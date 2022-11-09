/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.*;
import daos.IDao;
import daos.IDaoFactory;

/**
 *
 * @author kevin
 */
public class DaoFactory implements IDaoFactory {

    private Connection Con = null;
    
    public DaoFactory(){
        String url = "jdbc:sqlite:sibod-db.sqlite3";
        try {
            this.Con = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private DaoActivo daoActivo;
    @Override
    public IDao<Activo> getDaoActivo(){
        if(this.daoActivo == null)
            this.daoActivo = new DaoActivo(this.Con);
        return this.daoActivo;
    }
    
    private DaoActivoNota daoActivoNota;
    @Override
    public IDao<ActivoNota> getDaoActivoNota(){
        if(this.daoActivoNota == null)
            this.daoActivoNota = new DaoActivoNota(this.Con);
        return this.daoActivoNota;
    }
    
    private DaoArea daoArea;
    @Override
    public IDao<Area> getDaoArea(){
        if(this.daoArea == null)
            this.daoArea = new DaoArea(this.Con);
        return this.daoArea;
    }
    
    private DaoCategoria daoCategoria;
    @Override
    public IDao<Categoria> getDaoCategoria(){
        if(this.daoCategoria == null)
            this.daoCategoria = new DaoCategoria(this.Con);
        return this.daoCategoria;
    }
    
    private DaoConsumible daoConsumible;
    @Override
    public IDao<Consumible> getDaoConsumible(){
        if(this.daoConsumible == null)
            this.daoConsumible = new DaoConsumible(this.Con);
        return this.daoConsumible;
    }
    
    private DaoEntrada daoEntrada;
    @Override
    public IDao<Entrada> getDaoEntrada(){
        if(this.daoEntrada == null)
            this.daoEntrada = new DaoEntrada(this.Con);
        return this.daoEntrada;
    }
    
    private DaoEntradaActivo daoEntradaActivo;
    @Override
    public IDao<EntradaActivo> getDaoEntradaActivo(){
        if(this.daoEntradaActivo == null)
            this.daoEntradaActivo = new DaoEntradaActivo(this.Con);
        return this.daoEntradaActivo;
    }
    
    private DaoEntradaConsumible daoEntradaConsumible;
    @Override
    public IDao<EntradaConsumible> getDaoEntradaConsumible(){
        if(this.daoEntradaConsumible == null)
            this.daoEntradaConsumible = new DaoEntradaConsumible(this.Con);
        return this.daoEntradaConsumible;
    }
    
    private DaoEntrega daoEntrega;
    @Override
    public IDao<Entrega> getDaoEntrega(){
        if(this.daoEntrega == null)
            this.daoEntrega = new DaoEntrega(this.Con);
        return this.daoEntrega;
    }
    
    private DaoEntregaActivo daoEntregaActivo;
    @Override
    public IDao<EntregaActivo> getDaoEntregaActivo(){
        if(this.daoEntregaActivo == null)
            this.daoEntregaActivo = new DaoEntregaActivo(this.Con);
        return this.daoEntregaActivo;
    }
    
    private DaoEntregaConsumible daoEntregaConsumible;
    @Override
    public IDao<EntregaConsumible> getDaoEntregaConsumible(){
        if(this.daoEntregaConsumible == null)
            this.daoEntregaConsumible = new DaoEntregaConsumible(this.Con);
        return this.daoEntregaConsumible;
    }
    
    private DaoMarca daoMarca;
    @Override
    public IDao<Marca> getDaoMarca(){
        if(this.daoMarca == null)
            this.daoMarca = new DaoMarca(this.Con);
        return this.daoMarca;
    }
    
    private DaoModelo daoModelo;
    @Override
    public IDao<Modelo> getDaoModelo(){
        if(this.daoModelo == null)
            this.daoModelo = new DaoModelo(this.Con);
        return this.daoModelo;
    }
    
    private DaoOrdenCompra daoOrdenCompra;
    @Override
    public IDao<OrdenCompra> getDaoOrdenCompra(){
        if(this.daoOrdenCompra == null)
            this.daoOrdenCompra = new DaoOrdenCompra(this.Con);
        return this.daoOrdenCompra;
    }
    
    private DaoProveedor daoProveedor;
    @Override
    public IDao<Proveedor> getDaoProveedor(){
        if(this.daoProveedor == null)
            this.daoProveedor = new DaoProveedor(this.Con);
        return this.daoProveedor;
    }
    
    private DaoTipo daoTipo;
    @Override
    public IDao<Tipo> getDaoTipo(){
        if(this.daoTipo == null)
            this.daoTipo = new DaoTipo(this.Con);
        return this.daoTipo;
    }
    
    private DaoTrabajador daoTrabajador;
    @Override
    public IDao<Trabajador> getDaoTrabajador(){
        if(this.daoTrabajador == null)
            this.daoTrabajador = new DaoTrabajador(this.Con);
        return this.daoTrabajador;
    }

    private DaoTurno daoTurno;
    @Override
    public IDao<Turno> getDaoTurno(){
        if(this.daoTurno == null)
            this.daoTurno = new DaoTurno(this.Con);
        return this.daoTurno;
    }
    
}
