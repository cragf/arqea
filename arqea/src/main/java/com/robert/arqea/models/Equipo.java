package com.robert.arqea.models;
 
public class Equipo {
 
    private Integer id;
    private String nombre;
    private String lider; // FK -> se muestra como nombre del lider, no como id
 
    public Equipo() {
    }
 
    // Constructor completo (incluye id, para registros ya existentes en BD)
    public Equipo(Integer id, String nombre, String lider) {
        this.id = id;
        this.nombre = nombre;
        this.lider = lider;
    }
 
    // Constructor para registro nuevo (id lo asigna la BD -> null preventivo)
    public Equipo(String nombre, String lider) {
        this(null, nombre, lider);
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
 
    public String getLider() {
        return lider;
    }
 
    public void setLider(String lider) {
        this.lider = lider;
    }
 
    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", lider='" + lider + '\'' +
                '}';
    }
}
 