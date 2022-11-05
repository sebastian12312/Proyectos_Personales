/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author sebastian
 */
public class Producto {
    private String Codigo_Producto;
    private String Nombre_Producto;
    private String Descripcion_Producto;
    private int Cantidad_producto;
    private double PrecioUnidad_Producto;
    private double Descuento_Producto;
    private String Imagen_Producto;
    private String Estado_Producto;

    public Producto() {
    }
    
    public Producto(String Codigo_Producto, String Nombre_Producto, String Descripcion_Producto, int Cantidad_producto, double PrecioUnidad_Producto, double Descuento_Producto, String Imagen_Producto, String Estado_Producto) {
        this.Codigo_Producto = Codigo_Producto;
        this.Nombre_Producto = Nombre_Producto;
        this.Descripcion_Producto = Descripcion_Producto;
        this.Cantidad_producto = Cantidad_producto;
        this.PrecioUnidad_Producto = PrecioUnidad_Producto;
        this.Descuento_Producto = Descuento_Producto;
        this.Imagen_Producto = Imagen_Producto;
        this.Estado_Producto = Estado_Producto;
    }

    public String getCodigo_Producto() {
        return Codigo_Producto;
    }

    public void setCodigo_Producto(String Codigo_Producto) {
        this.Codigo_Producto = Codigo_Producto;
    }

    public String getNombre_Producto() {
        return Nombre_Producto;
    }

    public void setNombre_Producto(String Nombre_Producto) {
        this.Nombre_Producto = Nombre_Producto;
    }

    public String getDescripcion_Producto() {
        return Descripcion_Producto;
    }

    public void setDescripcion_Producto(String Descripcion_Producto) {
        this.Descripcion_Producto = Descripcion_Producto;
    }

    public int getCantidad_producto() {
        return Cantidad_producto;
    }

    public void setCantidad_producto(int Cantidad_producto) {
        this.Cantidad_producto = Cantidad_producto;
    }

    public double getPrecioUnidad_Producto() {
        return PrecioUnidad_Producto;
    }

    public void setPrecioUnidad_Producto(double PrecioUnidad_Producto) {
        this.PrecioUnidad_Producto = PrecioUnidad_Producto;
    }

    public double getDescuento_Producto() {
        return Descuento_Producto;
    }

    public void setDescuento_Producto(double Descuento_Producto) {
        this.Descuento_Producto = Descuento_Producto;
    }

    public String getImagen_Producto() {
        return Imagen_Producto;
    }

    public void setImagen_Producto(String Imagen_Producto) {
        this.Imagen_Producto = Imagen_Producto;
    }

    public String getEstado_Producto() {
        return Estado_Producto;
    }

    public void setEstado_Producto(String Estado_Producto) {
        this.Estado_Producto = Estado_Producto;
    }
    
    
    
}
