/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.mainTable.listeners;

import MC.MainInstances;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author C0FII
 */
public class VMTListener extends WindowAdapter{
      @Override
      public void windowClosed​(WindowEvent e){
            MainInstances.setVMT_DataCom(null);
            MainInstances.setVMT(null);
      }
}
