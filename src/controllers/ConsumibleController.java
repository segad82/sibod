/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.Action;
import daos.Option;
import forms.formConsumible;
import forms.formConsumibles;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import model.Consumible;

/**
 *
 * @author kevin
 */
public class ConsumibleController extends BaseController<Consumible> {

    public ConsumibleController(JFrame rootView) {
        super(rootView, new formConsumibles(), new formConsumible());
        this.LoadTable(1, 10);
        ((formConsumible)this.SingleView).loadModelo(this.Dao.getDaoModelo().Select(null, null, Option.All));
    }

    @Override
    protected void LoadTable(int index, int count) {
        this.List = this.Dao.getDaoConsumible().Select(null, new Object[] {index, count}, Option.Range);
        this.SetTable(this.List);
    }

    @Override
    protected void SetTable(java.util.List<Consumible> source) {
        String[] columns = {"ID","Modelo","Estado", "Cantidad Actual", "Cantidad Mínima", "", ""};
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columns);
        tableModel.setRowCount(0);
        Object[] row = new Object[tableModel.getColumnCount()];
        for(Consumible consumible: source) {
            row[0] = consumible.getId();
            row[1] = consumible.getModelo().getNombre();
            row[2] = consumible.getEstado();
            row[3] = consumible.getCantidad();
            row[4] = consumible.getCantidad_minima();
            row[5] = "Editar";
            row[6] = "Eliminar";
            tableModel.addRow(row);
        }
        this.MainView.setTable(tableModel, this);
    }

    @Override
    protected boolean Create(Consumible model) {
        return this.Dao.getDaoConsumible().Execute(model, Action.Create) != null;
    }

    @Override
    protected boolean Update(Consumible model) {
        return this.Dao.getDaoConsumible().Execute(model, Action.Update) != null;
    }

    @Override
    protected boolean Delete(Object id) {
        return this.Dao.getDaoConsumible().Execute(this.List.get((int)id), Action.Delete) != null;
    }
    
}
