/*VENTANA MODAL LOGIN*/
const AbrirLogin = document.getElementById('AbrirLogin');
const VentanaLogin = document.getElementById('Ventana_Modal_Login');
const CerrarLogin = document.getElementById('CerrarLogin');
AbrirLogin.addEventListener('click', ()=>{
    VentanaLogin.classList.add("AbrirVentana");
});
CerrarLogin.addEventListener('click', ()=>{
    VentanaLogin.classList.remove("AbrirVentana").classList.add("CerrarVentana");
});

/*VENTANA MODAL REGISTER*/
const AbrirRegister = document.getElementById('AbrirRegister');
const VentanaRegister = document.getElementById('Ventana_Modal_Register');
const CerrarRegister = document.getElementById('CerrarRegister');
AbrirRegister.addEventListener('click', ()=>{
    VentanaRegister.classList.add("AbrirVentana");
});
CerrarRegister.addEventListener('click', ()=>{
    VentanaRegister.classList.remove("AbrirVentana");
});
/*MODAL BAR*/
const btnAbrirBarra =document.getElementById("AbrirBarraUsuario");
const header_bar_usuario =document.getElementById('header_bar_usuario');
const CerraBarraUsuario = document.getElementById('CerraBarraUsuario');
btnAbrirBarra.addEventListener('click', ()=>{
    header_bar_usuario.classList.add('AbrirBarr');

})
CerraBarraUsuario.addEventListener('click', ()=>{
    header_bar_usuario.classList.remove('AbrirBarr');

})

const btnAbrirBarraNoUsuario =document.getElementById("btnAbrirBarraNoUsuario");
const header_bar_NoUsuario =document.getElementById('header_bar_NoUsuario');
const CerraBarraNoUsuario = document.getElementById('CerraBarraNoUsuario');
btnAbrirBarraNoUsuario.addEventListener('click', ()=>{
    header_bar_NoUsuario.classList.add('AbrirBarr');

})
CerraBarraNoUsuario.addEventListener('click', ()=>{
    header_bar_NoUsuario.classList.remove('AbrirBarr');

})