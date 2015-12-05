import com.java.lambda.Album;
import com.java.lambda.Refactor;
import com.java.lambda.SampleData;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Author: 王俊超
 * Date: 2015-12-04 10:33
 * All Rights Reserved !!!
 */
public class RefactorTest {
    @Test
    public void allStringJoins() {
        List<Supplier<Refactor.LongTrackFinder>> finders = Arrays.asList(
                Refactor.Step0::new,
                Refactor.Step1::new,
                Refactor.Step2::new,
                Refactor.Step3::new
        );

        List<Album> albums = Collections.unmodifiableList(Arrays.asList(
                SampleData.aLoveSupreme, SampleData.sampleShortAlbum));
        List<Album> noTracks = Collections.unmodifiableList(Collections.singletonList(
                SampleData.sampleShortAlbum));

        finders.forEach(finder -> {
            System.out.println("Testing: " + finder.toString());

            Refactor.LongTrackFinder longTrackFinder = finder.get();
            Set<String> longTracks = longTrackFinder.findLongTracks(albums);

            Assert.assertEquals("[Acknowledgement, Resolution]", longTracks.toString());

            longTracks = longTrackFinder.findLongTracks(noTracks);
            Assert.assertTrue(longTracks.isEmpty());
        });
    }
}
