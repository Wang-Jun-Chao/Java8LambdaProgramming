import com.java.lambda.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

/**
 * Author: 王俊超
 * Date: 2015-12-07 22:23
 * Declaration: All Rights Reserved !!!
 */
public class AlbumLookupTest {
    interface AlbumLookupFactory extends BiFunction<List<Track>, List<Artist>, AlbumLookup> {
    }

    @Test
    public void albumLookedUp() {
        Album album = SampleData.aLoveSupreme;
        List<Track> trackList = album.getTrackList();
        List<Artist> musicianList = album.getMusicianList();

        AlbumLookupFactory completable = CompletableAlbumLookup::new;
        AlbumLookupFactory future = FutureAlbumLookup::new;

        Stream.of(completable, future)
                .forEach(factory -> {
                    AlbumLookup lookup = factory.apply(trackList, musicianList);
                    System.out.println("Testing: " + lookup.getClass().getSimpleName());
                    Album result = lookup.lookupByName(album.getName());

                    Assert.assertEquals(trackList, result.getTrackList());
                    Assert.assertEquals(musicianList, result.getMusicianList());
                });
    }
}
