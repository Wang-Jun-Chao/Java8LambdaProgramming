package lambdabehave.expectations;

import org.junit.Assert;

/**
 * Author: 王俊超
 * Date: 2015/12/7 17:08
 * All Rights Reserved !!!
 */
public class BoundExpectation {
    private final Object objectUnderTest;

    public BoundExpectation(Object value) {
        this.objectUnderTest = value;
    }

    public void isEqualTo(Object expected) {
        Assert.assertEquals(expected, objectUnderTest);
    }
}
