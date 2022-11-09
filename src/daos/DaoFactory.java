/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

/**
 *
 * @author kevin
 */
public class DaoFactory {
    
    private static final IDaoFactory SQLite_INSTANCE = new daos.sqlite.DaoFactory();
    
    private DaoFactory(){}
    
    public static IDaoFactory getInstance(DB_Motor motor){
        switch(motor){
            case SQLite: return SQLite_INSTANCE;
            default: throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}