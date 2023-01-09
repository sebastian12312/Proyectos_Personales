const login_user = document.querySelectorAll('.login_user');
const body_contenedor_login = document.getElementById('body_contenedor_login');


for(let variable of login_user){
  variable.addEventListener('click', (event)=>{
    // Añade la clase que abre la ventana modal
    body_contenedor_login.classList.add('OpenLoginModal');
  });
}
body_contenedor_login.addEventListener('click', (e) => {
    if (e.target === body_contenedor_login) {
      body_contenedor_login.classList.remove('OpenLoginModal');
    }
  });
  