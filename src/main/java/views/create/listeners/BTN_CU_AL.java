/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import views.create.VC_R2;
import MC.DT;
import MC.DTSQL;
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

      MSQL ms = new MSQL(DTSQL.urlConnection, DTSQL.user, DTSQL.passw);

      public BTN_CU_AL(String choice) {
            Choice = choice;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
            if (Choice.equals("CREATE")) {
                  create();
            } else if (Choice.equals("UPDATE")) {

            }
      }
      
      private void create(){
            int countV = 0;
                  //HOW MANY COLS ARE VISIBLE
                  for (int a = 0; a < DT.maxColumns; a++) {
                        if (VC_R2.getTFS()[a].isVisible()) {
                              countV++;
                        }
                  }
                  System.out.println("'\tColumns Visible: " + countV);

                  TFSControl(countV);
                  boolean tableMatch = tableControl(VC_R2.getTF_Title().getText());

                  if (countV == countO && tableMatch == false) {
                        //GETTING VALUES TO CREATE THE TABLE++++++++++++++++++++++
                        String table = VC_R2.getTF_Title().getText();
                        String[] colNames = new String[countV];
                        String[] types = new String[countV];
                        boolean[] nulls = new boolean[countV];

                        for (int a = 0; a < countV; a++) {
                              colNames[a] = VC_R2.getTFS()[a].getText();
                              types[a] = VC_R2.getCombTypes1()[a].getSelectedItem().toString();
                              nulls[a] = VC_R2.getCheckbs()[a].isSelected();
                        }
                        
                        int colType2 = VC_R2.getRB_Types2Selected();
                        String type2 = null;
                        if (colType2 > 0) {
                              type2 = VC_R2.getCombTypes2()[colType2 - 1].getSelectedItem().toString();
                              //IF IS IDENTITY
                              if(VC_R2.getCombTypes2()[colType2 - 1].getSelectedIndex() == 1){
                                    type2 += "(" + VC_R2.getTFSTypes1()[colType2 - 1].getText()
                                            + ", " + VC_R2.getTFSTypes2()[colType2 - 1].getText() + ")";
                              }
                        }
                        //==============================================
                        ms.createTable(table, 
                                colNames, types, nulls, colType2, type2,
                                new Update("CreateTable", VC_R2.getLB_Status()));
                        //==============================================        
                        //INSERT TABLE ON MAINTTABLES++++++++++++++++++++++++++
                        Object[] newValues = new Object[]{null, table, 
                              VC_R2.getLB_ADisp()[0],//DIST1
                              VC_R2.getLB_ADisp()[1],//DIST2
                              VC_R2.getLB_ADisp()[2],//IMAGEC
                              VC_R2.getLB_ADisp()[3],//TAG
                              VC_R2.getLB_ADisp()[4]};//CLOCK
                        //==============================================
                        ms.insert(DTSQL.mainTable, DTSQL.mainTableColumns, newValues, colType2, 
                                new Update("INSERT", VC_R2.getLB_Status()));
                        //==============================================
                  } else {
                        Status.startLBStatus(VC_R2.getLB_Status(), Color.YELLOW,
                                "Unable to Create Table ->Check For Errors<-", 5000);
                  }
      }

      private void TFSControl(int cv) {
            countO = 0;
            //int countC = 0;
            //IF EACH JTF HAS TEXT AND NO SQL ERRORS
            for (int a = 0; a < cv; a++) {
                  //IF THE COLUMNS ARE CORRECT
                  if (!VC_R2.getTFS()[a].getText().isEmpty()) {
                        if (!VC_R2.getTFS()[a].getForeground().equals(Color.RED)
                                && !VC_R2.getLBS()[a].getForeground().equals(Color.RED)) {
                              System.out.println("\t\tCNEEDED " + (cv) + " = " + countO);
                              //countC++;
                              countO++;//count up only if it meats these conditions

                        }
                  }
            }
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
            } else {
                  match = true;
            }
            if (match == false) {

            } else {

            }
            return match;
      }

}
