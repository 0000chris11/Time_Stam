
package views.first.listeners;

import views.first.VF_R;
import MC.DT;
import MC.LK;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JComponent;

/**
 *
 * @author Christopher
 */
public class FocusBorder implements FocusListener{

      @Override
      public void focusGained(FocusEvent evt) {
            //System.out.println("\n2 - focusGained");
            JComponent JC = (JComponent) evt.getSource();          
            JC.setBorder(LK.BORDER_LINEMARIGIN_FOCUS_ON);
      }

      @Override
      public void focusLost(FocusEvent evt) {
            //System.out.println("\n2 - focusLost");
            JComponent JC = (JComponent) evt.getSource();
            JC.setBorder(LK.BORDER_LINEMARIGIN_FOCUS_OFF);
      }
      
}

