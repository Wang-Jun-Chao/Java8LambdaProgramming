package commond;

import com.java.lambda.comand.Editor;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2015/12/7 16:43
 * All Rights Reserved !!!
 */
public class MockEditor implements Editor {
    private final List<String> actions = new ArrayList<>();

    @Override
    public void save() {
        actions.add("save");
    }

    @Override
    public void open() {
        actions.add("open");
    }

    @Override
    public void close() {
        actions.add("close");
    }

    public void check() {
        Assert.assertEquals("open", actions.get(0));
        Assert.assertEquals("save", actions.get(1));
        Assert.assertEquals("close", actions.get(2));
    }
}
