package com.epam.petProject.dto;

import com.epam.petProject.enumm.Gender;
import com.epam.petProject.enumm.PetType;

import java.util.Objects;

public class PetDto {
    private int id;
    private String name;
    private Gender gender;
    private PetType petType;
    private OwnerDto ownerDto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public OwnerDto getOwnerDto() {
        return ownerDto;
    }

    public void setOwnerDto(OwnerDto ownerDto) {
        this.ownerDto = ownerDto;
    }

    @Override
    public String toString() {
        if(Objects.nonNull(ownerDto)) {
            return "PetDto{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", gender=" + gender +
                    ", petType=" + petType +
                    ", ownerDto=" + ownerDto +
                    '}';
        }else{
            return "PetDto{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", gender=" + gender +
                    ", petType=" + petType;
        }
    }
}
