/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Others;

import java.io.Serializable;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author Christopher
 */
public class LimitTextD extends DocumentFilter implements Serializable{

      private int Limit = 0;
      private String Op = "E";

      public LimitTextD(int limit) {
            if (limit <= 0) {
                  throw new IllegalArgumentException("Limit can not be <= 0");
            }
            Limit = limit;
      }

      public LimitTextD(String op) {
            if (op.equals("U") || op.equals("D")) {
                  Op = op;
            } else {
                  //throw new IllegalArgumentException();
            }
      }

      @Override
      public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            System.out.println("InsertString");
      }

      @Override
      public void remove(FilterBypass fb, int offset, int length) {
            //System.out.println("remove");
      }

      @Override
      public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) {
            if (Limit != 0) {
                  System.out.println("replace");
                  int currentLength = fb.getDocument().getLength();

                  int overLimit = (currentLength + text.length()) - Limit - length;
                  if (overLimit > 0) {
                        text = text.substring(0, text.length() - overLimit);
                  }
                  if (text.length() > 0) {
                        try {
                              super.replace(fb, offset, length, text, attrs);
                        } catch (BadLocationException ble) {
                              ble.printStackTrace();
                        }
                  }
            } else {
                  //++++++++++++++++++++++++++++++++++++++

                  if (test(text)) {
                        int n = Integer.parseInt(text);
                        if (Op.equals("D")) {
                              if (n < 6) {
                                    try {
                                          String oldText = fb.getDocument().getText(0, fb.getDocument().getLength());
                                          fb.replace(0, oldText.length(), text.substring(0)/*text.substring(text.length() -1)*/, attrs);
                                    } catch (BadLocationException ble) {
                                          ble.printStackTrace();
                                    }
                              }
                        } else if (Op.equals("U")) {
                              try {
                                    String oldText = fb.getDocument().getText(0, fb.getDocument().getLength());
                                    fb.replace(0, oldText.length(), text.substring(0)/*text.substring(text.length() -1)*/, attrs);
                              } catch (BadLocationException ble) {
                                    ble.printStackTrace();
                              }
                        }
                  }
                  //System.out.println("\tText: " + text);
                  //System.out.println("\ttextLength: " + text.length());
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
