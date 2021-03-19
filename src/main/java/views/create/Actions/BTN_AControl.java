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
import views.createUpdate.VC_R_Comps;
import views.createUpdate.VC_R_DataCom;
import com.cofii2.textControl.AKeyMatchActions;

/**
 *
 * @author C0FII
 */
public class BTN_AControl extends AKeyMatchActions {

      private VC_R_DataCom dt = MainInstances.getVC_R_DataCom();
      private VC_R_Comps c = MainInstances.getVC_R_Comps();
      
      @Override
      public Int_StringList getUpdatedList(int listID, ArrayList<String> list) {
            TFS_KControl.updateListC();
            return new Int_StringList(0, dt.getList_C());
      }

      @Override
      public void listsAction(EventObject e, boolean[] matches) {
                  
            if (matches[0]) {
                  c.getHeaders()[1].setForeground(Color.RED);
                  c.getHeaders()[1].setText("Same Column Detected");
            } else {
                  c.getHeaders()[1].setForeground(Color.WHITE);
                  c.getHeaders()[1].setText("Names");
            }
      }

}
