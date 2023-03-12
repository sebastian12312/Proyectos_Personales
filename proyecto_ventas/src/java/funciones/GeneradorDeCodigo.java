/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funciones;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
public class GeneradorDeCodigo {
   
    Calendar calendar = Calendar.getInstance();
    String fecha;

    public GeneradorDeCodigo() {
    }

    public String Fecha() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        fecha = sdf.format(calendar.getTime());
//        fecha = calendar.getTime().toString();
        return fecha;
    }

    public String FechaBD() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        fecha = sdf.format(calendar.getTime());
        return fecha;
    }

    public String GeneradorDeCodigo() {
        char[] mayusculas = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Y', 'Z'};
        char[] minuscula = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'y', 'z'};
        char[] numeros = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        StringBuilder caracteres = new StringBuilder();
        caracteres.append(mayusculas);
        caracteres.append(minuscula);
        caracteres.append(numeros);
        StringBuilder codigo = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            int Cantidadcodigo = caracteres.length();
            int NumeroRamdom = (int) (Math.random() * Cantidadcodigo);
            codigo.append((caracteres.toString()).charAt(NumeroRamdom));
        }
        return codigo.toString();
    }

    public String GenerarCodigoUsuario() {
        char[] numeros = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        char[] mayusculas = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Y', 'Z'};
        StringBuilder caracteres = new StringBuilder();
        caracteres.append(numeros);
        caracteres.append(mayusculas);
        StringBuilder codigo = new StringBuilder();
        for (int i = 0; i < 14; i++) {
            int Cantidadcodigo = caracteres.length();
            int NumeroRamdom = (int) (Math.random() * Cantidadcodigo);
            codigo.append((caracteres.toString()).charAt(NumeroRamdom));
        }
        return codigo.toString();
    } 
}
