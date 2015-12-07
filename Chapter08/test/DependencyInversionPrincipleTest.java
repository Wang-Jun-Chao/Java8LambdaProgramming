import com.java.lambda.DependencyInversionPrinciple;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2015/12/7 16:35
 * All Rights Reserved !!!
 */

@RunWith(Parameterized.class)
public class DependencyInversionPrincipleTest {


    private final DependencyInversionPrinciple.HeadingFinder finder;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
                {new DependencyInversionPrinciple.NoDIP()},
                {new DependencyInversionPrinciple.ExtractedDIP()}};
        return Arrays.asList(data);
    }

    public DependencyInversionPrincipleTest(DependencyInversionPrinciple.HeadingFinder finder) {
        this.finder = finder;
    }

    @Test
    public void correctHeadings() {
        InputStreamReader reader = new InputStreamReader(getClass().getResourceAsStream("test_file"));
        List<String> headings = finder.findHeadings(reader);
        Assert.assertEquals(Arrays.asList("Improve Content", "Cleanup", "Add Content", "Add to Streams Chapter"),
                headings);
    }

}

