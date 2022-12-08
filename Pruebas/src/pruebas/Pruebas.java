/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import java.util.Scanner;

/**
 *
 * @author sebastian
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double Monto;      
        double Respuesta;
        double Descuento;
        System.out.println("INGRESE EL MONTO A CALCULAR");
        Monto = scan.nextDouble();
        
        if (Monto > 100) {
            Descuento = 0.10;
            Respuesta = Monto - (Monto -Descuento);
        }else{
            Descuento = 0.20;
            Respuesta = Monto - (Monto - 0.20);
        }
        
        System.out.println("El descuento es:" + Descuento * 100 + "%");
        System.out.println("Monto final: S/" + Respuesta);
                
    }
    
}
