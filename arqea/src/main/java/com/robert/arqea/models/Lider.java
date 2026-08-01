package com.robert.arqea.models;

public class Lider {

    private Integer idLider;
    private String nombre;
    private String apellido;

    public Lider() {
    }

    // Constructor completo (incluye id, para registros ya existentes en BD)
    public Lider(Integer idLider, String nombre, String apellido) {
        this.idLider = idLider;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Constructor para registro nuevo (id lo asigna la BD -> null preventivo)
    public Lider(String nombre, String apellido) {
        this(null, nombre, apellido);
    }

    public Integer getIdLider() {
        return idLider;
    }

    public void setIdLider(Integer idLider) {
        this.idLider = idLider;
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
                "idLider=" + idLider +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
