/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import First.VF_R;
import MC.DT;
import MC.Status;
import com.cofii.myInterfaces.IActions;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            DT.getList_TP().clear();
            DT.getList_NL().clear();
      }

      @Override
      public void setData(ResultSet rs) throws SQLException {
            DT.getList_C().add(rs.getString(1));
            DT.getList_TP().add(rs.getString(2));
            DT.getList_NL().add(rs.getString(3));
      }

      @Override
      public void afterQuery() {
            DefaultTableModel tm = new DefaultTableModel();
            VF_R.getJT().setModel(tm);
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (DT.getList_C().size() == a + 1) {
                        //VF_R.getJT().setModel(DT.getDTMS()[a + 1]);
                        
                  }
                  //tm.setColumnCount(0);
                  //tm.setRowCount(0);
                  //DT.getDTMS()[a + 2].setColumnCount(0);
                  //DT.getDTMS()[a + 2].setRowCount((0));
                  
            }

            for (int a = 0; a < DT.getList_C().size(); a++) {
                  for (int b = 0; b < DT.maxColumns; b++) {
                        if (DT.getList_C().size() == b + 1) {
                              //DT.getDTMS()[b + 2].addColumn(DT.getList_C().get(a));
                              tm.addColumn(DT.getList_C().get(a));
                        }
                  }
            }
            
      }

      @Override
      public void exception(SQLException ex) {
            ex.printStackTrace();
            Status.startLBStatus(VF_R.getLB_Status(), DT.RGY[0],
                          "SelectColumns: " + ex.toString(), 8000);
      }

}
