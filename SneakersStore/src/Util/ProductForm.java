package Util;

import Model.Product;
import View.JIFProducts;
import javax.swing.JOptionPane;

public class ProductForm {
            
    public boolean ProductValidation(Product p) {
        //Tentar incluir uma Design Patern para diminuir a quantidade de IF
        //para uma boa manutenção.
        
        if (p.getProductCode() == null || p.getProductCode().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o código do produto.");
            return false;
        }
        if (p.getProductPrice() == null || p.getProductPrice() < 0.) {
            JOptionPane.showMessageDialog(null, "Preencha o preço do produto.");
            
            return false;
        }
        if (p.getProductDescription().isEmpty() || p.getProductDescription().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha a descrição do produto.");
            
            return false;
        }
        if (p.getProductLocation().isEmpty() || p.getProductLocation().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha a localização física do produto.");
            
            return false;
        }
        if (p.getProductSize().isEmpty() || p.getProductSize().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o tamanho do produto.");
            
            return false;
        }
        
        return true;
    }

}
