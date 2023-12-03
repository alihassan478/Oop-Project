package com.example.employeemanagement;

public class Employee {
    private String name;
    private String fatherName;
    private String salary;
    private String address;
    private String education;
    private String dateOfBirth;

    public Employee(String name, String fatherName, String salary, String address, String education, String dateOfBirth) {
        this.name = name;
        this.fatherName = fatherName;
        this.salary = salary;
        this.address = address;
        this.education = education;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
