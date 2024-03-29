/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.util.ArrayList;
import java.util.List;
import model.Marca;
import model.Modelo;
import model.Tipo;
import views.BaseSingleView;

/**
 *
 * @author kevin
 */
public class formModeloElemento extends BaseSingleView<Modelo> {

    private List<Tipo> TipoList = null;
    private List<Marca> MarcaList = null;
    
    /**
     * Creates new form formModeloElemento
     */
    public formModeloElemento() {
        initComponents();
        this.saveBtn = this.btnGuardar;
        this.cancelBtn = this.btnCancelar;
        this.setModel(this.model);
        this.TipoList = new ArrayList<>();
        this.MarcaList = new ArrayList<>();
    }
    
    public void loadTipo(List<Tipo> list) {
        this.TipoList = list;
        this.cbxTipo.removeAllItems();
        list.forEach((data) -> this.cbxTipo.addItem(data.getNombre()));
    }
    
    public void loadMarca(List<Marca> list) {
        this.MarcaList = list;
        this.cbxMarca.removeAllItems();
        list.forEach((data) -> this.cbxMarca.addItem(data.getNombre()));
    }
    
    /*public formModeloElemento(Modelo obj) {
        initComponents();
        int categoriaTipo = this.cargarListaTipo(obj.getTipo().getId());
        int categoriaMarca = this.cargarListaMarca(obj.getMarca().getId());
        
        this.id = obj.getId();
        this.tbxNombre.setText(obj.getNombre());
        this.chbxEstado.setSelected(obj.getEstado());
        this.cbxTipo.setSelectedIndex(categoriaTipo);
        this.cbxMarca.setSelectedIndex(categoriaMarca);
    }
    
    private int cargarListaTipo(int id) {
        this.TipoList = main.getDaoFactory().getDaoTipo().Select(null, Option.Light);
        this.cbxTipo.removeAllItems();
        int index = 0;
        int position = -1;
        for(Tipo tipo: this.TipoList) {
            this.cbxTipo.addItem(tipo.getNombre());
            if(id > 0 && id == tipo.getId())
                position = index;
            index++;
        }
        return position;
    }
    
    private int cargarListaMarca(int id) {
        this.cbxMarca.removeAllItems();
        this.MarcaList = main.getDaoFactory().getDaoMarca().Select(null, Option.Light);
        int index = 0;
        int position = -1;
        for(Marca marca: this.MarcaList) {
            this.cbxMarca.addItem(marca.getNombre());
            if(id > 0 && id == marca.getId())
                position = index;
            index++;
        }
        return position;
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        chbxEstado = new javax.swing.JCheckBox();
        tbxNombre = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox<>();
        cbxMarca = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Registrar Modelo de Elemento");

        jLabel2.setText("Nombre");

        jLabel3.setText("Estado");

        chbxEstado.setText("Activo");

        tbxNombre.setText("jTextField1");

        btnGuardar.setText("Guardar");

        btnCancelar.setText("Cancelar");

        jLabel4.setText("Tipo");

        jLabel5.setText("Marca");

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnGuardar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelar))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tbxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chbxEstado))))
                .addContainerGap(155, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tbxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(chbxEstado))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formModeloElemento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formModeloElemento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formModeloElemento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formModeloElemento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formModeloElemento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbxMarca;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JCheckBox chbxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField tbxNombre;
    // End of variables declaration//GEN-END:variables

    @Override
    public Modelo getModel() {
        if(this.model == null)
            this.model = new Modelo(0);
        this.model.setNombre(this.tbxNombre.getText());
        this.model.setTipo(this.TipoList.get(this.cbxTipo.getSelectedIndex()));
        this.model.setMarca(this.MarcaList.get(this.cbxMarca.getSelectedIndex()));
        this.model.setEstado(this.chbxEstado.isSelected());
        return this.model;
    }

    @Override
    public void setModel(Modelo model) {
        this.model = model;
        this.tbxNombre.setText(this.model != null ? this.model.getNombre() : "");
        this.cbxTipo.setSelectedItem(this.TipoList != null && this.model != null ? this.model.getTipo().getNombre() : "");
        this.cbxMarca.setSelectedItem(this.MarcaList != null && this.model != null ? this.model.getMarca().getNombre() : "");
        this.chbxEstado.setSelected(this.model != null ? this.model.getEstado(): false);
    }

    @Override
    public boolean checkView() {
        if(this.tbxNombre.getText().equals(""))
            this.addError("nombre", "El nombre es obligatorio.");
        if(this.cbxTipo.getSelectedItem().toString().equals(""))
            this.addError("tipo", "El tipo es obligatorio.");
        if(this.cbxMarca.getSelectedItem().toString().equals(""))
            this.addError("marca", "La marca es obligatoria.");
        return this.hasErrors();
    }

    @Override
    public boolean isNew() {
        return this.model == null || this.model.getId() == 0;
    }

}
