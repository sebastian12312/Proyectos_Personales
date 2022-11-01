const Identificador = document.getElementById('ActivarMensaje');
if (Identificador != null) {
    Identificador.classList.add("ActivarMensaje");
   
} else {
    Identificador.classList.remove("ActivarMensaje");
}
const cerrarMensajeError = document.getElementById('CerrarMensaje-Session');
cerrarMensajeError.addEventListener('click', () => {
    
    Identificador.classList.remove("ActivarMensaje");
    
});
 setTimeout(() => {Identificador.classList.remove("ActivarMensaje");}, 3000);
