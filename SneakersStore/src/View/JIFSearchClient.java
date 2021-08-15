package View;

import Controller.ClientController;
import Model.Client;
import Util.PositionForm;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JIFSearchClient extends javax.swing.JInternalFrame {
    
    PositionForm form = new PositionForm();
    JFMainScreen jfMain = new JFMainScreen();
    int selectedOption = 0;
    
    public JIFSearchClient() {
        initComponents();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jRBClientName = new javax.swing.JRadioButton();
        jRBClientCode = new javax.swing.JRadioButton();
        jRBClientCPF = new javax.swing.JRadioButton();
        jRBClientEmail = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jTFClientSearchText = new javax.swing.JTextField();
        jBtnFind = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTListClients = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Buscar por");

        buttonGroup2.add(jRBClientName);
        jRBClientName.setText("Nome");
        jRBClientName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBClientNameActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRBClientCode);
        jRBClientCode.setText("Código");
        jRBClientCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBClientCodeActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRBClientCPF);
        jRBClientCPF.setText("CPF");
        jRBClientCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBClientCPFActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRBClientEmail);
        jRBClientEmail.setText("E-mail");
        jRBClientEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBClientEmailActionPerformed(evt);
            }
        });

        jLabel2.setText("Digite o texto da pesquisa");

        jBtnFind.setText("Localizar");
        jBtnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFindActionPerformed(evt);
            }
        });

        jTListClients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Código", "CPF", "E-mail", "Última Compra", "Celular", "Estado"
            }
        ));
        jScrollPane1.setViewportView(jTListClients);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFClientSearchText, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnFind)
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBClientName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBClientCode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBClientCPF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBClientEmail)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jRBClientName)
                    .addComponent(jRBClientCode)
                    .addComponent(jRBClientCPF)
                    .addComponent(jRBClientEmail))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFClientSearchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnFind))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addRowToTable(ArrayList<Client> list) {
        
        DefaultTableModel model = (DefaultTableModel) jTListClients.getModel();
        
        Object rowData[] = new Object[7];
        
        for (int i = 0; i < list.size(); i++) {
            
            rowData[0] = list.get(i).getClientName();
            rowData[1] = list.get(i).getClientCode();
            rowData[2] = list.get(i).getClientCPF();
            rowData[3] = list.get(i).getClientEmail();
            rowData[4] = list.get(i).getClientDtLastBuy();
            rowData[5] = list.get(i).getClientCellphone();
            rowData[6] = list.get(i).getClientState();
            
            model.addRow(rowData);
        }
    }
    
    private void reset() {
        DefaultTableModel model = (DefaultTableModel) jTListClients.getModel();
        
        model.setRowCount(0);
        
    }
    private void jRBClientNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBClientNameActionPerformed
        selectedOption = 1;
    }//GEN-LAST:event_jRBClientNameActionPerformed

    private void jRBClientCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBClientCodeActionPerformed
        selectedOption = 2;
    }//GEN-LAST:event_jRBClientCodeActionPerformed

    private void jRBClientCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBClientCPFActionPerformed
        selectedOption = 3;
    }//GEN-LAST:event_jRBClientCPFActionPerformed

    private void jRBClientEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBClientEmailActionPerformed
        selectedOption = 4;
    }//GEN-LAST:event_jRBClientEmailActionPerformed

    private void jBtnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFindActionPerformed
        //futuramente (se possível) implementar strategy para melhorar a codificação.
        ClientController clientController = new ClientController();
        
        if (selectedOption == 0) { // nada foi informado
            JOptionPane.showMessageDialog(null, "Informe um parâmetro para pesquisa.");
        }
        
        if (selectedOption == 1) { // nome
            reset();
            addRowToTable(clientController.findByName(jTFClientSearchText.getText()));
        }
        if (selectedOption == 2) { // código
            reset();
            addRowToTable(clientController.findByCode(jTFClientSearchText.getText()));
        }
        if (selectedOption == 3) { // cpf
            reset();
            addRowToTable(clientController.findByCPF(jTFClientSearchText.getText()));
        }
        if (selectedOption == 4) { // e-mail
            reset();
            addRowToTable(clientController.findByEmail(jTFClientSearchText.getText()));
        }

    }//GEN-LAST:event_jBtnFindActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jBtnFind;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRBClientCPF;
    private javax.swing.JRadioButton jRBClientCode;
    private javax.swing.JRadioButton jRBClientEmail;
    private javax.swing.JRadioButton jRBClientName;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFClientSearchText;
    private javax.swing.JTable jTListClients;
    // End of variables declaration//GEN-END:variables
}
