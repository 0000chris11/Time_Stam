/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.Actions;

import java.awt.Color;
import views.create.VC_R2;
import views.create.VC_R_DataCom;
import views.first.listeners.MITableOptions_AL;


/**
 *
 * @author C0FII
 */
public class PKAction implements SelectionAction{

      VC_R_DataCom dt = MITableOptions_AL.getVCreateData();
      
      @Override
      public void action(int index) {
            dt.setRB_PKSelected(index + 1);
            if(index > -1){
                  dt.getHeaders()[6].setForeground(Color.YELLOW);
            }else{
                  dt.getHeaders()[6].setForeground(Color.WHITE);
            }
      }
      
}
