import com.java.lambda.SampleData;
import com.java.lambda.StreamExercises;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Author: 王俊超
 * Date: 2015/12/3 17:54
 * All Rights Reserved !!!
 */
public class StreamExercisesTest {
    @Test
    public void external() {
        Assert.assertEquals(4, StreamExercises.countBandMembersExternal(
                Arrays.asList(SampleData.johnColtrane, SampleData.theBeatles)));
    }

    @Test
    public void mapExample() {
        Stream<Integer> stream = Stream.of(1, 2, 3);
        List<Integer> values = StreamExercises.map(stream, x -> x + 1);
        Assert.assertEquals(Arrays.asList(2, 3, 4), values);
    }

    @Test
    public void mapExampleParallel() {
        Stream<Integer> parallelStream = Stream.of(1, 2, 3).parallel();
        List<Integer> values = StreamExercises.map(parallelStream, x -> x + 1);
        Assert.assertEquals(Arrays.asList(2, 3, 4), values);
    }
}
