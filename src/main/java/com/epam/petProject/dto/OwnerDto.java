package com.epam.petProject.dto;

import com.epam.petProject.enumm.Gender;

import java.util.Objects;

public class OwnerDto {
    private int id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String city;
    private String state;
    private String mobileNumber;
    private String emailId;
    private PetDto petDto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public PetDto getPetDto() {
        return petDto;
    }

    public void setPetDto(PetDto petDto) {
        this.petDto = petDto;
    }

    @Override
    public String toString() {

        if(Objects.nonNull(petDto)) {
            return "OwnerDto{" +
                    "id=" + id +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", gender=" + gender +
                    ", city='" + city + '\'' +
                    ", state='" + state + '\'' +
                    ", mobileNumber='" + mobileNumber + '\'' +
                    ", emailId='" + emailId + '\'' +
                    ", petDto=" + petDto +
                    '}';
        }else{
            return "OwnerDto{" +
                    "id=" + id +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", gender=" + gender +
                    ", city='" + city + '\'' +
                    ", state='" + state + '\'' +
                    ", mobileNumber='" + mobileNumber + '\'' +
                    ", emailId='" + emailId;

        }
    }
}
