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
    
      


        <script src="../js/header.js"></script>
        <script src="../js/modal.js"></script>
        <script src="../js/slider.js"></script>
    </body>

</html>