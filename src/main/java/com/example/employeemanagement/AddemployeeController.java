package com.example.employeemanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AddemployeeController {
    @FXML
    private Button addButton;


    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField address;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField email;

    @FXML
    private TextField dateofBirth;

    @FXML
    private TextField eName;

    @FXML
    private TextField education;

    @FXML
    private TextField fatherName;

    @FXML
    private Button loginButton;

    @FXML
    private TextField salary;

    @FXML
    private Button submitButton;

    @FXML
    private Button viewButton;

    @FXML
    void onCancel(ActionEvent event) {
        email.clear();
        education.clear();
        fatherName.clear();
        eName.clear();
        dateofBirth.clear();
        salary.clear();
        address.clear();
    }


    @FXML
    private Button homeButton;



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
    void onSubmit(ActionEvent event) throws IOException {
        String username = eName.getText();
        String fathername = fatherName.getText();
        String employeeaddress = address.getText();
        String employeeSalary = salary.getText();
        String employeeEducation = education.getText();
        String dob = dateofBirth.getText();

        String[] textToAdd ={username,fathername,employeeSalary,employeeaddress,employeeEducation,dob};

        String fileName = "C:\\Users\\GLB\\IdeaProjects\\EmployeeManagement\\src\\main\\employee.txt";

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true))){
            for(String text:textToAdd){
                writer.write(text);
                writer.write(",");
            }
            writer.write("\n");
            System.out.println("Done!!!");
        }catch (IOException e){
            System.err.println("Error writing this file: "+e.getMessage());
        }

        email.clear();
        education.clear();
        fatherName.clear();
        eName.clear();
        dateofBirth.clear();
        salary.clear();
        address.clear();

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

    @FXML
    void onHome(ActionEvent event) throws IOException {
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


}
