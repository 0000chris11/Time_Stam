/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import MC.Status;
import SQLStores.TableDistC;
import com.cofii2.myInterfaces.IUpdates;
import java.awt.Color;
import java.sql.SQLException;
import views.first.VF_R;

/**
 *
 * @author C0FII
 */
public class UpdateDefaultTable implements IUpdates {

      @Override
      public void executeResultRowN() {
            Status.startLBStatus(VF_R.getLB_Status(), Color.GREEN, "Default-Table Updated to " + TableDistC.getTable(), 3500);
      }

      @Override
      public void executeResult0() {
            Status.startLBStatus(VF_R.getLB_Status(), Color.YELLOW, "Fail to Update Defautl-Table", 5000);
      }

      @Override
      public void exception(SQLException ex) {
            ex.printStackTrace();
      }

}
