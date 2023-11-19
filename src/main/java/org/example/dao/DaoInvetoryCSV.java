package org.example.dao;

import org.example.exceptions.ResourceNotFound;
import org.example.model.InventoryLine;
import org.example.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class DaoInvetoryCSV implements IDaoProduct<InventoryLine>{

    private List<InventoryLine> inventoryLineList;
    private DaoProductCSV daoProduct;

    public DaoInvetoryCSV() throws IOException {
        daoProduct= new DaoProductCSV();
        this.inventoryLineList=new ArrayList<>();
        this.startInventory();
    }

    public void startInventory() throws IOException {

        Random random = new Random();


            for (Product product: daoProduct.findAll()){

                InventoryLine inventoryLine= new InventoryLine();
                inventoryLine.setProduct(product);
                inventoryLine.setStock(random.nextInt(100) + 1);
                this.inventoryLineList.add(inventoryLine);

            }



    }
    @Override
    public List<InventoryLine> findAll()  {

        return this.inventoryLineList;
    }

    @Override
    public Optional<InventoryLine> findById(Integer id) {

        return inventoryLineList.stream()
                .filter(inventoryLine -> inventoryLine.getProduct().getId().equals(id))
                .findFirst();
    }

    @Override
    public InventoryLine save(InventoryLine inventoryLine) {

        this.inventoryLineList.add(inventoryLine);
        int lastId=this.inventoryLineList.size()-1;
        return this.inventoryLineList.get(lastId);
    }

    @Override
    public void delete(Integer idInvetoryLine) throws ResourceNotFound {

    }

    @Override
    public InventoryLine update(Integer id,InventoryLine object) {
        return null;
    }


    @Override
    public Product update(Integer porductId, Product product) throws Exception {
        return null;
    }

    @Override
    public List<InventoryLine> findByNameProduct(String productName) {
        return null;
    }
}
