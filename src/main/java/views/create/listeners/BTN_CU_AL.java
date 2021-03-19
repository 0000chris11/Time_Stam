/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import MC.DT;
import MC.DTSQL;
import MC.MainInstances;
import MC.Status;
import SQL.DefaultConnection;
import SQL.SQLQuerys;
import SQLActions.SelectKeys;
import SQLActions.SelectTables;
import SQLStores.TableDistC;
import SQLStores.TablesDists;
import com.cofii2.myInterfaces.IUpdates;
import com.cofii2.mysql.MSQL;
import com.cofii2.mysql.MSQL1;
import com.cofii2.mysql.MSQLCreate;
import com.cofii2.stores.CC;
import com.cofii2.stores.DInt;
import com.cofii2.stores.IntBoolean;
import com.cofii2.stores.IntString;
import com.cofii2.stores.TString;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import views.createUpdate.VC_R_Comps;
import views.createUpdate.VC_R_DataCom;
import views.first.MENU;

/**
 *
 * @author C0FII
 */
public class BTN_CU_AL implements ActionListener {

      private VC_R_DataCom dt = MainInstances.getVC_R_DataCom();
      private static VC_R_Comps c = MainInstances.getVC_R_Comps();
      //private int countO = -1;

      private boolean tableCreation = false;
      private boolean tableInsertion = false;

      MSQL ms = new MSQL(DTSQL.getURLConnection(), DTSQL.getUser(), DTSQL.getPassw());

      //+++++++++++++++++++++++++++++++++++++++++++++++++
      @Override
      public void actionPerformed(ActionEvent e) {
            create();
            
            try {
                  ms.getConnection().close();
            } catch (SQLException ex) {
                  Logger.getLogger(BTN_CU_AL.class.getName()).log(Level.SEVERE, null, ex);
            }
      }

      private void create() {
            System.out.println(CC.GREEN + "\nCreate Table" + CC.RESET);
            int countV = 0;//TFS VISIBLE COLUMNS
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (c.getTFS()[a].isVisible()) {
                        countV++;
                  }
            }
            System.out.println("'\tColumns Visible: " + countV);

