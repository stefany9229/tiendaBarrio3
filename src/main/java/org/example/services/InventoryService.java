package org.example.services;

import org.example.dao.IDao;
import org.example.dao.IDaoProduct;
import org.example.exceptions.ResourceNotFound;
import org.example.model.InventoryLine;
import org.example.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InventoryService {

    private IDaoProduct<Product> productRepository;
    private IDaoProduct<InventoryLine> invetoryrRpository;

    public InventoryService() {
    }

    public InventoryService(IDaoProduct<Product> productRepository, IDaoProduct<InventoryLine> invetoryrRpository) {
        this.productRepository = productRepository;
        this.invetoryrRpository = invetoryrRpository;
    }

    public List<InventoryLine> findAll() {
        return this.invetoryrRpository.findAll();
    }

    public InventoryLine findByIdProduct(Integer idProduct) {
        List<InventoryLine> productsList =  invetoryrRpository.findAll();
        Optional<InventoryLine> productInvetory=  productsList.stream()
                                            .filter(product -> product.getProduct().getId().equals(idProduct))
                                            .findFirst();
        if( productInvetory.isPresent()){
            return productInvetory.get();
        }else{
            return null;
        }

    }

    public List <InventoryLine> findByProductName( String productName){
        return invetoryrRpository.findAll().stream()
                .filter(inventoryLine -> inventoryLine.getProduct().getName().contains(productName))
                .collect(Collectors.toList());
    }
}

