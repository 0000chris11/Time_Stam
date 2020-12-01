/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import views.first.VF_R;
import MC.DT;
import MC.Status;
import com.cofii.myClasses.CC;
import com.cofii.myInterfaces.IUpdates;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JLabel;

/**
 *
 * @author C0FII
 */
public class Update implements IUpdates {

      private String Msg;
      private JLabel LB;
      
      public Update(String msg, JLabel lb) {
            Msg = msg;
            LB = lb;
      }

      @Override
      public void executeResultRowN() {
            //FIXXXXXXXXXXXXXXXXX
            Status.startLBStatus(LB, Color.GREEN, Msg + ": Done", 4000);
      }

      @Override
      public void executeResult0() {
            //FIXXXXXXXXXXXXXXXXX
            Status.startLBStatus(LB, Color.YELLOW, Msg + ": Fail" + DT.inter, 8000);
      }

      @Override
      public void exception(SQLException ex) {
            ex.printStackTrace();
            Status.startLBStatus(LB, Color.RED, Msg + ": " + ex.toString(), 8000);
      }

}
