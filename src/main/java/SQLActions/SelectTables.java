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
import com.cofii.myInterfaces.IActions;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import views.Login.VL;

/**
 *
 * @author C0FII
 */
public class SelectTables implements IActions {

      @Override
      public void beforeQuery() {
            DT.getList_id().clear();
            DT.getList_T().clear();
            DT.getList_Dist1().clear();
            DT.getList_Dist2().clear();
            DT.getList_ImageC().clear();
            DT.getList_Tag().clear();
            DT.getList_Clock().clear();
      }

      @Override
      public void setData(ResultSet rs, int row) throws SQLException {
            DT.getList_id().add(rs.getString(1));
            DT.getList_T().add(rs.getString(2));
            DT.getList_Dist1().add(rs.getString(3));
            DT.getList_Dist2().add(rs.getString(4));
            DT.getList_ImageC().add(rs.getString(5));
            DT.getList_Tag().add(rs.getString(6));
            DT.getList_Clock().add(rs.getString(7));

      }

      @Override
      public void afterQuery(String query, boolean rsValue) {
            DT.setRTable(rsValue);
      }

      @Override
      public void exception(SQLException ex, String query) {
            ex.printStackTrace();
            Status.startLBStatus(VF_R.getLB_Status(), Color.RED,
                    "SelectTables: " + ex.toString(), 8000);

      }

}
