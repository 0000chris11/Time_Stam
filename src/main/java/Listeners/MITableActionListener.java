/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import First.VF_R;
import Second.VC;
import Second.VC_R;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Christopher
 */
public class MITableActionListener implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e) {
            String ac = e.getActionCommand();
            //System.out.println("\n" + ac);
            
            if(ac.equals(VF_R.getMI_CreateTable().getText())){
                  System.out.println("\t" + VF_R.getMI_CreateTable().getText());
                  new VC_R();
            }else if(ac.equals(VF_R.getMI_UpdateTable().getText())){
                  System.out.println("\t" + VF_R.getMI_UpdateTable().getText());
                  
            }else if(ac.equals(VF_R.getMI_DeleteTable().getText())){
                  System.out.println("\t" + VF_R.getMI_DeleteTable().getText());
                  
            }
      }
      
}
