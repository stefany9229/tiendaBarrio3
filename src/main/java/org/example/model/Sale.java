package org.example.model;

import java.util.Date;
import java.util.List;

public class Sale {

    private Integer id;
    private Date fecha;
    private double total;
    private List<SalesLine> salesLines;


    public Integer getId() {
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

    public void setTotal(double total) {
        this.total = total;
    }

    public List<SalesLine> getSalesLines() {
        return salesLines;
    }

    public void setSalesLines(List<SalesLine> salesLines) {
        this.salesLines = salesLines;
    }
}
