/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.Action;
import daos.Option;
import forms.formModeloElemento;
import forms.formModelosElementos;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import model.Modelo;

/**
 *
 * @author kevin
 */
public class ModeloElementoController extends BaseController<Modelo> {

    public ModeloElementoController(JFrame rootView) {
        super(rootView, new formModelosElementos(), new formModeloElemento());
        this.LoadTable(1, 10);
        ((formModeloElemento)this.SingleView).loadTipo(this.Dao.getDaoTipo().Select(null, null, Option.All));
        ((formModeloElemento)this.SingleView).loadMarca(this.Dao.getDaoMarca().Select(null, null, Option.All));
    }

    @Override
    protected void LoadTable(int index, int count) {
        this.List = this.Dao.getDaoModelo().Select(null, new Object[] {index, count}, Option.Range);
        this.SetTable(this.List);
    }

    @Override
    protected void SetTable(java.util.List<Modelo> source) {
        String[] columns = {"ID","Nombre","Estado", "Tipo", "Marca", "", ""};
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columns);
        tableModel.setRowCount(0);
        Object[] row = new Object[tableModel.getColumnCount()];
        for(Modelo modelo: source) {
            row[0] = modelo.getId();
            row[1] = modelo.getNombre();
            row[2] = modelo.getEstado();
            row[3] = modelo.getTipo().getNombre();
            row[4] = modelo.getMarca().getNombre();
            row[5] = "Editar";
            row[6] = "Eliminar";
            tableModel.addRow(row);
        }
        this.MainView.setTable(tableModel, this);
    }

    @Override
    protected boolean Create(Modelo model) {
        return this.Dao.getDaoModelo().Execute(model, Action.Create) != null;
    }

    @Override
    protected boolean Update(Modelo model) {
        return this.Dao.getDaoModelo().Execute(model, Action.Update) != null;
    }

    @Override
    protected boolean Delete(Object id) {
        return this.Dao.getDaoModelo().Execute(this.List.get((int)id), Action.Delete) != null;
    }
    
}