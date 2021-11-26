package View;

import Util.PositionForm;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class JFMainScreen extends javax.swing.JFrame {

    PositionForm form = new PositionForm();
    JIFPointOfSale jifPointOfSale;
    JIFInventory jifInventory;

    public JFMainScreen() {

        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);

        try {
            jdpMain.add(Background);
            Background.setMaximum(true);
            Background.setVisible(true);

        } catch (PropertyVetoException e) {
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jdpMain = new javax.swing.JDesktopPane();
        jMenuBarPrin = new javax.swing.JMenuBar();
        jMRecords = new javax.swing.JMenu();
        jMIClients = new javax.swing.JMenuItem();
        jMIProducts = new javax.swing.JMenuItem();
        jMPdv = new javax.swing.JMenu();
        jMIPointSale = new javax.swing.JMenuItem();
        jMReports = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMInventory = new javax.swing.JMenu();
        Inventário = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Snakers Store");

        javax.swing.GroupLayout jdpMainLayout = new javax.swing.GroupLayout(jdpMain);
        jdpMain.setLayout(jdpMainLayout);
        jdpMainLayout.setHorizontalGroup(
            jdpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
        );
        jdpMainLayout.setVerticalGroup(
            jdpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
        );

        jMRecords.setText("Cadastros");

        jMIClients.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMIClients.setText("Clientes");
        jMIClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIClientsActionPerformed(evt);
            }
        });
        jMRecords.add(jMIClients);

        jMIProducts.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMIProducts.setText("Produtos");
        jMIProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIProductsActionPerformed(evt);
            }
        });
        jMRecords.add(jMIProducts);

        jMenuBarPrin.add(jMRecords);

        jMPdv.setText("PDV");

        jMIPointSale.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMIPointSale.setText("Ponto de Venda");
        jMIPointSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPointSaleActionPerformed(evt);
            }
        });
        jMPdv.add(jMIPointSale);

        jMenuBarPrin.add(jMPdv);

        jMReports.setText("Relatórios");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Sintético");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMReports.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Analítico");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMReports.add(jMenuItem2);

        jMenuBarPrin.add(jMReports);

        jMInventory.setText("Estoque");

        Inventário.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        Inventário.setText("Inventário");
        Inventário.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InventárioActionPerformed(evt);
            }
        });
        jMInventory.add(Inventário);

        jMenuBarPrin.add(jMInventory);

        setJMenuBar(jMenuBarPrin);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpMain, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpMain, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMIClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIClientsActionPerformed

        JIFClients jifClients;
        form.openForm(jifClients = new JIFClients(), jdpMain);

    }//GEN-LAST:event_jMIClientsActionPerformed

    private void jMIProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIProductsActionPerformed

        JIFProducts jifProducts;
        form.openForm(jifProducts = new JIFProducts(), jdpMain);

    }//GEN-LAST:event_jMIProductsActionPerformed

    private void jMIPointSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPointSaleActionPerformed
        
        
        if (jifPointOfSale == null) {
            
            form.openForm(jifPointOfSale = new JIFPointOfSale(), jdpMain);

            jifPointOfSale.show();
            try {
                jifPointOfSale.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(JFMainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (!jifPointOfSale.isVisible()) {
            
            form.openForm(jifPointOfSale = new JIFPointOfSale(), jdpMain);

            jifPointOfSale.show();
            
            try {
                jifPointOfSale.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(JFMainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Tela já aberta.", "Informação sistema", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jMIPointSaleActionPerformed

    private void InventárioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InventárioActionPerformed
        if (jifInventory == null) {
            
            form.openForm(jifInventory = new JIFInventory(), jdpMain);

            jifInventory.show();
          
        } else if (!jifInventory.isVisible()) {
            
            form.openForm(jifInventory = new JIFInventory(), jdpMain);

            jifInventory.show();
            
        } else {
            JOptionPane.showMessageDialog(null, "Tela já aberta.", "Informação sistema", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_InventárioActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        JIFSyntheticReport jirelatorioS;
        form.openForm(jirelatorioS = new JIFSyntheticReport(), jdpMain);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
         JIFAnalyticalReport jirelatorioA;
        form.openForm(jirelatorioA = new JIFAnalyticalReport(), jdpMain);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public static void main(String args[]) {

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            new JFMainScreen().setVisible(true);
        });
    }
    private JIFBackground Background = new JIFBackground();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Inventário;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMIClients;
    private javax.swing.JMenuItem jMIPointSale;
    private javax.swing.JMenuItem jMIProducts;
    private javax.swing.JMenu jMInventory;
    private javax.swing.JMenu jMPdv;
    private javax.swing.JMenu jMRecords;
    private javax.swing.JMenu jMReports;
    private javax.swing.JMenuBar jMenuBarPrin;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JDesktopPane jdpMain;
    // End of variables declaration//GEN-END:variables

    public JDesktopPane getJdpMain() {
        return jdpMain;
    }

    public void setJdpMain(JDesktopPane jdpMain) {
        this.jdpMain = jdpMain;
    }
}
