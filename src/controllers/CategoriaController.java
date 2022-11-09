/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.Action;
import daos.Option;
import forms.formCategoria;
import forms.formCategorias;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import model.Categoria;

/**
 *
 * @author kevin
 */
public class CategoriaController extends BaseController<Categoria> {

    public CategoriaController(JFrame rootView) {
        super(rootView, new formCategorias(), new formCategoria());
        this.LoadTable(1, 10);
    }

    @Override
    protected void LoadTable(int index, int count) {
        this.List = this.Dao.getDaoCategoria().Select(null, new Object[] {index, count}, Option.Range);
        this.SetTable(this.List);
    }

    @Override
    protected void SetTable(java.util.List<Categoria> source) {
        String[] columns = {"ID","Nombre","Estado", "", ""};
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columns);
        tableModel.setRowCount(0);
        Object[] row = new Object[tableModel.getColumnCount()];
        for(Categoria categoria: source) {
            row[0] = categoria.getId();
            row[1] = categoria.getNombre();
            row[2] = categoria.getEstado();
            row[3] = "Editar";
            row[4] = "Eliminar";
            tableModel.addRow(row);
        }
        this.MainView.setTable(tableModel, this);
    }

    @Override
    protected boolean Create(Categoria model) {
        return this.Dao.getDaoCategoria().Execute(model, Action.Create) != null;
    }

    @Override
    protected boolean Update(Categoria model) {
        return this.Dao.getDaoCategoria().Execute(model, Action.Update) != null;
    }

    @Override
    protected boolean Delete(Object id) {
        return this.Dao.getDaoCategoria().Execute(this.List.get((int)id), Action.Delete) != null;
    }
    
}
