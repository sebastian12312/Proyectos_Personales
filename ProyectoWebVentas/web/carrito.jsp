<%-- 
    Document   : index
    Created on : Nov 19, 2022, 7:59:42 PM
    Author     : sebastian
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="clases.cart"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="clases.Productos"%>
<%@page import="ServLetUsuario.AgregarProducto"%>
<%@page import="Funciones.FuncionTienda"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Plantilla Web</title>
        <link rel="stylesheet" href="css/DisenoWebUsuario/DiseñoHeaderFooterUsuario.css">
        <link rel="stylesheet" href="css/DiseñoWeb/fuente.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/DiseñoWeb/DiseñoIndex.css">
        <link rel="stylesheet" href="css/DiseñoWeb/VentanasModal.css">
        <link rel="stylesheet" href="css/DiseñoWeb/DiseñoCarritoCompras.css">
    </head>
    <%
        //Datos Usuarios
        String CodigoUsuario = (String) session.getAttribute("CodigoUsuario");
        String NickName = (String) session.getAttribute("NickName");
        Double SaldoUsuario = (Double) session.getAttribute("SaldoUsuario");
    %>
    <body>

        <%
            if (CodigoUsuario != null) {
        %>
        <!-- USUARIO REGISTRADO -->
        <div class="cuerpo_header">
            <header class="header">
                <div class="contenedor_header_1">
                    <div class="titulo_header">
                        <h1><a href="#">TituloProyecto</a></h1>
                    </div>
                    <div class="opciones_header">
                        <ul class="ul_opciones_header">
                            <li><a href="Tienda.jsp">Tienda</a></li>
                            <li><a href="#">carrito ${CantidadCarrito}</a></li>
                            <li><a href="#">contacto</a></li>
                        </ul>
                    </div>
                </div>
                <div class="contenedor_header_2">
                    <div class="droptown_usuario">
                        <div class="contenedor_datos_droptown">
                            <a href="#" class="usuario_registrado"><%=NickName%>......</a>
                        </div>
                        <div class="lista_droptown_usuario">
                            <a href="usuario/MisCompras.jsp">MisCompras</a>
                            <a href="">Saldo: $ <%=SaldoUsuario%></a>
                            <a href="">Tienda</a>
                            <a href="session?loguout=true">CerrarSesion</a>
                        </div>
                    </div>
                    <div class="barra_responsive_header">
                        <a id="btnAbrirBarraNoUsuario">
                            <i class="fa fa-angle-left"></i>
                        </a>
                    </div>
                </div>
            </header>
        </div>

        <%
        } else {
        %>
        <!-- USUARIO NO REGISTRADO -->
        <div class="cuerpo_header">
            <header class="header">
                <div class="contenedor_header_1">
                    <div class="titulo_header">
                        <h1><a href="index.jsp">TituloProyecto</a></h1>
                    </div>
                    <div class="opciones_header">
                        <ul class="ul_opciones_header">
                            <li><a href="Tienda.jsp">Tienda</a></li>
                            <li><a href="#">carrito ${CantidadCarrito}</a></li>
                            <li><a href="#">contacto</a></li>
                        </ul>
                    </div>
                </div>
                <div class="contenedor_header_2">
                    <div class="inicio_session_header">
                        <a id="AbrirLogin"><i class="fa fa-user"></i><span>Iniciar Sesion</span></a>
                    </div>
                    <div class="registrar_header">
                        <a id="AbrirRegister"><i class="fa fa-edit"></i><span>Registrate</span></a>
                    </div>
                    <div class="barra_responsive_header">
                        <a id="AbrirBarraUsuario">
                            <i class="fa fa-angle-left"></i>
                        </a>
                    </div>
                </div>
            </header>
        </div>
        <%
            }
        %>
        <!-- HEADER NO LOGUEADO -->
        <nav class="header_bar" id="header_bar_usuario">
            <div class="datos_barra_usuario">
                <a id="CerraBarraUsuario" class="btn_bar_close"><i class="fa fa-close"></i></a>
                <div class="">
                    <div class="titulo_bars_responsive">
                        <h1><a href="index.jsp" class="">ProyectoWeb</a></h1>
                        <h1><a href="index.jsp" class="">PW</a></h1>
                    </div>
                    <div class="">
                        <ul class="datos_tienda_usuario">
                            <li><a href="Tienda.jsp">Tienda</a></li>
                            <li><a href="#">Contacto</a></li>
                            <li><a href="#">Colaboradores</a></li>
                        </ul>
                    </div>
                </div>            
            </div>
        </nav>
        <!-- HEADER LOGUEADOS -->
        <nav class="header_bar" id="header_bar_NoUsuario">
            <div class="datos_barra_usuario">
                <a id="CerraBarraNoUsuario" class="btn_bar_close"><i class="fa fa-close"></i></a>
                <div class="">
                    <div class="titulo_bars_responsive">
                        <h1><a href="index.jsp" class="">ProyectoWeb</a></h1>
                        <h1><a href="index.jsp" class="">PW</a></h1>
                    </div>
                    <div class="">
                        <ul class="datos_tienda_usuario">
                            <li><a href="Tienda.jsp">Tienda</a></li>
                            <li><a href="#">Contacto</a></li>
                            <li><a href="#">Colaboradores</a></li>
                        </ul>
                    </div>
                </div>
                <div class="">
                    <div class="datos_session_usuairo">
                        <a id="">Iniciar Sesion</a>
                        <a id="">Registrate</a>
                    </div>
                </div>
            </div>
        </nav>

        <div class="titulo_lista_carrito">
            <h1>LISTA DE CARRITO DE COMPRAS</h1>
        </div>
        <div class="contenedor_carrito" style="margin-bottom: 14%">
            <div class="contenedor_productos_carrito">
                <table class="table">
                    <tr>
                        <th>N°</th>
                        <th>Codigo Producto</th>
                        <th>Nombre Producto</th>
                        <th>Descripcion Producto</th>
                        <th>Cantidad</th>
                        <th>Precio Producto</th>
                        <th>Imagen</th>
                        <th>Descuento</th>
                        <th>SubTotal Producto</th>
                        <th>accion</th>
                    </tr> 
                   <%
                       int cont = 1;
                       String MensajeCarrito =(String) session.getAttribute("MensajeCarrito");
                        if(MensajeCarrito == "CarritoLleno"){
                   %>
                   
                    <c:forEach var="carrito" items="${ListarCarrito}">
                        <tr>                           
                            <td><%=cont++%></td>
                            <td>${carrito.getCodigoProducto()}</td>
                            <td>${carrito.getNombreProducto()}</td>
                            <td>${carrito.getDescripcionProducto()}</td>
                            <td>${carrito.getCantidadProducto()}</td>
                            <td>${carrito.getPrecioProducto()}</td>
                            <td>
                                <img src="img/axe.png" alt="alt"/>
                            </td>
                            <td>${carrito.getDescuentoProducto()}</td>
                            <td>${carrito.getSubTotal()}</td>
                            <td>
                                <a href="" class="btn_trash_carrito"><i class="fa fa-trash"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                      <%
                          } else{
                      %>
                      <tr>
                          <td colspan="10">
                              <h1>NO HAY PRODUCTO</h1>
                              <img src="img/bag.png" alt="alt"/>
                          </td>
                      </tr>
                     <%
                         }
                     %>
                </table>
            </div>
            <div class="contenedor_datos_carrito">
                <div class="datos_carrito">
                    <div class="titulo_carrito">
                        <a href="#">Datos de La Compra</a>
                    </div>
                    <div class="datos_iguales">
                        <p>SubTotal:</p>
                        <p>$ ${SubTotalCarrito}</p>
                    </div>
                    <div class="datos_iguales">
                        <p>IGV:</p>
                        <p>$ ${IGV}</p>
                    </div>
                    <div class="datos_iguales">
                        <p>Descuento ${DescuentoEntero}%:</p>
                        <p>$ ${DescuentoPrecio}</p>
                    </div>
                    <div class="datos_iguales Precio_final">
                        <p>Precio Final:</p>
                        <p>$ ${PrecioFinalCarrito}</p>
                    </div>
                    <div>
                        <span>${MensajeCompra}</span>
                    </div>
                    <div class="btn_carrito_compra">
                        <a href="comprar">Comprar Ahora</a>
                        <a href="Tienda.jsp">Seguir Comprando</a>
                    </div>
                </div>
            </div>
        </div>
        <br><br><br><br><br><br><br><br>
        <!-- VENTANAS MODAL -->
        <div class="contenedor_modal" id="Ventana_Modal_Login">
            <div class="contenedor_modal_login">
                <form action="" class="modal_login">
                    <div class="Titulo_modal_usuario">
                        <h1>Inicia Sesion</h1>
                    </div>
                    <div class="label_modal">
                        <label for="">Ingrese su Usuario o E-mail</label>
                        <input type="text">
                    </div>
                    <div class="label_modal">
                        <label for="">Ingrese su contrasena</label>
                        <input type="password">
                    </div>
                    <div class="btn_modal_usuario">
                        <input type="submit" value="Iniciar Sesion">
                        <a id="CerrarLogin">cerrar</a>
                    </div>
                </form>
            </div>
        </div>



        <!-- VENTANAS MODAL -->
        <div class="contenedor_modal" id="Ventana_Modal_Login">
            <div class="contenedor_modal_login">
                <form action="session" method="post" class="modal_login">
                    <div class="Titulo_modal_usuario">
                        <h1>Inicia Sesion</h1>
                    </div>
                    <div class="label_modal">
                        <label for="">Ingrese su Usuario o E-mail</label>
                        <input type="text" name="usuario">
                    </div>
                    <div class="label_modal">
                        <label for="">Ingrese su contrasena</label>
                        <input type="password" name="password">
                    </div>
                    <div class="btn_modal_usuario">
                        <input type="submit" value="Iniciar Sesion">
                        <a id="CerrarLogin">cerrar</a>
                    </div>
                </form>
            </div>
        </div>
        <!-- modal register -->
        <div class="contenedor_modal" id="Ventana_Modal_Register">
            <div class="contenedor_modal_register">
                <form action="" class="ventana_modal_register">
                    <div class="Titulo_modal_usuario">
                        <h1>Registrate</h1>
                    </div>
                    <div class="division_modal_register">
                        <div class="label_modal_register">
                            <label for="">DNI</label>
                            <input type="text">
                        </div>
                        <div class="label_modal_register">
                            <label for="">NickName</label>
                            <input type="text">
                        </div>
                    </div>

                    <div class="division_modal_register">
                        <div class="label_modal_register">
                            <label for="">Nombre</label>
                            <input type="text">
                        </div>
                        <div class="label_modal_register">
                            <label for="">Apellido</label>
                            <input type="text">
                        </div>
                    </div>

                    <div class="division_modal_register">
                        <div class="label_modal_register">
                            <label for="">Correo</label>
                            <input type="text">
                        </div>
                        <div class="label_modal_register">
                            <label for="">Telefono</label>
                            <input type="text">
                        </div>
                    </div>
                    <div class="division_modal_register">
                        <div class="label_modal_register">
                            <label for="">contrasena</label>
                            <input type="text">
                        </div>
                        <div class="label_modal_register">
                            <label for="">repita su contrasena</label>
                            <input type="text">
                        </div>
                    </div>

                    <div class="division_modal_register">
                        <div class="label_modal_register">
                            <label for="">Genero</label>
                            <select name="" id="">
                                <option value="MASCULINO">MASCULINO</option>
                                <option value="FEMENINO">FEMENINO</option>
                            </select>
                        </div>
                        <div class="label_modal_register">
                            <label for="">Fecha de Nacimiento</label>
                            <input type="date">
                        </div>
                    </div>
                    <div class="btn_modal_usuario">
                        <input type="submit" value="Iniciar Sesion">
                        <a id="CerrarRegister">cerrar</a>
                    </div>
                </form>
            </div>
        </div>


        <!-- FOOTER -->
        <footer class="footer">
            <div class="titulo_footer">
                <h1><a href="#">TituloProyecto</a></h1>
            </div>
            <div class="opciones_footer">
                <ul class="ul_opciones_footer">
                    <li><a href="#">Tienda</a></li>
                    <li><a href="#">carrito</a></li>
                    <li><a href="#">contacto</a></li>
                </ul>
            </div>
            <div class="linea">
            </div>
            <div class="desarrollador_footer">
                <p>Desarrollado por &copy; SEBASTIAN8026</p>
            </div>
        </footer>
        <script src="js/slider.js"></script>
        <script src="js/ventanaModal.js"></script>
    </body>

</html>