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
        FuncionSession funcionSesion = new FuncionSession();
        Generadores generador = new Generadores();
        String CodigoUsuario = generador.GeneradorDeCodigoUsuario();

        String usuario = request.getParameter("usuario");
        String email = request.getParameter("email");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String password1 = request.getParameter("password1");
        String Telefono = request.getParameter("Telefono");
        String genero = request.getParameter("genero");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        double SaldoUsuario = 0.0;
        String TipoUsuario = "USUARIO";
        String EstadoUsuario = "ACTIVO";
        
        int respuesta = funcionSesion.RegistrarUsuario(CodigoUsuario, usuario, nombre, apellido, Telefono, email, password1, genero, fechaNacimiento);
        System.out.println("resultado" + respuesta);
//        if (respuesta == 1) {
//            int respuesta2 = funcionSesion.RegistrarDatosUsuario(CodigoUsuario, SaldoUsuario, TipoUsuario, EstadoUsuario);
//        }else{
//         
//        }
        response.sendRedirect("index.jsp");
        
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
