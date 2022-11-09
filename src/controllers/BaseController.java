/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import tools.PrintMessage;
import views.*;

/**
 *
 * @author kevin
 * @param <T>
 */
public abstract class BaseController<T> extends AbstractAction implements ActionListener {
    
    private JFrame RootView;
    
    protected IDaoFactory Dao = DaoFactory.getInstance(DB_Motor.SQLite);
    protected BaseMainView MainView;
    protected BaseSingleView SingleView;
    protected List<T> List = null;
    
    protected BaseController(JFrame rootView, BaseMainView mainView, BaseSingleView singleView) {
        
        this.RootView = rootView;
        this.MainView = mainView;
        this.SingleView = singleView;
        
        if(this.MainView.createBtn != null)
            this.MainView.createBtn.addActionListener(this);
        if(this.MainView.exitBtn != null)
            this.MainView.exitBtn.addActionListener(this);
        if(this.MainView.cleanBtn != null)
            this.MainView.cleanBtn.addActionListener(this);
        if(this.MainView.searchBtn != null)
            this.MainView.searchBtn.addActionListener(this);
        if(this.MainView.exportBtn != null)
            this.MainView.exportBtn.addActionListener(this);
        if(this.SingleView.saveBtn != null)
            this.SingleView.saveBtn.addActionListener(this);
        if(this.SingleView.cancelBtn != null)
            this.SingleView.cancelBtn.addActionListener(this);
        
        ((JFrame)this.MainView).setVisible(true);
        this.RootView.setVisible(false);
        
        this.List = new ArrayList<>();

    }
    
    /*protected abstract void OnClean();
    protected abstract void OnSearch();
    protected abstract void OnExport();*/
    
    private void OnSave() {
        if(this.SingleView.checkView()){
            if(this.SingleView.isNew()){
                if(this.Create((T)this.SingleView.getModel())){
                    PrintMessage.showInformationMessage("Registro", "Registro guardado.");
                }else
                    PrintMessage.showInformationMessage("Registro", "Registro no pudo ser guardado.");
            } else {
                if(this.Update((T)this.SingleView.getModel())){
                    PrintMessage.showInformationMessage("Registro", "Registro modificado.");
                }else
                    PrintMessage.showInformationMessage("Registro", "Registro no pudo ser modificado.");
            }
        }
    }
    
    private void OnDelete(int position){
        if (this.Delete(position)) {
            ((DefaultTableModel)this.MainView.getTable().getModel()).removeRow(position);
            this.List.remove(position);
            PrintMessage.showInformationMessage("Registro", "Registro eliminado.");
        } else {
            PrintMessage.showInformationMessage("Registro", "Registro no pudo ser eliminado.");
        }
    }
    
    
    protected abstract void LoadTable(int index, int count);
    protected abstract void SetTable(List<T> source);
    protected abstract boolean Create(T model);
    //protected abstract T Read(Object key);
    protected abstract boolean Update(T model);
    protected abstract boolean Delete(Object id);
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == this.MainView.exitBtn){
            ((JFrame)this.RootView).setVisible(true);
            ((JFrame)this.MainView).dispose();
            ((JFrame)this.SingleView).dispose();
        } else if(e.getSource() == this.MainView.createBtn){
            ((JFrame)this.SingleView).setVisible(true);
            ((JFrame)this.MainView).setVisible(false);
        } else if(e.getSource() == this.SingleView.cancelBtn){
            ((JFrame)this.SingleView).setVisible(false);
            this.SingleView.setModel(null);
            this.SingleView.cleanErrors();
            this.LoadTable(1, 10);
            ((JFrame)this.MainView).setVisible(true);
        } else if(e.getSource() == this.MainView.cleanBtn) {
            //this.OnClean();
        } else if(e.getSource() == this.MainView.searchBtn) {
            //this.OnSearch();
        } else if(e.getSource() == this.MainView.exportBtn) {
            //this.OnExport();
        } else if(e.getSource() == this.SingleView.saveBtn) {
            this.OnSave();
        } else if (e.getID() == 1) {
            int row = Integer.valueOf(e.getActionCommand());
            this.MainView.setVisible(false);
            this.SingleView.setModel(this.List.get(row));
            this.SingleView.setVisible(true);
        } else if (e.getID() == 2){
            int row = Integer.valueOf(e.getActionCommand());
            this.OnDelete(row);
        } else
            System.out.println("Opción " + e.getActionCommand() + " no implementada.");//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
