/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import MC.MainInstances;
import com.cofii2.methods.MList;
import com.cofii2.myInterfaces.IActions;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import views.createUpdate.VC_R_Comps;

/**
 *
 * @author C0FII
 */
public class SelectPrimaryKeys implements IActions {

      private VC_R_Comps c = MainInstances.getVC_R_Comps();
      private ArrayList<String> listPK;
      private String[] primaryKeys;

      public SelectPrimaryKeys(String[] primaryKeys) {
            listPK = new ArrayList<String>();
            this.primaryKeys = primaryKeys;
      }

      @Override
      public void beforeQuery() {

      }

      @Override
      public void setData(ResultSet rs, int row) throws SQLException {
            String string1 = rs.getString(1);
            String string2 = rs.getString(2);

            if (!string2.equals("NONE")) {
                  listPK.add(string1 + "." + string2);
            }
      }

      @Override
      public void afterQuery(String query, boolean rsValue) {
            if (rsValue) {
                  primaryKeys = MList.getListToArray(String.class, listPK);
            }
      }

      @Override
      public void exception(SQLException ex, String query) {
            ex.printStackTrace();
      }
      //+++++++++++++++++++++++++++++++++++++++++
      public String[] getPrimaryKeys(){
            return primaryKeys;
      }

}
