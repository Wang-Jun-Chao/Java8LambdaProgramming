package com.java.lamdba;

import com.java.lambda.Album;
import com.java.lambda.Artist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: 王俊超
 * Date: 2015-12-05 15:41
 * Declaration: All Rights Reserved !!!
 */
public class Niceties {
    abstract class ArtistService {
        protected Map<String, Artist> artistCache = new HashMap<>();

        public abstract Artist getArtist(String name);

        protected Artist readArtistFromDB(String name) {
            return new Artist(name, "UK");
        }
    }

    class OldArtistService extends ArtistService {

        @Override
        public Artist getArtist(String name) {
            Artist artist = artistCache.get(name);
            if (artist == null) {
                artist = readArtistFromDB(name);
                artistCache.put(name, artist);
            }
            return artist;
        }
    }

    class Java8ArtistService extends ArtistService {

        @Override
        public Artist getArtist(String name) {
            return artistCache.computeIfAbsent(name, this::readArtistFromDB);
        }
    }

    class ImperativeCount {
        // 计算艺术家对应的专辑数
        public Map<Artist, Integer> countAlbums(Map<Artist, List<Album>> albumsByArtist) {
            Map<Artist, Integer> countOfAlbums = new HashMap<>();
            for (Map.Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
                Artist artist = entry.getKey();
                List<Album> albums = entry.getValue();
                countOfAlbums.put(artist, albums.size());
            }
            return countOfAlbums;
        }
    }

    class Java8Count {
        public Map<Artist, Integer> countAlbums(Map<Artist, List<Album>> albumsByArtist) {
            Map<Artist, Integer> countOfAlbums = new HashMap<>();
            albumsByArtist.forEach((artist, albums) -> countOfAlbums.put(artist, albums.size()));

            return countOfAlbums;
        }
    }
}
