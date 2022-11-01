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

import conexionBD.SQLSever;
import javax.servlet.http.HttpSession;
import Funciones.FuncionesSession;
import clases.datosUsuario;
import clases.usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "session", urlPatterns = {"/session"})
public class session extends HttpServlet {

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
        HttpSession session = request.getSession();
        //Variables
        List lista = new ArrayList<>();
         String id_usuario = request.getParameter("id_usuario");
        String password = request.getParameter("password");
        String codigo_usuario;
        //Objetos
        FuncionesSession funcionSession = new FuncionesSession();
        usuario user = new usuario();
        datosUsuario datos = new datosUsuario();
       
     
        //Clases        
        codigo_usuario = funcionSession.ValidacionLogin(id_usuario, password);   
        
        
        //session       
        //DatosUsuarios
        
        datos = funcionSession.DatosUsuario(codigo_usuario);
        user = funcionSession.UsuarioMain(codigo_usuario);
        if(codigo_usuario != null){ 
            if (datos.getTipo_Usuario().equals("USUARIO") && datos.getEstado_Usuario().equals("ACTIVO")) {
                //validacion usuario activado
                session.setAttribute("CodigoUsuario" ,codigo_usuario);
                session.setAttribute("NickName", user.getNickName_Usuario());
                session.setAttribute("SaldoUsuario", datos.getSaldo_Usuario());
                String MensajeErrorLogin = "MensajeErrorLogin";
                session.setAttribute("MensajeErrorLogin", MensajeErrorLogin);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }else if (datos.getTipo_Usuario().equals("ADMINISTRADOR") && datos.getEstado_Usuario().equals("ACTIVO")) {
                //validacion administrador activo
                session.setAttribute("CodigoUsuario" ,codigo_usuario);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }else{
                //error en ambas validacion
                String MensajeError = "El Usuario o Contrasena incorrecto por favor Vuelva a Ingresar!";
           
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }else{        
            //usuario no reconocido en la base de datos
           
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }                
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
