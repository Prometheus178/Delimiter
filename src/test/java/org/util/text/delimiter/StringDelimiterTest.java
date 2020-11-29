package org.util.text.delimiter;

import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.List;
import java.util.Random;


/**
 * @author S. Popov
 **/
class StringDelimiterTest {

    public static void main(String[] args) {
        String text = generateRandomString();
        Delimiter delimiter = new StringDelimiter();
//        List<String> strings = delimiter.split(text);
        List<String> strings = delimiter.split(text, 100, "Arial", 14);
        strings.forEach(System.out::println);
    }

    private static String generateRandomString() {
        Random random = new Random();
        int length = random.nextInt(15000);
        System.out.println(length);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length - 3; ++i) {
            builder.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return builder.toString();
    }
}