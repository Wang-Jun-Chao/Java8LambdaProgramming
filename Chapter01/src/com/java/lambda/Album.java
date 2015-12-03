package com.java.lambda;

import java.sql.Connection;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 唱片类
 * All Rights Reserved !!!
 * Author: 王俊超
 * Date: 2015-12-03 08:26
 */
public class Album {
    // 唱片的名字
    private String name;
    // 唱片的曲目
    private List<Track> tracks;
    // 唱片的作曲者
    private List<Artist> musicians;

    public Album(String name, List<Track> tracks, List<Artist> musicians) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(tracks);
        Objects.requireNonNull(musicians);

        this.name = name;
        this.tracks = new ArrayList<>(tracks);
        this.musicians = new ArrayList<>(musicians);
    }


    public String getName() {
        return name;
    }

    public Stream<Track> getTracks() {
        return tracks.stream();
    }

    public List<Track> getTrackList() {
        return Collections.unmodifiableList(tracks);
    }

    public Stream<Artist> getMusicians() {
        return musicians.stream();
    }

    public List<Artist> getMusicianList() {
        return Collections.unmodifiableList(musicians);
    }

    public Artist getMainMusician() {
        return musicians.get(0);
    }

    public Album copy() {
        List<Track> tracks = getTracks().map(Track::copy).collect(Collectors.toList());
        List<Artist> musicians = getMusicians().map(Artist::copy).collect(Collectors.toList());
        return new Album(name, tracks, musicians);
    }

    public Stream<Artist> getAllMusicians() {
        Set<Artist> result = new HashSet<>();
        musicians.forEach(artist -> {
           artist.getMembers().forEach(result::add);
        });
        return result.stream();
    }
}
