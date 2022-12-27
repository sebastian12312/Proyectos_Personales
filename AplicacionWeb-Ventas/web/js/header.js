const NombreUsuario =document.getElementById('NombreUsuario').textContent + '*******'
const $NombreUsuario = NombreUsuario.substring(0,14);
document.getElementById('NombreUsuario').textContent = $NombreUsuario;

const LinkTienda = {
    "name" : "Link del enlance Tienda",
    "link" : "Tienda.jsp"
}
const IDTienda = document.getElementById("MenuTienda");
IDTienda.href = LinkTienda.link;
const IDTienda1 = document.getElementById("dropTienda");
IDTienda1.href = LinkTienda.link;
