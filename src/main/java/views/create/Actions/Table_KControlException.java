/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.Actions;

import MC.MainInstances;
import java.awt.Color;
import java.util.EventObject;
import views.create.VC_R_DataCom;
import views.create.mTFControl.AKeyMatchActions3;

/**
 *
 * @author C0FII
 */
public class Table_KControlException extends AKeyMatchActions3 {
      
      private VC_R_DataCom dt = MainInstances.getVC_R_DataCom();
      
      @Override
      public void listsAction(EventObject e, boolean[] matches) {
            if (matches[0] || matches[1]) {
                  dt.getTF_Title().setForeground(Color.RED);
            } else if (!matches[0] && !matches[1]) {
                  dt.getTF_Title().setForeground(Color.WHITE);
            }

            if (matches[2]) {
                  dt.getLB_Title().setForeground(Color.RED);
                  dt.getLB_Title().setText("This table already exist");
            } else {
                  dt.getLB_Title().setForeground(Color.WHITE);
                  dt.getLB_Title().setText(dt.getLB_TitleOrigText());
            }
      }

}
