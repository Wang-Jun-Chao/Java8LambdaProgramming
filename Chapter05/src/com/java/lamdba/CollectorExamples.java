package com.java.lamdba;

import com.java.lambda.Album;
import com.java.lambda.Artist;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author: 王俊超
 * Date: 2015-12-05 14:45
 * Declaration: All Rights Reserved !!!
 */
public class CollectorExamples {

    private static final Pattern SPACES = Pattern.compile("\\w+");

    // 将流中的数据转换成有序集合中的数据
    public void toCollectionTreeSet() {
        Stream<Integer> stream = Stream.of(1, 2, 3);
        stream.collect(Collectors.toCollection(TreeSet::new));
    }

    public Optional<Artist> biggestGroup(Stream<Artist> artists) {
        // 求一个乐队的队员数人函数对象
        Function<Artist, Long> getCount = artist -> artist.getMembers().count();
        // 求乐队队员最多的乐队
        return artists.collect(Collectors.maxBy(Comparator.comparing(getCount)));
    }

    public Map<Boolean, List<Artist>> bandsAndSolo(Stream<Artist> artists) {
        // 找出乐队中的所有乐队成员
        return artists.collect(Collectors.partitioningBy(artist -> artist.isSolo()));
    }
    public Map<Boolean, List<Artist>> bandsAndSoloRef(Stream<Artist> artists) {
        // 找出乐队中的所有乐队成员，使用方法引用的方式
        return artists.collect(Collectors.partitioningBy(Artist::isSolo));
    }

    public Map<Artist, List<Album>> albumsByArtist(Stream<Album> albums) {
        // 使用主唱对专辑分组
        return albums.collect(Collectors.groupingBy(Album::getMainMusician));
    }
    public Map<Artist, Integer> numberOfAlbumsDumb(Stream<Album> albums) {
        // 主唱对应的专辑
        Map<Artist, List<Album>> albumsByArtist = albums.collect(Collectors.groupingBy(Album::getMainMusician));
        // 主唱对应的专辑数
        Map<Artist, Integer> numberOfAlbums = new HashMap<>();
        for(Map.Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
            numberOfAlbums.put(entry.getKey(), entry.getValue().size());
        }

        return numberOfAlbums;
    }
    public Map<Artist, Long> numberOfAlbums(Stream<Album> albums) {
        // 首先求主唱对应的专辑，Album::getMainMusician
        // 然后求主唱对象的专辑数，Collectors.counting()
        return albums.collect(Collectors.groupingBy(Album::getMainMusician, Collectors.counting()));
    }

    // 求每个艺术家的专辑名
    public Map<Artist, List<String>> nameOfAlbumsDumb(Stream<Album> albums) {
        // 主唱对应的专辑
        Map<Artist, List<Album>> albumsByArtist = albums.collect(Collectors.groupingBy(Album::getMainMusician));
        // 主唱对应的专辑名字
        Map<Artist, List<String>>  nameOfAlbums = new HashMap<>();
        for(Map.Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
            nameOfAlbums.put(entry.getKey(),
                    entry.getValue().stream()  // 求出专辑的流，再将流转换成名字流，再获取名字的集合对象
                    .map(Album::getName).collect(Collectors.toList()));
        }

        return nameOfAlbums;
    }

    // 求每个艺术家的专辑名
    public Map<Artist, List<String>> nameOfAlbums(Stream<Album> albums) {
        return albums.collect(Collectors.groupingBy(Album::getMainMusician,
                Collectors.mapping(Album::getName, Collectors.toList())));
    }

    // 计算流中的字符数
    public static Map<String, Long> countWords(Stream<String> words) {
        return words.collect(Collectors.groupingBy(word->word, Collectors.counting()));
    }
    // 计算流中的字符数
    public static Map<String, Long> countWordsIn(Path path) throws IOException {
        Stream<String> words = Files.readAllLines(path, Charset.defaultCharset()).stream()
                .flatMap(SPACES::splitAsStream);

        return countWords(words);
    }

    // 计算专辑中的平均曲目数
    public double averageNumberOfTracks(List<Album> albums) {
        return albums.stream().collect(Collectors.averagingInt(album->album.getTrackList().size()));
    }

}
