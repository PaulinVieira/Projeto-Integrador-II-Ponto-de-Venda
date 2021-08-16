package View;

import Controller.ClientController;
import Model.Client;
import Util.PositionForm;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import static javax.management.Query.gt;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class JIFSearchClient extends javax.swing.JInternalFrame {
    
 

    PositionForm form = new PositionForm();
    JFMainScreen jfMain = new JFMainScreen();
    int selectedOption = 0;

    public JIFSearchClient() {
        initComponents();
        
    //Thread, que de tempos em tempos 
    //verifica se o conteudo do campo de pesquisa é diferente de vazio.
    //Se for diferente, torna o botão "clicável".
    
        Thread t = new Thread(){
    @Override
    public void run(){
        while (true){
            if(!(jTFClientSearchText.getText().equals(""))){
                jBtnFind.setEnabled(true);
            } else {
                jBtnFind.setEnabled(false); 
            }
            try {
                sleep(500); //meio segundo
            } catch (InterruptedException e) {}
         }
    }
};
     t.start();
       

    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jTFClientSearchText = new javax.swing.JTextField();
        jBtnFind = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTListClients = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jRBClientCode = new javax.swing.JRadioButton();
        jRBClientName = new javax.swing.JRadioButton();
        jRBClientCPF = new javax.swing.JRadioButton();
        jRBClientEmail = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel2.setText("Digite o texto da pesquisa");

        jTFClientSearchText.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTFClientSearchTextInputMethodTextChanged(evt);
            }
        });
        jTFClientSearchText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFClientSearchTextActionPerformed(evt);
            }
        });
        jTFClientSearchText.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTFClientSearchTextPropertyChange(evt);
            }
        });

        jBtnFind.setText("Localizar");
        jBtnFind.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBtnFindStateChanged(evt);
            }
        });
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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTListClients.setColumnSelectionAllowed(true);
        jTListClients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTListClientsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTListClients);
        jTListClients.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Pesquisar por"));

        buttonGroup2.add(jRBClientCode);
        jRBClientCode.setText("Código");
        jRBClientCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBClientCodeActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRBClientName);
        jRBClientName.setText("Nome");
        jRBClientName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBClientNameActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRBClientName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRBClientCode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRBClientCPF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBClientEmail)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBClientName)
                    .addComponent(jRBClientCode)
                    .addComponent(jRBClientCPF)
                    .addComponent(jRBClientEmail))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFClientSearchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnFind))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
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
    
    private void verifyModel() {
        DefaultTableModel model = (DefaultTableModel) jTListClients.getModel();

        if(model.getRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Não existem registros com o parâmetro informado.", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
            
        }

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
                JOptionPane.showMessageDialog(null, "Informe um parâmetro para pesquisa.", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
            }
            if (selectedOption == 1) { // nome
                reset();
                addRowToTable(clientController.findByName(jTFClientSearchText.getText()));
                verifyModel();
            }
            if (selectedOption == 2) { // código
                reset();
                addRowToTable(clientController.findByCode(jTFClientSearchText.getText()));
                verifyModel();
            }
            if (selectedOption == 3) { // cpf
                reset();
                addRowToTable(clientController.findByCPF(jTFClientSearchText.getText()));
                verifyModel();
            }
            if (selectedOption == 4) { // e-mail
                reset();
                addRowToTable(clientController.findByEmail(jTFClientSearchText.getText()));
                verifyModel();
            }

    }//GEN-LAST:event_jBtnFindActionPerformed

    private void jTListClientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTListClientsMouseClicked
        JIFClients jifClients = new JIFClients();
        JDesktopPane desktop = getDesktopPane();
        desktop.add(jifClients);

        int index = jTListClients.getSelectedRow();

        DefaultTableModel model = (DefaultTableModel) jTListClients.getModel();
        String cpf = model.getValueAt(index, 2).toString();

        jifClients.showObject(cpf);
        jifClients.show();

    }//GEN-LAST:event_jTListClientsMouseClicked

    private void jTFClientSearchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFClientSearchTextActionPerformed

    }//GEN-LAST:event_jTFClientSearchTextActionPerformed

    private void jTFClientSearchTextInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTFClientSearchTextInputMethodTextChanged

    }//GEN-LAST:event_jTFClientSearchTextInputMethodTextChanged

    private void jTFClientSearchTextPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTFClientSearchTextPropertyChange

    }//GEN-LAST:event_jTFClientSearchTextPropertyChange

    private void jBtnFindStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBtnFindStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnFindStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jBtnFind;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRBClientCPF;
    private javax.swing.JRadioButton jRBClientCode;
    private javax.swing.JRadioButton jRBClientEmail;
    private javax.swing.JRadioButton jRBClientName;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFClientSearchText;
    private javax.swing.JTable jTListClients;
    // End of variables declaration//GEN-END:variables
}
