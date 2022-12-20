/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author sebastian
 */
public class producto {
    private String CodigProducto;
    private String NombreProducto;
    private String DescripcionProducto;
    private int CantidadProducto;
    private double PrecioProducto;
    private double DescuentoProducto;
    private String ImagenProducto;
    private String EstadoProducto;
    private String CategoriaProducto;

    public producto() {
    }

    public producto(String CodigProducto, String NombreProducto, String DescripcionProducto, int CantidadProducto, double PrecioProducto, double DescuentoProducto, String ImagenProducto, String EstadoProducto, String CategoriaProducto) {
        this.CodigProducto = CodigProducto;
        this.NombreProducto = NombreProducto;
        this.DescripcionProducto = DescripcionProducto;
        this.CantidadProducto = CantidadProducto;
        this.PrecioProducto = PrecioProducto;
        this.DescuentoProducto = DescuentoProducto;
        this.ImagenProducto = ImagenProducto;
        this.EstadoProducto = EstadoProducto;
        this.CategoriaProducto = CategoriaProducto;
    }

    public String getCodigProducto() {
        return CodigProducto;
    }

    public void setCodigProducto(String CodigProducto) {
        this.CodigProducto = CodigProducto;
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

    public String getImagenProducto() {
        return ImagenProducto;
    }

    public void setImagenProducto(String ImagenProducto) {
        this.ImagenProducto = ImagenProducto;
    }

    public String getEstadoProducto() {
        return EstadoProducto;
    }

    public void setEstadoProducto(String EstadoProducto) {
        this.EstadoProducto = EstadoProducto;
    }

    public String getCategoriaProducto() {
        return CategoriaProducto;
    }

    public void setCategoriaProducto(String CategoriaProducto) {
        this.CategoriaProducto = CategoriaProducto;
    }
    
    
}
