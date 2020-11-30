/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import com.cofii.myInterfaces.IActions;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author C0FII
 */
public class SelectDistinctColumn implements IActions{

      private ArrayList<String> List;
      public boolean rsValues;
      
      public SelectDistinctColumn(ArrayList<String> list){
            List = list;
      }
      
      @Override
      public void beforeQuery() {
            List.clear();
      }

      @Override
      public void setData(ResultSet rs, int i) throws SQLException {
            List.add(rs.getString(1));
      }

      @Override
      public void afterQuery(String string, boolean bln) {
            if(bln){
                  rsValues = true;
            }else{
                  rsValues = false;
            }
      }

      @Override
      public void exception(SQLException sqle, String string) {
            sqle.printStackTrace();
      }
      
}
