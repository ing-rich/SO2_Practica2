/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema1;

import javax.swing.JLabel;

/**
 *
 * @author linkh
 */
public class problema1GUI extends javax.swing.JFrame {

    /**
     * Creates new form problema1GUI
     */
    Controladora c;
    public problema1GUI() {
        initComponents();
        this.terminarBoton.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Filosofo1 = new javax.swing.JLabel();
        Filosofo2 = new javax.swing.JLabel();
        Filosofo3 = new javax.swing.JLabel();
        Filosofo4 = new javax.swing.JLabel();
        Filosofo5 = new javax.swing.JLabel();
        tenedor1 = new javax.swing.JLabel();
        tenedor2 = new javax.swing.JLabel();
        tenedor3 = new javax.swing.JLabel();
        tenedor4 = new javax.swing.JLabel();
        tenedor5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        iniciarBoton = new javax.swing.JButton();
        terminarBoton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Filosofo1.setBackground(new java.awt.Color(0, 0, 255));
        Filosofo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Filosofo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/socrates.png"))); // NOI18N
        Filosofo1.setText("FILOSOFO 1");
        Filosofo1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Filosofo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Filosofo1.setOpaque(true);
        Filosofo1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        Filosofo2.setBackground(new java.awt.Color(0, 0, 255));
        Filosofo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Filosofo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/socrates.png"))); // NOI18N
        Filosofo2.setText("FILOSOFO 2");
        Filosofo2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Filosofo2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Filosofo2.setOpaque(true);
        Filosofo2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        Filosofo3.setBackground(new java.awt.Color(0, 0, 255));
        Filosofo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Filosofo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/socrates.png"))); // NOI18N
        Filosofo3.setText("FILOSOFO 3");
        Filosofo3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Filosofo3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Filosofo3.setOpaque(true);
        Filosofo3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        Filosofo4.setBackground(new java.awt.Color(0, 0, 255));
        Filosofo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Filosofo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/socrates.png"))); // NOI18N
        Filosofo4.setText("FILOSOFO 4");
        Filosofo4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Filosofo4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Filosofo4.setOpaque(true);
        Filosofo4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        Filosofo5.setBackground(new java.awt.Color(0, 0, 255));
        Filosofo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Filosofo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/socrates.png"))); // NOI18N
        Filosofo5.setText("FILOSOFO 5");
        Filosofo5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Filosofo5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Filosofo5.setOpaque(true);
        Filosofo5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        tenedor1.setBackground(new java.awt.Color(0, 204, 0));
        tenedor1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tenedor.png"))); // NOI18N
        tenedor1.setText("TENEDOR 1");
        tenedor1.setOpaque(true);

        tenedor2.setBackground(new java.awt.Color(0, 204, 0));
        tenedor2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tenedor.png"))); // NOI18N
        tenedor2.setText("TENEDOR 2");
        tenedor2.setOpaque(true);

        tenedor3.setBackground(new java.awt.Color(0, 204, 0));
        tenedor3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tenedor.png"))); // NOI18N
        tenedor3.setText("TENEDOR 1");
        tenedor3.setOpaque(true);

        tenedor4.setBackground(new java.awt.Color(0, 204, 0));
        tenedor4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tenedor.png"))); // NOI18N
        tenedor4.setText("TENEDOR 1");
        tenedor4.setOpaque(true);

        tenedor5.setBackground(new java.awt.Color(0, 204, 0));
        tenedor5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tenedor.png"))); // NOI18N
        tenedor5.setText("TENEDOR 1");
        tenedor5.setOpaque(true);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mesa.png"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("TENEDORES");

        jLabel3.setBackground(new java.awt.Color(51, 204, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Libre");
        jLabel3.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(255, 51, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Ocupado");
        jLabel4.setOpaque(true);

        jLabel5.setText("FILOSOFOS");

        jLabel6.setBackground(new java.awt.Color(0, 0, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Pensando");
        jLabel6.setOpaque(true);

        jLabel7.setBackground(new java.awt.Color(0, 204, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Comiendo");
        jLabel7.setOpaque(true);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Entro a comer");
        jLabel9.setOpaque(true);

        iniciarBoton.setText("Iniciar");
        iniciarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarBotonActionPerformed(evt);
            }
        });

        terminarBoton.setText("Terminar");
        terminarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminarBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(47, 47, 47))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(iniciarBoton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(terminarBoton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel5)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(iniciarBoton)
                        .addComponent(terminarBoton)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Filosofo2)
                    .addComponent(tenedor2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Filosofo3)
                        .addGap(37, 37, 37)
                        .addComponent(tenedor3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Filosofo4))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Filosofo5)
                    .addComponent(tenedor4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(tenedor1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(Filosofo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tenedor5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tenedor1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Filosofo1)
                    .addComponent(tenedor5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(65, 65, 65)
                            .addComponent(Filosofo5)
                            .addGap(44, 44, 44)
                            .addComponent(tenedor4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(Filosofo2)
                        .addGap(50, 50, 50)
                        .addComponent(tenedor2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Filosofo3)
                    .addComponent(Filosofo4)
                    .addComponent(tenedor3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarBotonActionPerformed
        iniciarSimulacion();
        this.iniciarBoton.setEnabled(false);
        this.terminarBoton.setEnabled(true);
    }//GEN-LAST:event_iniciarBotonActionPerformed

    private void terminarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarBotonActionPerformed
        c.detenerSimulacion();
        this.iniciarBoton.setEnabled(true);
        this.terminarBoton.setEnabled(false);
    }//GEN-LAST:event_terminarBotonActionPerformed
    private void iniciarSimulacion(){
        JLabel [] FilosofosLbl = new JLabel[5];
        JLabel [] TenedoresLbl = new JLabel[5];
        FilosofosLbl[0] = this.Filosofo1;
        FilosofosLbl[1] = this.Filosofo2;
        FilosofosLbl[2] = this.Filosofo3;
        FilosofosLbl[3] = this.Filosofo4;
        FilosofosLbl[4] = this.Filosofo5;
        TenedoresLbl[0] = this.tenedor1;
        TenedoresLbl[1] = this.tenedor2;
        TenedoresLbl[2] = this.tenedor3;
        TenedoresLbl[3] = this.tenedor4;
        TenedoresLbl[4] = this.tenedor5;
        c = new Controladora(TenedoresLbl,FilosofosLbl);
        c.iniciarSimulacion();
    }

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
            java.util.logging.Logger.getLogger(problema1GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(problema1GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(problema1GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(problema1GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new problema1GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Filosofo1;
    private javax.swing.JLabel Filosofo2;
    private javax.swing.JLabel Filosofo3;
    private javax.swing.JLabel Filosofo4;
    private javax.swing.JLabel Filosofo5;
    private javax.swing.JButton iniciarBoton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel tenedor1;
    private javax.swing.JLabel tenedor2;
    private javax.swing.JLabel tenedor3;
    private javax.swing.JLabel tenedor4;
    private javax.swing.JLabel tenedor5;
    private javax.swing.JButton terminarBoton;
    // End of variables declaration//GEN-END:variables
}
