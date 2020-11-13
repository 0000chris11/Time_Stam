/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Others;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author C0FII
 */
public class LimitN extends DocumentFilter {

      @Override
      public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) {
            if (test(text)) {
                  //int n = Integer.parseInt(text);
                  try {
                        String oldText = fb.getDocument().getText(0, fb.getDocument().getLength());
                        fb.replace(0, oldText.length(), text.substring(0), attrs);
                  } catch (BadLocationException ble) {
                        ble.printStackTrace();
                  }
            }
      }

      public boolean test(String text) {
            try {
                  Integer.parseInt(text);
                  return true;
            } catch (NumberFormatException e) {
                  return false;
            }
      }
}
