/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;
import conexionBD.SQLSever;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
public class FuncionesCompras {
    PreparedStatement ps;
    ResultSet rs;
    
    public int RegistrarCompra(String CodigoCompra,String CodigoUsuario, double SubTotal,double PrecioTotal,String FechaCompra,String EstadoCompra){
        int respesta = 0 ;
        try {
            ps = SQLSever.getConexion().prepareStatement("insert into compras(codigo_compra,codigo_usuario,sub_total,precio_total,fecha_compra,estado_compra) values(?,?,?,?,?,?)");
            ps.setString(1, CodigoCompra);
            ps.setString(2, CodigoUsuario);
            ps.setDouble(3, SubTotal);
            ps.setDouble(4, PrecioTotal);
            ps.setString(5, FechaCompra);
            ps.setString(6, EstadoCompra);
            rs = ps.executeQuery();
            SQLSever.getConexion().close();
        } catch (Exception e) {
        
        }
        
        return 1;
    }
    public  void ResgistrarDetallesCompras(String CodigoCompra,String CodigoProducto, String NombreProducto,String DescripcionProducto,int cantidadCompra,double PrecioProducto,double SubTotal,double descuento){
        int respesta = 0 ;
        try {
            ps = SQLSever.getConexion().prepareStatement("insert into DetallesCompras(codigo_compra,codigo_producto,nombre_producto,descripcion_producto,cantidad_compra,precio_producto,sub_total,descuento_compra) values(?,?,?,?,?,?,?,?)");
            ps.setString(1, CodigoCompra);
            ps.setString(2, CodigoProducto);
            ps.setString(3, NombreProducto);
            ps.setString(4, DescripcionProducto);
            ps.setInt(5, cantidadCompra);
            ps.setDouble(6, PrecioProducto);
            ps.setDouble(7, SubTotal);
            ps.setDouble(8, descuento);
            rs = ps.executeQuery();
            SQLSever.getConexion().close();
        } catch (Exception e) {
        
        }                
    }
}
