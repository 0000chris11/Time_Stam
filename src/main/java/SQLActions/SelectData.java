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
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
      public void setData(ResultSet rs, int rowN) throws SQLException {
            for (int a = 0; a < Cols; a++) {
                  row[a] = rs.getString(a + 1);
            }

            tm.addRow(row);

      }

      @Override
      public void afterQuery(String string, boolean rsValue) {
            if (rsValue) {
                  if (VF_R.getSPL().getRightComponent() != VF_R.getSC_JT()) {
                        VF_R.getSPL().setRightComponent(VF_R.getSC_JT());
                  }
            } else {
                  System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                  VF_R.getSPL().setRightComponent(VF_R.getLB_JT());
                  VF_R.getLB_JT().setText("NO ROWS DETECTED");
                  VF_R.getLB_JT().setForeground(Color.RED);
            }
      }

      @Override
      public void exception(SQLException ex, String query) {
            System.out.println(CC.RED + query + CC.RESET);
            ex.printStackTrace();
            Status.startLBStatus(VF_R.getLB_Status(), Color.RED,
                    "SelectData: " + ex.toString(), 8000);
      }

}
