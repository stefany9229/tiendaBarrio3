package org.example;

import org.example.dao.DaoInvetoryCSV;
import org.example.dao.DaoProductCSV;
import org.example.dao.IDao;
import org.example.dao.IDaoProduct;
import org.example.exceptions.ResourceNotFound;
import org.example.model.InventoryLine;
import org.example.model.Product;
import org.example.services.InventoryService;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )  {


        try {
            InventoryService inventario= new InventoryService(new DaoProductCSV(),new DaoInvetoryCSV());
            //System.out.println(inventario.findByIdProduct(100004));
            System.out.println(inventario.findByProductName("leche"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
