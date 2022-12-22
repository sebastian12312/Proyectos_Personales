/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package usuario;

import clases.ComprasUsuario;
import clases.DetalleComprasUsuario;
import funciones.FuncionUsuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sebastian
 */
@WebServlet(name = "DetallesCompras", urlPatterns = {"/DetallesCompras"})
public class DetallesCompras extends HttpServlet {

    FuncionUsuarios funcionUsuario = new FuncionUsuarios();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String codigoUsuario = (String)session.getAttribute("CodigoUsuario");
        String codigoCompra = request.getParameter("codigoCompra");
        System.out.println("codiog" +codigoUsuario);
        ArrayList<DetalleComprasUsuario> details = new ArrayList<>();
        ComprasUsuario compras = new ComprasUsuario();
        if (codigoUsuario != null) {
            details = funcionUsuario.DetallesCompraUsuario(codigoUsuario, codigoCompra);
            compras = funcionUsuario.BuscarCompras(codigoCompra);
            session.setAttribute("fechaCompra", compras.getFechaCompra());
            session.setAttribute("SubTotalCompra",(Double)compras.getSubTotal());
            session.setAttribute("IGVcompras", (Double)compras.getIGVCompra());
            session.setAttribute("DescuentoCompras", (Double)compras.getDescuentoCompra());
            session.setAttribute("TotalAPagarComprobante", (Double)compras.getPrecioFInal());
            session.setAttribute("codigoCompraComprobante", codigoCompra);
            session.setAttribute("DetallesCompras", details);
            response.sendRedirect("usuario/DetallesCompras.jsp");
        }else{
            response.sendRedirect("index.jsp");
        }
        
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
        processRequest(request, response);
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
