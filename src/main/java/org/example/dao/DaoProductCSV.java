package org.example.dao;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.example.model.Product;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DaoProductCSV implements IDao {

    private List<Product> productList;
    private String filePath;

    private CSVParser parser;

    public DaoProductCSV()  {
        this.filePath = "src/main/resources/inventory.csv";
        this.productList = new ArrayList<>();

    }

    @Override
    public List<Product> findAll() throws IOException {
        // declaro el objeto para manipular el csv
        this.parser= CSVFormat.DEFAULT
                .withFirstRecordAsHeader() // Esto indica que la primera fila contiene los encabezados
                .parse(new FileReader(filePath));

        // estabelzco un contador para poner id
        int id= 1;

        // cargo los productos del CSV
        for (CSVRecord csvRecord : parser) {
            Product product = new Product();
            product.setName(csvRecord.get("Nombre")); // Usa el encabezado de la columna en lugar del índice
            product.setDescription(csvRecord.get("Descripcion"));
            product.setCategory(csvRecord.get("Categoria"));
            product.setTags(csvRecord.get("Etiquetas"));
            product.setImageUrl(csvRecord.get("URL FOTO"));

            String priceStr = csvRecord.get("Precio");
            product.setPrice(priceStr.isEmpty() ? null : Float.valueOf(priceStr));

            product.setId(id);
            id++;
            // Suponiendo que quieres imprimir el precio para verificar
            productList.add(product);
        }

        return this.productList;
    }


    @Override
    public Optional<Product> findById(Integer id) {

        return productList.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    @Override
    public Product save(Product product) {
        int lastId= this.productList.size();
        product.setId(lastId);
        this.productList.add(product);

        return productList.get(lastId);
    }

    @Override
    public void delete(Integer idProduct) throws Exception {

        Product product= findById(idProduct)
                .orElseThrow(() -> new Exception("Product nof found,  ID: " + idProduct));
       this.productList.remove(product);


    }
}