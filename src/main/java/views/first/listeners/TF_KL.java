/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.first.listeners;

import com.cofii.myMethods.MComp;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComboBox;
import javax.swing.JTextField;

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

      @Override
      public void keyTyped(KeyEvent e) {

      }

      @Override
      public void keyPressed(KeyEvent e) {
            System.out.println("\nKEYPRESSED " + ++count + " (" + e.getComponent().getName() + ")");
            popupControl(e);
            String text = TF.getText();
            System.out.println("Text: " + text);
            String ntext = MComp.setCountComponents(TF, e);
            System.out.println("nText: " + ntext);
            //System.out.println("CB TEXT: " + CB.getSelectedItem().toString());
            
            //System.out.println("CB TEXT: " + CB.getSelectedItem().toString());
            if (!ntext.isEmpty()) {
                  System.out.println("\tTHREAD");
                  new Thread(new Runnable() {
                        @Override
                        public void run() {
                              while (true) {
                                    if (TF.getText().isEmpty() || CB.getSelectedItem().toString().equals("")) {
                                          if (!TF.getText().equals(ntext)) {
                                                TF.setText(ntext);
                                          }
                                          System.out.println("\t\tTF.getText: " + TF.getText());
                                          break;
                                    }
                              }
                        }

                  }).start();
            }
      }

      @Override
      public void keyReleased(KeyEvent e) {

      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++
      private void popupControl(KeyEvent e) {
            if (TF.hasFocus()) {
                  if (e.isAltDown() || e.isControlDown()) {
                        CB.setPopupVisible(false);

                  } else if (!e.isAltDown() && !e.isControlDown()) {
                        CB.setPopupVisible(true);
                  }
            }
      }

}
