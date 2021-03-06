package Controller;

import Dao.ConnectionDatabase;
import Model.Inventory;
import Model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class ProductController {

    public void saveProduct(Product p) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            InventoryController inventory = new InventoryController();
            stmt = con.prepareStatement(
                    "insert into Products ("
                    + "productCode, productCategory, productDescription, productActive,"
                    + "productLocation, productPrice, productSize, productObs, productDtRegistration)"
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP());");

            stmt.setString(1, p.getProductCode());
            stmt.setString(2, p.getProductCategory());
            stmt.setString(3, p.getProductDescription());
            stmt.setString(4, "S");
            stmt.setString(5, p.getProductLocation());
            stmt.setDouble(6, p.getProductPrice());
            stmt.setString(7, p.getProductSize());
            stmt.setString(8, p.getProductObs());
            
            stmt.executeUpdate();

            Inventory i = new Inventory();

            i.setProductCode(p.getProductCode());
            i.setQuantity(p.getProductQTDInitial());

            inventory.createMovi(i);
        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado ao salvar o produto. Impossível continuar.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            ConnectionDatabase.closeConnection(con, stmt);
        }
    }
    public void updateProduct(Product p) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(
                    "update products set productCategory = ?, productDescription = ?, "
                    + "productActive = ?, productLocation = ?, productPrice = ?, productSize = ?, productObs = ? where productCode= ? ");

            stmt.setString(1, p.getProductCategory());
            stmt.setString(2, p.getProductDescription());
            //implementar inativar produto/cliente
            stmt.setString(3, "S");
            stmt.setString(4, p.getProductLocation());
            stmt.setDouble(5, p.getProductPrice());
            stmt.setString(6, p.getProductSize());
            stmt.setString(7, p.getProductObs());
            stmt.setString(8, p.getProductCode());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado ao salvar o produto. Impossível continuar.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    public void deleteByCode(String code) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("delete from products where productCode= \'" + code + "\'");

            stmt.executeUpdate();

        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado. Impossível concluir a operação.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    //métodos de pesquisa
    public boolean uniqueCode(String code) {
        boolean uniqueCode = true;
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement("SELECT id FROM products WHERE productCode = \'" + code + "\'");

            rs = stmt.executeQuery();

            if (rs.next()) {
                uniqueCode = false;
            }

        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado. Impossível concluir a operação.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            ConnectionDatabase.closeConnection(con, stmt, rs);
        }
        return uniqueCode;
    }

    public Product findProduct(String code) {

        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Product p = new Product();

        try {

            stmt = con.prepareStatement("SELECT * FROM products WHERE productCode = \'" + code + "\'");
            rs = stmt.executeQuery();

            if (rs.next()) {
                p.setProductCode(rs.getString("productCode"));
                p.setProductCategory(rs.getString("productCategory"));
                p.setProductDescription(rs.getString("productDescription"));
                p.setProductLocation(rs.getString("productLocation"));
                p.setProductPrice(rs.getDouble("productPrice"));
                p.setProductQuantity(rs.getInt("productQuantityAvailable"));
                p.setProductSize(rs.getString("productSize"));
                p.setProductDtRegistration(rs.getTimestamp("productDtRegistration"));
                p.setProductObs(rs.getString("productObs"));
                
            } else {
                JOptionPane.showMessageDialog(null, "Código de produto não existente!!", "Informação sistema", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado. Impossível concluir a operação.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            ConnectionDatabase.closeConnection(con, stmt, rs);
        }
        return p;
    }

    public ArrayList<Product> findByDescription(String description) {

        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Product> listProducts = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT * FROM products WHERE productDescription LIKE \'%" + description + "%\' order by productDescription");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Product p = new Product();

                p.setProductCode(rs.getString("productCode"));
                p.setProductCategory(rs.getString("productCategory"));
                p.setProductDescription(rs.getString("productDescription"));
                p.setProductQuantity(rs.getInt("productQuantityAvailable"));
                p.setProductLocation(rs.getString("productLocation"));
                p.setProductPrice(rs.getDouble("productPrice"));
                p.setProductDtRegistration(rs.getTimestamp("productDtRegistration"));

                listProducts.add(p);

            }
        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado. Impossível concluir a operação.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            ConnectionDatabase.closeConnection(con, stmt, rs);
        }
        return listProducts;
    }

    public ArrayList<Product> findByCode(String code) {

        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Product> listProducts = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT * FROM products WHERE productCode LIKE \'%" + code + "%\' order by productCode");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Product p = new Product();

                p.setProductCode(rs.getString("productCode"));
                p.setProductCategory(rs.getString("productCategory"));
                p.setProductDescription(rs.getString("productDescription"));
                p.setProductQuantity(rs.getInt("productQuantityAvailable"));
                p.setProductLocation(rs.getString("productLocation"));
                p.setProductPrice(rs.getDouble("productPrice"));
                p.setProductDtRegistration(rs.getTimestamp("productDtRegistration"));

                listProducts.add(p);

            }
        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado. Impossível concluir a operação.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            ConnectionDatabase.closeConnection(con, stmt, rs);
        }
        return listProducts;
    }

    public ArrayList<Product> findByCategory(String category) {

        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Product> listProducts = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT * FROM products WHERE productCategory LIKE \'%" + category + "%\' order by productCategory");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Product p = new Product();

                p.setProductCode(rs.getString("productCode"));
                p.setProductCategory(rs.getString("productCategory"));
                p.setProductDescription(rs.getString("productDescription"));
                p.setProductQuantity(rs.getInt("productQuantityAvailable"));
                p.setProductLocation(rs.getString("productLocation"));
                p.setProductPrice(rs.getDouble("productPrice"));
                p.setProductDtRegistration(rs.getTimestamp("productDtRegistration"));

                listProducts.add(p);

            }
        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado. Impossível concluir a operação.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            ConnectionDatabase.closeConnection(con, stmt, rs);
        }
        return listProducts;
    }

    public ArrayList<Product> findByLocation(String location) {

        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Product> listProducts = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT * FROM products WHERE productLocation LIKE \'%" + location + "%\' order by productLocation");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Product p = new Product();

                p.setProductCode(rs.getString("productCode"));
                p.setProductCategory(rs.getString("productCategory"));
                p.setProductDescription(rs.getString("productDescription"));
                p.setProductQuantity(rs.getInt("productQuantityAvailable"));
                p.setProductLocation(rs.getString("productLocation"));
                p.setProductPrice(rs.getDouble("productPrice"));
                p.setProductDtRegistration(rs.getTimestamp("productDtRegistration"));

                listProducts.add(p);

            }
        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado. Impossível concluir a operação.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            ConnectionDatabase.closeConnection(con, stmt, rs);
        }
        return listProducts;
    }

    public ArrayList<Product> findAll() {

        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Product> listProducts = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT * FROM products order by productCode");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Product p = new Product();

                p.setProductCode(rs.getString("productCode"));
                p.setProductCategory(rs.getString("productCategory"));
                p.setProductDescription(rs.getString("productDescription"));
                p.setProductQuantity(rs.getInt("productQuantityAvailable"));
                p.setProductLocation(rs.getString("productLocation"));
                p.setProductPrice(rs.getDouble("productPrice"));
                p.setProductDtRegistration(rs.getDate("productDtRegistration"));

                listProducts.add(p);

            }
        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado. Impossível concluir a operação.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            ConnectionDatabase.closeConnection(con, stmt, rs);
        }
        return listProducts;
    }
    
    public boolean getMoviP(String code) {

        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
     
        try {

            stmt = con.prepareStatement(
                    "select SUM(quantity)  AS \"totalQtd\", COUNT(*) AS \"totalReg\" from ("
                    + "SELECT "
                    + "P.idSale, V.quantity, P.date from "
                    + "itenssale V, sale P "
                    + "where (v.idSale = P.idSale) "
                    + "and productCode = \'" + code + "\') as TOTAL");
            rs = stmt.executeQuery();

            if (rs.next()) 
            return true;
            
        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado. Impossível continuar.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            ConnectionDatabase.closeConnection(con, stmt, rs);

        }
        return false;
    }
    
    
    

}
