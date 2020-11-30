/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import MC.Status;
import com.cofii.myInterfaces.IUpdates;
import java.awt.Color;
import java.sql.SQLException;
import views.first.VF_R;

/**
 *
 * @author COFII
 */
public class DeleteRow implements IUpdates{

      private Object[] Values;
      
      public DeleteRow(Object[] values){
            Values = values;
      }
      
      @Override
      public void executeResultRowN() {
            Status.startLBStatus(VF_R.getLB_Status(), Color.YELLOW, 
                    "Fail to delete row", 4000);
      }

      @Override
      public void executeResult0() {
            Status.startLBStatus(VF_R.getLB_Status(), Color.GREEN, 
                    "Row [" + Values.toString() + "] has been deleted", 4000);
      }

      @Override
      public void exception(SQLException sqle) {
            Status.startLBStatus(VF_R.getLB_Status(), Color.RED, sqle.getMessage(), 6000);
            sqle.printStackTrace();
      }
      
}
