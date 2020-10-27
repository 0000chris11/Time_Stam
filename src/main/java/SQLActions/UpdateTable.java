/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import First.VF_R;
import MC.DT;
import MC.Status;
import com.cofii.myInterfaces.IUpdates;
import java.sql.SQLException;

/**
 *
 * @author C0FII
 */
public class UpdateTable implements IUpdates {

      private String Msg;
      
      public UpdateTable(String msg){
            Msg = msg;
      }
      
      @Override
      public void succeed() {
            Status.startLBStatus(VF_R.getLB_Status(), DT.RGY[1], Msg, 4000);
      }

      @Override
      public void fail() {
            Status.startLBStatus(VF_R.getLB_Status(), DT.RGY[2], Msg + DT.inter, 8000);
      }

      @Override
      public void exception(SQLException ex) {
            ex.printStackTrace();
            Status.startLBStatus(VF_R.getLB_Status(), DT.RGY[0], Msg + ex.toString(), 8000);
      }

}
