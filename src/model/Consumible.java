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
public class Consumible extends BaseModel {
    
    public Consumible(long id) {
        this.id = id;
        this.cantidad = 0;
        this.cantidad_minima = 0;
        this.estado = false;
        this.modelo = null;
    }
    
    public Consumible(
            long id, 
            int cantidad,
            int cantidad_minima,
            boolean estado,
            Modelo modelo) {
        this.id = id;
        this.cantidad = cantidad;
        this.cantidad_minima = cantidad_minima;
        this.estado = estado;
        this.modelo = modelo;
    }
    
    private long id;
    private int cantidad;
    private int cantidad_minima;
    private boolean estado;
    private Modelo modelo;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the cantidad_minima
     */
    public int getCantidad_minima() {
        return cantidad_minima;
    }

    /**
     * @param cantidad_minima the cantidad_minima to set
     */
    public void setCantidad_minima(int cantidad_minima) {
        this.cantidad_minima = cantidad_minima;
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
     * @return the modelo
     */
    public Modelo getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    
}
