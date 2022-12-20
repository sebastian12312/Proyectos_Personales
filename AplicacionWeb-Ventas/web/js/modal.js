const AbrirVentanaLogin = document.getElementById('AbrirVentanaLogin');
const contenedor_modal_login =document.getElementById('contenedor_modal_login');
const CerrarVentanaLogin = document.getElementById('CerrarVentanaLogin');
AbrirVentanaLogin.addEventListener('click', ()=>{
    contenedor_modal_login.classList.add('AbrirModal');
    contenedor_modal_login.classList.remove('CerrarModal');
});
CerrarVentanaLogin.addEventListener('click',()=>{
    contenedor_modal_login.classList.add('CerrarModal');
    contenedor_modal_login.classList.remove('AbrirModal');
});
const AbrirVentanaRegister = document.getElementById('AbrirVentanaRegister');
const contenedor_modal_register =document.getElementById('contenedor_modal_register');
const CerrarModalRegister = document.getElementById('CerrarModalRegister');
AbrirVentanaRegister.addEventListener('click', ()=>{
    contenedor_modal_register.classList.add('AbrirModal');
    contenedor_modal_register.classList.remove('CerrarModal');
});
CerrarModalRegister.addEventListener('click',()=>{
    contenedor_modal_register.classList.add('CerrarModal');
    contenedor_modal_register.classList.remove('AbrirModal');
});
/*barra lateral*/

const AbrirVentanaLateralNoUsuario = document.getElementById('AbrirVentanaLateralNoUsuario');
const contenedor_barra_lateral_NoUsuario = document.getElementById('contenedor_barra_lateral_NoUsuario');
const CerrarVentanaLateralNoUsuario = document.getElementById('CerrarVentanaLateralNoUsuario');
AbrirVentanaLateralNoUsuario.addEventListener('click', ()=>{
    contenedor_barra_lateral_NoUsuario.classList.add('AbrirModdalLateral');
    contenedor_barra_lateral_NoUsuario.classList.remove('CerrarModdalLateral');
});
CerrarVentanaLateralNoUsuario.addEventListener('click', ()=>{
    contenedor_barra_lateral_NoUsuario.classList.add('CerrarModdalLateral');
    contenedor_barra_lateral_NoUsuario.classList.remove('AbrirModdalLateral');
  
});

/*ver password*/
const ver_password = document.getElementById('ver_password');
const password_modal = document.getElementById('password_modal');
const li = ver_password.querySelector('li:first-child');
const li2 = ver_password.querySelector('li:nth-child(2)');
ver_password.addEventListener('click', ()=>{
    if(password_modal.type == 'password'){
        password_modal.type  = 'text';
        li.style.display = "none";
        li2.style.display = "flex";
    }else{
        password_modal.type = 'password';
        li.style.display = "flex";
        li2.style.display = "none";
       
    }
});