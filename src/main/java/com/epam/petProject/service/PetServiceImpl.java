package com.epam.petProject.service;

import com.epam.petProject.dto.PetDto;
import com.epam.petProject.exception.PetNotFoundException;
import com.epam.petProject.repository.PetRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements PetService{

    private final PetRepository petRepository;
    private final String petNotFound;

    public PetServiceImpl(PetRepository petRepository,@Value("${pet.not.found}")String petNotFound) {
        this.petRepository = petRepository;
        this.petNotFound = petNotFound;
    }

    @Override
    public PetDto findPet(int petId) throws PetNotFoundException {
        return petRepository.findById(petId).orElseThrow(() -> new PetNotFoundException(String.format(petNotFound,petId)));
    }
}
