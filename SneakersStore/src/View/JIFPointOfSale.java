package View;

import Controller.ClientController;
import Controller.ProductController;
import Model.Client;
import Model.ItemsBuy;
import Model.Product;
import Util.PositionForm;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lombok.Data;

@Data
public class JIFPointOfSale extends javax.swing.JInternalFrame {

    PositionForm form = new PositionForm();
    Client c;
    Product p;
    JIFSearchProduct jifSearchProduct;
    JIFSearchClient jifSearchClient;
    ClientController clientController = new ClientController();
    ProductController productController = new ProductController();
    DecimalFormat df = new DecimalFormat("###,###.00");
    ArrayList<ItemsBuy> listProduct = new ArrayList<>();

    public JIFPointOfSale() {
        initComponents();
        jTFTotalItem.setEditable(false);
        jLProductName.setText("");
        jLVlTUnit.setText("");
        jLVlDesc.setText("");
        jLTotal.setText("");

    }

    private void cleanForm() {
        jLProductName.setText("");
        jTFProductCode.setText("Informe o código do produto");
        jTFVlDesc.setText("0");
        jTFTotalItem.setText("0");
        jTFVlUnit.setText("0");
        jTFQtd.setText("0");
    }

    private void addRowToTable(Product p) {
        if (!jLProductName.getText().equals("")) {

            ItemsBuy iBuy = new ItemsBuy();

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

            Object rowData[] = new Object[5];

            rowData[0] = p.getProductCode();
            rowData[1] = p.getProductDescription();
            rowData[2] = jTFQtd.getText();
            rowData[3] = jTFVlDesc.getText();
            rowData[4] = jTFTotalItem.getText();

            model.addRow(rowData);

            iBuy.setP(p);
            iBuy.setQuantidade(Integer.valueOf(jTFQtd.getText()));
            iBuy.setVlDesc(Double.valueOf(formatString(jTFVlDesc.getText())));

            Double vlTUnit = Double.valueOf(formatString(jTFVlUnit.getText())) * Integer.valueOf(jTFQtd.getText());

            iBuy.setVlTUnit(vlTUnit);
            iBuy.setVlTotal(Double.valueOf(formatString(jTFTotalItem.getText())));

            listProduct.add(iBuy);

            cleanForm();
            attValues();
        } else {
            JOptionPane.showMessageDialog(null, "Pesquise um produto antes!!", "Informação sistema", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void attValues() {

        Double subTotal = 0.;
        Double vlDesc = 0.;
        Double vlTUnit = 0.;

        for (ItemsBuy listProduct1 : listProduct) {

            subTotal += listProduct1.getVlTotal();
            vlDesc += listProduct1.getVlDesc();
            vlTUnit += listProduct1.getVlTUnit();

        }

        jLVlTUnit.setText(df.format(vlTUnit));
        jLVlDesc.setText(df.format(vlDesc));
        jLTotal.setText(df.format(subTotal));

    }

    void selectedProduct(String code) {

        p = productController.findProduct(code);
        showObjectP(p);

    }

    private String formatString(String num) {
        String formated = num.replaceAll("\\.", "").replaceAll(",", ".");

        return formated;
    }

    private void updateFinalValue() {

        Double vlUnit = Double.valueOf(formatString(jTFVlUnit.getText()));
        Integer qtd = Integer.valueOf(jTFQtd.getText());
        Double desc = Double.valueOf(formatString(jTFVlDesc.getText()));

        Double vlTotalIt = (vlUnit * qtd) - desc;
        if (vlTotalIt <= 0) {
            jTFTotalItem.setText("0");
        } else {
            jTFTotalItem.setText(df.format(vlTotalIt));
        }
    }

    private void showObjectC(Client c) {
        jTFClientCPF.setText(c.getClientCPF());
        jLClientEmail.setText(c.getClientEmail());
        jLClientName.setText(c.getClientName());
    }

    public void showObjectP(Product p) {
        jLProductName.setText(p.getProductDescription());
        jTFVlUnit.setText(df.format(p.getProductPrice()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLProductName = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTFClientCPF = new javax.swing.JFormattedTextField();
        jLClientEmail = new javax.swing.JLabel();
        jLClientName = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jBtnFinish = new javax.swing.JButton();
        jBtnClear = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLTotal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLVlDesc = new javax.swing.JLabel();
        jLVlTUnit = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTFProductCode = new javax.swing.JTextField();
        jTFTotalItem = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTFQtd = new javax.swing.JFormattedTextField();
        jTFVlUnit = new javax.swing.JFormattedTextField();
        jTFVlDesc = new javax.swing.JFormattedTextField();
        jBtnAdd = new javax.swing.JButton();
        jSPPreview = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLProductName.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        try {
            jTFClientCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTFClientCPF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFClientCPFFocusLost(evt);
            }
        });
        jTFClientCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFClientCPFActionPerformed(evt);
            }
        });

        jLClientEmail.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLClientName.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel7.setText("CPF do Cliente");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLClientName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFClientCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLClientEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFClientCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jLClientName, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLClientEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jBtnFinish.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jBtnFinish.setText("Finalizar Compra");
        jBtnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFinishActionPerformed(evt);
            }
        });

        jBtnClear.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jBtnClear.setText("Limpar");
        jBtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClearActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Total a Pagar");

        jLTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLTotal.setText("jLabel7");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Desconto");

        jLVlDesc.setText("jLabel7");

        jLVlTUnit.setText("jLabel7");

        jLabel4.setText("R$");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Total s/ Desconto");

        jLabel5.setText("R$");

        jLabel6.setText("R$");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLVlTUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLVlDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(14, 14, 14)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 21, Short.MAX_VALUE))
                    .addComponent(jLTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLVlTUnit))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLVlDesc)
                    .addComponent(jLabel6)
                    .addComponent(jLTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTFProductCode.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTFProductCode.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTFProductCode.setText("Informe o código do produto");
        jTFProductCode.setToolTipText("Código do Produto");
        jTFProductCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTFProductCodeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFProductCodeFocusLost(evt);
            }
        });
        jTFProductCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFProductCodeActionPerformed(evt);
            }
        });
        jTFProductCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFProductCodeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFProductCodeKeyReleased(evt);
            }
        });

        jTFTotalItem.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTFTotalItem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTFTotalItem.setText("0");
        jTFTotalItem.setToolTipText("Valor Unitário");
        jTFTotalItem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTFTotalItemCaretUpdate(evt);
            }
        });
        jTFTotalItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFTotalItemActionPerformed(evt);
            }
        });

        jLabel10.setText("Vl Unitário");

        jLabel11.setText("Quantidade");

        jLabel12.setText("Desconto");

        jLabel13.setText("Sub - Total");

        jTFQtd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jTFQtd.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTFQtd.setText("0");
        jTFQtd.setToolTipText("");
        jTFQtd.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTFQtdCaretUpdate(evt);
            }
        });

        jTFVlUnit.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        jTFVlUnit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTFVlUnit.setText("0");
        jTFVlUnit.setToolTipText("");
        jTFVlUnit.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTFVlUnit.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTFVlUnitCaretUpdate(evt);
            }
        });

        jTFVlDesc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        jTFVlDesc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTFVlDesc.setText("0");
        jTFVlDesc.setToolTipText("");
        jTFVlDesc.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTFVlDesc.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTFVlDescCaretUpdate(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTFVlDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFTotalItem, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(133, 133, 133))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jTFQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFVlUnit)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel13))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTFProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTFProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTFVlUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFTotalItem, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFVlDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jBtnAdd.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jBtnAdd.setText("Adicionar");
        jBtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddActionPerformed(evt);
            }
        });

        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Produto", "Nome Produto", "Quantidade", "Desconto total", "Sub - Total"
            }
        ));
        jSPPreview.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLProductName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(336, 336, 336))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jBtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jSPPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 971, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jSPPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnClearActionPerformed

    private void jBtnFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFinishActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnFinishActionPerformed

    private void jTFProductCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFProductCodeKeyPressed

    }//GEN-LAST:event_jTFProductCodeKeyPressed

    private void jTFTotalItemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTFTotalItemCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFTotalItemCaretUpdate

    private void jTFTotalItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFTotalItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFTotalItemActionPerformed

    private void jTFProductCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFProductCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFProductCodeActionPerformed

    private void jTFProductCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFProductCodeKeyReleased

    }//GEN-LAST:event_jTFProductCodeKeyReleased

    private void jTFProductCodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFProductCodeFocusGained

    }//GEN-LAST:event_jTFProductCodeFocusGained

    private void jTFProductCodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFProductCodeFocusLost

        try {
            if (!jTFProductCode.getText().equals("") && !jTFProductCode.getText().equals("Informe o código do produto")) {
                p = productController.findProduct(jTFProductCode.getText());
                showObjectP(p);
            }

        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTFProductCodeFocusLost

    private void jTFQtdCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTFQtdCaretUpdate
        if (jTFQtd.getText().equals("")) {
            return;
        }
        updateFinalValue();
    }//GEN-LAST:event_jTFQtdCaretUpdate

    private void jTFVlUnitCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTFVlUnitCaretUpdate
        if (jTFVlUnit.getText().equals("")) {
            return;
        }
        updateFinalValue();
    }//GEN-LAST:event_jTFVlUnitCaretUpdate

    private void jTFVlDescCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTFVlDescCaretUpdate
        if (jTFVlDesc.getText().equals("")) {
            return;
        }

        updateFinalValue();
    }//GEN-LAST:event_jTFVlDescCaretUpdate

    private void jBtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddActionPerformed

        if (jTFTotalItem.getText().equals("0")) {
            JOptionPane.showMessageDialog(null, "Desconto total atingido!! Redigite os valores.", "Informação sistema", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        p = new Product();

        p.setProductCode(jTFProductCode.getText());
        p.setProductDescription(jLProductName.getText());

        try {
            addRowToTable(p);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro não documentado ao adicionar!!", "Informação sistema", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e);
        }


    }//GEN-LAST:event_jBtnAddActionPerformed

    private void jTFClientCPFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFClientCPFFocusLost
        if (!jTFClientCPF.getText().contains(" ")) {
            try {
                c = clientController.findClient(jTFClientCPF.getText());
                showObjectC(c);
            } catch (Exception e) {
            }

        }

    }//GEN-LAST:event_jTFClientCPFFocusLost

    private void jTFClientCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFClientCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFClientCPFActionPerformed

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
            java.util.logging.Logger.getLogger(JIFPointOfSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JIFPointOfSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JIFPointOfSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JIFPointOfSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JIFPointOfSale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAdd;
    private javax.swing.JButton jBtnClear;
    private javax.swing.JButton jBtnFinish;
    private javax.swing.JLabel jLClientEmail;
    private javax.swing.JLabel jLClientName;
    private javax.swing.JLabel jLProductName;
    private javax.swing.JLabel jLTotal;
    private javax.swing.JLabel jLVlDesc;
    private javax.swing.JLabel jLVlTUnit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jSPPreview;
    private javax.swing.JFormattedTextField jTFClientCPF;
    private javax.swing.JTextField jTFProductCode;
    private javax.swing.JFormattedTextField jTFQtd;
    private javax.swing.JTextField jTFTotalItem;
    private javax.swing.JFormattedTextField jTFVlDesc;
    private javax.swing.JFormattedTextField jTFVlUnit;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
