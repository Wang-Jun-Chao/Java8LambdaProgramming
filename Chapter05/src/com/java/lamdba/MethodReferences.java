package com.java.lamdba;

import com.java.lambda.Album;
import com.java.lambda.Artist;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author: 王俊超
 * Date: 2015-12-05 15:37
 * Declaration: All Rights Reserved !!!
 */
public class MethodReferences {
    private static final Pattern SPACES = Pattern.compile("\\w+");

    // 主唱对应的专辑
    public Map<Artist, List<Album>> albumsByArtist(Stream<Album> albums) {
        return albums.collect(Collectors.groupingBy(Album::getMainMusician));
    }

    // 计算流中的字符数
    public static Map<String, Long> countWords(Stream<String> words) {
        return words.collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    }

    public static Map<String, Long> countWordsIn(Path path) throws IOException {
        Stream<String> words = Files.readAllLines(path, Charset.defaultCharset()).stream()
                .flatMap(SPACES::splitAsStream);

        return countWords(words);
    }
}
