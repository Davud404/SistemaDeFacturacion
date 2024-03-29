/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import model.Empresa;

/**
 *
 * @author Usuario
 */
public class PanelEmpresa extends javax.swing.JPanel {

    /**
     * Creates new form PanelEmpresa
     */
    public PanelEmpresa() {
        initComponents();
        Empresa empresa=new Empresa();
        empresa.mostrar("1000554545");
        txtNombreEmpresa.setText(empresa.getNombre());
        txtRucEmpresa.setText(empresa.getRuc());
        txtIva.setText(String.valueOf(empresa.getPorcentajeIVA()));
        txtMargenUtilidad.setText(String.valueOf(empresa.getUtilidad()));
        txtTefefonoEmpresa.setText(empresa.getTelefono());
        txtCorreoEmpresa.setText(empresa.getCorreo());
        txtDireccion.setText(empresa.getDireccionEmpresa());
        
        

        
    }

    public PanelEmpresa(JTextField txtCorreoEmpresa, JTextField txtDireccionEmpresa, JTextField txtIva, JTextField txtMargenUtilidad, JLabel txtNombreEmpresa, JTextField txtRucEmpresa, JTextField txtTefefonoEmpresa) {
        this.txtCorreoEmpresa = txtCorreoEmpresa;
        this.txtDireccion = txtDireccionEmpresa;
        this.txtIva = txtIva;
        this.txtMargenUtilidad = txtMargenUtilidad;
        this.txtNombreEmpresa = txtNombreEmpresa;
        this.txtRucEmpresa = txtRucEmpresa;
        this.txtTefefonoEmpresa = txtTefefonoEmpresa;
    }
    

    public PanelEmpresa(JButton jButton2, JLabel jLabel1, JLabel jLabel2, JLabel jLabel3, JLabel jLabel4, JLabel jLabel5, JLabel jLabel6, JLabel jLabel7, JPanel jPanel1, JPanel jPanel2, JPanel jPanel3, JRadioButton jRadioButton1, PanImagen panImagen2, JTextField txtCorreoEmpresa, JTextField txtDireccion, JTextField txtIva, JTextField txtMargenUtilidad, JLabel txtNombreEmpresa, JTextField txtRucEmpresa, JTextField txtTefefonoEmpresa) {
        this.jButton2 = jButton2;
        this.jLabel1 = jLabel1;
        this.jLabel2 = jLabel2;
        this.jLabel3 = jLabel3;
        this.jLabel4 = jLabel4;
        this.jLabel5 = jLabel5;
        this.jLabel6 = jLabel6;
        this.jLabel7 = jLabel7;
        this.jPanel1 = jPanel1;
        this.jPanel2 = jPanel2;
        this.jPanel3 = jPanel3;
        this.jRadioButton1 = jRadioButton1;
        this.panImagen2 = panImagen2;
        this.txtCorreoEmpresa = txtCorreoEmpresa;
        this.txtDireccion = txtDireccion;
        this.txtIva = txtIva;
        this.txtMargenUtilidad = txtMargenUtilidad;
        this.txtNombreEmpresa = txtNombreEmpresa;
        this.txtRucEmpresa = txtRucEmpresa;
        this.txtTefefonoEmpresa = txtTefefonoEmpresa;
    }
    


    

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panImagen2 = new gui.PanImagen();
        jPanel3 = new javax.swing.JPanel();
        txtNombreEmpresa = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtRucEmpresa = new javax.swing.JTextField();
        txtTefefonoEmpresa = new javax.swing.JTextField();
        txtCorreoEmpresa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtMargenUtilidad = new javax.swing.JTextField();
        txtIva = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(720, 600));

        jPanel1.setBackground(new java.awt.Color(3, 48, 90));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 2, 24)); // NOI18N
        jLabel2.setText("Empresa");

        panImagen2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Downloads\\icono empresa(1).png")); // NOI18N

        javax.swing.GroupLayout panImagen2Layout = new javax.swing.GroupLayout(panImagen2);
        panImagen2.setLayout(panImagen2Layout);
        panImagen2Layout.setHorizontalGroup(
            panImagen2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panImagen2Layout.setVerticalGroup(
            panImagen2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panImagen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(panImagen2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        txtNombreEmpresa.setFont(new java.awt.Font("Segoe UI", 2, 36)); // NOI18N
        txtNombreEmpresa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNombreEmpresa.setText("NombreEmpresa");

        jLabel3.setText("Ruc:");

        jLabel4.setText("Telefono:");

        jLabel5.setText("Direccion:");

        jLabel6.setText("Correo:");

        jLabel7.setText("IVA: ");

        txtRucEmpresa.setEnabled(false);
        txtRucEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRucEmpresaActionPerformed(evt);
            }
        });

        txtTefefonoEmpresa.setEnabled(false);

        txtCorreoEmpresa.setEnabled(false);

        jLabel1.setText("Margen Utilidad:");

        txtMargenUtilidad.setEnabled(false);
        txtMargenUtilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMargenUtilidadActionPerformed(evt);
            }
        });

        txtIva.setEnabled(false);

        txtDireccion.setEnabled(false);
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        jRadioButton1.setText("Editar Datos");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRucEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(txtTefefonoEmpresa)
                            .addComponent(txtCorreoEmpresa)
                            .addComponent(txtIva, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMargenUtilidad, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDireccion))
                        .addGap(56, 56, 56)
                        .addComponent(jRadioButton1)
                        .addGap(110, 110, 110))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRucEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTefefonoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtCorreoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMargenUtilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jButton2.setText("ActualizarDatos");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(265, 265, 265))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    Empresa empresa = new Empresa();
    
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        empresa.setRuc(txtRucEmpresa.getText());
        empresa.setNombre(txtNombreEmpresa.getText());
        empresa.setPorcentajeIVA(Integer.parseInt(txtIva.getText()));
        empresa.setUtilidad(Integer.parseInt(txtMargenUtilidad.getText()));
        empresa.setTelefono(txtTefefonoEmpresa.getText());
        empresa.setCorreo(txtCorreoEmpresa.getText());
        empresa.setDireccionEmpresa(txtDireccion.getText());
        
        empresa.modificar(empresa.getNombre(), empresa.getRuc(), empresa.getPorcentajeIVA(), empresa.getUtilidad(), empresa.getTelefono(), empresa.getCorreo(), empresa.getDireccionEmpresa());
        
    }//GEN-LAST:event_jButton2MouseClicked

    private void txtMargenUtilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMargenUtilidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMargenUtilidadActionPerformed

    private void txtRucEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRucEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRucEmpresaActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        // TODO add your handling code here:
         txtCorreoEmpresa.setEnabled(true);
        txtMargenUtilidad.setEnabled(true);
        txtNombreEmpresa.setEnabled(true);
        txtRucEmpresa.setEnabled(true);
        txtTefefonoEmpresa.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtIva.setEnabled(true);
    }//GEN-LAST:event_jRadioButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private gui.PanImagen panImagen2;
    private javax.swing.JTextField txtCorreoEmpresa;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtMargenUtilidad;
    private javax.swing.JLabel txtNombreEmpresa;
    private javax.swing.JTextField txtRucEmpresa;
    private javax.swing.JTextField txtTefefonoEmpresa;
    // End of variables declaration//GEN-END:variables
}
