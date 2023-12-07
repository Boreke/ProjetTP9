package com.example.projettp9;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ServiceSceneController {
    public Label welcomeLabel;
    public Button newMessageButton;

    public static void afficher(String name){
        try{
            FXMLLoader loader=new FXMLLoader(HelloApplication.class.getResource("ServiceScene.fxml"));
            Scene scene =new Scene(loader.load());
            Stage stage=new Stage();
            ServiceSceneController c =loader.getController();
            c.welcomeLabel.setText("Bonjour " +name);
            stage.setTitle("Votre Compte");
            stage.setScene(scene);
            stage.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
