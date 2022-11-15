/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author sebastian
 */
public class compras {
    private String CodigoCompra;
    private String CodigoUsuasrio;
    private Double SubTotal;
    private Double PrecioTotal;
    private String FechaCompra;
    private String EstadoCompra;

    public compras() {
    }

    public compras(String CodigoCompra, String CodigoUsuasrio, Double SubTotal, Double PrecioTotal, String FechaCompra, String EstadoCompra) {
        this.CodigoCompra = CodigoCompra;
        this.CodigoUsuasrio = CodigoUsuasrio;
        this.SubTotal = SubTotal;
        this.PrecioTotal = PrecioTotal;
        this.FechaCompra = FechaCompra;
        this.EstadoCompra = EstadoCompra;
    }

    public String getCodigoCompra() {
        return CodigoCompra;
    }

    public void setCodigoCompra(String CodigoCompra) {
        this.CodigoCompra = CodigoCompra;
    }

    public String getCodigoUsuasrio() {
        return CodigoUsuasrio;
    }

    public void setCodigoUsuasrio(String CodigoUsuasrio) {
        this.CodigoUsuasrio = CodigoUsuasrio;
    }

    public Double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(Double SubTotal) {
        this.SubTotal = SubTotal;
    }

    public Double getPrecioTotal() {
        return PrecioTotal;
    }

    public void setPrecioTotal(Double PrecioTotal) {
        this.PrecioTotal = PrecioTotal;
    }

    public String getFechaCompra() {
        return FechaCompra;
    }

    public void setFechaCompra(String FechaCompra) {
        this.FechaCompra = FechaCompra;
    }

    public String getEstadoCompra() {
        return EstadoCompra;
    }

    public void setEstadoCompra(String EstadoCompra) {
        this.EstadoCompra = EstadoCompra;
    }
    
}
