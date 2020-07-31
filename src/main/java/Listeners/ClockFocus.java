package Listeners;

import First.VF;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 *
 * @author Christopher
 */
public class ClockFocus implements FocusListener{

      //private Color C = new Color(0, 0, 80);
      
      public void setColor(FocusEvent evt, Color color){
            JTextField jtfC = (JTextField)evt.getSource();
            for(int a = 0; a < 5; a++){
                  if(jtfC.getLocation().equals(VF.getTFS_MD()[a].getLocation())){
                        //System.out.println("\tMD [" + a +"]: ");
                        VF.getTFS_MD()[a].setBackground(color);
                  }else if(jtfC.getLocation().equals(VF.getTFS_MU()[a].getLocation())){
                        //System.out.println("\tUD [" + a +"]: ");
                        VF.getTFS_MU()[a].setBackground(color);
                  }else if(jtfC.getLocation().equals(VF.getTFS_SD()[a].getLocation())){
                        //System.out.println("\tSD [" + a +"]: ");
                        VF.getTFS_SD()[a].setBackground(color);
                  }else if(jtfC.getLocation().equals(VF.getTFS_SU()[a].getLocation())){
                        //System.out.println("\tSU [" + a +"]: ");
                        VF.getTFS_SU()[a].setBackground(color);
                  }
            }
      }
      
      @Override
      public void focusGained(FocusEvent evt) {
            setColor(evt, new Color(0, 0, 80));
      }

      @Override
      public void focusLost(FocusEvent evt) {
            setColor(evt, new Color(51, 51, 51));
      }
      
}
