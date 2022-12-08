/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author sebastian
 */
public class Productos {
    private String CodigoProducto;
    private String NombreProducto;
    private String DescripcionProducto;
    private int CantidadProducto;
    private double PrecioUnidadProducto;
    private double DescuentoProducto;
    private String ImagenProducto;
    private String EstadoProducto;

    public Productos() {
    }

    public Productos(String CodigoProducto, String NombreProducto, String DescripcionProducto, int CantidadProducto, double PrecioUnidadProducto, double DescuentoProducto, String ImagenProducto, String EstadoProducto) {
        this.CodigoProducto = CodigoProducto;
        this.NombreProducto = NombreProducto;
        this.DescripcionProducto = DescripcionProducto;
        this.CantidadProducto = CantidadProducto;
        this.PrecioUnidadProducto = PrecioUnidadProducto;
        this.DescuentoProducto = DescuentoProducto;
        this.ImagenProducto = ImagenProducto;
        this.EstadoProducto = EstadoProducto;
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

    public double getPrecioUnidadProducto() {
        return PrecioUnidadProducto;
    }

    public void setPrecioUnidadProducto(double PrecioUnidadProducto) {
        this.PrecioUnidadProducto = PrecioUnidadProducto;
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
    
    
}
