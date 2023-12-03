package com.example.employeemanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class UpdateController {

    @FXML
    private TextField address;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField dateofBirth;

    @FXML
    private TextField eName;

    @FXML
    private TextField education;

    @FXML
    private TextField email;

    @FXML
    private TextField fatherName;

    @FXML
    private TextField salary;

    @FXML
    private Button updateButton;

    @FXML
    void onCancel(ActionEvent event) {

    }

    @FXML
    void onUpdate(ActionEvent event) {
        String updatedName = eName.getText();
        String updatedFatherName = fatherName.getText();
        String updatedSalary = salary.getText();
        String updatedAddress = address.getText();
        String updatedEducation = education.getText();
        String updatedDateOfBirth = dateofBirth.getText();





    }



}