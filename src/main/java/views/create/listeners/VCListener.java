/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import views.first.listeners.MITableOptions_AL;

/**
 *
 * @author C0FII
 */
public class VCListener extends WindowAdapter{
      @Override
      public void windowClosed​(WindowEvent e){
            MITableOptions_AL.setVCreate(null);
            MITableOptions_AL.setVCreateData(null);
      }
}
