package com.java.lambda.comand;

/**
 * Author: 王俊超
 * Date: 2015/12/7 14:43
 * All Rights Reserved !!!
 */
public class Save implements Action {
    private final Editor editor;

    public Save(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.save();
    }
}
