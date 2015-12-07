import com.java.lambda.SingleResponsibilityPrinciple;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Author: 王俊超
 * Date: 2015/12/7 15:44
 * All Rights Reserved !!!
 */
@RunWith(Parameterized.class)
public class SingleResponsibilityPrincipleTest {

    private final SingleResponsibilityPrinciple.PrimeCounter primeCounter;

    public SingleResponsibilityPrincipleTest(SingleResponsibilityPrinciple.PrimeCounter primeCounter) {
        this.primeCounter = primeCounter;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
                {new SingleResponsibilityPrinciple.ImperativeRefactoredPrimeCounter()},
                {new SingleResponsibilityPrinciple.ImperativeSingleMethodPrimeCounter()},
                {new SingleResponsibilityPrinciple.FunctionalPrimeCounter()},
                {new SingleResponsibilityPrinciple.ParallelFunctionalPrimeCounter()}};
        return Arrays.asList(data);
    }

    @Test
    public void countsPrimesTo10() {
        Assert.assertEquals(5, primeCounter.countPrimes(10));
        Assert.assertEquals(9, primeCounter.countPrimes(20));
    }

    @Test
    public void countsPrimesTo20() {
        Assert.assertEquals(9, primeCounter.countPrimes(20));
    }

    @Test
    public void countsPrimesTo30() {
        Assert.assertEquals(11, primeCounter.countPrimes(30));
    }
}
