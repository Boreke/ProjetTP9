package com.example.projettp9;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class SignInController {
    @FXML
    public TextField nameField;
    @FXML
    public Button confirmButton;
    @FXML
    public TextField phoneField;
    @FXML
    public TextField mailField;
    @FXML
    public TextField passwordField;
    @FXML
    public TextField confirmPasswordField;

    @FXML
    public Label confirmLabel;

    public static void afficher(){
        try{
            FXMLLoader loader=new FXMLLoader(HelloApplication.class.getResource("SignInScene.fxml"));
            Scene scene =new Scene(loader.load());

            Stage stage=new Stage();
            stage.setTitle("Sign in");
            stage.setScene(scene);
            stage.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    protected void onSignInButtonClick(ActionEvent e)throws IOException{
        String[]contents = new String[]{nameField.getText(),phoneField.getText(),mailField.getText(),passwordField.getText()} ;
        Node source=(Node) e.getSource();
        Stage stage= (Stage) source.getScene().getWindow();
        if (passwordField.getText().equals(confirmPasswordField.getText())) {
            File file = new File("credentials.csv");
            if (!file.exists()) {
                file.createNewFile();
                FileWriter fileWriter=new FileWriter(file);
                BufferedWriter printWriter = new BufferedWriter(fileWriter);
                printWriter.write("Nom;telephone;email;mot de passe");
                printWriter.newLine();
                printWriter.close();
            }
            StringBuilder stringbuilder = new StringBuilder();
            for (String content : contents) {
                stringbuilder.append(content).append(";");
            }
            appendToFile(stringbuilder.toString());
            stage.close();

        }else{
            confirmLabel.setText("Les Mots de passe doivent être les mêmes.");
            stage.setScene(source.getScene());
            stage.show();
        }

    }
    private void appendToFile(String s) throws IOException{
        FileWriter fw = new FileWriter("credentials.csv", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(s);
        bw.newLine();
        bw.close();
    }
}
