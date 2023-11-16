package org.example.dao;

import org.example.model.Product;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IDao {

    List<Product> findAll() throws IOException;
  ;

    Optional<Product> findById(Integer id);

    Product save(Product product);
    void delete(Integer idProduct) throws Exception;

}

