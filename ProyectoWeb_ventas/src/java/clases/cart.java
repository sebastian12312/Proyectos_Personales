/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author sebastian
 */
public class cart {
    private String CodigoCarrito;
    private String NombreProducto;
    private String DescricionCarrito;
    private int CantidadCompra;
    private Double PrecioUnidad;
    private Double DescuentoProducto;    
    private Double SubTotal;
    private String ImagenProducto;

    public cart() {
    }

    public cart(String CodigoCarrito, String NombreProducto, String DescricionCarrito, int CantidadCompra, Double PrecioUnidad, Double DescuentoProducto, Double SubTotal, String ImagenProducto) {
        this.CodigoCarrito = CodigoCarrito;
        this.NombreProducto = NombreProducto;
        this.DescricionCarrito = DescricionCarrito;
        this.CantidadCompra = CantidadCompra;
        this.PrecioUnidad = PrecioUnidad;
        this.DescuentoProducto = DescuentoProducto;
        this.SubTotal = SubTotal;
        this.ImagenProducto = ImagenProducto;
    }

    public String getCodigoCarrito() {
        return CodigoCarrito;
    }

    public void setCodigoCarrito(String CodigoCarrito) {
        this.CodigoCarrito = CodigoCarrito;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public String getDescricionCarrito() {
        return DescricionCarrito;
    }

    public void setDescricionCarrito(String DescricionCarrito) {
        this.DescricionCarrito = DescricionCarrito;
    }

    public int getCantidadCompra() {
        return CantidadCompra;
    }

    public void setCantidadCompra(int CantidadCompra) {
        this.CantidadCompra = CantidadCompra;
    }

    public Double getPrecioUnidad() {
        return PrecioUnidad;
    }

    public void setPrecioUnidad(Double PrecioUnidad) {
        this.PrecioUnidad = PrecioUnidad;
    }

    public Double getDescuentoProducto() {
        return DescuentoProducto;
    }

    public void setDescuentoProducto(Double DescuentoProducto) {
        this.DescuentoProducto = DescuentoProducto;
    }

    public Double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(Double SubTotal) {
        this.SubTotal = SubTotal;
    }

    public String getImagenProducto() {
        return ImagenProducto;
    }

    public void setImagenProducto(String ImagenProducto) {
        this.ImagenProducto = ImagenProducto;
    }
    
    
}
