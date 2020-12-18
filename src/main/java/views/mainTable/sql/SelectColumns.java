/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.mainTable.sql;

import MC.MainInstances;
import com.cofii2.myInterfaces.IActions;
import java.sql.ResultSet;
import java.sql.SQLException;
import views.mainTable.VMT;

/**
 *
 * @author C0FII
 */
public class SelectColumns implements IActions {

      private VMT dt = MainInstances.getVMT();

      @Override
      public void beforeQuery() {
            dt.getJTTypes().setModel(dt.getDTMTypes());
            dt.getDTMTypes().addColumn("Field");
            dt.getDTMTypes().addColumn("Type");
            dt.getDTMTypes().addColumn("Null");
            dt.getDTMTypes().addColumn("Key");
            dt.getDTMTypes().addColumn("Default");
            dt.getDTMTypes().addColumn("Extra");
      }

      @Override
      public void setData(ResultSet rs, int row) throws SQLException {
            Object[] rows = new Object[]{
                  rs.getString(1),//FIELD
                  rs.getString(2),//TYPES
                  rs.getString(3),//NULLS
                  rs.getString(4),//KEY
                  rs.getString(5),//DEFAULT
                  rs.getString(6)};//EXTRA

            dt.getDTMTypes().addRow(rows);
      }

      @Override
      public void afterQuery(String query, boolean rsValue) {

      }

      @Override
      public void exception(SQLException ex, String query) {
            ex.printStackTrace();
      }

}
