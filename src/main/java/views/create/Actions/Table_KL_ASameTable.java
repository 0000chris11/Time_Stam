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
public class Table_KL_ASameTable extends IKeyMatchActions2 {

      @Override
      public void listAction(KeyEvent e, boolean matchEST) {
            if (matchEST) {
                  VC_R2.getLB_Title().setForeground(Color.RED);
                  VC_R2.getLB_Title().setText("This table already exist");
            } else {
                  VC_R2.getLB_Title().setForeground(Color.WHITE);
                  VC_R2.getLB_Title().setText(VC_R2.getLB_TitleOrigText());
            }
      }

}
