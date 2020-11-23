/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import views.create.VC_R2;
import MC.DT;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author C0FII
 */
public class CBType2_IL implements ItemListener {

      @Override
      public void itemStateChanged(ItemEvent e) {
            boolean visible = false;
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (e.getSource() == VC_R2.getCombTypes2()[a]) {
                        if (VC_R2.getCombTypes2()[a].getSelectedIndex() == 1) {
                              visible = true;
                        } else {
                              visible = false;
                        }
                        VC_R2.getTFSTypes1()[a].setVisible(visible);
                        VC_R2.getTFSTypes2()[a].setVisible(visible);
                  }
                  VC_R2.getPanelTypes2()[a].revalidate();
            }
      }

}
