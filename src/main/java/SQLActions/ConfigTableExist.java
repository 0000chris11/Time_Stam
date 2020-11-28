/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import MC.DTSQL;
import com.cofii.myInterfaces.IActions;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author C0FII
 */
public class ConfigTableExist implements IActions{

      private String configTable;
      
      @Override
      public void beforeQuery() {
            
      }

      @Override
      public void setData(ResultSet rs) throws SQLException {
            configTable = rs.getString(1);
      }

      @Override
      public void afterQuery(String sql, boolean rsValue) {
            if (rsValue && configTable.equals(DTSQL.configTable)) {
                  System.out.println("\tConfig Table Exist Already");
                  DTSQL.setConfigTableExist(true);
            } else {
                  System.out.println("\tConfig Table doesn't exist");
                  DTSQL.setConfigTableExist(false);
            }
      }

      @Override
      public void exception(SQLException ex, String mess) {
            System.out.println(mess);
            ex.printStackTrace();
      }
      
}
