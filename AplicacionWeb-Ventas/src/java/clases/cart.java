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
    private String Codigo_Producto_Cart;
    private String Nombre_Producto_Cart;
    private String Descripcion_Producto_Cart;
    private int Cantidad_Producto_Cart;
    private double Precio_Producto_cart;
    private double Descuento_Producto_Cart;
    private String Imagen_Producto_Cart;
    private double SubTotal_Producto_Cart;

    public cart() {
    }

    public cart(String Codigo_Producto_Cart, String Nombre_Producto_Cart, String Descripcion_Producto_Cart, int Cantidad_Producto_Cart, double Precio_Producto_cart, double Descuento_Producto_Cart, String Imagen_Producto_Cart, double SubTotal_Producto_Cart) {
        this.Codigo_Producto_Cart = Codigo_Producto_Cart;
        this.Nombre_Producto_Cart = Nombre_Producto_Cart;
        this.Descripcion_Producto_Cart = Descripcion_Producto_Cart;
        this.Cantidad_Producto_Cart = Cantidad_Producto_Cart;
        this.Precio_Producto_cart = Precio_Producto_cart;
        this.Descuento_Producto_Cart = Descuento_Producto_Cart;
        this.Imagen_Producto_Cart = Imagen_Producto_Cart;
        this.SubTotal_Producto_Cart = SubTotal_Producto_Cart;
    }

    public String getCodigo_Producto_Cart() {
        return Codigo_Producto_Cart;
    }

    public void setCodigo_Producto_Cart(String Codigo_Producto_Cart) {
        this.Codigo_Producto_Cart = Codigo_Producto_Cart;
    }

    public String getNombre_Producto_Cart() {
        return Nombre_Producto_Cart;
    }

    public void setNombre_Producto_Cart(String Nombre_Producto_Cart) {
        this.Nombre_Producto_Cart = Nombre_Producto_Cart;
    }

    public String getDescripcion_Producto_Cart() {
        return Descripcion_Producto_Cart;
    }

    public void setDescripcion_Producto_Cart(String Descripcion_Producto_Cart) {
        this.Descripcion_Producto_Cart = Descripcion_Producto_Cart;
    }

    public int getCantidad_Producto_Cart() {
        return Cantidad_Producto_Cart;
    }

    public void setCantidad_Producto_Cart(int Cantidad_Producto_Cart) {
        this.Cantidad_Producto_Cart = Cantidad_Producto_Cart;
    }

    public double getPrecio_Producto_cart() {
        return Precio_Producto_cart;
    }

    public void setPrecio_Producto_cart(double Precio_Producto_cart) {
        this.Precio_Producto_cart = Precio_Producto_cart;
    }

    public double getDescuento_Producto_Cart() {
        return Descuento_Producto_Cart;
    }

    public void setDescuento_Producto_Cart(double Descuento_Producto_Cart) {
        this.Descuento_Producto_Cart = Descuento_Producto_Cart;
    }

    public String getImagen_Producto_Cart() {
        return Imagen_Producto_Cart;
    }

    public void setImagen_Producto_Cart(String Imagen_Producto_Cart) {
        this.Imagen_Producto_Cart = Imagen_Producto_Cart;
    }

    public double getSubTotal_Producto_Cart() {
        return SubTotal_Producto_Cart;
    }

    public void setSubTotal_Producto_Cart(double SubTotal_Producto_Cart) {
        this.SubTotal_Producto_Cart = SubTotal_Producto_Cart;
    }

    
    
}
