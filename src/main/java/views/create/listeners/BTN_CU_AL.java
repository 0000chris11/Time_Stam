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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;
import views.create.VC_R_DataCom;
import views.first.listeners.MITableOptions_AL;

/**
 *
 * @author C0FII
 */
public class BTN_CU_AL implements ActionListener {

      private VC_R_DataCom dt = MITableOptions_AL.getVCreateData();

      private String Choice;
      private int countO = -1;

      MSQL ms = new MSQL(DTSQL.getURLConnection(), DTSQL.getUser(), DTSQL.getPassw());

      public BTN_CU_AL(String choice) {
            Choice = choice;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
            if (Choice.equals("CREATE")) {
                  create();
            } else if (Choice.equals("UPDATE")) {

            }
            try {
                  ms.getConnection().close();
            } catch (SQLException ex) {
                  Logger.getLogger(BTN_CU_AL.class.getName()).log(Level.SEVERE, null, ex);
            }
      }

      private void create() {
            System.out.println(CC.GREEN + "\nCreate Table" + CC.RESET);
            int countV = 0;
            //HOW MANY COLS ARE VISIBLE
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (dt.getTFS()[a].isVisible()) {
                        countV++;
                  }
            }
            System.out.println("'Columns Visible: " + countV);

            TFSControl(countV);
            boolean tableMatch = tableControl(dt.getTF_Title().getText());

            if (countV == countO && tableMatch == false) {
                  System.out.println("\tColumns and table = OK");
                  //GETTING VALUES TO CREATE THE TABLE++++++++++++++++++++++
                  String table = dt.getTF_Title().getText();
                  String[] colNames = new String[countV];
                  String[] types = new String[countV];
                  boolean[] nulls = new boolean[countV];

                  for (int a = 0; a < countV; a++) {
                        colNames[a] = dt.getTFS()[a].getText();
                        types[a] = dt.getCombTypes()[a].getSelectedItem().toString();
                        nulls[a] = dt.getCheckbNulls()[a].isSelected();
                  }

                  int extraCol = dt.getRB_ExtraSelected();
                  String extraValue = null;
                  if (extraCol > 0) {
                        extraValue = dt.getCombTypes2()[extraCol - 1].getSelectedItem().toString();
                        //IF IS IDENTITY
                        if (dt.getCombTypes2()[extraCol - 1].getSelectedIndex() == 1) {
                              extraValue += "(" + dt.getTFSTypes1()[extraCol - 1].getText()
                                      + ", " + dt.getTFSTypes2()[extraCol - 1].getText() + ")";
                        }
                  }

                  int pkIndex = dt.getRB_PKSelected();
                  String pkCol = null;
                  if (pkIndex > 0) {
                        pkCol = colNames[dt.getRB_PKSelected() - 1];
                  }
                  //==============================================
                  /*
                        String table, String[] colNames, String[] types, boolean[] nulls,
                              int extraCol, String extraValue, String primaryKey, IUpdates iu
                   */
                  System.out.println("\n+++++++CREATE TABLE VARIABLES+++++++");
                  System.out.println("\tTable: " + table);
                  int c = 1;
                  for (String x : colNames) {
                        System.out.println("\tColumns " + c++ + ": " + x);
                  }
                  c = 1;
                  for (String x : types) {
                        System.out.println("\tTypes " + c++ + ": " + x);
                  }
                  c = 1;
                  for (boolean x : nulls) {
                        System.out.println("\tNulls " + c++ + ": " + x);
                  }
                  System.out.println("\tExtraCol: " + extraCol);
                  System.out.println("\tExtraValue: " + extraValue);
                  System.out.println("\tPKCol: " + pkCol);

                  ms.createTable(table,
                          colNames, types, nulls, extraCol, extraValue, pkCol,
                          new Update("CreateTable", dt.getLB_Status()));

                  //==============================================        
                  //INSERT TABLE ON MAINTTABLES++++++++++++++++++++++++++
                  Object[] newValues = new Object[]{null, table,
                        dt.getLB_ADisp()[0].getText(),//DIST1
                        dt.getLB_ADisp()[1].getText(),//DIST2
                        dt.getLB_ADisp()[2].getText(),//IMAGEC
                        dt.getLB_ADisp()[3].getText(),//TAG
                        dt.getLB_ADisp()[4].getText()};//CLOCK
                  //==============================================
                  System.out.println("\n+++++++INSERT TABLE+++++++");
                  System.out.println("\tTable: " + DTSQL.mainTable);
                  c = 1;
                  for (String x : DTSQL.mainTableColumns) {
                        System.out.println("\tColumns " + c++ + ": " + x);
                  }
                  c = 1;
                  for (Object x : newValues) {
                        System.out.println("\tnewValues " + c++ + ": " + x);
                  }
                  System.out.println("\textraCol: " + 1);

                  ms.insert(DTSQL.mainTable, DTSQL.mainTableColumns, newValues, 1,
                          new Update("INSERT", dt.getLB_Status()));

                  //==============================================
            } else {
                  System.out.println("\tColumns and table = NOT OK");
                  Status.startLBStatus(dt.getLB_Status(), Color.YELLOW,
                          "Unable to Create Table ->Check For Errors or Missing Data<-", 5000);
            }
      }

      private void TFSControl(int cv) {
            countO = 0;
            //int countC = 0;
            //IF EACH JTF HAS TEXT AND NO SQL ERRORS
            for (int a = 0; a < cv; a++) {
                  //IF THE COLUMNS ARE CORRECT
                  JTextField TF = dt.getTFS()[a];
                  if (!TF.getText().isEmpty()) {
                        if (!TF.getForeground().equals(Color.RED)
                                && !dt.getHeaders()[1].getForeground().equals(Color.RED)) {
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
