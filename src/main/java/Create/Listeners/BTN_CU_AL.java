/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Create.Listeners;

import Create.VC_R2;
import MC.DT;
import MC.Status;
import SQLActions.Update;
import com.cofii.myClasses.CC;
import com.cofii.myClasses.MSQL;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author C0FII
 */
public class BTN_CU_AL implements ActionListener {

      private String Choice;
      private int countO = -1;

      MSQL ms = new MSQL(DT.urlConnection, DT.user, DT.passw);

      public BTN_CU_AL(String choice) {
            Choice = choice;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
            if (Choice.equals("CREATE")) {
                  int countV = 0;

                  //HOW MANY COLS ARE VISIBLE
                  for (int a = 0; a < DT.maxColumns; a++) {
                        if (VC_R2.getTFS()[a].isVisible()) {
                              countV++;
                        }
                  }
                  System.out.println("'\tColumns Visible: " + countV);

                  String[] cols = TFSControl(countV);
                  boolean tableMatch = tableControl(VC_R2.getTF_Title().getText());
                  if (countV == countO && tableMatch == false) {

                        String table = VC_R2.getTF_Title().getText();
                        String[] colNames = new String[countV];
                        String[] types = new String[countV];
                        boolean[] nulls = new boolean[countV];
                        for (int a = 0; a < countV; a++) {
                              colNames[a] = VC_R2.getTFS()[a].getText();
                              types[a] = VC_R2.getCombs()[a].getSelectedItem().toString();
                              nulls[a] = VC_R2.getCheckbs()[a].isSelected();
                        }

                        ms.createTable(table, colNames, types, nulls,
                                new Update("CreateTable", VC_R2.getLB_Status()));
                  } else {
                        Status.startLBStatus(VC_R2.getLB_Status(), Color.YELLOW,
                                "Unable to Create Table ->Check Errors<-", 5000);
                  }

            } else if (Choice.equals("UPDATE")) {

            }
      }

      private String[] TFSControl(int cv) {
            countO = 0;
            int countC = 0;
            String[] cols = new String[cv];
            //IF EACH JTF HAS TEXT AND NO SQL ERRORS
            for (int a = 0; a < cv; a++) {
                  //IF THE COLUMNS ARE OK
                  if (!VC_R2.getTFS()[a].getText().isEmpty()) {
                        if (!VC_R2.getTFS()[a].getForeground().equals(Color.RED)
                                && !VC_R2.getLBS()[a].getForeground().equals(Color.RED)) {
                              System.out.println("\t\tCNEEDED " + (cv) + " = " + countC);
                              cols[countC] = VC_R2.getTFS()[a].getText();
                              countC++;//count up only if it meats the conditions
                              countO++;

                        }
                  }
            }
            return cols;
      }

      private boolean tableControl(String table) {
            boolean match = false;
            if (!table.isEmpty()) {
                  for (int b = 0; b < DT.getList_T().size(); b++) {
                        if (table.equalsIgnoreCase(
                                DT.getList_T().get(b))) {
                              match = true;
                        } else {
                              if (match != true) {
                                    match = false;
                              }
                        }
                  }
            }else{
                  match = true;
            }
            if (match == false) {
                  
            } else {
                  
            }
            return match;
      }

}
