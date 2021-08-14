package Main;
import View.JFMainScreen;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainScreen {

    public static void main(String[] args) throws SQLException {
         try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
        }catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex){
          Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE,null, ex);
              
        }
     
      new JFMainScreen().setVisible(true);
        
    }
    
}
