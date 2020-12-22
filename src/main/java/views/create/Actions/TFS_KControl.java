/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.Actions;

import MC.MainInstances;
import java.awt.Color;
import java.util.ArrayList;
import java.util.EventObject;
import javax.swing.JTextField;
import views.create.VC_R_Comps;
import views.create.VC_R_DataCom;
import views.create.mTFControl.AKeyMatchActions3;
import views.create.mTFControl.UpdateList;

/**
 *
 * @author C0FII
 */
public class TFS_KControl extends AKeyMatchActions3 {
      
      private static VC_R_DataCom dt = MainInstances.getVC_R_DataCom();
      private static VC_R_Comps c = MainInstances.getVC_R_Comps();

      @Override
      public UpdateList getUpdatedList(int listID, ArrayList<String> list) {
            updateListC();
            return new UpdateList(2, dt.getList_C());
      }

      @Override
      public void listsAction(EventObject e, boolean[] matches) {
            JTextField tf = (JTextField) e.getSource();
            if (matches[0] || matches[1]) {
                  tf.setForeground(Color.RED);
            } else if (!matches[0] && !matches[1]) {
                  tf.setForeground(Color.WHITE);
            }

            if (matches[2]) {
                  c.getHeaders()[1].setForeground(Color.RED);
                  c.getHeaders()[1].setText("Same Column Detected");
            } else {
                  c.getHeaders()[1].setForeground(Color.WHITE);
                  c.getHeaders()[1].setText("Names");
            }
      }
      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public static void updateListC() {
            dt.getList_C().clear();
            for (JTextField x : c.getTFS()) {
                  if (x.isVisible() && !x.getText().isEmpty()) {
                        dt.getList_C().add(x.getText());
                  }
            }
      }

}
