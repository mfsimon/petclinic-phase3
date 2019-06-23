package com.example.petclinic.controller;

import com.example.petclinic.model.Owner;
import com.example.petclinic.service.OwnerService;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Owner Controller
 */
@Controller
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    public Owner saveOwner(Owner owner) {

        Owner result = this.ownerService.saveOwner(owner);
        return result;
    }

    public Owner getOwner(Long id) {

        Owner result = this.ownerService.getOwner(id);
        return result;
    }

    public Owner modifyOwner(Owner owner) {

        Owner result = this.ownerService.modifyOwner(owner);
        return result;
    }

    public boolean deleteOwner(Owner owner) {

        boolean result = this.ownerService.deleteOwner(owner);
        return result;
    }


    public List<Owner> getAllOwners() {

        List<Owner> result = this.ownerService.getAll();
        return result;

    }


}
