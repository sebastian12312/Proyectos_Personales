<%-- 
    Document   : index
    Created on : Dec 18, 2022, 7:59:19 PM
    Author     : sebastian
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="clases.cart"%>
<%@page import="java.util.ArrayList"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Diseño Web</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!-- fuente -->
        <link rel="stylesheet" href="css/fuente.css">
        <!-- header y footer -->
        <link rel="stylesheet" href="css/header_footer.css">
        <!-- Modal  -->
        <link rel="stylesheet" href="css/modalUsuario.css">
        <!-- slider 0-->
        <link rel="stylesheet" href="css/slider.css">
        <!--  -->
        <link rel="stylesheet" href="css/index.css">

        <link rel="stylesheet" href="css/carrito.css">
    </head>
    <%
        String usuario = (String) session.getAttribute("usuario");
        String CodigoUsuario = (String) session.getAttribute("CodigoUsuario");
        session.setAttribute("CodigoUsuario", CodigoUsuario);
        session.setAttribute("CodigoUsuario", CodigoUsuario);
        Double SaldoUsuario = (Double) session.getAttribute("SaldoUsuario");

    %>
    <body>
              <header class="header" id="header">
            <div class="contenedor-header">
                <div class="contenedor-menu-header">
                    <div class="titulo-header">
                        <a href="#">Diseno Web</a>
                    </div>
                    <div class="contenedor-menu">
                        <a href="#">Inicio</a>
                        <a href="#">Tienda</a>
                        <a href="#">nosotros</a>
                        <a href="#">contacto</a>
                    </div>
                </div>
                <div class="contenedor-autenticacion-header">
                    <div class="cambio-theme" id="cambio-theme">
                        <div class="theme-light"><img src="img/validaciones/full.png" alt=""></div>
                        <div class="theme-dark"><img src="img/validaciones/sunglasses.png" alt=""></div>
                        <div class="buttom-theme"></div>
                    </div>

                    <div class="datos_usuario">
                        <%
                            if (CodigoUsuario != null) {

                        %>
                        <div class="usuario-logueado" >
                            <a><%=usuario%></a>
                            <a href="#">
                                <li class="fa fa-bars"></li>
                            </a>
                        </div>

                        <%                    
                            } else {
                        %>
                        <div class="usuario-no-logueado" >
                            <a  class="login_user">
                                <span>
                                    <li class="fa fa-user"></li>
                                </span>
                                <p> iniciar sesion </p>
                            </a>
                            <a href="registrar.jsp">
                                <span>
                                    <li class="fa fa-edit"></li>
                                </span>
                                <p>registrar</p>
                            </a>
                            <a href="#">
                                <li class="fa fa-bars"></li>
                            </a>
                        </div>

                        <%
                            }
                        %>
                    </div>

                </div>
            </div>
        </header>
        <div class="body_contenedor_login" id="body_contenedor_login">
            <div class="contenedor_login">
                <h1>Iniciar sesion</h1>
                <div class="iniciar_redes_sociales">
                    <a href="#">
                        <li class="fa fa-google"></li> Google
                    </a>
                    <a href="#">
                        <li class="fa fa-facebook"> </li> Facebook
                    </a>
                    <a href="#">
                        <li class="fa fa-github"></li> GitHub
                    </a>
                </div>
                <form action="session" method="post">
                    <div class="division_fomulario">
                        <label for="">usuario</label>
                        <input type="text" placeholder="Escribe tu correo Electronico" name="usuario"  >
                    </div>
                    <div class="division_fomulario">
                        <label for="">Contraseña</label>
                        <div class="view_eye">
                            <input type="password" placeholder="Escribe tu contraseña" id="pass1" name="password">
                            <a data-password="view_pass1">
                                <li class="fa fa-eye"></li>
                            </a>
                        </div>
                    </div>
                    <div class="btn_formulario">
                        <input type="submit" name="name" value="iniciar sesion">
                     
                    </div>
                </form>
            </div>
        </div>

        <div class="contenedor_carrito_compras">
            <section class="seccion_carrito_compras">
                <div class="carrito_compras">               
                    <table class="table_carrito_compras">
                        <tr>
                            <td>#</td>
                            <td>imagen</td>
                            <td>Descripcion</td>
                            <td>Precio</td>
                            <td>Cantidad</td>
                            <td>Precio Total</td>
                            <td>Elimar</td>
                        </tr>
                        <%
                            String MensajeConfirmacion = (String) session.getAttribute("MensajeConfirmacion");
                            if (MensajeConfirmacion.equals("aceptado")) {

                                int ContadorCarrito = 0;
                                ArrayList<cart> carritoCompras = (ArrayList<cart>) session.getAttribute("CarritoDeComprasBuy");
                                for (int i = 0; i < carritoCompras.size(); i++) {
                                    cart c = carritoCompras.get(i);
                                    ContadorCarrito++;
                        %>
                        <tr>                              
                            <td><%=ContadorCarrito%></td>
                            <td><img src="img/axe2.png" alt=""></td>
                            <td><%=c.getNombre_Producto_Cart()%></td>
                            <td>$ <%=c.getPrecio_Producto_cart()%></td>
                            <td><%=c.getCantidad_Producto_Cart()%></td>
                            <td>$ <%=c.getSubTotal_Producto_Cart()%></td>
                            <td><a href="#"  class="delete_producto_carrito"><li class="fa fa-trash"></li></a></td>
                        </tr>
                        <%
                            }
                        } else {
                        %>
                        <tr>
                            <td colspan="9">
                                <h1>NO HAY PRODUCTOS EN EL CARRITO DE COMPRAS</h1>
                                <img src="https://cdn-icons-png.flaticon.com/512/3082/3082011.png" alt="alt"/>
                            </td>
                        </tr>
                        <%}%>
                    </table>
                </div>
            </section>
            <section class="seccion_datos_carritos">
                <div class="datos_carrito">
                    <div class="titulo_datos_carrito">
                        <span>carrito de compras: ( ${CantidadProductosCompras} )item</span>
                    </div>
                    <div class="datos_carrito_compras">
                        <p>SubTotal</p>
                        <p>$ ${PrecioFinal}</p>
                    </div>
                    <div class="datos_carrito_compras">
                        <p>IGV</p>
                        <p>$ ${IGVCarrito}</p>
                    </div>
                    <div class="datos_carrito_compras">
                        <p>Descuento</p>
                        <p>$ ${PrecioFinal}</p>
                    </div>
                    <div class="datos_carrito_compras border_top_datos_carrito">
                        <p>Precio Final</p>
                        <p>$ ${PrecioFinal}</p>
                    </div>
                    <div class="MensajeErrorCompras">
                        <p style="color: red">
                            ${MensajeError}
                        </p>
                    </div>
                    <div class="btn_carrito_compras">
                        <a href="Tienda"><li class="fa fa-plus"></li> seguir comprando</a>
                        <a href="comprar"><li class="fa fa-check"></li> comprar</a>
                        <a href=""><li class="fa fa-pencil-square-o"></li> generar compra</a>
                    </div>
                   
                </div>
            </section>
        </div>


        <!-- others -->

        <!-- barralateral no usuario -->
        <div class="contenedor_barra_lateral" id="contenedor_barra_lateral_NoUsuario">
            <div class="barra_lateral_NoUsuario">
                <div class="cerrar_barra_lateral">
                    <a id="CerrarVentanaLateralNoUsuario">
                        <li class="fa fa-close"></li>
                    </a>
                </div>
                <ul class="menu_barra_lateral_NoUsuario">
                    <h1>Menu</h1>
                    <li><a>Tienda</a></li>
                    <li><a>contacto</a></li>
                    <li><a class="">Nosotros</a></li>
                </ul>
            </div>
        </div>
        <!-- modal login -->
       

      


        <script src="js/header.js"></script>
        <script src="js/modal.js"></script>
        <script src="js/slider.js"></script>
    </body>

</html>