/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.first.listeners;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;

/**
 *
 * @author C0FII
 */
public class JF_FL implements FocusListener {

      private final KeyEventDispatcher altDisabler = new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                  return e.getKeyCode() == KeyEvent.VK_ALT;
            }

      };

      @Override
      public void focusGained(FocusEvent e) {
            KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(altDisabler);
      }

      @Override
      public void focusLost(FocusEvent e) {
            KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(altDisabler);
      }

}
