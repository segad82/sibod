/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.Action;
import daos.Option;
import forms.formArea;
import forms.formAreas;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import model.Area;

/**
 *
 * @author kevin
 */
public class AreaController extends BaseController<Area> {
    
    public AreaController(JFrame rootView) {
        super(rootView, new formAreas(), new formArea());
        this.LoadTable(1, 10);
    }

    /*@Override
    protected void OnSave() {
        if(this.SingleView.checkView()){
            Area data = (Area)this.SingleView.getModel();
            if(data.getId() == 0){
                if(this.Create(data)){
                    PrintMessage.showInformationMessage("Registro", "Registro guardado.");
                }else
                    PrintMessage.showInformationMessage("Registro", "Registro no pudo ser guardado.");
            } else {
                if(this.Update(data)){
                    PrintMessage.showInformationMessage("Registro", "Registro modificado.");
                }else
                    PrintMessage.showInformationMessage("Registro", "Registro no pudo ser modificado.");
            }
        }*/
        /*
        Area data = new Area(this.id, tbxNombre.getText(), chbxEstado.isSelected());
        if(this.id == 0){
            if(main.getDaoFactory().getDaoArea().Execute(data, Action.Create) != null){
                PrintMessage.showInformationMessage("Registro", "Registro guardado");
                new formAreas().setVisible(true);
                this.dispose();
            } else {
                PrintMessage.showErrorMessage("Registro", "Registro no guardado");
            }
        } else {
            if(main.getDaoFactory().getDaoArea().Execute(data, Action.Update) != null){
                PrintMessage.showInformationMessage("Registro", "Registro modificado");
                new formAreas().setVisible(true);
                this.dispose();
            } else {
                PrintMessage.showErrorMessage("Registro", "Registro no modificado");
            }
        }
        
    }*/

    /*@Override
    protected void OnDelete(int position) {
        if (this.Delete(position)) {
            ((DefaultTableModel)this.MainView.getTable().getModel()).removeRow(position);
            this.List.remove(position);
            PrintMessage.showInformationMessage("Registro", "Registro eliminado.");
        } else {
            PrintMessage.showInformationMessage("Registro", "Registro no pudo ser eliminado.");
        }
    }*/
    
    @Override
    protected void LoadTable(int index, int count) {
        this.List = this.Dao.getDaoArea().Select(null, new Object[] {index, count}, Option.Range);
        this.SetTable(this.List);
    }
    
    @Override
    protected void SetTable(List<Area> source){
        String[] columns = {"ID","Nombre","Estado", "", ""};
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columns);
        tableModel.setRowCount(0);
        Object[] row = new Object[tableModel.getColumnCount()];
        for(Area area: source) {
            row[0] = area.getId();
            row[1] = area.getNombre();
            row[2] = area.getEstado();
            row[3] = "Editar";
            row[4] = "Eliminar";
            tableModel.addRow(row);
        }
        this.MainView.setTable(tableModel, this);
        //this.MainView.getTable().setModel(tableModel);
    }

    @Override
    protected boolean Create(Area model) {
        return this.Dao.getDaoArea().Execute(model, Action.Create) != null;
    }

    @Override
    protected boolean Update(Area model) {
        return this.Dao.getDaoArea().Execute(model, Action.Update) != null;
    }

    @Override
    protected boolean Delete(Object id) {
        return this.Dao.getDaoArea().Execute(this.List.get((int)id), daos.Action.Delete) != null;
    }

}
