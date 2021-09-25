package Controller;

import Dao.ConnectionDatabase;
import Model.Inventory;
import Model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

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

            stmt = con.prepareStatement(
                    "update products set productQuantityAvailable = \'" + i.getQuantity() + "\'"
                    + " where productCode = \'" + i.getProductCode() + "\'");
            stmt.executeUpdate();

        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado. Impossível continuar.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    public void addMovi(Inventory i) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(
                    "update inventory set quantity = quantity + ? where productCode = ?");

            stmt.setInt(1, i.getQuantity());
            stmt.setString(2, i.getProductCode());

            stmt.executeUpdate();

            stmt = con.prepareStatement(
                    "update products set productQuantityAvailable = productQuantityAvailable + " + i.getQuantity()
                    + " where productCode = \'" + i.getProductCode() + "\'");
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Quantidade adicionada:" + i.getQuantity(), "Informação do Sistema", INFORMATION_MESSAGE);
        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado. Impossível continuar.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    public boolean checkMovi(Inventory i) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(
                    "select quantity from inventory where productCode = \'" + i.getProductCode() + "\'");
            rs = stmt.executeQuery();

            if (rs.next()) {

                int quantity = rs.getInt("quantity");

                if (quantity == 0) {

                    JOptionPane.showMessageDialog(null, "Impossível continuar pois o estoque negativo.", "Informação do Sistema", INFORMATION_MESSAGE);
                    return false;
                } else if ((quantity - i.getQuantity()) < 0) {
                    JOptionPane.showMessageDialog(null, "Impossível continuar pois o estoque negativo.", "Informação do Sistema", INFORMATION_MESSAGE);
                    return false;
                }

            }

        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado. Impossível continuar.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            ConnectionDatabase.closeConnection(con, stmt, rs);
        }
        return true;
    }

    public void subtractMovi(Inventory i) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        if (checkMovi(i)) {

            try {
                stmt = con.prepareStatement(
                        "update inventory set quantity = quantity - ? where productCode = ?");

                stmt.setInt(1, i.getQuantity());
                stmt.setString(2, i.getProductCode());

                stmt.executeUpdate();
                
                stmt = con.prepareStatement(
                    "update products set productQuantityAvailable = productQuantityAvailable - " + i.getQuantity()
                    + " where productCode = \'" + i.getProductCode() + "\'");
            stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Quantidade baixada:" + i.getQuantity(), "Informação do Sistema", INFORMATION_MESSAGE);

            } catch (SQLException ex) {

                String err = "Ocorreu um erro não documentado. Impossível continuar.\nDetalhes técnicos: " + ex;
                JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
                Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);

            } finally {

                ConnectionDatabase.closeConnection(con, stmt);
            }
        }
    }

}
