package com.example.employeemanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SplashController {


    @FXML
    private Button splashButton;
    Stage stage;

    @FXML
    void onClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent mainScreenRoot = loader.load();

        // Get the controller for the new screen
        LoginController loginController = loader.getController();

        // Create a new stage for the main screen
        Stage mainScreenStage = new Stage();
        mainScreenStage.setTitle("LogIn");
        mainScreenStage.setScene(new Scene(mainScreenRoot, 658, 680));

        // Show the new screen
        mainScreenStage.show();

        // Close the splash screen
        Stage splashStage = (Stage) splashButton.getScene().getWindow();
        splashStage.close();
    }

}
