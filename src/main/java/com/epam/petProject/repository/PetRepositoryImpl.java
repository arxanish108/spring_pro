package com.epam.petProject.repository;

import com.epam.petProject.dto.DomesticPetDto;
import com.epam.petProject.dto.OwnerDto;
import com.epam.petProject.dto.PetDto;
import com.epam.petProject.dto.WildPetDto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.epam.petProject.enumm.Gender.F;
import static com.epam.petProject.enumm.Gender.M;
import static com.epam.petProject.enumm.PetType.CAT;
import static com.epam.petProject.enumm.PetType.DOG;

@Repository
public class PetRepositoryImpl implements PetRepository{
    private List<PetDto> petDtoList;

    public PetRepositoryImpl() {
        petDtoList = new ArrayList<>();
    }

    @PostConstruct
    public void init(){
        DomesticPetDto domesticPetDTO = new DomesticPetDto();
        domesticPetDTO.setId(1);
        domesticPetDTO.setName("Max");
        domesticPetDTO.setGender(M);
        domesticPetDTO.setPetType(DOG);
        domesticPetDTO.setBirthdate(LocalDate.of(2018, 7, 26));
        OwnerDto ownerDTO = new OwnerDto();
        ownerDTO.setId(1);
        ownerDTO.setFirstName("John");
        ownerDTO.setLastName("Doe");
        ownerDTO.setGender(M);
        ownerDTO.setCity("Hyderabad");
        ownerDTO.setState("Andhra Pradesh");
        ownerDTO.setMobileNumber("9009009001");
        ownerDTO.setEmailId("john.doe@abhishekvermaa10.com");
        domesticPetDTO.setOwnerDto(ownerDTO);
        petDtoList.add(domesticPetDTO);
        WildPetDto wildPetDTO = new WildPetDto();
        wildPetDTO.setId(2);
        wildPetDTO.setName("Fluffy");
        wildPetDTO.setGender(F);
        wildPetDTO.setPetType(CAT);
        wildPetDTO.setBirthPlace("Jim Corbett National Park");
        ownerDTO = new OwnerDto();
        ownerDTO.setId(2);
        ownerDTO.setFirstName("Jane");
        ownerDTO.setLastName("Smith");
        ownerDTO.setGender(F);
        ownerDTO.setCity("Vishakhapatnam");
        ownerDTO.setState("Andhra Pradesh");
        ownerDTO.setMobileNumber("9009009002");
        ownerDTO.setEmailId("jane.smith@abhishekvermaa10.com");
        wildPetDTO.setOwnerDto(ownerDTO);
        petDtoList.add(wildPetDTO);
    }

    @Override
    public Optional<PetDto> findById(int petId) {
        return petDtoList.stream().filter(pet -> pet.getId() == petId).findFirst();
    }
}
