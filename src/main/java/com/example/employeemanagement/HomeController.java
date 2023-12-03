package com.example.employeemanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private Button homeButton;

    @FXML
    private VBox pnitems;

    @FXML
    private Button viewButton;

    @FXML
    private Button updateButton;


    @FXML
    private Button addButton;

    @FXML
    private Button loginButton;

    @FXML
    void moveToUpdate(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateEmployee.fxml"));
        Parent root = loader.load();

        UpdateEmployeeController updateEmployeeController = loader.getController();

        Stage updateScreenStage = new Stage();
        updateScreenStage.setTitle("UpdateEmployee");
        updateScreenStage.setScene(new Scene(root,1230,680));
        updateScreenStage.show();

        Stage viewStage = (Stage)updateButton.getScene().getWindow();
        viewStage.close();
    }

    @FXML
    void moveToView(ActionEvent event)throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();

        HomeController homeController = loader.getController();

        Stage viewScreenStage = new Stage();
        viewScreenStage.setTitle("View");
        viewScreenStage.setScene(new Scene(root,1230,680));
        viewScreenStage.show();
    }

    @FXML
    void moveToHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
        Parent root = loader.load();

        AdminController adminController = loader.getController();

        Stage homeScreenStage = new Stage();
        homeScreenStage.setTitle("Home");
        homeScreenStage.setScene(new Scene(root,1230,680));
        homeScreenStage.show();

        Stage viewStage = (Stage) homeButton.getScene().getWindow();
        viewStage.close();
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadEmployeeDataFromFile("C:\\Users\\GLB\\IdeaProjects\\EmployeeManagement\\src\\main\\employee.txt");
    }

    private void loadEmployeeDataFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] employeeInfo = line.split(",");
                addEmployeeToUI(employeeInfo[0], employeeInfo[1], employeeInfo[2], employeeInfo[3], employeeInfo[4], employeeInfo[5]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addEmployeeToUI(String firstName, String lastName, String salary, String city, String degree, String dateOfBirth) {
        // Set a fixed width for each label
        HBox employeeRow = new HBox();
        employeeRow.setAlignment(Pos.CENTER);
        employeeRow.setStyle("-fx-background-color: WHITE;");
        double labelWidth = 80.0;

        Label nameLabel = new Label(firstName);
        nameLabel.setMinWidth(labelWidth);
        nameLabel.setMaxWidth(labelWidth);
        nameLabel.setWrapText(true); // Allow text to wrap if it's too long
        employeeRow.getChildren().add(nameLabel);

        Label fatherLabel = new Label(lastName);
        fatherLabel.setMinWidth(labelWidth);
        fatherLabel.setMaxWidth(labelWidth);
        fatherLabel.setWrapText(true);
        employeeRow.getChildren().add(fatherLabel);

        Label salaryLabel = new Label(salary);
        salaryLabel.setMinWidth(labelWidth);
        salaryLabel.setMaxWidth(labelWidth);
        salaryLabel.setWrapText(true);
        employeeRow.getChildren().add(salaryLabel);

        Label addressLabel = new Label(city);
        addressLabel.setMinWidth(labelWidth);
        addressLabel.setMaxWidth(labelWidth);
        addressLabel.setWrapText(true);
        employeeRow.getChildren().add(addressLabel);

        Label educationLabel = new Label(degree);
        educationLabel.setMinWidth(labelWidth);
        educationLabel.setMaxWidth(labelWidth);
        educationLabel.setWrapText(true);
        employeeRow.getChildren().add(educationLabel);

        Label dobLabel = new Label(dateOfBirth);
        dobLabel.setMinWidth(labelWidth);
        dobLabel.setMaxWidth(labelWidth);
        dobLabel.setWrapText(true);
        employeeRow.getChildren().add(dobLabel);

        // Set spacing between labels
        employeeRow.setSpacing(30.0);

        pnitems.getChildren().add(employeeRow);

        HBox.setMargin(nameLabel, new Insets(0, 0, 0, 30)); // Adjust the values according to your layout
        HBox.setMargin(fatherLabel, new Insets(0, 20, 0, 20));
        employeeRow.setPadding(new Insets(0,20,0,20));
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
}
