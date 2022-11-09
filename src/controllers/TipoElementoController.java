/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.Action;
import daos.Option;
import forms.formTipoElemento;
import forms.formTiposElementos;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import model.Tipo;

/**
 *
 * @author kevin
 */
public class TipoElementoController extends BaseController<Tipo> {

    public TipoElementoController(JFrame rootView) {
        super(rootView, new formTiposElementos(), new formTipoElemento());
        this.LoadTable(1, 10);
        ((formTipoElemento)this.SingleView).loadCategoria(this.Dao.getDaoCategoria().Select(null, null, Option.All));
    }
    
    @Override
    protected void LoadTable(int index, int count) {
        this.List = this.Dao.getDaoTipo().Select(null, new Object[] {index, count}, Option.Range);
        this.SetTable(this.List);
    }

    @Override
    protected void SetTable(java.util.List<Tipo> source) {
        String[] columns = {"ID","Nombre","Estado", "Categoría", "Clase", "", ""};
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columns);
        tableModel.setRowCount(0);
        Object[] row = new Object[tableModel.getColumnCount()];
        for(Tipo tipo: source) {
            row[0] = tipo.getId();
            row[1] = tipo.getNombre();
            row[2] = tipo.getEstado();
            row[3] = tipo.getCategoria().getNombre();
            row[4] = tipo.getClase() ? "Consumible" : "Activo";
            row[5] = "Editar";
            row[6] = "Eliminar";
            tableModel.addRow(row);
        }
        this.MainView.setTable(tableModel, this);
    }

    @Override
    protected boolean Create(Tipo model) {
        return this.Dao.getDaoTipo().Execute(model, Action.Create) != null;
    }

    @Override
    protected boolean Update(Tipo model) {
        return this.Dao.getDaoTipo().Execute(model, Action.Update) != null;
    }

    @Override
    protected boolean Delete(Object id) {
        return this.Dao.getDaoTipo().Execute(this.List.get((int)id), Action.Delete) != null;
    }
    
}
