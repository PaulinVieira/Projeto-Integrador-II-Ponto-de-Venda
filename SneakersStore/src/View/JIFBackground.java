/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author paulo
 */
public class JIFBackground extends javax.swing.JInternalFrame {

    /**
     * Creates new form JInternalFrameBackground
     */
    public JIFBackground() {
        super(null, false, false, false);
        initComponents();
        this.moveToBack();
        
        try {
            background = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("img--background.png"), "img--background.png"));           
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar a imagem de fundo, contate o suporte", "Erro - Imagem fundo", 0);
        }
    }
        public void paint(Graphics Background){
    
            Background.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

protected static Image background;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
