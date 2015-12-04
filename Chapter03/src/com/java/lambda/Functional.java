package com.java.lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Author: 王俊超
 * Date: 2015/12/3 16:41
 * All Rights Reserved !!!
 */
public class Functional {
    private JButton button = new JButton();
    private ActionEvent lastEvent;

    private void registerHandler() {
        button.addActionListener((ActionEvent event) -> {
            this.lastEvent = event;
        });
    }
}
