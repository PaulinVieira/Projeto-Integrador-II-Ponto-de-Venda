package Controller;

import Dao.ConnectionDatabase;
import Model.Inventory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class InventoryController {

 public void createMovi(Inventory i) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
       
        try {            
            stmt = con.prepareStatement(
                    "insert into inventory (productCode, quantity) "
                            + "values (?, ?);");
            
            stmt.setString(1, i.getProductCode());
            stmt.setInt(2, i.getQuantity());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado ao salvar o produto. Impossível continuar.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }
 
  public void updateMovi(Inventory i) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
       
        try {            
            stmt = con.prepareStatement(
                    "update inventory set quantity = quantity + ? where productCode = ?");
            
            stmt.setInt(1, i.getQuantity());
            stmt.setString(2, i.getProductCode());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado ao salvar o produto. Impossível continuar.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }  
}
