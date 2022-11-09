/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.HashMap;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import tools.PrintMessage;

/**
 *
 * @author kevin
 * @param <T>
 */
public abstract class BaseSingleView<T> extends JFrame {
    
    protected T model;
    private HashMap<String, ArrayList<String>> errors;
    
    public JButton saveBtn;
    public JButton cancelBtn;
    
    public BaseSingleView() {
        this.errors = new HashMap<>();
        this.model = null;
    }
    
    public abstract T getModel();
    public abstract void setModel(T model);
    public abstract boolean checkView();
    public abstract boolean isNew();
    
    protected void addError(String key, String error) {
        if(!this.errors.containsKey(key))
            this.errors.put(key, new ArrayList<>());
        this.errors.get(key).add(error);
            
        /*if(this.errors.containsKey(key))
            this.errors.get(key).add(error);
        else {
            this.errors.put(key, new ArrayList<>());
            this.errors.get(key).add(error);
        }*/
    }
    
    public void cleanErrors() {
        this.errors = new HashMap<>();
    }
    
    protected boolean hasErrors() {
        if(this.errors.size() > 0){
            this.printErrors();
            return false;
        } else {
            return true;
        }
    }
    
    protected void printErrors(){
        String message = "Por favor considerar que:";
        for(String key: this.errors.keySet()){
            for(String value: this.errors.get(key)){
                message += "\n    * " + value;
            }
        }
        PrintMessage.showAlertMessage("Validación", message);
        this.errors.clear();
    }
    
}
