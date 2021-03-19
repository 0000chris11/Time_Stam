/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import MC.MainInstances;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;
import views.createUpdate.VC_R_Comps;

/**
 *
 * @author C0FII
 */
public class TFTypes_KL implements KeyListener {

      private VC_R_Comps c = MainInstances.getVC_R_Comps();
      private int index;

      public TFTypes_KL(int index) {
            this.index = index;
      }

      @Override
      public void keyTyped(KeyEvent e) {

      }

      @Override
      public void keyPressed(KeyEvent e) {

      }

      @Override
      public void keyReleased(KeyEvent e) {
            if (c.getUpdateStore() != null) {
                  String typeC = c.getUpdateStore().getTypes()[index].string;
                  String type = c.getCBSTypes()[index].getSelectedItem().toString().toUpperCase();
                  int typeWidthC = c.getUpdateStore().getTypes()[index].index;
                  int typeWidth = Integer.parseInt(c.getTFSTypes()[index].getText());
                  if (type.equals(typeC) && typeWidth == typeWidthC) {
                        c.getBTNSChange_Types()[index].setEnabled(false);
                  } else {
                        c.getBTNSChange_Types()[index].setEnabled(true);
                  }
            }
      }

}
