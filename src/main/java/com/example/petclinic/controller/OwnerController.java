package com.example.petclinic.controller;

import com.example.petclinic.model.Owner;
import com.example.petclinic.service.OwnerService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OwnerController implements BasicController<Owner> {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {

        this.ownerService = ownerService;
    }

    @Override
    public Owner add(Owner owner) {

        return this.ownerService.add(owner);
    }

    @Override
    public Owner get(Long id) {

        return this.ownerService.get(id);
    }

    @Override
    public Owner modify(Owner owner) {

        return this.ownerService.modify(owner);
    }

    @Override
    public boolean delete(Owner owner) {

        return this.ownerService.delete(owner);
    }

    @Override
    public List<Owner> getAll() {

        return this.ownerService.getAll();
    }

}
