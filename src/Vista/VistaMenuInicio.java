package Vista;

import Controlador.ControladorAgendarCita;
import Controlador.ControladorAgregarMascota;
import Controlador.ControladorCancelarCliente;
import Controlador.ControladorHistorial;
import Controlador.ControladorHistorialCliente;
import Controlador.ControladorMenuInicio;
import Controlador.ControladorModificarCliente;
import Controlador.ControladorRegistrarMascota;
import Controlador.ControladorVerMascotas;
import Excepciones.CitasException;
import Excepciones.ClientesExcepciones;
import Excepciones.DiagnosticosException;
import Excepciones.MascotaExcepcion;
import Excepciones.UserNotFound;
import Modelo.VO.Cliente;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
/**
 *
 * @author danii
 */
public class VistaMenuInicio extends javax.swing.JDialog {

    /**
     * Creates new form Personal_1
     */
    public VistaMenuInicio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public VistaMenuInicio() {
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

        jPanel3 = new javax.swing.JPanel();
        btn_salir = new javax.swing.JButton();
        btn_agendar = new javax.swing.JButton();
        btn_ver = new javax.swing.JButton();
        lbl_mensaje = new javax.swing.JLabel();
        btn_cerrar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_mascotas = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_historial = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        imagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setForeground(new java.awt.Color(0, 102, 255));

        btn_salir.setFont(new java.awt.Font("The munday free version", 1, 14)); // NOI18N
        btn_salir.setForeground(new java.awt.Color(0, 102, 255));
        btn_salir.setText("Salir");
        btn_salir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_salir.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btn_salirFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btn_salirFocusLost(evt);
            }
        });
        btn_salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_salirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_salirMouseExited(evt);
            }
        });
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        btn_agendar.setFont(new java.awt.Font("The munday free version", 1, 14)); // NOI18N
        btn_agendar.setForeground(new java.awt.Color(0, 102, 255));
        btn_agendar.setText("Agendar cita");
        btn_agendar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_agendar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btn_agendarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btn_agendarFocusLost(evt);
            }
        });
        btn_agendar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_agendarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_agendarMouseExited(evt);
            }
        });
        btn_agendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agendarActionPerformed(evt);
            }
        });

        btn_ver.setFont(new java.awt.Font("The munday free version", 1, 14)); // NOI18N
        btn_ver.setForeground(new java.awt.Color(0, 102, 255));
        btn_ver.setText("Ver citas");
        btn_ver.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_ver.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btn_verFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btn_verFocusLost(evt);
            }
        });
        btn_ver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_verMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_verMouseExited(evt);
            }
        });
        btn_ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verActionPerformed(evt);
            }
        });

        lbl_mensaje.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N

        btn_cerrar.setFont(new java.awt.Font("The munday free version", 1, 14)); // NOI18N
        btn_cerrar.setForeground(new java.awt.Color(0, 102, 255));
        btn_cerrar.setText("Cerrar Sesion");
        btn_cerrar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_cerrar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btn_cerrarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btn_cerrarFocusLost(evt);
            }
        });
        btn_cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cerrarMouseExited(evt);
            }
        });
        btn_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarActionPerformed(evt);
            }
        });

        btn_modificar.setFont(new java.awt.Font("The munday free version", 1, 14)); // NOI18N
        btn_modificar.setForeground(new java.awt.Color(0, 102, 255));
        btn_modificar.setText("Modificar Datos");
        btn_modificar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_modificar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btn_modificarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btn_modificarFocusLost(evt);
            }
        });
        btn_modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_modificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_modificarMouseExited(evt);
            }
        });
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_mascotas.setFont(new java.awt.Font("The munday free version", 1, 14)); // NOI18N
        btn_mascotas.setForeground(new java.awt.Color(0, 102, 255));
        btn_mascotas.setText("Mis mascotas");
        btn_mascotas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_mascotas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btn_mascotasFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btn_mascotasFocusLost(evt);
            }
        });
        btn_mascotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_mascotasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_mascotasMouseExited(evt);
            }
        });
        btn_mascotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mascotasActionPerformed(evt);
            }
        });

        btn_agregar.setFont(new java.awt.Font("The munday free version", 1, 14)); // NOI18N
        btn_agregar.setForeground(new java.awt.Color(0, 102, 255));
        btn_agregar.setText("Agregar mascota");
        btn_agregar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_agregar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btn_agregarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btn_agregarFocusLost(evt);
            }
        });
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        btn_cancelar.setFont(new java.awt.Font("The munday free version", 1, 14)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(0, 102, 255));
        btn_cancelar.setText("Cancelar citas");
        btn_cancelar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_cancelar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btn_cancelarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btn_cancelarFocusLost(evt);
            }
        });
        btn_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cancelarMouseExited(evt);
            }
        });
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_historial.setFont(new java.awt.Font("The munday free version", 1, 14)); // NOI18N
        btn_historial.setForeground(new java.awt.Color(0, 102, 255));
        btn_historial.setText("Historiales");
        btn_historial.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_historial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btn_historialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btn_historialFocusLost(evt);
            }
        });
        btn_historial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_historialMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_historialMouseExited(evt);
            }
        });
        btn_historial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_historialActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(134, 187, 239));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("The munday free version", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("MENU INICIO");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modelo/Assets/MenuIn.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 180, 470));

        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Modelo/Assets/InicioAnimal 1 (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_mascotas, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_ver, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_agendar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_salir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_historial, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_mensaje))
                    .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_agendar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_ver, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_historial, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_mascotas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(lbl_mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_cerrar)
                            .addComponent(btn_salir))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_historialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_historialActionPerformed
        try {
            // TODO add your handling code here:
            ControladorHistorialCliente.mostrarVentana();
            this.setVisible(false);
        } catch (MascotaExcepcion ex) {
            JOptionPane.showMessageDialog(this, "No hay mascotas registradas");
        } catch (DiagnosticosException ex) {
            JOptionPane.showMessageDialog(this, "No hay diagnosticos que mostrar");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (CitasException ex) {
            System.out.println(ex.getMessage());
        } catch (ClientesExcepciones ex) {
            System.out.println(ex.getMessage());
        } catch (UserNotFound ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btn_historialActionPerformed

    private void btn_historialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_historialFocusLost
        // TODO add your handling code here:
        btn_historial.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btn_historialFocusLost

    private void btn_historialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_historialFocusGained
        // TODO add your handling code here:
        btn_historial.setBackground(new Color(187, 215, 243));
    }//GEN-LAST:event_btn_historialFocusGained

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        try {
            // TODO add your handling code here:
            ControladorCancelarCliente.mostrarVentana();
        } catch (CitasException ex) {
            JOptionPane.showMessageDialog(this, "No hay citas que mostrar");
        }
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_cancelarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_cancelarFocusLost
        // TODO add your handling code here:
        btn_cancelar.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btn_cancelarFocusLost

    private void btn_cancelarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_cancelarFocusGained
        // TODO add your handling code here:
        btn_cancelar.setBackground(new Color(187, 215, 243));
    }//GEN-LAST:event_btn_cancelarFocusGained

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        // TODO add your handling code here:
        ControladorAgregarMascota.mostrarVentana();
        this.setVisible(false);
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_agregarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_agregarFocusLost
        // TODO add your handling code here:
        btn_agregar.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btn_agregarFocusLost

    private void btn_agregarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_agregarFocusGained
        // TODO add your handling code here:
        btn_agregar.setBackground(new Color(187, 215, 243));
    }//GEN-LAST:event_btn_agregarFocusGained

    private void btn_mascotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mascotasActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        try {
            ControladorVerMascotas.mostrarVentana();
        } catch (MascotaExcepcion ex) {
            Logger.getLogger(VistaMenuInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_mascotasActionPerformed

    private void btn_mascotasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_mascotasFocusLost
        // TODO add your handling code here:
        btn_mascotas.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btn_mascotasFocusLost

    private void btn_mascotasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_mascotasFocusGained
        // TODO add your handling code here:
        btn_mascotas.setBackground(new Color(187, 215, 243));
    }//GEN-LAST:event_btn_mascotasFocusGained

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        ControladorModificarCliente.mostrarVentana();
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_modificarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_modificarFocusLost
        // TODO add your handling code here:
        btn_modificar.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btn_modificarFocusLost

    private void btn_modificarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_modificarFocusGained
        // TODO add your handling code here:
        btn_modificar.setBackground(new Color(187, 215, 243));
    }//GEN-LAST:event_btn_modificarFocusGained

    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
        // TODO add your handling code here:
        ControladorMenuInicio.cerrar();
    }//GEN-LAST:event_btn_cerrarActionPerformed

    private void btn_cerrarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_cerrarFocusLost
        // TODO add your handling code here
        btn_cerrar.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btn_cerrarFocusLost

    private void btn_cerrarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_cerrarFocusGained
        // TODO add your handling code here:
        btn_cerrar.setBackground(new Color(187, 215, 243));
    }//GEN-LAST:event_btn_cerrarFocusGained

    private void btn_verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verActionPerformed
        try {
            // TODO add your handling code here:
            ControladorMenuInicio.verCitas();
            this.setVisible(false);
        } catch (CitasException ex) {
            JOptionPane.showMessageDialog(this, "No hay citas que mostrar");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClientesExcepciones ex) {
            System.out.println(ex.getMessage());
        } catch (UserNotFound ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btn_verActionPerformed

    private void btn_verFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_verFocusLost
        // TODO add your handling code here:
        btn_ver.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btn_verFocusLost

    private void btn_verFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_verFocusGained
        // TODO add your handling code here:
        btn_ver.setBackground(new Color(187, 215, 243));
    }//GEN-LAST:event_btn_verFocusGained

    private void btn_agendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agendarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        ControladorMenuInicio.agendarCita();
        this.dispose();
    }//GEN-LAST:event_btn_agendarActionPerformed

    private void btn_agendarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_agendarFocusLost
        // TODO add your handling code here:
        btn_agendar.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btn_agendarFocusLost

    private void btn_agendarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_agendarFocusGained
        // TODO add your handling code here:
        btn_agendar.setBackground(new Color(187, 215, 243));
        
    }//GEN-LAST:event_btn_agendarFocusGained

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // TODO add your handling code here:
        ControladorMenuInicio.salir();
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_salirFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_salirFocusLost
        // TODO add your handling code here:
        btn_salir.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btn_salirFocusLost

    private void btn_salirFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_salirFocusGained
        // TODO add your handling code here:
        btn_salir.setBackground(new Color(187, 215, 243));
    }//GEN-LAST:event_btn_salirFocusGained

    private void btn_verMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_verMouseEntered
        // TODO add your handling code here:
        
        btn_ver.setForeground(new Color(204, 51, 255));
    }//GEN-LAST:event_btn_verMouseEntered

    private void btn_agendarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agendarMouseEntered
        // TODO add your handling code here:
        btn_agendar.setForeground(new Color(204, 51, 255));
    }//GEN-LAST:event_btn_agendarMouseEntered

    private void btn_agendarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agendarMouseExited
        // TODO add your handling code here:
        btn_agendar.setForeground(new Color(0, 102, 255));
        
    }//GEN-LAST:event_btn_agendarMouseExited

    private void btn_verMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_verMouseExited
        // TODO add your handling code here:
        btn_ver.setForeground(new Color(0, 102, 255));
    }//GEN-LAST:event_btn_verMouseExited

    private void btn_mascotasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mascotasMouseEntered
        // TODO add your handling code here:
        btn_mascotas.setForeground(new Color(204, 51, 255));
    }//GEN-LAST:event_btn_mascotasMouseEntered

    private void btn_mascotasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mascotasMouseExited
        // TODO add your handling code here:
        btn_mascotas.setForeground(new Color(0, 102, 255));
    }//GEN-LAST:event_btn_mascotasMouseExited

    private void btn_modificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_modificarMouseEntered
        // TODO add your handling code here:
        btn_modificar.setForeground(new Color(204, 51, 255));
        
    }//GEN-LAST:event_btn_modificarMouseEntered

    private void btn_modificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_modificarMouseExited
        // TODO add your handling code here:
        btn_modificar.setForeground(new Color(0, 102, 255));
    }//GEN-LAST:event_btn_modificarMouseExited

    private void btn_historialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_historialMouseEntered
        // TODO add your handling code here:
        btn_historial.setForeground(new Color(204, 51, 255));
    }//GEN-LAST:event_btn_historialMouseEntered

    private void btn_historialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_historialMouseExited
        // TODO add your handling code here:
        btn_historial.setForeground(new Color(0, 102, 255));
        
    }//GEN-LAST:event_btn_historialMouseExited

    private void btn_cancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelarMouseEntered
        // TODO add your handling code here:
        
        btn_cancelar.setForeground(new Color(204, 51, 255));
    }//GEN-LAST:event_btn_cancelarMouseEntered

    private void btn_cancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelarMouseExited
        // TODO add your handling code here:
        btn_cancelar.setForeground(new Color(0, 102, 255));
    }//GEN-LAST:event_btn_cancelarMouseExited

    private void btn_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseEntered
        // TODO add your handling code here:
        btn_salir.setForeground(new Color(204, 51, 255));
    }//GEN-LAST:event_btn_salirMouseEntered

    private void btn_salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseExited
        // TODO add your handling code here:
        btn_salir.setForeground(new Color(0, 102, 255));
    }//GEN-LAST:event_btn_salirMouseExited

    private void btn_cerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cerrarMouseEntered
        // TODO add your handling code here:
        btn_cerrar.setForeground(new Color(204, 51, 255));
    }//GEN-LAST:event_btn_cerrarMouseEntered

    private void btn_cerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cerrarMouseExited
        // TODO add your handling code here:
        btn_cerrar.setForeground(new Color(0, 102, 255));
    }//GEN-LAST:event_btn_cerrarMouseExited

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        // TODO add your handling code here:
        jLabel1.setForeground(new Color(204, 51, 255));
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        // TODO add your handling code here:
        
        jLabel1.setForeground(new Color(0, 0, 204));
    }//GEN-LAST:event_jLabel1MouseExited

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
            java.util.logging.Logger.getLogger(VistaMenuInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaMenuInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaMenuInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaMenuInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VistaMenuInicio dialog = new VistaMenuInicio(new javax.swing.JFrame(), true);
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
    
    public JButton getBtn_agendar() {
        return btn_agendar;
    }
    
    public void setBtn_agendar(JButton btn_agendar) {
        this.btn_agendar = btn_agendar;
    }
    
    public JButton getBtn_ver() {
        return btn_ver;
    }
    
    public void setBtn_ver(JButton btn_ver) {
        this.btn_ver = btn_ver;
    }
    
    public JLabel getLbl_mensaje() {
        return lbl_mensaje;
    }
    
    public void setLbl_mensaje(JLabel lbl_mensaje) {
        this.lbl_mensaje = lbl_mensaje;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agendar;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton btn_historial;
    private javax.swing.JButton btn_mascotas;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_ver;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl_mensaje;
    // End of variables declaration//GEN-END:variables
}
