/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funciones;
import clases.DatosUsuario;
import clases.Usuario;
import clases.producto;
import conexion.conexionSQLServer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class FuncionTienda {
    PreparedStatement ps;
    ResultSet rs;
    public int RegistrarDetallesCompras(String CodigoCompra,String CodigoProducto,String NombreProducto,String DescripcionProducto, int CantidadProductoCompra, double PrecioProducto, double SubTotalDetalles,double DescuentoCompraDetalles){
        try {
            ps = conexionSQLServer.getConexion().prepareStatement("insert into detallescompras (codigo_compra, codigo_producto, nombre_producto, descripcion_producto, cantidad_compra,precio_producto,sub_total, descuento_detalle) values (?,?,?,?,?,?,?,?)");
            ps.setString(1, CodigoCompra);
            ps.setString(2, CodigoProducto);
            ps.setString(3, NombreProducto);
            ps.setString(4, DescripcionProducto);
            ps.setInt(5, CantidadProductoCompra);
            ps.setDouble(6, PrecioProducto);
            ps.setDouble(7, SubTotalDetalles);
            ps.setDouble(8, DescuentoCompraDetalles);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return 1;
    }
    public int RegistrarCompra(String CodigoCompra, String CodigoUsuario,double SubTotal,double DescuentoCompra,double IGVCompra,double PrecioFinal,String FechaCompra, String EstadoCompra){        
        try {
            ps = conexionSQLServer.getConexion().prepareStatement("insert into compras (codigo_compra , codigo_usuario , sub_total , descuento_compra , IGV_compra , precio_total , fecha_compra,estado_compra) values (?,?,?,?,?,?,?,?)");
            ps.setString(1, CodigoCompra);
            ps.setString(2, CodigoUsuario);
            ps.setDouble(3, SubTotal);
            ps.setDouble(4, DescuentoCompra);
            ps.setDouble(5, IGVCompra);
            ps.setDouble(6, PrecioFinal);
            ps.setString(7, FechaCompra);
            ps.setString(8, EstadoCompra);
            ps.executeUpdate();
        } catch (Exception e) {
        
        }        
        return 1;
    }
    public ArrayList<producto> ListarProducto(){
     ArrayList<producto> ListarProducto = new ArrayList<producto>();
        try {
            ps = conexionSQLServer.getConexion().prepareStatement("select * from productos");
            rs = ps.executeQuery();
            while (rs.next()) {                
                producto p = new producto();
                p.setCodigProducto(rs.getString(1));
                p.setNombreProducto(rs.getString(2));
                p.setDescripcionProducto(rs.getString(3));
                p.setCantidadProducto(rs.getInt(4));
                p.setPrecioProducto(rs.getDouble(5));
                p.setDescuentoProducto(rs.getDouble(6));
                p.setImagenProducto(rs.getString(7));
                p.setEstadoProducto(rs.getString(8));
                p.setCategoriaProducto(rs.getString(9));
                ListarProducto.add(p);
            }
        } catch (Exception e) {
        
        }
     
     return ListarProducto;
    }
    public producto BuscarProducto(String CodigoProducto){
        producto p = new producto();
        try {
            ps = conexionSQLServer.getConexion().prepareStatement("select * from productos where codigo_producto=?");
            ps.setString(1, CodigoProducto);
            rs = ps.executeQuery();
            while (rs.next()) {                                
                p.setCodigProducto(rs.getString(1));
                p.setNombreProducto(rs.getString(2));
                p.setDescripcionProducto(rs.getString(3));
                p.setCantidadProducto(rs.getInt(4));
                p.setPrecioProducto(rs.getDouble(5));
                p.setDescuentoProducto(rs.getDouble(6));
                p.setImagenProducto(rs.getString(7));
                p.setEstadoProducto(rs.getString(8));
                p.setCategoriaProducto(rs.getString(9));                
            }
        } catch (Exception e) {
        
        }
     
     return p;
    }
}
