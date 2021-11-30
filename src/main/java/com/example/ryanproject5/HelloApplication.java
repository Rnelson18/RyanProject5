package com.example.ryanproject5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FirstWindow.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 300, 400);
        }
        catch (IOException e){
            System.out.println("Couldn't Find FXML file!!!!!!");
        }
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

