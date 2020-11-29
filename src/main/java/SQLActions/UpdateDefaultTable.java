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
public class UpdateDefaultTable implements IUpdates {

      @Override
      public void executeResultRowN() {
            Status.startLBStatus(VF_R.getLB_Status(), Color.GREEN, "Fail to Update Defautl-Table ", 6000);
      }

      @Override
      public void executeResult0() {
            DT.setDTable(DT.getTable());
            Status.startLBStatus(VF_R.getLB_Status(), Color.GREEN, "Default-Table Updated to ", 4000);
      }

      @Override
      public void exception(SQLException ex) {
            ex.printStackTrace();
      }

}
