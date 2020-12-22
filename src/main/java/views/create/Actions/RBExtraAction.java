/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.Actions;

import MC.DT;
import MC.MainInstances;
import views.create.VC_R_Comps;

/**
 *
 * @author C0FII
 */
public class RBExtraAction implements SelectionAction {

      private VC_R_Comps c = MainInstances.getVC_R_Comps();

      @Override
      public void action(int index) {
            c.setRB_ExtraSelected(index + 1);
            boolean visible = false;
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (index == a) {
                        visible = true;
                  } else {
                        visible = false;
                  }

                  c.getCBSExtra()[a].setVisible(visible);
                  //++++++++++++++++++++++++++++++++++++++++++++++
                  if (index == a) {
                        if (c.getCBSExtra()[a].getSelectedIndex() == 1) {
                              visible = true;
                        } else {
                              visible = false;
                        }
                  }
                  c.getTFSIDEN1()[a].setVisible(visible);
                  c.getTFSIDEN2()[a].setVisible(visible);
            }
      }

}
