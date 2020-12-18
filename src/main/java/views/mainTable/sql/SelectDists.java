/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.mainTable.sql;

import MC.DTSQL;
import MC.MainInstances;
import com.cofii2.myInterfaces.IActions;
import java.sql.ResultSet;
import java.sql.SQLException;
import views.mainTable.VMT;

/**
 *
 * @author C0FII
 */
public class SelectDists implements IActions {

      private VMT dt = MainInstances.getVMT();

      @Override
      public void beforeQuery() {
            if (dt == null) {
                  System.out.println("vmt is emtpy");
            }
            if (dt.getJTDists() == null) {
                  System.out.println("getJTDists is emtpy");
            }
            if (dt.getDTMDists() == null) {
                  System.out.println("getDTMDists is emtpy");
            }
            dt.getJTDists().setModel(dt.getDTMDists());
            for (String x : DTSQL.mainTableColumns) {
                  dt.getDTMDists().addColumn(x);
            }
      }

      @Override
      public void setData(ResultSet rs, int rn) throws SQLException {
            Object[] row = new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                  rs.getString(5), rs.getString(6), rs.getString(7)};

            dt.getDTMDists().addRow(row);
      }

      @Override
      public void afterQuery(String query, boolean rsValue) {

      }

      @Override
      public void exception(SQLException ex, String query) {
            ex.printStackTrace();
      }

}
