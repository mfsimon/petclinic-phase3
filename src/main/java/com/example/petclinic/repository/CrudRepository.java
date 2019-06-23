package com.example.petclinic.repository;

import java.util.List;

public interface CrudRepository<T> {

    T create(T t);

    T read(T t);

    T update(T t);

    boolean delete(T t);

    List<T> getAll();

}
