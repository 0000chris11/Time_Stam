/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import views.create.VC_R2;
import MC.DT;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JPanel;

/**
 *
 * @author C0FII
 */
public class CBType1_IL implements ItemListener {

      @Override
      public void itemStateChanged(ItemEvent e) {
            //System.out.println("itemStateChanged");
            boolean enabled = false;
            Color foreg = Color.WHITE;
            Color selec = Color.BLUE;
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (e.getSource() == VC_R2.getCombTypes1()[a]) {
                        if (VC_R2.getCombTypes1()[a].getSelectedItem().toString().equals("INT")) {
                              enabled = true;
                              foreg = Color.WHITE;
                              selec = Color.BLUE;
                        } else {
                              foreg = Color.GRAY;
                              selec = Color.RED.darker();
                              enabled = false;
                        }
                        
                        VC_R2.getCombTypes2()[a].setEnabled(enabled);
                        VC_R2.getCombTypes2()[a].setForeground(foreg);
                        //VC_R2.getCombTypes2()[a].setForeground(foreg);
                        
                        VC_R2.getTFSTypes1()[a].setEnabled(enabled);
                        VC_R2.getTFSTypes1()[a].setForeground(foreg);
                        
                        VC_R2.getTFSTypes2()[a].setEnabled(enabled);
                        VC_R2.getTFSTypes2()[a].setForeground(foreg);
                        
                  }
            }
      }

}
