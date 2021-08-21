package View;

import Util.PositionForm;
import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;

public class JFMainScreen extends javax.swing.JFrame {

    PositionForm form = new PositionForm();

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

        jdpMain = new javax.swing.JDesktopPane();
        jMenuBarPrin = new javax.swing.JMenuBar();
        jMRecords = new javax.swing.JMenu();
        jMIClients = new javax.swing.JMenuItem();
        jMIProducts = new javax.swing.JMenuItem();
        jMIFindClient = new javax.swing.JMenuItem();
        jMIFindProduct = new javax.swing.JMenuItem();
        jMPdv = new javax.swing.JMenu();
        jMReports = new javax.swing.JMenu();

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
        jMIClients.setText("Cadastrar Cliente");
        jMIClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIClientsActionPerformed(evt);
            }
        });
        jMRecords.add(jMIClients);

        jMIProducts.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMIProducts.setText("Cadastrar Produto");
        jMIProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIProductsActionPerformed(evt);
            }
        });
        jMRecords.add(jMIProducts);

        jMIFindClient.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMIFindClient.setText("Localizar Clientes");
        jMIFindClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIFindClientActionPerformed(evt);
            }
        });
        jMRecords.add(jMIFindClient);

        jMIFindProduct.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMIFindProduct.setText("Localizar Produtos");
        jMIFindProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIFindProductActionPerformed(evt);
            }
        });
        jMRecords.add(jMIFindProduct);

        jMenuBarPrin.add(jMRecords);

        jMPdv.setText("PDV");
        jMenuBarPrin.add(jMPdv);

        jMReports.setText("Relatórios");
        jMenuBarPrin.add(jMReports);

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

    private void jMIFindClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIFindClientActionPerformed

        JIFSearchClient jifSearchClient;
        form.openForm(jifSearchClient = new JIFSearchClient(), jdpMain);

    }//GEN-LAST:event_jMIFindClientActionPerformed

    private void jMIFindProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIFindProductActionPerformed

        JIFSearchProduct jifSearchProduct;
        form.openForm(jifSearchProduct = new JIFSearchProduct(), jdpMain);

    }//GEN-LAST:event_jMIFindProductActionPerformed

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
    private javax.swing.JMenuItem jMIClients;
    private javax.swing.JMenuItem jMIFindClient;
    private javax.swing.JMenuItem jMIFindProduct;
    private javax.swing.JMenuItem jMIProducts;
    private javax.swing.JMenu jMPdv;
    private javax.swing.JMenu jMRecords;
    private javax.swing.JMenu jMReports;
    private javax.swing.JMenuBar jMenuBarPrin;
    private javax.swing.JDesktopPane jdpMain;
    // End of variables declaration//GEN-END:variables

    public JDesktopPane getJdpMain() {
        return jdpMain;
    }

    public void setJdpMain(JDesktopPane jdpMain) {
        this.jdpMain = jdpMain;
    }
}
