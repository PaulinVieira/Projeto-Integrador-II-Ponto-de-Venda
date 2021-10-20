package Controller;

import Dao.ConnectionDatabase;
import Model.Sale;
import Model.ItemsSale;
import Model.Product;
import Model.SyntheticInformation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class SaleController {

    public void updateLastBuy(Sale s) {

        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("update Clients set clientDtLastBuy = CURRENT_TIMESTAMP() where clientCPF = ?");

            stmt.setString(1, s.getC().getClientCPF());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SaleController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    public void saveSale(Sale s) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("insert into sale (clientCPF, payment, vlTotal, vlDesc, postcode, address, district, state, city, date) values(?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP())",
                    Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, s.getC().getClientCPF());
            stmt.setString(2, s.getPayment());
            stmt.setDouble(3, s.getVlTotal());
            stmt.setDouble(4, s.getVlDesc());
            stmt.setString(5, s.getC().getClientPostcode());
            stmt.setString(6, s.getC().getClientAddress());
            stmt.setString(7, s.getC().getClientDistrict());
            stmt.setString(8, s.getC().getClientState());
            stmt.setString(9, s.getC().getClientCity());
            stmt.executeUpdate();

            updateLastBuy(s);

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idSale = generatedKeys.getInt(1);
                s.getItemsSale().forEach(item -> salvarItens(item, idSale));
            }

            JOptionPane.showMessageDialog(null, "Venda salva com sucesso!!", "Informação sistema", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(SaleController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    public void salvarItens(ItemsSale itemsSale, int idSale) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement("insert into itenssale (idSale, productCode, quantity, vlUnit) values(?,?,?,?)");
            stmt.setInt(1, idSale);
            stmt.setString(2, itemsSale.getP().getProductCode());
            stmt.setInt(3, itemsSale.getQuantidade());
            stmt.setDouble(4, itemsSale.getVlTUnit());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SaleController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    public SyntheticInformation getInfoSpec(String code, String firstDate, String lastDate) {

        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        SyntheticInformation s = new SyntheticInformation();
        
        ProductController productController = new ProductController();
        Product p = productController.findProduct(code);
        
        try {
            
            s.setP(p);
            
            stmt = con.prepareStatement(
                    "select SUM(quantity)  AS \"totalQtd\", COUNT(*) AS \"totalReg\" from itenssale where productCode = \'" + code + "\' between \'" + firstDate + "\' and \'" + lastDate + "\'");
            rs = stmt.executeQuery();

            if (rs.next()) {

                int quantity = rs.getInt("totalQtd");
                int totalRes = rs.getInt("totalReg");
                
                s.setSaleQtd(quantity);
                
                if(quantity > 0){
                    s.setSalesAverage(quantity/totalRes);
                }
                
            }
            
            return s;

        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado. Impossível continuar.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            ConnectionDatabase.closeConnection(con, stmt, rs);

        }
        return s;
    }
}
