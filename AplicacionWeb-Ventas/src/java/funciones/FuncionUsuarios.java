/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funciones;

import clases.ComprasUsuario;
import clases.DatosUsuario;
import clases.DetalleComprasUsuario;
import clases.Usuario;
import clases.producto;
import conexion.conexionSQLServer;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import usuario.DetallesCompras;
public class FuncionUsuarios {
        PreparedStatement ps;
        ResultSet rs;
    public ArrayList<DetalleComprasUsuario> DetallesCompraUsuario (String CodigoUsuario, String CodigoCompra){
        ArrayList<DetalleComprasUsuario>  detalles = new ArrayList<>();
        try {
            ps = conexionSQLServer.getConexion().prepareStatement("select * from compras c inner join DetallesCompras d on (c.codigo_compra = d.codigo_compra) where c.codigo_usuario = ? and d.codigo_compra = ?");
            ps.setString(1, CodigoUsuario);
            ps.setString(2, CodigoCompra);
            rs = ps.executeQuery();
            while (rs.next()) {                
                DetalleComprasUsuario d = new DetalleComprasUsuario();  
                d.setCodigoCompra(rs.getString(1));
                d.setCodigoUsuario(rs.getString(2));
                d.setSubTotal(rs.getDouble(3));
                d.setDescuentoCompra(rs.getDouble(4));
                d.setIGVCompra(rs.getDouble(5));
                d.setPrecioFInal(rs.getDouble(6));
                d.setFechaCompra(rs.getString(7));
                d.setEstadoCompra(rs.getString(8));
                d.setCodigoCompra(rs.getString(9));
                d.setCodigoProducto(rs.getString(10));
                d.setNombreProducto(rs.getString(11));
                d.setDescripcionProducto(rs.getString(12));
                d.setCantidadCompra(rs.getInt(13));
                d.setPrecioProducto(rs.getDouble(14));
                d.setSubTotalDetalles(rs.getDouble(15));
                d.setDescuentoDetalle(rs.getDouble(16));
                detalles.add(d);
            }
        } catch (Exception e) {
        }
        return detalles;
    }
    public  ArrayList<ComprasUsuario> ListarCompras (String CodigoUsuario){
     ArrayList<ComprasUsuario> listarcompras = new ArrayList<>();
        try {
            ps = conexionSQLServer.getConexion().prepareStatement("select * from compras where codigo_usuario = ?");
            ps.setString(1, CodigoUsuario);
            rs = ps.executeQuery();
            while (rs.next()) {                
                ComprasUsuario c = new ComprasUsuario();
                c.setCodigoCompra(rs.getString(1));
                c.setCodigoUsuario(rs.getString(2));
                c.setSubTotal(rs.getDouble(3));
                c.setDescuentoCompra(rs.getDouble(4));
                c.setIGVCompra(rs.getDouble(5));
                c.setPrecioFInal(rs.getDouble(6));
                c.setFechaCompra(rs.getString(7));
                c.setEstadoCompra(rs.getString(8));
                listarcompras.add(c);
            }
        } catch (Exception e) {
        }
        return listarcompras;
    }
    public  ComprasUsuario BuscarCompras (String CodigoCompra){
   ComprasUsuario c = new ComprasUsuario();
        try {
            ps = conexionSQLServer.getConexion().prepareStatement("select * from compras where codigo_compra = ?");
            ps.setString(1, CodigoCompra);
            rs = ps.executeQuery();
            while (rs.next()) {                                
                c.setCodigoCompra(rs.getString(1));
                c.setCodigoUsuario(rs.getString(2));
                c.setSubTotal(rs.getDouble(3));
                c.setDescuentoCompra(rs.getDouble(4));
                c.setIGVCompra(rs.getDouble(5));
                c.setPrecioFInal(rs.getDouble(6));
                c.setFechaCompra(rs.getString(7));
                c.setEstadoCompra(rs.getString(8));                
            }
        } catch (Exception e) {
        }
        return c;
    }
}
