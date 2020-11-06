/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Create.Listeners;

import Create.VC_R;
import Create.VC_R2;
import MC.DT;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
            boolean bool = false;
            for (int a = 0; a < DT.maxColumns; a++) {
                  String text = VC_R2.getJTFSN()[a].getText().toUpperCase();

                  for (int b = 0; b < DT.getBandW().size(); b++) {
                        if (text.contains(DT.getBandW().get(b))) {
                              VC_R2.getJTFSN()[a].setForeground(Color.RED);
                              bool = true;
                        }  else {
                              if (bool != true) {
                                    VC_R2.getJTFSN()[a].setForeground(Color.WHITE);

                              }
                        }
                  }
            }
      }
      
}
