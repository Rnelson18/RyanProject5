package com.example.ryanproject5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;


    @FXML
    public void handleOpenWindow(ActionEvent event){
        var secondLoc = new FXMLLoader(GroupApplication.class.getResource("SecondWindow.fxml"));
        Scene secondScene = null;
        try{
            secondScene = new Scene(secondLoc.load(), 900, 600);
        }catch (IOException e){
            System.out.println("Couldn't load second window");
            e.printStackTrace();
        }
        Stage Nick = new Stage();
        Nick.setScene(secondScene);
        Nick.setTitle("See  - here is a second window");
        Nick.show();
    }

    @FXML
    public void handleClose(ActionEvent event){
        System.exit(0);
    }

}
