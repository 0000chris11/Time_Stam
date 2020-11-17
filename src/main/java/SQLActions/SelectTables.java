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
public class SelectTables implements IActions {
      
      @Override
      public void beforeQuery(boolean result) {
            DT.getList_id().clear();
            DT.getList_T().clear();
            DT.getList_Dist1().clear();
            DT.getList_Dist2().clear();
            DT.getList_Tabl().clear();
            DT.getList_Tag().clear();
            DT.getList_Clock().clear();
      }

      @Override
      public void setData(ResultSet rs) throws SQLException {
            DT.getList_id().add(rs.getString(1));
            DT.getList_T().add(rs.getString(2));
            DT.getList_Dist1().add(rs.getString(3));
            DT.getList_Dist2().add(rs.getString(4));
            DT.getList_Tabl().add(rs.getString(5));
            DT.getList_Tag().add(rs.getString(6));
            DT.getList_Clock().add(rs.getString(7));
            
            
      }

      @Override
      public void afterQuery(String query) {
            
      }

      @Override
      public void exception(SQLException ex, String query) {
            System.out.println(CC.RED + query + CC.RESET);
            ex.printStackTrace();
                  Status.startLBStatus(VF_R.getLB_Status(), DT.RGY[0],
                          "SelectTables: " + ex.toString(), 8000);
      }

}
