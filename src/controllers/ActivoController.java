/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.Action;
import daos.Option;
import forms.formActivo;
import forms.formActivos;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import model.Activo;

/**
 *
 * @author kevin
 */
public class ActivoController extends BaseController<Activo> {

    public ActivoController(JFrame rootView) {
        super(rootView, new formActivos(), new formActivo());
        this.LoadTable(1, 10);
    }

    @Override
    protected void LoadTable(int index, int count) {
        this.List = this.Dao.getDaoActivo().Select(null, new Object[] {index, count}, Option.Range);
        this.SetTable(this.List);
    }

    @Override
    protected void SetTable(java.util.List<Activo> source) {
        String[] columns = {"ID","Nombre","Estado", "", ""};
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columns);
        tableModel.setRowCount(0);
        Object[] row = new Object[tableModel.getColumnCount()];
        for(Activo activo: source) {
            row[0] = activo.getId();
            row[1] = activo.getCodigo();
            row[2] = activo.getModelo();
            row[3] = activo.getSerie();
            row[4] = activo.getEstado();
            row[5] = "Editar";
            row[6] = "Eliminar";
            tableModel.addRow(row);
        }
        this.MainView.setTable(tableModel, this);
    }

    @Override
    protected boolean Create(Activo model) {
        return this.Dao.getDaoActivo().Execute(model, Action.Create) != null;
    }

    @Override
    protected boolean Update(Activo model) {
        return this.Dao.getDaoActivo().Execute(model, Action.Update) != null;
    }

    @Override
    protected boolean Delete(Object id) {
        return this.Dao.getDaoActivo().Execute(this.List.get((int)id), Action.Delete) != null;
    }
    
}
