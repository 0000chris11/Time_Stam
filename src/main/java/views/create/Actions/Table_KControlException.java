/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.Actions;

import MC.MainInstances;
import com.cofii2.methods.MString;
import java.awt.Color;
import java.util.EventObject;
import com.cofii2.textControl.AKeyMatchActions;
import views.createUpdate.VC_R_Comps;
import views.createUpdate.VC_R_DataCom;

/**
 *
 * @author C0FII
 */
public class Table_KControlException extends AKeyMatchActions {

      private VC_R_DataCom dt = MainInstances.getVC_R_DataCom();
      private VC_R_Comps c = MainInstances.getVC_R_Comps();
      private String table;
      
      public Table_KControlException(){
            if(c.getUpdateStore() != null){
                  this.table = c.getUpdateStore().getTable();
            }
      }

      @Override
      public void listsAction(EventObject e, boolean[] matches) {
            Color fg = Color.WHITE;
            if (table != null) {
                  String table = MString.getCustomClearTableFormat(dt.getTF_Title().getText());
                  String tableC = c.getUpdateStore().getTable();

                  if(tableC.equals(table)){
                        dt.getBTNChange_Table().setEnabled(false);
                  }else{
                        dt.getBTNChange_Table().setEnabled(true);
                  }
            }
            
            if (matches[0] || matches[1]) {
                  dt.getTF_Title().setForeground(Color.RED);
            } else if (!matches[0] && !matches[1]) {
                  dt.getTF_Title().setForeground(fg);
            }

            if (matches[2]) {
                  dt.getLB_Title().setForeground(Color.RED);
                  dt.getLB_Title().setText("This table already exist");
            } else {
                  dt.getLB_Title().setForeground(fg);
                  dt.getLB_Title().setText(dt.getLB_TitleOrigText());
            }
      }

}
