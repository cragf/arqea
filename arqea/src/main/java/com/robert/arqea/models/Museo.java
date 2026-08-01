package com.robert.arqea.models;

public class Museo {

    private Integer idMuseo;
    private String nombreMuseo;

    public Museo() {
    }

    // Constructor completo (incluye id, para registros ya existentes en BD)
    public Museo(Integer idMuseo, String nombreMuseo) {
        this.idMuseo = idMuseo;
        this.nombreMuseo = nombreMuseo;
    }

    // Constructor para registro nuevo (id lo asigna la BD -> null preventivo)
    public Museo(String nombreMuseo) {
        this(null, nombreMuseo);
    }

    public Integer getIdMuseo() {
        return idMuseo;
    }

    public void setIdMuseo(Integer idMuseo) {
        this.idMuseo = idMuseo;
    }

    public String getNombreMuseo() {
        return nombreMuseo;
    }

    public void setNombreMuseo(String nombreMuseo) {
        this.nombreMuseo = nombreMuseo;
    }

    @Override
    public String toString() {
        return "Museo{" +
                "idMuseo=" + idMuseo +
                ", nombreMuseo='" + nombreMuseo + '\'' +
                '}';
    }
}
