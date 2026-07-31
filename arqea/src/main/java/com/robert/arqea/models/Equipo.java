package com.robert.arqea.models;

public class Equipo {

    private Integer idEquipo;
    private String nombreEquipo;
    private Integer lider; // FK -> Lider.idLider

    public Equipo() {
    }

    // Constructor completo (incluye id, para registros ya existentes en BD)
    public Equipo(Integer idEquipo, String nombreEquipo, Integer lider) {
        this.idEquipo = idEquipo;
        this.nombreEquipo = nombreEquipo;
        this.lider = lider;
    }

    // Constructor para registro nuevo (id lo asigna la BD -> null preventivo)
    public Equipo(String nombreEquipo, Integer lider) {
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

    public Integer getLider() {
        return lider;
    }

    public void setLider(Integer lider) {
        this.lider = lider;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "idEquipo=" + idEquipo +
                ", nombreEquipo='" + nombreEquipo + '\'' +
                ", lider=" + lider +
                '}';
    }
}
