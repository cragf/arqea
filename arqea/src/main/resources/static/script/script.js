function mostrarImagen(nombreArchivo) {
    var img = document.getElementById("imagen-preview");
    if (nombreArchivo && nombreArchivo !== "null") {
        img.src = "/img/" + nombreArchivo;
        console.log("Mostrando imagen: " + nombreArchivo);
    } else {
        img.src = "/img/sin-imagen.png";
        console.log("Mostrando imagen por defecto");
    }
}
function mostrarTabla(boton) {
    var targetId = boton.getAttribute("data-target");

    document.querySelectorAll(".tabla-seccion").forEach(function (seccion) {
        seccion.classList.remove("activo");
    });
    document.querySelectorAll(".toggle-btn").forEach(function (btn) {
        btn.classList.remove("activo");
    });

    document.getElementById(targetId).classList.add("activo");
    boton.classList.add("activo");
}