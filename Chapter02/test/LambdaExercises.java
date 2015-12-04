import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.ThreadFactory;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Author: 王俊超
 * Date: 2015-12-03 11:13
 * All Rights Reserved !!!
 */
public class LambdaExercises {
    @Test
    public void test1a() {
        Assert.assertTrue("Shown in the next chapter", true);
    }

    @Test
    public void test1b() {
        // 将每一个操作看作函数对象
        Function<Double, Double> negate = (x) -> -1 * x;
        Function<Double, Double> square = (x) -> x * x;
        Function<Double, Double> percent = (x) -> 100 * x;
    }

    @Test
    public void test1c() {
        // 加一操作的函数对象
        Function<Integer, Integer> one = x -> x + 1;
        // 判断等于1的函数对象
        Function<Integer, Boolean> three = x -> x == 1;
    }

    @Test
    public void test2a() {
        Assert.assertTrue("ThreadLocal.withInitial", true);
    }

    @Test
    public void test2b() {
        ThreadLocal<DateFormat> threadSafeFormatter = ThreadLocal.withInitial(DateFormat::getDateInstance);
        DateFormat formatter = threadSafeFormatter.get();
        Assert.assertTrue("ThreadLocal.withInitial", true);
        Assert.assertEquals("1970-1-1", formatter.format(new Date(0)));
    }

    @Test
    public void test3a() {
        Runnable helloWorld = () -> System.out.println("hello world");
    }

    @Test
    public void test3b() {
        JButton button = new JButton();
        button.addActionListener(event-> System.out.println(event.getActionCommand()));
    }
    @Test
    public void test3c() {
        // 错误的使用
        // check(x -> x > 5);
    }

    private boolean check(Predicate<Integer> predicate) {
        System.out.println("wat?");
        return true;
    }

    interface  IntPred {
        boolean test(Integer value);
    }

    private boolean check(IntPred pred) {
        return true;
    }


}
