package Controller;

import Dao.ConnectionDatabase;
import Model.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class ClientController {
    
    public void saveClient(Client c) throws SQLException {
		      Connection con = ConnectionDatabase.getConnection();
		      PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(
                                
		"insert into Clients ("
                +"clientCode, clientCPF, clientName, clientDtBirth, clientEmail,"
                +"clientCellphone, clientDtLastBuy, clientPostcode, clientAddress, clientDistrict,"
                +"clientState, clientCity) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
                        
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
                    
            String err = "Ocorreu um erro não documentado ao salvar o cliente.\nDetalhes técnicos: " +ex;
            JOptionPane.showMessageDialog(null, err, "ERRO Desconhecido", ERROR_MESSAGE);	    
			              Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}
    
}
