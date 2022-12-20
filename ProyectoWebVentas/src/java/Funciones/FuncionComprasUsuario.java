/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import clases.*;
import conexion.conexionSQLServer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class FuncionComprasUsuario {
    PreparedStatement ps;
    ResultSet rs;
   public int ValidacionCompras (String CodigoUsuario , String CodigoCompra){
       try {
              ps = conexionSQLServer.getConexion().prepareStatement("select * from compras where codigo_compra =? and codigo_usuario=?");
              ps.setString(1, CodigoCompra);
              ps.setString(2, CodigoUsuario);
              rs = ps.executeQuery();              
       } catch (Exception e) {              
       }                      
       return 1;
   }
    public ArrayList<DetallesCompras> Details ( String CodigoCompra){
      ArrayList<DetallesCompras> ListarDetailsCompras = new ArrayList<>();
        try {   
                ps = conexionSQLServer.getConexion().prepareStatement("select * from detallesCompras where codigo_compra =?");
                ps.setString(1, CodigoCompra);
                rs = ps.executeQuery();    
                while (rs.next()) {      
                    System.out.println("goo");
                    DetallesCompras d = new DetallesCompras();
                    d.setCodigoCompra(rs.getString(1));
                    d.setCodigoProducto(rs.getString(2));
                    d.setNombreProducto(rs.getString(3));
                    d.setDescripcionProducto(rs.getString(4));
                    d.setCantidadCompra(rs.getInt(5));
                    d.setPrecioCompra(rs.getDouble(6));
                    d.setSubTotalCompraProducto(rs.getDouble(7));
                    d.setDescuentoCompra(rs.getDouble(8));
                    ListarDetailsCompras.add(d);

                }
        } catch (Exception e) {
        }
      
      return ListarDetailsCompras;
    } 
    public ArrayList<compras> Miscompras(String CodigoUsuario){
        ArrayList<compras> ListarCompras = new ArrayList<>();
        try {
            ps = conexionSQLServer.getConexion().prepareStatement("select * from compras where codigo_usuario=?");
            ps.setString(1, CodigoUsuario);
            rs = ps.executeQuery();
            conexionSQLServer.getConexion().close();
            while (rs.next()) {                
                compras d = new compras();
                d.setCodigoCompra(rs.getString(1));
                d.setCodigoUsuario(rs.getString(2));
                d.setSubTotalCompra(rs.getDouble(3));
                d.setPrecioTotal(rs.getDouble(4));
                d.setFechaCompra(rs.getString(5));
                d.setEstadoCompra(rs.getString(6));
                ListarCompras.add(d);
            }
        } catch (Exception e) {
        }
        return ListarCompras; 
    }
           
    
    
    
}
