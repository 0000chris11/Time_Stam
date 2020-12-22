
package views.first.listeners;

import views.first.VF_R;
import MC.LKCustom;
import com.cofii2.methods.MComp;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JComponent;

/**
 *
 * @author C0FII
 */
public class FocusBorderCustom implements FocusListener{

      @Override
      public void focusGained(FocusEvent evt) {
            //System.out.println("\n2 - focusGained");
            JComponent JC = (JComponent) evt.getSource();          
            int index = MComp.getLastDigitCharsCountAtEnd(JC.getName()) - 1;
            
            VF_R.getJCBS()[index].setBorder(LKCustom.BR_LINEMARIGIN_FOCUS_ON);
      }

      @Override
      public void focusLost(FocusEvent evt) {
            //System.out.println("\n2 - focusLost");
            JComponent JC = (JComponent) evt.getSource();
            int index = MComp.getLastDigitCharsCountAtEnd(JC.getName()) - 1;
             VF_R.getJCBS()[index].setBorder(LKCustom.BR_LINEMARIGIN_FOCUS_OFF);
      }
      
}

