/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.Actions;

import MC.MainInstances;
import com.cofii2.stores.Int_StringList;
import java.awt.Color;
import java.util.ArrayList;
import java.util.EventObject;
import javax.swing.JTextField;
import views.createUpdate.VC_R_Comps;
import views.createUpdate.VC_R_DataCom;
import com.cofii2.textControl.AKeyMatchActions;

/**
 *
 * @author C0FII
 */
public class TFS_KControl extends AKeyMatchActions {
      
      private static VC_R_DataCom dt = MainInstances.getVC_R_DataCom();
      private static VC_R_Comps c = MainInstances.getVC_R_Comps();
      private int index;
      
      public TFS_KControl(int index){
            this.index = index;
      }

      @Override
      public Int_StringList getUpdatedList(int listID, ArrayList<String> list) {
            updateListC();
            return new Int_StringList(2, dt.getList_C());
      }

      @Override
      public void listsAction(EventObject e, boolean[] matches) {
            JTextField tf = (JTextField) e.getSource();
            
            if(c.getUpdateStore() != null){
                  String columnC = c.getUpdateStore().getColumnNames()[index];
                  String column = tf.getText().toLowerCase().trim();
                  if(column.equals(columnC)){
                        c.getBTNSChange_TFS()[index].setEnabled(false);
                  }else{
                        c.getBTNSChange_TFS()[index].setEnabled(true);
                  }
            }
            
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
