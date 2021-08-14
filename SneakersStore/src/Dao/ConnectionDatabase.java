package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class ConnectionDatabase {
    
//arquivo BD.sql em anexo para criação do banco.
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/snearkersstore?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "senac";

    public static Connection getConnection() throws SQLException {
	try {
	    Class.forName(DRIVER);
	    return DriverManager.getConnection(URL, USER, PASSWORD);

	} catch (ClassNotFoundException | SQLException e) {
            String err = "Não foi possível conectar-se ao banco de dados\nDetalhes técnicos: " +e;
            JOptionPane.showMessageDialog(null, err, "ERRO BANCO DE DADOS", ERROR_MESSAGE);	    
            throw new RuntimeException("Saída console: Falha na conexão com o banco de dados." + e);
            
	}
    }

    public static void closeConnection(Connection con) {
	if (con != null) {
	    try {
		con.close();
	    } catch (SQLException ex) {
		Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {
	closeConnection(con);
	if (stmt != null) {
	    try {
		stmt.close();
	    } catch (SQLException ex) {
		Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
	closeConnection(con, stmt);
	if (rs != null) {
	    try {
		rs.close();
	    } catch (SQLException ex) {
		Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }
}
