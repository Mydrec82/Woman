package com.company.controller;

import com.company.SetingFile;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class WorkWindow {

    @FXML
    public GridPane pane;
    public Label date;
    public Label labelNow;
    private SetingFile file = new SetingFile();
    private LocalDate dateNow = LocalDate.now();
    private LocalDate middle = dateNow;



    public void initialize() {
        String s = dateNow.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        date.setText(s);
        fillTable(dateNow);
    }


    //Created table
    private void fillTable(LocalDate date){
        int now = date.getDayOfMonth();
        LocalDate first = LocalDate.of(date.getYear(), date.getMonth(), 1);
        LocalDate one = getMensDay1(date);

        //define first Monday of Month
        while(!first.getDayOfWeek().equals(DayOfWeek.MONDAY)){
           first = first.plusDays(1);
        }

        //fill Table labels
        for(int vert = 0; vert < 5; vert++){
            for(int hor = 0; hor < 7; hor++){
                String numberDay = String.valueOf(first.getDayOfMonth());
                Label label = new Label(numberDay);
                label.setMaxSize(200, 200);
                label.setAlignment(Pos.CENTER);
                label.setStyle("-fx-font-size:14px");

                //set color label
                if(first.isAfter(one.minusDays(7)) && first.isBefore(one))label.setStyle("-fx-background-color: lightgreen");
                else if(first.isAfter(one.minusDays(1)) && first.isBefore(one.plusDays(5))) label.setStyle("-fx-background-color: red");
                else if(first.isAfter(one.plusDays(4)) && first.isBefore(one.plusDays(7))) label.setStyle("-fx-background-color: lightgreen");
                else label.setStyle("-fx-background-color: #eaeaea");

                pane.add(label,hor, vert);

                first = first.plusDays(1);
            }
        }
    }

    private LocalDate getMensDay1(LocalDate now){
        LocalDate dateFist = LocalDate.parse(file.getData("date"), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        int days = Integer.parseInt(file.getData("days"));

        while(dateFist.getMonthValue() < now.getMonthValue()){
            dateFist = dateFist.plusDays(days);
        }
        return dateFist;
    }

    public void addMonth(){
        middle = middle.plusMonths(1);
        labelNow.setText(middle.getMonth().toString());
        fillTable(middle);
    }

    public void minusMonth(){
        middle = middle.minusMonths(1);
        if(dateNow.getMonthValue() == middle.getMonthValue()){
            labelNow.setText("Сегодня");
        }
        labelNow.setText(middle.getMonth().toString());
        fillTable(middle);
    }

}
