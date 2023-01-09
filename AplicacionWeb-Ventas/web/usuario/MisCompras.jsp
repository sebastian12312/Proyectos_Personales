<%-- 
    Document   : index
    Created on : Dec 18, 2022, 7:59:19 PM
    Author     : sebastian
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="clases.ComprasUsuario"%>
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
        <link rel="stylesheet" href="../css/fuente.css">
        <!-- header y footer -->
        <link rel="stylesheet" href="../css/header_footer.css">
        <!-- Modal  -->
        <link rel="stylesheet" href="../css/modalUsuario.css">
        <!-- slider 0-->
        <link rel="stylesheet" href="../css/slider.css">
        <!--  -->
        <link rel="stylesheet" href="../css/index.css">
        <link rel="stylesheet" href="../css/usuario.css">
    </head>
    <%
        String usuario = (String) session.getAttribute("usuario");
        String CodigoUsuario = (String) session.getAttribute("CodigoUsuario");
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
        <%
            if (CodigoUsuario != null) {
        %>
        <div class="contenedor_dashboard">
            <div class="contenedor_dash_1">
                <div class="datos_usuario_dashboard">
                    <h1>Datos Usuario</h1>
                    <a href="#" class="saldo_user_dash" id="saldo_user_dash">
                        <div class="datos_saldo_dash">
                            <div>
                                <p>Saldo: $</p>
                            </div>
                            <div>
                                <p><%=SaldoUsuario%></p>
                            </div>
                        </div>
                    </a>

                    <a href="#" class="saldo_user_dash" id="saldo_user_dash">
                        <div class="datos_saldo_dash">
                            <div>
                                <p>Recargar Saldo</p>
                            </div>
                            <div>
                                <p></p>
                            </div>
                        </div>
                    </a>


                    <a href="#" class="saldo_user_dash" id="saldo_user_dash">
                        <div class="datos_saldo_dash">
                            <div>
                                <p>Cerrar Sesion</p>
                            </div>
                            <div>
                                <p></p>
                            </div>
                        </div>
                    </a>
                </div>

            </div>
            <div class="contenedor_dash_2">
                <h1>Mis Compras</h1>
                <div>
                    <table class="table_dashboard">
                        <tr>
                            <th>#</th>
                            <th>Codigo Compra</th>
                            <th>Codigo Usuario</th>
                            <th>SubTotal</th>
                            <th>Descuento</th>
                            <th>IGV compra</th>
                            <th>Precio Compra</th>
                            <th>Fecha Compra</th>
                            <th>Estaod Compra</th>
                            <th>Accion</th>
                        </tr>
                        <%
                            ArrayList<ComprasUsuario> compras = (ArrayList<ComprasUsuario>) session.getAttribute("ListaCompras");
                            int contadorCompras = 0;

                            for (int i = 0; i < compras.size(); i++) {
                                ComprasUsuario c = compras.get(i);
                                contadorCompras++;
                        %>
                        <tr>
                            <td><%=contadorCompras%></td>
                            <td><%=c.getCodigoCompra()%></td>
                            <td><%=c.getCodigoUsuario()%></td>
                            <td><%=c.getSubTotal()%></td>
                            <td><%=c.getDescuentoCompra()%></td>
                            <td><%=c.getIGVCompra()%></td>
                            <td><%=c.getPrecioFInal()%></td>
                            <td><%=c.getFechaCompra()%></td>
                            <td><%=c.getEstadoCompra()%></td>
                            <td>
                                <a href="../DetallesCompras?codigoCompra=<%=c.getCodigoCompra()%>" class="delete_producto"><i class="fa fa-edit"></i></a>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                </div>
            </div>

        </div>
        <%
            } else {
                out.print("error");
            }
        %>                

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
   

   

        <script src="../js/header.js"></script>
        <script src="../js/modal.js"></script>
        <script src="../js/slider.js"></script>
    </body>

</html>