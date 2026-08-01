package com.robert.arqea.models;

public class Museo {

    private Integer id;
    private String nombre;

    public Museo() {
    }

    // Constructor completo (incluye id, para registros ya existentes en BD)
    public Museo(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Constructor para registro nuevo (id lo asigna la BD -> null preventivo)
    public Museo(String nombre) {
        this(null, nombre);
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

    @Override
    public String toString() {
        return "Museo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
