package com.epam.petProject.util;

import com.epam.petProject.dto.DomesticPetDto;
import com.epam.petProject.dto.OwnerDto;
import com.epam.petProject.dto.PetDto;
import com.epam.petProject.dto.WildPetDto;
import com.epam.petProject.enumm.Gender;
import com.epam.petProject.enumm.PetType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class InputUtil {
    private InputUtil() {

    }

    public static int acceptMenuOption(Scanner scanner) {
        System.out.println("Press 1 to add new owner.");
        System.out.println("Press 2 to fetch owner details.");
        System.out.println("Press 3 to updated pet details of owner.");
        System.out.println("Press 4 to delete owner details.");
        System.out.println("Press 5 to fetch all owners.");
        System.out.println("Press 6 to fetch pet details.");
        int menuOption = scanner.nextInt();
        if (menuOption == 1 || menuOption == 2 || menuOption == 3 || menuOption == 4 || menuOption == 5
                || menuOption == 6) {
            return menuOption;
        } else {
            System.out.println("Invalid option entered.");
            return acceptMenuOption(scanner);
        }
    }

    public static boolean wantToContinue(Scanner scanner) {
        System.out.println("Press Y to continue and N to exit.");
        char choice = scanner.next().toUpperCase().charAt(0);
        return 'Y' == choice;
    }

    public static OwnerDto acceptOwnerDetailsToSave(Scanner scanner) {
        System.out.println("Enter id of owner:");
        int id = scanner.nextInt();
        System.out.println("Enter first name of owner:");
        String firstName = scanner.next();
        System.out.println("Enter last name of owner:");
        String lastName = scanner.next();
        System.out.println("Enter gender of owner:" + Arrays.asList(Gender.values()).toString());
        String gender = scanner.next().toUpperCase();
        System.out.println("Enter city of owner:");
        String city = scanner.next();
        System.out.println("Enter state of owner:");
        String state = scanner.next();
        System.out.println("Enter mobile number of owner:");
        String mobileNumber = scanner.next();
        System.out.println("Enter email id of owner:");
        String emailId = scanner.next();
        try {
            OwnerDto ownerDTO = new OwnerDto();
            ownerDTO.setId(id);
            ownerDTO.setFirstName(firstName);
            ownerDTO.setLastName(lastName);
            ownerDTO.setGender(Gender.valueOf(gender));
            ownerDTO.setCity(city);
            ownerDTO.setState(state);
            ownerDTO.setMobileNumber(mobileNumber);
            ownerDTO.setEmailId(emailId);
            return ownerDTO;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return acceptOwnerDetailsToSave(scanner);
        }
    }

    public static PetDto acceptPetDetailsToSave(Scanner scanner) {
        System.out.println("Enter id of pet:");
        int petId = scanner.nextInt();
        System.out.println("Enter name of pet:");
        String petName = scanner.next();
        System.out.println("Press D for domestic pet and W for wild pet.");
        char choice = scanner.next().toUpperCase().charAt(0);
        String petPlaceOfBirth = null;
        String petDateOfBirth = null;
        if ('W' == choice) {
            System.out.println("Enter place of birth of pet:");
            petPlaceOfBirth = scanner.next();
        } else if ('D' == choice) {
            System.out.println("Enter date of birth of pet (dd-MM-yyyy):");
            petDateOfBirth = scanner.next();
        }
        System.out.println("Enter gender of pet:" + Arrays.asList(Gender.values()).toString());
        String petGender = scanner.next().toUpperCase();
        System.out.println("Enter pet type:" + Arrays.asList(PetType.values()).toString());
        String petType = scanner.next().toUpperCase();
        try {
            PetDto petDTO = null;
            if ('D' == choice) {
                petDTO = new DomesticPetDto();
                ((DomesticPetDto) petDTO).setBirthdate(convertStringToDate(petDateOfBirth));
            } else if ('W' == choice) {
                petDTO = new WildPetDto();
                ((WildPetDto) petDTO).setBirthPlace(petPlaceOfBirth);
            } else {
                throw new IllegalArgumentException("Unsupported pet choice: " + choice);
            }
            petDTO.setId(petId);
            petDTO.setName(petName);
            petDTO.setGender(Gender.valueOf(petGender));
            petDTO.setPetType(PetType.valueOf(petType));
            return petDTO;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return acceptPetDetailsToSave(scanner);
        }
    }

    public static String acceptPetDetailsToUpdate(Scanner scanner) {
        System.out.println("Enter updated name of pet:");
        return scanner.next();
    }

    public static int acceptOwnerIdToOperate(Scanner scanner) {
        System.out.println("Enter id of owner:");
        return scanner.nextInt();
    }

    public static int acceptPetIdToOperate(Scanner scanner) {
        System.out.println("Enter id of pet:");
        return scanner.nextInt();
    }

    private static LocalDate convertStringToDate(String stringDate) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(stringDate, format);
    }
}
