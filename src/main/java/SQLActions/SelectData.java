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

/**
 *
 * @author C0FII
 */
public class SelectData implements IActions {
      
      private int Cols;
      private DefaultTableModel tm;
      Object[] row;

      public SelectData(int cols) {
            Cols = cols;
      }

      @Override
      public void beforeQuery() {
            tm = (DefaultTableModel) VF_R.getJT().getModel();
            tm.setRowCount(0);

            row = new Object[Cols];
      }

      @Override
      public void setData(ResultSet rs) throws SQLException {
            for (int a = 0; a < Cols; a++) {
                  row[a] = rs.getString(a + 1);
            }
            tm.addRow(row);
      }

      @Override
      public void afterQuery() {

      }

      @Override
      public void exception(SQLException ex) {
            ex.printStackTrace();
            Status.startLBStatus(VF_R.getLB_Status(), DT.RGY[0],
                          "SelectData: " + ex.toString(), 8000);
      }

}
