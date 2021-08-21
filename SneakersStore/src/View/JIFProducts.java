package View;


import Controller.ProductController;
import Model.Product;
import Util.ProductForm;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class JIFProducts extends javax.swing.JInternalFrame {

    JDesktopPane windowManager;
    ProductController productController = new ProductController();
    String productCategory = "Tênis";
    ProductForm form = new ProductForm();
    

    public JIFProducts() {
        initComponents();
        this.jRBInactive.setEnabled(false);
        this.jRBActive.setSelected(true);
        this.jLabel4.setVisible(false);
        this.jLDtRegistration.setVisible(false);
        jBtnUpdate.setVisible(false);

    }

    private void disableForm() {

        jTFProductCode.setEditable(false);
        jTFProductDescription.setEditable(false);
        jBtnSave.setEnabled(false);
        jBtnClear.setEnabled(false);
        JTAObs.setEditable(false);
        jRBActive.setEnabled(false);
        jRBInactive.setEnabled(false);
        jRBBota.setEnabled(false);
        jRBChinelo.setEnabled(false);
        jRBEsportivo.setEnabled(false);
        jRBMeias.setEnabled(false);
        jRBSapato.setEnabled(false);
        jRBTenis.setEnabled(false);
        jTFQTDInitial.setEditable(false);
        jTFProductPrice.setEditable(false);
        jTFProductLocation.setEditable(false);

    }

    private void cleanForm() {
        jTFProductCode.setText("");
        jTFProductDescription.setText("");
        jBtnSave.setText("");
        jBtnClear.setText("");
        JTAObs.setText("");
        jRBActive.setText("");
        jRBInactive.setText("");
        jRBBota.setText("");
        jRBChinelo.setText("");
        jRBEsportivo.setText("");
        jRBMeias.setText("");
        jRBSapato.setText("");
        jRBTenis.setText("");
        jTFQTDInitial.setText("");
        jTFProductPrice.setText("");
    }

    public void showObject(String code, int type) {
        Product p = new Product();
        p = productController.findProduct(code);

        this.jTFProductDescription.setText(p.getProductDescription());
        this.jTFProductCode.setText(p.getProductCode());
        
        DateFormat dtFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedDate = dtFormat.format(p.getProductDtRegistration());
        
        this.jLDtRegistration.setText(formattedDate);
        this.jTFQTDInitial.setValue(p.getProductQuantity());
        this.jRBActive.setSelected(true);
        this.jTFProductLocation.setText(p.getProductLocation());
        this.jLabel4.setVisible(true);
        this.jLDtRegistration.setVisible(true);
        this.jTFProductPrice.setText(p.getProductPrice().toString());

         if(type == 0){
                 disableForm();
        } else {
            this.jTFProductCode.setEnabled(false);
            this.jBtnSave.setVisible(false);
            this.jBtnUpdate.setVisible(true);
            this.jTFQTDInitial.setEnabled(false);
        }

    }

    public void initComponentes() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jF = new javax.swing.JPanel();
        jTFProductCode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTFProductDescription = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTFProductPrice = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTAObs = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jRBTenis = new javax.swing.JRadioButton();
        jRBEsportivo = new javax.swing.JRadioButton();
        jRBSapato = new javax.swing.JRadioButton();
        jRBMeias = new javax.swing.JRadioButton();
        jRBChinelo = new javax.swing.JRadioButton();
        jRBBota = new javax.swing.JRadioButton();
        jTFProductLocation = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTFQTDInitial = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jRBActive = new javax.swing.JRadioButton();
        jRBInactive = new javax.swing.JRadioButton();
        jLDtRegistration = new javax.swing.JLabel();
        jBtnSave = new javax.swing.JButton();
        jBtnClear = new javax.swing.JButton();
        jBtnUpdate = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Código");

        jLabel3.setText("Descrição");

        jTFProductDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFProductDescriptionActionPerformed(evt);
            }
        });

        jLabel4.setText("Data Cadastro:");

        jLabel6.setText("Preço de Venda");

        jLabel5.setText("Localização Fisica");

        jTFProductPrice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        jTFProductPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFProductPriceActionPerformed(evt);
            }
        });

        jLabel8.setText("Observações");

        JTAObs.setColumns(20);
        JTAObs.setRows(5);
        jScrollPane1.setViewportView(JTAObs);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Categoria"));

        buttonGroup1.add(jRBTenis);
        jRBTenis.setSelected(true);
        jRBTenis.setText("Tênis");
        jRBTenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBTenisActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBEsportivo);
        jRBEsportivo.setText("Esportivo");
        jRBEsportivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBEsportivoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBSapato);
        jRBSapato.setText("Sapato");
        jRBSapato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBSapatoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBMeias);
        jRBMeias.setText("Meias");
        jRBMeias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBMeiasActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBChinelo);
        jRBChinelo.setText("Chinelo");
        jRBChinelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBChineloActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRBBota);
        jRBBota.setText("Bota");
        jRBBota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBBotaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jRBTenis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBEsportivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBSapato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBMeias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBChinelo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRBBota)
                .addGap(0, 7, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRBTenis)
                    .addComponent(jRBEsportivo)
                    .addComponent(jRBSapato)
                    .addComponent(jRBMeias)
                    .addComponent(jRBChinelo)
                    .addComponent(jRBBota)))
        );

        jLabel2.setText("Quantidade Inicial");

        jTFQTDInitial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jTFQTDInitial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFQTDInitialActionPerformed(evt);
            }
        });

        jLabel7.setText("Situação");

        buttonGroup2.add(jRBActive);
        jRBActive.setText("Ativo");

        buttonGroup2.add(jRBInactive);
        jRBInactive.setText("Inativo");
        jRBInactive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBInactiveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jFLayout = new javax.swing.GroupLayout(jF);
        jF.setLayout(jFLayout);
        jFLayout.setHorizontalGroup(
            jFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFLayout.createSequentialGroup()
                .addGroup(jFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jFLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBActive)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBInactive)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFLayout.createSequentialGroup()
                .addGroup(jFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jFLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1))
                    .addGroup(jFLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jFLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFProductLocation))
                            .addGroup(jFLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTFProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jFLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLDtRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFQTDInitial, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jFLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jTFProductDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(10, 10, 10))
        );
        jFLayout.setVerticalGroup(
            jFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFProductDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jTFProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jTFQTDInitial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLDtRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTFProductLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBActive)
                    .addComponent(jRBInactive)
                    .addComponent(jLabel7))
                .addGroup(jFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jFLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel8)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jFLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLDtRegistration, jLabel4});

        jTabbedPane1.addTab("Informações Gerais", jF);

        jBtnSave.setText("Salvar (F2)");
        jBtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSaveActionPerformed(evt);
            }
        });

        jBtnClear.setText("Limpar");
        jBtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClearActionPerformed(evt);
            }
        });

        jBtnUpdate.setText("Alterar");
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
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jBtnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnClear)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnSave)
                    .addComponent(jBtnClear)
                    .addComponent(jBtnUpdate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSaveActionPerformed

        Product p = new Product();
        ProductForm form = new ProductForm();

        p.setProductCode(this.jTFProductCode.getText());
        p.setProductDescription(this.jTFProductDescription.getText());
        p.setProductLocation(this.jTFProductLocation.getText());
        p.setProductCategory(productCategory);
       
        if(!this.jTFQTDInitial.getText().equals("")){
            p.setProductQTDInitial(Integer.valueOf(this.jTFQTDInitial.getText().replace(".", "")));
        }

           
        if(!this.jTFProductPrice.getText().equals("")){
        String price = this.jTFProductPrice.getText().replace(".", "");
            p.setProductPrice(Double.parseDouble(price.replaceAll(",", ".")));    
        }
            
            if (productController.uniqueCode(p.getProductCode()) == false) {
                JOptionPane.showMessageDialog(null, "Código já existente! Altere a informação do campo", "Informação Sistema", JOptionPane.INFORMATION_MESSAGE);
            } else{
            
             if (form.ProductValidation(p)) {
                productController.saveProduct(p);
                JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!", "Informação Sistema", JOptionPane.INFORMATION_MESSAGE);
            }
                
            }
            
            
        
    }//GEN-LAST:event_jBtnSaveActionPerformed

    private void jBtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClearActionPerformed
        cleanForm();
    }//GEN-LAST:event_jBtnClearActionPerformed

    private void jTFProductDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFProductDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFProductDescriptionActionPerformed

    private void jRBTenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBTenisActionPerformed
            productCategory = "Tênis";        
    }//GEN-LAST:event_jRBTenisActionPerformed

    private void jRBEsportivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBEsportivoActionPerformed
            productCategory = "Esportivo";
    }//GEN-LAST:event_jRBEsportivoActionPerformed

    private void jRBSapatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBSapatoActionPerformed
            productCategory = "Sapato";
    }//GEN-LAST:event_jRBSapatoActionPerformed

    private void jRBMeiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBMeiasActionPerformed
            productCategory = "Meias";
    }//GEN-LAST:event_jRBMeiasActionPerformed

    private void jRBChineloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBChineloActionPerformed
            productCategory = "Chinelo";
    }//GEN-LAST:event_jRBChineloActionPerformed

    private void jRBBotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBBotaActionPerformed
            productCategory = "Bota";
    }//GEN-LAST:event_jRBBotaActionPerformed

    private void jTFQTDInitialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFQTDInitialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFQTDInitialActionPerformed

    private void jBtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnUpdateActionPerformed
        Product p = new Product();

        p.setProductCode(this.jTFProductCode.getText());
        p.setProductDescription(this.jTFProductDescription.getText());
        p.setProductLocation(this.jTFProductLocation.getText());
        p.setProductCategory(productCategory);
        p.setProductQTDInitial(Integer.valueOf(this.jTFQTDInitial.getText()));
           
        if(!this.jTFProductPrice.getText().equals("")){
        p.setProductPrice(Double.parseDouble(jTFProductPrice.getText().replace("," , "." ).substring(3)));

        }
            
            
             if (form.ProductValidation(p)) {
                productController.updateProduct(p);
                JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!", "Informação Sistema", JOptionPane.INFORMATION_MESSAGE);
            }
                
            
    }//GEN-LAST:event_jBtnUpdateActionPerformed

    private void jRBInactiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBInactiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRBInactiveActionPerformed

    private void jTFProductPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFProductPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFProductPriceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea JTAObs;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jBtnClear;
    private javax.swing.JButton jBtnSave;
    private javax.swing.JButton jBtnUpdate;
    private javax.swing.JPanel jF;
    private javax.swing.JLabel jLDtRegistration;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRBActive;
    private javax.swing.JRadioButton jRBBota;
    private javax.swing.JRadioButton jRBChinelo;
    private javax.swing.JRadioButton jRBEsportivo;
    private javax.swing.JRadioButton jRBInactive;
    private javax.swing.JRadioButton jRBMeias;
    private javax.swing.JRadioButton jRBSapato;
    private javax.swing.JRadioButton jRBTenis;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFProductCode;
    private javax.swing.JTextField jTFProductDescription;
    private javax.swing.JTextField jTFProductLocation;
    private javax.swing.JFormattedTextField jTFProductPrice;
    private javax.swing.JFormattedTextField jTFQTDInitial;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
