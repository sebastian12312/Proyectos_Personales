/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author sebastian
 */
public class ComprasUsuario {
    private String CodigoCompra;
    private String codigoUsuario;
    private double SubTotal;
    private double DescuentoCompra;
    private double IGVCompra;
    private double PrecioFInal;
    private String FechaCompra;
    private String EstadoCompra;

    public ComprasUsuario() {
    }

    public ComprasUsuario(String CodigoCompra, String codigoUsuario, double SubTotal, double DescuentoCompra, double IGVCompra, double PrecioFInal, String FechaCompra, String EstadoCompra) {
        this.CodigoCompra = CodigoCompra;
        this.codigoUsuario = codigoUsuario;
        this.SubTotal = SubTotal;
        this.DescuentoCompra = DescuentoCompra;
        this.IGVCompra = IGVCompra;
        this.PrecioFInal = PrecioFInal;
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
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(double SubTotal) {
        this.SubTotal = SubTotal;
    }

    public double getDescuentoCompra() {
        return DescuentoCompra;
    }

    public void setDescuentoCompra(double DescuentoCompra) {
        this.DescuentoCompra = DescuentoCompra;
    }

    public double getIGVCompra() {
        return IGVCompra;
    }

    public void setIGVCompra(double IGVCompra) {
        this.IGVCompra = IGVCompra;
    }

    public double getPrecioFInal() {
        return PrecioFInal;
    }

    public void setPrecioFInal(double PrecioFInal) {
        this.PrecioFInal = PrecioFInal;
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
