// Variable para almacenar el tipo de estiba seleccionado
let tipoEstibaSeleccionado = "";

// Función para mostrar el formulario y seleccionar el tipo de estiba
function seleccionarEstiba(tipo) {
    tipoEstibaSeleccionado = tipo;
    document.getElementById("tipoEstibaSeleccionada").innerText = `Tipo de Estiba: ${tipo}`;
    document.getElementById("estibaForm").style.display = "block";
}

// Función para guardar una nueva estiba
function guardarEstiba() {
    const cantidadTablas = document.getElementById("cantidadTablas").value;
    const cantidadTacos = document.getElementById("cantidadTacos").value;

    if (!cantidadTablas || !cantidadTacos || !tipoEstibaSeleccionado) {
        alert("Por favor, complete todos los campos.");
        return;
    }

    const estibaData = {
        cantidadTablas: parseInt(cantidadTablas),
        cantidadTacos: parseInt(cantidadTacos),
        tipoEstiba: tipoEstibaSeleccionado
    };

    // Simulación de guardado (puedes agregar lógica adicional aquí)
    console.log("Datos de la estiba guardados:", estibaData);

    // Limpiar campos del formulario
    document.getElementById("cantidadTablas").value = "";
    document.getElementById("cantidadTacos").value = "";

    // Opcional: Ocultar el formulario o resetear el tipo de estiba seleccionado
    // document.getElementById("estibaForm").style.display = "none";
    // tipoEstibaSeleccionado = "";
}
    
