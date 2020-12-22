/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.Actions;

import MC.MainInstances;
import java.awt.Color;
import views.create.VC_R_Comps;


/**
 *
 * @author C0FII
 */
public class PKAction implements SelectionAction{

      private VC_R_Comps c = MainInstances.getVC_R_Comps();
      
      @Override
      public void action(int index) {
            c.setRB_PKSelected(index + 1);
            if(index > -1){
                  c.getHeaders()[6].setForeground(Color.YELLOW);
            }else{
                  c.getHeaders()[6].setForeground(Color.WHITE);
            }
      }
      
}
