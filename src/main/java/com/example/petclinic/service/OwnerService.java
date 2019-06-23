package com.example.petclinic.service;

import com.example.petclinic.model.Owner;
import com.example.petclinic.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService implements BasicService<Owner> {

    private OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {

        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner add(Owner owner) {

        return this.ownerRepository.create(owner);
    }

    @Override
    public Owner get(int id) {

        return this.ownerRepository.read(new Owner(id));
    }

    @Override
    public Owner modify(Owner owner) {

        return this.ownerRepository.update(owner);
    }

    @Override
    public boolean delete(Owner owner) {

        return this.ownerRepository.delete(owner);
    }

    @Override
    public List<Owner> getAll() {

        return ownerRepository.getAll();
    }


}
