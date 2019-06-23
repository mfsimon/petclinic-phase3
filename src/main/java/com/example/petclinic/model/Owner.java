package com.example.petclinic.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class represents a pet owner.
 */
public class Owner implements Modifiable {

    private int id;
    private String name;
    private String address;
    private String city;
    private String phoneNumber;

    // associations
    private List<Pet> pets;


    public Owner(int id) {
        this.id = id;
    }

    public Owner(int id, String name, String address, String city, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.pets = new ArrayList<>();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Pet getPet(Pet pet) {
        return this.pets.get(pets.indexOf(pet));
    }

    public void addPet(Pet pet) {
        this.pets.add(pet);
    }

    public List<Pet> getAllPets() {
        return this.pets;
    }

    /*
    Only include id when generating equals and hashcode
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return id == owner.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Owner{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", pets=").append(pets);
        sb.append('}');
        return sb.toString();
    }
}
