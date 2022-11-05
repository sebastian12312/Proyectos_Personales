/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import Funciones.FuncionesTienda;
import clases.Producto;
import clases.cart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sebastian
 */
@WebServlet(name = "Agregar", urlPatterns = {"/Agregar"})
public class Agregar extends HttpServlet {

    ArrayList<cart> carrito =new  ArrayList<>();
    cart  cart = new cart();
    Producto producto = new Producto();
    int cant = 1;        
    FuncionesTienda funcionTienda = new FuncionesTienda();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              
        añadirProducto(request);
        request.setAttribute("carrito", carrito);
        request.setAttribute("contador", carrito.size());
        request.getRequestDispatcher("Tienda").forward(request, response);
       
    }

    public void añadirProducto(HttpServletRequest request) {
        String codigo = request.getParameter("codigo");
        producto =  funcionTienda.BuscarProducto(codigo);
        cart = new cart();
        cart.setCodigoCarrito(producto.getCodigo_Producto());
        cart.setNombreProducto(producto.getNombre_Producto());
        cart.setDescricionCarrito(producto.getDescripcion_Producto());
        cart.setCantidadCompra(cant);
        cart.setPrecioUnidad(producto.getPrecioUnidad_Producto());
        cart.setDescuentoProducto(producto.getDescuento_Producto());
        cart.setSubTotal(cant *producto.getPrecioUnidad_Producto());
        cart.setImagenProducto(producto.getImagen_Producto());
        carrito.add(cart);
        
    
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
