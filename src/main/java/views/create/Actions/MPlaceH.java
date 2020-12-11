/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.Actions;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.security.InvalidParameterException;
import javax.swing.JTextField;

/**
 *
 * @author C0FII
 */
public class MPlaceH implements FocusListener {

      private String text;

      public MPlaceH(String text) {
            this.text = text;
      }

      @Override
      public void focusGained(FocusEvent e) {
            if (e.getComponent() instanceof JTextField) {
                  JTextField tf = (JTextField) e.getComponent();
                  if (tf.getText().equalsIgnoreCase(text)) {
                        
                  }
            }else{
                  throw new InvalidParameterException("Only JTextField allowed");
            }
      }

      @Override
      public void focusLost(FocusEvent e) {

      }

}
