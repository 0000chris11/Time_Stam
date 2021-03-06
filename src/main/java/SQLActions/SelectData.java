/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import MC.Status;
import com.cofii2.myInterfaces.IActions;
import com.cofii2.stores.CC;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import views.first.VF_R;

/**
 *
 * @author C0FII
 */
public class SelectData implements IActions {

      private int Cols;
      private DefaultTableModel tm;
      Object[] row;

      private int getLastSelectedRow;

      public SelectData(int cols) {
            Cols = cols;
      }

      @Override
      public void beforeQuery() {
            tm = (DefaultTableModel) VF_R.getJT().getModel();
            tm.setRowCount(0);

            row = new Object[Cols];

            getLastSelectedRow = VF_R.getJT().getSelectedRow();
            //System.out.println("### TEST SelectData");

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
            int dlocation = VF_R.getSPL().getDividerLocation();
            if (rsValue) {
                  /*
                  if (getLastSelectedRow > -1) {
                        VF_R.getJT().setRowSelectionInterval(getLastSelectedRow, getLastSelectedRow);
                        System.out.println("\tgetLastSelectedRow: " + getLastSelectedRow);
                  }
                  */

                  if (VF_R.getSPL().getRightComponent() != VF_R.getSC_JT()) {
                        VF_R.getSPL().setRightComponent(VF_R.getSC_JT());

                  }

            } else {
                  //System.out.println("\tNo rows detected");
                  VF_R.getLB_JT().setText("NO ROWS DETECTED");
                  VF_R.getLB_JT().setForeground(Color.RED);

                  if (VF_R.getSPL().getRightComponent() != VF_R.getLB_JT()) {
                        VF_R.getSPL().setRightComponent(VF_R.getLB_JT());
                  }
                  //VF_R.getLB_JT().setPreferredSize(new Dimension(300, 400));

            }

            VF_R.getSPL().setDividerLocation(dlocation);
            /*
            VF_R.getSPL().setDividerLocation(0.4);
            VF_R.getSPL().revalidate();
             */
      }

      @Override
      public void exception(SQLException ex, String query) {
            System.out.println(CC.RED + query + CC.RESET);
            ex.printStackTrace();
            Status.startLBStatus(VF_R.getLB_Status(), Color.RED,
                    "SelectData: " + ex.toString(), 8000);
      }

}
