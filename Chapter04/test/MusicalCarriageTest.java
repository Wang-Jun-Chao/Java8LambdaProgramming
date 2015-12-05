import com.java.lambda.MusicalCarriage;
import org.junit.Assert;
import org.junit.Test;

/**
 * Author: 王俊超
 * Date: 2015-12-05 10:51
 * Declaration: All Rights Reserved !!!
 */
public class MusicalCarriageTest {
    @Test
    public void rocksLikeACarriage() {
        Assert.assertEquals("... from side to side", new MusicalCarriage().rock());
    }
}
