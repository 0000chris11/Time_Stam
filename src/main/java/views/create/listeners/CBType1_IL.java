/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import MC.DT;
import MC.MainInstances;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import views.create.VC_R_Comps;

/**
 *
 * @author C0FII
 */
public class CBType1_IL implements ItemListener {
      
      private VC_R_Comps c = MainInstances.getVC_R_Comps();

      @Override
      public void itemStateChanged(ItemEvent e) {
            //System.out.println("itemStateChanged");
            boolean enabled = false;
            Color foreg = Color.WHITE;
            Color selec = Color.BLUE;
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (e.getSource() == c.getCBSTypes()[a]) {
                        if (c.getCBSTypes()[a].getSelectedItem().toString().equals("INT")) {
                              enabled = true;
                              foreg = Color.WHITE;
                              selec = Color.BLUE;
                        } else {
                              foreg = Color.GRAY;
                              selec = Color.RED.darker();
                              enabled = false;
                        }
                        
                        c.getCBSExtra()[a].setEnabled(enabled);
                        c.getCBSExtra()[a].setForeground(foreg);
                        //VC_R2.getCombTypes2()[a].setForeground(foreg);
                        
                        c.getTFSIDEN1()[a].setEnabled(enabled);
                        c.getTFSIDEN1()[a].setForeground(foreg);
                        
                        c.getTFSIDEN2()[a].setEnabled(enabled);
                        c.getTFSIDEN2()[a].setForeground(foreg);
                        
                  }
            }
      }

}
