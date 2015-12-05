package com.java.lambda;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Author: 王俊超
 * Date: 2015-12-04 10:05
 * All Rights Reserved !!!
 */
public class Decisions {
    public static class Imperative {
        public Set<String> originsOfBands (Album album) {
            Set<String> nationalities = new HashSet<>();
            for (Artist artist: album.getMusicianList()) {
                if (artist.getName().startsWith("The")) {
                    String nationality = artist.getNationality();
                    nationalities.add(nationality);
                }
            }

            return nationalities;
        }
    }

    public Set<String> originsOfBands(Album album) {
        return album.getMusicians()
                .filter(artist -> artist.getName().startsWith("The"))
                .map(Artist::getNationality)
                .collect(Collectors.toSet());
    }

    public Set<String> originsOfBandsMisuse(Album album) {
        List<Artist> musicians = album.getMusicians().collect(Collectors.toList());
        List<Artist> bands = musicians.stream()
                .filter(artist -> artist.getName().startsWith("The"))
                .collect(Collectors.toList());
        return bands.stream()
                .map(Artist::getNationality)
                .collect(Collectors.toSet());

    }
}
