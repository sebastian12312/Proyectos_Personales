<%-- 
    Document   : Tienda
    Created on : 11 mar. 2023, 18:02:31
    Author     : sebastian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/HeaderFooter.css">
    <link rel="stylesheet" href="fuentes/fuente.css">
    <link rel="stylesheet" href="css/colores.css">
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/Tienda.css">
</head>
<body>
      <header class="header">
        <div class="contenedor_header">
           <div class="contenedor_headar_1">
                <div class="titulo">
                    <a href="">SuperCraft</a>
                </div>
           </div>
           <div class="contenedor_headar_2">
                <div class="menu_header">
                    <ul class="lista_menu_header">
                        <li><a href="#">inicio</a></li>
                        <li><a href="#">productos</a></li>
                        <li><a href="#">contacto</a></li>
                        <li><a href="#">nosotros</a></li>
                    </ul>
                </div>
           </div>
           <div class="contenedor_headar_3">
                <div class="acceso_usuario" >
                    <a class="login_user">iniciar sesion</a>
                    <a href="#">registrar</a>
                    <a href="#"><li class="fa fa-bars"></li></a>
                </div>
                <div class="acceso_usuario_registrado" style="display: none;">
                    <a href="#">SEBASTIAN8026</a>
                    <a href="#"><li class="fa fa-bars"></li></a>
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
            <form action="">
                <div class="division_fomulario">
                    <label for="">correo electronico</label>
                    <input type="text" placeholder="Escribe tu correo Electronico">
                </div>
                <div class="division_fomulario">
                    <label for="">Contraseña</label>
                    <div class="view_eye">
                        <input type="password" placeholder="Escribe tu contraseña" id="pass1">
                        <a data-password="view_pass1">
                            <li class="fa fa-eye"></li>
                        </a>
                    </div>
                </div>
                <div class="btn_formulario">
                    <input id="button_register" value="iniciar sesion" type="submit">
                </div>
            </form>
        </div>
    </div>

    <!--  -->
    <div class="header_tienda_filtro">
        <div class="header_tienda_filtro_1">
            <a >Productos Encontrados</a>
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
                        <a href="#"><li class="fa fa-shopping-cart"></li> carrito ( 10 )</a>
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
                <div class="card_productos">
                    <div class="imagen_producto_tienda">
                        <img src="img/cart.png" alt="">
                    </div>
                    <div class="datos_productos_tienda">
                        <span>Nombre Producto</span>
                        <p>$ 30.00</p>
                    </div>
                    <div class="btn_productos_tienda">
                        <a href="#">agregar <li class="fa fa-shopping-cart"></li></a>
                    </div>                    
                </div>
                <div class="card_productos">
                    <div class="imagen_producto_tienda">
                        <img src="img/cart.png" alt="">
                    </div>
                    <div class="datos_productos_tienda">
                        <span>Nombre Producto</span>
                        <p>$ 30.00</p>
                    </div>
                    <div class="btn_productos_tienda">
                        <a href="#">agregar <li class="fa fa-shopping-cart"></li></a>
                    </div>                    
                </div>
                <div class="card_productos">
                    <div class="imagen_producto_tienda">
                        <img src="img/cart.png" alt="">
                    </div>
                    <div class="datos_productos_tienda">
                        <span>Nombre Producto</span>
                        <p>$ 30.00</p>
                    </div>
                    <div class="btn_productos_tienda">
                        <a href="#">agregar <li class="fa fa-shopping-cart"></li></a>
                    </div>                    
                </div>
                <div class="card_productos">
                    <div class="imagen_producto_tienda">
                        <img src="img/cart.png" alt="">
                    </div>
                    <div class="datos_productos_tienda">
                        <span>Nombre Producto</span>
                        <p>$ 30.00</p>
                    </div>
                    <div class="btn_productos_tienda">
                        <a href="#">agregar <li class="fa fa-shopping-cart"></li></a>
                    </div>                    
                </div>
                <div class="card_productos">
                    <div class="imagen_producto_tienda">
                        <img src="img/cart.png" alt="">
                    </div>
                    <div class="datos_productos_tienda">
                        <span>Nombre Producto</span>
                        <p>$ 30.00</p>
                    </div>
                    <div class="btn_productos_tienda">
                        <a href="#">agregar</a>
                    </div>                    
                </div>
                <div class="card_productos">
                    <div class="imagen_producto_tienda">
                        <img src="img/cart.png" alt="">
                    </div>
                    <div class="datos_productos_tienda">
                        <span>Nombre Producto</span>
                        <p>$ 30.00</p>
                    </div>
                    <div class="btn_productos_tienda">
                        <a href="#">agregar <li class="fa fa-shopping-cart"></li></a>
                    </div>                    
                </div>
                <div class="card_productos">
                    <div class="imagen_producto_tienda">
                        <img src="img/cart.png" alt="">
                    </div>
                    <div class="datos_productos_tienda">
                        <span>Nombre Producto</span>
                        <p>$ 30.00</p>
                    </div>
                    <div class="btn_productos_tienda">
                        <a href="#">agregar <li class="fa fa-shopping-cart"></li></a>
                    </div>                    
                </div>
                <div class="card_productos">
                    <div class="imagen_producto_tienda">
                        <img src="img/cart.png" alt="">
                    </div>
                    <div class="datos_productos_tienda">
                        <span>Nombre Producto</span>
                        <p>$ 30.00</p>
                    </div>
                    <div class="btn_productos_tienda">
                        <a href="#">agregar <li class="fa fa-shopping-cart"></li></a>
                    </div>                    
                </div>
            </div>
        </div>
    </main>
    <!--  -->
    <div class="contenedor_cambio_theme" style="display: none;">
        <div class="cambio-theme" id="cambio-theme">
            <div class="theme-light"><img src="img/full.png" alt=""></div>
            <div class="theme-dark"><img src="img/sunglasses.png" alt=""></div>
            <div class="buttom-theme"></div>
        </div>
    </div>    
    <script src="js/ModalLogin.js"></script>
    <script src="js/cambioTheme.js"></script>
</body>
</html>
