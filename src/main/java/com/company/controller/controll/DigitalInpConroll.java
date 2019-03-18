package com.company.controller.controll;


import javafx.scene.control.TextField;

public class DigitalInpConroll extends TextField {

    @Override
    public void replaceText(int start, int end, String text) {
        if(text.matches("\\d*[\\.]{0,1}"))
        super.replaceText(start, end, text);
    }

}
