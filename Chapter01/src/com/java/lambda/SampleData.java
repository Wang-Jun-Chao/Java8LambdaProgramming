package com.java.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * All Rights Reserved !!!
 * Author: 王俊超
 * Date: 2015-12-03 09:26
 */
public class SampleData {
    public static final Artist johnColtrane = new Artist("John Coltrane", "US");
    public static final Artist johnLennon = new Artist("John Lennon", "UK");
    public static final Artist paulMcCartney = new Artist("Paul McCartney", "UK");
    public static final Artist georgeHarrison = new Artist("George Harrison", "UK");
    public static final Artist ringoStarr = new Artist("Ringo Starr", "UK");

    public static final List<Artist> membersOfTheBeatles = Arrays.asList(
            johnLennon, paulMcCartney, georgeHarrison, ringoStarr);

    public static final Artist theBeatles = new Artist(
            "The Beatles",
            membersOfTheBeatles,
            "UK");

    public static final Album aLoveSupreme = new Album(
            "A Love Supreme",
            Arrays.asList(new Track("Acknowledgement", 467), new Track("Resolution", 442)),
            Collections.singletonList(johnColtrane));

    public static final Album sampleShortAlbum = new Album(
            "sample Short Album",
            Collections.singletonList(new Track("short track", 30)),
            Collections.singletonList(johnColtrane));

    public static final Album manyTrackAlbum = new Album(
            "sample Short Album",
            Arrays.asList(
                    new Track("short track", 30),
                    new Track("short track 2", 30),
                    new Track("short track 3", 30),
                    new Track("short track 4", 30),
                    new Track("short track 5", 30)),
            Collections.singletonList(johnColtrane));

    public static Stream<Album> albums = Stream.of(aLoveSupreme);

    public static Stream<Artist> threeArtists() {
        return Stream.of(johnColtrane, johnLennon, theBeatles);
    }

    public static List<Artist> getThreeArtists() {
        return Arrays.asList(johnColtrane, johnLennon, theBeatles);
    }
}
