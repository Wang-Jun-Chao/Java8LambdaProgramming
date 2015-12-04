import com.java.lambda.Iteration;
import com.java.lambda.SampleData;
import org.junit.Test;

/**
 * Author: 王俊超
 * Date: 2015/12/3 17:03
 * All Rights Reserved !!!
 */
public class IterationTest {
    @Test
    public void lazyPrintOuts() {
        Iteration iteration = new Iteration();
        iteration.filterArtistsFromLondonPrinted(SampleData.membersOfTheBeatles);
    }

    @Test
    public void evaluatedPrintOuts() {
        Iteration iteration = new Iteration();
        iteration.internalCountArtistsFromLondonPrinted(SampleData.membersOfTheBeatles);
    }
}
