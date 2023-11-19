package org.example.dao;

import org.example.exceptions.ResourceNotFound;
import org.example.model.Product;
import org.example.model.Sale;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DaoSalesCSV implements IDao<Sale>{

    private List<Sale> saleList;

    public DaoSalesCSV() {
        this.saleList= new ArrayList<>();
    }

    @Override
    public List<Sale> findAll() {
        return this.saleList;
    }

    @Override
    public Optional<Sale> findById(Integer id) {
        return this.saleList.stream()
                .filter(sale -> sale.getId().equals(id))
                .findFirst();
    }

    @Override
    public Sale save(Sale sale) {
        sale.setId(this.saleList.size()+1);
        this.saleList.add(sale);
        return sale;
    }

    @Override
    public void delete(Integer idSale) throws ResourceNotFound {
        Sale sale= findById(idSale)
                .orElseThrow(() -> new ResourceNotFound("SAle nof found,  ID: " + idSale));
        this.saleList.remove(sale);
    }

    @Override
    public Sale update(Integer id, Sale object) throws ResourceNotFound  {
        return null;
    }

}
