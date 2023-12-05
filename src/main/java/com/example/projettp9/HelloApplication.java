package com.example.projettp9;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        exercice1(stage);
    }

    public static void main(String[] args) {
        launch();
    }
    public static void exercice1(Stage stage)throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("InscriptionScene.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 600,400);
        stage.setTitle("inscriptionScene");
        stage.setScene(scene);
        stage.show();
    }
}