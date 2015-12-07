import com.java.lambda.Artist;
import com.java.lambda.RxExamples;
import com.java.lambda.SampleData;
import org.junit.Assert;
import org.junit.Test;

/**
 * Author: 王俊超
 * Date: 2015-12-07 22:34
 * Declaration: All Rights Reserved !!!
 */
public class RxExamplesTest {
    @Test
    public void filtersAlbums() throws InterruptedException {
        RxExamples examples = new RxExamples(SampleData.getThreeArtists());
        Artist artist = examples.search("John", "UK", 5)
                .toBlockingObservable()
                .single();

        Assert.assertEquals(SampleData.johnLennon, artist);
    }
}
