package com.example.BookShopApi.bo;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Administrator {
    @Id
    @NonNull
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int AdminID;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String emailAddress;

    @NonNull
    private String encryptedPassword;

    public int getAdminID() {
        return AdminID;
    }

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    @NonNull
    public String getEmailAddress() {
        return emailAddress;
    }

    @NonNull
    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    @NonNull
    public String getLastName() {
        return lastName;
    }


    public void setEncryptedPassword(@NonNull String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }


    public void setEmailAddress(@NonNull String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setLastName(@NonNull String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    public void setAdminID(int adminID) {
        AdminID = adminID;
    }
}
