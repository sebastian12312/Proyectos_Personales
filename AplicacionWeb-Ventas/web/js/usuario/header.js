

/*tipo de thema*/
const  cambio_theme = document.getElementById('cambio-theme');
const $header = document.getElementById('header');


cambio_theme.addEventListener('click',()=>{
  if(sessionStorage.getItem('buttonClicked' === 'true')){
    cambio_theme.classList.toggle('desactive');
    $header.classList.toggle('ThemeLight');

  } else {
    cambio_theme.classList.toggle('active');
    $header.classList.toggle('Themedark');
    sessionStorage.setItem('buttonClicked', 'true');

  }
});

if(sessionStorage.getItem('buttonClicked') === 'true' ){
  cambio_theme.classList.toggle('active');
  $header.classList.toggle('Themedark');

} 
const NombreUsuario = document.getElementById('NombreUsuario').textContent + '*********'
const $NombreUsuario = NombreUsuario.substring(0, 15);
document.getElementById('NombreUsuario').textContent = $NombreUsuario;
/*data links*/
const DataLink = document.querySelectorAll('[data-link]');
for (let data of DataLink) {
    data.addEventListener('click', () => {
        const atributo = data.getAttribute('data-link');
        if (atributo === 'tienda') {
            data.href = 'tienda.html';
        } else if (atributo === 'contacto') {
            data.href = 'contacto.html';
        } else if (atributo === 'nosotros') {
            data.href = 'nosotros.html';
        }
    });
}