/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author sebastian
 */
public class DatosUsuario extends usuario{
    private double SaldoUsuario;
    private String TipoUsuario;
    private String EstadoUsuario;

    public DatosUsuario() {
    }
    
    public DatosUsuario(double SaldoUsuario, String TipoUsuario, String EstadoUsuario, String CodigoUsuario, String NickName, String NombreUsuario, String ApellidoUsuario, String TelefonoUsuario, String CorreoUsuario, String ContraseñaUsuario, String GeneroUsuario, String FechaNacimiento) {
        super(CodigoUsuario, NickName, NombreUsuario, ApellidoUsuario, TelefonoUsuario, CorreoUsuario, ContraseñaUsuario, GeneroUsuario, FechaNacimiento);
        this.SaldoUsuario = SaldoUsuario;
        this.TipoUsuario = TipoUsuario;
        this.EstadoUsuario = EstadoUsuario;
    }

    public double getSaldoUsuario() {
        return SaldoUsuario;
    }

    public void setSaldoUsuario(double SaldoUsuario) {
        this.SaldoUsuario = SaldoUsuario;
    }

    public String getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(String TipoUsuario) {
        this.TipoUsuario = TipoUsuario;
    }

    public String getEstadoUsuario() {
        return EstadoUsuario;
    }

    public void setEstadoUsuario(String EstadoUsuario) {
        this.EstadoUsuario = EstadoUsuario;
    }
    
    
}
