package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class ProductoArray {
    private List<ProductoInventario> productosInventario;

    public ProductoArray() {
        this.productosInventario=new ArrayList<>();
    }

    public List<ProductoInventario> obtenerListadoProducto() {
        return productosInventario;
    }


    public Producto consultarProducto(String nombre) {
        for (ProductoInventario producto : productosInventario) {
            if (producto.getNombre().equals(nombre)) {
                return producto;
            }
        }
        return null; // Devuelve null si no encuentra el producto con ese nombre
    }

    public Producto consultarProducto(int codigo) {
        for (ProductoInventario producto : productosInventario) {
            if (producto.getCodigo() == codigo) {
                return producto;
            }
        }
        return null; // Devuelve null si no encuentra el producto con ese código
    }


    public void eliminarProducto(String productoString) {

        Producto product = this.consultarProducto(productoString);
        productosInventario.remove(product);
    }

    public void eliminarProducto(int codigo) {

        Producto product = this.consultarProducto(codigo);
        productosInventario.remove(product);
    }



    public void agregarProducto(ProductoInventario producto) {
        productosInventario.add(producto);
    }

    public void eliminarProducto(ProductoInventario producto) {
        productosInventario.remove(producto);
    }

    public ProductoInventario actualizarProducto(ProductoInventario producto) {
        for (int i = 0; i < productosInventario.size(); i++) {
            if (productosInventario.get(i).getCodigo() == producto.getCodigo()) {
                productosInventario.set(i, producto);
                return producto;
            }
        }
        return null; // Devuelve null si no encuentra el producto para actualizar

    }


    public boolean disminuirProducto(int codigo, int cantidad) {
        for (ProductoInventario producto : productosInventario) {
            if (producto.getCodigo() == codigo) {
                if (producto.getCantidad() < cantidad) {
                    return false; // No hay suficiente producto en el inventario para disminuir
                }
                producto.setCantidad(producto.getCantidad() - cantidad);
                return true; // Se disminuyó exitosamente
            }
        }
        return false; // No se encontró el producto con ese código
    }

    public void setProductosInventario(List<ProductoInventario> productosInventario) {
        this.productosInventario = productosInventario;
    }

    public List<ProductoInventario> getProductosInventario() {
        return productosInventario;
    }

    @Override
    public String toString() {
        String resulttoString="ProdcutArray{ ";

        for (ProductoInventario producto : productosInventario) {

            String productoString=
                    "ProductoInventario{" +
                            "codigo='" +producto.getCodigo() +
                            ", nombre='" + producto.getNombre() +
                            ", precio:'" +producto.getPrecio() +
                            ", descripcion='" + producto.getDescripcion()+ '\'' +
                            ", categoria='" + producto.getCategoria() + '\'' +
                            ", urlFoto='" + producto.getUrlFoto() + '\'' +
                            ", cantidad=" + producto.getCantidad() +
                            '}' + "\n";

                resulttoString +=productoString;
            }

        resulttoString +="}";


        return resulttoString;

        }



    }


