/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vista;

import Controlador.ControladorDatosVet;
import Controlador.ControladorInicioPersonal;
import Controlador.ControladorMenuAdmi;
import Controlador.ControladorModificarRecepcion;
import Controlador.ControladorResumen;
import Excepciones.CitasException;
import Excepciones.ClientesExcepciones;
import Excepciones.UserNotFound;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gambo
 */
public class VistaMenuAdmin extends javax.swing.JDialog {

    /**
     * Creates new form VistaMenuAdmin
     */
    public VistaMenuAdmin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public VistaMenuAdmin() {
        super();
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_resumen = new javax.swing.JButton();
        btn_veteriarios1 = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        btn_cerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("The munday free version", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("ADMINISTRADOR");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 51));
        jLabel3.setText("Bienvenida, TOKISCHA");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modelo/Assets/tokischa400.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel2.setMaximumSize(new java.awt.Dimension(50, 50));

        btn_resumen.setFont(new java.awt.Font("The munday free version", 1, 14)); // NOI18N
        btn_resumen.setForeground(new java.awt.Color(0, 102, 255));
        btn_resumen.setText("RESUMEN");
        btn_resumen.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btn_resumenFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btn_resumenFocusLost(evt);
            }
        });
        btn_resumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resumenActionPerformed(evt);
            }
        });

        btn_veteriarios1.setFont(new java.awt.Font("The munday free version", 1, 14)); // NOI18N
        btn_veteriarios1.setForeground(new java.awt.Color(0, 102, 255));
        btn_veteriarios1.setText("VETERINARIOS");
        btn_veteriarios1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btn_veteriarios1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btn_veteriarios1FocusLost(evt);
            }
        });
        btn_veteriarios1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_veteriarios1ActionPerformed(evt);
            }
        });

        btn_salir.setFont(new java.awt.Font("The munday free version", 1, 14)); // NOI18N
        btn_salir.setForeground(new java.awt.Color(0, 102, 255));
        btn_salir.setText("SALIR");
        btn_salir.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btn_salirFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btn_salirFocusLost(evt);
            }
        });
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        btn_cerrarSesion.setFont(new java.awt.Font("The munday free version", 1, 14)); // NOI18N
        btn_cerrarSesion.setForeground(new java.awt.Color(0, 102, 255));
        btn_cerrarSesion.setText("CERRAR SESION");
        btn_cerrarSesion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btn_cerrarSesionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btn_cerrarSesionFocusLost(evt);
            }
        });
        btn_cerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_resumen, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_veteriarios1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                        .addComponent(btn_veteriarios1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btn_resumen, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(btn_cerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_resumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resumenActionPerformed
        try {
            // TODO add your handling code here:
            ControladorResumen.mostrarVentana();
            this.setVisible(false);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClientesExcepciones ex) {
            System.out.println(ex.getMessage());
        } catch (UserNotFound ex) {
            System.out.println(ex.getMessage());
        } catch (CitasException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btn_resumenActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // TODO add your handling code here:
        ControladorMenuAdmi.salir();
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_cerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarSesionActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        ControladorInicioPersonal.mostrarVentana();
        this.dispose();
    }//GEN-LAST:event_btn_cerrarSesionActionPerformed

    private void btn_veteriarios1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_veteriarios1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        ControladorDatosVet.mostrarVentana();

    }//GEN-LAST:event_btn_veteriarios1ActionPerformed

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        // TODO add your handling code here:
        jLabel1.setForeground(Color.magenta);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        // TODO add your handling code here:
        jLabel1.setForeground(new Color(0, 51, 255));
    }//GEN-LAST:event_jLabel1MouseExited

    private void btn_veteriarios1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_veteriarios1FocusGained
        // TODO add your handling code here:
        btn_veteriarios1.setBackground(new Color(187, 215, 243));
    }//GEN-LAST:event_btn_veteriarios1FocusGained

    private void btn_veteriarios1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_veteriarios1FocusLost
        // TODO add your handling code here:
        btn_veteriarios1.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btn_veteriarios1FocusLost

    private void btn_resumenFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_resumenFocusGained
        // TODO add your handling code here:
        btn_resumen.setBackground(new Color(187, 215, 243));
    }//GEN-LAST:event_btn_resumenFocusGained

    private void btn_resumenFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_resumenFocusLost
        // TODO add your handling code here:
        btn_resumen.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btn_resumenFocusLost

    private void btn_cerrarSesionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_cerrarSesionFocusGained
        // TODO add your handling code here:
        btn_cerrarSesion.setBackground(new Color(187, 215, 243));
    }//GEN-LAST:event_btn_cerrarSesionFocusGained

    private void btn_cerrarSesionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_cerrarSesionFocusLost
        // TODO add your handling code here:
        btn_cerrarSesion.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btn_cerrarSesionFocusLost

    private void btn_salirFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_salirFocusGained
        // TODO add your handling code here:
        btn_salir.setBackground(new Color(187, 215, 243));
    }//GEN-LAST:event_btn_salirFocusGained

    private void btn_salirFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_salirFocusLost
        // TODO add your handling code here:
        btn_salir.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btn_salirFocusLost

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
            java.util.logging.Logger.getLogger(VistaMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VistaMenuAdmin dialog = new VistaMenuAdmin(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cerrarSesion;
    private javax.swing.JButton btn_resumen;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_veteriarios1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}