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
    private String CodigoUsuario;
    private double SubTotalCompra;
    private double PrecioTotal;
    private String FechaCompra;
    private String EstadoCompra;

    public compras() {
    }

    public compras(String CodigoCompra, String CodigoUsuario, double SubTotalCompra, double PrecioTotal, String FechaCompra, String EstadoCompra) {
        this.CodigoCompra = CodigoCompra;
        this.CodigoUsuario = CodigoUsuario;
        this.SubTotalCompra = SubTotalCompra;
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

    public String getCodigoUsuario() {
        return CodigoUsuario;
    }

    public void setCodigoUsuario(String CodigoUsuario) {
        this.CodigoUsuario = CodigoUsuario;
    }

    public double getSubTotalCompra() {
        return SubTotalCompra;
    }

    public void setSubTotalCompra(double SubTotalCompra) {
        this.SubTotalCompra = SubTotalCompra;
    }

    public double getPrecioTotal() {
        return PrecioTotal;
    }

    public void setPrecioTotal(double PrecioTotal) {
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
