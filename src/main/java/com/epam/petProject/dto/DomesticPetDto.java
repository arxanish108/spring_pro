package com.epam.petProject.dto;

import java.time.LocalDate;

public class DomesticPetDto extends PetDto{
    private LocalDate birthdate;

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "DomesticPetDto{" +
                "birthdate=" + birthdate +
                '}'+getName() +" "+getId()+" "+getPetType()+" "+getOwnerDto();
    }
}
