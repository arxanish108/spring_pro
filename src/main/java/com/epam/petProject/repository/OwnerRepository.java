package com.epam.petProject.repository;

import com.epam.petProject.dto.OwnerDto;
import com.epam.petProject.exception.DuplicateOwnerIdException;
import com.epam.petProject.exception.OwnerFoundException;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository{
    void save(OwnerDto ownerDto) ;
    Optional<OwnerDto> findById(int ownerId);
    void updatePetDetails(int ownerId,String petName);
    void deleteById(int ownerId);
    List<OwnerDto> findAll();
}
