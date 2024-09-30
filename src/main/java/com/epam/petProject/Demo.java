package com.epam.petProject;

import com.epam.petProject.dto.OwnerDto;
import com.epam.petProject.dto.PetDto;
import com.epam.petProject.service.OwnerService;
import com.epam.petProject.service.PetService;
import com.epam.petProject.util.InputUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@PropertySource("classpath:mess.properties")
public class Demo implements CommandLineRunner {

	private final OwnerService ownerService;
	private final PetService petService;
	private static final Logger LOGGER = LoggerFactory.getLogger(Demo.class);


	public Demo(OwnerService ownerService, PetService petService) {
        this.ownerService = ownerService;
        this.petService = petService;
    }


    public static void main(String[] args) {
		SpringApplication.run(Demo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try (Scanner scanner = new Scanner(System.in)) {
			do {
				System.out.println("Welcome to Petistaan");
				int menuOption = InputUtil.acceptMenuOption(scanner);
				switch (menuOption) {
					case 1:
						OwnerDto ownerDTO = InputUtil.acceptOwnerDetailsToSave(scanner);
						PetDto petDTO = InputUtil.acceptPetDetailsToSave(scanner);
						ownerDTO.setPetDto(petDTO);
						ownerService.saveOwner(ownerDTO);
						System.out.println("Owner has been saved successfully.");
						break;
					case 2:
						int ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
						ownerDTO = ownerService.findOwner(ownerId);
						System.out.println("Owner has been fetched successfully.");
						System.out.println(ownerDTO);
						break;
					case 3:
						ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
						String petName = InputUtil.acceptPetDetailsToUpdate(scanner);
						ownerService.updatePetDetails(ownerId, petName);
						System.out.println("Pet details of owner have been updated successfully.");
						break;
					case 4:
						ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
						ownerService.deleteOwner(ownerId);
						System.out.println("Owner has been deleted successfully.");
						break;
					case 5:
						List<OwnerDto> ownerDTOList = ownerService.findAllOwners();
						System.out.println("There are " + ownerDTOList.size() + " owners.");
						ownerDTOList.forEach(System.out::println);
						break;
					case 6:
						int petId = InputUtil.acceptPetIdToOperate(scanner);
						petDTO = petService.findPet(petId);
						System.out.println("Pet has been fetched successfully.");
						System.out.println(petDTO);
						break;
					default:
						System.out.println("Invalid option entered.");
				}
			} while (InputUtil.wantToContinue(scanner));
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
	}
}
