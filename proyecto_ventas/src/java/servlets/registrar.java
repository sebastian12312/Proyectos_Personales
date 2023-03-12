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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

@WebServlet(name = "registrar", urlPatterns = {"/registrar"})
public class registrar extends HttpServlet {

    PreparedStatement ps;

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
        HttpSession session = request.getSession();
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
        String FechaNacimiento = request.getParameter("FechaNacimiento");
        String GeneroUsuario = request.getParameter("GeneroUsuario");
        System.out.println("codigo" + CodigoUsuario);
        System.out.println("codigo" + NickName);
        System.out.println("codigo" + ApellidoUsuario);
        System.out.println("codigo" + CorreoUsuario);
        System.out.println("codigo" + PasswordUsuario);
        System.out.println("codigo" + TelefonoUsuario);
        System.out.println("codigo" + FechaNacimiento);
        System.out.println("codigo" + GeneroUsuario);
        //datos usuario
        double SaldoUsuario = 0.0;
        String TipoUsuario = "USUARIO";
        String EstadoUsuario = "ACTIVO";
        String Mensaje = "";
        try {
            SQLserver.getConexion().setAutoCommit(false);
            ps = SQLserver.getConexion().prepareStatement("insert into usuario (CodigoUsuario,NickName,NombreUsuario,ApellidoUsuario,CorreoUsuario,PasswordUsuario,TelefonoUsuario,FechaNacimiento,Genero) values (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, CodigoUsuario);
            ps.setString(2, NickName);
            ps.setString(3, NombreUsuario);
            ps.setString(4, ApellidoUsuario);
            ps.setString(5, CorreoUsuario);
            ps.setString(6, PasswordUsuario);
            ps.setString(7, TelefonoUsuario);
            ps.setString(8, FechaNacimiento);
            ps.setString(9, GeneroUsuario);
            ps.executeUpdate();
            ps = SQLserver.getConexion().prepareStatement("insert into datosUsuario (CodigoUsuario,SaldoUsuario,TipoUsuario,EstadoUsuario) values (?,?,?,?)");
            ps.setString(1, CodigoUsuario);
            ps.setDouble(2, SaldoUsuario);
            ps.setString(3, TipoUsuario);
            ps.setString(4, EstadoUsuario);
            ps.executeUpdate();
            SQLserver.getConexion().commit();
            response.getWriter().write("OK");
            ps.close();
        } catch (Exception e) {            
            e.printStackTrace();
            try {
                SQLserver.getConexion().rollback();
            } catch (SQLException ex) {
                Logger.getLogger(registrar.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*el response se envia al scrib ajax con  el mismo function (response)*/
            response.getWriter().write("Revise de nuevo");
        }        

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
