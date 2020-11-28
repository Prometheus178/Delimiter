package org.util.text.delimiter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Popov
 **/
public class StringDelimiter implements Delimiter {

    private static final int DEFAULT_LENGTH = 100;
    private String text;
    private int width;
    private int countSegments;
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
        validateText();
        return delimiter();
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
        if (text.length() < DEFAULT_LENGTH) {
            segments.add(text);
            return segments;
        }
        width = DEFAULT_LENGTH;
        return getSegments();
    }

    private List<String> getSegments() {
        int begin = 0;
        int end;
        for (countSegments = getCountSegments(); countSegments >= 0; countSegments--) {
            if (countSegments == 0) {
                end = begin + lastSegment;
            } else {
                end = (begin == 0) ? width : begin + width;
            }
            segments.add(text.substring(begin, end));
            begin = end;
        }
        return segments;
    }

    private int getCountSegments() {
        countSegments = (text.length() / width);
        lastSegment = text.length() % width;
        return countSegments;
    }

    @Override
    public List<String> split(String text, int width) {
        return null;
    }

    @Override
    public List<String> split(String text, int width, String font, int fontSize, FontStyle fontStyle) {
        return null;
    }


}
