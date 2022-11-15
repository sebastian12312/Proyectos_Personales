/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

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

import Funciones.*;
import clases.datosUsuario;
import clases.usuario;
/**
 *
 * @author sebastian
 */
@WebServlet(name = "Comprar", urlPatterns = {"/Comprar"})
public class Comprar extends HttpServlet {
    FuncionesSession funcionUsario =new FuncionesSession();
    FuncionesCompras FuncionCompras = new FuncionesCompras();
    FuncionesSession funcioneSession = new FuncionesSession();
    GeneradorDeCodigo generador = new GeneradorDeCodigo();
    datosUsuario usuario = new datosUsuario();
    cart carrito = new cart();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double PrecioFinal = 0.0;
        double TotalCarrito = 0.0;
        double Descuento = 1;
        String CodigoCompra =generador.CrearCodigo();
        String EstadoCompra = "ENTREGADO";
        int Respuesta;
        //
        String MensajeCompra="";
        HttpSession session = request.getSession();   
        ArrayList<cart> cart = (ArrayList<cart>) session.getAttribute("ListaCarrito");
        String codigoUsuario=  (String) session.getAttribute("CodigoUsuario");       
        if(codigoUsuario != null){
              usuario = funcionUsario.DatosUsuario(codigoUsuario);
            for (int i = 0; i < cart.size(); i++) {
                TotalCarrito = TotalCarrito + cart.get(i).getSubTotal();
            }
             PrecioFinal = TotalCarrito -(TotalCarrito * Descuento);
            if (PrecioFinal <= usuario.getSaldo_Usuario()) {
                Respuesta = FuncionCompras.RegistrarCompra(CodigoCompra, codigoUsuario, TotalCarrito, PrecioFinal, "12-12-12", EstadoCompra);
                    
                if (Respuesta == 1) {                    
                    for (int i = 0; i < cart.size(); i++) {
                        carrito = cart.get(i);
                        FuncionCompras.ResgistrarDetallesCompras(CodigoCompra, carrito.getCodigoCarrito(), carrito.getNombreProducto(), carrito.getDescricionCarrito(), carrito.getCantidadCompra(), carrito.getPrecioUnidad(), carrito.getPrecioUnidad(), Descuento);
                    }
                    cart.clear(); 
                    double NuevoSaldo = usuario.getSaldo_Usuario() - PrecioFinal;
                    int respuestaSaldo = funcioneSession.ActualizarSaldo(codigoUsuario, NuevoSaldo);
                    if (respuestaSaldo == 1) {
                         MensajeCompra = "Compra Exitosa";
                         request.setAttribute("MensajeCompra", MensajeCompra);
                         request.getRequestDispatcher("carrito").forward(request, response);
                    }else{
                        
                         request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                   
                }else{
                    MensajeCompra = "Producto No disponible Intentar Mas Tarde!";
                    request.getRequestDispatcher(MensajeCompra);
                    request.getRequestDispatcher("carrito").forward(request, response);
                }
            }else{
            MensajeCompra = "Saldo Insuficiente";
            request.getRequestDispatcher(MensajeCompra);
            request.getRequestDispatcher("carrito").forward(request, response);
            }
        }else{
        MensajeCompra = "Usuario No Registrador Por Favor Neseceita Loguearse";
        request.getRequestDispatcher(MensajeCompra);
        request.getRequestDispatcher("carrito").forward(request, response);
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
