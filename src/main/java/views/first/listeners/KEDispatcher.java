/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.first.listeners;

import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import views.Login.VL;

/**
 *
 * @author C0FII
 */
public class KEDispatcher implements KeyEventDispatcher {


      public KEDispatcher(boolean check) {
            System.out.println("KEDispatcher - Check value: " + check);
            check(check, VL.getLBPass());
      }

      @Override
      public boolean dispatchKeyEvent(KeyEvent e) {
            if (KeyEvent.VK_CAPS_LOCK == e.getKeyCode()) {
                  JLabel lb = VL.getLBPass();
                  String text = lb.getText();
                  
                  
                  boolean check = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);
                  check(check, lb);
            }

            return false;
      }

      public void check(boolean b, JLabel lb) {
            String text = lb.getText();
            String extra = " - LOCK CAPS ON";
            if (b) {
                  //System.out.println("CHECK");
                  if (!text.contains(extra)) {
                        lb.setText(text + extra);
                        lb.setForeground(Color.CYAN);
                  }
            } else {
                  if (text.contains(extra)) {
                        lb.setText(text.substring(0, text.indexOf(" - LOCK CAPS ON")));
                        lb.setForeground(Color.WHITE);
                  }
            }
      }

}
