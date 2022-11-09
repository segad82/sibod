/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import tools.ButtonColumn;

/**
 *
 * @author kevin
 */
public abstract class BaseMainView extends JFrame {
    
    private ButtonColumn editTableButton;
    private ButtonColumn deleteTableButton;
    
    protected HashMap<String, Object> filters;
    
    public JButton createBtn = null;
    public JButton cleanBtn = null;
    public JButton searchBtn = null;
    public JButton exportBtn = null;
    public JButton exitBtn = null;
    protected JTable table = null;
    
    public BaseMainView() {
        this.filters = new HashMap<>();
    }
    
    /**
     *
     * @return
     */
    public HashMap<String, Object> getFilters(){
        return this.filters;
    }
    
    public JTable getTable() {
        return this.table;
    }
    
    public void setTable(DefaultTableModel dataModel, ActionListener action) {
        
        this.table.setModel(dataModel);
        
        Action edit = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.actionPerformed(new ActionEvent(e.getSource(), 1, e.getActionCommand()));
            }
        };
        this.editTableButton = new ButtonColumn(this.table, edit, dataModel.getColumnCount() -2);
        this.editTableButton.setMnemonic(KeyEvent.VK_D);
        
        Action delete = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.actionPerformed(new ActionEvent(e.getSource(), 2, e.getActionCommand()));
            }
        };
        this.deleteTableButton = new ButtonColumn(this.table, delete, dataModel.getColumnCount() -1);
        this.deleteTableButton.setMnemonic(KeyEvent.VK_D);

    }
    
}
