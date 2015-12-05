import com.java.lambda.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;
import java.util.function.Function;

/**
 * Author: 王俊超
 * Date: 2015-12-05 11:04
 * Declaration: All Rights Reserved !!!
 */
@RunWith(Parameterized.class)
public class TestOrder {

    private interface OrderFactory extends Function<List<Album>, Order> {
    }

    private final OrderFactory factory;
    private Order order;

    public TestOrder(OrderFactory factory) {
        this.factory = factory;
    }

    private static Object[] of(OrderFactory factory) {
        return new Object[]{factory};
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                of(OrderImperative::new),
                of(OrderStream::new),
                of(OrderDomain::new)};
        return Arrays.asList(data);
    }

    @Before
    public void initOrder() {
        List<Track> tracks = Arrays.asList(new Track("Acknowledgement", 467), new Track("Resolution", 442));
        Album aLoveSupreme = new Album("A Love Supreme", tracks, Arrays.asList(SampleData.johnColtrane));
        order = factory.apply(Collections.singletonList(aLoveSupreme));
    }

    @Test
    public void countsRunningTime() {
        Assert.assertEquals(909, order.countRunningTime());
    }

    @Test
    public void countsArtists() {
        Assert.assertEquals(1, order.countMusicians());
    }

    @Test
    public void countsTracks() {
        Assert.assertEquals(2, order.countTracks());
    }
}
