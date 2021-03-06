/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.first.listeners;

import views.first.VF_R;
import MC.DT;
import MC.LKCustom;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JComponent;

/**
 *
 * @author C0FII
 */
public class TF_LST_FL_GL implements FocusListener {
      
      @Override
      public void focusGained(FocusEvent e) {
            System.out.println("\nfocusGained");
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (VF_R.getJCBS()[a].hasFocus()) {
                        if (VF_R.getJCBS()[a].getBackground().equals(LKCustom.BK_DIST1)
                                || VF_R.getJCBS()[a].getBackground().equals(LKCustom.BK_DIST2)) {
                              System.out.println("\tLST_" + (a + 1) );
                              VF_R.getJSCS()[a].setVisible(true);
                              VF_R.getPL_UC().revalidate();
                        }
                  }
            }
      }
      
      @Override
      public void focusLost(FocusEvent e) {
            System.out.println("focusLost");
            String JC = ((JComponent) e.getSource()).getName();
            for (int a = 0; a < DT.maxColumns; a++) {
                  if ((JC.equals("TF_" + (a + 1))
                          && (VF_R.getJCBS()[a].getBackground().equals(LKCustom.BK_DIST1)
                          || VF_R.getJCBS()[a].getBackground().equals(LKCustom.BK_DIST2)))
                          || JC.equals("LST_" + (a + 1))) {
                        
                        System.out.println("\tLST_" + a);
                        VF_R.getJSCS()[a].setVisible(false);
                        VF_R.getPL_UC().revalidate();
                  }
            }
      }
      
}
