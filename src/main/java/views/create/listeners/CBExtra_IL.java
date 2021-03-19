/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import MC.MainInstances;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import views.createUpdate.VC_R_Comps;

/**
 *OLD CLASS NOT BEIGN USE
 * 
 * @author C0FII
 */
public class CBExtra_IL implements ItemListener {
      
      private VC_R_Comps c = MainInstances.getVC_R_Comps();

      @Override
      public void itemStateChanged(ItemEvent e) {
            /*
            boolean visible = false;
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (e.getSource() == c.getCBSExtra()[a]) {
                        if (c.getCBSExtra()[a].getSelectedIndex() == 1) {
                              visible = true;
                        } else {
                              visible = false;
                        }
                        c.getTFSIDEN1()[a].setVisible(visible);
                        c.getTFSIDEN2()[a].setVisible(visible);
                  }
                  c.getPanelsExtra()[a].revalidate();
            }
            */
      }

}
