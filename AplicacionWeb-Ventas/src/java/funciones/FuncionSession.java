/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funciones;

import clases.DatosUsuario;
import clases.Usuario;
import conexion.conexionSQLServer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class FuncionSession {
    PreparedStatement ps;
    ResultSet rs;
    public double BuscarSaldoUsuario(String codigoUsuario){
        double SaldoUsuario=0.0;
        try {
            ps = conexionSQLServer.getConexion().prepareStatement("select * from datosUsuario where codigo_usuario=?");
            ps.setString(1, codigoUsuario);
            rs = ps.executeQuery();
            while (rs.next()) {                
                SaldoUsuario = rs.getDouble(2);
            }
        } catch (Exception e) {
        }
        return SaldoUsuario;
        
    }
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
    public DatosUsuario BuscarUsuario(String codigoUsuario){
        DatosUsuario user = new DatosUsuario();
        try {
            ps = conexionSQLServer.getConexion().prepareStatement("select * from usuario u inner join datosUsuario d on (u.codigo_usuario = d.codigo_usuario) where u.codigo_usuario");
            ps.setString(1, codigoUsuario);
            rs=ps.executeQuery();
            while (rs.next()) {                
                user.setCodigoUsuario(rs.getString(1));
                user.setNickNameUsuario(rs.getString(2));
                user.setNombreUsuario(rs.getString(3));
                user.setApellidoUsuario(rs.getString(4));
                user.setTelefonoUsuario(rs.getString(5));
                user.setCorreoUsuario(rs.getString(6));
                user.setContraseñaUsuario(rs.getString(7));
                user.setGeneroUsuario(rs.getString(8));
                user.setFechaNacimientoUsuario(rs.getString(9));
                user.setCodigoUsuario(rs.getString(10));
                user.setSaldoUsuario(rs.getDouble(11));
                user.setTipoUsuario(rs.getString(12));
                user.setEstadoUsuario(rs.getString(13));
            }
        } catch (Exception e) {
        }
        return   user;   
    }
    public DatosUsuario Usuario(String usuario, String password){
        DatosUsuario user = new DatosUsuario();
        try {
            ps = conexionSQLServer.getConexion().prepareStatement("select * from usuario u inner join datosUsuario d on (u.codigo_usuario = d.codigo_usuario) where u.codigo_usuario =? and u.contraseña_usuario =?");
            ps.setString(1, usuario);
            ps.setString(2, password);
            rs=ps.executeQuery();
            while (rs.next()) {                
                user.setCodigoUsuario(rs.getString(1));
                user.setNickNameUsuario(rs.getString(2));
                user.setNombreUsuario(rs.getString(3));
                user.setApellidoUsuario(rs.getString(4));
                user.setTelefonoUsuario(rs.getString(5));
                user.setCorreoUsuario(rs.getString(6));
                user.setContraseñaUsuario(rs.getString(7));
                user.setGeneroUsuario(rs.getString(8));
                user.setFechaNacimientoUsuario(rs.getString(9));
                user.setCodigoUsuario(rs.getString(10));
                user.setSaldoUsuario(rs.getDouble(11));
                user.setTipoUsuario(rs.getString(12));
                user.setEstadoUsuario(rs.getString(13));
            }
        } catch (Exception e) {
        }
        return   user;   
    }
    public int RegistrarUsuario(String CodigoUsuario,String usuario, String NombreUsuario, String ApellidoUsuario, String TelefonoUsuario,String email,String password,String GeneroUsuario,String FechaNacimiento){
       
        try {
            ps = conexionSQLServer.getConexion().prepareStatement("INSERT INTO  usuario (codigo_usuario,nickname_usuario,nombre_usuario,apellido_usuario,telefono_usuario,correo_usuario,contraseña_usuario,genero_usuario,fecha_nacimiento) values (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, CodigoUsuario);
            ps.setString(2, usuario);
            ps.setString(3, NombreUsuario);
            ps.setString(4, ApellidoUsuario);
            ps.setString(5, TelefonoUsuario);
            ps.setString(6, email);
            ps.setString(7, password);
            ps.setString(8, GeneroUsuario);
            ps.setString(9, FechaNacimiento);
            ps.executeUpdate();
            
        } catch (Exception e) {
         
        }
        
        return  1;
    }
    public int RegistrarDatosUsuario(String CodigoUsuario, double SaldoUsuario, String TipoUsuario,String EstadoUSuario){
    try {
              ps = conexionSQLServer.getConexion().prepareStatement("insert into datosUsuario (codigo_usuario,saldo_usuario,tipo_usuario,estado_usuario) values (?,?,?,?");
               ps.setString(1, CodigoUsuario);
               ps.setDouble(2,SaldoUsuario);
               ps.setString(3, TipoUsuario);
               ps.setString(4, EstadoUSuario);
               ps.executeUpdate();
        } catch (Exception e) {
        
        }
        return 1;
    }
}
