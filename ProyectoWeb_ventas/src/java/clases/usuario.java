/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.logging.Logger;

/**
 *
 * @author sebastian
 */
public class usuario   {
    private String Codigo_Usuario;    
    private String NickName_Usuario;
    private String Nombre_Usuario;
    private String Apellido_Usuario;
    private String Telefono_Usuario;
    private String Correo_Usuario;
    private String Contraseña_Usuario;
    private String Genero_Usuario;
    private String Fecha_Nacimiento;

    public usuario(String Codigo_Usuario, String NickName_Usuario, String Nombre_Usuario, String Apellido_Usuario, String Telefono_Usuario, String Correo_Usuario, String Contraseña_Usuario, String Genero_Usuario, String Fecha_Nacimiento) {
        this.Codigo_Usuario = Codigo_Usuario;
        this.NickName_Usuario = NickName_Usuario;
        this.Nombre_Usuario = Nombre_Usuario;
        this.Apellido_Usuario = Apellido_Usuario;
        this.Telefono_Usuario = Telefono_Usuario;
        this.Correo_Usuario = Correo_Usuario;
        this.Contraseña_Usuario = Contraseña_Usuario;
        this.Genero_Usuario = Genero_Usuario;
        this.Fecha_Nacimiento = Fecha_Nacimiento;
    }

    public usuario() {
    }

      
    public String getCodigo_Usuario() {
        return Codigo_Usuario;
    }

    public void setCodigo_Usuario(String Codigo_Usuario) {
        this.Codigo_Usuario = Codigo_Usuario;
    }

    public String getNickName_Usuario() {
        return NickName_Usuario;
    }

    public void setNickName_Usuario(String NickName_Usuario) {
        this.NickName_Usuario = NickName_Usuario;
    }

    public String getNombre_Usuario() {
        return Nombre_Usuario;
    }

    public void setNombre_Usuario(String Nombre_Usuario) {
        this.Nombre_Usuario = Nombre_Usuario;
    }

    public String getApellido_Usuario() {
        return Apellido_Usuario;
    }

    public void setApellido_Usuario(String Apellido_Usuario) {
        this.Apellido_Usuario = Apellido_Usuario;
    }

    public String getTelefono_Usuario() {
        return Telefono_Usuario;
    }

    public void setTelefono_Usuario(String Telefono_Usuario) {
        this.Telefono_Usuario = Telefono_Usuario;
    }

    public String getCorreo_Usuario() {
        return Correo_Usuario;
    }

    public void setCorreo_Usuario(String Correo_Usuario) {
        this.Correo_Usuario = Correo_Usuario;
    }

    public String getContraseña_Usuario() {
        return Contraseña_Usuario;
    }

    public void setContraseña_Usuario(String Contraseña_Usuario) {
        this.Contraseña_Usuario = Contraseña_Usuario;
    }

    public String getGenero_Usuario() {
        return Genero_Usuario;
    }

    public void setGenero_Usuario(String Genero_Usuario) {
        this.Genero_Usuario = Genero_Usuario;
    }

    public String getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(String Fecha_Nacimiento) {
        this.Fecha_Nacimiento = Fecha_Nacimiento;
    }



    
}
