/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.Action;
import daos.Option;
import forms.formProveedor;
import forms.formProveedores;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import model.Proveedor;

/**
 *
 * @author kevin
 */
public class ProveedorController extends BaseController<Proveedor> {

    public ProveedorController(JFrame rootView) {
        super(rootView, new formProveedores(), new formProveedor());
        this.LoadTable(1, 10);
    }

    @Override
    protected void LoadTable(int index, int count) {
        this.List = this.Dao.getDaoProveedor().Select(null, new Object[] {index, count}, Option.Range);
        this.SetTable(this.List);
    }

    @Override
    protected void SetTable(java.util.List<Proveedor> source) {
        String[] columns = {"ID","Nombre","Correo","Teléfono","Estado", "", ""};
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columns);
        tableModel.setRowCount(0);
        Object[] row = new Object[tableModel.getColumnCount()];
        for(Proveedor proveedor: source) {
            row[0] = proveedor.getId();
            row[1] = proveedor.getNombre();
            row[2] = proveedor.getCorreo();
            row[3] = proveedor.getTelefono();
            row[4] = proveedor.getEstado();
            row[5] = "Editar";
            row[6] = "Eliminar";
            tableModel.addRow(row);
        }
        this.MainView.setTable(tableModel, this);
    }

    @Override
    protected boolean Create(Proveedor model) {
        return this.Dao.getDaoProveedor().Execute(model, Action.Create) != null;
    }

    @Override
    protected boolean Update(Proveedor model) {
        return this.Dao.getDaoProveedor().Execute(model, Action.Update) != null;
    }

    @Override
    protected boolean Delete(Object id) {
        return this.Dao.getDaoProveedor().Execute(this.List.get((int)id), Action.Delete) != null;
    }
    
}
