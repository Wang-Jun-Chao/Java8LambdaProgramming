package com.java.lambda;

import java.util.List;
import java.util.stream.Collectors;

/**
 * All Rights Reserved !!!
 * Author: 王俊超
 * Date: 2015-12-03 09:29
 */
public class Chapter01 extends MusicChapter {
    public List<String> getNamesOfArtists_Lambda() {
        return artists.stream()
                .map(Artist::getName)
                .collect(Collectors.toList());
    }

    public List<String> getNamesOfArtists_MethodReference() {
        return artists.stream()
                .map(Artist::getName)
                .collect(Collectors.toList());
    }

    public List<Artist> artistsLivingInLondon() {
        return artists.stream()
                .filter(artist -> "London".equals(artist.getNationality()))
                .collect(Collectors.toList());
    }
}
