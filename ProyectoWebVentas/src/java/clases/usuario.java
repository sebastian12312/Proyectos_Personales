/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author sebastian
 */
public class usuario {
    private String CodigoUsuario;
    private String NickName;
    private String NombreUsuario;
    private String ApellidoUsuario;
    private String TelefonoUsuario;
    private String CorreoUsuario;
    private String ContraseñaUsuario;
    private String GeneroUsuario;
    private String FechaNacimiento;

    public usuario() {
    }

    public usuario(String CodigoUsuario, String NickName, String NombreUsuario, String ApellidoUsuario, String TelefonoUsuario, String CorreoUsuario, String ContraseñaUsuario, String GeneroUsuario, String FechaNacimiento) {
        this.CodigoUsuario = CodigoUsuario;
        this.NickName = NickName;
        this.NombreUsuario = NombreUsuario;
        this.ApellidoUsuario = ApellidoUsuario;
        this.TelefonoUsuario = TelefonoUsuario;
        this.CorreoUsuario = CorreoUsuario;
        this.ContraseñaUsuario = ContraseñaUsuario;
        this.GeneroUsuario = GeneroUsuario;
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getCodigoUsuario() {
        return CodigoUsuario;
    }

    public void setCodigoUsuario(String CodigoUsuario) {
        this.CodigoUsuario = CodigoUsuario;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String NickName) {
        this.NickName = NickName;
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

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }
    
    
    
}
