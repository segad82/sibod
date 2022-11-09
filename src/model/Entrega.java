/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author kevin
 */
public class Entrega extends BaseModel {
    
    public Entrega(long id){
        this.id = id;
        this.numero_documento = "";
        this.fecha = null;
        this.persona_entrega = null;
        this.persona_recibe = null;
        this.observacion = "";
    }
    
    public Entrega(
            long id,
            String numero_documento,
            Date fecha,
            Trabajador persona_entrega,
            Trabajador persona_recibe,
            String observacion){
        this.id = id;
        this.numero_documento = numero_documento;
        this.fecha = fecha;
        this.persona_entrega = persona_entrega;
        this.persona_recibe = persona_recibe;
        this.observacion = observacion;
    }
    
    private long id;
    private String numero_documento;
    private Date fecha;
    private Trabajador persona_entrega;
    private Trabajador persona_recibe;
    private String observacion;

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
     * @return the numero_documento
     */
    public String getNumero_documento() {
        return numero_documento;
    }

    /**
     * @param numero_documento the numero_documento to set
     */
    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the persona_entrega
     */
    public Trabajador getPersona_entrega() {
        return persona_entrega;
    }

    /**
     * @param persona_entrega the persona_entrega to set
     */
    public void setPersona_entrega(Trabajador persona_entrega) {
        this.persona_entrega = persona_entrega;
    }

    /**
     * @return the persona_recibe
     */
    public Trabajador getPersona_recibe() {
        return persona_recibe;
    }

    /**
     * @param persona_recibe the persona_recibe to set
     */
    public void setPersona_recibe(Trabajador persona_recibe) {
        this.persona_recibe = persona_recibe;
    }

    /**
     * @return the observacion
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * @param observacion the observacion to set
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
}
