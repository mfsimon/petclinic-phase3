package com.example.petclinic.service;

import com.example.petclinic.model.Owner;
import com.example.petclinic.repository.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Owner Service
 */
@Service
public class OwnerService {

    private static final Logger logger = LoggerFactory.getLogger(OwnerService.class.getName());

    private OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    /**
     * Basic create operation.
     *
     * @param owner
     * @return
     */
    public Owner saveOwner(Owner owner) {

        Owner result = this.ownerRepository.save(owner);
        return result;
    }

    /**
     * Basic read operation.
     *
     * @param id
     * @return
     */
    public Owner getOwner(Long id) {

        Optional optional = this.ownerRepository.findById(id);

        Owner owner = null;
        if (optional.isPresent()) {
            owner = (Owner) optional.get();
        } else {
            logger.warn(new StringBuilder().append("No owner exists for id [").append(id).append("].").toString());
        }

        return owner;

    }

    /**
     * Basic update operation.
     *
     * @param owner
     * @return
     */
    public Owner modifyOwner(Owner owner) {

        Owner result = this.ownerRepository.save(owner);
        return result;
    }

    /**
     * Basic delete operation.
     *
     * @param owner
     * @return
     */
    public boolean deleteOwner(Owner owner) {

        // delete return type is void from the repository
        // we hardcode the boolean return value here
        this.ownerRepository.delete(owner);
        return true;
    }

    /**
     * Specific type of
     *
     * @return
     */
    public List<Owner> getAll() {

        // A narrowing cast is required because the findAll method returns an Iterable<Owner> object
        List<Owner> result = (List<Owner>) ownerRepository.findAll();
        return result;
    }


}
