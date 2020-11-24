/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.Login.listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import views.Login.VL;

/**
 *
 * @author C0FII
 */
public class TFLST_FL implements FocusListener {

      @Override
      public void focusGained(FocusEvent e) {
            action(e, true);
      }

      @Override
      public void focusLost(FocusEvent e) {
            action(e, false);
      }

      public void action(FocusEvent e, boolean b) {
            
            System.out.println(e.getComponent().getName());
            
            if (e.getSource() == VL.getTFUser() || e.getSource() == VL.getLSTUser()) {

                  VL.getSCUser().setVisible(b);
                  
                  //!VL.getLSTUser().hasFocus()
            } else if (e.getSource() == VL.getTFDB() || e.getSource() == VL.getLSTDB()) {

                  VL.getSCDB().setVisible(b);

            }
            VL.getP().revalidate();

      }
}
