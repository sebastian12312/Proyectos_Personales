response.setContentType("application/json");
response.setCharacterEncoding("UTF-8");
var variable = new XMLHttpRequest;
variable.onload = function () {
    fetch('/session', {
        method: 'post',
        headers: {
            'Content-Type': 'application/json'
        }
    })
            .then(response => response.json())
            .then(data => {
                // Procesar la respuesta del servlet aquí
                console.log(data.message);
            });
}