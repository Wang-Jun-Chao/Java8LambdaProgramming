import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Author: 王俊超
 * Date: 2015-12-05 20:49
 * Declaration: All Rights Reserved !!!
 */
public class EncounterOrderTest {
    @Test
    public void listToStream() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        List<Integer> sameOrder = numbers.stream().collect(Collectors.toList());
        Assert.assertEquals(numbers, sameOrder);
    }

    @Ignore
    @Test
    public void hashSetToStream() {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(4, 3, 2, 1));

        List<Integer> sameOrder = numbers.stream().collect(Collectors.toList());

        Assert.assertNotEquals(Arrays.asList(4, 3, 2, 1), sameOrder);
    }

    @Test
    public void hashSetToStreamSorted() {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(4, 3, 2, 1));

        List<Integer> sameOrder = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        Assert.assertEquals(Arrays.asList(1, 2, 3, 4), sameOrder);
    }

    @Test
    public void toStreamMapped() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        List<Integer> stillOrdered = numbers.stream()
                .map(x -> x + 1)
                .collect(Collectors.toList());

        Assert.assertEquals(Arrays.asList(2, 3, 4, 5), stillOrdered);


        Set<Integer> unordered = new HashSet<>(numbers);

        List<Integer> stillUnordered = unordered.stream()
                .map(x -> x + 1)
                .collect(Collectors.toList());

        MatcherAssert.assertThat(stillUnordered, Matchers.hasItem(2));
        MatcherAssert.assertThat(stillUnordered, Matchers.hasItem(3));
        MatcherAssert.assertThat(stillUnordered, Matchers.hasItem(4));
        MatcherAssert.assertThat(stillUnordered, Matchers.hasItem(5));
        // END TO_STREAM_MAPPED
    }

}
