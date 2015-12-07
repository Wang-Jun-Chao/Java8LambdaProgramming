package com.java.lambda.comand;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Author: 王俊超
 * Date: 2015/12/7 14:38
 * All Rights Reserved !!!
 */
public class Close implements Action {
    private final Editor editor;

    public Close(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.close();
    }
}
