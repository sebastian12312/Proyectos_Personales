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
            <div class="contenedor_header_1">
                <div class="titulo_header">
                    <h1><a href="../index.jsp">DisenoWeb</a></h1>
                </div>
                <div class="menu_header">
                    <ul class="contenedor_menu">
                        <li><a id="" href="../Tienda">Tienda</a></li>
                        <li><a id="abc" data-tienda="tienda">contacto</a></li>
                        <li><a class="">Nosotros</a></li>
                    </ul>
                </div>
            </div>
            <div class="contenedor_header_2">
                <%
                    if (CodigoUsuario != null) {

                %>
                <div class="header_Usuario">
                    <div class="header_datosUsuario header_droptown">
                        <a id="NombreUsuario"><%=usuario%></a>
                        <a href="#">
                            <li class="fa fa-bars"></li>
                        </a>
                        <div class="header_menu_droptown">
                            <ul class="menu_droptown">
                                <li><a id="dropMisCompras" href="../MisCompras">Mis Compras</a></li>
                                <li><a id="dropTienda" href="../Tienda">Tienda</a></li>
                                <li><a id="dropMiSaldo">Saldo: $ <%=SaldoUsuario%></a></li>
                                <li><a id="dropCerrarSesion" href="session?cerrar=true">cerrar sesion</a></li>
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
        <div class="contenedor_modal" id="contenedor_modal_login">
            <form action="../session" method="post" class="formulario_login">
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
            <form action="../ResgistrarUsuario" method="post" class="formulario_register">
                <h1>REGISTRATE</h1>
                <div class="contenedor_datos_register">
                    <div class="datos_register">
                        <label for="">usuario*:</label>
                        <input type="text" name="usuario">
                    </div>
                    <div class="datos_register">
                        <label for="">E-mail*:</label>
                        <input type="text" name="email">
                    </div>
                </div>
                <div class="contenedor_datos_register">
                    <div class="datos_register">
                        <label for="">Nombre*:</label>
                        <input type="text" name="nombre">
                    </div>
                    <div class="datos_register">
                        <label for="">Apellido*:</label>
                        <input type="text" name="apellido">
                    </div>
                </div>
                <div class="contenedor_datos_register">
                    <div class="datos_register">
                        <label for="">contrasena*:</label>
                        <input type="text" name="password1">
                    </div>
                    <div class="datos_register">
                        <label for="">Repetia su contrasena*:</label>
                        <input type="text" name="password2">
                    </div>
                </div>
                <div class="contenedor_datos_register">
                    <div class="datos_register">
                        <label for="">Telefono*:</label>
                        <input type="text" name="Telefono">
                    </div>
                </div>
                <div class="contenedor_datos_register">
                    <div class="datos_register">
                        <label for="">Genero*:</label>
                        <select name="" id="" name="genero">
                            <option value="MASCULINO">MASCULINO</option>
                            <option value="FEMENINO">FEMENINO</option>
                        </select>
                    </div>
                    <div class="datos_register">
                        <label for="">Fecha de Nacimiento*:</label>
                        <input type="date" name="fechaNacimiento">
                    </div>
                </div>
                <div class="btn_modal_register">
                    <input type="submit" value="registrarse">
                    <a id="CerrarModalRegister">cerrar ventana</a>
                </div>
            </form>
        </div>


        <script src="../js/header.js"></script>
        <script src="../js/modal.js"></script>
        <script src="../js/slider.js"></script>
    </body>

</html>