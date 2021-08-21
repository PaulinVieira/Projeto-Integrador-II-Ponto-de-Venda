package View;

import Controller.ProductController;
import Model.Product;
import Util.PositionForm;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JIFSearchProduct extends javax.swing.JInternalFrame {

    PositionForm form = new PositionForm();
    JFMainScreen jfMain = new JFMainScreen();
    ProductController productController = new ProductController();
    int selectedOption = 0;

    public JIFSearchProduct() {
        initComponents();
        jBtnDelete.setVisible(false);
        jBtnUpdate.setVisible(false);

        //Thread, que de tempos em tempos 
        //verifica se o conteudo do campo de pesquisa é diferente de vazio.
        //Se for diferente, torna o botão "clicável".
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (!(jTFProductSearchText.getText().equals("") && selectedOption != 5)) {
                        jBtnFind.setEnabled(true);
                    } else {
                        jBtnFind.setEnabled(false);
                    }
                    try {
                        sleep(500); //meio segundo
                    } catch (InterruptedException e) {
                    }
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
        jTFProductSearchText = new javax.swing.JTextField();
        jBtnFind = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTListProducts = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jRBProductCode = new javax.swing.JRadioButton();
        jRBProductDescription = new javax.swing.JRadioButton();
        jRBProductCategory = new javax.swing.JRadioButton();
        jRBProductLocation = new javax.swing.JRadioButton();
        jRBProductAll = new javax.swing.JRadioButton();
        jBtnDelete = new javax.swing.JButton();
        jBtnUpdate = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel2.setText("Digite o texto da pesquisa");

        jTFProductSearchText.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTFProductSearchTextInputMethodTextChanged(evt);
            }
        });
        jTFProductSearchText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFProductSearchTextActionPerformed(evt);
            }
        });
        jTFProductSearchText.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTFProductSearchTextPropertyChange(evt);
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

        jTListProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Código", "Categoria", "Localização", "Preço de Venda", "Quantidade Disponível"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTListProducts.setColumnSelectionAllowed(true);
        jTListProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTListProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTListProducts);
        jTListProducts.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Pesquisar por"));

        buttonGroup2.add(jRBProductCode);
        jRBProductCode.setText("Código");
        jRBProductCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBProductCodeActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRBProductDescription);
        jRBProductDescription.setText("Descrição");
        jRBProductDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBProductDescriptionActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRBProductCategory);
        jRBProductCategory.setText("Categoria");
        jRBProductCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBProductCategoryActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRBProductLocation);
        jRBProductLocation.setText("Localização");
        jRBProductLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBProductLocationActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRBProductAll);
        jRBProductAll.setText("Todos");
        jRBProductAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBProductAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRBProductDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRBProductCode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRBProductCategory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBProductLocation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBProductAll)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBProductDescription)
                    .addComponent(jRBProductCode)
                    .addComponent(jRBProductCategory)
                    .addComponent(jRBProductLocation)
                    .addComponent(jRBProductAll))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jBtnDelete.setText("Deletar");
        jBtnDelete.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBtnDeleteStateChanged(evt);
            }
        });
        jBtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDeleteActionPerformed(evt);
            }
        });

        jBtnUpdate.setText("Alterar");
        jBtnUpdate.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jBtnUpdateStateChanged(evt);
            }
        });
        jBtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFProductSearchText, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(137, 137, 137)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtnFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBtnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnDelete)
                        .addGap(2, 2, 2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFProductSearchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnFind))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addRowToTable(ArrayList<Product> list) {

        DefaultTableModel model = (DefaultTableModel) jTListProducts.getModel();

        Object rowData[] = new Object[7];

        for (int i = 0; i < list.size(); i++) {

            rowData[0] = list.get(i).getProductDescription();
            rowData[1] = list.get(i).getProductCode();
            rowData[2] = list.get(i).getProductCategory();
            rowData[3] = list.get(i).getProductLocation();
            rowData[4] = list.get(i).getProductPrice();
            rowData[5] = list.get(i).getProductQuantity();

            model.addRow(rowData);
        }
    }

    private void reset() {
        DefaultTableModel model = (DefaultTableModel) jTListProducts.getModel();

        model.setRowCount(0);
    }

    private void verifyModel() {
        DefaultTableModel model = (DefaultTableModel) jTListProducts.getModel();

        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Não existem registros com o parâmetro informado.", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        jBtnDelete.setVisible(true);
        jBtnUpdate.setVisible(true);

    }
    private void jRBProductDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBProductDescriptionActionPerformed
        jTFProductSearchText.setEnabled(true);
        selectedOption = 1;
    }//GEN-LAST:event_jRBProductDescriptionActionPerformed

    private void jRBProductCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBProductCodeActionPerformed
        jTFProductSearchText.setEnabled(true);
        selectedOption = 2;
    }//GEN-LAST:event_jRBProductCodeActionPerformed

    private void jRBProductCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBProductCategoryActionPerformed
        jTFProductSearchText.setEnabled(true);
        selectedOption = 3;
    }//GEN-LAST:event_jRBProductCategoryActionPerformed

    private void jRBProductLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBProductLocationActionPerformed
        jTFProductSearchText.setEnabled(true);
        selectedOption = 4;
    }//GEN-LAST:event_jRBProductLocationActionPerformed

    private void jBtnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFindActionPerformed
        //futuramente (se possível) implementar strategy para melhorar a codificação.

        if (selectedOption == 0) { // nada foi informado
            JOptionPane.showMessageDialog(null, "Informe um parâmetro para pesquisa.", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
        }
        if (selectedOption == 1) { // nome
            reset();
            addRowToTable(productController.findByDescription(jTFProductSearchText.getText()));
            verifyModel();
        }
        if (selectedOption == 2) { // código
            reset();
            addRowToTable(productController.findByCode(jTFProductSearchText.getText()));
            verifyModel();
        }
        if (selectedOption == 3) { // cpf
            reset();
            addRowToTable(productController.findByCategory(jTFProductSearchText.getText()));
            verifyModel();
        }
        if (selectedOption == 4) { // e-mail
            reset();
            addRowToTable(productController.findByLocation(jTFProductSearchText.getText()));
            verifyModel();
        }
        if (selectedOption == 5) { // todos
            reset();
            addRowToTable(productController.findAll());
            verifyModel();
        }

    }//GEN-LAST:event_jBtnFindActionPerformed

    private void jTListProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTListProductsMouseClicked

        //só abrir a jifClients se houver um duplo clique, e se o evento não foi chamado anteriormente.
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();

            JIFProducts jifProducts = new JIFProducts();
            JDesktopPane desktop = getDesktopPane();
            desktop.add(jifProducts);

            int index = jTListProducts.getSelectedRow();

            DefaultTableModel model = (DefaultTableModel) jTListProducts.getModel();
            String code = model.getValueAt(index, 1).toString();

            jifProducts.showObject(code, 0);
            jifProducts.show();
        }

    }//GEN-LAST:event_jTListProductsMouseClicked

    private void jTFProductSearchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFProductSearchTextActionPerformed

    }//GEN-LAST:event_jTFProductSearchTextActionPerformed

    private void jTFProductSearchTextInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTFProductSearchTextInputMethodTextChanged

    }//GEN-LAST:event_jTFProductSearchTextInputMethodTextChanged

    private void jTFProductSearchTextPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTFProductSearchTextPropertyChange

    }//GEN-LAST:event_jTFProductSearchTextPropertyChange

    private void jBtnFindStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBtnFindStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnFindStateChanged

    private void jBtnDeleteStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBtnDeleteStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnDeleteStateChanged

    private void jBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeleteActionPerformed

        if (jTListProducts.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um produto para excluir.", "Informação sistema", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int index = jTListProducts.getSelectedRow();

        DefaultTableModel model = (DefaultTableModel) jTListProducts.getModel();
        String code = model.getValueAt(index, 1).toString();

        int input = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o produto selecionado?");
        if (input == 0) {
            productController.deleteByCode(code);
            jBtnDelete.setVisible(false);
            JOptionPane.showMessageDialog(null, "Produto excluído com sucesso.", "Informação sistema", JOptionPane.INFORMATION_MESSAGE);
            reset();
        }
    }//GEN-LAST:event_jBtnDeleteActionPerformed

    private void jRBProductAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBProductAllActionPerformed
        selectedOption = 5;
        jTFProductSearchText.setText("");
        jTFProductSearchText.setEnabled(false);
    }//GEN-LAST:event_jRBProductAllActionPerformed

    private void jBtnUpdateStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jBtnUpdateStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnUpdateStateChanged

    private void jBtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnUpdateActionPerformed

        if (jTListProducts.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um produto para alterar.", "Informação sistema", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        JIFProducts jifProducts = new JIFProducts();
        JDesktopPane desktop = getDesktopPane();
        desktop.add(jifProducts);

        int index = jTListProducts.getSelectedRow();

        DefaultTableModel model = (DefaultTableModel) jTListProducts.getModel();
        String code = model.getValueAt(index, 1).toString();

        jifProducts.showObject(code, 1);
        jifProducts.show();
    }//GEN-LAST:event_jBtnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jBtnDelete;
    private javax.swing.JButton jBtnFind;
    private javax.swing.JButton jBtnUpdate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRBProductAll;
    private javax.swing.JRadioButton jRBProductCategory;
    private javax.swing.JRadioButton jRBProductCode;
    private javax.swing.JRadioButton jRBProductDescription;
    private javax.swing.JRadioButton jRBProductLocation;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFProductSearchText;
    private javax.swing.JTable jTListProducts;
    // End of variables declaration//GEN-END:variables
}
