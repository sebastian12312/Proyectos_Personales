const LoginON = document.getElementById("barra-login-OFF");
const loginOFF = document.getElementById("barra-login-ON");
const barra_responsive_loginOFF = document.getElementById("barra_responsive_loginOFF");
const barra_responsive_loginON = document.getElementById("barra_responsive_loginON");
const cerrar_barraResponsive = document.getElementById("cerrar_barraResponsive");
const cerrar_barraResponsive_on = document.getElementById("cerrar_barraResponsive_on");
LoginON.addEventListener('click', () => {
    barra_responsive_loginOFF.classList.remove("DisplayLoginOFF");
})
cerrar_barraResponsive.addEventListener('click', () => {
    barra_responsive_loginOFF.classList.add("DisplayLoginOFF");
})
loginOFF.addEventListener('click', () => {
    barra_responsive_loginON.classList.remove("DisplayLoginOFF");
})
cerrar_barraResponsive_on.addEventListener('click', () => {
    barra_responsive_loginON.classList.add("DisplayLoginOFF");
})