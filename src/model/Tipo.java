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
public class Tipo extends BaseModel {
    
    public Tipo(int id) {
        this.id = id;
        this.nombre = "";
        this.estado = false;
        this.categoria = null;
        this.clase = false;
    }
    
    public Tipo(int id, String nombre, boolean estado, Categoria categoria, boolean clase) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.categoria = categoria;
        this.clase = clase;
    }
    
    private int id;
    private String nombre;
    private boolean estado;
    private Categoria categoria;
    private boolean clase;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the clase
     */
    public boolean getClase() {
        return clase;
    }

    /**
     * @param clase the clase to set
     */
    public void setClase(boolean clase) {
        this.clase = clase;
    }
    
}
