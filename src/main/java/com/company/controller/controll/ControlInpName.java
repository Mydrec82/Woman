package com.company.controller.controll;

import javafx.scene.control.TextField;

public class ControlInpName extends TextField {

    String name = "\\w*";

    @Override
    public void replaceText(int start, int end, String text) {
        if (inp(text)) super.replaceText(start, end, text);
    }

    private boolean inp(String text){
        return text.matches(name);
    }
}
