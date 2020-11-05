/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Create.Listeners;

import Create.VC_R2;
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
            for(int a = 0; a < DT.maxColumns - 1; a++){
                  if(e.getSource() == VC_R2.getJBTNS_MO()[a + 1]){//FIRST ONE ALLWAYS DISABLED
                        for(int b = 0; b < VC_R2.getCompsD()[a].length; b++){
                              VC_R2.getCompsD()[a + 2][b].setVisible(false);
                        }
                        VC_R2.getJBTNS_MO()[a].setVisible(true);
                        VC_R2.getJBTNS_PO()[a].setVisible(true);
                  }
            }
      }
      
}
