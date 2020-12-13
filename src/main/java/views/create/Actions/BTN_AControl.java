/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.Actions;

import java.awt.Color;
import java.util.ArrayList;
import java.util.EventObject;
import views.create.VC_R_DataCom;
import views.create.mTFControl.AKeyMatchActions3;
import views.create.mTFControl.UpdateList;
import views.first.listeners.MITableOptions_AL;

/**
 *
 * @author C0FII
 */
public class BTN_AControl extends AKeyMatchActions3 {

      VC_R_DataCom dt = MITableOptions_AL.getVCreateData();
      
      @Override
      public UpdateList getUpdatedList(int listID, ArrayList<String> list) {
            TFS_KControl.updateListC();
            return new UpdateList(0, dt.getList_C());
      }

      @Override
      public void listsAction(EventObject e, boolean[] matches) {
                  
            if (matches[0]) {
                  dt.getHeaders()[1].setForeground(Color.RED);
                  dt.getHeaders()[1].setText("Same Column Detected");
            } else {
                  dt.getHeaders()[1].setForeground(Color.WHITE);
                  dt.getHeaders()[1].setText("Names");
            }
      }

}
