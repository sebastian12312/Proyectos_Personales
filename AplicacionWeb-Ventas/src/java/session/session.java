/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package session;

import clases.DatosUsuario;
import com.sun.xml.internal.ws.resources.SenderMessages;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funciones.FuncionSession;
import javax.json.JsonObject;
import javax.servlet.http.HttpSession;

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
        HttpSession session = request.getSession();
        String cerrar = request.getParameter("cerrar");
        if (cerrar.equals("true")) {
            session.invalidate();
            response.sendRedirect("index.jsp");
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
        FuncionSession funcionSesion = new FuncionSession();
        DatosUsuario user = new DatosUsuario();
        HttpSession session = request.getSession();
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        user = funcionSesion.Usuario(usuario, password);

        String MensajeSession = "";
        if (user.getCodigoUsuario() != null) {
            if (user.getTipoUsuario().equals("USUARIO")) {
                session.setAttribute("usuario", user.getNickNameUsuario());
                session.setAttribute("CodigoUsuario", user.getCodigoUsuario());
                session.setAttribute("SaldoUsuario", user.getSaldoUsuario());
                response.sendRedirect("index.jsp");
            } else if (user.getTipoUsuario().equals("ADMINISTRADOR")) {
                response.sendRedirect("administrador/dashboard.jsp");
            }
        } else {
           
         response.sendRedirect("index.jsp");
           
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
