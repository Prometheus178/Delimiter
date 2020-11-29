package org.util.text.delimiter;

/**
 * @author S. Popov
 **/
public enum FontStyle {

    PLANE(0),
    ITALIC(1),
    BOLD(2);

    private final int fontCode;

    private FontStyle(int fontCode) {
        this.fontCode = fontCode;
    }

    public int getFontCode() {
        return fontCode;
    }
}
