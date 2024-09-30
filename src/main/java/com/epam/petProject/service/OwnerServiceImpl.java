package com.epam.petProject.service;

import com.epam.petProject.dto.OwnerDto;
import com.epam.petProject.exception.DuplicateOwnerIdException;
import com.epam.petProject.exception.OwnerFoundException;
import com.epam.petProject.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OwnerServiceImpl implements OwnerService{

    private final String ownerIdAlreadyExist;
    private final OwnerRepository ownerRepository;
    private final String ownerNotFound;

    public OwnerServiceImpl(@Value("${owner.already.exist}")String ownerIdAlreadyExist, OwnerRepository ownerRepository, @Value("${owner.not.found}") String ownerNotFound) {
        this.ownerIdAlreadyExist = ownerIdAlreadyExist;
        this.ownerRepository = ownerRepository;
        this.ownerNotFound = ownerNotFound;
    }

    @Override
    public void saveOwner(OwnerDto ownerDto) throws DuplicateOwnerIdException {
          if(ownerRepository.findById(ownerDto.getId()).isPresent()){
              throw new DuplicateOwnerIdException(String.format(ownerIdAlreadyExist,ownerDto.getId()));
          }else {
              ownerRepository.save(ownerDto);
          }
    }

    @Override
    public OwnerDto findOwner(int ownerId) throws OwnerFoundException {
        return  ownerRepository.findById(ownerId)
                .orElseThrow(() -> new OwnerFoundException(String.format(ownerNotFound,ownerId)));
    }

    @Override
    public void updatePetDetails(int ownerId, String petName) throws OwnerFoundException {
        ownerRepository.findById(ownerId).orElseThrow( () ->
             new OwnerFoundException(String.format(ownerIdAlreadyExist,ownerId)));
        ownerRepository.updatePetDetails(ownerId,petName);
    }

    @Override
    public void deleteOwner(int ownerId) throws OwnerFoundException {
        ownerRepository.findById(ownerId).orElseThrow( () ->
                new OwnerFoundException(String.format(ownerIdAlreadyExist,ownerId)));
        ownerRepository.deleteById(ownerId);
    }

    @Override
    public List<OwnerDto> findAllOwners() {
        return ownerRepository.findAll()  ;
    }
}
