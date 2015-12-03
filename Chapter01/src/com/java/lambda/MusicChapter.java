package com.java.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * All Rights Reserved !!!
 * Author: 王俊超
 * Date: 2015-12-03 09:28
 */
public class MusicChapter {
    protected final List<Artist> artists;
    protected final List<Album> albums;

    public MusicChapter() {
        artists = new ArrayList<>();
        albums = new ArrayList<>();
        loadData("");
    }

    private void loadData(String file) {

    }
}
