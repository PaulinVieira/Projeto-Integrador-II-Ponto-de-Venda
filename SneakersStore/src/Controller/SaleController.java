package Controller;

import Dao.ConnectionDatabase;
import Model.AnalyticalInformation;
import Model.Client;
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
                    "select SUM(quantity)  AS \"totalQtd\", COUNT(*) AS \"totalReg\" from ("
                    + "SELECT "
                    + "P.idSale, V.quantity, P.date from "
                    + "itenssale V, sale P "
                    + "where (v.idSale = P.idSale) and (date between \'" + firstDate + "\' and \'" + lastDate + "\') "
                    + "and productCode = \'" + code + "\') as TOTAL");
            rs = stmt.executeQuery();

            if (rs.next()) {

                int quantity = rs.getInt("totalQtd");
                int totalRes = rs.getInt("totalReg");

                s.setSaleQtd(quantity);

                if (quantity > 0) {
                    s.setSalesAverage(quantity / totalRes);
                } else {
                    String msg = "Não há dados com os parâmetros informados!!";
                    JOptionPane.showMessageDialog(null, msg, "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                    return null;
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

    public ArrayList<SyntheticInformation> getInfoSpecCate(String cate, String firstDate, String lastDate) {

        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ResultSet rs1 = null;

        ArrayList<SyntheticInformation> aSyntheticInformation = new ArrayList<>();

        ProductController productController = new ProductController();

        try {

            stmt = con.prepareStatement(
                    "select distinct productCode from ("
                    + "SELECT "
                    + "P.idSale, V.quantity, P.date, D.productCategory, V.productCode from "
                    + "itenssale V, sale P, products D "
                    + "where (v.idSale = P.idSale) and (date between \'" + firstDate + "\' and \'" + lastDate + "\') "
                    + "and (v.productCode = D.productCode) "
                    + "and (D.productCategory = \'" + cate + "\') ) as TOTAL");
            rs1 = stmt.executeQuery();

                while (rs1.next()) {

                    SyntheticInformation s = new SyntheticInformation();

                    s.setP(productController.findProduct(rs1.getString("productCode")));

                    stmt = con.prepareStatement(
                            "select SUM(quantity) AS \"totalQtd\", COUNT(*) AS \"totalReg\" from ("
                            + "SELECT "
                            + "P.idSale, V.quantity, P.date, D.productCategory, V.productCode from "
                            + "itenssale V, sale P, products D "
                            + "where (V.idSale = P.idSale) and (date between \'" + firstDate + "\' and \'" + lastDate + "\') "
                            + "and (v.productCode = D.productCode) and "
                            + "(v.productCode = \'" + rs1.getString("productCode") + "\') ) as total ");
                    rs = stmt.executeQuery();

                    if (rs.next()) {

                        double quantity = rs.getInt("totalQtd");
                        double totalRes = rs.getInt("totalReg");

                        s.setSaleQtd(quantity);

                        if (quantity > 0) {
                            s.setSalesAverage(quantity / totalRes);
                        }
                        aSyntheticInformation.add(s);
                    }
                    
                   
                }
                
                if(aSyntheticInformation.isEmpty())
                    JOptionPane.showMessageDialog(null, "Não há dados com o parâmetro informado!!", "Informação sistema", JOptionPane.INFORMATION_MESSAGE);

                 
                return aSyntheticInformation;

        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado. Impossível continuar.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            ConnectionDatabase.closeConnection(con, stmt, rs, rs1);

        }
        return aSyntheticInformation;
    }

    public ArrayList<SyntheticInformation> getInfoSpecLoca(String loca, String firstDate, String lastDate) {

        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ResultSet rs1 = null;

        ArrayList<SyntheticInformation> aSyntheticInformation = new ArrayList<>();

        ProductController productController = new ProductController();

        try {

            stmt = con.prepareStatement(
                    "select distinct productCode from ("
                    + "SELECT "
                    + "P.idSale, V.quantity, P.date, D.productCategory, V.productCode from "
                    + "itenssale V, sale P, products D "
                    + "where (v.idSale = P.idSale) and (date between \'" + firstDate + "\' and \'" + lastDate + "\') "
                    + "and (v.productCode = D.productCode) "
                    + "and (D.productLocation = \'" + loca + "\') ) as TOTAL");
            rs1 = stmt.executeQuery();
            
                while (rs1.next()) {

                    SyntheticInformation s = new SyntheticInformation();

                    s.setP(productController.findProduct(rs1.getString("productCode")));

                    stmt = con.prepareStatement(
                            "select SUM(quantity) AS \"totalQtd\", COUNT(*) AS \"totalReg\" from ("
                            + "SELECT "
                            + "P.idSale, V.quantity, P.date, D.productCategory, V.productCode from "
                            + "itenssale V, sale P, products D "
                            + "where (V.idSale = P.idSale) and (date between \'" + firstDate + "\' and \'" + lastDate + "\') "
                            + "and (v.productCode = D.productCode) and "
                            + "(v.productCode = \'" + rs1.getString("productCode") + "\') ) as total ");
                    rs = stmt.executeQuery();

                    if (rs.next()) {

                        double quantity = rs.getInt("totalQtd");
                        double totalRes = rs.getInt("totalReg");

                        s.setSaleQtd(quantity);

                        if (quantity > 0) {
                            s.setSalesAverage(quantity / totalRes);
                        }
                        
                        aSyntheticInformation.add(s);
                    }
                }
                
                if(aSyntheticInformation.isEmpty())
                    JOptionPane.showMessageDialog(null, "Não há dados com o parâmetro informado!!", "Informação sistema", JOptionPane.INFORMATION_MESSAGE);


            return aSyntheticInformation;

        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado. Impossível continuar.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            ConnectionDatabase.closeConnection(con, stmt, rs, rs1);

        }
        return aSyntheticInformation;
    }
    
    
    public ArrayList<AnalyticalInformation> getAnalyticalInformationCl(String cpf, String firstDate, String lastDate) {

        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<AnalyticalInformation> analyticalInformation = new ArrayList<>();
        ClientController clientController = new ClientController();

        try {

            stmt = con.prepareStatement(
                    "select * from ("
                    + "SELECT SUM(quantity)  AS \"totalQtd\", P.payment, P.vlTotal, P.vlDesc from "
                    + "itenssale V, sale P where (v.idSale = P.idSale) " +"and "
                    + "(date between  \'" + firstDate + "\' and \'" + lastDate + "\') and P.clientCPF = \'" + cpf + "\') as TOTAL");
            
            
            rs = stmt.executeQuery();
            
            Client c = clientController.findClient(cpf);

                while (rs.next()) {
                    
                    Sale s = new Sale ();
                    
                    s.setC(c);
                    s.setPayment(rs.getString("payment"));
                    s.setVlDesc(rs.getDouble("vlDesc"));
                    s.setVlTotal(rs.getDouble("vlTotal"));

                    AnalyticalInformation analytical = new AnalyticalInformation();
                    analytical.setS(s);
                    analytical.setSaleQtd(rs.getDouble("totalQtd"));

                    analyticalInformation.add(analytical);
                    
                    }
                
                
                if(analyticalInformation.isEmpty())
                    JOptionPane.showMessageDialog(null, "Não há dados com o parâmetro informado!!", "Informação sistema", JOptionPane.INFORMATION_MESSAGE);

                 
                return analyticalInformation;

        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado. Impossível continuar.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            ConnectionDatabase.closeConnection(con, stmt, rs, rs);

        }
        return analyticalInformation;
    }

}
