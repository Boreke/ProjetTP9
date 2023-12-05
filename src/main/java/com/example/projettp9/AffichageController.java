package com.example.projettp9;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.stage.Stage;

public class AffichageController {

    public Label finalNameLabel;
    public Label finalMailLabel;

    public static void afficher(String name,String email){
        try{
            FXMLLoader loader=new FXMLLoader(HelloApplication.class.getResource("AffichageScene.fxml"));
            Scene scene =new Scene(loader.load());
            AffichageController c =loader.getController();
            c.finalNameLabel.setText("Bonjour " +name);
            c.finalMailLabel.setText("votre email: "+email);
            Stage stage=new Stage();
            stage.setTitle("logged in");
            stage.setScene(scene);
            stage.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
