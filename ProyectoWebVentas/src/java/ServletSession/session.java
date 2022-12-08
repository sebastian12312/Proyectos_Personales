/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ServletSession;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexion.conexionSQLServer;
import Funciones.FuncionSession;
import clases.DatosUsuario;
import clases.usuario;
import javax.servlet.http.HttpSession;

@WebServlet(name = "session", urlPatterns = {"/session"})
public class session extends HttpServlet {

    FuncionSession funcionsession = new FuncionSession();
    DatosUsuario datos = new DatosUsuario();
    
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
        String loguout = request.getParameter("loguout");
         HttpSession session = request.getSession();
        if(loguout.equals("true")){
            session.invalidate();
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
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
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        String MensajeLogin = "";

        String RespuestaLogin = funcionsession.ValidacionLogin(usuario, password);
        datos = funcionsession.DatosUsuario(usuario);
        if (RespuestaLogin != null) {
            if (datos.getTipoUsuario().equals("USUARIO")) {
                if (datos.getEstadoUsuario().equals("ACTIVO")) {                  
                   String NickName = datos.getNickName();
                   String CodigoUsuario = RespuestaLogin;
                   double SaldoUsuario = datos.getSaldoUsuario();
                   session.setAttribute("NickName", NickName);
                   session.setAttribute("CodigoUsuario", CodigoUsuario);
                   session.setAttribute("SaldoUsuario", SaldoUsuario);
                   request.getRequestDispatcher("index.jsp").forward(request, response);
                }else if (datos.getEstadoUsuario().equals("INNACTIVO")) {
                
                }else{
                
                }
            } else if (datos.getTipoUsuario().equals("ADMINISTRADOR")) {
                if (datos.getEstadoUsuario().equals("ACTIVO")) {
                    
                }else if (datos.getEstadoUsuario().equals("INNACTIVO")) {
                
                }else{
                
                }
            } else {

            }

        } else {
            MensajeLogin = "Usuario No Existente";
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
