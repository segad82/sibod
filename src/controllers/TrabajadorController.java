/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.Action;
import daos.Option;
import forms.formTrabajador;
import forms.formTrabajadores;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import model.Trabajador;

/**
 *
 * @author kevin
 */
public class TrabajadorController extends BaseController<Trabajador> {

    public TrabajadorController(JFrame rootView) {
        super(rootView, new formTrabajadores(), new formTrabajador());
        this.LoadTable(1, 10);
        ((formTrabajador)this.SingleView).loadArea(this.Dao.getDaoArea().Select(null, null, Option.Light));
        ((formTrabajador)this.SingleView).loadTurno(this.Dao.getDaoTurno().Select(null, null, Option.Light));
    }

    @Override
    protected void LoadTable(int index, int count) {
        this.List = this.Dao.getDaoTrabajador().Select(null, new Object[] {index, count}, Option.Range);
        this.SetTable(this.List);
    }

    @Override
    protected void SetTable(java.util.List<Trabajador> source) {
        String[] columns = {"Rut","Nombre", "Área", "Turno", "Estado", "", ""};
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columns);
        tableModel.setRowCount(0);
        Object[] row = new Object[tableModel.getColumnCount()];
        for(Trabajador trabajador: source) {
            row[0] = trabajador.getRut();
            row[1] = trabajador.getNombre();
            row[2] = trabajador.getArea().getNombre();
            row[3] = trabajador.getTurno().getNombre();
            row[4] = trabajador.getEstado();
            row[5] = "Editar";
            row[6] = "Eliminar";
            tableModel.addRow(row);
        }
        this.MainView.setTable(tableModel, this);
    }

    @Override
    protected boolean Create(Trabajador model) {
        return this.Dao.getDaoTrabajador().Execute(model, Action.Create) != null;
    }

    @Override
    protected boolean Update(Trabajador model) {
        return this.Dao.getDaoTrabajador().Execute(model, Action.Update) != null;
    }

    @Override
    protected boolean Delete(Object id) {
        return this.Dao.getDaoTrabajador().Execute(this.List.get((int)id), Action.Delete) != null;
    }
    
}
