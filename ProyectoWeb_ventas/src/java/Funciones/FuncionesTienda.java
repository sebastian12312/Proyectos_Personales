/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import conexionBD.SQLSever;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import clases.Producto;
public class FuncionesTienda {
    PreparedStatement ps;
    ResultSet rs;
    public List Tienda(){
        ArrayList<Producto> ListarTienda = new ArrayList<>();
        try {
            String Condicion = "Activo";
            ps = SQLSever.getConexion().prepareStatement("select * from producto where estado_producto =?");
            ps.setString(1, Condicion);
            rs= ps.executeQuery();
            while (rs.next()) {                
                Producto producto = new Producto();
                producto.setCodigo_Producto(rs.getString(1));
                producto.setNombre_Producto(rs.getString(2));
                producto.setDescripcion_Producto(rs.getString(3));
                producto.setCantidad_producto(rs.getInt(4));
                producto.setPrecioUnidad_Producto(rs.getDouble(5));
                producto.setDescuento_Producto(rs.getDouble(6));
                producto.setImagen_Producto(rs.getString(7));
                producto.setEstado_Producto(rs.getString(8));
                ListarTienda.add(producto);
            }
            SQLSever.getConexion().close();
 
        } catch (Exception e) {
        
        }
        return ListarTienda;
    }
    public Producto BuscarProducto(String Codigo){
        Producto producto = new Producto();
        try {
            ps = SQLSever.getConexion().prepareStatement("select * from producto where codigo_producto=?");
            ps.setString(1, Codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                producto.setCodigo_Producto(rs.getString(1));
                producto.setNombre_Producto(rs.getString(2));
                producto.setDescripcion_Producto(rs.getString(3));
                producto.setCantidad_producto(rs.getInt(4));
                producto.setPrecioUnidad_Producto(rs.getDouble(5));
                producto.setDescuento_Producto(rs.getDouble(6));
                producto.setImagen_Producto(rs.getString(7));
                producto.setEstado_Producto(rs.getString(8));
            }
        } catch (Exception e) {
        }
        return producto;
    }
}
