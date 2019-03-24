package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartWorkWindow extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/workWindow.fxml"));
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
