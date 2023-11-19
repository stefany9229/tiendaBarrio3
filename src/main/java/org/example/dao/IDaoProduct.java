package org.example.dao;

import org.example.model.Product;

import java.io.IOException;
import java.util.List;

public interface IDaoProduct<T> extends IDao<T>{

    Product update(Integer porductId, Product product) throws Exception;

    List<T> findByNameProduct(String productName) ;
}
