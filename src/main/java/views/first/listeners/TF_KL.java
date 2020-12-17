/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.first.listeners;

import com.cofii2.myMethods.MComp;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import views.first.VF_R;

/**
 *
 * @author C0FII
 */
public class TF_KL implements KeyListener {

      private int count = 0;
      private JComboBox CB;
      private JTextField TF;

      public TF_KL(JComboBox cb, JTextField tf) {
            CB = cb;
            TF = tf;
      }

      public TF_KL(JTextField tf) {
            TF = tf;
            CB = null;
      }

      @Override
      public void keyTyped(KeyEvent e) {

      }

      @Override
      public void keyPressed(KeyEvent e) {
            String name = e.getComponent().getName();
            int index = MComp.getLastDigitCharsCountAtEnd(name);
            //System.out.println("\nkeyPressed " + index);
            if (CB != null) {
                  popupControl(e);
            }
            //COUNT UP OR DOWN ++++++++++++++++++++++++++++++++++++
            TF.setText(MComp.getCountComponents(TF, e));
            //CLOCK FOCUS CHANGE (CTRL+LEFT OR RIGHT) ++++++++++++++
            focusChangeRL(e, index);
            //TF FOCUS CHANGE (CTRL+DOWN OR UP) +++++++++++++++++++
            int cc = VF_R.getJT().getColumnCount();
            foucusChangeDU(cc, index, e);

      }

      @Override
      public void keyReleased(KeyEvent e) {

      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++
      private void popupControl(KeyEvent e) {
            if (TF.hasFocus()) {
                  if (e.isAltDown() || e.isControlDown() || e.isShiftDown()) {
                        CB.setPopupVisible(false);

                  } else if (!e.isAltDown() && !e.isControlDown() && e.isShiftDown()) {
                        CB.setPopupVisible(true);
                  }
            }
      }

      private void focusChangeRL(KeyEvent e, int index) {

            if (index > 0) {
                  //THIS WILL BE IGNORED IF NO CLOCK IS DISPLAYABLE
                  if (KeyEvent.VK_RIGHT == e.getKeyCode()) {
                        if (e.isControlDown()) {
                              VF_R.getTFS_MD()[index - 1].requestFocus();
                        }
                  } else if (KeyEvent.VK_LEFT == e.getKeyCode()) {
                        if (e.isControlDown()) {
                              VF_R.getTFS_SU()[index - 1].requestFocus();
                        }
                  }
            }
      }

      private void foucusChangeDU(int cc, int index, KeyEvent e) {
            if (KeyEvent.VK_DOWN == e.getKeyCode()) {
                  if (e.isControlDown()) {
                        for (int a = 0; a < cc; a++) {
                              if (a == index - 1) {
                                    int count = 0;//IF ITS THE LAST ONE
                                    if (a != cc - 1) {//IF NOT THE LAST ONE
                                          count = a + 1;//NEXT ONE
                                    }
                                    while (true) {
                                          if (VF_R.getJTFES()[count].isEnabled()) {
                                                VF_R.getJTFES()[count].requestFocus();
                                                break;
                                          } else {
                                                if (count == cc - 1) {//IF ITS REACHES THE LAST ONE
                                                      count = 0;
                                                } else {
                                                      count++;
                                                }
                                          }
                                    }

                              }
                        }
                  }
            } else if (KeyEvent.VK_UP == e.getKeyCode()) {
                  if (e.isControlDown()) {
                        for (int a = 0; a < cc; a++) {
                              if (a == index - 1) {
                                    int count = cc - 1;//IF ITS THE FIST ONE
                                    if (a != 0) {//IF NOT THE FIRST ONE
                                          count = a - 1;//PREVIOUS ONE
                                    }
                                    while (true) {
                                          if (VF_R.getJTFES()[count].isEnabled()) {
                                                VF_R.getJTFES()[count].requestFocus();
                                                break;
                                          } else {
                                                if (count == 0) {//IF ITS REACHES THE FIRST ONE
                                                      count = cc - 1;
                                                } else {
                                                      count--;
                                                }
                                          }
                                    }

                              }
                        }
                  }
            }
      }
      //+++++++++++++++++++++++++++++++++++++++++++++++++
}
