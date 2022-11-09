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
public abstract class BaseModel {
    
    public BaseModel(){
        this.ref = 0;
    }
    
    private int ref;

    /**
     * @return the ref
     */
    public int getRef() {
        return ref;
    }

    /**
     * @param ref the ref to set
     */
    public void setRef(int ref) {
        this.ref = ref;
    }
    
}
