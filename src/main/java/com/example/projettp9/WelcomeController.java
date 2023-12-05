package com.example.projettp9;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeController {

    public TextField mailField;
    public TextField passwordField;
    public Button signInButton;
    public Button logInButton;

    @FXML
    protected void onSignInButtonClick(ActionEvent e) throws IOException {
        SignInController.afficher();
        Node source=(Node) e.getSource();
        Stage stage= (Stage) source.getScene().getWindow();
        stage.close();

    }
}
