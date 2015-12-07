package com.java.lambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Author: 王俊超
 * Date: 2015-12-07 11:55
 * Declaration: All Rights Reserved !!!
 */
public class WordCounting {
    private static final Pattern username = Pattern.compile("\\s+<username>(.*?)</username>");
    private static final Pattern space = Pattern.compile("\\s+");

    public void countUsers(InputStream stream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            Map<String, Long> counts = reader.lines().parallel()
                    .filter(line -> line.contains("<username>"))
                    .map(line -> {
                        Matcher matcher = username.matcher(line);
                        matcher.find();
                        return matcher.group(1);
                    })
                    .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
            counts.forEach((word, count) ->System.out.print(word + " -> " + count));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void countWords(InputStream stream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            Map<String, Long> counts = reader.lines()
                    .flatMap(space::splitAsStream)
                    .map(String::trim)
                    .filter(word->!word.isEmpty())
                    .collect(Collectors.groupingBy(word->word, Collectors.counting()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
//        InputStream enWiki = WordCounting.class.getResourceAsStream("enwiki-20131230-stubs-meta-hist-incr.xml");
//        new WordCounting().countUsers(enWiki);
         InputStream huckleberryFinn = WordCounting.class.getResourceAsStream("huckleberry_finn");
         new WordCounting().countWords(huckleberryFinn);
    }
}
