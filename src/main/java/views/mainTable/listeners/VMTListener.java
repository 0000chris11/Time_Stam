/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.mainTable.listeners;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import views.first.listeners.MainListeners_F;

/**
 *
 * @author C0FII
 */
public class VMTListener extends WindowAdapter{
      @Override
      public void windowClosed​(WindowEvent e){
            MainListeners_F.setVMT(null);
      }
}
