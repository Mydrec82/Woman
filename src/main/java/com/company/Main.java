package com.company;

import com.company.controller.FirstStart;
import com.company.controller.Login;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch();

    }

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        primaryStage.setTitle("Woman days");


        if(new SetingFile().getFile().length() == 0){
            loader.setLocation(getClass().getResource("/firstStart.fxml"));
            primaryStage.setScene(new Scene(loader.load()));
            FirstStart firstStart = loader.getController();
            firstStart.setController(primaryStage);
            primaryStage.show();

        }else {
            loader.setLocation(getClass().getResource("/login.fxml"));
            primaryStage.setScene(new Scene(loader.load()));
            Login login = loader.getController();
            login.setStage(primaryStage);
            primaryStage.show();
        }
    }
}