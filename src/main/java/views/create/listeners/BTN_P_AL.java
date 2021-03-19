/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import MC.MainInstances;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.createUpdate.VC_R_Comps;
import views.createUpdate.VC_R_DataCom;

/**
 *
 * @author C0FII
 */
public class BTN_P_AL implements ActionListener {

      private VC_R_Comps c = MainInstances.getVC_R_Comps();
      private VC_R_DataCom dt = MainInstances.getVC_R_DataCom();
      private int index = 0;

      public BTN_P_AL(int index) {
            this.index = index;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
            int col = c.getCompsD()[0].length;

            c.getBTNS_M()[index].setVisible(false);
            c.getBTNS_P()[index].setVisible(false);
            //+++++++++++++++++++++++++++++++++++++++++++
            for (int a = 0; a < col; a++) {
                  c.getCompsD()[index + 1][a].setVisible(true);
            }
            c.getBTNS_Dist()[index + 1].setVisible(true);
            c.getBTNS_Dist2()[index].setVisible(true);
            c.getBTNS_ImageC()[index + 1].setVisible(true);
            c.getBTNS_Tag()[index + 1].setVisible(true);
            c.getBTNS_Clock()[index + 1].setVisible(true);
            
            System.out.println("\nTEST INDEX + 1 ++++ " + (index + 1));
            dt.setPCDistHeigth(index + 2);
            //+++++++++++++++++++++++++++++++++++++++++++
            
            c.getBTNS_M()[index + 1].setVisible(true);
            c.getBTNS_P()[index + 1].setVisible(true);
            
            c.setColumnDisplayed(c.getColumnDisplayed() + 1);
      }

}
