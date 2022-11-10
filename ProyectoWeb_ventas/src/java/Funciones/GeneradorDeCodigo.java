/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import java.util.Random;

/**
 *
 * @author sebastian
 */
public class GeneradorDeCodigo {
    
    public String CrearCodigo(){
        Random random = new Random(); 
        char LETRA1 = (char) (random.nextInt(26) + 'A' );            
        char LETRA2 = (char) (random.nextInt(26) + 'A' );     
        char LETRA3 = (char) (random.nextInt(26) + 'A' ); 
        String setOfCharacters = "1234567890";
        int NUMERO = random.nextInt(setOfCharacters.length()+11);
        char randomChar = setOfCharacters.charAt(NUMERO);
        char randomChar2 = setOfCharacters.charAt(NUMERO);
        String letra = "COD"+LETRA1+randomChar+LETRA3+randomChar2+LETRA2;                             
        return letra;        
    }
}
