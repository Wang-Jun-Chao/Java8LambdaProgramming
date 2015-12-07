package com.java.lambda.comand;

/**
 * Author: 王俊超
 * Date: 2015/12/7 14:42
 * All Rights Reserved !!!
 */
public class Open implements Action {

    private final Editor editor;

    public Open(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.open();
    }
}
