/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import com.cofii.myMethods.MComp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import views.create.VC_R_DataCom;
import views.first.listeners.MITableOptions_AL;

/**
 *
 * @author C0FII
 */
public class rbDefault_AL implements ActionListener {
      
      private VC_R_DataCom dt = MITableOptions_AL.getVCreateData();
      
      private int index = 0;
      
      public rbDefault_AL(int index){
            this.index = index;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
            JRadioButton rb = (JRadioButton) e.getSource();
            if (rb.isSelected()) {
                  dt.getTFSDefaults()[index].setVisible(true);
            }else{
                  dt.getTFSDefaults()[index].setVisible(false);
            }
            
      }

}
