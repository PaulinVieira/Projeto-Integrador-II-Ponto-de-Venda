package Util;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class PositionForm {
    
    public void openForm(JInternalFrame frame, JDesktopPane desktop){
        
        //pego altura e largura do meu internal e do meu desktop
        int lDesk = desktop.getWidth();
        int aDesk = desktop.getHeight();
        int lFrame = frame.getWidth();
        int aFrame = frame.getHeight();
        
        //Defino o X e o Y
        
        // x = largura do desktopPane / 2   - largura do meu frame / 2
        // y = altura do desktopPane / 2    - altura do meu frame / 2
       frame.setLocation(lDesk / 2 - lFrame / 2, aDesk / 2 - aFrame /2);
       desktop.add(frame);
       frame.setVisible(true);
    
    }
    
}
