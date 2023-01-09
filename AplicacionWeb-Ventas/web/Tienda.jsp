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

        <!-- Tienda -->
        <link rel="stylesheet" href="css/Tienda.css">
        <!-- carrito -->
        <link rel="stylesheet" href="css/carrito.css">
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!-- fuente -->
        <link rel="stylesheet" href="css/fuente.css">
        <!-- header y footer -->
        <link rel="stylesheet" href="css/usuariosCss/header_footer.css">
        <!-- Modal  -->
        <link rel="stylesheet" href="css/modalUsuario.css">
        <!-- slider 0-->
        <link rel="stylesheet" href="css/slider.css">
        <!--  -->
        <link rel="stylesheet" href="css/index.css">
        <link rel="stylesheet" href="css/usuariosCss/login-register.css">
    </head>
    <%
        String usuario = (String) session.getAttribute("usuario");
        String CodigoUsuario = (String) session.getAttribute("CodigoUsuario");
        Double SaldoUsuario = (Double) session.getAttribute("SaldoUsuario");
        int CantidadProducto = (Integer) request.getAttribute("CantidadProducto");
      
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
      

      


        <script src="js/usuario/header.js"></script>
        <script src="js/usuario/validaciones.js"></script>
        <script src="js/usuario/modalUsuario.js"></script>
        <script src="js/slider.js"></script>
    </body>

</html>