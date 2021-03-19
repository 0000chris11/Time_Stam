/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.Actions;

import MC.MainInstances;
import java.awt.Color;
import java.awt.Dimension;
import views.createUpdate.VC_R_Comps;

/**
 *
 * @author C0FII
 */
public class RBFKModel {
      
      private static VC_R_Comps c = MainInstances.getVC_R_Comps();
      
      public static void action() {
            boolean selected = false;
            for(int a = 0; a < c.getColumnDisplayed(); a++){
                  if(c.getRBS_FK()[a].isSelected()){
                        selected = true;
                        break;
                  }
            }
            
            for(int a = 0; a < c.getColumnDisplayed(); a++){
                  if(c.getRBS_FK()[a].isSelected()){
                        c.getCBS_FK()[a].setVisible(true);
                  }else{
                        c.getCBS_FK()[a].setVisible(false);
                  }
            }
            changeSize();
            
             if(selected){
                   c.getHeaders()[5].setForeground(Color.CYAN);
             }else{
                    c.getHeaders()[5].setForeground(Color.WHITE);
             }
          
      }
      
      private static void changeSize(){
            for(int a = 0; a < c.getColumnDisplayed(); a++){
                  if(c.getRBS_FK()[a].isSelected()){
                        if(c.getUpdateStore() != null){
                              c.getPanelsFK()[a].setMinimumSize(new Dimension(190, 27));
                              c.getPanelsFK()[a].setMaximumSize(new Dimension(190, 27));
                              c.getPanelsFK()[a].setPreferredSize(new Dimension(190, 27));
                        }else{
                              c.getPanelsFK()[a].setMinimumSize(new Dimension(160, 27));
                              c.getPanelsFK()[a].setMaximumSize(new Dimension(160, 27));
                              c.getPanelsFK()[a].setPreferredSize(new Dimension(160, 27));
                        }
                  }else{
                        if(c.getUpdateStore() != null){
                              c.getPanelsFK()[a].setMinimumSize(new Dimension(60, 27));
                              c.getPanelsFK()[a].setMaximumSize(new Dimension(60, 27));
                              c.getPanelsFK()[a].setPreferredSize(new Dimension(60, 27));
                        }else{
                              c.getPanelsFK()[a].setMinimumSize(new Dimension(30, 27));
                              c.getPanelsFK()[a].setMaximumSize(new Dimension(30, 27));
                              c.getPanelsFK()[a].setPreferredSize(new Dimension(30, 27));
                        }
                  }
            }
      }
}
