/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author sebastian
 */
public class datosUsuario{
   private String Codigo_Usuario;
    private double Saldo_Usuario;
    private String Tipo_Usuario;
    private String Estado_Usuario;

    public datosUsuario() {
    }

    public datosUsuario(String Codigo_Usuario, double Saldo_Usuario, String Tipo_Usuario, String Estado_Usuario) {
        this.Codigo_Usuario = Codigo_Usuario;
        this.Saldo_Usuario = Saldo_Usuario;
        this.Tipo_Usuario = Tipo_Usuario;
        this.Estado_Usuario = Estado_Usuario;
    }

    public String getCodigo_Usuario() {
        return Codigo_Usuario;
    }

    public void setCodigo_Usuario(String Codigo_Usuario) {
        this.Codigo_Usuario = Codigo_Usuario;
    }

    public double getSaldo_Usuario() {
        return Saldo_Usuario;
    }

    public void setSaldo_Usuario(double Saldo_Usuario) {
        this.Saldo_Usuario = Saldo_Usuario;
    }

    public String getTipo_Usuario() {
        return Tipo_Usuario;
    }

    public void setTipo_Usuario(String Tipo_Usuario) {
        this.Tipo_Usuario = Tipo_Usuario;
    }

    public String getEstado_Usuario() {
        return Estado_Usuario;
    }

    public void setEstado_Usuario(String Estado_Usuario) {
        this.Estado_Usuario = Estado_Usuario;
    }

   
    
}
