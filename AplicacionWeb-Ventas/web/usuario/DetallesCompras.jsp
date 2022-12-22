<%-- 
    Document   : index
    Created on : Dec 18, 2022, 7:59:19 PM
    Author     : sebastian
--%>
<%@page import="clases.DetalleComprasUsuario"%>
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
        <link rel="stylesheet" href="../css/GenerarFactura.css">
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
        <br><br><br>  
        <div class="contenedor_factura">
            <div class="header_factura">
                <div class="titulo_factura">
                    <h1>Page factura</h1>
                </div>
                <div class="datos_empresa_factura">
                    <p>www.google.com</p>
                    <p>E-mail: abc@gmail.com</p>
                    <p>Telefono: 960722532</p>
                </div>
                <div class="datos2_empresa_factura">
                    <p>www.google.com</p>
                    <p>E-mail: abc@gmail.com</p>
                    <p>Telefono: 960722532</p>
                </div>
            </div>
            <div class="cuerpo_factura">
                <div class="tipo_comprobante">
                    <a href="#">FACTURA/BOLETA</a>
                </div>

                <div class="datos_cliente_comprobante">
                    <div class="cliente_comprobante">
                        <p>Nombre Cliente:</p>
                        <p>Correo Cliente:</p>
                        <p>Telefono cliente:</p>
                        <p>ID cliente:</p>
                    </div>
                    <div class="datos_cliente">
                        <p>${NombreUsuario} ${ApellidoUsuario}</p>
                        <p>${CorreoUsuario}</p>
                        <p>${TelefonoUsuario}</p>
                        <p>${CodigoUsuario}</p>
                    </div>
                </div>
                <div class="table_datos_detallesCompra">
                    <table class="table_detallesCompras">
                        <tr>
                            <td colspan="8">
                                <h1>Productos comprasdos</h1>
                            </td>
                        </tr>
                        <tr>
                            <td>#</td>
                            <td>Codigo Producto</td>
                            <td>Nombre Producto</td>
                            <td>Descripcion Producto</td>
                            <td>Cantidad</td>
                            <td>Precio</td>
                            <td>SubTotal</td>
                            <td>Descuento</td>
                        </tr>
                        <%
                            int contadorDetalles = 0;
                        ArrayList<DetalleComprasUsuario> detallesCompras = (ArrayList<DetalleComprasUsuario>) session.getAttribute("DetallesCompras");
                        for (int i = 0; i < detallesCompras.size(); i++) {
                                DetalleComprasUsuario d = detallesCompras.get(i);
                           contadorDetalles++;
                        %>
                        <tr>
                            <td><%=contadorDetalles%></td>
                            <td><%=d.getCodigoProducto()%></td>
                            <td><%=d.getNombreProducto()%></td>
                            <td><%=d.getDescripcionProducto()%></td>
                            <td><%=d.getCantidadCompra()%></td>
                            <td><%=d.getPrecioProducto()%></td>
                            <td><%=d.getSubTotalDetalles()%></td>
                            <td><%=d.getDescuentoDetalle()%></td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                </div>
            </div>
            <br>
            <div class="footer_factura">
                <div class="table_datos_factura">
                    <table class="table_footer_factura">
                        <tr>
                            <td>Codigo</td>
                            <td>Fecha Compra</td>
                            <td>SubTotal</td>
                            <td>IGV</td>
                            <td>Descuento</td>
                            <td>Total a Pagar</td>
                        </tr>
                        <tr>
                            <td>${codigoCompraComprobante}</td>
                            <td>${fechaCompra}</td>
                            <td>${SubTotalCompra}</td>
                            <td>${IGVcompras}</td>
                            <td>${DescuentoCompras}</td>
                            <td>${TotalAPagarComprobante}</td>
                        </tr>
                    </table>
                </div>
            </div>

        </div>
        <div class="btn_comprobante">
            <a href="#">DESCARGAR COMPROBANTE</a>
            <a href="../MisCompras">regresar</a>
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