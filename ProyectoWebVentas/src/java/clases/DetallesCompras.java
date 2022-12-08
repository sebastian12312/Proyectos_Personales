/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author sebastian
 */
public class DetallesCompras  extends compras{
    private String CodigoProducto;
    private String NombreProducto;
    private String DescripcionProducto;
    private int CantidadCompra;
    private double PrecioCompra;
    private double SubTotalCompraProducto;
    private double DescuentoCompra;

    public DetallesCompras() {
    }
    
    public DetallesCompras(String CodigoProducto, String NombreProducto, String DescripcionProducto, int CantidadCompra, double PrecioCompra, double SubTotalCompraProducto, double DescuentoCompra, String CodigoCompra, String CodigoUsuario, double SubTotalCompra, double PrecioTotal, String FechaCompra, String EstadoCompra) {
        super(CodigoCompra, CodigoUsuario, SubTotalCompra, PrecioTotal, FechaCompra, EstadoCompra);
        this.CodigoProducto = CodigoProducto;
        this.NombreProducto = NombreProducto;
        this.DescripcionProducto = DescripcionProducto;
        this.CantidadCompra = CantidadCompra;
        this.PrecioCompra = PrecioCompra;
        this.SubTotalCompraProducto = SubTotalCompraProducto;
        this.DescuentoCompra = DescuentoCompra;
    }

    public String getCodigoProducto() {
        return CodigoProducto;
    }

    public void setCodigoProducto(String CodigoProducto) {
        this.CodigoProducto = CodigoProducto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public String getDescripcionProducto() {
        return DescripcionProducto;
    }

    public void setDescripcionProducto(String DescripcionProducto) {
        this.DescripcionProducto = DescripcionProducto;
    }

    public int getCantidadCompra() {
        return CantidadCompra;
    }

    public void setCantidadCompra(int CantidadCompra) {
        this.CantidadCompra = CantidadCompra;
    }

    public double getPrecioCompra() {
        return PrecioCompra;
    }

    public void setPrecioCompra(double PrecioCompra) {
        this.PrecioCompra = PrecioCompra;
    }

    public double getSubTotalCompraProducto() {
        return SubTotalCompraProducto;
    }

    public void setSubTotalCompraProducto(double SubTotalCompraProducto) {
        this.SubTotalCompraProducto = SubTotalCompraProducto;
    }

    public double getDescuentoCompra() {
        return DescuentoCompra;
    }

    public void setDescuentoCompra(double DescuentoCompra) {
        this.DescuentoCompra = DescuentoCompra;
    }

    
}
