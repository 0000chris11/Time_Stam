/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.Login.listeners;

import MC.DTSQL;
import com.cofii2.myClasses.MSQL;
import com.cofii2.myMethods.MOthers;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import views.Login.VL;
import views.first.VF_R;

/**
 *
 * @author C0FII
 */
public class BTNLogin_AL implements ActionListener {

      MSQL ms = new MSQL(DTSQL.initURLConnection, DTSQL.rootUser, DTSQL.rootPassw);

      @Override
      public void actionPerformed(ActionEvent e) {
            System.out.println("LOGIN +++++ ACTION");
            resetLBS();
            //++++++++++++++++++++++++++++++++++++++
            String selectedUser = VL.getCBUser().getSelectedItem().toString();
            String selectedPass = String.valueOf(VL.getTFPass().getPassword());
            String selectedDB = VL.getCBDB().getSelectedItem().toString();
            System.out.println("\tselectedUser: " + selectedUser);
            System.out.println("\tselectedPass: " + selectedPass);
            System.out.println("\tselectedDB: " + selectedDB);
            //System.out.println("User SelectedItem: " + selected);
            int countB = 0;
            if (!selectedUser.isEmpty()
                    && MOthers.getEqualMatchFromStringToList(selectedUser, VL.getUserData(), -1, true)) {
                  VL.getLBUser().setForeground(Color.WHITE);
                  VL.getLBUser().setText("User");
                  countB++;
            } else {
                  VL.getLBUser().setForeground(Color.RED);
                  VL.getLBUser().setText("Not Found User");
            }

            if (!selectedDB.isEmpty()
                    && MOthers.getEqualMatchFromStringToList(selectedDB, VL.getDBData(), -1, true)) {
                  VL.getLBDB().setForeground(Color.WHITE);
                  VL.getLBDB().setText("Database");
                  countB++;
            } else {
                  VL.getLBUser().setForeground(Color.RED);
                  VL.getLBUser().setText("Not Found Database");
            }
            //++++++++++++++++++++++++++++++++++++
            if (countB == 2 && VF_R.getJF() != null) {
                  VF_R.getJF().dispose();
                  try {
                        Thread.sleep(1000);
                  } catch (InterruptedException ex) {
                        Logger.getLogger(BTNLogin_AL.class.getName()).log(Level.SEVERE, null, ex);
                  }

                  DTSQL.setUser(selectedUser);
                  DTSQL.setPassw(selectedPass);
                  DTSQL.setDatabase(selectedDB);
                  //++++++++++++++++++++++++++++++++
                  if (VL.getCKB_Default().isSelected()) {
                        Object[] newValues = new Object[]{selectedUser, selectedPass, selectedDB};
                        /*
                        ms.insert(DTSQL.defaultUserTable,
                                DTSQL.defaultUserTableColumns, newValues, 0,
                                null);
                        */
                        ms.updateRow(DTSQL.defaultUserTable, 
                                DTSQL.defaultUserTableColumns, newValues, 1, null);
                  } else {
                        if (VL.getDefaultUser()) {
                              ms.deleteRow(DTSQL.defaultUserTable, 1, null);
                              VL.setDefaultUser(false);
                        }
                  }
            }
            //++++++++++++++++++++++++++++++++
            new VF_R();
      }

      private void resetLBS() {
            VL.getLBUser().setForeground(Color.WHITE);
            VL.getLBUser().setText("User");
            VL.getLBPass().setForeground(Color.WHITE);
            VL.getLBPass().setText("Password");
            VL.getLBDB().setForeground(Color.WHITE);
            VL.getLBDB().setText("Database");
      }

}
