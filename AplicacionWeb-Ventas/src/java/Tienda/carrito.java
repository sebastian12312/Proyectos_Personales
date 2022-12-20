/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Tienda;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import clases.cart;
import clases.producto;
import funciones.FuncionTienda;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

@WebServlet(name = "carrito", urlPatterns = {"/carrito"})
public class carrito extends HttpServlet {

      protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<cart> carrito = (ArrayList<cart>) session.getAttribute("CarritoDeCompras");
        String Mensaje = "";
        DecimalFormat df = new DecimalFormat("#,##");
        if (carrito != null) {
            Mensaje = "aceptado";
            double TotalFinal= 0.0;
            double IGV=0.19;
            double DescuentoCarrito=0.01;
            
            for (int i = 0; i < carrito.size(); i++) {
                TotalFinal = carrito.get(i).getSubTotal_Producto_Cart()+ TotalFinal ;
            }
            double PrecioIGV = TotalFinal * IGV;
            double PrecioDescuentoCarrito = TotalFinal * DescuentoCarrito;
            String IGVString = df.format(PrecioIGV);
            String DescString = df.format(PrecioDescuentoCarrito);
            double RedondepDescuento = Double.parseDouble(DescString);
            double RedondeoIGV = Double.parseDouble(IGVString);
           ;
            session.setAttribute("DescuentoCarrito", RedondepDescuento);
            session.setAttribute("IGVCarrito", RedondeoIGV);
            session.setAttribute("PrecioFinal", TotalFinal);
            session.setAttribute("CarritoDeComprasBuy", carrito);
        } else {
            Mensaje = "rechazado";
        }
        session.setAttribute("MensajeConfirmacion", Mensaje);
        request.getRequestDispatcher("carrito.jsp").forward(request, response);


        
           
            
        
        
      
        
       
         

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
