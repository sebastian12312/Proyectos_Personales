<%-- 
    Document   : dashboard
    Created on : Dec 23, 2022, 12:16:56 AM
    Author     : sebastian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="../css/dashboardAdmin.css">
        <link rel="stylesheet" href="../css/fuente.css">
        <link rel="stylesheet" href="../css/modalUsuario.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>

    <body>
        <%
            String codigoUsuario = (String) session.getAttribute("CodigoUsuario");
            String RangoUsuario = (String) session.getAttribute("RangoUsuario");
            String NombreUsuario = (String) session.getAttribute("NombreUsuario");

            if (codigoUsuario != null && RangoUsuario.contentEquals("ADMINISTRADOR")) {


        %>
        <div class="header_administrador" id="header_administrador">
            <div class="contenedor_header_administrador_1">
                <div class="header_administrador_1">
                    <div class="barra_header_administrador">
                        <a onclick="openNav()">
                            <li class="fa fa-angle-left"></li>
                        </a>
                    </div>
                    <div class="titulo_header_administrador">
                        <a href="#">TITULO DASHBOARD</a>
                    </div>
                </div>
                <div class="header_administrador_2">
                    <div class="menu_header_administrador">
                        <a href="#">
                            <li class="fa fa-comment-o"></li>
                        </a>
                        <a href="#">
                            <li class="fa fa-cog"></li>
                        </a>
                        <a href="#">
                            <li class="fa fa-bell-o"></li>
                        </a>
                    </div>
                    <div class="droptown_menu_header">
                        <a href="#" class="btn_dropwtown_header_admin" id="NombreUsuario">${NombreUsuario}</a>
                        <div class="menu_droptown_administrador">
                            <a href="#">OPCIONES</a>
                            <a href="#">OPCIONES</a>
                            <a href="#">OPCIONES</a>
                            <a href="#">OPCIONES</a>
                        </div>
                    </div>
                </div>
            </div>
            <div>
                <main class="body_administrador">
                    <div class="">
                        <h1>usuario</h1>
                        <div class="add_accion_table_administrador">
                            <a id="AbrirVentanaLogin" class="">Agregar Usuario</a>
                        </div>

                        <table class="table_administrador">
                            <tr>
                                <td>#</td>
                                <td>NickName</td>
                                <td>Nombre</td>
                                <td>Apellido</td>
                                <td>telefono</td>
                                <td>correo</td>
                                <td>password</td>
                                <td>Genero</td>
                                <td>Fecha Nacimiento</td>
                                <td>Ver Detalles</td>
                            </tr>
                            <tr>
                                <td>#</td>
                                <td>NickName</td>
                                <td>Nombre</td>
                                <td>Apellido</td>
                                <td>telefono</td>
                                <td>correo</td>
                                <td>password</td>
                                <td>Genero</td>
                                <td>Fecha Nacimiento</td>
                                <td>
                                    <a href="#">
                                        <li class="fa fa-edit"></li>
                                    </a>
                                </td>
                            </tr>
                        </table>
                    </div>
                </main>
            </div>

        </div>

        <div id="barra_lateral_header_admin" class="barra_lateral_header_admin">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">
                <li class="fa fa-angle-right"></li>
            </a>
            <div class="opciones_menu_barra_lateral">
                <a href="#">dashboard</a>
                <a href="#">usuarios</a>
                <a href="#">productos</a>
                <a href="#">reportes</a>
                <a href="#">mensajes</a>
                <a href="#">loguout</a>
            </div>
        </div>

        <!-- modal -->
        <div class="contenedor_modal" id="contenedor_modal_login">
            <form action="" class="formulario_login">
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
                <div class="btn_login" id="btn_login">
                    <input type="submit" value="Registrar   ">
                    <a id="CerrarVentanaLogin">cerrar ventana</a>
                </div>
            </form>
        </div>
        <script src="../js/modal.js"></script>
        <script src="../js/administrador.js"></script>
        <script src="../js/header.js"></script>
        <%        }else{
        %>
        <h1>ERROR404</h1>
        <%}%>
    </body>

</html>