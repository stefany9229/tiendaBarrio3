package org.example.model;
public class Producto implements Comparable {

    // Atributos
    private String nombre;
    private double precio;
    private int codigo;

    public Producto() {
    }

    // Constructor
    public Producto(String nombre, double precio, int codigo) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
    }

    // Getters y Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }



    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", codigo=" + codigo +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Producto otroProducto = (Producto) o;
        if (this.nombre.equals(otroProducto.nombre)) {
            return 0;
        }

        // Si los códigos son iguales, consideramos los productos iguales
        if (this.codigo == otroProducto.codigo) {
            return 0;
        }

        // En caso contrario, podemos ordenarlos por nombre como default
        // o por cualquier otro criterio
        return this.nombre.compareTo(otroProducto.nombre);


    }
}
