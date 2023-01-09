<%-- 
    Document   : registrar.jsp
    Created on : Jan 5, 2023, 7:28:45 PM
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
    <title>Registrar ~ Diseno Web</title>
    <link rel="stylesheet" href="css/fuente.css">
    <link rel="stylesheet" href="css/alert-modal.css">
    <link rel="stylesheet" href="css/usuariosCss/login-register.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
 <%
     String respuestaRegister = (String) response.getContentType();
 %>
<body>
    <div class="body_contenedor_formulario">
        <div class="contenedor_formulario">
            <div class="titulo_formulario">
                <a href="#">Diseno web</a>
                <h1>crea tu cuenta</h1>
            </div>
            <div class="registrar_redes">
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
            <div class="titulo_formulario">
                <h1>Registra Tus Datos</h1>
            </div>
            <form action="ResgistrarUsuario" class="formulario" method="POST">
                <div class="contenedor_division_formulario">
                    <div class="division_fomulario">
                        <label for="">Nombre<strong>:</strong></label>
                        <input type="text" placeholder="Escribe tu nombre" name="NombreUsuario">
                    </div>
                    <div class="division_fomulario">
                        <label for="">Apellido<strong>:</strong></label>
                        <input type="text" placeholder="Escribe tu apellido" name="ApellidoUsuario">
                    </div>
                </div>
                 <div class="">
                    <div class="division_fomulario">
                        <label for="">NickName<strong>:</strong></label>
                        <input type="text" placeholder="Escribe tu correo electronico" name="NickName">
                    </div>                  
                </div>
                <div class="contenedor_division_formulario">
                    <div class="division_fomulario">
                        <label for="">correo Electronico<strong>:</strong></label>
                        <input type="text" placeholder="Escribe tu correo electronico" name="CorreoUsuario">
                    </div>
                    <div class="division_fomulario">
                        <label for="">Telefono<strong>:</strong></label>
                        <input type="text" placeholder="Escribe tu numero de telefono" name="TelefonoUsuario">
                    </div>
                </div>
                <div class="contenedor_division_formulario">
                    <div class="division_fomulario">
                        <label for="">Contraseña<strong>:</strong></label>
                        <div class="view_eye">
                            <input type="password" placeholder="Escribe tu contraseña" id="pass1" name="PasswordUsuario1">
                            <a data-password="view_pass1">
                                <li class="fa fa-eye"></li>
                            </a>
                        </div>
                        <span class="mensaje__validacion"></span>
                    </div>
                    <div class="division_fomulario">
                        <label for="">Confirme su Contraseña<strong>:</strong></label>
                        <div class="view_eye">
                            <input type="password" placeholder="Confirme su contraseña" id="pass2" name="PasswordUsuario2">
                            <a data-password="view_pass2">
                                <li class="fa fa-eye"></li>
                            </a>
                        </div>
                        <span class="mensaje__validacion"></span>
                    </div>
                </div>
                <div class="contenedor_division_formulario">
                    <div class="division_fomulario">
                        <label for="">Genero<strong>:</strong></label>
                        <select name="GeneroUsuario" id="" >
                            <option value="MASCULINO">MASCULINO</option>
                            <option value="FEMENINO">FEMENINO</option>
                        </select>
                    </div>
                    <div class="division_fomulario">
                        <label for="">Fecha de nacimiento<strong>:</strong></label>
                        <input type="date" placeholder="Confirme su contraseña" name="FechaNacimiento">
                    </div>
                </div>
                <div class="btn_formulario">
                    <p>${MensajeRegistro}s</p>
                    <button id="button_register">Registrate Ahora</button>
                </div>
            </form>
        </div>
    </div>
    <div class="contenedor-modal ${RespuestaRegisterCSS}>
        <div class="modal-valido">
            <p>USUARIO REGISTRADOR</p>
        </div>
    </div>
    <script src="js/usuario/validaciones.js"></script>
</body>

</html>