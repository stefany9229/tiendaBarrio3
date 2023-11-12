package org.example.model;

public class ProductoInventario extends Producto {
    private String descripcion;
    private String categoria;
    private String urlFoto;
    private int cantidad;

    public ProductoInventario() {
    }

    public ProductoInventario(String nombre, double precio, int codigo, String descripcion, String categoria, String urlFoto, int cantidad) {
        super(nombre, precio, codigo);
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.urlFoto = urlFoto;
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }



}