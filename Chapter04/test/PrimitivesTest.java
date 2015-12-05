import com.java.lambda.Primitives;
import com.java.lambda.SampleData;
import org.junit.Test;

/**
 * Author: 王俊超
 * Date: 2015-12-05 10:56
 * Declaration: All Rights Reserved !!!
 */
public class PrimitivesTest {
    @Test
    public void albumStatistics() {
        Primitives.printTrackLengthStatistics(SampleData.aLoveSupreme);
    }
}
