package org.example.model;

public class InventoryLine {

    private Product product;
    private Integer stock;


    public InventoryLine() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "InventoryLine{" +
                "product=" + product +
                ", stock=" + stock +
                '}';
    }
}
