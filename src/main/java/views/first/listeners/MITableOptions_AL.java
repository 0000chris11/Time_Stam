/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.first.listeners;

import views.first.VF_R;
import MC.DT;
import MC.Status;
import MC.TableInfoC;
import java.awt.Color;
import views.create.VC_R2;
import views.choice.VO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.create.VC_R_DataCom;

/**
 *
 * @author C0FII
 */
public class MITableOptions_AL implements ActionListener {

      private static VC_R2 vCreate;
      private static VC_R_DataCom vdCreate;
      private static VC_R2 vUpdate;

      @Override
      public void actionPerformed(ActionEvent e) {
            String ac = e.getActionCommand();
            //System.out.println("\n" + ac);

            if (ac.equals(VF_R.getMI_CreateTable().getText())) {
                  //System.out.println(VF_R.getMI_CreateTable().getText());
                  if (vCreate == null) {
                        vdCreate = new VC_R_DataCom();
                        vCreate = new VC_R2("CREATE");
                  }else{
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
      
      public static VC_R2 getVCreate(){
            return vCreate;
      }
      public static VC_R_DataCom getVCreateData(){
            return vdCreate;
      }
      public static void setVCreate(VC_R2 vc){
            vCreate = vc;
      }
      public static void setVCreateData(VC_R_DataCom vc){
            vdCreate = vc;
      }

}
