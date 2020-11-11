/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Create.Listeners;

import Create.VC_R2;
import MC.DT;
import com.cofii.myMethods.MOthers;
import com.cofii.myMethods.MOthers.Result;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
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
            boolean bool_BW = false;//BANDWORDS MATCH
            boolean bool_SC = false;//SAME COLUMN

            //BAND WORDS CONTROL
            bool_BW = MOthers.getContainMatchFromArrayToList(VC_R2.getTFS(), DT.getBandW());
            if (bool_BW = true) {

            }

            ArrayList<Result> resSC = MOthers.getEqualsMatchAndPositionFromArray(
                    VC_R2.getTFS(), true);

            //ArrayList<Integer> A = (ArrayList<Integer>) resSC[1];
            //ArrayList<Integer> B = (ArrayList<Integer>) resSC[2];
            //bool_SC = (boolean) resSC[0];
            for (Result x : resSC) {
                  if (x.match == true) {
                        bool_SC = true;
                        System.out.println("\tColumn " + (x.a + 1) + " & " + (x.b + 1) + " Match");
                        VC_R2.getLBS()[x.a].setForeground(Color.RED);
                        VC_R2.getLBS()[x.a].setText("Same Name");
                        VC_R2.getLBS()[x.b].setForeground(Color.RED);
                        VC_R2.getLBS()[x.b].setText("Same Name");
                  } else {
                        if (bool_SC != true) {
                              System.out.println("\tColumn " + (x.a + 1) + " & " + (x.b + 1) + " Unmatch");
                              VC_R2.getLBS()[x.a].setForeground(Color.WHITE);
                              VC_R2.getLBS()[x.a].setText(VC_R2.getLBOrigTexts()[x.a]);
                              VC_R2.getLBS()[x.b].setForeground(Color.WHITE);
                              VC_R2.getLBS()[x.b].setText(VC_R2.getLBOrigTexts()[x.b]);
                        }

                  }
            }
            /*
            if (bool_SC == true) {
                  for (Integer x : A) {
                        VC_R2.getLBS()[x].setForeground(Color.RED);
                        VC_R2.getLBS()[x].setText("Same Name");
                  }
                  for (Integer x : B) {
                        VC_R2.getLBS()[x].setForeground(Color.RED);
                        VC_R2.getLBS()[x].setText("Same Name");
                  }
            }
             */
 /*
            for (int a = 0; a < DT.maxColumns; a++) {
                  //COLUMN WITH THE SAME NAME CONTROL
                  JTextField tf = VC_R2.getTFS()[a];
                  JLabel lb = VC_R2.getLBS()[a];
                  //if (e.getSource() == tf) {
                  for (int b = 0; b < DT.maxColumns; b++) {
                        if (a != b) {//DIFFERENT FROM ITSELF
                              if (tf.getText().trim().equalsIgnoreCase(VC_R2.getTFS()[b].getText().trim())
                                      && !tf.getText().trim().isEmpty()) {
                                    //System.out.println("Source: " + tf.getText().trim());
                                    //System.out.println("C" + b + ": " + VC_R2.getTFS()[b].getText().trim());
                                    lb.setText("Same Name");
                                    lb.setForeground(Color.RED);
                                    VC_R2.getLBS()[b].setText("Same Name");
                                    VC_R2.getLBS()[b].setForeground(Color.RED);
                                    bool_SC = true;
                              } else {
                                    if (bool_SC != true) {
                                          lb.setText(VC_R2.getLBOrigTexts()[a]);
                                          lb.setForeground(Color.WHITE);
                                          VC_R2.getLBS()[b].setText(VC_R2.getLBOrigTexts()[b]);
                                          VC_R2.getLBS()[b].setForeground(Color.WHITE);
                                    }
                              }
                        }
                        //}
                  }
                  
            }
             */
      }

}
