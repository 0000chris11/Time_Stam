/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import MC.MainInstances;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import views.createUpdate.VC_R_Comps;
import views.createUpdate.VC_R_DataCom;

/**
 *
 * @author C0FII
 */
public class BTN_M_AL implements ActionListener{
      
      private VC_R_Comps c = MainInstances.getVC_R_Comps();
      private VC_R_DataCom dt = MainInstances.getVC_R_DataCom();
      private int index = 0;
      
      public BTN_M_AL(int index){
            this.index = index;
      }
      
      @Override
      public void actionPerformed(ActionEvent e) {
            int col = c.getCompsD()[0].length;
            
            c.getBTNS_M()[index - 1].setVisible(true);
            c.getBTNS_P()[index - 1].setVisible(true);
        
            for (int a = 0; a < col; a++) {
                  JComponent jc = c.getCompsD()[index][a];
                  jc.setVisible(false);
                  
                  if(jc.getName().contains("PANEL_TFS_")){
                        JTextField tf = (JTextField) jc.getComponent(0);
                        tf.setText("");
                        tf.setForeground(Color.WHITE);
                  }else if(jc.getName().contains("RB_")){
                        JRadioButton rb = (JRadioButton) jc;
                        rb.setSelected(false);
                  }
                  
            }
            //+++++++++++++++++++++++++++++++++++++++++++++++++++
            c.getBTNS_Dist()[index].setVisible(false);
            c.getBTNS_Dist2()[index - 1].setVisible(false);
            c.getBTNS_ImageC()[index].setVisible(false);
            c.getBTNS_Tag()[index].setVisible(false);
            c.getBTNS_Clock()[index].setVisible(false);
            
            dt.setPCDistHeigth(index);
            //+++++++++++++++++++++++++++++++++++++++++++++++++++
            c.setColumnDisplayed(c.getColumnDisplayed() - 1);
      }
      
}
