/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.Actions;

import MC.LK;
import com.cofii.myMethods.MComp;
import com.cofii.myMethods.MList;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import views.create.VC_R2;
import views.create.listeners.MTF_Control;

/**
 *
 * @author C0FII
 */
public class TFS_KL_ABandWords extends IKeyMatchActions2 {
     
      @Override
      public void listAction(KeyEvent e, boolean v) {
            JTextField tf = (JTextField) e.getComponent();
            if (v) {
                  tf.setForeground(Color.RED);
            } else {
                  tf.setForeground(Color.WHITE);
            }
      }


}
