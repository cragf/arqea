package com.robert.arqea.models;

public class Lider {

    private Integer id;
    private String nombre;
    private String apellido;

    public Lider() {
    }

    // Constructor completo (incluye id, para registros ya existentes en BD)
    public Lider(Integer id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Constructor para registro nuevo (id lo asigna la BD -> null preventivo)
    public Lider(String nombre, String apellido) {
        this(null, nombre, apellido);
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Lider{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
