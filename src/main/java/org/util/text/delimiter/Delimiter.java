package org.util.text.delimiter;

import java.awt.*;
import java.util.List;

/**
 * @author Sergey Popov
 */
public interface Delimiter {

    List<String> split(String text);

    List<String> split(String text, int length);

    List<String> split(String text, int length, String font , int fontSize, FontStyle fontStyle);

}
