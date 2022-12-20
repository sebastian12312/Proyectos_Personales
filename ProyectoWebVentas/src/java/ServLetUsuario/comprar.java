/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ServLetUsuario;

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
import clases.*;
import Funciones.FuncionSession;
import java.util.Random;
@WebServlet(name = "comprar", urlPatterns = {"/comprar"})
public class comprar extends HttpServlet {

    DatosUsuario datosUser = new DatosUsuario();
    FuncionSession funcionsesion = new FuncionSession();
    public String GenCod(){
        Random random = new Random(); 
        char LETRA1 = (char) (random.nextInt(26) + 'A' );            
        char LETRA2 = (char) (random.nextInt(26) + 'A' );     
        char LETRA3 = (char) (random.nextInt(26) + 'A' ); 
        String setOfCharacters = "1234567890";
        int NUMERO = random.nextInt(setOfCharacters.length()+11);
        char randomChar = setOfCharacters.charAt(NUMERO);
        char randomChar2 = setOfCharacters.charAt(NUMERO);
        String letra = "COD"+LETRA1+randomChar+LETRA3+randomChar2+LETRA2;          
        return letra;
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String MensajeCompra ="";
        cart cart;
        String CodigoUsuario = (String) session.getAttribute("CodigoUsuario");
        System.out.println(CodigoUsuario);
        if (CodigoUsuario != null) {
            ArrayList<cart> ListaCarrito = (ArrayList) session.getAttribute("ListaCarrito");            
            if (ListaCarrito.size() > 0) {                
                double SubTotalCarrito = (Double) session.getAttribute("SubTotalCarrito");
                double IGV = (Double) session.getAttribute("IGV");
                double DescuentoPrecio = (Double) session.getAttribute("DescuentoPrecio");
                double PrecioFinalCarrito = (Double) session.getAttribute("PrecioFinalCarrito");
                String CodigoCompra = "abc";
                datosUser = funcionsesion.DatosUsuario(CodigoUsuario);
                if(datosUser != null){
                    if (PrecioFinalCarrito < datosUser.getSaldoUsuario()) {
                        int RespuestaCompra = funcionsesion.RegistrarCompra(CodigoCompra, CodigoUsuario, SubTotalCarrito, PrecioFinalCarrito, "12-12-12", "ENTREGADO");
                        if (RespuestaCompra == 1) {
                            int Respuesta2= 0;
                            for (int i = 0; i < ListaCarrito.size(); i++) {
                                cart carrito = ListaCarrito.get(i);
                                Respuesta2 = funcionsesion.RegistrarDetallesCompra(CodigoCompra, carrito.getCodigoProducto(), carrito.getNombreProducto(), carrito.getDescripcionProducto(), carrito.getCantidadProducto(), SubTotalCarrito,PrecioFinalCarrito, DescuentoPrecio);
                            }
                            if (Respuesta2 == 1) {
                                double NuevoSaldo = datosUser.getSaldoUsuario() - PrecioFinalCarrito;
                                int RespuestaSaldo = funcionsesion.ActualizarSaldo(CodigoUsuario, NuevoSaldo);
                                if (RespuestaSaldo == 1) {                                    
                                    if (datosUser.getSaldoUsuario() > 0) {
                                        MensajeCompra = "Compra Exitosa";
                                        request.setAttribute("MensajeCompra",MensajeCompra);    
                                        request.getRequestDispatcher("/carrito.jsp").forward(request, response);
                                    }else{
                                    funcionsesion.ActualizarSaldo(CodigoUsuario, NuevoSaldo);
                                    MensajeCompra ="Error Intente Mas Tarde";
                                    request.setAttribute("MensajeCompra",MensajeCompra);    
                                    request.getRequestDispatcher("carrito.jsp").forward(request, response);
                                    }
                                    
                                }else{
                                MensajeCompra ="Error Intente Mas Tarde";
                                request.setAttribute("MensajeCompra",MensajeCompra);    
                                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                                }
                                
                            }else{
                                MensajeCompra ="Error Intente Mas Tarde";
                                request.setAttribute("MensajeCompra",MensajeCompra);    
                                request.getRequestDispatcher("/carrito.jsp").forward(request, response);
                            }
                        }else{
                        MensajeCompra = "Saldo Insuficiente";
                        request.setAttribute("MensajeCompra",MensajeCompra);
                        }
                    }else{
                    MensajeCompra = "Saldo Insuficiente";
                    request.setAttribute("MensajeCompra",MensajeCompra);
                    }
                }else{
                MensajeCompra = "Error Intente Mas Tarde";
                request.setAttribute("MensajeCompra",MensajeCompra);
                }
            }else{
            MensajeCompra = "No Tienes producto en la Bolsa";
            request.setAttribute("MensajeCompra",MensajeCompra);
            request.getRequestDispatcher("/carrito.jsp").forward(request, response);
            }
        }else{
            MensajeCompra = "Necesita Loguearse Para poder Comprar El producto";
            request.setAttribute("MensajeCompra",MensajeCompra);
            request.getRequestDispatcher("/carrito.jsp").forward(request, response);
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
