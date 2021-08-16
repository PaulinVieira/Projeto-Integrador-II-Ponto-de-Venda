package Controller;

import Dao.ConnectionDatabase;
import Model.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class ClientController {

    public void saveClient(Client c) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(
                    "insert into Clients ("
                    + "clientCode, clientCPF, clientName, clientDtBirth, clientEmail,"
                    + "clientCellphone, clientDtLastBuy, clientPostcode, clientAddress, clientDistrict,"
                    + "clientState, clientCity) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

            stmt.setString(1, c.getClientCode());
            stmt.setString(2, c.getClientCPF());
            stmt.setString(3, c.getClientName());
            stmt.setString(4, c.getClientDtBirth());
            stmt.setString(5, c.getClientEmail());
            stmt.setString(6, c.getClientCellphone());
            stmt.setString(7, c.getClientDtLastBuy());
            stmt.setString(8, c.getClientPostcode());
            stmt.setString(9, c.getClientAddress());
            stmt.setString(10, c.getClientDistrict());
            stmt.setString(11, c.getClientState());
            stmt.setString(12, c.getClientCity());

            stmt.executeUpdate();
        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado ao salvar o cliente. Impossível continuar.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    public boolean uniqueCPF(String cpf) {
        boolean uniqueCPF = true;
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {

            stmt = con.prepareStatement("SELECT id FROM clients WHERE clientCPF = \'" + cpf + "\'");

            rs = stmt.executeQuery();

            if (rs.next()) 
                uniqueCPF = false;
            
             else 
                uniqueCPF= true;

        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado. Impossível concluir a operação.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
        return uniqueCPF;
    }
    
    
    //métodos de pesquisa
    
    
    public Client findClient(String cpf) {
        
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Client c = new Client(); 
        
        try {

            stmt = con.prepareStatement("SELECT * FROM clients WHERE clientCPF = \'" + cpf + "\'");
            rs = stmt.executeQuery();
            
            rs.next();
        
                    c.setClientName(rs.getString("clientName"));
                    c.setClientCode(rs.getString("clientCode"));
                    c.setClientCPF(rs.getString("clientCPF"));
                    c.setClientEmail(rs.getString("clientEmail"));
                    c.setClientDtLastBuy(rs.getString("clientDtLastBuy"));
                    c.setClientCellphone(rs.getString("clientCellphone"));
                    c.setClientState(rs.getString("clientState"));
                    c.setClientAddress(rs.getString("clientAddress"));
                    c.setClientPostcode(rs.getString("clientPostcode"));
                    c.setClientDistrict(rs.getString("clientDistrict"));
                    c.setClientCity(rs.getString("clientCity"));
                    
                 
        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado. Impossível concluir a operação.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    return c;
    }
    
    public ArrayList<Client> findByName(String name) {
        
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Client> listClients = new ArrayList<>();
        
        try {

            stmt = con.prepareStatement("SELECT * FROM clients WHERE clientName LIKE \'%" + name + "%\' order by clientName");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                    Client c = new Client();
                    
                    c.setClientName(rs.getString("clientName"));
                    c.setClientCode(rs.getString("clientCode"));
                    c.setClientCPF(rs.getString("clientCPF"));
                    c.setClientEmail(rs.getString("clientEmail"));
                    c.setClientDtLastBuy(rs.getString("clientDtLastBuy"));
                    c.setClientCellphone(rs.getString("clientCellphone"));
                    c.setClientState(rs.getString("clientState"));
                    
                    listClients.add(c);
                    
                }
        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado. Impossível concluir a operação.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    return listClients;
    }
    
    public ArrayList<Client> findByCode(String code) {
        
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Client> listClients = new ArrayList<>();
        
        try {

            stmt = con.prepareStatement("SELECT * FROM clients WHERE clientCode LIKE \'%" + code + "%\' order by clientCode");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                    Client c = new Client();
                    
                    c.setClientName(rs.getString("clientName"));
                    c.setClientCode(rs.getString("clientCode"));
                    c.setClientCPF(rs.getString("clientCPF"));
                    c.setClientEmail(rs.getString("clientEmail"));
                    c.setClientDtLastBuy(rs.getString("clientDtLastBuy"));
                    c.setClientCellphone(rs.getString("clientCellphone"));
                    c.setClientState(rs.getString("clientState"));
                    
                    listClients.add(c);
                    
                }
        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado. Impossível concluir a operação.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    return listClients;
    }
    
    public ArrayList<Client> findByCPF(String cpf) {
        
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Client> listClients = new ArrayList<>();
        
        try {

            stmt = con.prepareStatement("SELECT * FROM clients WHERE clientCPF LIKE \'%" + cpf + "%\' order by clientCPF");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                    Client c = new Client();
                    
                    c.setClientName(rs.getString("clientName"));
                    c.setClientCode(rs.getString("clientCode"));
                    c.setClientCPF(rs.getString("clientCPF"));
                    c.setClientEmail(rs.getString("clientEmail"));
                    c.setClientDtLastBuy(rs.getString("clientDtLastBuy"));
                    c.setClientCellphone(rs.getString("clientCellphone"));
                    c.setClientState(rs.getString("clientState"));
                    
                    listClients.add(c);
                    
                }
        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado. Impossível concluir a operação.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    return listClients;
    }
    
    public ArrayList<Client> findByEmail(String email) {
        
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Client> listClients = new ArrayList<>();
        
        try {

            stmt = con.prepareStatement("SELECT * FROM clients WHERE clientEmail LIKE \'%" + email + "%\' order by clientEmail");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                    Client c = new Client();
                    
                    c.setClientName(rs.getString("clientName"));
                    c.setClientCode(rs.getString("clientCode"));
                    c.setClientCPF(rs.getString("clientCPF"));
                    c.setClientEmail(rs.getString("clientEmail"));
                    c.setClientDtLastBuy(rs.getString("clientDtLastBuy"));
                    c.setClientCellphone(rs.getString("clientCellphone"));
                    c.setClientState(rs.getString("clientState"));
                    
                    listClients.add(c);
                    
                }
        } catch (SQLException ex) {

            String err = "Ocorreu um erro não documentado. Impossível concluir a operação.\nDetalhes técnicos: " + ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    return listClients;
    }
    
}
