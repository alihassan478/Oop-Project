module com.example.employeemanagement {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.employeemanagement to javafx.fxml;
    exports com.example.employeemanagement;
}