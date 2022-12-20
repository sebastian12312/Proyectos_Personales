/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ServLetUsuario;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Funciones.FuncionTienda;
import clases.Productos;
import clases.cart;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AgregarProducto", urlPatterns = {"/AgregarProducto"})
public class AgregarProducto extends HttpServlet {

    FuncionTienda funciontienda = new FuncionTienda();
    Productos producto = new Productos();
    cart carrito = new cart();
    ArrayList<cart> ListaCarrito = new ArrayList<cart>();
    double SubTotal = 0.0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        addProducto(request);
        session.setAttribute("ListarCarrito", ListaCarrito);
        int Canti = ListaCarrito.size();
        String MensajeCarrito ="";
        if(Canti > 0){
            MensajeCarrito = "CarritoLleno";
        }else{
            MensajeCarrito = "CarritoVacio";
        }
        double SubTotalCarrito = 0.0;
        for (int i = 0; i <ListaCarrito.size(); i++) {
            SubTotalCarrito = ListaCarrito.get(i).getSubTotal() + SubTotalCarrito;
        }
        /**/
        double PrecioIGV = 0.18;
        double IGV = (SubTotalCarrito * PrecioIGV); 
        /**/       
        double Desc = 0.10;
        int DescuentoEntero = (int)(Desc *  100);     
        double DescuentoPrecio = Desc * SubTotalCarrito;
        double PrecioFinalCarrito = SubTotalCarrito - DescuentoPrecio;
        /*        
        RESPUESTA 
        */
        session.setAttribute("DescuentoPrecio", DescuentoPrecio);
        session.setAttribute("DescuentoEntero", DescuentoEntero);
        session.setAttribute("IGV", IGV);
        session.setAttribute("SubTotalCarrito", SubTotalCarrito);
        session.setAttribute("PrecioFinalCarrito", PrecioFinalCarrito);
        session.setAttribute("MensajeCarrito",MensajeCarrito);
        request.setAttribute("CantidadCarrito", Canti);
        session.setAttribute("ListaCarrito",ListaCarrito);
        request.getRequestDispatcher("Tienda.jsp").forward(request, response);
    }

    protected void addProducto(HttpServletRequest request) {
        String codigoProducto = request.getParameter("codigo");
        int Posicion = 0;
        int Cantidad = 1;
        producto = funciontienda.BuscarProducto(codigoProducto);
        carrito = new cart();
        if (ListaCarrito.size() > 0) {
            for (int i = 0; i < ListaCarrito.size(); i++) {
                if (ListaCarrito.get(i).getCodigoProducto().equals(codigoProducto)) {
                    Posicion = i;
                }
            }
            if (ListaCarrito.get(Posicion).getCodigoProducto().equals(codigoProducto)) {
                Cantidad = ListaCarrito.get(Posicion).getCantidadProducto() + Cantidad;
                SubTotal = ListaCarrito.get(Posicion).getPrecioProducto() * Cantidad;
                ListaCarrito.get(Posicion).setCantidadProducto(Cantidad);
                ListaCarrito.get(Posicion).setSubTotal(SubTotal);
            } else {
                carrito = new cart();
                Posicion = Posicion + 1;
                carrito.setPosicionCarrito(Posicion);
                carrito.setCodigoProducto(producto.getCodigoProducto());
                carrito.setNombreProducto(producto.getNombreProducto());
                carrito.setDescripcionProducto(producto.getDescripcionProducto());
                carrito.setCantidadProducto(Cantidad);
                carrito.setPrecioProducto(producto.getPrecioUnidadProducto());                
                carrito.setDescuentoProducto(producto.getDescuentoProducto());
                carrito.setSubTotal(Cantidad * producto.getPrecioUnidadProducto());
                carrito.setImagenProducto(producto.getImagenProducto());
                ListaCarrito.add(carrito);
            }
        } else {
            carrito = new cart();           
            carrito.setPosicionCarrito(Posicion +1 );
            carrito.setCodigoProducto(producto.getCodigoProducto());
            carrito.setNombreProducto(producto.getNombreProducto());
            carrito.setDescripcionProducto(producto.getDescripcionProducto());
            System.out.println("descripco =" + producto.getDescripcionProducto());
            carrito.setCantidadProducto(Cantidad);
            carrito.setPrecioProducto(producto.getPrecioUnidadProducto());
            carrito.setDescuentoProducto(producto.getDescuentoProducto());
            carrito.setSubTotal(Cantidad * producto.getPrecioUnidadProducto());
            carrito.setImagenProducto(producto.getImagenProducto());
            ListaCarrito.add(carrito);
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
