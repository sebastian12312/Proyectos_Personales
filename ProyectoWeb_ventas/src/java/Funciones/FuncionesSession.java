/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import clases.datosUsuario;
import clases.usuario;
import conexionBD.SQLSever;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FuncionesSession {

    PreparedStatement ps;
    ResultSet rs;

    public String ValidacionLogin(String Id_Usuario, String Password_Usuario) {
        String Respuesta = null;
        try {
            ps = SQLSever.getConexion().prepareStatement("select * from usuario where correo_usuario=? and contraseña_usuario=? ");
            ps.setString(1, Id_Usuario);
            ps.setString(2, Password_Usuario);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(1) != null) {
                    Respuesta = rs.getString(1);
                } else {
                    Respuesta =null;
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR:" + e);
        }
        return Respuesta;
    }

    public datosUsuario DatosUsuario(String codigo_usuario) {
        datosUsuario datos = new datosUsuario();
        String Respuesta = "";
        try {
            ps = SQLSever.getConexion().prepareStatement("select * from datosUsuario where codigo_usuario=?");
            ps.setString(1, codigo_usuario);
            rs = ps.executeQuery();
            while (rs.next()) {
                datos.setCodigo_Usuario(rs.getString(1));
                datos.setSaldo_Usuario(rs.getDouble(2));
                datos.setTipo_Usuario(rs.getString(3));
                datos.setEstado_Usuario(rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return datos;
    }

    public usuario UsuarioMain(String codigo_usuario) {
        usuario datos = new usuario();
        try {
            ps = SQLSever.getConexion().prepareStatement("select * from usuario where codigo_usuario=?");
            ps.setString(1, codigo_usuario);
            rs = ps.executeQuery();
            while (rs.next()) {
                datos.setCodigo_Usuario(rs.getString(1));
                datos.setNickName_Usuario(rs.getString(2));
                datos.setNombre_Usuario(rs.getString(3));
                datos.setApellido_Usuario(rs.getString(4));
                datos.setTelefono_Usuario(rs.getString(5));
                datos.setCorreo_Usuario(rs.getString(6));
                datos.setContraseña_Usuario(rs.getString(7));
                datos.setGenero_Usuario(rs.getString(8));
                datos.setFecha_Nacimiento(rs.getString(9));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return datos;
    }
}
