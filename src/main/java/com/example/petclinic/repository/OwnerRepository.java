package com.example.petclinic.repository;

import com.example.petclinic.model.Owner;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OwnerRepository extends BasicRepository implements CrudRepository<Owner> {

    @Override
    public Owner create(Owner owner) {

        return this.fakeDatabase.save(owner);
    }

    @Override
    public Owner read(Owner owner) {

        return this.fakeDatabase.get(owner);
    }

    @Override
    public Owner update(Owner owner) {

        return this.fakeDatabase.modify(owner);
    }

    @Override
    public boolean delete(Owner owner) {

        return this.fakeDatabase.delete(owner);
    }

    @Override
    public List<Owner> getAll() {

        return this.fakeDatabase.getAll(Owner.class.getSimpleName().toLowerCase());
    }

}
