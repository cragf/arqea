let filaActual = null;
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
function Toggle(fila) {

    if (filaActual !== null) {
        filaActual.style.setProperty('--color-fila', '#eed');
    }

    fila.style.setProperty('--color-fila', '#ff9f70');

    if (filaActual === fila) {
        fila.style.setProperty('--color-fila', '#eed');
        filaActual = null;
        return;
    }
    filaActual = fila;
}
function pedirClave(tipo, id, accion) {
    document.getElementById('clave-tipo').value = tipo;
    document.getElementById('clave-id').value = id;
    document.getElementById('clave-accion').value = accion;
    document.getElementById('modal-clave-accion').style.display = 'flex';
}

function cerrarModalClave() {
    document.getElementById('modal-clave-accion').style.display = 'none';
}