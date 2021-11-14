package com.Domenico.BasicUserManagement;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "user")
@Entity
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;

    public User () {
    }

    public User(String firstName, String middleName, String lastName, String email, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}