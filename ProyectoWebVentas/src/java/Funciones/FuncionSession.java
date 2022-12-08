/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import clases.DatosUsuario;
import clases.usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conexion.conexionSQLServer;
/**
 *
 * @author sebastian
 */
public class FuncionSession {
    PreparedStatement ps;
    ResultSet rs;
    public int ActualizarSaldo(String CodigoUsuario,double NuevoSaldo){
        try {
            ps = conexionSQLServer.getConexion().prepareStatement("update datosUsuario set saldo_usuario=? where codigo_usuario=?");
            ps.setDouble(1, NuevoSaldo);
            ps.setString(2, CodigoUsuario);
            ps.executeUpdate();
        } catch (Exception e) {
        
        }
        
    return 1;
    }
    public int RegistrarDetallesCompra(String CodigoCompra, String CodigoProducto, String NombreProducto,String DescripcionProducto, int CantidadCompra, double PrecioProducto, double subTotalProducto, double DescuentoCompra){
        try {
            ps = conexionSQLServer.getConexion().prepareStatement("insert into DetallesCompras (codigo_compra,codigo_producto,nombre_producto,descripcion_producto, cantidad_compra,precio_producto,sub_total,descuento_compra) values (?,?,?,?,?,?,?,?)");
            ps.setString(1, CodigoCompra);
            ps.setString(2, CodigoProducto);
            ps.setString(3, NombreProducto);
            ps.setString(4, DescripcionProducto);
            ps.setInt(5, CantidadCompra);
            ps.setDouble(6, PrecioProducto);
            ps.setDouble(7, subTotalProducto);
            ps.setDouble(8, DescuentoCompra);
            ps.executeUpdate();
        } catch (Exception e) {                
        }
        return 1;
    }
    public int RegistrarCompra(String CodigoCompra, String CodigoUsuario, double Subtotal,double PrecioTotal, String FechaCompra, String EstadoCompra){
        try {
            ps = conexionSQLServer.getConexion().prepareStatement("insert into compras (codigo_compra,codigo_usuario,sub_total,precio_total,fecha_compra,Estado_compra) values (?,?,?,?,?,?)");
            ps.setString(1, CodigoCompra);
            ps.setString(2, CodigoUsuario);
            ps.setDouble(3, Subtotal);
            ps.setDouble(4, PrecioTotal);
            ps.setString(5, FechaCompra);
            ps.setString(6, EstadoCompra);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return 1;
    }
    public String ValidacionLogin (String usuario , String password){
        String CodigoUsuario = "";        
        try {
            ps = conexionSQLServer.getConexion().prepareStatement("select * from usuario where correo_usuario =? and contraseña_usuario=?");
            ps.setString(1, usuario);
            ps.setString(2, password);
            rs = ps.executeQuery();   
            if(rs.next()){
                CodigoUsuario = rs.getString(1);            
            }
        } catch (Exception e) {
            
        }       
        return CodigoUsuario;
    }
    public DatosUsuario DatosUsuario(String correo){
            DatosUsuario user = new DatosUsuario();
        try {
            ps = conexionSQLServer.getConexion().prepareStatement("select [nickname_usuario],[correo_usuario],[saldo_usuario],[tipo_usuario], [estado_usuario] from usuario u inner join datosUsuario d on (u.codigo_usuario = d.codigo_usuario)  where correo_usuario = ?");
            ps.setString(1, correo);
            rs = ps.executeQuery();
            while (rs.next()) {                
                user.setNickName(rs.getString(1));
                user.setCorreoUsuario(rs.getString(2));
                user.setSaldoUsuario(rs.getDouble(3));
                user.setTipoUsuario(rs.getString(4));
                user.setEstadoUsuario(rs.getString(5));
            }
        } catch (Exception e) {       
        
        }
        return user;
    }
    
    public DatosUsuario BuscarSaldo(String CodigoUsuario){
        DatosUsuario dato = new DatosUsuario();
        try {
            ps = conexionSQLServer.getConexion().prepareStatement("select * from datosUsuario where codigo_usuario =?");
            ps.setString(1, CodigoUsuario);
            rs = ps.executeQuery();
            while (rs.next()) {                
                dato.setCodigoUsuario(rs.getString(1));
                dato.setSaldoUsuario(rs.getDouble(2));
                dato.setTipoUsuario(rs.getString(3));
                dato.setEstadoUsuario(rs.getString(4));
            }
        } catch (Exception e) {
        }
        return dato;
    }
    
}
