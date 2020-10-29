/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import First.VF_R;
import MC.DT;
import MC.Status;
import com.cofii.myClasses.CC;
import com.cofii.myInterfaces.IActions;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author C0FII
 */
public class SelectConfig implements IActions {

      @Override
      public void beforeQuery() {
            DT.getList_TC().clear();
            DT.getList_BL().clear();
            System.out.println(CC.CYAN + "SELECT" + CC.RESET);
      }

      @Override
      public void setData(ResultSet rs) throws SQLException {
            System.out.println("\t" + rs.getBoolean(3));
            
            DT.getList_TC().add(rs.getString(2));
            DT.getList_BL().add(rs.getBoolean(3));
      }

      @Override
      public void afterQuery() {
            
      }

      @Override
      public void exception(SQLException ex) {
            ex.printStackTrace();
                  Status.startLBStatus(VF_R.getLB_Status(), DT.RGY[0],
                          "SelectConfig: " + ex.toString(), 8000);
      }

}
