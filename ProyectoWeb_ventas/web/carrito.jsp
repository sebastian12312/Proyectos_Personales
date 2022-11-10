<%-- 
    Document   : index
    Created on : 31 oct. 2022, 15:55:44
    Author     : sebastian
--%>

<%@page import="java.sql.Array"%>
<%@page import="clases.cart"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page session="true" %>
<%@page import="servlets.session"%>
<html lang="en">   
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Proyecto web</title>
        <link rel="stylesheet" href="css/fuente.css">
        <link rel="stylesheet" href="css/header-footer.css">
        <link rel="stylesheet" href="css/ventana-modal-login-register.css">
        <link rel="stylesheet" href="css/barra-responsive.css">
        <link rel="stylesheet" href="css/droptown.css">
        <link rel="stylesheet" href="css/carrito.css">
        <link rel="stylesheet" href="css/tienda.css">
        <link rel="stylesheet" href="css/MensajesModal.css">
        <link rel="stylesheet" href="css/dashboard-user.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <%
        String CodigoUsuario = (String) session.getAttribute("CodigoUsuario");
        session.setAttribute("CodigoUsuario", CodigoUsuario);
        String NickName = (String) session.getAttribute("NickName");
        String MensajeErrorLogin = (String) session.getAttribute("MensajeErrorLogin");
        Double SaldoUsuario = (Double) session.getAttribute("SaldoUsuario");

        //Mensajes del login
        String Mensaje = (String) session.getAttribute("Mensaje");
        String Identificador = (String) session.getAttribute("Identificador");
        String accion = (String) session.getAttribute("accion");
    %>

    <body>
        <!-- HEADER LOGUEADOS -->
        <%
            if (CodigoUsuario != null) {
        %>
        <nav class="header">
            <div class="contenedor_header">
                <div class="header_1">
                    <div class="header_titulo">
                        <h1><a href="#" class="titulo_responsive_off">Sistema ventas ${saldo}</a></h1>
                        <h1><a href="#" class="titulo_responsive">SV</a></h1>
                    </div>
                    <div class="header_opciones">
                        <ul class="opciones_header">
                            <li><a href="Tienda">Tienda</a></li>
                            <li><a href="#">Contacto</a></li>
                            <li> <a href="#">Colaboradores</a></li>
                        </ul>
                    </div>
                </div>
                <div class="header_2">
                    <div class="header_usuario droptown">
                        <a href="#" ><%=NickName%></a>
                        <div class="contenedor_droptown">
                            <a href="#">Saldo:$ <%=SaldoUsuario%></a>
                            <a href="#">Ajustes</a>
                            <a href="#">Recargar Saldo</a>
                            <a href="session?logout=1">Cerrar sesion</a>
                        </div>
                    </div>
                    <div class="barra_responsive">
                        <a id="barra-login-ON"><i class="fa fa-bars"></i></a>
                    </div>
                </div>
            </div>
        </nav>
        <div class="barra_responsive_on DisplayLoginOFF" id="barra_responsive_loginON">
            <div class="contenedor_barra_responsive">
                <a href="#" class="close_responsive" id="cerrar_barraResponsive_on"><i class="fa fa-close"></i></a>
                <div class="contenido_barra">

                    <h1><a href="#" class="titulo_responsive_1">Sistema ventas</a></h1>
                    <div class="a">
                        <ul class="opciones_responsive">
                            <li><a href="#">Saldo: $ 3000</a></li>
                            <li><a href="#">Tienda</a></li>
                            <li><a href="#">Contacto</a></li>
                            <li> <a href="#">Colaboradores</a></li>
                            <li><a href="#"> cerrar Sesion</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>                       
        <%
        } else {
        %>
        <!-- HEADER NO LOGUEADO -->
        <nav class="header">
            <div class="contenedor_header">
                <div class="header_1">
                    <div class="header_titulo">
                        <h1><a href="#" class="titulo_responsive_off">Sistema ventas</a></h1>
                        <h1><a href="#" class="titulo_responsive">SV</a></h1>
                    </div>
                    <div class="header_opciones">
                        <ul class="opciones_header">
                            <li><a href="Tienda">Tienda</a></li>
                            <li><a href="#">Contacto</a></li>
                            <li> <a href="#">Colaboradores</a></li>
                        </ul>
                    </div>
                </div>
                <div class="header_2">
                    <div class="header_login">
                        <a id="Iniciar_Sesion">Iniciar Sesion</a>
                    </div>
                    <div class="header_register">
                        <a id="registrate">Registrate</a>
                    </div>
                    <div class="barra_responsive">
                        <a id="barra-login-OFF"><i class="fa fa-bars"></i></a>
                    </div>
                </div>
            </div>
        </nav>
        <%
            }
        %>



        <%
            ArrayList<cart> carrito = (ArrayList<cart>) session.getAttribute("cart");
        %>

        <!-- CARRITO -->
        <a href="remove">Eliminar</a>
        <div class="carrito">
            <div class="contenedor_carrito_1">
                <table class="table_carrito" style="max-width: 1500px">
                    <tr>
                        <th>#</th>
                        <th>Codigo Producto</th>
                        <th>Nombre Producto</th>
                        <th>Descripcion Producto</th>
                        <th>Imagen Producto</th>
                        <th>Cantidad Producto</th>
                        <th>Precio Producto</th>
                        <th>Descuento Producto</th>
                        <th>SubTotal</th>
                        <th>Accion</th>
                    </tr>
                    <%
                        if (carrito != null) {


                    %>    
                    <%                        int contadorCarrito = 0;
                        for (int i = 0; i < carrito.size(); i++) {
                            cart car = carrito.get(i);
                            contadorCarrito++;
                    %>
                    <tr>
                        <td><%=contadorCarrito%></td>
                        <td><%=car.getCodigoCarrito()%></td>
                        <td><%=car.getNombreProducto()%></td>
                        <td><%=car.getDescricionCarrito()%></td>
                        <td ><img  src="img/axe.png" alt="ERROR"/></td>
                        <td><%=car.getCantidadCompra()%></td>
                        <td><%=car.getPrecioUnidad()%></td>
                        <td><%=car.getDescuentoProducto()%></td>
                        <td><%=car.getSubTotal()%></td>
                        <td>
                            <a href="remove?remove=<%=car.getCodigoCarrito()%>" class="delete_producto"><i class="fa fa-trash"></i></a>
                        </td>
                    </tr>
                    <%
                        }
                    %>      
                    <%
                    } else {
                    %>
                    <tr >
                        <td colspan="10">
                            <h3>NO HAY PRODUCTOS EN LA BOLSA</h3>
                            <img src="https://olsi-trade.ru/local/templates/olsi/img/icon/empty-basket.svg" alt="alt"/>
                        </td>                   
                    </tr>
                    <%
                        }
                    %>




                </table>
            </div>
            <div class="contenedor_carrito_2">
               
                <div class="datos_carrito">
                    <h3>carrito de compras</h3>
                    <div class="carrito_datos_compras">
                        <div>
                            <span>SubTotal:</span>
                        </div>
                        <%
                            Double TotalCarrito = (Double) request.getAttribute("TotalCarrito");
                        %>
                        <div>
                            <span><%=TotalCarrito%></span>
                        </div>
                    </div>
                    <div class="carrito_datos_compras">
                        <%
                            String IGV = (String) request.getAttribute("IGV");
                        %>
                        <div>
                            <span>IGV:</span>
                        </div>
                        <div>
                            <span><%=IGV%></span>
                        </div>
                    </div>
                    <div class="carrito_datos_compras">
                        <div>
                            <span>Descuento:</span>
                        </div>
                        <div>
                            <%
                                String Descuento = (String) request.getAttribute("Descuento");
                            %>
                            <span><%=Descuento%> %</span>
                        </div>
                    </div>
                    <div class="linea_carrito">

                    </div>
                    <div class="carrito_datos_compras">
                        <div>
                            <span>Precio Final:</span>
                        </div>
                        <div>
                            <%
                                String PrecioFinal = (String) request.getAttribute("PrecioFinal");
                            %>
                            <span><%=PrecioFinal%></span>
                        </div>
                    </div>
                    <div class="btn_carrito">
                        <a href="Comprar">Generar Compra</a>
                    </div>
                    <div class="seguir_comprando">
                        <a href="#">Seguir Comprando</a>
                    </div>
                </div>                   
            </div>
        </div>

        <!-- LOGIN -->
        <div class="contenedor_ventana_modal" id="ventana_login">
            <form action="session" method="POST" class="form_login">
                <div class="contenedor_form_login">
                    <div class="titulo_form">
                        <h1><a href="#" class="titulo_responsive_off">Sistema ventas</a></h1>
                        <h1><a href="#" class="titulo_responsive">SV</a></h1>
                    </div>
                    <div class="datos_usuario_login">
                        <label for="">Nombre de Usuario / Correo Electronico</label>
                        <input type="text" name="id_usuario">
                    </div>
                    <div class="datos_usuario_login">
                        <label for="">contraseña</label>
                        <div class="contraseña_view">
                            <input type="password" id="password_login" name="password">
                            <a class="eye eye_1" id="eye_login_1"><i class="fa fa-eye-slash"></i></a>
                            <a class="eye eye_2" id="eye_login_2"><i class="fa fa-eye"></i></a>
                        </div>
                    </div>
                    <div class="btns_form">
                        <input type="submit" value="Iniciar Sesion">
                        <a id="close_login">cerrar</a>
                    </div>
                </div>

            </form>
        </div>
        <!--  -->
        <!-- REGISTER -->
        <div class="contenedor_ventana_modal" id="ventana_Register">
            <form action="" class="form_login">
                <div class="contenedor_form_login">
                    <div class="titulo_form">
                        <h1><a href="#" class="titulo_responsive_off">Sistema ventas</a></h1>
                        <h1><a href="#" class="titulo_responsive">SV</a></h1>
                    </div>
                    <div class="datos_usuario_login">
                        <label for="">NickName</label>
                        <input type="text">
                    </div>
                    <div class="datos_usuario_login">
                        <label for="">Nombre usuario</label>
                        <input type="text">
                    </div>
                    <div class="datos_usuario_login">
                        <label for="">Apellido Usuario</label>
                        <input type="text">
                    </div>
                    <div class="datos_usuario_login">
                        <label for="">Correo Usuario</label>
                        <input type="text">
                    </div>
                    <div class="datos_usuario_login">
                        <label for="">contraseña Usuario</label>
                        <div class="contraseña_view">
                            <input type="password" id="password_register">
                            <a class="eye eye_1" id="eye_register_1"><i class="fa fa-eye-slash"></i></a>
                            <a class="eye eye_2" id="eye_register_2"><i class="fa fa-eye"></i></a>
                        </div>
                    </div>
                    <div class="datos_usuario_login">
                        <label for="">Telefono Usuario</label>
                        <input type="text">
                    </div>
                    <div class="datos_usuario_login">
                        <label for="">Genero</label>
                        <select name="" id="">
                            <option value="">MASCULINO</option>
                            <option value="">FEMENINO</option>
                        </select>
                    </div>
                    <div class="datos_usuario_login">
                        <label for="">Fecha Nacimiento</label>
                        <input type="date">
                    </div>
                    <div class="btns_form">
                        <input type="submit" value="Iniciar Sesion">
                        <a id="close_register">cerrar</a>
                    </div>
                </div>

            </form>
        </div>
        <!--  -->
        <!-- BARRA RESPONSIVE -->
        <div class="barra_responsive_on DisplayLoginOFF" id="barra_responsive_loginOFF">
            <div class="contenedor_barra_responsive">
                <a href="#" class="close_responsive" id="cerrar_barraResponsive"><i class="fa fa-close"></i></a>
                <div class="contenido_barra">

                    <h1><a href="#" class="titulo_responsive_1">Sistema ventas</a></h1>
                    <div class="a">
                        <ul class="opciones_responsive">
                            <li><a href="#">Tienda</a></li>
                            <li><a href="#">Contacto</a></li>
                            <li> <a href="#">Colaboradores</a></li>
                            <li><a href="#">Iniciar Sesion</a></li>
                            <li><a href="#">Registrate</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <!-- FIN BARRA -->
        <footer class="footer">
            <div class="titulo_footer">
                <h1><a href="#" class="titulo_responsive_off">SistemaVentas</a></h1>
                <h1><a href="#" class="titulo_responsive">SV</a></h1>
            </div>
            <div class="opciones_footer">
                <ul class="footer_opciones">
                    <li><a href="#">Tienda</a></li>
                    <li><a href="#">Contacto</a></li>
                    <li> <a href="#">Colaboradores</a></li>
                    <li> <a href="#">Contacto</a></li>
                </ul>

            </div>
            <div class="derechos_de_autor">
                <p>Desarrollador por &copy SEBASTIAN8026 </p>
            </div>
        </footer>

        <!-- MENSAJE LATERAL DE LOGIN-->
        <div class="contenedor_mensaje_exitoso_login " id="<%=Identificador%>">
            <div class="mensaje_login_conectado <%=accion%>">
                <div class="mensaje">
                    <p><%=Mensaje%></p>
                </div>
                <div>
                    <a id="CerrarMensaje-Session">
                        <li class="fa fa-close"></li>
                    </a>
                </div>
            </div>
        </div>
        <script src="js/Mensajes-login.js"></script>
        <script src="js/modal-barra-responsive.js"></script>
        <script src="js/modal-login-register.js"></script>
        <script src="https://use.fontawesome.com/87ad7ac135.js"></script>


    </body>
</html>