import com.java.lambda.ArrayExamples;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Author: 王俊超
 * Date: 2015/12/7 13:42
 * All Rights Reserved !!!
 */
@RunWith(Parameterized.class)
public class ArrayExamplesTest {
    private final int size;
    private final double[] output;

    public ArrayExamplesTest(int size, double[] output) {
        this.size = size;
        this.output = output;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
                {0, new double[]{}},
                {2, new double[]{0, 1}},
                {4, new double[]{0, 1, 2, 3}}
        };

        return Arrays.asList(data);
    }
    @Test
    public void parallel() {
        Assert.assertArrayEquals(output, ArrayExamples.parallelInitialize(size), 0.0);
    }


    @Test
    public void imperative() {
        Assert.assertArrayEquals(output, ArrayExamples.imperativeInitialize(size), 0.0);
    }
}
