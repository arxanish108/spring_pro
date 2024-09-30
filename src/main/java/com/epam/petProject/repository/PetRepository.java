package com.epam.petProject.repository;

import com.epam.petProject.dto.OwnerDto;
import com.epam.petProject.dto.PetDto;

import java.util.Optional;

public interface PetRepository {
    Optional<PetDto> findById(int petId);
}
