package org.example.model;

public class Tienda {

    private ProductoArray inventario;
    private VentasArray invetarioVentas;
    // ... Constructor ...

    public void realizarVenta(Venta venta){

        for (LineaVenta lv : venta.getLineasVenta()){
            this.inventario.disminuirProducto(lv.getProducto().getCodigo(),lv.getCantidad());
        }

        this.invetarioVentas.agregarVenta(venta);


    }

    public ProductoArray getInventario() {
        return inventario;
    }

    public void setInventario(ProductoArray inventario) {
        this.inventario = inventario;
    }

    public VentasArray getInvetarioVentas() {
        return invetarioVentas;
    }

    public void setInvetarioVentas(VentasArray invetarioVentas) {
        this.invetarioVentas = invetarioVentas;
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "inventario=" + inventario +
                ", invetarioVentas=" + invetarioVentas +
                '}';
    }
}
