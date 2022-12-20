<%-- 
    Document   : index
    Created on : Dec 18, 2022, 7:59:19 PM
    Author     : sebastian
--%>
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
        <link rel="stylesheet" href="css/fuente.css">
        <!-- header y footer -->
        <link rel="stylesheet" href="css/header_footer.css">
        <!-- Modal  -->
        <link rel="stylesheet" href="css/modalUsuario.css">
        <!-- slider 0-->
        <link rel="stylesheet" href="css/slider.css">
        <!--  -->
        <link rel="stylesheet" href="css/index.css">
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
                    <h1><a href="#">DisenoWeb</a></h1>
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
                                <li><a id="dropMisCompras">Mis Compras</a></li>
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
        <!-- SLIDER  -->
        <div class="contenedor">
            <div class="slider-contenedor">
                <section class="contenido-slider">
                    <div>
                        <h2>Lorem ipsum dolor sit amet consectetur adipisicing elit. Minima ipsa ipsam aliquam natus quidem
                            sed. Quos cupiditate id delectus est.</h2>
                        <a href="#">Ir a Tienda</a>
                    </div>
                    <img class="img-slider" src="img/img1.png" alt="">

                </section>
                <section class="contenido-slider">
                    <div>
                        <h2>Lorem ipsum dolor sit amet consectetur adipisicing elit. Minima ipsa ipsam aliquam natus quidem
                            sed. Quos cupiditate id delectus est.</h2>
                        <a href="#">Ir a Tienda</a>
                    </div>
                    <img class="img-slider" src="img/img1.png" alt="">

                </section>
                <section class="contenido-slider">
                    <div>
                        <h2>Lorem ipsum dolor sit amet consectetur adipisicing elit. Minima ipsa ipsam aliquam natus quidem
                            sed. Quos cupiditate id delectus est.</h2>
                        <a href="#">Ver Ofertas!</a>
                    </div>
                    <img class="img-slider" src="img/img1.png" alt="">

                </section>
                <section class="contenido-slider">
                    <div>
                        <h2>Lorem ipsum dolor sit amet consectetur adipisicing elit. Minima ipsa ipsam aliquam natus quidem
                            sed. Quos cupiditate id delectus est.</h2>
                        <a href="#">Registrate</a>
                    </div>
                    <img class="img-slider" src="img/img1.png" alt="">
                </section>
            </div>
        </div>


        <!-- cards productos  -->
        <div class="titulo_categorias">
            <h1><a href="3">categorias</a></h1>
        </div>
        <div class="contenedor_tarjeta">

            <div class="tarjeta_producto">
                <img src="img/cart.png" alt="">
                <div class="titulo_tarjeta_producto">Titulo</div>
            </div>
            <div class="tarjeta_producto">
                <img src="img/cart.png" alt="">
                <div class="titulo_tarjeta_producto">Titulo</div>
            </div>
            <div class="tarjeta_producto">
                <img src="img/cart.png" alt="">
                <div class="titulo_tarjeta_producto">Titulo</div>
            </div>    
        </div>

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
            <form action="ResgistrarUsuario" method="post" class="formulario_register">
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


        <script src="js/header.js"></script>
        <script src="js/modal.js"></script>
        <script src="js/slider.js"></script>
    </body>

</html>