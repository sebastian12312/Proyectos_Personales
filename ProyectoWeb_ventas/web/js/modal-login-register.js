const ventana_login = document.getElementById("ventana_login");
const Iniciar_Sesion = document.getElementById("Iniciar_Sesion");

const close_login = document.getElementById("close_login");
Iniciar_Sesion.addEventListener('click', () => {
    ventana_login.classList.add("LoginON");
    ventana_login.classList.remove("LoginOFF");
})
close_login.addEventListener('click', () => {
    ventana_login.classList.add("LoginOFF");
    ventana_login.classList.remove("LoginON");

})


/*REGISTER*/
const registrate = document.getElementById("registrate");
const ventana_Register = document.getElementById("ventana_Register");
registrate.addEventListener('click', () => {
    ventana_Register.classList.add("LoginON");
    ventana_Register.classList.remove("LoginOFF");
})
close_register.addEventListener('click', () => {
    ventana_Register.classList.add("LoginOFF");
    ventana_Register.classList.remove("LoginON");

})
/**FORMULARIO**/

const eye_login_1 = document.getElementById("eye_login_1");
const eye_login_2 = document.getElementById("eye_login_2");
const eye_1 = document.getElementsByClassName("eye_1");
var password_login = document.getElementById("password_login");
eye_login_1.addEventListener('click', () => {
    password_login.type = "text";
    eye_login_1.classList.add("eye_2");
    eye_login_2.classList.remove("eye_2");
})
eye_login_2.addEventListener('click', () => {
    password_login.type = "password"
    eye_login_1.classList.remove("eye_2");
    eye_login_2.classList.add("eye_2");
})
/**/
const eye_register_1 = document.getElementById("eye_register_1");
const eye_register_2 = document.getElementById("eye_register_2");
var password_register = document.getElementById("password_register");
eye_register_1.addEventListener('click', () => {
    password_register.type = "text";
    eye_register_1.classList.add("eye_2");
    eye_register_2.classList.remove("eye_2");
})
eye_register_2.addEventListener('click', () => {
    password_register.type = "password"
    eye_register_1.classList.remove("eye_2");
    eye_register_2.classList.add("eye_2");
})

