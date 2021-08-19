package Controller;

import Dao.ConnectionDatabase;
import Model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class InventoryController {

 public void createMovi(Product p) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
       
        try {            
            stmt = con.prepareStatement(
                    "insert into inventory ("
                    + "productCode, quantity, productQuantityAvailable)"
                    + "values (?, ?, ?);");
            
            stmt.setString(1, p.getProductCode());
            stmt.setInt(2, 0);
            stmt.setInt(3, 0);
            stmt.executeUpdate();
        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado ao salvar o produto. Impossível continuar.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }
 
 public void firstMovi(Product p) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
       
        try {            
            stmt = con.prepareStatement(
                    "insert into inventory ("
                    + "productCode, quantity, productQuantityAvailable)"
                    + "values (?, ?, ?);");
            
            stmt.setString(1, p.getProductCode());
            stmt.setInt(2, 0);
            stmt.setInt(3, 0);
            stmt.executeUpdate();
        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado ao salvar amovi. Impossível continuar.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    
}
