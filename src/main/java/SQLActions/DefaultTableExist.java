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
public class DefaultTableExist implements IActions{
      
      private String table;

      @Override
      public void beforeQuery() {
            
      }

      @Override
      public void setData(ResultSet rs) throws SQLException {
            table = rs.getString(1);
      }

      @Override
      public void afterQuery(String string, boolean bln) {
            if(bln && table.equals(DTSQL.defautlTable)){
                  System.out.println("Default Table Already Exist");
                  DTSQL.setDefaultTableExist(true);
            }else{
                  System.out.println("Default Table doesn't exist");
                  DTSQL.setDefaultTableExist(false);
            }
      }

      @Override
      public void exception(SQLException sqle, String string) {
            sqle.printStackTrace();
      }
      
}
