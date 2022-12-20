/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author sebastian
 */
public class Usuario {
    private String CodigoUsuario;
    private String NickNameUsuario;
    private String NombreUsuario;
    private String ApellidoUsuario;
    private String TelefonoUsuario;
    private String CorreoUsuario;
    private String ContraseñaUsuario;
    private String GeneroUsuario;
    private String FechaNacimientoUsuario;

    public Usuario() {
    }
    public Usuario(String CodigoUsuario, String NickNameUsuario, String NombreUsuario, String ApellidoUsuario, String TelefonoUsuario, String CorreoUsuario, String ContraseñaUsuario, String GeneroUsuario, String FechaNacimientoUsuario) {
        this.CodigoUsuario = CodigoUsuario;
        this.NickNameUsuario = NickNameUsuario;
        this.NombreUsuario = NombreUsuario;
        this.ApellidoUsuario = ApellidoUsuario;
        this.TelefonoUsuario = TelefonoUsuario;
        this.CorreoUsuario = CorreoUsuario;
        this.ContraseñaUsuario = ContraseñaUsuario;
        this.GeneroUsuario = GeneroUsuario;
        this.FechaNacimientoUsuario = FechaNacimientoUsuario;
    }

    public String getCodigoUsuario() {
        return CodigoUsuario;
    }

    public void setCodigoUsuario(String CodigoUsuario) {
        this.CodigoUsuario = CodigoUsuario;
    }

    public String getNickNameUsuario() {
        return NickNameUsuario;
    }

    public void setNickNameUsuario(String NickNameUsuario) {
        this.NickNameUsuario = NickNameUsuario;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getApellidoUsuario() {
        return ApellidoUsuario;
    }

    public void setApellidoUsuario(String ApellidoUsuario) {
        this.ApellidoUsuario = ApellidoUsuario;
    }

    public String getTelefonoUsuario() {
        return TelefonoUsuario;
    }

    public void setTelefonoUsuario(String TelefonoUsuario) {
        this.TelefonoUsuario = TelefonoUsuario;
    }

    public String getCorreoUsuario() {
        return CorreoUsuario;
    }

    public void setCorreoUsuario(String CorreoUsuario) {
        this.CorreoUsuario = CorreoUsuario;
    }

    public String getContraseñaUsuario() {
        return ContraseñaUsuario;
    }

    public void setContraseñaUsuario(String ContraseñaUsuario) {
        this.ContraseñaUsuario = ContraseñaUsuario;
    }

    public String getGeneroUsuario() {
        return GeneroUsuario;
    }

    public void setGeneroUsuario(String GeneroUsuario) {
        this.GeneroUsuario = GeneroUsuario;
    }

    public String getFechaNacimientoUsuario() {
        return FechaNacimientoUsuario;
    }

    public void setFechaNacimientoUsuario(String FechaNacimientoUsuario) {
        this.FechaNacimientoUsuario = FechaNacimientoUsuario;
    }
    
    
}
