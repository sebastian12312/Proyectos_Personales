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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jdk.nashorn.internal.codegen.types.NumericType;

/**
 *
 * @author sebastian
 */
@WebServlet(name = "Agregar", urlPatterns = {"/Agregar"})
public class Agregar extends HttpServlet {

    ArrayList<cart> carrito = new ArrayList<>();
    cart cart = new cart();
    Producto producto = new Producto();
    FuncionesTienda funcionTienda = new FuncionesTienda();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String codigo = request.getParameter("codigo");

        añadirProducto(request);
        int Contador = carrito.size();
        session.setAttribute("ListaCarrito", carrito);
        request.setAttribute("contador", Contador);
        request.getRequestDispatcher("Tienda").forward(request, response);

    }

    private void añadirProducto(HttpServletRequest request) {
        String codigo = request.getParameter("codigo");
        producto = funcionTienda.BuscarProducto(codigo);
        int posicion = 0;
        int cantidad = 1;
        double subtotal = 0.0;
       
        if (carrito.size() > 0) {
            for (int i = 0; i < carrito.size(); i++) {
                if (carrito.get(i).getCodigoCarrito() == codigo) {
                    posicion = i;
                }
            }
            if (carrito.get(posicion).getCodigoCarrito() == codigo) {
                cart = new cart();
                cantidad = carrito.get(posicion).getCantidadCompra() + cantidad;
                subtotal = carrito.get(posicion).getPrecioUnidad() * cantidad;
                carrito.get(posicion).setCantidadCompra(cantidad);
                carrito.get(posicion).setSubTotal(subtotal);
                System.out.println("ingreso");
            } else {
               
                cart.setCodigoCarrito(producto.getCodigo_Producto());
                cart.setNombreProducto(producto.getNombre_Producto());
                cart.setDescricionCarrito(producto.getDescripcion_Producto());
                cart.setCantidadCompra(cantidad);
                cart.setPrecioUnidad(producto.getPrecioUnidad_Producto());
                cart.setDescuentoProducto(producto.getDescuento_Producto());
                cart.setSubTotal(cantidad * producto.getPrecioUnidad_Producto());
                cart.setImagenProducto(producto.getImagen_Producto());
                carrito.add(cart);
            }
        } else {
            cart = new cart();
            cart.setCodigoCarrito(producto.getCodigo_Producto());
            cart.setNombreProducto(producto.getNombre_Producto());
            cart.setDescricionCarrito(producto.getDescripcion_Producto());
            cart.setCantidadCompra(cantidad);
            cart.setPrecioUnidad(producto.getPrecioUnidad_Producto());
            cart.setDescuentoProducto(producto.getDescuento_Producto());
            cart.setSubTotal(cantidad * producto.getPrecioUnidad_Producto());
            cart.setImagenProducto(producto.getImagen_Producto());
            carrito.add(cart);
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
