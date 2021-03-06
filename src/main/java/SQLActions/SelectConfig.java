/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import views.first.VF_R;
import MC.DT;
import MC.Status;
import com.cofii2.stores.CC;
import com.cofii2.myInterfaces.IActions;
import java.awt.Color;
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
      public void setData(ResultSet rs, int row) throws SQLException {
            DT.getList_TC().add(rs.getString(2));
            DT.getList_BL().add(rs.getBoolean(3));
      }


      @Override
      public void exception(SQLException ex, String query) {
            System.out.println(CC.RED + query + CC.RESET);
            ex.printStackTrace();
                  Status.startLBStatus(VF_R.getLB_Status(), Color.RED,
                          "SelectConfig: " + ex.toString(), 8000);
      }

      @Override
      public void afterQuery(String string, boolean rsValue) {
            
      }

}
