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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;


public class DeleteemployeeController implements Initializable {

    @FXML
    private Button homeButton;

    @FXML
    private Button loginButton;

    @FXML
    private VBox pnitems;

    @FXML
    private Button viewButton;

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

        Button delbutton = new Button("Delete");
        delbutton.setMinWidth(90);
        delbutton.setMinHeight(30);
        delbutton.setStyle("-fx-background-color: #D22B2B;-fx-text-fill: white;-fx-cursor: hand;");

        delbutton.setOnAction(actionEvent -> {
            HBox employeerow = (HBox) delbutton.getParent();
            pnitems.getChildren().remove(employeerow);

            String firstname = ((Label) employeeRow.getChildren().get(0)).getText();
            String lastname = ((Label) employeeRow.getChildren().get(1)).getText();
            String esalary = ((Label) employeeRow.getChildren().get(2)).getText();
            String ecity = ((Label) employeeRow.getChildren().get(3)).getText();
            String edegree = ((Label) employeeRow.getChildren().get(4)).getText();
            String edateOfBirth = ((Label) employeeRow.getChildren().get(5)).getText();

            // Create a string with the employee information to be deleted
            String employeeToDelete = String.format("%s,%s,%s,%s,%s,%s,", firstname, lastname, esalary, ecity, edegree, edateOfBirth);

            // Update the text file by removing the line with the employee information
            updateTextFile("C:\\Users\\GLB\\IdeaProjects\\EmployeeManagement\\src\\main\\employee.txt", employeeToDelete);
        });


        employeeRow.getChildren().add(delbutton);


        // Set spacing between labels
        employeeRow.setSpacing(30.0);

        pnitems.getChildren().add(employeeRow);

        HBox.setMargin(nameLabel, new Insets(0, 0, 0, 30)); // Adjust the values according to your layout
        HBox.setMargin(fatherLabel, new Insets(0, 0, 0, 20));
        HBox.setMargin(salaryLabel,new Insets(0,0,0,20));
        HBox.setMargin(dobLabel,new Insets(0.,0,0,0));
        HBox.setMargin(delbutton,new Insets(0,0,10,0));
        employeeRow.setPadding(new Insets(0,20,0,20));
    }

    private void updateTextFile(String filePath, String dataToRemove) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            lines.removeIf(line -> line.equals(dataToRemove));

            // Write the updated lines back to the file
            Files.write(Paths.get(filePath), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
