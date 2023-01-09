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
                        <a href="Tienda">Tienda</a>
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
                        <input type="text" placeholder="Escribe tu correo Electronico" name="usuario"  id="usuario">
                    </div>
                    <div class="division_fomulario">
                        <label for="">Contraseña</label>
                        <div class="view_eye">
                            <input type="password" placeholder="Escribe tu contraseña" id="pass1" name="password" id="password">
                            <a data-password="view_pass1">
                                <li class="fa fa-eye"></li>
                            </a>
                        </div>
                    </div>
                    <div id="error-message">
                       
                    </div>
                    <div class="btn_formulario">
                        <input type="submit" name="name" value="iniciar sesion" id="login-button">
                    </div>
                </form>
            </div>
        </div>

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


        
        <script src="js/usuario/header.js"></script>
        <script src="js/ajax/ajaxFormularios.js"></script>
        <script src="js/usuario/validaciones.js"></script>
        <script src="js/usuario/modalUsuario.js"></script>
        <script src="js/slider.js"></script>
    </body>

</html>