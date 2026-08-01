package com.robert.arqea.models;

public class Clase {

    private Integer id;
    private String nombre;
    private String descripcion;

    public Clase() {
    }

    // Constructor completo (incluye id, para registros ya existentes en BD)
    public Clase(Integer id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Constructor para registro nuevo (id lo asigna la BD -> null preventivo)
    public Clase(String nombre, String descripcion) {
        this(null, nombre, descripcion);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Clase{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
