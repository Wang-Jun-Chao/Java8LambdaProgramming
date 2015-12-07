package com.java.lambda;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Author: 王俊超
 * Date: 2015/12/7 13:59
 * All Rights Reserved !!!
 */
public class Testing {
    private static final Logger logger = Logger.getLogger("Testing");

    // 将单词全部转成大写
    public static List<String> allToUpperCase(List<String> words) {
        return words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.<String>toList());
    }

    // 将单词的第一个字符转成大写
    public static List<String> elementFirstToUpperCaseLambdas(List<String> words) {
        return words.stream()
                .map(value -> {
                    char firstChar = Character.toUpperCase(value.charAt(0));
                    return firstChar + value.substring(1);
                })
                .collect(Collectors.<String>toList());
    }

    // 将单词的第一个字符转成大写
    public static String firstToUppercase(String value) {
        char firstChar = Character.toUpperCase(value.charAt(0));
        return firstChar + value.substring(1);
    }

    // 将单词的第一个字符转成大写
    public static List<String> elementFirstToUppercase(List<String> words) {
        return words.stream()
                .map(Testing::firstToUppercase)
                .collect(Collectors.<String>toList());
    }

    public static Set<String> imperativeNationalityReport(Album album) {
        Set<String> nationalities = new HashSet<>();
        for (Artist artist : album.getMusicianList()) {
            if (artist.getName().startsWith("The")) {
                String nationality = artist.getNationality();
                System.out.println("Found nationality: " + nationality);
                nationalities.add(nationality);
            }
        }

        return nationalities;
    }

    public static Set<String> forEachLoggingFailure(Album album) {

        album.getMusicians()
                .filter(artist -> artist.getName().startsWith("The"))
                .map(Artist::getNationality)
                .forEach(nationality -> System.out.println("Found: " + nationality));

        return album.getMusicians()
                .filter(artist -> artist.getName().startsWith("The"))
                .map(Artist::getNationality)
                .collect(Collectors.<String>toSet());
    }

    public static Set<String> nationalityReportUsingPeek(Album album) {
        return album.getMusicians()
                .filter(artist -> artist.getName().startsWith("The"))
                .map(Artist::getNationality)
                .peek(nation -> System.out.println("Found nationality: " + nation))
                .collect(Collectors.<String>toSet());
    }
}
