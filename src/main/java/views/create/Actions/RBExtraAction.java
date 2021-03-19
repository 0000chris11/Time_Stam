/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.Actions;

import MC.DT;
import MC.MainInstances;
import com.cofii2.myInterfaces.SingleSelectionIAction;
import java.awt.Color;
import java.util.EventObject;
import views.createUpdate.VC_R_Comps;

/**
 *
 * @author C0FII
 */
public class RBExtraAction implements SingleSelectionIAction {

      private VC_R_Comps c = MainInstances.getVC_R_Comps();

      private String[] previousDefaultsTexts = new String[DT.maxColumns];

      @Override
      public void action(EventObject e, int index) {
            c.setRB_ExtraSelected(index + 1);
            //boolean visible = false;
            for (int a = 0; a < DT.maxColumns; a++) {
                  /*
                  if (index == a) {
                        visible = true;
                  } else {
                        visible = false;
                  }

                  //c.getCBSExtra()[a].setVisible(visible);
                  //++++++++++++++++++++++++++++++++++++++++++++++
                  
                  if (index == a) {
                        if (c.getCBSExtra()[a].getSelectedIndex() == 1) {
                              visible = true;
                        } else {
                              visible = false;
                        }
                  }
                  */
                  //c.getTFSIDEN1()[a].setVisible(visible);
                  //c.getTFSIDEN2()[a].setVisible(visible);

                  
                  //setTextDefaults(a);
                  //System.out.println("TEST RBSEXTRA");
                  if (c.getRBSExtra()[a].isSelected()) {
                        //System.out.println("\tSelected");
                       
                        c.getTFSDefaults()[a].setForeground(Color.RED);
                        c.getTFSDefaults()[a].setToolTipText("AUTO_INCREMENT or IDENTITY doesn't allow DEFAULTS values");
                  } else {
                        //System.out.println("\tUnselected");
                        c.getTFSDefaults()[a].setForeground(Color.WHITE);
                        c.getTFSDefaults()[a].setToolTipText(null);
                  }

            }
      }
      
      private void setTextDefaults(int a){
            previousDefaultsTexts[a] = c.getTFSDefaults()[a].getText();
      }

}
