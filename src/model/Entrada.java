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
public class Entrada extends BaseModel {
    
    public Entrada(long id){
        this.id = id;
        this.numero_documento = "";
        this.fecha = null;
        this.proveedor = null;
        this.orden_compra = null;
        this.valor = 0;
        this.url_archivo = "";
        this.observacion = "";
    }
    
    public Entrada(
            long id,
            String numero_documento,
            Date fecha,
            Proveedor proveedor,
            OrdenCompra orden_compra,
            int valor,
            String url_archivo,
            String observacion){
        this.id = id;
        this.numero_documento = numero_documento;
        this.fecha = fecha;
        this.proveedor = proveedor;
        this.orden_compra = orden_compra;
        this.valor = valor;
        this.url_archivo = url_archivo;
        this.observacion = observacion;
    }
    
    private long id;
    private String numero_documento;
    private Date fecha;
    private Proveedor proveedor;
    private OrdenCompra orden_compra;
    private int valor;
    private String url_archivo;
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
     * @return the proveedor
     */
    public Proveedor getProveedor() {
        return proveedor;
    }

    /**
     * @param proveedor the proveedor to set
     */
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * @return the orden_compra
     */
    public OrdenCompra getOrden_compra() {
        return orden_compra;
    }

    /**
     * @param orden_compra the orden_compra to set
     */
    public void setOrden_compra(OrdenCompra orden_compra) {
        this.orden_compra = orden_compra;
    }

    /**
     * @return the valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * @return the url_archivo
     */
    public String getUrl_archivo() {
        return url_archivo;
    }

    /**
     * @param url_archivo the url_archivo to set
     */
    public void setUrl_archivo(String url_archivo) {
        this.url_archivo = url_archivo;
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
