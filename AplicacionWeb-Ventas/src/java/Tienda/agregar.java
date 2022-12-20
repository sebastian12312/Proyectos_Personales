/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Tienda;

import clases.cart;
import clases.producto;
import funciones.FuncionTienda;
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
@WebServlet(name = "agregar", urlPatterns = {"/agregar"})
public class agregar extends HttpServlet {

    FuncionTienda funcionTienda = new FuncionTienda();
    producto p = new producto();
    ArrayList<cart> carritoCompras = new ArrayList<>();
    cart carrito = new cart();
    double SubTotalCart = 0.0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String codigoProducto = request.getParameter("codigoProducto");
        addProducto(request, codigoProducto);
        session.setAttribute("CarritoDeCompras", carritoCompras); 
        //request.getRequestDispatcher("Tienda").forward(request, response);
        int CantidadProductosCompras=0;
        for (int i = 0; i < carritoCompras.size(); i++) {
           CantidadProductosCompras = carritoCompras.get(i).getCantidad_Producto_Cart()+CantidadProductosCompras;
        }
        session.setAttribute("CantidadProductosCompras", CantidadProductosCompras);
        response.sendRedirect("Tienda");
    }

    protected void addProducto(HttpServletRequest request, String codigoProducto) {

        int CantidadCompra = 1;
        p = funcionTienda.BuscarProducto(codigoProducto);
        carrito = new cart();
        int pos = 0;
        if (carritoCompras.size() > 0) {
            for (int i = 0; i < carritoCompras.size(); i++) {
                if (carritoCompras.get(i).getCodigo_Producto_Cart().equals(codigoProducto)) {
                    pos = i;
                }
            }
            if (carritoCompras.get(pos).getCodigo_Producto_Cart().equals(codigoProducto)) {
                CantidadCompra = carritoCompras.get(pos).getCantidad_Producto_Cart() + CantidadCompra;
                carritoCompras.get(pos).setCantidad_Producto_Cart(CantidadCompra);
                SubTotalCart = (Double) carritoCompras.get(pos).getPrecio_Producto_cart() * CantidadCompra;
                carritoCompras.get(pos).setSubTotal_Producto_Cart(SubTotalCart);
            } else {
                carrito.setCodigo_Producto_Cart(p.getCodigProducto());
                carrito.setNombre_Producto_Cart(p.getNombreProducto());
                carrito.setDescripcion_Producto_Cart(p.getDescripcionProducto());
                carrito.setCantidad_Producto_Cart(CantidadCompra);
                carrito.setPrecio_Producto_cart(p.getPrecioProducto());
                carrito.setImagen_Producto_Cart(p.getImagenProducto());
                carrito.setSubTotal_Producto_Cart(p.getPrecioProducto());
                carritoCompras.add(carrito);
            }
        } else {         
            carrito.setCodigo_Producto_Cart(p.getCodigProducto());
            carrito.setNombre_Producto_Cart(p.getNombreProducto());
            carrito.setDescripcion_Producto_Cart(p.getDescripcionProducto());
            carrito.setCantidad_Producto_Cart(CantidadCompra);
            carrito.setPrecio_Producto_cart(p.getPrecioProducto());
            carrito.setImagen_Producto_Cart(p.getImagenProducto());
            carrito.setSubTotal_Producto_Cart(p.getPrecioProducto());
            carritoCompras.add(carrito);
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
