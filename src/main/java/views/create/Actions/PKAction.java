/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.Actions;

import java.awt.Color;
import views.create.VC_R2;


/**
 *
 * @author C0FII
 */
public class PKAction implements SelectionAction{

      @Override
      public void action(int index) {
            VC_R2.setRB_PKSelected(index + 1);
            if(index > -1){
                  VC_R2.getHeaders()[6].setForeground(Color.YELLOW);
            }else{
                  VC_R2.getHeaders()[6].setForeground(Color.WHITE);
            }
      }
      
}
