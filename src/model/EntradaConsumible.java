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
public class EntradaConsumible extends BaseModel {
    
    public EntradaConsumible(long id, Entrada entrada, Consumible consumible, int cantidad) {
        this.id = id;
        this.entrada = entrada;
        this.consumible = consumible;
        this.cantidad = cantidad;
    }
    
    private long id;
    private Entrada entrada;
    private Consumible consumible;
    private int cantidad;

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
     * @return the entrada
     */
    public Entrada getEntrada() {
        return entrada;
    }

    /**
     * @param entrada the entrada to set
     */
    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    /**
     * @return the consumible
     */
    public Consumible getConsumible() {
        return consumible;
    }

    /**
     * @param consumible the consumible to set
     */
    public void setConsumible(Consumible consumible) {
        this.consumible = consumible;
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
    
}
