package org.example.model;

import java.util.ArrayList;
import java.util.List;



    public class VentasArray {
        private List<Venta> ventaList;

        // Constructor
        public VentasArray() {
            this.ventaList = new ArrayList<>();
        }

        // Métodos


        public double calcularVentasTotal() {
            double totalVentas = 0.0;
            for(Venta venta : ventaList) {
                totalVentas += venta.getTotal();
            }
            return totalVentas;
        }

        /**
         * Agrega una nueva venta a la lista de ventas.
         *
         * @param venta La venta que se desea agregar.
         */
        public void agregarVenta(Venta venta) {
            this.ventaList.add(venta);
        }

        // Getter para lineaVentas si es necesario

        public List<Venta> getLineaVentas() {
            return ventaList;
        }

        public List<Venta> getVentaList() {
            return ventaList;
        }

        @Override
        public String toString() {
            String resultado="VentasArray{";

            for(Venta venta: ventaList){
                resultado += (venta.toString() + "\n");
            }
            resultado += "}";
            return  resultado;
        }
    }
