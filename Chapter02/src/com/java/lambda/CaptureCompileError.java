package com.java.lambda;

import javax.swing.*;

/**
 * All Rights Reserved !!!
 * Author: 王俊超
 * Date: 2015-12-03 11:11
 */
public class CaptureCompileError {
    private JButton button;

    public void error() {
        String name = getUserName();
        name = formatUserName(name);
    }

    private String formatUserName(String name) {
        return name.toLowerCase();
    }

    private String getUserName() {
        return "WANG";
    }
}
