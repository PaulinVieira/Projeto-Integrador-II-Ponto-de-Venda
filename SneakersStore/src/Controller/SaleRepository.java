package Controller;

import Dao.ConnectionDatabase;
import Model.Sale;
import Model.ItemsSale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SaleRepository {

    public void saveBuy(Sale s) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("insert into sale (clientCPF, formaPagamento, vlTotal, vlDesc, postcode, address, district, state, city, date) values(?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP())", 
            Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, s.getC().getClientCPF());
            stmt.setString(2, "1");
            stmt.setDouble(3, s.getVlTotal());
            stmt.setDouble(4, s.getVlDesc());
            stmt.setString(5, s.getC().getClientPostcode());
            stmt.setString(6, s.getC().getClientAddress());
            stmt.setString(7, s.getC().getClientDistrict());
            stmt.setString(8, s.getC().getClientState());
            stmt.setString(9, s.getC().getClientCity());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idSale = generatedKeys.getInt(1);
                s.getItemsSale().forEach(item -> salvarItens(item, idSale));
            }

        } catch (SQLException ex) {
            Logger.getLogger(SaleRepository.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SaleRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }
}
