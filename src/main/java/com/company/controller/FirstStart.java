package com.company.controller;

import com.company.SetingFile;
import com.company.StartWorkWindow;
import com.company.controller.controll.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FirstStart {
    @FXML
    public ControlInpName nameField;
    public ControlInpName passField;
    public DigitalInpConroll dateField;
    public DigitalInpConroll daysField;
    public Label label;
    private Stage stage;

    public void setOk() throws Exception {
        SetingFile file = new SetingFile();
        if(!nameField.getText().isEmpty() & !passField.getText().isEmpty() & parseDate(dateField.getText()) & checkDays(daysField.getText())){
            file.write("name", nameField.getText());
            file.write("pass", passField.getText());
            file.write("days", daysField.getText());
            file.write("date",dateField.getText());
            new StartWorkWindow().start(stage);

        }else {
            label.setText("  Что - то ввели не правильно... Проверьте вводимые данные");
        }
    }


    //check input date no later now
    private boolean parseDate(String date){
        try {
            LocalDate date1 = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            if(date1.isAfter(LocalDate.now())){
                dateField.clear();
                return false;
            }else return true;
        }catch(DateTimeParseException e){
            dateField.clear();
            return false;
        }
    }

    private boolean checkDays(String days){
        try{
            int a = Integer.parseInt(days);
            if(a >= 25 && a <= 30) return true;
            else{
                daysField.clear();
                return false;
            }

        }catch (NumberFormatException n){
            daysField.clear();
            return false;
        }
    }


    public void setReset(){
        nameField.clear();
        passField.clear();
        dateField.clear();
        daysField.clear();
    }

    public void setController(Stage stage) {
        this.stage = stage;
    }
}
