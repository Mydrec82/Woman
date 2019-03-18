package com.company.controller;

import com.company.SetingFile;
import com.company.StartWorkWindow;
import com.company.User;
import com.company.controller.controll.ControlInpName;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;



public class Login {

    @FXML
    public ControlInpName loginField;
    public ControlInpName passField;
    public Label label;
    public Button button;
    private Stage stage;
    private SetingFile setingFile = new SetingFile();

  @FXML
  void setOk(){
      if(loginField.getText().length() != 0 & passField.getText().length() != 0){
          User inUser = new User(loginField.getText(), passField.getText());
          try {
              User user = setingFile.getUser();

              if(inUser.equals(user))new StartWorkWindow().start(stage);
              else {
                  label.setText("Проверьте имя или пароль");
                  loginField.clear();
                  passField.clear();
              }
          }  catch (Exception e) {
              e.printStackTrace();
          }


      }
  }

  @FXML
  void setOy(){
      setingFile.deleteFile();
      stage.close();
  }

  public void setStage(Stage primaryStage) {
      this.stage = primaryStage;
      stage.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
          @Override
          public void handle(KeyEvent event) {
              if(KeyCode.ENTER.equals(event.getCode())) setOk();
          }
      });
  }


}
