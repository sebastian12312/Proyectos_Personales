/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funciones.GeneradorDeCodigo;
import java.sql.PreparedStatement;
import conexion.SQLserver;
import java.sql.ResultSet;
import java.sql.SQLException;
@WebServlet(name = "registrar", urlPatterns = {"/registrar"})
public class registrar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PreparedStatement ps = null;
        PreparedStatement ps1;
        PreparedStatement ps2 = null;
        ResultSet rs;
        GeneradorDeCodigo generarCod = new GeneradorDeCodigo();
        //usuario
        String CodigoUsuario = generarCod.GenerarCodigoUsuario();
        String NickName = request.getParameter("NickName");
        String NombreUsuario = request.getParameter("NombreUsuario");
        String ApellidoUsuario = request.getParameter("ApellidoUsuario");
        String CorreoUsuario = request.getParameter("CorreoUsuario");
        String PasswordUsuario = request.getParameter("PasswordUsuario");
        String PasswordUsuario2 = request.getParameter("PasswordUsuario2");
        String TelefonoUsuario = request.getParameter("TelefonoUsuario");
        String FechaNacimiento = "21-12-12";
        String GeneroUsuario = request.getParameter("GeneroUsuario");
        //datos usuario
        double SaldoUsuario = 0.0;
        String TipoUSuario = "USUARIO";
        String EstadoUsuario = "ACTIVO";
        
        try {
            ps1 = SQLserver.getConexion().prepareStatement("INSERT INTO Usuario (CodigoUsuario,NickName,NombreUsuario,ApellidoUsuario,CorreoUsuario,PasswordUsuario,TelefonoUsuario,FechaNacimiento,Genero) values (?,?,?,?,?,?,?,?,?)");
            ps1.setString(1, CodigoUsuario);
            ps1.setString(2, NickName);
            ps1.setString(3, NombreUsuario);
            ps1.setString(4, ApellidoUsuario);
            ps1.setString(5, CorreoUsuario);
            ps1.setString(6, PasswordUsuario);
            ps1.setString(7, TelefonoUsuario);
            ps1.setString(8, FechaNacimiento);
            ps1.setString(9, GeneroUsuario);
            ps1.executeUpdate();                   
            
        } catch (Exception e) {           
            e.printStackTrace();
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
