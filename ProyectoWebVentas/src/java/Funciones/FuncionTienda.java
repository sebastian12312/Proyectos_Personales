/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import clases.Productos;
import conexion.conexionSQLServer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class FuncionTienda {
    PreparedStatement ps;
    ResultSet rs;
    
    
    public Productos BuscarProducto(String CodigoProducto){
        Productos producto = new Productos();
        try {
            ps = conexionSQLServer.getConexion().prepareStatement("select * from producto where codigo_producto=?");   
            ps.setString(1, CodigoProducto);   
            rs = ps.executeQuery();
            while (rs.next()) {                             
                producto.setCodigoProducto(rs.getString(1));
                producto.setNombreProducto(rs.getString(2));
                producto.setDescripcionProducto(rs.getString(3));
                producto.setCantidadProducto(rs.getInt(4));
                producto.setPrecioUnidadProducto(rs.getDouble(5));
                producto.setDescuentoProducto(rs.getDouble(6));
                producto.setImagenProducto(rs.getString(7));
                producto.setEstadoProducto(rs.getString(8));                               
            }
            conexionSQLServer.getConexion().close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return producto;
    }
    
    public ArrayList ListarTienda(){
        ArrayList<Productos> ListarTiendaProducto = new ArrayList<>();
        try {
            String EstadoProducto = "ACTIVO";
            ps = conexionSQLServer.getConexion().prepareStatement("select * from producto");          
            rs = ps.executeQuery();
            while (rs.next()) {              
                Productos producto = new Productos();
                producto.setCodigoProducto(rs.getString(1));
                producto.setNombreProducto(rs.getString(2));
                producto.setDescripcionProducto(rs.getString(3));
                producto.setCantidadProducto(rs.getInt(4));
                producto.setPrecioUnidadProducto(rs.getDouble(5));
                producto.setDescuentoProducto(rs.getDouble(6));
                producto.setImagenProducto(rs.getString(7));
                producto.setEstadoProducto(rs.getString(8));
                ListarTiendaProducto.add(producto);                        
            }
            conexionSQLServer.getConexion().close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return ListarTiendaProducto;
    }
}
