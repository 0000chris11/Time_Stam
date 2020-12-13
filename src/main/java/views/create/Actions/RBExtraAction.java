/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.Actions;

import MC.DT;
import views.create.VC_R2;
import views.create.VC_R_DataCom;
import views.first.listeners.MITableOptions_AL;

/**
 *
 * @author C0FII
 */
public class RBExtraAction implements SelectionAction {
      
      VC_R_DataCom dt = MITableOptions_AL.getVCreateData();

      @Override
      public void action(int index) {
            dt.setRB_ExtraSelected(index + 1);
            boolean visible = false;
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (index == a) {
                        visible = true;
                  } else {
                        visible = false;
                  }

                  dt.getCombTypes2()[a].setVisible(visible);
                  //++++++++++++++++++++++++++++++++++++++++++++++
                  if (index == a) {
                        if (dt.getCombTypes2()[a].getSelectedIndex() == 1) {
                              visible = true;
                        } else {
                              visible = false;
                        }
                  }
                  dt.getTFSTypes1()[a].setVisible(visible);
                  dt.getTFSTypes2()[a].setVisible(visible);
            }
      }

}
