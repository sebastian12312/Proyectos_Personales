/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Tienda;

import clases.DatosUsuario;
import clases.cart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import funciones.Generadores;
import funciones.*;
import java.util.Random;

/**
 *
 * @author sebastian
 */
@WebServlet(name = "comprar", urlPatterns = {"/comprar"})
public class comprar extends HttpServlet {

    FuncionSession funcionSesion = new FuncionSession();
    FuncionTienda funcionTienda = new FuncionTienda();
    DatosUsuario datosUser = new DatosUsuario();
    Generadores generador = new Generadores();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String CodigoUsuario = (String) session.getAttribute("CodigoUsuario");
        String MensajeNoLogueado = "";
        String MensajeCarritoVacio = "";
        String MensajeError= "";
        String MensajeConfirmacion = (String) session.getAttribute("MensajeConfirmacion");
        if (MensajeConfirmacion.equals("aceptado")) {
            if (CodigoUsuario != null) {
                ArrayList<cart> carritoCompras = (ArrayList<cart>) session.getAttribute("CarritoDeComprasBuy");
                datosUser = funcionSesion.BuscarUsuario(CodigoUsuario);
                double PrecioFinal = (Double) session.getAttribute("PrecioFinal");
                double IGVCarrito = (Double) session.getAttribute("IGVCarrito");
                double DescuentoCarrito = (Double) session.getAttribute("DescuentoCarrito");
                String Estado = "CANCELADO";
                String FechaCompra = generador.FechaBD();
                String CodigoCompra = generador.GeneradorDeCodigo();
                double SaldoUsuario = funcionSesion.BuscarSaldoUsuario(CodigoUsuario);               
                if (SaldoUsuario >= PrecioFinal) {                            
                    int respuesta = funcionTienda.RegistrarCompra(CodigoCompra, CodigoUsuario, PrecioFinal, PrecioFinal, FechaCompra, Estado);
                    double NuevoSaldo = SaldoUsuario - PrecioFinal;
                    int respuestaSaldo = funcionSesion.ActualizarSaldo(CodigoUsuario, NuevoSaldo);
                    if (respuesta == 1) {
                        for (int i = 0; i < carritoCompras.size(); i++) {
                            cart c = carritoCompras.get(i);
                            funcionTienda.RegistrarDetallesCompras(CodigoCompra, c.getCodigo_Producto_Cart(), c.getNombre_Producto_Cart(), c.getDescripcion_Producto_Cart(), c.getCantidad_Producto_Cart(), c.getPrecio_Producto_cart(), c.getPrecio_Producto_cart(), c.getDescuento_Producto_Cart());
                        }
                        carritoCompras.clear();
                        MensajeError = "COMPRA EXITOSA";
                        
                    } else {
                        MensajeError = "OCURRIO UN ERROR COMUNIQUESE CON LOS ADMINISTRADORES!";
                        session.setAttribute("MensajeError", MensajeError);
                    }
                } else {
                    // saldo insuficiente
                    MensajeError = "Saldo insuficiente";
                    session.setAttribute("MensajeError", MensajeError);
                }
            } else {
                // usuario no registrado
                MensajeError = "USUARIO NO REGISTRADO";
                session.setAttribute("MensajeError", MensajeError);
            }
        } else {
            //carrito sin producto
            MensajeError = "Carrito de Compras Sin Productos";
            session.setAttribute("MensajeError", MensajeError);
        }

        response.sendRedirect("carrito");

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
