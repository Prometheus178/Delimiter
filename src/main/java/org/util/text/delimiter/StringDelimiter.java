package org.util.text.delimiter;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Popov
 **/
public class StringDelimiter implements Delimiter {

    private static final int DEFAULT_LENGTH = 100;
    private String text;
    private int width;
    private String fontName;
    private int fontSize;
    private int fontStyle;
    private int position;
    private int lastSegment;
    List<String> segments;

    /**
     * @param text
     * @return
     * @throws NullPointerException
     * @throws IllegalArgumentException
     */
    @Override
    public List<String> split(String text) {
        this.text = text;
        this.width = DEFAULT_LENGTH;
        validateText();
        return delimiter();
    }

    @Override
    public List<String> split(String text, int width) {
        this.text = text;
        this.width = width;
        validateText();
        return delimiter();
    }

    @Override
    public List<String> split(String text, int width, String fontName, int fontSize) {
        this.text = text;
        this.width = width;
        this.fontName = fontName.toLowerCase();
        this.fontSize = fontSize;
        this.fontStyle = FontStyle.PLANE.getFontCode();
        validateText();
        return delimiterByFontSize();
    }

    @Override
    public List<String> split(String text, int width, String fontName, int fontSize, FontStyle fontStyle) {
        this.text = text;
        this.width = width;
        this.fontName = fontName.toLowerCase();
        this.fontSize = fontSize;
        this.fontStyle = fontStyle.getFontCode();
        validateText();
        return delimiterByFontSize();
    }

    private void validateText() {
        if (text == null)
            throw new NullPointerException();
        if (text.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private List<String> delimiter() {
        segments = new ArrayList<>();
        if (text.length() < width) {
            segments.add(text);
            return segments;
        }
        return getSegments();
    }

    private List<String> delimiterByFontSize() {
        segments = new ArrayList<>();
        return getSegmentsByFont();
    }

    private List<String> getSegments() {
        int begin = 0;
        int end;
        for (position = getCountPosition(); position >= 0; position--) {
            if (position == 0) {
                end = begin + lastSegment;
            } else {
                end = (begin == 0) ? width : begin + width;
            }
            segments.add(text.substring(begin, end));
            begin = end;
        }
        return segments;
    }

    private List<String> getSegmentsByFont() {
        Font font = new Font(fontName, fontStyle, fontSize);
        AffineTransform affinetransform = new AffineTransform();
        FontRenderContext renderContext = new FontRenderContext(affinetransform, true, true);
        AttributedString attributedString = new AttributedString(text);
        attributedString.addAttribute(TextAttribute.FONT, font);
        AttributedCharacterIterator styledText = attributedString.getIterator();
        LineBreakMeasurer measurer = new LineBreakMeasurer(styledText, renderContext);

//        int begin = measurer.getPosition();
//        int end = measurer.getPosition();
//        int addCharacter = 0;

        while (measurer.getPosition() < styledText.getEndIndex()) {
            TextLayout layout = measurer.nextLayout(width);
            String line = text.substring(measurer.getPosition() - layout.getCharacterCount(), measurer.getPosition());
            segments.add(line);
        }
        return segments;
    }

    private int getCountPosition() {
        position = (text.length() / width);
        lastSegment = text.length() % width;
        return position;
    }

}
