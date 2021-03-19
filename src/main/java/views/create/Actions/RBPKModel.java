/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.Actions;

import MC.MainInstances;
import java.awt.Color;
import views.createUpdate.VC_R_Comps;

/**
 *
 * @author C0FII
 */
public class RBPKModel {
      
      public static void action(){
            VC_R_Comps c = MainInstances.getVC_R_Comps();
            
            boolean selected = false;
            for(int a = 0; a < c.getColumnDisplayed(); a++){
                  if(c.getRBS_PK()[a].isSelected()){
                        selected = true;
                        break;
                  }
            }
            
            if(selected){
                  c.getHeaders()[4].setForeground(Color.YELLOW);
            }else{
                  c.getHeaders()[4].setForeground(Color.WHITE);
            }
      }
}
