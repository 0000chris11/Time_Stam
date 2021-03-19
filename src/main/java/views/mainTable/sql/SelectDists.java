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
import views.mainTable.VMT_DataCom;

/**
 *
 * @author C0FII
 */
public class SelectDists implements IActions {

      private VMT_DataCom dt = MainInstances.getVMT_DataCom();

      @Override
      public void beforeQuery() {
            dt.getJTDists().setModel(dt.getDTMDists());
            for (String x : DTSQL.mainTableColumns) {
                  dt.getDTMDists().addColumn(x);
            }
      }

      @Override
      public void setData(ResultSet rs, int rn) throws SQLException {
            Object[] row = new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                  rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)};

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
