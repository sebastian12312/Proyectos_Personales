/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author sebastian
 */
public class DetallesCompras {
    private String CodigoCompra;
    private String CodigoProducto;
    private String NombreProducto;
    private String DescripcionProducto;
    private int CantidadCompra;
    private Double PrecioProducto;
    private Double SubTotal;
    private Double descuentoCompra;

    public DetallesCompras() {
    }

    
    public DetallesCompras(String CodigoCompra, String CodigoProducto, String NombreProducto, String DescripcionProducto, int CantidadCompra, Double PrecioProducto, Double SubTotal, Double descuentoCompra) {
        this.CodigoCompra = CodigoCompra;
        this.CodigoProducto = CodigoProducto;
        this.NombreProducto = NombreProducto;
        this.DescripcionProducto = DescripcionProducto;
        this.CantidadCompra = CantidadCompra;
        this.PrecioProducto = PrecioProducto;
        this.SubTotal = SubTotal;
        this.descuentoCompra = descuentoCompra;
    }

    public String getCodigoCompra() {
        return CodigoCompra;
    }

    public void setCodigoCompra(String CodigoCompra) {
        this.CodigoCompra = CodigoCompra;
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

    public Double getPrecioProducto() {
        return PrecioProducto;
    }

    public void setPrecioProducto(Double PrecioProducto) {
        this.PrecioProducto = PrecioProducto;
    }

    public Double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(Double SubTotal) {
        this.SubTotal = SubTotal;
    }

    public Double getDescuentoCompra() {
        return descuentoCompra;
    }

    public void setDescuentoCompra(Double descuentoCompra) {
        this.descuentoCompra = descuentoCompra;
    }
    
    
}
