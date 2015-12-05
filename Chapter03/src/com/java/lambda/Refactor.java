package com.java.lambda;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Author: 王俊超
 * Date: 2015-12-04 10:14
 * All Rights Reserved !!!
 */
public class Refactor {
    public static interface LongTrackFinder {
        public Set<String> findLongTracks(List<Album> albums);
    }

    public static class Step0 implements LongTrackFinder {

        @Override
        public Set<String> findLongTracks(List<Album> albums) {
            Set<String> trackNames = new HashSet<>();
            for (Album album : albums) {
                for (Track track : album.getTrackList()) {
                    if (track.getLength() > 60) {
                        trackNames.add(track.getName());
                    }
                }
            }
            return trackNames;
        }
    }

    public static class Step1 implements LongTrackFinder {
        public Set<String> findLongTracks(List<Album> albums) {
            Set<String> trackNames = new HashSet<>();
            albums.stream().forEach(album -> {
                album.getTracks().forEach(track -> {
                    if (track.getLength() > 60) {
                        trackNames.add(track.getName());
                    }
                });
            });
            return trackNames;
        }
    }

    public static class Step2 implements LongTrackFinder {
        public Set<String> findLongTracks(List<Album> albums) {
            Set<String> trackNames = new HashSet<>();
            albums.stream().forEach(album -> {
                album.getTracks()
                        .filter(track -> track.getLength() > 60)
                        .map(Track::getName)
                        .forEach(trackNames::add);
            });

            return trackNames;
        }
    }

    public static class Step3 implements LongTrackFinder {
        public Set<String> findLongTracks(List<Album> albums) {
            Set<String> trackNames = new HashSet<>();
            albums.stream()
                    .flatMap(Album::getTracks)
                    .filter(track -> track.getLength() > 60)
                    .map(Track::getName)
                    .forEach(trackNames::add);

            return trackNames;
        }
    }

    public static class Step4 implements LongTrackFinder {
        public Set<String> findLongTracks(List<Album> albums) {
            return albums.stream()
                    .flatMap(Album::getTracks)
                    .filter(track -> track.getLength() > 60)
                    .map(Track::getName)
                    .collect(Collectors.toSet());
        }
    }


}
