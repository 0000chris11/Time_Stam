/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import MC.DT;
import MC.DTSQL;
import MC.Status;
import com.cofii.myInterfaces.IActions;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import views.Login.VL;
import views.first.VF_R;

/**
 *
 * @author C0FII
 */
public class MainTableExistFQ implements IActions {

      private String MainTableName;

      @Override
      public void beforeQuery() {

      }

      @Override
      public void setData(ResultSet rs, int row) throws SQLException {
            MainTableName = rs.getObject(1).toString();

      }

      @Override
      public void afterQuery(String string, boolean value) {
            if (value && MainTableName.equals(DTSQL.mainTable)) {
                  System.out.println("\tMain Table Exist Already");
                  DTSQL.setMainTableExist(true);
            } else {
                  System.out.println("\tMain Table doesn't exist");
                  DTSQL.setMainTableExist(false);
            }
      }

      @Override
      public void exception(SQLException ex, String string) {
            System.out.println("ERROR QUERY: " + string);
            System.out.println("MESSAGE: " + ex.getMessage());
            if (ex.getMessage().contains("Access denied for user")) {
                  System.out.println("\tWRONG PASSWORD");
                  DT.setWrongPassword(true);
                  VL.getLBPass().setForeground(Color.RED);
                  VL.getLBPass().setText("Incorrect Password");
            } else {
                  DT.setWrongPassword(false);
                  ex.printStackTrace();
                  Status.startLBStatus(VF_R.getLB_Status(), DT.RGY[0],
                          "SelectTables: " + ex.toString(), 8000);
            }
      }

}
