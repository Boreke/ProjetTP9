package com.example.projettp9;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WelcomeController {

    public TextField mailField;
    public TextField passwordField;
    public Button signInButton;
    public Button logInButton;
    public Label errorLabel;

    @FXML
    protected void onSignInButtonClick(ActionEvent e) {
        SignInController.afficher();
        Node source=(Node) e.getSource();
        Stage stage= (Stage) source.getScene().getWindow();
        stage.close();

    }
    @FXML
    protected void onLogInButtonClick(ActionEvent e ) throws IOException{
        Node source=(Node) e.getSource();
        Stage stage= (Stage) source.getScene().getWindow();
        Scanner scanner = new Scanner(new File("credentials.csv"));
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine())
                    .append("\n");
        }
        scanner.close();

        String data = stringBuilder.toString();
        String[] lines = data.split("\n");
        for (String line :lines) {
            String[] parts=line.split(";");
            String mail=parts[2];
            String password=parts[3];
            if (mailField.getText().equals(mail)&&passwordField.getText().equals(password)){
                ServiceSceneController.afficher(parts[1]);
                stage.close();
            }else{
                errorLabel.setText("Les informations sont incorrectes");
                stage.setScene(source.getScene());
                stage.show();
            }

        }
    }
}
