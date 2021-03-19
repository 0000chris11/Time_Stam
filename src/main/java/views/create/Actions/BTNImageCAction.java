/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.Actions;

import MC.MainInstances;
import com.cofii2.myInterfaces.SingleSelectionIAction;
import java.awt.Color;
import java.util.EventObject;
import views.createUpdate.VC_R_Comps;
import views.createUpdate.VC_R_DataCom;

/**
 *
 * @author C0FII
 */
public class BTNImageCAction implements SingleSelectionIAction {

      private VC_R_DataCom dt = MainInstances.getVC_R_DataCom();
      private VC_R_Comps c = MainInstances.getVC_R_Comps();

      @Override
      public void action(EventObject e, int index) {
            
            c.setBTN_ImageCSelected(index + 1);
            if (index > -1) {
                  dt.getPImageC().setVisible(true);
                  dt.getLBImageC().setVisible(true);
                  
                  dt.getLBAImageC().setText("C" + (index + 1));
                  dt.getLBAImageC().setForeground(Color.CYAN);
            }else{
                  dt.getPImageC().setVisible(false);
                  dt.getLBImageC().setVisible(false);
                  
                  dt.getLBAImageC().setText("NONE");
                  dt.getLBAImageC().setForeground(Color.WHITE);
            }
      }

}
