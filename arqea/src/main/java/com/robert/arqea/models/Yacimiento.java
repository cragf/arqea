package com.robert.arqea.models;

public class Yacimiento {

    private Integer idYacimiento;
    private String nombre;
    private Double latitud;  // nullable en BD (coordenadas POINT admite NULL)
    private Double longitud; // nullable en BD (coordenadas POINT admite NULL)

    public Yacimiento() {
    }

    // Constructor completo (incluye id, para registros ya existentes en BD)
    public Yacimiento(Integer idYacimiento, String nombre, Double latitud, Double longitud) {
        this.idYacimiento = idYacimiento;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    // Constructor para registro nuevo con coordenadas conocidas (id -> null preventivo)
    public Yacimiento(String nombre, Double latitud, Double longitud) {
        this(null, nombre, latitud, longitud);
    }

    // Constructor para registro nuevo sin coordenadas todavia (id y coordenadas -> null preventivo)
    public Yacimiento(String nombre) {
        this(null, nombre, null, null);
    }

    public Integer getIdYacimiento() {
        return idYacimiento;
    }

    public void setIdYacimiento(Integer idYacimiento) {
        this.idYacimiento = idYacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Yacimiento{" +
                "idYacimiento=" + idYacimiento +
                ", nombre='" + nombre + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                '}';
    }
}
