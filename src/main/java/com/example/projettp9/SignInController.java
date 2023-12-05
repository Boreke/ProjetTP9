package com.example.projettp9;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class SignInController {
    public TextField nameField;

    public Button confirmButton;

    public TextField phoneField;
    public TextField mailField;
    public TextField passwordField;
    public TextField confirmPasswordField;
    public TextField[] textFields={nameField,phoneField,mailField,passwordField,confirmPasswordField};
    public static void afficher(){
        try{
            FXMLLoader loader=new FXMLLoader(HelloApplication.class.getResource("SignInScene.fxml"));
            Scene scene =new Scene(loader.load());
            SignInController c =loader.getController();
            Stage stage=new Stage();
            stage.setTitle("Sign in");
            stage.setScene(scene);
            stage.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void onSignInButtonClick(ActionEvent e){
        File file=new File("credentials.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException x) {
                throw new RuntimeException(x);
            }
        }
        try {
            PrintWriter printWriter=new PrintWriter(file);

            printWriter.close();
        } catch (FileNotFoundException x) {
            throw new RuntimeException(x);
        }



    Node source=(Node) e.getSource();
    Stage stage= (Stage) source.getScene().getWindow();
    stage.close();

    }
}
