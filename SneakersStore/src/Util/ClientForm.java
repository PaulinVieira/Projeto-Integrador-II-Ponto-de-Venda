package Util;

import Model.Client;
import javax.swing.JOptionPane;


public class ClientForm {
    
        EmailValidation emailValidation = new EmailValidation();
    
      public boolean ClientValidation(Client c){
          //Tentar incluir uma Design Patern para diminuir a quantidade de IF
          //para uma boa manutenção.
          
          if(c.getClientCode().isEmpty() || c.getClientCode().equals("")){
              JOptionPane.showMessageDialog(null, "Preencha o código do cliente.");
          return false; 
          }
          //incluir validação para CPF ÚNICO -> data 13/08/2021, prazo 15/08/2021
          if(c.getClientCPF().contains(" ")){
              JOptionPane.showMessageDialog(null, "Informe um CPF válido.");
          return false; 
          }
          if(c.getClientName().isEmpty() || c.getClientName().equals("")){
              JOptionPane.showMessageDialog(null, "Preencha o nome do cliente.");
          return false;
          }
          if(c.getClientEmail().isEmpty() || c.getClientEmail().equals("")){
              JOptionPane.showMessageDialog(null, "Preencha o email do cliente.");
          return false;
          }
          if(emailValidation.isValidEmail(c.getClientEmail()) == false){
              JOptionPane.showMessageDialog(null, "Preencha um email válido.");
          return false;
          }
          if(c.getClientEmail().isEmpty() || c.getClientEmail().equals("")){
              JOptionPane.showMessageDialog(null, "Preencha o email do cliente.");
          return false;
          }
          if(c.getClientPostcode().isEmpty() || c.getClientPostcode().equals("")){
              JOptionPane.showMessageDialog(null, "Preencha o CEP do cliente.");
          return false; 
          }
           if(c.getClientAddress().isEmpty() || c.getClientAddress().equals("")){
              JOptionPane.showMessageDialog(null, "Preencha o endereço do cliente.");
          return false;
          }          
           if(c.getClientState().isEmpty() || c.getClientCode().equals("")){
              JOptionPane.showMessageDialog(null, "Preencha o estado do cliente.");
           return false; 
          }
          if(c.getClientDistrict().isEmpty() || c.getClientDistrict().equals("")){
              JOptionPane.showMessageDialog(null, "Preencha o bairro do cliente.");
          return false; 
          }         
          if(c.getClientCity().isEmpty() || c.getClientCity().equals("")){
              JOptionPane.showMessageDialog(null, "Preencha a cidade do cliente.");
             return false; 
          }           
          
      return true;
      }
    
}
