/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Create.Listeners;

import Create.VC_R2;
import MC.DT;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author C0FII
 */
public class TF_KL_Control implements KeyListener {

      @Override
      public void keyTyped(KeyEvent e) {

      }

      @Override
      public void keyPressed(KeyEvent e) {

      }

      @Override
      public void keyReleased(KeyEvent e) {
            System.out.println("keyReleased");
            boolean bool_BW = false;
            boolean bool_SC = false;
            for (int a = 0; a < DT.maxColumns; a++) {

                  String text = VC_R2.getJTFS()[a].getText().toUpperCase();
                  //BAND WORDS CONTROL
                  for (int b = 0; b < DT.getBandW().size(); b++) {
                        if (text.contains(DT.getBandW().get(b))) {
                              VC_R2.getJTFS()[a].setForeground(Color.RED);
                              bool_BW = true;
                        } else {
                              if (bool_BW != true) {
                                    VC_R2.getJTFS()[a].setForeground(Color.WHITE);
                              }
                        }
                  }
                  //COLUMN WITH THE SAME NAME CONTROL
                  JTextField tf = VC_R2.getJTFS()[a];
                  JLabel lb = VC_R2.getJLBS()[a];
                  //if (e.getSource() == tf) {
                  for (int b = 0; b < DT.maxColumns; b++) {
                        if (a != b) {//DIFFERENT FROM ITSELF
                              if (tf.getText().trim().equalsIgnoreCase(VC_R2.getJTFS()[b].getText().trim())
                                      && !tf.getText().trim().isEmpty()) {
                                    //System.out.println("Source: " + tf.getText().trim());
                                    //System.out.println("C" + b + ": " + VC_R2.getJTFS()[b].getText().trim());
                                    lb.setText("Same Name");
                                    lb.setForeground(Color.RED);
                                    VC_R2.getJLBS()[b].setText("Same Name");
                                    VC_R2.getJLBS()[b].setForeground(Color.RED);
                                    bool_SC = true;
                              } else {
                                    if (bool_SC != true) {
                                          lb.setText(VC_R2.getJLBOrigTexts()[a]);
                                          lb.setForeground(Color.WHITE);
                                          VC_R2.getJLBS()[b].setText(VC_R2.getJLBOrigTexts()[b]);
                                          VC_R2.getJLBS()[b].setForeground(Color.WHITE);
                                    }
                              }
                        }
                        //}
                  }

            }
      }

}
