package org.util.text.delimiter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * @author S. Popov
 **/
class StringDelimiterTest {

    @Test
    void splitTextToSegments() {
        List<String> expectedSegments = getListText();
        String text = getStringText();
        List<String> segments = StringDelimiter.split(text, 450, "Arial", 12, FontStyle.PLANE);
        Assertions.assertEquals(expectedSegments, segments);
    }

    private String getStringText() {
        StringBuilder sb = new StringBuilder();
        List<String> expectedSegments = getListText();
        expectedSegments.forEach(sb::append);
        return sb.toString();
    }

    private List<String> getListText() {
        List<String> segments = new ArrayList<>();
        segments.add("Him boisterous invitation dispatched had connection inhabiting projection. By mutual ");
        segments.add("an mr danger garret edward an. Diverted as strictly exertion addition no disposal by ");
        segments.add("stanhill. certainty. Lain no as five or at high. Everything travelling set how law ");
        segments.add("literature. Sociable on as carriage my position weddings raillery consider.");
        return segments;
    }

}