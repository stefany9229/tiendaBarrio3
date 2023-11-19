package org.example.services;

import org.example.dao.DaoProductCSV;
import org.example.dao.IDao;
import org.example.exceptions.ResourceNotFound;
import org.example.model.Product;

public class ProductService {

    private IDao<Product> repositoryProduct;


    public ProductService(IDao<Product> repositoryPrduct) {
        this.repositoryProduct = repositoryPrduct;
    }

    public Product findById(Integer idProduct) throws ResourceNotFound {
        Product product=  repositoryProduct.findById(idProduct)
                .orElseThrow(() -> new ResourceNotFound("Product nof found,  ID: " + idProduct) );
        return product;
    }

}