            boolean columnsNameCorrect = TFSControl(countV);//IF THE COLUMNS NAMES HAVE NO ERRORS
            boolean tableMatch = tableControl(dt.getTF_Title().getText()); //IF TABLE DOESN'T MATCH WITH AN EXISTING ONE
            if (!columnsNameCorrect) {
                  Status.startLBStatus(dt.getLB_Status(), Color.YELLOW, "The Columns Fields are empty or they have errors", 4000);
            }
            if (tableMatch) {
                  Status.startLBStatus(dt.getLB_Status(), Color.YELLOW, "Table field is empty or it have errors", 4000);
            }
            if (columnsNameCorrect && !tableMatch) {
                  System.out.println("\t\tColumns and table = OK");

                  String table = dt.getTF_Title().getText();//TABLE NAME
                  //+++++++++++++++++++++++++++++++++++++++++++++++++++++
                  tableCreation(countV, table);
                  distsCreation(table);
                  System.out.println("\t\ttableCreation: " + tableCreation);
                  System.out.println("\t\ttableInsertion: " + tableInsertion);
                  if (tableCreation && tableInsertion) {
                        Status.startLBStatus(dt.getLB_Status(), Color.GREEN, "Table \"" + table + "\" has been created", 5000);
                        MSQL1 ms1 = new MSQL1(new DefaultConnection());
                        ms1.select(SQLQuerys.SELECT_KEYS, new SelectKeys());

                        ms.selectData(DTSQL.mainTable, new SelectTables());
                        MENU.addItemToMenus();
                        MENU.setColorToDItem(TableDistC.getTable(), DT.getDTable());

                  } else {
                        Status.startLBStatus(dt.getLB_Status(), Color.YELLOW, "Table \"" + table + "\" fail to be created", 5000);
                  }

            }

      }

      private void tableCreation(int countV, String table) {
            String[] colNames = new String[countV];//COLUMNS NAMES

            String[] types = new String[countV];//TYPES
            DInt[] typesWidth = new DInt[countV];

            IntBoolean[] nulls = new IntBoolean[countV];//NULLS ALLOWED

            int[] PKCol = new int[countV];
            String PKColName = null;//PRIMARY KEY COLUMN NAME

            String FKColName = null;//FOREIGN KEY COLUMN NAME
            String FKReferences = null;//FOREIGN KEY REFERENCES

            IntString[] defaults = new IntString[countV];//COLUMNS DEFAULT VALUES

            int extraCol = c.getRB_ExtraSelected();//COLUMN THAT HAVE EXTRA TYPE
            String extraType = null;//AUTO_INCREMNET OR IDENTITY
            int IDEN_STAR = 0;
            int IDEN_INCREASE = 0;
            //ARRAYS ++++++++++++++++++++++++++++++++++++++++
            for (int a = 0; a < countV; a++) {
                  colNames[a] = c.getTFS()[a].getText();

                  types[a] = c.getCBSTypes()[a].getSelectedItem().toString();
                  if (c.getTFSTypes()[a].isVisible()) {
                        int width = Integer.parseInt(c.getTFSTypes()[a].getText());
                        typesWidth[a] = new DInt(a + 1, width);
                  } else {
                        typesWidth[a] = null;
                  }

                  boolean value = c.getCKSNulls()[a].isSelected();
                  nulls[a] = new IntBoolean(a + 1, value);

                  if (c.getRBSDefaults()[a].isSelected() && !c.getTFSDefaults()[a].getForeground().equals(Color.RED)) {
                        String string = c.getTFSDefaults()[a].getText();
                        defaults[a] = new IntString(a + 1, string);
                  } else {
                        defaults[a] = null;
                  }
            }
            //SINGLE RB SELECTION +++++++++++++++++++++++++++++++
            ArrayList<String> listPK = new ArrayList<String>();
            for (int a = 0; a < countV; a++) {
                  if (c.getRBS_PK()[a].isSelected()) {
                        listPK.add(colNames[a]);

                  }
            }
            ArrayList<TString> listFK = new ArrayList<TString>();
            for (int a = 0; a < countV; a++) {
                  if (c.getRBS_FK()[a].isSelected()) {
                        String ref = c.getCBS_FK()[a].getSelectedItem().toString();
                        String tableR = ref.substring(0, ref.indexOf("."));
                        String colR = ref.substring(ref.indexOf(".") + 1, ref.length() - 1);
                        listFK.add(new TString(colNames[a], tableR, colR));

                  }
            }

            if (extraCol > 0) {
                  if (c.getRBSExtra()[extraCol - 1].isEnabled()) {
                        extraType = "AUTO_INCREMENT";
                  }
                  /*
                  //IF IS IDENTITY
                  if (c.getCBSExtra()[extraCol - 1].getSelectedIndex() == 1) {
                        IDEN_STAR = Integer.parseInt(c.getTFSIDEN1()[extraCol - 1].getText());
                        IDEN_INCREASE = Integer.parseInt(c.getTFSIDEN2()[extraCol - 1].getText());

                        extraType += "(" + IDEN_STAR + ", " + IDEN_INCREASE + ")";
                  }
                   */
            }
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
            printTableCreationInfo(countV, table, colNames, types, typesWidth, nulls,
                    listPK, listFK, defaults, extraType, extraCol);
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
            
            MSQLCreate mc = new MSQLCreate(new DefaultConnection());
            mc.setAllTypesWidths(typesWidth);
            mc.setAllAllowsNulls(nulls);
            mc.setAllDefaults(defaults);

            if (extraType != null) {
                  if (extraType.equals("AUTO_INCREMENT") && extraCol > 0) {
                        mc.setAutoIncrement(extraCol);
                  }
                  /*else if (extraType.equals("IDENTITY") && extraCol > 0) {
                        mc.setIdentity(extraCol, new DInt(IDEN_STAR, IDEN_INCREASE));
                  }*/
            }

            if (!listPK.isEmpty()) {
                  mc.addAllPrimaryKeys(listPK);
            }
            if (!listFK.isEmpty()) {
                  mc.addAllForeignKeys(listFK);
            }
            mc.createTable(table, colNames, types, new IUpdates() {
                  @Override
                  public void executeResultRowN() {
                        
                  }

                  @Override
                  public void executeResult0() {
                        tableCreation = true;
                  }

                  @Override
                  public void exception(SQLException ex) {
                        ex.printStackTrace();
                  }
            });
            /*
            ms.createTable(table,
                    colNames, types, nulls, new IntString(extraCol, extraValue), pkCol,
                    new Update("CreateTable", dt.getLB_Status()));
             */

      }
      
      private void printTableCreationInfo(int countV, 
              String table, String[] colNames, String[] types, DInt[] typesWidth, IntBoolean[] nulls,
              ArrayList<String> listPK, ArrayList<TString> listFK, IntString[] defaults,
              String extraType, int extraCol){
            System.out.println("\n+++++++CREATE TABLE VARIABLES+++++++");
            System.out.println("\tTable: " + table);
            int c = 1;
            for (String x : colNames) {
                  System.out.println("\tColumns " + c++ + ": " + x);
            }
            System.out.println();
            c = 1;
            for (int a = 0; a < countV; a++) {
                  System.out.println("\tTypes " + c + ": " + types[a]);
                  System.out.println("\t\tTypes Width " + c++ + ": " + typesWidth[a].index1 + " - " + typesWidth[a].index2);
            }
            System.out.println();
            c = 1;
            for (IntBoolean x : nulls) {
                  System.out.println("\tNulls " + c++ + ": " + x.bool);
            }
            System.out.println();
            c = 1;
            for(String x : listPK){
                  System.out.println("\tPK " + c++ + ": " + x);
            }
            System.out.println();
            c = 1;
            for(TString x : listFK){
                  System.out.println("\tFK " + c++ + ": " + x.string1 + " REFERENCES " + x.string2 + " - " + x.string3);
            }

            c = 1;
            for (IntString x : defaults) {
                  if (x != null) {
                        System.out.println("\tDefaults " + c++ + ": " + x.string);
                  } else {
                        System.out.println("\tDefaults " + c++ + ": null");
                  }
            }

            System.out.println("\n\tExtraType: " + extraType + " (" + extraCol + ")");
            //System.out.println("\t\tIDEN_STAR: " + IDEN_STAR);
            //System.out.println("\t\tIDEN_INCREASE: " + IDEN_INCREASE);
      }

      private void distsCreation(String table) {
            //INSERT TABLE ON MAINTTABLES++++++++++++++++++++++++++
            String url = "NONE";
            Path imageCPath = Paths.get(url);
            Object[] newValues = new Object[]{null, table,
                  dt.getLBADist().getText(),
                  dt.getLBADist2().getText(),
                  dt.getLBAImageC().getText(),
                  url,
                  dt.getLBATag().getText(),
                  dt.getLBAClock().getText()};

            if (dt.getTFImageC().isVisible() && !Files.exists(imageCPath)) {
                  Status.startLBStatus(dt.getLB_Status(), Color.YELLOW, "Path to folder does not exist", 5000);
            } else if (dt.getTFImageC().isVisible() && Files.exists(imageCPath)) {
                  System.out.println("TEST PATH: " + url);
                  String newUrl = url.replace("\\", "\\\\");//PatternSyntaxException
                  newValues[5] = newUrl;

                  System.out.println("\n+++++++INSERT TABLE+++++++");
                  System.out.println("\tTable: " + DTSQL.mainTable);
                  int c = 1;
                  for (int a = 0; a < newValues.length; a++) {
                        System.out.println("\t" + DTSQL.mainTableColumns[a] + ": " + newValues[a]);
                  }

                  ms.insert(DTSQL.mainTable, DTSQL.mainTableColumns, newValues, 1, new IUpdates() {
                        @Override
                        public void executeResultRowN() {
                              tableInsertion = true;
                        }

                        @Override
                        public void executeResult0() {

                        }

                        @Override
                        public void exception(SQLException ex) {
                              ex.printStackTrace();
                        }

                  });

            }

      }

      //++++++++++++++++++++++++++++++++++++++++++++++
      private boolean TFSControl(int cv) {
            boolean tfOK = false;
            boolean tfDefaultOK = false;
            //IF EACH JTF HAS TEXT AND NO SQL ERRORS
            for (int a = 0; a < cv; a++) {
                  //IF THE COLUMNS ARE CORRECT
                  JTextField TF = c.getTFS()[a];
                  if (!TF.getText().isEmpty()) {
                        if (!TF.getForeground().equals(Color.RED)
                                && !c.getHeaders()[1].getForeground().equals(Color.RED)) {
                              tfOK = true;//OK
                        } else {
                              tfOK = false;
                              break;
                        }
                  }
            }
            //IF TFS DEFAUTLS ARE OK
            for (int a = 0; a < cv; a++) {
                  JTextField TF = c.getTFSDefaults()[a];
                  if (!TF.getText().isEmpty()) {
                        if (!TF.getForeground().equals(Color.RED)) {
                              tfDefaultOK = true;//OK
                        }else{
                              tfDefaultOK = false;
                              break;
                        }
                  }
            }
            
            if(tfOK && tfDefaultOK){
                  return true;
            }else{
                  return false;
            }
      }

      private boolean tableControl(String table) {
            boolean match = false;
            if (!table.isEmpty()) {
                  ArrayList<String> listT = TablesDists.getTableList();
                  for (int b = 0; b < listT.size(); b++) {
                        if (table.equalsIgnoreCase(
                                listT.get(b))) {
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
