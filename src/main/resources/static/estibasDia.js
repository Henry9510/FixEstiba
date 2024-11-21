function obtenerTotalesDelDia() {
    // URLs para cada tipo de estiba
    const urls = {
        pequena: "http://localhost:8080/api/estibas/totales/pequeña",
        mediana: "http://localhost:8080/api/estibas/totales/mediana",
        grande: "http://localhost:8080/api/estibas/totales/grande"
    };

    // Variables para acumular el total de tacos
    let totalTacos = 0;

    // Función para procesar la respuesta de cada tipo de estiba
    function procesarRespuesta(tipo, data) {
        document.getElementById(`totales${tipo}Tablas`).innerText = `${data[0]} Tablas`;
        totalTacos += data[1]; // Acumular tacos
        document.getElementById("totalesTacos").innerText = `${totalTacos} Tacos`; // Actualizar tacos totales
    }

    // Solicitar y procesar datos para cada tipo de estiba
    Object.keys(urls).forEach(tipo => {
        fetch(urls[tipo])
            .then(response => {
                if (!response.ok) {
                    throw new Error(`Error en la solicitud: ${response.status}`);
                }
                return response.json(); // Convertir respuesta a JSON
            })
            .then(data => procesarRespuesta(tipo.charAt(0).toUpperCase() + tipo.slice(1), data)) // Actualizar dashboard
            .catch(error => {
                console.error(`Error al obtener los datos de ${tipo}:`, error);
                document.getElementById(`totales${tipo}Tablas`).innerText = "Error al cargar";
            });
    });
}

// Llamar a la función al cargar la página
document.addEventListener("DOMContentLoaded", obtenerTotalesDelDia);