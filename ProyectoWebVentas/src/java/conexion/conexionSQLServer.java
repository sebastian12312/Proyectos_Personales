/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author sebastian
 */
public class conexionSQLServer {
     public static Connection getConexion(){
        String url="jdbc:sqlserver://localhost:1433;databaseName=ProyectoVentas;user=sa;password=12345"; //Conexion URL
        Connection con = null ;
        try { 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //CONEXION AL DRIVER
            con = DriverManager.getConnection(url); //OTRA CONEXION QUE NOSE  PARA QUE SIRVE                       
            System.out.println("CONEXION EXITOSA");                                         
        } catch (Exception e) {
            e.printStackTrace();
        }
          return con;
    }
    public static void main(String[] args) {
           conexionSQLServer.getConexion();
    }
}
