/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import MC.Status;
import MC.TableInfoC;
import com.cofii2.myInterfaces.IUpdates;
import java.awt.Color;
import java.sql.SQLException;
import views.first.VF_R;

/**
 *
 * @author C0FII
 */
public class DeleteTable implements IUpdates {

      private String Table;

      public DeleteTable(String table) {
            Table = table;
      }

      @Override
      public void executeResultRowN() {
            Status.startLBStatus(VF_R.getLB_Status(), Color.GREEN,
                    "Table " + Table + " fail to be deleted", 6000);
      }

      @Override
      public void executeResult0() {
            VF_R.tableDeletedState();//HIDE ALL COMPONENTS
            VF_R.getSPL().setRightComponent(VF_R.getLB_JT());
            VF_R.getLB_JT().setText("No Table Selected");
            TableInfoC.setTable(null);

            VF_R.getMI_DeleteThisTable().setEnabled(false);
            //REMOVING TABLE FROM THE MENU
            for (int a = 0; a < VF_R.getJM_Select().getItemCount(); a++) {
                  if (VF_R.getJM_Select().getItem(a).toString().
                          equals(Table)) {
                        VF_R.getJM_Select().remove(a);
                  }
                  if (VF_R.getJMS_ChangeDTable().getItem(a).toString().
                          contains(Table)) {
                        VF_R.getJMS_ChangeDTable().remove(a);
                  }
            }
            //++++++++++++++++++++++++++++++++++++
            Status.startLBStatus(VF_R.getLB_Status(), Color.GREEN,
                    "Table " + Table + " Deleted successfully", 6000);
      }

      @Override
      public void exception(SQLException ex) {
            ex.printStackTrace();
      }

}
