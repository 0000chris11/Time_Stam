/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners_F;

import First.VF_R;
import MC.DT;
import Second.VC;
import Second.VC_R;
import Second.VO;
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
                  System.out.println(VF_R.getMI_CreateTable().getText());
                  new VC_R();
            }else if(ac.equals(VF_R.getMI_UpdateTable().getText())){
                  System.out.println(VF_R.getMI_UpdateTable().getText());
                  //NOT YET+++++++++++++++++++++++++
            }else if(ac.equals(VF_R.getMI_DeleteTables().getText())){
                  System.out.println(VF_R.getMI_DeleteTables().getText());
                  //NOT YET+++++++++++++++++++++++++
            }else if(ac.equals(VF_R.getMI_DeleteThisTable().getText())){
                  System.out.println(VF_R.getMI_DeleteThisTable().getText());
                  new VO("Delete this table?", DT.getTable());
            }
      }
      
}
