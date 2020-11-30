/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import views.first.VF_R;
import MC.DT;
import MC.Status;
import com.cofii.myClasses.CC;
import com.cofii.myInterfaces.IActions;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author C0FII
 */
public class SelectColumns implements IActions {

      @Override
      public void beforeQuery() {
            DT.getList_C().clear();
            DT.getList_Types().clear();
            DT.getList_Nulls().clear();
            DT.setPrimaryKey(0);
            DT.getList_Defaults().clear();
            DT.setExtra(0, null);

            System.out.println("SET DATA");
      }

      @Override
      public void setData(ResultSet rs, int row) throws SQLException {
            DT.getList_C().add(rs.getString(1));
            DT.getList_Types().add(rs.getString(2));
            DT.getList_Nulls().add(rs.getString(3));
            DT.getList_Defaults().add(rs.getString(5));
            String pk = rs.getString(4);
            System.out.println("\t" + row + ": pk value is: " + pk);
            if (pk != null) {
                  //System.out.println("\t" + row + ": " + pk);
                  DT.setPrimaryKey(row);
            }
            String ext = rs.getString(6);
            System.out.println("\t" + row + ": ext value is: " + ext);
            if (ext != null) {
                  //System.out.println("\t" + row + ": " + ext);
                  DT.setExtra(row, ext);
            }
            
      }

      @Override
      public void afterQuery(String query, boolean value) {
            if (value) {
                  System.out.println("AFTER QUERY (Select Columns)");
                  System.out.println("\tPrimary Key: C" + DT.getPrimaryKey());
                  System.out.println("\tExtra: C" + DT.getExtra()[0] + " (" + DT.getExtra()[1].toString() + ")");
                  
                  DefaultTableModel tm = new DefaultTableModel();
                  VF_R.getJT().setModel(tm);

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
            Status.startLBStatus(VF_R.getLB_Status(), DT.RGY[0],
                    "SelectColumns: " + ex.toString(), 8000);
      }

}
