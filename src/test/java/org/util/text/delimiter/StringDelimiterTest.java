package org.util.text.delimiter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;


/**
 * @author S. Popov
 **/
class StringDelimiterTest {

    public static void main(String[] args) throws IOException {
        String text = generateRandomString();
        Delimiter delimiter = new StringDelimiter();
//        List<String> strings = delimiter.split(text);
        List<String> strings = delimiter.split(text, 300, "Arial", 1);
        Path file = Paths.get("new-file.txt");
        Files.write(file, strings);
//        strings.forEach(System.out::println);
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