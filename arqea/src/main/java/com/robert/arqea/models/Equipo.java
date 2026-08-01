package com.robert.arqea.models;
 
public class Equipo {
 
    private Integer idEquipo;
    private String nombreEquipo;
    private String lider; // FK -> se muestra como nombre del lider, no como id
 
    public Equipo() {
    }
 
    // Constructor completo (incluye id, para registros ya existentes en BD)
    public Equipo(Integer idEquipo, String nombreEquipo, String lider) {
        this.idEquipo = idEquipo;
        this.nombreEquipo = nombreEquipo;
        this.lider = lider;
    }
 
    // Constructor para registro nuevo (id lo asigna la BD -> null preventivo)
    public Equipo(String nombreEquipo, String lider) {
        this(null, nombreEquipo, lider);
    }
 
    public Integer getIdEquipo() {
        return idEquipo;
    }
 
    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }
 
    public String getNombreEquipo() {
        return nombreEquipo;
    }
 
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
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
                "idEquipo=" + idEquipo +
                ", nombreEquipo='" + nombreEquipo + '\'' +
                ", lider='" + lider + '\'' +
                '}';
    }
}
 