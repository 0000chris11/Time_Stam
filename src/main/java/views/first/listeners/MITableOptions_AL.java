/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.first.listeners;

import MC.MainInstances;
import MC.Status;
import SQLStores.TableDistC;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.choice.VO;
import views.createUpdate.VC_R2;
import views.createUpdate.VC_R_Comps;
import views.createUpdate.VC_R_DataCom;
import views.delete.VD;
import views.first.VF_R;

/**
 *
 * @author C0FII
 */
public class MITableOptions_AL implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {
            String ac = e.getActionCommand();
            //System.out.println("\n" + ac);

            if (ac.equals(VF_R.getMI_CreateTable().getText())) {
                  createTable();
            } else if (ac.equals(VF_R.getMI_UpdateTable().getText())) {
                  //NOT READY
                  updateTable();
            } else if (ac.equals(VF_R.getMI_DeleteTables().getText())) {
                  deleteTable();
            } else if (ac.equals(VF_R.getMI_DeleteThisTable().getText())) {
                  //System.out.println(VF_R.getMI_DeleteThisTable().getText());
                  new VO("Delete this table?", TableDistC.getTable());
            }
      }

      private void createTable() {
            if (MainInstances.getVC_R2() == null) {

                  MainInstances.setVC_R_DataCom(new VC_R_DataCom());
                  MainInstances.setVC_R_Comps(new VC_R_Comps());
                  MainInstances.setVC_R2(new VC_R2());

            } else {
                  Status.startLBStatus(VF_R.getLB_Status(), Color.YELLOW,
                          "There is already an instance of VCreate Window", 4000);
            }
      }

      private void updateTable() {
            if (MainInstances.getVC_R2() == null) {
                  String table = TableDistC.getTable();
                  MainInstances.setVC_R_DataCom(new VC_R_DataCom());
                  MainInstances.setVC_R_Comps(new VC_R_Comps(table));
                  MainInstances.setVC_R2(new VC_R2(table));
            }else {
                  Status.startLBStatus(VF_R.getLB_Status(), Color.YELLOW,
                          "The Create Window must be close before open the Update Window", 5000);
            }
      }

      private void deleteTable() {
            if (MainInstances.getVD() == null) {
                  MainInstances.setVD(new VD());
            } else {
                  Status.startLBStatus(VF_R.getLB_Status(), Color.YELLOW,
                          "There is already an instance of VDelete Window", 4000);
            }
      }

}
