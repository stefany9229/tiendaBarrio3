package org.example.dao;

import org.example.exceptions.ResourceNotFound;
import org.example.model.Product;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IDao<T> {

    List<T> findAll() ;

    Optional<T> findById(Integer id);

    T save(T object);

    void delete(Integer id) throws ResourceNotFound;

    T update(Integer id, T object)throws ResourceNotFound;

}