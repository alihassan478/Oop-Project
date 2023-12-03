package com.example.employeemanagement;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class AdminController {
    @FXML
    private Label nameLabel;

    @FXML
    private Label number;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button loginButton;

    @FXML
    private Button addButton;

    @FXML
    private Button viewButton;


    public void initialize() {
        // Set initial name
        nameLabel.setText("Ali Hassan");

        // Create a timeline to switch names every 5 seconds
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> {
                    // Switch between "Ali Hassan" and "Rajab"
                    if (nameLabel.getText().equals("Ali Hassan")) {
                        nameLabel.setText("Rajab Kamran");
                    } else {
                        nameLabel.setText("Ali Hassan");
                    }
                })
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }



    @FXML
    void moveToUpdate(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateEmployee.fxml"));
        Parent root = loader.load();

        UpdateEmployeeController uodateemployeeController = loader.getController();

        Stage deleteStage = new Stage();
        deleteStage.setTitle("DeleteEmployee");
        deleteStage.setScene(new Scene(root,1230,680));
        deleteStage.show();

        Stage prevStage = (Stage)deleteButton.getScene().getWindow();
        prevStage.close();
    }


    @FXML
    void moveToDelete(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Deleteemployee.fxml"));
        Parent root = loader.load();

        DeleteemployeeController deleteemployeeController = loader.getController();

        Stage deleteStage = new Stage();
        deleteStage.setTitle("DeleteEmployee");
        deleteStage.setScene(new Scene(root,1230,680));
        deleteStage.show();

        Stage prevStage = (Stage)deleteButton.getScene().getWindow();
        prevStage.close();
    }


    @FXML
    void onClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();

        HomeController adminController = loader.getController();

        Stage adminScreenStage = new Stage();
        adminScreenStage.setTitle("View");
        adminScreenStage.setScene(new Scene(root,1230,680));
        adminScreenStage.show();

        Stage homeStage = (Stage) viewButton.getScene().getWindow();
        homeStage.close();
    }


    @FXML
    void moveToAdd(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Addemployee.fxml"));
        Parent root = loader.load();

        AddemployeeController addemployeeController = loader.getController();

        Stage addStage = new Stage();
        addStage.setTitle("AddEmployee");
        addStage.setScene(new Scene(root,1230,680));
        addStage.show();

        Stage homeStage = (Stage) addButton.getScene().getWindow();
        homeStage.close();
    }

    @FXML
    void onLogIn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = loader.load();

        LoginController loginController = loader.getController();

        Stage loginStage = new Stage();
        loginStage.setTitle("LogIn");
        loginStage.setScene(new Scene(root,655,680));
        loginStage.show();

        Stage adminStage = (Stage) loginButton.getScene().getWindow();
        adminStage.close();
    }

}
