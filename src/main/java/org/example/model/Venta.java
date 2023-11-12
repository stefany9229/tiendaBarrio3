package org.example.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venta {
    private int id;
    private Date fecha;
    private double total;
    private List<LineaVenta> lineasVenta;

    // Constructor
    public Venta() {
        this.fecha = new Date(); // Establecer la fecha actual al crear una venta
        this.lineasVenta = new ArrayList<>();
        this.total = 0.0;
    }

    // Métodos

    public void agregarProducto(Producto p, int cantidad) {
        LineaVenta nuevaLinea = new LineaVenta(p, cantidad);
        nuevaLinea.setSubtotal(nuevaLinea.getSubtotal());
        this.lineasVenta.add(nuevaLinea);
        actualizarTotal();
    }

    public double calcularTotal() {
        double suma = 0.0;
        for(LineaVenta lv : lineasVenta) {
            suma += lv.getSubtotal();
        }
        this.total = suma;
        return total;
    }

    public List<LineaVenta> getLineasVenta() {
        return lineasVenta;
    }

    public double calcularImpuesto() {
        // Suponiendo un impuesto del 15% como ejemplo
        return total * 0.15;
    }

    // Esto se asume como un método privado para ajustar el total después de agregar un producto
    private void actualizarTotal() {
        this.total = calcularTotal();
    }

    // Supongo que este método está destinado a ser utilizado en situaciones específicas, dado que tiene el símbolo "#"
    protected void setLineasVenta(List<LineaVenta> lineas) {
        this.lineasVenta = lineas;
        actualizarTotal();
    }

    // Getters y Setters para los demás atributos si es necesario

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {

        String listlv= "";

        for(LineaVenta lv : this.getLineasVenta()){
            listlv += (lv.toString());
        }
        listlv +="}";

        return "Venta{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", total=" + total +
                //",lineasVenta={"+ listlv + "}" +
                '}';
    }
}
