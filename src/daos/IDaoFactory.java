/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import model.*;

/**
 *
 * @author kevin
 */
public interface IDaoFactory {
    IDao<Activo> getDaoActivo();
    IDao<ActivoNota> getDaoActivoNota();
    IDao<Area> getDaoArea();
    IDao<Categoria> getDaoCategoria();
    IDao<Consumible> getDaoConsumible();
    IDao<Entrada> getDaoEntrada();
    IDao<EntradaActivo> getDaoEntradaActivo();
    IDao<EntradaConsumible> getDaoEntradaConsumible();
    IDao<Entrega> getDaoEntrega();
    IDao<EntregaActivo> getDaoEntregaActivo();
    IDao<EntregaConsumible> getDaoEntregaConsumible();
    IDao<Marca> getDaoMarca();
    IDao<Modelo> getDaoModelo();
    IDao<OrdenCompra> getDaoOrdenCompra();
    IDao<Proveedor> getDaoProveedor();
    IDao<Tipo> getDaoTipo();
    IDao<Trabajador> getDaoTrabajador();
    IDao<Turno> getDaoTurno();
}
