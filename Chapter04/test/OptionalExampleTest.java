import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * Author: 王俊超
 * Date: 2015-12-05 10:52
 * Declaration: All Rights Reserved !!!
 */
public class OptionalExampleTest {
    @Test
    public void examples() {
        Optional<String> a = Optional.of("a");
        Assert.assertEquals("a", a.get());

        Optional emptyOptional = Optional.empty();
        Optional alsoEmpty = Optional.ofNullable(null);
        Assert.assertFalse(emptyOptional.isPresent());
        Assert.assertFalse(alsoEmpty.isPresent());

        Assert.assertTrue(a.isPresent());

        Assert.assertEquals("b", emptyOptional.orElse("b"));
        Assert.assertEquals("c", emptyOptional.orElseGet(() -> "c"));
    }
}
