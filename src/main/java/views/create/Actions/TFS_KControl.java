/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.Actions;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JTextField;
import views.create.VC_R2;
import views.create.mTFControl.IKeyMatchActions3;
import views.create.mTFControl.UpdateList;

/**
 *
 * @author C0FII
 */
public class TFS_KControl extends IKeyMatchActions3 {

      @Override
      public UpdateList getUpdatedList(int listID, ArrayList<String> list) {
            updateListC();
            return new UpdateList(2, VC_R2.getList_C());
      }

      @Override
      public void listsAction(KeyEvent e, boolean[] matches) {
            System.out.println("Matches length: " + matches.length);
            JTextField tf = (JTextField) e.getComponent();
            if (matches[0] || matches[1]) {
                  tf.setForeground(Color.RED);
            } else if (!matches[0] && !matches[1]) {
                  tf.setForeground(Color.WHITE);
            }

            if (matches[2]) {
                  VC_R2.getHeaders()[1].setForeground(Color.RED);
                  VC_R2.getHeaders()[1].setText("Same Column Detected");
            } else {
                  VC_R2.getHeaders()[1].setForeground(Color.WHITE);
                  VC_R2.getHeaders()[1].setText("Names");
            }
      }
      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public static void updateListC() {
            VC_R2.getList_C().clear();
            for (JTextField x : VC_R2.getTFS()) {
                  if (x.isVisible() && !x.getText().isEmpty()) {
                        VC_R2.getList_C().add(x.getText());
                  }
            }
      }

}
