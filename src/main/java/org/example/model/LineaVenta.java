package org.example.model;

public class LineaVenta {
    private Producto producto;
    private int cantidad;
    private double subtotal;

    public LineaVenta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;

    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        double subtotal_=(this.cantidad * this.producto.getPrecio());
        return subtotal_;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "LineaVenta{" +
                "producto=" + producto.getNombre() +
                ", cantidad=" + cantidad +
                ", subtotal=" + subtotal +
                '}';
    }
}