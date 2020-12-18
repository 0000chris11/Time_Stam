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
import views.create.VC_R_DataCom;

/**
 *
 * @author C0FII
 */
public class CBType1_IL implements ItemListener {
      
      private VC_R_DataCom dt = MainInstances.getVC_R_DataCom();

      @Override
      public void itemStateChanged(ItemEvent e) {
            //System.out.println("itemStateChanged");
            boolean enabled = false;
            Color foreg = Color.WHITE;
            Color selec = Color.BLUE;
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (e.getSource() == dt.getCombTypes()[a]) {
                        if (dt.getCombTypes()[a].getSelectedItem().toString().equals("INT")) {
                              enabled = true;
                              foreg = Color.WHITE;
                              selec = Color.BLUE;
                        } else {
                              foreg = Color.GRAY;
                              selec = Color.RED.darker();
                              enabled = false;
                        }
                        
                        dt.getCombTypes2()[a].setEnabled(enabled);
                        dt.getCombTypes2()[a].setForeground(foreg);
                        //VC_R2.getCombTypes2()[a].setForeground(foreg);
                        
                        dt.getTFSTypes1()[a].setEnabled(enabled);
                        dt.getTFSTypes1()[a].setForeground(foreg);
                        
                        dt.getTFSTypes2()[a].setEnabled(enabled);
                        dt.getTFSTypes2()[a].setForeground(foreg);
                        
                  }
            }
      }

}
