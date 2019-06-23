package com.example.petclinic.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Pet implements Modifiable {

    private int id;
    private String name;
    private Date birthDate;
    private PetType petType;

    // associations
    private Owner owner;
    private List<Visit> visits;

    public Pet(int id) {
        this.id = id;
    }

    public Pet(int id, String name, Date birthDate, PetType petType) {

        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.petType = petType;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Visit getVisit(Visit visit) {
        return visits.get(visits.indexOf(visit));
    }

    public void addVisit(Visit visit) {
        visits.add(visit);
    }

    public List<Visit> getAllVisits() {
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
        sb.append(", owner=").append(owner);
        sb.append(", visits=").append(visits);
        sb.append('}');
        return sb.toString();
    }
}
