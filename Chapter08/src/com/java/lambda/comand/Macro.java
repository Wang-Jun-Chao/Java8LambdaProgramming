package com.java.lambda.comand;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2015/12/7 14:40
 * All Rights Reserved !!!
 */
public class Macro {
    private final List<Action> actions;

    public Macro() {
        actions = new ArrayList<>();
    }

    public void record(Action action) {
        actions.add(action);
    }

    public void run() {
        actions.forEach(Action::perform);
    }
}

