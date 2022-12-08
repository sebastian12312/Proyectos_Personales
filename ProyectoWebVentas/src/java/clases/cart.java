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

    private int PosicionCarrito;
    private String CodigoProducto;
    private String NombreProducto;
    private String DescripcionProducto;
    private int CantidadProducto;
    private double PrecioProducto;
    private double DescuentoProducto;
    private double SubTotal;
    private String ImagenProducto;

    public cart() {
    }

    public cart(int PosicionCarrito, String CodigoProducto, String NombreProducto, String DescripcionProducto, int CantidadProducto, double PrecioProducto, double DescuentoProducto, double SubTotal, String ImagenProducto) {
        this.PosicionCarrito = PosicionCarrito;
        this.CodigoProducto = CodigoProducto;
        this.NombreProducto = NombreProducto;
        this.DescripcionProducto = DescripcionProducto;
        this.CantidadProducto = CantidadProducto;
        this.PrecioProducto = PrecioProducto;
        this.DescuentoProducto = DescuentoProducto;
        this.SubTotal = SubTotal;
        this.ImagenProducto = ImagenProducto;
    }

    public int getPosicionCarrito() {
        return PosicionCarrito;
    }

    public void setPosicionCarrito(int PosicionCarrito) {
        this.PosicionCarrito = PosicionCarrito;
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

    public int getCantidadProducto() {
        return CantidadProducto;
    }

    public void setCantidadProducto(int CantidadProducto) {
        this.CantidadProducto = CantidadProducto;
    }

    public double getPrecioProducto() {
        return PrecioProducto;
    }

    public void setPrecioProducto(double PrecioProducto) {
        this.PrecioProducto = PrecioProducto;
    }

    public double getDescuentoProducto() {
        return DescuentoProducto;
    }

    public void setDescuentoProducto(double DescuentoProducto) {
        this.DescuentoProducto = DescuentoProducto;
    }

    public double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(double SubTotal) {
        this.SubTotal = SubTotal;
    }

    public String getImagenProducto() {
        return ImagenProducto;
    }

    public void setImagenProducto(String ImagenProducto) {
        this.ImagenProducto = ImagenProducto;
    }

}
