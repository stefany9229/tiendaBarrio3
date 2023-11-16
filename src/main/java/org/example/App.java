package org.example;

import org.example.dao.DaoProductCSV;
import org.example.dao.IDao;
import org.example.model.Product;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){

        try {
            IDao invetarioCSV= new DaoProductCSV();
            //System.out.println(invetarioCSV.findAll());
            Product product= invetarioCSV.findById(12).orElse(null);
            product.setName("nuevo pordcuto en la Bd");
            System.out.println(invetarioCSV.save(product));

            //System.out.println(invetarioCSV.findById(120));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }
}
