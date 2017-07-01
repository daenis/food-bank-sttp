package com.opendatadelaware.feede.controller.utils;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by denniskalaygian on 6/30/17.
 */

public class UserAuthValidator {

    @NotNull(message="First name cannot be null")
    private String firstName;

    @NotNull(message="Last name cannot be null")
    private String lastName;

    @NotNull(message="Email cannot be null")
    @Email
    private String email;

    @NotNull(message="Password cannot be null")
    private String password;

    @NotNull(message="Phone number cannot be null")
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phoneNumber;

    @NotNull(message ="Street cannot be null")
    private String street;

    @NotNull(message ="City cannot be null")
    private String city;

    @NotNull(message ="State cannot be null")
    private String state;

    @NotNull(message ="Zip cannot be null")
    private String zip;

    @NotNull(message="Type cannot be null")
    private String type;

    public UserAuthValidator(String firstName, String lastName, String email, String password,
                             String phoneNumber, String street, String city, String state, String zip, String type)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.street = city;
        this.street = state;
        this.street = zip;
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
