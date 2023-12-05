package com.example.projettp9;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    public TextField mailTextField;
    @FXML
    public Label mailLabel;

    public Button confirmButton;
    @FXML
    private Label nameLabel;
    @FXML
    private TextField nameTextField;


    @FXML
    protected void onConfirmButtonClick(ActionEvent e) throws IOException {
        String name=nameTextField.getText();
        String mail=mailTextField.getText();
        AffichageController.afficher(name,mail);
        Node source=(Node) e.getSource();
        Stage stage= (Stage) source.getScene().getWindow();
        stage.close();

    }
}