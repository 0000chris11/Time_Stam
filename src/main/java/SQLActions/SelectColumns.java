/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import MC.DT;
import MC.Status;
import SQLStores.TableTypeC;
import com.cofii2.myInterfaces.IActions;
import com.cofii2.stores.CC;
import com.cofii2.stores.IntString;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import views.first.VF_R;

/**
 *
 * @author C0FII
 */
public class SelectColumns implements IActions {

      private boolean lockPK = false;//ONLY ONE TIME CAN YOU SET THE VALUE OF PK AND EXTRA
      private boolean lockEX = false;
      
      private DefaultTableModel tm;
      
      @Override
      public void beforeQuery() {
            DT.getList_C().clear();
            DT.getList_Types().clear();
            DT.getList_Nulls().clear();
            DT.getList_Defaults().clear();
            //DEFAULT++++++++++++++++++++++++
            TableTypeC.setTable(null);
            TableTypeC.setEX(new IntString(0, null));
            
            tm = (DefaultTableModel) VF_R.getJT().getModel();
            tm.setColumnCount(0);
      }

      @Override
      public void setData(ResultSet rs, int row) throws SQLException {
            DT.getList_C().add(rs.getString(1));
            DT.getList_Types().add(rs.getString(2));
            String nulll = rs.getString(3);
            if(nulll.equals("NO")){
                  DT.getList_Nulls().add(false);
            }else{
                  DT.getList_Nulls().add(true);
            }
            
            DT.getList_Defaults().add(rs.getString(5));
            
            String extra = rs.getString(6);
            if(extra.equals("auto_increment")){
                  TableTypeC.setEX(new IntString(row, extra));
            }
            
      }

      @Override
      public void afterQuery(String query, boolean value) {
            if (value) {                
                  for (int a = 0; a < DT.getList_C().size(); a++) {
                        for (int b = 0; b < DT.maxColumns; b++) {
                              if (DT.getList_C().size() == b + 1) {
                                    tm.addColumn(DT.getList_C().get(a));
                              }
                        }
                  }
            }
      }

      @Override
      public void exception(SQLException ex, String query) {
            System.out.println(CC.RED + query + CC.RESET);
            ex.printStackTrace();
            Status.startLBStatus(VF_R.getLB_Status(), Color.RED,
                    "SelectColumns: " + ex.toString(), 8000);
      }

}
