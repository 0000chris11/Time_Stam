/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.Actions;

import java.awt.Color;
import java.util.ArrayList;
import java.util.EventObject;
import javax.swing.JTextField;
import views.create.VC_R2;
import views.create.VC_R_DataCom;
import views.create.mTFControl.AKeyMatchActions3;
import views.create.mTFControl.UpdateList;
import views.first.listeners.MITableOptions_AL;

/**
 *
 * @author C0FII
 */
public class TFS_KControl extends AKeyMatchActions3 {
      
      static VC_R_DataCom dt = MITableOptions_AL.getVCreateData();

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
                  dt.getHeaders()[1].setForeground(Color.RED);
                  dt.getHeaders()[1].setText("Same Column Detected");
            } else {
                  dt.getHeaders()[1].setForeground(Color.WHITE);
                  dt.getHeaders()[1].setText("Names");
            }
      }
      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public static void updateListC() {
            dt.getList_C().clear();
            for (JTextField x : dt.getTFS()) {
                  if (x.isVisible() && !x.getText().isEmpty()) {
                        dt.getList_C().add(x.getText());
                  }
            }
      }

}