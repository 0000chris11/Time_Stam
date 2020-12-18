/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import views.create.VC_R2;
import MC.DT;
import MC.MainInstances;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import views.create.VC_R_DataCom;

/**
 *
 * @author C0FII
 */
public class CBExtra_IL implements ItemListener {
      
      private VC_R_DataCom dt = MainInstances.getVC_R_DataCom();
      private VC_R2 vc = MainInstances.getVC_R2();

      @Override
      public void itemStateChanged(ItemEvent e) {
            boolean visible = false;
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (e.getSource() == dt.getCombTypes2()[a]) {
                        if (dt.getCombTypes2()[a].getSelectedIndex() == 1) {
                              visible = true;
                        } else {
                              visible = false;
                        }
                        dt.getTFSTypes1()[a].setVisible(visible);
                        dt.getTFSTypes2()[a].setVisible(visible);
                  }
                  dt.getPanelTypes2()[a].revalidate();
            }
            vc.toolKitConfig();
      }

}
