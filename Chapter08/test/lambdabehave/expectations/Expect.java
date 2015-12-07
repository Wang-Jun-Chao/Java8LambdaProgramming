package lambdabehave.expectations;

import java.util.Collection;

/**
 * Author: 王俊超
 * Date: 2015/12/7 17:08
 * All Rights Reserved !!!
 */
public class Expect {
    public BoundExpectation that(Object value) {
        return new BoundExpectation(value);
    }

    public CollectionExpectation that(Collection<?> collection) {
        return new CollectionExpectation(collection);
    }
}
