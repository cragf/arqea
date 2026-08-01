package com.robert.arqea.models;
 
public class Artefacto {
 
    private Integer idArtefacto;
    private String nombre;
    private String descripcion;
    private String descubridores; // FK -> nombre del equipo
    private Boolean encamino;
    private String museo;         // FK -> nombre del museo (nullable en BD)
    private String yacimiento;    // FK -> nombre del yacimiento
    private String clave;         // codigo unico, ej. 2 letras + 10 numeros
    private String img;           // nullable en BD
    private String clase;         // FK -> nombre de la clase
 
    public Artefacto() {
    }
 
    // Constructor completo (incluye id, para registros ya existentes en BD)
    public Artefacto(Integer idArtefacto, String nombre, String descripcion, String descubridores,
                      Boolean encamino, String museo, String yacimiento, String clave,
                      String img, String clase) {
        this.idArtefacto = idArtefacto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.descubridores = descubridores;
        this.encamino = encamino;
        this.museo = museo;
        this.yacimiento = yacimiento;
        this.clave = clave;
        this.img = img;
        this.clase = clase;
    }
 
    // Constructor para registro nuevo, con museo e img conocidos (id -> null preventivo)
    public Artefacto(String nombre, String descripcion, String descubridores, Boolean encamino,
                      String museo, String yacimiento, String clave, String img, String clase) {
        this(null, nombre, descripcion, descubridores, encamino, museo, yacimiento, clave, img, clase);
    }
 
    // Constructor para registro nuevo sin museo asignado ni imagen todavia
    // (id, museo e img -> null preventivo, campos nullable segun la BD)
    public Artefacto(String nombre, String descripcion, String descubridores, Boolean encamino,
                      String yacimiento, String clave, String clase) {
        this(null, nombre, descripcion, descubridores, encamino, null, yacimiento, clave, null, clase);
    }
 
    public Integer getIdArtefacto() {
        return idArtefacto;
    }
 
    public void setIdArtefacto(Integer idArtefacto) {
        this.idArtefacto = idArtefacto;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public String getDescripcion() {
        return descripcion;
    }
 
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
 
    public String getDescubridores() {
        return descubridores;
    }
 
    public void setDescubridores(String descubridores) {
        this.descubridores = descubridores;
    }
 
    public Boolean getEncamino() {
        return encamino;
    }
 
    public void setEncamino(Boolean encamino) {
        this.encamino = encamino;
    }
 
    public String getMuseo() {
        return museo;
    }
 
    public void setMuseo(String museo) {
        this.museo = museo;
    }
 
    public String getYacimiento() {
        return yacimiento;
    }
 
    public void setYacimiento(String yacimiento) {
        this.yacimiento = yacimiento;
    }
 
    public String getClave() {
        return clave;
    }
 
    public void setClave(String clave) {
        this.clave = clave;
    }
 
    public String getImg() {
        return img;
    }
 
    public void setImg(String img) {
        this.img = img;
    }
 
    public String getClase() {
        return clase;
    }
 
    public void setClase(String clase) {
        this.clase = clase;
    }
 
    @Override
    public String toString() {
        return "Artefacto{" +
                "idArtefacto=" + idArtefacto +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", descubridores='" + descubridores + '\'' +
                ", encamino=" + encamino +
                ", museo='" + museo + '\'' +
                ", yacimiento='" + yacimiento + '\'' +
                ", clave='" + clave + '\'' +
                ", img='" + img + '\'' +
                ", clase='" + clase + '\'' +
                '}';
    }
}
 