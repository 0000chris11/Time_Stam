/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.Actions;

import java.awt.Color;
import java.awt.event.KeyEvent;
import views.create.VC_R2;
import views.create.mTFControl.IKeyMatchActions3;

/**
 *
 * @author C0FII
 */
public class Table_KControl extends IKeyMatchActions3 {

      @Override
      public void listsAction(KeyEvent e, boolean[] matches) {
            System.out.println("Matches length: " + matches.length);
            if (matches[0] || matches[1]) {
                  VC_R2.getTF_Title().setForeground(Color.RED);
            } else if (!matches[0] && !matches[1]) {
                  VC_R2.getTF_Title().setForeground(Color.WHITE);
            }

            if (matches[2]) {
                  VC_R2.getLB_Title().setForeground(Color.RED);
                  VC_R2.getLB_Title().setText("This table already exist");
            } else {
                  VC_R2.getLB_Title().setForeground(Color.WHITE);
                  VC_R2.getLB_Title().setText(VC_R2.getLB_TitleOrigText());
            }
      }

}
