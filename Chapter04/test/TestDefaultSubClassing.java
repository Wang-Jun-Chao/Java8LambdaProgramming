import com.java.lambda.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Author: 王俊超
 * Date: 2015-12-05 10:58
 * Declaration: All Rights Reserved !!!
 */
public class TestDefaultSubClassing {
    @Test
    public void parentDefaultUsed() {
        Parent parent = new ParentImpl();
        parent.welcome();
        Assert.assertEquals("Parent: Hi!", parent.getLastMessage());
    }

    @Test
    public void childOverrideDefault() {
        Child child = new ChildImpl();
        child.welcome();
        Assert.assertEquals("Child: Hi!", child.getLastMessage());
    }

    @Test
    public void concreteBeatsDefault() {
        Parent parent = new OverridingParent();
        parent.welcome();
        Assert.assertEquals("Class Parent: Hi!", parent.getLastMessage());
    }

    @Test
    public void concreteBeatsCloserDefault() {
        Child child = new OverridingChild();
        child.welcome();
        Assert.assertEquals("Class Parent: Hi!", child.getLastMessage());
    }
}
