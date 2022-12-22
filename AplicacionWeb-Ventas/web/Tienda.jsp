<%-- 
    Document   : index
    Created on : Dec 18, 2022, 7:59:19 PM
    Author     : sebastian
--%>

<%@page import="clases.producto"%>
<%@page import="java.util.ArrayList"%>
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
        <!-- Tienda -->
        <link rel="stylesheet" href="css/Tienda.css">
        <!-- carrito -->
        <link rel="stylesheet" href="css/carrito.css">
    </head>
    <%
        String usuario = (String) session.getAttribute("usuario");
        String CodigoUsuario = (String) session.getAttribute("CodigoUsuario");
        Double SaldoUsuario = (Double) session.getAttribute("SaldoUsuario");
        int CantidadProducto = (Integer) request.getAttribute("CantidadProducto");
      
    %>
    <body>
        <header class="header" id="header">
            <div class="contenedor_header_1">
                <div class="titulo_header">
                    <h1><a href="index.jsp">DisenoWeb</a></h1>
                </div>
                <div class="menu_header">
                    <ul class="contenedor_menu">
                        <li><a id="" href="Tienda">Tienda</a></li>
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
                                <li><a id="dropMisCompras" href="MisCompras">Mis Compras</a></li>
                                <li><a id="dropTienda">Tienda</a></li>
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


        <div class="header_tienda_filtro">
            <div class="header_tienda_filtro_1">
                <a >
                    Productos Encontrados:                   
                    <%=CantidadProducto%>
                </a>
            </div>
            <div class="header_tienda_filtro_2">
                <div class="">
                    <label for="">Categorias</label>
                    <select name="" id="" aria-placeholder="">
                        <option value="Ropa">Ropa</option>
                        <option value="Zapatos">Zapatos</option>
                        <option value="Accesorios">Accesorios</option>
                        <option value="Other">Other</option>
                    </select>
                </div>
            </div>
        </div>
        <main class="contenedor_tienda">
            <div class="contenedor_filtro_categorias">            
                <div class="filtro_categorias"> 
                    <h1>Filtrar Producto</h1>               
                    <form action="">
                        <div class="carrito_compras">
                            <a href="carrito"><li class="fa fa-shopping-cart"></li> carrito ( ${CantidadProductosCompras} )</a>
                        </div>
                        <div class="filtro_tienda buscar_filtro">
                            <input type="search" name="" id="">
                            <li class="fa fa-search"></li>
                        </div>
                        <div class="filtro_tienda">
                            <label for="">Categorias</label>
                            <select name="" id="" aria-placeholder="">
                                <option value="Ropa">Ropa</option>
                                <option value="Zapatos">Zapatos</option>
                                <option value="Accesorios">Accesorios</option>
                                <option value="Other">Other</option>
                            </select>
                        </div>
                        <div class="filtro_tienda">
                            <label for="">Genero</label>
                            <select name="" id="" aria-placeholder="">
                                <option value="Ropa">Masculino</option>
                                <option value="Zapatos">Femenino</option>
                                <option value="Accesorios">others</option>
                            </select>
                        </div>
                        <div class="btn_filtros_tienda">
                            <input type="submit" value="Aplicar Filtro">
                        </div>
                    </form>
                </div>            
            </div>
            <div class="contenedor_tienda_productos">
                <div class="card_productos_tienda">

                    <%

                        ArrayList<producto> products = (ArrayList<producto>) request.getAttribute("producto");
                        for (int i = 0; i < products.size(); i++) {
                            producto p = products.get(i);

                    %>    
                    <div class="card_productos">
                        <div class="imagen_producto_tienda">
                            <img src="img/cart.png" alt="">
                        </div>
                        <div class="datos_productos_tienda">
                            <span><%=p.getNombreProducto()%></span>
                            <p>$ <%=p.getPrecioProducto()%></p>
                        </div>
                        <div class="btn_productos_tienda">
                            <a href="agregar?codigoProducto=<%=p.getCodigProducto()%>">agregar <li class="fa fa-shopping-cart"></li></a>
                        </div>                    
                    </div>
                    <%
                        }
                    %>
                </div>
            </div>
        </main>

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