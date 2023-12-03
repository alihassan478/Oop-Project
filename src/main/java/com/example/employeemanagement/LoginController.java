package com.example.employeemanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {


    @FXML
    private PasswordField password;

    @FXML
    private TextField username;
    @FXML
    private Button logInButton;

    @FXML
    void onClick(ActionEvent event) throws IOException {
        String user = username.getText();
        String pass = password.getText();

        if(("alihassan").equals(user) && "12345".equals(pass) || ("rajabkamran").equals(user)){
            System.out.println("Login successfully");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
            Parent homeScreen = loader.load();

            AdminController homeController = loader.getController();

            Stage homeScreenStage = new Stage();
            homeScreenStage.setTitle("Home");
            homeScreenStage.setScene(new Scene(homeScreen,1230,680));
            homeScreenStage.show();

            Stage loginStage = (Stage) logInButton.getScene().getWindow();
            loginStage.close();
        }else {
            System.out.println("Username or Password is Incorrect");
        }

    }
}
