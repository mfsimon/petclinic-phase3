package com.example.petclinic.model;


import java.util.List;
import java.util.Objects;

public class Vet implements Modifiable {

    private Long id;
    private String name;
    private List<Speciality> specialities;

    // associations
    private List<Visit> visits;

    protected Vet() {

    }

    public Vet(Long id) {

        this.id = id;
    }

    public Vet(Long id, String name, List<Speciality> specialities, List<Visit> visits) {

        this.id = id;
        this.name = name;
        this.specialities = specialities;
        this.visits = visits;
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

    public List<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(List<Speciality> specialities) {
        this.specialities = specialities;
    }

    // Update relationship between this Vet and visits
    public void addVisit(Visit visit) {

        addVisit(visit, true);
    }

    public void addVisit(Visit visit, Boolean updateRelationship) {

        this.visits.add(visit);
        if(updateRelationship) {
            visit.addVet(this, false);
        }
    }

    public void removeVisit(Visit visit) {
        removeVisit(visit, true);
    }

    public void removeVisit(Visit visit, Boolean updateRelationship) {

        this.visits.remove(visit);
        if(updateRelationship) {
            visit.removeVet(this, false);
        }
    }

    public List<Visit> getVisits() {

        return this.visits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vet vet = (Vet) o;
        return Objects.equals(id, vet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vet{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", specialities=").append(specialities);
        sb.append(", visits=").append(visits);
        sb.append('}');
        return sb.toString();
    }
}
