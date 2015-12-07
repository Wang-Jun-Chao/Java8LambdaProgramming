package lambdabehave.example;

import lambdabehave.Lets;

import java.util.Stack;

/**
 * Author: 王俊超
 * Date: 2015/12/7 17:03
 * All Rights Reserved !!!
 */
public class StackSpec {
    {
        Lets.describe("a stack", it -> {
            it.should("be very when created", expect -> {
                expect.that(new Stack<Object>()).isEmpty();
            });

            it.should("push new elements onto the top of the stack", expect -> {
                Stack<Integer> stack = new Stack<>();
                stack.push(1);
                expect.that(stack.get(0)).isEqualTo(1);
            });

            it.should("pop the last element pushed onto the stack", expect -> {
                Stack<Integer> stack = new Stack<>();
                stack.push(2);
                stack.push(1);

                expect.that(stack.pop()).isEqualTo(2);
            });
        });
    }
}
