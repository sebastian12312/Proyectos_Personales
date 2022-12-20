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
        Double SaldoUsuario = (Double) session.getAttribute("SaldoUsuario");

    %>
    <body>
        <header class="header" id="header">
            <div class="contenedor_header_1">
                <div class="titulo_header">
                    <h1><a href="#">DisenoWeb</a></h1>
                </div>
                <div class="menu_header">
                    <ul class="contenedor_menu">
                        <li><a id="" href="Tienda/Tienda">Tienda</a></li>
                        <li><a id="abc" data-tienda="tienda">contacto</a></li>
                        <li><a class="">Nosotros</a></li>
                    </ul>
                </div>
            </div>
            <div class="contenedor_header_2">
                <%                    if (CodigoUsuario != null) {

                %>
                <div class="header_Usuario">
                    <div class="header_datosUsuario header_droptown">
                        <a id="NombreUsuario"><%=usuario%></a>
                        <a href="#">
                            <li class="fa fa-bars"></li>
                        </a>
                        <div class="header_menu_droptown">
                            <ul class="menu_droptown">
                                <li><a id="dropMisCompras">Mis Compras</a></li>
                                <li><a id="dropTienda">Tienda</a></li>
                                <li><a id="dropMiSaldo">Saldo: $ <%=SaldoUsuario%></a></li>
                                <li><a id="dropCerrarSesion" href="session?false=">cerrar sesion</a></li>
                            </ul>
                        </div>
                    </div>
                </div>  
                <%
                } else {
                %>   


                <div class="header_NoUsuario">
                    <div class="header_sesionUsuario">
                        <a id="AbrirVentanaLogin">
                            <li class="fa fa-user"></li><span>iniciar sesion</span>
                        </a>
                        <a id="AbrirVentanaRegister">
                            <li class="fa fa-edit"></li><span>registrar</span>
                        </a>
                        <a id="AbrirVentanaLateralNoUsuario">
                            <li class="fa fa-bars"></li>
                        </a>
                    </div>
                </div>
                <%}%>

            </div>
        </header>

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
        <div class="contenedor_modal" id="contenedor_modal_login">
            <form action="session" method="post" class="formulario_login">
                <div class="logo_modal_login">
                    <a></a>
                </div>
                <div class="datos_login">
                    <label for="">correo o usuario:</label>
                    <input type="text" name="usuario">
                </div>
                <div class="datos_login">
                    <label for="">contrasena:</label>
                    <div class="ver_password_login">
                        <input type="password" id="password_modal" name="password">
                        <a id="ver_password">
                            <li class="fa fa-eye "></li>
                            <li class="fa fa-eye-slash eye2"></li>
                        </a>
                    </div>
                </div>

                <div class="datos_login">
                    <a href="#">Olvidastes Tu contrasena?</a>
                </div>
                <div class="btn_login" id="btn_login">
                    <input type="submit" value="iniciar sesion">
                    <a id="CerrarVentanaLogin">cerrar ventana</a>
                </div>
            </form>
        </div>

        <div class="contenedor_modal" id="contenedor_modal_register">
            <form action="" class="formulario_register">
                <h1>REGISTRATE</h1>
                <div class="contenedor_datos_register">
                    <div class="datos_register">
                        <label for="">usuario*:</label>
                        <input type="text">
                    </div>
                    <div class="datos_register">
                        <label for="">E-mail*:</label>
                        <input type="text">
                    </div>
                </div>
                <div class="contenedor_datos_register">
                    <div class="datos_register">
                        <label for="">Nombre*:</label>
                        <input type="text">
                    </div>
                    <div class="datos_register">
                        <label for="">Apellido*:</label>
                        <input type="text">
                    </div>
                </div>
                <div class="contenedor_datos_register">
                    <div class="datos_register">
                        <label for="">contrasena*:</label>
                        <input type="text">
                    </div>
                    <div class="datos_register">
                        <label for="">Repetia su contrasena*:</label>
                        <input type="text">
                    </div>
                </div>
                <div class="contenedor_datos_register">
                    <div class="datos_register">
                        <label for="">Genero*:</label>
                        <select name="" id="">
                            <option value="MASCULINO">MASCULINO</option>
                            <option value="FEMENINO">FEMENINO</option>
                        </select>
                    </div>
                    <div class="datos_register">
                        <label for="">Fecha de Nacimiento*:</label>
                        <input type="date">
                    </div>
                </div>
                <div class="btn_modal_register">
                    <input type="submit" value="registrarse">
                    <a id="CerrarModalRegister">cerrar ventana</a>
                </div>
            </form>
        </div>


        <script src="js/header.js"></script>
        <script src="js/modal.js"></script>
        <script src="js/slider.js"></script>
    </body>

</html>