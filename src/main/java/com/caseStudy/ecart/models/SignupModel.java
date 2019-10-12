package com.caseStudy.ecart.models;

import javax.persistence.*;

@Entity
@Table(name="Signup")
public class SignupModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    int id;
    String username;
    String email;
    String contact;
    String password;
    String confirm_pswd;
    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirm_pswd(String confirm_pswd) {
        this.confirm_pswd = confirm_pswd;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirm_pswd() {
        return confirm_pswd;
    }


}
