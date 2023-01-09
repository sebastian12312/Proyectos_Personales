const pass1 = document.getElementById('pass1');
const pass2 = document.getElementById('pass2');
const mensaje__validacion = document.querySelectorAll('.mensaje__validacion');
const button_register = document.getElementById('button_register');
button_register.disabled = 'true';
button_register.disabled = 'false';
pass2.disabled = 'true';
pass2.disabled = 'false';
pass2.classList.add('DisableButton');
button_register.classList.add('DisableButton');
pass1.addEventListener('input', () => {
    if (pass1.value != "") {
        if (pass1.value.length > 8) {
            pass2.disabled = false;
            pass2.classList.remove('DisableButton');
          
            for (i = 0; i < mensaje__validacion.length; i++) {
                mensaje__validacion[i].textContent = '';
                mensaje__validacion[i].classList.add('PassError');
                pass1.classList.remove('InputError');
            }
        }else{
            for (i = 0; i < mensaje__validacion.length; i++) {
                mensaje__validacion[i].textContent = 'contrasena muy corta';
                mensaje__validacion[i].classList.add('PassError');
                pass1.classList.add('InputError');
            }
        }
            pass2.addEventListener('input', () => {
                if (pass1.value === pass2.value) {                   
                    for (i = 0; i < mensaje__validacion.length; i++) {
                        mensaje__validacion[i].textContent = '*contraseña iguales*';
                        mensaje__validacion[i].classList.add('PassIguales');
                        mensaje__validacion[i].classList.remove('PassError');
                        button_register.disabled = false;
                        button_register.classList.remove('DisableButton');
                        pass1.classList.remove('InputError');
                        pass2.classList.remove('InputError');
                        pass1.classList.add('InputCorrecto');
                        pass2.classList.add('InputCorrecto');
                    }
                } else {
                    for (i = 0; i < mensaje__validacion.length; i++) {
                        mensaje__validacion[i].classList.add('PassError');
                        mensaje__validacion[i].classList.remove('PassIguales');
                        mensaje__validacion[i].textContent = '*contraseña no coinciden*';
                        button_register.disabled = true;
                        button_register.classList.add('DisableButton');
                        pass1.classList.add('InputError');
                        pass2.classList.add('InputError');
                        pass1.classList.remove('InputCorrecto');
                        pass2.classList.remove('InputCorrecto');
                    }
                }
            })        
    } else {
        console.log('vacido');
        pass2.disabled = true;
        pass2.classList.add('DisableButton');
    }
});
const ver_password = document.querySelectorAll('[data-password]');
for (i = 0; i < ver_password.length; i++) {
    const respuesta = ver_password[i].getAttribute('data-password')
    ver_password[i].addEventListener('click', () => {
        if (respuesta == 'view_pass1') {
            if (pass1.type == 'password') {
                pass1.type = 'text';
            } else {
                pass1.type = 'password';
            }
        } else if (respuesta == 'view_pass2') {
            if (pass2.type == 'password') {
                pass2.type = 'text';
            } else {
                pass2.type = 'password';
            }
        }
    })

}
if(pass1.onclick){
    console.log('aeamongol')
}