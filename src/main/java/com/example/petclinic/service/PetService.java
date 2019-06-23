package com.example.petclinic.service;

import com.example.petclinic.model.Owner;
import com.example.petclinic.model.Pet;
import com.example.petclinic.repository.PetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private static final Logger logger = LoggerFactory.getLogger(PetService.class.getName());

    private PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet savePet(Pet pet) {
        return this.petRepository.save(pet);
    }

    public Pet getPet(Long id) {

        Optional optional = this.petRepository.findById(id);

        Pet pet = null;
        if (optional.isPresent()) {
            pet = (Pet) optional.get();
        } else {
            logger.warn(new StringBuilder().append("No pet exists for id [").append(id).append("].").toString());
        }

        return pet;
    }

    public Pet modifyPet(Pet pet) {
        return this.petRepository.save(pet);
    }

    public boolean deletePet(Pet pet) {
        this.petRepository.delete(pet);
        return true;
    }

    public List<Pet> getAll() {
        return (List<Pet>) this.petRepository.findAll();
    }

    public Object getAllPetsForOwner(Owner owner) {
        return this.petRepository.getAllPetsByOwner(owner);
    }
}
