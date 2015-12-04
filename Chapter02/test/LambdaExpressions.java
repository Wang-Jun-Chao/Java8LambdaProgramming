import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * Author: 王俊超
 * Date: 2015/12/3 15:56
 * All Rights Reserved !!!
 */
public class LambdaExpressions {
    public void firstLambda1() {
        JButton button = new JButton();
        // lambda表达式开始
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button clicked");
            }
        });

        // lambda表达式结束
    }

    public void firstLambda2() {
        JButton button = new JButton();
        // lambda表达式开始
        button.addActionListener(event -> System.out.println("button clicked"));
        // lambda表达式结束
    }

    public void firstLambda3() {
        JButton button = new JButton();
        // lambda表达式开始
        // 带参数类型和括号
        button.addActionListener((ActionEvent event) -> {
            System.out.println("button clicked");
        });
        // lambda表达式结束
    }

    // 所有的lambda表达式类型
    public void allLambdaForms() {
        // lambda表达式形式开始
        // 无参数的形式
        Runnable noArguments = () -> System.out.println("Hello World!");
        // 一个参数
        ActionListener oneArgument = event -> System.out.println("button clicked");
        // 多行语句
        Runnable multiStatement = () -> {
            System.out.print("Hello ");
            System.out.println("World");
        };
        // 二元操作
        BinaryOperator<Long> add = (x, y) -> x + y;
        // 二元操作
        BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;
        // lambda表达式形式结束
    }

    public void firstLambda5() {
        JButton button = new JButton();
        // lambda表达式开始
        final String name = getUserName();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hi " + name);
            }
        });
        // lambda表达式结束
    }

    public void firstLambda6() {
        JButton button = new JButton();
        // lambda表达式开始
        final String name = getUserName();
        button.addActionListener(event -> System.out.println("hi " + name));
        // lambda表达式结束
    }

    public void diamondInference() {
        // 钻石引用开始
        // JDK1.7之前的用法
        Map<String, Integer> oldWordCounts = new HashMap<String, Integer>();
        // JDK1.7开始后的用法
        Map<String, Integer> diamondWordCounts = new HashMap<>();
        // 钻石引用结束
    }

    public void diamondInferenceMethod() {
        // 钻石引用方法开始
        useHashMap(new HashMap<>());
    }

    private void useHashMap(Map<String, String> values) {
        // 方法
    }


    public void firstBiFunction() {
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
    }
    public void biFunctionDeclaration() {
        BiFunction<Integer, Integer, Integer> add;
    }

    public void typeInferenceExamples() {
        Predicate<Integer> atLeast5 = x -> x > 5;
    }

    public void typeInferenceExamples2() {
        BinaryOperator<Long> addLongs = (x, y) -> x + y;
    }


    @Test
    public void mostSpecific() {
        overloadedMethod("abc");
    }

    @Test
    public void mostSpecificBiFunction() {
        overloadedMethod((x, y) -> x + y);
    }

    private interface IntegerBiFunction extends BinaryOperator<Integer> {
    }


    private void overloadedMethod(BinaryOperator<Integer> lambda) {
        System.out.print("BinaryOperator");
    }

    private void overloadedMethod(IntegerBiFunction lambda) {
        System.out.print("IntegerBinaryOperator");
    }

    private void overloadedMethod(Object o) {
        System.out.print("Object");
    }

    private void overloadedMethod(String s) {
        System.out.print("String");
    }

    private String getUserName() {
        return "Wang";
    }
}
