/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import MC.MainInstances;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import views.create.VC_R_Comps;

/**
 *
 * @author C0FII
 */
public class rbDefault_AL implements ActionListener {
      
      private VC_R_Comps c = MainInstances.getVC_R_Comps();
      
      private int index = 0;
      
      public rbDefault_AL(int index){
            this.index = index;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
            JRadioButton rb = (JRadioButton) e.getSource();
            if (rb.isSelected()) {
                  c.getTFSDefaults()[index].setVisible(true);
            }else{
                  c.getTFSDefaults()[index].setVisible(false);
            }
            
      }

}
