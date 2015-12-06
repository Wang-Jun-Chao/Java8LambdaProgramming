import com.java.lambda.Artist;
import com.java.lambda.SampleData;
import com.java.lamdba.StringExamples;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Function;

/**
 * Author: 王俊超
 * Date: 2015-12-05 21:17
 * Declaration: All Rights Reserved !!!
 */
public class StringExamplesTest {
    @Test
    public void beatlesExample() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        joiner.add("John");
        joiner.add("Paul");
        joiner.add("Ringo");
        Assert.assertEquals("[John, Paul, Ringo]", joiner.toString());
    }

    @Test
    public void allStringJoins() {
        List<Function<List<Artist>, String>> formatters = Arrays.<Function<List<Artist>, String>>asList(
                StringExamples::formatArtists,
                StringExamples::formatArtistsForLoop,
                StringExamples::formatArtistsRefactor1,
                StringExamples::formatArtistsRefactor2,
                StringExamples::formatArtistsRefactor3,
                StringExamples::formatArtistsRefactor4,
                StringExamples::formatArtistsRefactor5
        );

        formatters.forEach(formatter -> {
            System.out.println("Testing: " + formatter.toString());
            String result = formatter.apply(SampleData.getThreeArtists());
            Assert.assertEquals("[John Coltrane, John Lennon, The Beatles]", result);

            result = formatter.apply(Collections.emptyList());
            Assert.assertEquals("[]", result);
        });
    }
}
