package com.robert.arqea.models;

public class Clase {

    private Integer idClase;
    private String nombreClase;
    private String descripcionClase;

    public Clase() {
    }

    // Constructor completo (incluye id, para registros ya existentes en BD)
    public Clase(Integer idClase, String nombreClase, String descripcionClase) {
        this.idClase = idClase;
        this.nombreClase = nombreClase;
        this.descripcionClase = descripcionClase;
    }

    // Constructor para registro nuevo (id lo asigna la BD -> null preventivo)
    public Clase(String nombreClase, String descripcionClase) {
        this(null, nombreClase, descripcionClase);
    }

    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public String getDescripcionClase() {
        return descripcionClase;
    }

    public void setDescripcionClase(String descripcionClase) {
        this.descripcionClase = descripcionClase;
    }

    @Override
    public String toString() {
        return "Clase{" +
                "idClase=" + idClase +
                ", nombreClase='" + nombreClase + '\'' +
                ", descripcionClase='" + descripcionClase + '\'' +
                '}';
    }
}
