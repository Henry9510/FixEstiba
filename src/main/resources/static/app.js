// Variable para almacenar el tipo de estiba seleccionado
let tipoEstibaSeleccionado = "";

// Función para mostrar el formulario y seleccionar el tipo de estiba
function seleccionarEstiba(tipo) {
    tipoEstibaSeleccionado = tipo;
    document.getElementById("tipoEstibaSeleccionada").innerText = `Tipo de Estiba: ${tipo}`;
    document.getElementById("estibaForm").style.display = "block";
}

// Función para guardar una nueva estiba
async function guardarEstiba() {
    const cantidadTablas = document.getElementById("cantidadTablas").value;
    const cantidadTacos = document.getElementById("cantidadTacos").value;
    const fecha = document.getElementById("fecha").value;

    if (!cantidadTablas || !cantidadTacos || !tipoEstibaSeleccionado) {
        alert("Por favor, complete todos los campos.");
        return;
    }

    const estibaData = {
        fecha:fecha,
        cantidadTablas: parseInt(cantidadTablas),
        cantidadTacos: parseInt(cantidadTacos),
        tipoEstiba: tipoEstibaSeleccionado
    };

    try {
        // Realizar POST al backend
        const response = await fetch("http://localhost:8080/api/estibas/crear", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(estibaData)
        });

        if (!response.ok) {
            throw new Error(`Error al guardar la estiba: ${response.statusText}`);
        }

        const responseData = await response.json();
        console.log("Datos guardados con éxito:", responseData);

        // Mostrar mensaje de éxito
        alert("La estiba se ha registrado correctamente.");

        // Limpiar campos del formulario
        document.getElementById("cantidadTablas").value = "";
        document.getElementById("cantidadTacos").value = "";

        // Opcional: Ocultar el formulario o resetear el tipo de estiba seleccionado
        // document.getElementById("estibaForm").style.display = "none";
        // tipoEstibaSeleccionado = "";
    } catch (error) {
        console.error("Error al guardar la estiba:", error);
        alert("Hubo un error al guardar la estiba. Inténtelo nuevamente.");
    }
}
