let tipoEstibaSeleccionado = "";

// Función para mostrar el formulario y seleccionar el tipo de estiba
function seleccionarEstiba(tipo) {
    tipoEstibaSeleccionado = tipo;

    // Actualiza el DOM con el tipo de estiba seleccionado
    document.getElementById("tipoEstibaSeleccionada").innerText = `Tipo de Estiba: ${tipo}`;
    document.getElementById("tipoEstibaOculta").value = tipo; // Actualiza el campo oculto

    // Muestra el formulario
    document.getElementById("estibaForm").style.display = "block";
}

// Función para guardar una nueva estiba
function guardarEstiba() {
    const cantidadTablas = document.getElementById("cantidadTablas").value;
    const cantidadTacos = document.getElementById("cantidadTacos").value;
    const fecha = document.getElementById("fecha").value;
    const tipoEstiba = document.getElementById("tipoEstibaOculta").value; // Recupera del campo oculto

    if (!cantidadTablas || !cantidadTacos || !fecha || !tipoEstiba) {
        alert("Por favor, complete todos los campos.");
        return;
    }

    const estibaData = {
        cantidadTablas: parseInt(cantidadTablas),
        cantidadTacos: parseInt(cantidadTacos),
        fecha: fecha,
        tipoEstiba: tipoEstiba
    };

    fetch("http://localhost:8080/api/estibas/crear", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(estibaData)
    })
        .then(response => response.json())
        .then(data => {
            alert("Estiba guardada con éxito!");
        })
        .catch(error => {
            alert("Error al guardar la estiba: " + error.message);
        });
}