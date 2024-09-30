package com.epam.petProject.service;

import com.epam.petProject.dto.OwnerDto;
import com.epam.petProject.exception.DuplicateOwnerIdException;
import com.epam.petProject.exception.OwnerFoundException;
import com.epam.petProject.exception.PetNotFoundException;

import java.util.List;

public interface OwnerService {
    void saveOwner(OwnerDto ownerDto) throws DuplicateOwnerIdException;
    OwnerDto findOwner(int ownerId) throws OwnerFoundException;
    void updatePetDetails(int ownerId,String petName) throws OwnerFoundException;
    void deleteOwner(int ownerId) throws OwnerFoundException;
    List<OwnerDto> findAllOwners();
}
