package com.robert.arqea.models;

public class Equipo {

    private Integer idEquipo;
    private String nombreEquipo;
    private String lider; // FK -> Lider.idLider
    private String clave;
    private boolean habilitado;
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }


    
    public boolean isHabilitado() {
        return habilitado;
    }
    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
    // Constructor completo (incluye id, para registros ya existentes en BD)
    public Equipo(Integer idEquipo, String nombreEquipo, String lider, String clave) {
        this.idEquipo = idEquipo;
        this.nombreEquipo = nombreEquipo;
        this.lider = lider;
        this.clave = clave;
        this.habilitado = true;
    }
    public Equipo() {
    }


    // Constructor para registro nuevo (id lo asigna la BD -> null preventivo)
    public Equipo(String nombreEquipo, String lider, String clave) {
        this(null, nombreEquipo, lider, clave);
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
                ", lider=" + lider +
                '}';
    }
}
