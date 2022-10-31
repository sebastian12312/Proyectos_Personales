/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionBD;

import java.sql.*;
public class SQLSever {
    
    public static Connection getConexion(){
       String url="jdbc:sqlserver://localhost:1433;databaseName=ImpactoFilms;user=sa;password=12345"; //Conexion URL
        Connection con = null ;
        try { 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //CONEXION AL DRIVER
            con = DriverManager.getConnection(url); //OTRA CONEXION QUE NOSE  PARA QUE SIRVE
           
            
            System.out.println("CONEXION EXITOSA");
             
            ;

         
          
        } catch (Exception e) {
            e.printStackTrace();
        }
          return con;
    }
     public static void main(String[] args) {
           SQLSever.getConexion();
    }
}
