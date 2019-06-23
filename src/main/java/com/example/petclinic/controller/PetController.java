package com.example.petclinic.controller;


import com.example.petclinic.model.Owner;
import com.example.petclinic.model.Pet;
import com.example.petclinic.service.PetService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PetController {

    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    public Pet savePet(Pet pet) {

        Pet result = this.petService.savePet(pet);
        return result;
    }

    public Pet getPet(Long id) {

        Pet result = this.petService.getPet(id);
        return result;
    }

    public Pet modifyPet(Pet pet) {

        Pet result = this.petService.modifyPet(pet);
        return result;
    }

    public boolean deletePet(Pet pet) {

        boolean result = this.petService.deletePet(pet);
        return result;
    }


    public List<Pet> getAllPets() {

        List<Pet> result = this.petService.getAll();
        return result;

    }

    public Object getAllPetsForOwner(Owner owner) {
        return this.petService.getAllPetsForOwner(owner);
    }
}
