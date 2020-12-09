/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.Actions;

import java.awt.Color;
import java.awt.event.KeyEvent;
import views.create.VC_R2;

/**
 *
 * @author C0FII
 */
public class Table_KL_ABandWords extends IKeyMatchActions2 {

      @Override
      public void listAction(KeyEvent e, boolean matchBW) {
            if (matchBW) {
                  VC_R2.getTF_Title().setForeground(Color.RED);
            } else {
                  VC_R2.getTF_Title().setForeground(Color.WHITE);
            }
      }

}
