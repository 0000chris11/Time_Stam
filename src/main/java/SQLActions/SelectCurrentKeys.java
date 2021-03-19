/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import SQLStores.TableKeysC;
import com.cofii2.methods.MList;
import com.cofii2.myInterfaces.IActions;
import com.cofii2.stores.IntString;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author C0FII
 */
public class SelectCurrentKeys implements IActions {

      private String table = null;
      private ArrayList<IntString> listPK = new ArrayList<IntString>();
      private ArrayList<IntString> listFK = new ArrayList<IntString>();
      private ArrayList<String> listTR = new ArrayList<String>();
      private ArrayList<String> listCR = new ArrayList<String>();
      
      @Override
      public void beforeQuery() {
            TableKeysC.setTable(null);
            TableKeysC.setConstraint_Type(null);
            TableKeysC.setPK(new IntString[]{new IntString(0, null)});
            TableKeysC.setFK(new IntString[]{new IntString(0, null)});
            TableKeysC.setTableR(new String[]{null});
            TableKeysC.setColumnR(new String[]{null});
      }

      @Override
      public void setData(ResultSet rs, int row) throws SQLException {
            table = rs.getString(1);
            
            String constraint_type = rs.getString(2);
            IntString pk = new IntString(0, null);
            IntString fk = new IntString(0, null);
            String tableR = rs.getString(5);
            String columnR = rs.getString(6);
            
            if (constraint_type.equals("PRIMARY KEY")) {
                  pk = new IntString(rs.getInt(3), rs.getString(4));
                  listPK.add(pk);
            } else if (constraint_type.equals("FOREIGN KEY")) {
                  fk = new IntString(rs.getInt(3), rs.getString(4));
                  listFK.add(fk);
                  listTR.add(tableR);
                  listCR.add(columnR);
            }
      }

      @Override
      public void afterQuery(String query, boolean rsValue) {           
            if (rsValue) {
                  TableKeysC.setTable(table);
                  //TableKeysC.setConstraint_Type(constraint_type);
                  TableKeysC.setPK(MList.getListToArray(IntString.class, listPK));
                  //COULDN'T CONVERT CLASS IntString
                  IntString[] FK = new IntString[listFK.size()];
                  for(int a = 0; a < listFK.size(); a++){
                        FK[a] = listFK.get(a);
                  }
                  
                  TableKeysC.setFK(FK);
                  TableKeysC.setTableR(MList.getListToArray(String.class, listTR));
                  TableKeysC.setColumnR(MList.getListToArray(String.class, listCR));
            }
            
      }

      @Override
      public void exception(SQLException ex, String query) {
            ex.printStackTrace();
      }

}
