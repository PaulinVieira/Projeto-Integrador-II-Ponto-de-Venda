package Util;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class PositionForm {
    
    public void openForm(JInternalFrame frame, JDesktopPane desktop){
        int lDesk = desktop.getWidth();
        int aDesk = desktop.getHeight();
        int lFrame = frame.getWidth();
        int aFrame = frame.getHeight();
        
       frame.setLocation(lDesk / 2 - lFrame / 2, aDesk / 2 - aFrame /2);
       desktop.add(frame);
       frame.setVisible(true);
    
    }
    
}
