package com.example.petclinic.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Visit implements Modifiable {

    private int id;
    private Date dateOfVisit;
    private String description;

    // associations
    private Pet pet;
    private List<Vet> vets;

    protected Visit() {

    }

    public Visit(int id) {
        this.id = id;
    }

    public Visit(int id, Date dateOfVisit, String description, Pet pet) {
        this.id = id;
        this.dateOfVisit = dateOfVisit;
        this.description = description;
        this.pet = pet;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(Date dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Vet getVet(Vet vet) {
        return this.vets.get(vets.indexOf(vet));
    }

    public void addVet(Vet vet) {
        this.vets.add(vet);
    }

    public List<Vet> getAllVets() {
        return this.vets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return Objects.equals(id, visit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Visit{");
        sb.append("id=").append(id);
        sb.append(", dateOfVisit=").append(dateOfVisit);
        sb.append(", description='").append(description).append('\'');
        sb.append(", pet=").append(pet);
        sb.append(", vets=").append(vets);
        sb.append('}');
        return sb.toString();
    }
}
