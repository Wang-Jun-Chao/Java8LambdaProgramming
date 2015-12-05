import com.java.lambda.Track;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author: 王俊超
 * Date: 2015-12-04 10:44
 * All Rights Reserved !!!
 */
public class HigherOrderFunctionExamplesTest {
    @Test
    public void collectToList() {
        List<String> collected = Stream.of("a", "b", "c").collect(Collectors.toList());
        Assert.assertEquals(Arrays.asList("a", "b", "c"), collected);
    }

    @Test
    public void mapToUpperCase() {
        List<String> collected = Stream.of("a", "b", "hello")
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        Assert.assertEquals(Arrays.asList("A", "B", "HELLO"), collected);
    }

    @Test
    public void imperativeMaxLength() {
        List<Track> tracks = Arrays.asList(new Track("Bakai", 524),
                new Track("Violets for Your Furs", 378),
                new Track("Time Was", 451));

        Track shortestTrack = tracks.get(0);
        for (Track track : tracks) {
            if (track.getLength() < shortestTrack.getLength()) {
                shortestTrack = track;
            }
        }

        Assert.assertEquals(tracks.get(1), shortestTrack);
    }

    @Test
    public void streamsAnyMatch() {
        List<Track> tracksOnColtrane = Arrays.asList(new Track("Bakai", 524),
                new Track("Violets for Your Furs", 378),
                new Track("Time Was", 451));

        boolean matchLength = false;
        for (Track track : tracksOnColtrane) {
            if (track.getLength() > 500) {
                matchLength = true;
            }
        }

        Assert.assertTrue(matchLength);
    }

    @Test
    public void sumUsingReduce() {
        int count = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);
        Assert.assertEquals(6, count);
    }

    @Test
    public void expandedReduce() {
        BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
        int count = accumulator.apply(
                accumulator.apply(
                        accumulator.apply(0, 1),
                        2),
                3);

        Assert.assertEquals(6, count);
    }


    @Test
    public void countUsingReduceFor() {
        int acc = 0;
        for (Integer element : Arrays.asList(1, 2, 3)) {
            acc = acc + element;
        }
        Assert.assertEquals(6, acc);
    }

    @Test
    public void functionalStringsWithNumbers() {
        List<String> beginningWithNumbers = Stream.of("a", "1abc", "abc1")
                .filter(value->Character.isDigit(value.charAt(0)))
                .collect(Collectors.toList());
        Assert.assertEquals(Collections.singletonList("1abc"), beginningWithNumbers);
    }

    @Test
    public void imperativeStringsWithNumbers() {
        // BEGIN strings_numbers_for
        List<String> beginningWithNumbers = new ArrayList<>();
        for (String value : Arrays.asList("a", "1abc", "abc1")) {
            if (Character.isDigit(value.charAt(0))) {
                beginningWithNumbers.add(value);
            }
        }

        Assert.assertEquals(Collections.singletonList("1abc"), beginningWithNumbers);
    }

    @Test
    public void flatMapCharacters() {
        List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4), together);
    }

























}





























