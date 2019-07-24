package com.example.petclinic.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Pet implements Modifiable {

    private Long id;
    private String name;
    private Date birthDate;
    private PetType petType;

    // associations
    private Owner owner;
    private List<Visit> visits;

    public Pet(Long id) {

        this(id, null, null, null);
    }

    public Pet(Long id, String name, Date birthDate, PetType petType) {

        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.petType = petType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    // Update the relationship between Owner and Pet when adding an Owner
    public void addOwner(Owner owner) {

        addOwner(owner, true);
    }

    public void addOwner(Owner owner, Boolean updateRelationship) {

        this.owner = owner;
        if (updateRelationship) {
            owner.addPet(this, false);
        }
    }

    // Update the relationship between Owner and Pet when removing an Owner
    public void removeOwner(Owner owner) {

        removeOwner(owner, true);
    }

    public void removeOwner(Owner owner, Boolean updateRelationship) {

        this.owner = null;
        if (updateRelationship) {
            owner.removePet(this, false);
        }
    }

    // Update the relationship between Visit and Pet when adding a Visit
    public void addVisit(Visit visit) {

        addVisit(visit, true);
    }

    public void addVisit(Visit visit, Boolean updateRelationship) {

        visits.add(visit);
        if (updateRelationship) {
            visit.addPet(this, false);
        }
    }

    // Update the relationship between Visit and Pet when removing a Visit
    public void removeVisit(Visit visit) {

        removeVisit(visit, true);
    }

    public void removeVisit(Visit visit, Boolean updateRelationship) {

        visits.remove(visit);
        if (updateRelationship) {
            visit.removePet(this, false);
        }
    }

    public Owner getOwner() {
        return owner;
    }

    public List<Visit> getVisits() {
        return this.visits;
    }

    // only include id field when generating equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return id == pet.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pet{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", birthDate=").append(birthDate);
        sb.append(", petType=").append(petType);
        sb.append('}');
        return sb.toString();
    }
}
