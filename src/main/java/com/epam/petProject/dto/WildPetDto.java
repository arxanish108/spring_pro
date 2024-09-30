package com.epam.petProject.dto;

public class WildPetDto extends PetDto{
    private String birthPlace;

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    @Override
    public String toString() {
        return "WildPetDto{" +
                "birthPlace='" + birthPlace + '\'' +
                '}'+getName() +" "+getId()+" "+" "+getPetType()+" "+getOwnerDto();

    }
}
