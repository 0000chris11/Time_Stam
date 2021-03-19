/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import MC.MainInstances;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author C0FII
 */
public class VCListener extends WindowAdapter{
      
      @Override
      public void windowClosed​(WindowEvent e){
            MainInstances.setVC_R2(null);
            MainInstances.setVC_R_DataCom(null);
            MainInstances.setVC_R_Comps(null);
      }
}
