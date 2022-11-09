/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author kevin
 */
public class Trabajador extends BaseModel {
    
    public Trabajador(String rut){
        this.rut = rut;
        this.nombre = "";
        this.area = null;
        this.turno = null;
        this.fecha_nacimiento = null;
        this.estado = false;
        this.talla_camisa = "";
        this.talla_pantalon = "";
        this.talla_calzado = "";
    }
    
    public Trabajador(
            String rut,
            String nombre,
            Area area,
            Turno turno,
            String fecha_nacimiento,
            boolean estado,
            String talla_camisa,
            String talla_pantalon,
            String talla_calzado){
        this.rut = rut;
        this.nombre = nombre;
        this.area = area;
        this.turno = turno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.estado = estado;
        this.talla_camisa = talla_camisa;
        this.talla_pantalon = talla_pantalon;
        this.talla_calzado = talla_calzado;
    }
    
    private String old_rut;
    private String rut;
    private String nombre;
    private Area area;
    private Turno turno;
    private String fecha_nacimiento;
    private boolean estado;
    private String talla_camisa;
    private String talla_pantalon;
    private String talla_calzado;

    /**
     * @return the old_rut
     */
    public String getOld_rut() {
        return old_rut;
    }

    /**
     * @param old_rut the old_rut to set
     */
    public void setOld_rut(String old_rut) {
        this.old_rut = old_rut;
    }
    
    /**
     * @return the rut
     */
    public String getRut() {
        return rut;
    }

    /**
     * @param rut the rut to set
     */
    public void setRut(String rut) {
        this.rut = rut;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the area
     */
    public Area getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(Area area) {
        this.area = area;
    }

    /**
     * @return the turno
     */
    public Turno getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    /**
     * @return the fecha_nacimiento
     */
    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * @param fecha_nacimiento the fecha_nacimiento to set
     */
    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     * @return the estado
     */
    public boolean getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the talla_camisa
     */
    public String getTalla_camisa() {
        return talla_camisa;
    }

    /**
     * @param talla_camisa the talla_camisa to set
     */
    public void setTalla_camisa(String talla_camisa) {
        this.talla_camisa = talla_camisa;
    }

    /**
     * @return the talla_pantalon
     */
    public String getTalla_pantalon() {
        return talla_pantalon;
    }

    /**
     * @param talla_pantalon the talla_pantalon to set
     */
    public void setTalla_pantalon(String talla_pantalon) {
        this.talla_pantalon = talla_pantalon;
    }

    /**
     * @return the talla_calzado
     */
    public String getTalla_calzado() {
        return talla_calzado;
    }

    /**
     * @param talla_calzado the talla_calzado to set
     */
    public void setTalla_calzado(String talla_calzado) {
        this.talla_calzado = talla_calzado;
    }
    
}
