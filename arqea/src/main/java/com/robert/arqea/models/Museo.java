package com.robert.arqea.models;

public class Museo {

    private Integer idMuseo;
    private String nombreMuseo;
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

    public Museo() {
    }

    // Constructor completo (incluye id, para registros ya existentes en BD)
    public Museo(Integer idMuseo, String nombreMuseo) {
        this.idMuseo = idMuseo;
        this.nombreMuseo = nombreMuseo;
        this.clave = null;
        this.habilitado = true;
    }

    // Constructor para registro nuevo
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
