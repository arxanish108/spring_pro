package com.epam.petProject.service;

import com.epam.petProject.dto.PetDto;
import com.epam.petProject.exception.PetNotFoundException;

public interface PetService {
    PetDto findPet(int petId) throws PetNotFoundException;
}
