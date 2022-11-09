/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos.sqlite;

import daos.Action;
import daos.IDao;
import daos.Option;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public abstract class BaseDao<T> implements IDao<T> {
    
    protected Connection DB = null;
    
    public BaseDao(Connection db) {
        this.DB = db;
    }
    
    @Override
    public ArrayList<T> Select(T data, Object[] parameters, Option option) {
        switch(option){
            case All: return this.selectAll();
            case Light: return this.selectLight();
            case Range: return this.selectRange((int)parameters[0], (int)parameters[1]);
            default: throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
    @Override
    public T Execute(T data, Action action) {
        switch(action){
            case Create: return this.create(data);
            case Read: return this.read(data);
            case Update: return this.update(data);
            case Delete: return this.delete(data);
            default: throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
    protected abstract ArrayList<T> selectAll();
    protected abstract ArrayList<T> selectLight();
    protected abstract ArrayList<T> selectRange(int index, int count);
    protected abstract T create(T obj);
    protected abstract T read(T obj);
    protected abstract T update(T obj);
    protected abstract T delete(T obj);
    
}
