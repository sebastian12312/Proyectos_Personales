<%-- 
    Document   : registrar
    Created on : 11 mar. 2023, 18:01:04
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
        <link rel="stylesheet" href="fuentes/fuente.css">
        <link rel="stylesheet" href="css/colores.css">
        <link rel="stylesheet" href="css/registrar.css">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </head>

    <body>
        <div class="body_contenedor_register">
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
                <form  class="formulario" id="formulario_registro" >
                    <div class="contenedor_division_formulario_">
                        <div class="division_fomulario">
                            <label for="">NickName<strong>:</strong></label>
                            <input type="text" placeholder="Escribe su nickName"  id="NickName">
                        </div>                  
                    </div>
                    <div class="contenedor_division_formulario">
                        <div class="division_fomulario">
                            <label for="">Nombre<strong>:</strong></label>
                            <input type="text" placeholder="Escribe tu nombre"  id="NombreUsuario">
                        </div>
                        <div class="division_fomulario">
                            <label for="">Apellido<strong>:</strong></label>
                            <input type="text" placeholder="Escribe tu apellido"  id="ApellidoUsuario">
                        </div>
                    </div>
                    <div class="contenedor_division_formulario">
                        <div class="division_fomulario">
                            <label for="">correo Electronico<strong>:</strong></label>
                            <input type="text" placeholder="Escribe tu correo electronico"  id="CorreoUsuario">
                        </div>
                        <div class="division_fomulario">
                            <label for="">Telefono<strong>:</strong></label>
                            <input type="text" placeholder="Escribe tu numero de telefono" id="TelefonoUsuario">
                        </div>
                    </div>
                    <div class="contenedor_division_formulario">
                        <div class="division_fomulario">
                            <label for="">Contraseña<strong>:</strong></label>
                            <div class="view_eye">
                                <input type="password" placeholder="Escribe tu contraseña" id="pass1"  >
                                <a data-password="view_pass1">
                                    <li class="fa fa-eye"></li>
                                </a>
                            </div>
                            <span class="mensaje__validacion"></span>
                        </div>
                        <div class="division_fomulario">
                            <label for="">Confirme su Contraseña<strong>:</strong></label>
                            <div class="view_eye">
                                <input type="password" placeholder="Confirme su contraseña" id="pass2" >
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
                            <select   id="GeneroUsuario">
                                <option value="MASCULINO">MASCULINO</option>
                                <option value="FEMENINO">FEMENINO</option>
                            </select>
                        </div>
                        <div class="division_fomulario">
                            <label for="">Fecha de nacimiento<strong>:</strong></label>
                            <input type="date" placeholder="Confirme su contraseña"  id="FechaNacimiento">
                        </div>
                    </div>
                    <div class="btn_formulario">
                        <button id="button_register"  type="submit" value="Registrar Usuario">Registrar Usuario</button>
                    </div>
                </form>
            </div>
        </div>  
        <script>
            const button_register = document.getElementById("button_register");
            button_register.addEventListener('click', (e) => {
                // evita que el formulario se envíe por defecto
                e.preventDefault();
                // obtén los valores de los campos del formulario
                var nickName = $('#NickName').val();
                var nombreUsuario = $('#NombreUsuario').val();
                var apellidoUsuario = $('#ApellidoUsuario').val();
                var correoUsuario = $('#CorreoUsuario').val();
                var passwordUsuario = $('#pass1').val();
                var passwordUsuario2 = $('#pass2').val();
                var telefonoUsuario = $('#TelefonoUsuario').val();
                var fechaNacimiento = $('#FechaNacimiento').val();
                var generoUsuario = $('#GeneroUsuario').val();
                // crea un objeto con los datos del usuario
                var usuario = {
                    NickName: nickName,
                    NombreUsuario: nombreUsuario,
                    ApellidoUsuario: apellidoUsuario,
                    CorreoUsuario: correoUsuario,
                    PasswordUsuario: passwordUsuario,
                    PasswordUsuario2: passwordUsuario2,
                    TelefonoUsuario: telefonoUsuario,
                    FechaNacimiento: fechaNacimiento,
                    GeneroUsuario: generoUsuario
                };
                // envía los datos del usuario al servlet utilizando ajax
                $.ajax({
                    url: 'registrar', // la URL del servlet
                    type: 'POST', // el método HTTP utilizado
                    data: usuario, // los datos a enviar
                    success: function (response) {
                        // si el servlet responde con éxito, muestra un mensaje de éxito
                        if (response == "OK") {
                            Swal.fire('¡Registro exitoso!', '¡Tu cuenta ha sido creada exitosamente!', 'success');
                        } else {
                            Swal.fire('Error', '¡No se pudo completar el registro! ' + response, 'error');
                        }
                    },
                    error: function (xhr, status, error) {
                        // maneja el error y muestra un mensaje de error
                        Swal.fire('Error', '¡No se pudo completar el registro! ' + error, 'error');
                    }
                });
            });
        </script>
    </body>
</html>