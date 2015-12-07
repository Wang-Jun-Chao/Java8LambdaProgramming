import com.java.lambda.Album;
import com.java.lambda.OrderDomain;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * Author: 王俊超
 * Date: 2015/12/7 14:20
 * All Rights Reserved !!!
 */
public class OrderDomainExampleTest {
    private Album newAlbum(String name) {
        return new Album(name, Collections.emptyList(), Collections.emptyList());
    }

    @Test
    public void canCountFeatures() {
        OrderDomain order = new OrderDomain(Arrays.asList(
                newAlbum("Exile on Main St."),
                newAlbum("Beggars Banquet"),
                newAlbum("Aftermath"),
                newAlbum("Let it Bleed")));

        Assert.assertEquals(8, order.countFeature(album -> 2));
    }

}
