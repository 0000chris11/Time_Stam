/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import SQLStores.TableDistC;
import SQLStores.TableTypeC;
import com.cofii2.myInterfaces.IActions;
import com.cofii2.stores.IntString;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author C0FII
 */
public class SelectCurrentTypes implements IActions{

      @Override
      public void beforeQuery() {
            
      }

      @Override
      public void setData(ResultSet rs, int row) throws SQLException {
            TableTypeC.setTable(TableDistC.getTable());
            TableTypeC.setEX(new IntString(rs.getInt(6), rs.getString(7)));
      }

      @Override
      public void afterQuery(String query, boolean rsValue) {
            
      }

      @Override
      public void exception(SQLException ex, String query) {
            ex.printStackTrace();
      }
      
}
