/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package session;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import funciones.FuncionSession;
import funciones.Generadores;

@WebServlet(name = "ResgistrarUsuario", urlPatterns = {"/ResgistrarUsuario"})
public class ResgistrarUsuario extends HttpServlet {

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Generadores generadorCodigo = new Generadores();
        FuncionSession funcionSession = new FuncionSession();
        String CodigoUsuario = generadorCodigo.GeneradorCodigoUsuario();        
        String NombreUsuario = request.getParameter("NombreUsuario");
        String ApellidoUsuario = request.getParameter("ApellidoUsuario");
        String NickName = request.getParameter("NickName");
        String CorreoUsuario = request.getParameter("CorreoUsuario");
        String TelefonoUsuario = request.getParameter("TelefonoUsuario");
        String PasswordUsuario1 = request.getParameter("PasswordUsuario1");
        String PasswordUsuario2 = request.getParameter("PasswordUsuario2");
        String GeneroUsuario = request.getParameter("GeneroUsuario");
        String FechaNacimiento = request.getParameter("FechaNacimiento");
        String TipoUsuario = "USUARIO";
        String EstadoUsuario = "ACTIVO";
        double SaldoUsuario = 0.0;
        String MensajeRegistro = "";
        String RespuestaRegisterCSS = "";
        int respuesta = funcionSession.RegistrarUsuario(CodigoUsuario, NickName, NombreUsuario, ApellidoUsuario, TelefonoUsuario, CorreoUsuario, PasswordUsuario2, GeneroUsuario, FechaNacimiento);
        if (respuesta == 1) {
            int respuesta2 = funcionSession.RegistrarDatosUsuario(CodigoUsuario, SaldoUsuario, TipoUsuario, EstadoUsuario);
            MensajeRegistro = "usuario registrado";
            RespuestaRegisterCSS = "respuesta-modal";
            request.setAttribute("MensajeRegistro", MensajeRegistro);
            request.setAttribute("RespuestaRegisterCSS", RespuestaRegisterCSS);
            request.getRequestDispatcher("registrar.jsp").forward(request, response);
            // response.sendRedirect("registrar.jsp");
        }else{
            MensajeRegistro = "usuario no regisrado intente de nuevo";
            request.setAttribute("MensajeRegistro", MensajeRegistro);
            response.sendRedirect("registrar.jsp");
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
