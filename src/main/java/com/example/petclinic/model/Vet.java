package com.example.petclinic.model;


import java.util.List;
import java.util.Objects;

public class Vet implements Modifiable {


    private int id;
    private String name;
    private List<Speciality> specialities;

    // associations
    private List<Visit> visits;

    protected Vet() {

    }

    public Vet(int id) {

        this.id = id;
    }

    public Vet(int id, String name, List<Speciality> specialities, List<Visit> visits) {

        this.id = id;
        this.name = name;
        this.specialities = specialities;
        this.visits = visits;
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

    public List<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(List<Speciality> specialities) {
        this.specialities = specialities;
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
