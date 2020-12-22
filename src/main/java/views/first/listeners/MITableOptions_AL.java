/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.first.listeners;

import MC.MainInstances;
import MC.Status;
import MC.TableInfoC;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.choice.VO;
import views.create.VC_R2;
import views.create.VC_R_Comps;
import views.create.VC_R_DataCom;
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
                  if (MainInstances.getVC_R2() == null) {
                        MainInstances.setVC_R_DataCom(new VC_R_DataCom());
                        MainInstances.setVC_R_Comps(new VC_R_Comps());
                        MainInstances.setVC_R2(new VC_R2("CREATE"));
                        
                  } else {
                        Status.startLBStatus(VF_R.getLB_Status(), Color.YELLOW,
                                "There is already an instance of VCreate Window", 4000);
                  }
            } else if (ac.equals(VF_R.getMI_UpdateTable().getText())) {
                  //System.out.println(VF_R.getMI_UpdateTable().getText());

                  new VC_R2("UPDATE");
            } else if (ac.equals(VF_R.getMI_DeleteTables().getText())) {
                  //System.out.println(VF_R.getMI_DeleteTables().getText());
                  //NOT YET+++++++++++++++++++++++++
            } else if (ac.equals(VF_R.getMI_DeleteThisTable().getText())) {
                  //System.out.println(VF_R.getMI_DeleteThisTable().getText());
                  new VO("Delete this table?", TableInfoC.getTable());
            }
      }

}
