package lambdabehave.expectations;

import org.junit.Assert;

import java.util.Collection;

/**
 * Author: 王俊超
 * Date: 2015/12/7 17:09
 * All Rights Reserved !!!
 */
public class CollectionExpectation extends BoundExpectation {
    private final Collection<?> objectUnderTest;

    public CollectionExpectation(Collection<?> objectUnderTest) {
        super(objectUnderTest);
        this.objectUnderTest = objectUnderTest;
    }

    public void isEmpty() {
        Assert.assertTrue(objectUnderTest.isEmpty());
    }
}
