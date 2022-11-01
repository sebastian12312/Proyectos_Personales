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

    FuncionesSession funcionSession = new FuncionesSession();
    usuario user = new usuario();
    datosUsuario datos = new datosUsuario();

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
        int valor = Integer.parseInt(request.getParameter("logout"));
        if(valor == 1){
            HttpSession session = request.getSession();
            session.invalidate();
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else{
             HttpSession session = request.getSession();
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
        //HttpSession
        HttpSession session = request.getSession();
        //Variables      
        String id_usuario = request.getParameter("id_usuario");
        String password = request.getParameter("password");
        String codigo_usuario;
        String Mensaje = "";
        String accion = "";
        String Identificador = "ActivarMensaje";
        //Validacion        
        codigo_usuario = funcionSession.ValidacionLogin(id_usuario, password);
        //Funciones
        datos = funcionSession.DatosUsuario(codigo_usuario);
        user = funcionSession.UsuarioMain(codigo_usuario);
        if (codigo_usuario != null) {
            if (datos.getTipo_Usuario().equals("USUARIO") && datos.getEstado_Usuario().equals("ACTIVO")) {
                //validacion usuario activado
                //VARIABLES
                accion = "UsuarioSiExiste";
                Mensaje = "Usuario conectado";
                //Enviar Atributos al Jsp
                session.setAttribute("accion", accion);
                session.setAttribute("CodigoUsuario", codigo_usuario);
                session.setAttribute("NickName", user.getNickName_Usuario());
                session.setAttribute("SaldoUsuario", datos.getSaldo_Usuario());
                session.setAttribute("Mensaje", Mensaje);
                session.setAttribute("Identificador", Identificador);
                //
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else if (datos.getTipo_Usuario().equals("ADMINISTRADOR") && datos.getEstado_Usuario().equals("ACTIVO")) {
                //validacion administrador activo
                session.setAttribute("CodigoUsuario", codigo_usuario);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                //error en ambas validacion
                //VARIABLES
                accion = "ValidacionERROR";
                Mensaje = "Usted Se Encuentra Suspendido!";
                //Enviar Atributos al Jsp
                session.setAttribute("Mensaje", Mensaje);
                session.setAttribute("Identificador", Identificador);
                session.setAttribute("accion", accion);
                //
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            //usuario no reconocido en la base de datos
            //variables
            Mensaje = "El Usuario No Existente";
            accion = "UsuarioNoExiste";
            //enviar al jsp
            session.setAttribute("accion", accion);
            session.setAttribute("Mensaje", Mensaje);
            session.setAttribute("Identificador", Identificador);
            //
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
