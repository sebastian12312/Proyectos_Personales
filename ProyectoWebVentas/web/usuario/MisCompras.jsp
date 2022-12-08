<%-- 
    Document   : index
    Created on : Nov 19, 2022, 7:59:42 PM
    Author     : sebastian
--%>

<%@page import="clases.compras"%>
<%@page import="clases.compras"%>
<%@page import="clases.DetallesCompras"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@page import="Funciones.FuncionComprasUsuario"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Plantilla Web</title>
        <link rel="stylesheet" href="../css/DisenoWebUsuario/DiseñoHeaderFooterUsuario.css">
        <link rel="stylesheet" href="../css/DiseñoWeb/fuente.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="../css/DiseñoWeb/slider.css">
        <link rel="stylesheet" href="../css/DiseñoWeb/DiseñoIndex.css">
        <link rel="stylesheet" href="../css/DiseñoWeb/VentanasModal.css">
        <link rel="stylesheet" href="../css/DisenoWebUsuario/dashboard-user.css">
        <link rel="stylesheet" href="../css/DisenoWebUsuario/404.css">
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
                        <h1><a href="index.jsp">TituloProyecto</a></h1>
                    </div>
                    <div class="opciones_header">
                        <ul class="ul_opciones_header">
                            <li><a href="Tienda.jsp">Tienda</a></li>
                            <li><a href="#">carrito</a></li>
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
                            <a href="Tienda.jsp">Tienda</a>
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
                            <li><a href="#">carrito</a></li>
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


        <%
            if (CodigoUsuario != null) {
        %>
        <!-- dashboard user-->
        <div class="MisCompras">
            <div class="contenedor_dashboard" id="">
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
                                <th>Sub Total</th>
                                <th>Precio Total</th>
                                <th>Fecha Compra</th>
                                <th>Estado Compra</th>
                                <th>Detalles</th>
                            </tr>
                            <%
                                FuncionComprasUsuario usuario = new FuncionComprasUsuario();
                                ArrayList<compras> detalles = new ArrayList<compras>();
                                detalles = usuario.Miscompras(CodigoUsuario);
                                int contadorListaCompras = 0;
                                for (int i = 0; i < detalles.size(); i++) {
                                    compras d = detalles.get(i);
                                    contadorListaCompras++;
                            %>     
                            <tr>
                                <td><%=contadorListaCompras%></td>
                                <td><%=d.getCodigoCompra()%></td>
                                <td><%=d.getCodigoUsuario()%></td>
                                <td><%=d.getSubTotalCompra()%></td>
                                <td><%=d.getPrecioTotal()%></td>
                                <td><%=d.getFechaCompra()%></td>
                                <td><%=d.getEstadoCompra()%></td>
                                <td>
                                    <a href="../usuario/Details.jsp?codigo=<%=d.getCodigoCompra()%>" class="ver_details"><i class="fa fa-folder"></i></a>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                        </table>
                    </div>
                </div>

            </div>
        </div>


        <%
        } else {
        %>

        <div class="contenedor_error_404">
            <div class="error_404">
                <div class="contenedor_error_1">
                    <img src="../img/404.png" alt="">
                </div>
                <div class="contenedor_error_2">
                    <div>
                        <h1>OOOPSS!!!! PAGE NO FOUND</h1>
                    </div>
                    <div>
                        <p>
                            This was a web page for an organization that used to exist. This organization no longer exists
                            as it has been replaced with a new organization to teach surf kids the values and love of the
                            ocean. The new site is:
                        </p>
                        <a href="index.jsp">Regresar Al Inicio</a>
                    </div>
                </div>
            </div>
        </div>
        <%
            }
        %>
        <!-- VENTANAS MODAL -->
        <div class="contenedor_modal" id="Ventana_Modal_Login">
            <div class="contenedor_modal_login">
                <form action="../session" method="post" class="modal_login">
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
        <script src="../js/slider.js"></script>
        <script src="../js/ventanaModal.js"></script>
    </body>

</html>