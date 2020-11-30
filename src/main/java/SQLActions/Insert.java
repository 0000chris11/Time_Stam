/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import MC.DT;
import MC.Status;
import com.cofii.myInterfaces.IUpdates;
import java.awt.Color;
import java.sql.SQLException;
import views.first.VF_R;

/**
 *
 * @author C0FII
 */
public class Insert implements IUpdates{

      public boolean success;
      
      @Override
      public void executeResultRowN() {
            success = false;
            Status.startLBStatus(VF_R.getLB_Status(), Color.YELLOW, "Fail to Insert on " + DT.getTable(), 5000);
      }

      @Override
      public void executeResult0() {
            success = true;
            Status.startLBStatus(VF_R.getLB_Status(), Color.GREEN, "Insert on " + DT.getTable(), 4000);
      }

      @Override
      public void exception(SQLException sqle) {
            success = false;
            sqle.printStackTrace();
      }
      
}
