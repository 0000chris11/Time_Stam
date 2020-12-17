/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import com.cofii2.myInterfaces.IActions;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author C0FII
 */
public class SelectDistinctColumns implements IActions{

      private ArrayList<String> List1;
      private ArrayList<String> List2;
      public boolean rsValues;
      
      public SelectDistinctColumns(ArrayList<String> list1, ArrayList<String> list2){
            List1 = list1;
            List2 = list2;
      }
      
      @Override
      public void beforeQuery() {
            List1.clear();
            List2.clear();
      }

      @Override
      public void setData(ResultSet rs, int i) throws SQLException {
            List1.add(rs.getString(1));
            List2.add(rs.getString(2));
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
