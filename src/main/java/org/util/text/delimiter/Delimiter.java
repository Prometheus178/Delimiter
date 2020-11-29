package org.util.text.delimiter;

import java.util.List;

/**
 * @author Sergey Popov
 */
public interface Delimiter {

    List<String> split(String text);

    List<String> split(String text, int width);


    List<String> split(String text, int width, String fontName, int fontSize);

    List<String> split(String text, int width, String fontName , int fontSize, FontStyle fontStyle);

}
