package org.util.text.delimiter;

import java.util.List;

/**
 *
 *  The interface gives to split string by parameters
 *
 * @author Sergey Popov
 */
public interface Delimiter {

    /**
     * split string by default width = 100
     *
     * @param text
     * @return list of separated strings
     */
    List<String> split(String text);

    /**
     * split string by width
     *
     * @param text
     * @param width
     * @return list of separated strings
     */
    List<String> split(String text, int width);

    /**
     * split string by default FontStyle = Plane
     *
     * @param text
     * @param width
     * @param fontName
     * @param fontSize
     * @return list of separated strings
     */
    List<String> split(String text, int width, String fontName, int fontSize);

    /**
     * @param text
     * @param width
     * @param fontName
     * @param fontSize
     * @param fontStyle
     * @return list of separated strings
     */
    List<String> split(String text, int width, String fontName , int fontSize, FontStyle fontStyle);

}
