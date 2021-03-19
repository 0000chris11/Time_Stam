/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.Actions;

import MC.DT;
import MC.MainInstances;
import com.cofii2.myInterfaces.SingleSelectionIAction;
import java.awt.Dimension;
import java.util.EventObject;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import views.createUpdate.VC_R_Comps;
import views.createUpdate.VC_R_DataCom;

/**
 *
 * @author C0FII
 */
public class RBDefaultsModel {

      private static VC_R_Comps c = MainInstances.getVC_R_Comps();
      private static VC_R_DataCom dt = MainInstances.getVC_R_DataCom();

      public static void action() {
            System.out.println("TEST RBDefaultsModel LISTENING");
            for (int a = 0; a < c.getColumnDisplayed(); a++) {
                  if (c.getRBSDefaults()[a].isSelected()) {
                        System.out.println("\tSELECTED (" + (a + 1) + ")");
                        c.getTFSDefaults()[a].setVisible(true);
                  } else {
                        System.out.println("\tUNSELECTED (" + (a + 1) + ")");
                        c.getTFSDefaults()[a].setVisible(false);
                  }
            }
            /*
            if (index > -1) {
                  c.getPanelsDefaults()[index].revalidate();
            }else{
                  for(JPanel x : c.getPanelsDefaults()){
                        x.revalidate();
                  }
            }
             */

            changeSize();

      }

      private static void changeSize() {
            for (int a = 0; a < c.getColumnDisplayed(); a++) {
                  if (c.getRBSDefaults()[a].isSelected()) {
                        if (c.getUpdateStore() != null) {
                              c.getPanelsDefaults()[a].setMinimumSize(new Dimension(160, 27));
                              c.getPanelsDefaults()[a].setMaximumSize(new Dimension(160, 27));
                              c.getPanelsDefaults()[a].setPreferredSize(new Dimension(160, 27));
                              c.getPanelsDefaults()[a].revalidate();
                        } else {
                              c.getPanelsDefaults()[a].setMinimumSize(new Dimension(130, 27));
                              c.getPanelsDefaults()[a].setMaximumSize(new Dimension(130, 27));
                              c.getPanelsDefaults()[a].setPreferredSize(new Dimension(130, 27));
                              c.getPanelsDefaults()[a].revalidate();
                        }

                        JScrollBar scroll = dt.getsc_JPC().getHorizontalScrollBar();
                        scroll.setValue(scroll.getMaximum());
                        scroll.revalidate();//NOT WORKING
                  } else {
                        if (c.getUpdateStore() != null) {
                              c.getPanelsDefaults()[a].setMinimumSize(new Dimension(60, 27));
                              c.getPanelsDefaults()[a].setMaximumSize(new Dimension(60, 27));
                              c.getPanelsDefaults()[a].setPreferredSize(new Dimension(60, 27));
                              c.getPanelsDefaults()[a].revalidate();
                        } else {
                              c.getPanelsDefaults()[a].setMinimumSize(new Dimension(30, 27));
                              c.getPanelsDefaults()[a].setMaximumSize(new Dimension(30, 27));
                              c.getPanelsDefaults()[a].setPreferredSize(new Dimension(30, 27));
                              c.getPanelsDefaults()[a].revalidate();
                        }
                  }
            }
      }

}
