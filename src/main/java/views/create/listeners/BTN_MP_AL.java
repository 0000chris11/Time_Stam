/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import views.create.VC_R2;
import MC.DT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author C0FII
 */
public class BTN_MP_AL implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e) {
            for(int row = 0; row < DT.maxColumns - 1; row++){
                  //SUB
                  if(e.getSource() == VC_R2.getBTNS_M()[row + 1]){//FIRST ONE ALLWAYS DISABLED
                        for(int col = 0; col < VC_R2.getCompsD()[row].length; col++){
                              VC_R2.getCompsD()[row + 2][col].setVisible(false);
                        }
                        VC_R2.getBTNS_M()[row].setVisible(true);
                        VC_R2.getBTNS_P()[row].setVisible(true);
                  }
                  //ADD
                  if(e.getSource() == VC_R2.getBTNS_P()[row]){//LAST ONE ALLWAYS DISABLED
                        for(int col = 0; col < VC_R2.getCompsD()[row].length; col++){
                              VC_R2.getCompsD()[row + 2][col].setVisible(true);
                        }
                        VC_R2.getBTNS_M()[row].setVisible(false);
                        VC_R2.getBTNS_P()[row].setVisible(false);
                        
                  }
            }
            
            //System.out.println("REVALIDATE");
            //VC_R2.getPC().revalidate();
            
      }
      
}
