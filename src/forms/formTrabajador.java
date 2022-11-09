/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.util.ArrayList;
import java.util.List;
import model.Area;
import model.Trabajador;
import model.Turno;
import views.BaseSingleView;

/**
 *
 * @author kevin
 */
public class formTrabajador extends BaseSingleView<Trabajador> {

    private List<Area> AreaList = null;
    private List<Turno> TurnoList = null;
    
    /**
     * Creates new form formTrabajador
     */
    public formTrabajador() {
        initComponents();
        this.saveBtn = this.btnGuardar;
        this.cancelBtn = this.btnCancelar;
        this.setModel(this.model);
        this.AreaList = new ArrayList<>();
        this.TurnoList = new ArrayList<>();
        this.loadCamisa();
        this.loadPantalon();
        this.loadCalzado();
    }
    
    public void loadArea(List<Area> list) {
        this.AreaList = list;
        this.cbxArea.removeAllItems();
        list.forEach((data) -> this.cbxArea.addItem(data.getNombre()));
    }
    
    public void loadTurno(List<Turno> list) {
        this.TurnoList = list;
        this.cbxTurno.removeAllItems();
        list.forEach((data) -> this.cbxTurno.addItem(data.getNombre()));
    }
    
    private void loadCamisa(){
        this.cbxCamisa.removeAllItems();
        this.cbxCamisa.addItem("XS");
        this.cbxCamisa.addItem("S");
        this.cbxCamisa.addItem("M");
        this.cbxCamisa.addItem("L");
        this.cbxCamisa.addItem("XL");
        this.cbxCamisa.addItem("XXL");
    }
    
    private void loadPantalon(){
        this.cbxPantalon.removeAllItems();
        this.cbxPantalon.addItem("XS");
        this.cbxPantalon.addItem("S");
        this.cbxPantalon.addItem("M");
        this.cbxPantalon.addItem("L");
        this.cbxPantalon.addItem("XL");
        this.cbxPantalon.addItem("XXL");
    }
    
    private void loadCalzado(){
        this.cbxCalzado.removeAllItems();
        this.cbxCalzado.addItem("35");
        this.cbxCalzado.addItem("36");
        this.cbxCalzado.addItem("37");
        this.cbxCalzado.addItem("38");
        this.cbxCalzado.addItem("39");
        this.cbxCalzado.addItem("40");
        this.cbxCalzado.addItem("41");
        this.cbxCalzado.addItem("42");
        this.cbxCalzado.addItem("43");
        this.cbxCalzado.addItem("44");
        this.cbxCalzado.addItem("45");
        this.cbxCalzado.addItem("46");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        chbxEstado = new javax.swing.JCheckBox();
        tbxRut = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxArea = new javax.swing.JComboBox<>();
        cbxTurno = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tbxNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxCamisa = new javax.swing.JComboBox<>();
        cbxPantalon = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbxCalzado = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        tbxFecha = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Estado");

        chbxEstado.setText("Activo");

        tbxRut.setText("jTextField1");

        btnGuardar.setText("Guardar");

        btnCancelar.setText("Cancelar");

        jLabel4.setText("Área");

        jLabel5.setText("Turno");

        cbxArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Registrar Trabajador");

        jLabel2.setText("RUT");

        tbxNombre.setText("jTextField1");

        jLabel6.setText("Nombre");

        jLabel7.setText("Fecha de Nacimiento");

        jLabel8.setText("Camisa");

        cbxCamisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxPantalon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Pantalón");

        cbxCalzado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("Calzado");

        tbxFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/M/yyyy"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(chbxEstado))
                            .addComponent(jLabel7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tbxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tbxRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnGuardar))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbxPantalon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbxCamisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxCalzado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnCancelar)
                                    .addComponent(tbxFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel1))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tbxRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tbxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbxArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(cbxCamisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(cbxPantalon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxCalzado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(chbxEstado))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tbxFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addContainerGap(86, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(formTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formTrabajador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbxArea;
    private javax.swing.JComboBox<String> cbxCalzado;
    private javax.swing.JComboBox<String> cbxCamisa;
    private javax.swing.JComboBox<String> cbxPantalon;
    private javax.swing.JComboBox<String> cbxTurno;
    private javax.swing.JCheckBox chbxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JFormattedTextField tbxFecha;
    private javax.swing.JTextField tbxNombre;
    private javax.swing.JTextField tbxRut;
    // End of variables declaration//GEN-END:variables

    @Override
    public Trabajador getModel() {
        if(this.model == null)
            this.model = new Trabajador("");
        this.model.setRut(this.tbxRut.getText());
        this.model.setNombre(this.tbxNombre.getText());
        this.model.setArea(this.AreaList.get(this.cbxArea.getSelectedIndex()));
        this.model.setTurno(this.TurnoList.get(this.cbxTurno.getSelectedIndex()));
        this.model.setFecha_nacimiento(this.tbxFecha.getText());
        this.model.setEstado(this.chbxEstado.isSelected());
        this.model.setTalla_camisa(this.cbxCamisa.getSelectedItem().toString());
        this.model.setTalla_pantalon(this.cbxPantalon.getSelectedItem().toString());
        this.model.setTalla_calzado(this.cbxCalzado.getSelectedItem().toString());
        return this.model;
    }

    @Override
    public void setModel(Trabajador model) {
        this.model = model;
        if(this.model != null)
            this.model.setOld_rut(this.model.getRut());
        this.tbxRut.setText(this.model != null ? this.model.getRut(): "");
        this.tbxNombre.setText(this.model != null ? this.model.getNombre() : "");
        this.cbxArea.setSelectedItem(this.AreaList != null && this.model != null ? this.model.getArea().getNombre() : "");
        this.cbxTurno.setSelectedItem(this.TurnoList != null && this.model != null ? this.model.getTurno().getNombre() : "");
        this.tbxFecha.setText(this.model != null ? this.model.getFecha_nacimiento(): "");
        this.chbxEstado.setSelected(this.model != null ? this.model.getEstado(): false);
        this.cbxCamisa.setSelectedItem(this.model != null ? this.model.getTalla_camisa(): "");
        this.cbxPantalon.setSelectedItem(this.model != null ? this.model.getTalla_pantalon(): "");
        this.cbxCalzado.setSelectedItem(this.model != null ? this.model.getTalla_calzado(): "");
    }

    @Override
    public boolean checkView() {
        if(this.tbxNombre.getText().equals(""))
            this.addError("nombre", "El nombre es obligatorio.");
        if(this.cbxArea.getSelectedItem().toString().equals(""))
            this.addError("area", "El área es obligatorio.");
        if(this.cbxTurno.getSelectedItem().toString().equals(""))
            this.addError("turno", "El turno es obligatorio.");
        return this.hasErrors();
    }

    @Override
    public boolean isNew() {
        return this.model == null || this.model.getOld_rut().equals("");
    }
    
}