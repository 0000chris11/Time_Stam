package MC;

import First.VF_R;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ArrayMethods.Instance;
import Others.CC;

/**
 *
 * @author Christopher
 */
public class MakeCon {

      String CName = this.getClass().getName();
      //Data dt = new Data("MakeCon");
      Status st = new Status();

      ArrayList<Object>[] listsN = new ArrayList[]{DT.getList_1(), DT.getList_2(),
            DT.getList_3(), DT.getList_4(), DT.getList_5(), DT.getList_6()};

      Connection con;
      final String urlConnection
              = "jdbc:mysql://localhost:3306/"
              + "TIME_STAM?allowPublicKeyRetrieval=true&"
              + "useSSL=false&"
              + "useJDBCCompliantTimezoneShift=true&"
              + "useLegacyDatetimeCode=false&"
              + "serverTimezone=UTC";
      
      final String user = "root";
      final String passw = "ccfmps00112";

      String query;
      Statement stt;
      PreparedStatement pstt;
      ResultSet rs;

      public MakeCon(String from, int CC) {
            DT.getConstructorName(DT.cons, CName, from, CC);
      }

      //++++++++++++++++++++++++++++++++++
      public void SelectConfig() {
            System.out.println(CC.YELLOW + "MakeCon ++++ SelectConfig" + CC.RESET);
            try {
                  con = DriverManager.getConnection(
                          urlConnection, user, passw);

                  String query = "SELECT * FROM Table_Config";
                  stt = con.createStatement();
                  rs = stt.executeQuery(query);

                  DT.getList_TC().clear();
                  DT.getList_BL().clear();
                  while (rs.next()) {
                        DT.getList_TC().add(rs.getString(2));
                        DT.getList_BL().add(rs.getBoolean(3));
                  }
                  //System.out.println("0 AOT: " + DT.getList_BL().get(0));
                  //System.out.println("1: AutoR" + dt.getList_BL().get(1));
                  //System.out.println("2: Grid" + dt.getList_BL().get(2));

            } catch (SQLException ex) {
                  ex.printStackTrace();
                  st.startLBStatus(VF_R.getLB_Status(), DT.RGY[0], 
                          "SelectConfig: " + ex.toString(), 8000);
            }
      }

      public void UpdateConfig(boolean newnv, int id) {
            System.out.println(CC.YELLOW + "MakeCon ++++ UpdateConfig" + CC.RESET);
            try {
                  con = DriverManager.getConnection(
                          urlConnection, user, passw);

                  pstt = con.prepareStatement(
                          "UPDATE Table_Config SET Value = " + newnv + " WHERE id = " + id);
                  //Update Table_Config SET 
                  //System.out.println("UPDATE Table_Config SET Value = " + newnv + " WHERE id = " + id);

                  int ex = pstt.executeUpdate();
                  if (ex == 1) {
                        st.startLBStatus(VF_R.getLB_Status(), DT.RGY[1], "MC-UpdateConfig Done!", 4000);
                  } else {
                        st.startLBStatus(VF_R.getLB_Status(), DT.RGY[2], 
                                "UpdateConfig: " + DT.inter, 8000);
                  }
                  //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

            } catch (SQLException ex) {
                  ex.printStackTrace();
                  st.startLBStatus(VF_R.getLB_Status(), DT.RGY[0], 
                          "UpdateConfig: " + ex.toString(), 8000);
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++
      public void SelectDefaultTable() {
            System.out.println(CC.YELLOW + "MakeCon ++++ SelectDefaultTable" + CC.RESET);
            try {
                  con = DriverManager.getConnection(
                          urlConnection, user, passw);
                  //jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC

                  //Table_Names ON Default_Table.id = Table_Names.id;
                  String query = "SELECT Default_Table.id, Name, Dist1, Dist2, Tabl, Tag1, Clock FROM Default_Table "
                          + "LEFT JOIN Table_Names ON Default_Table.id = Table_Names.id";
                  stt = con.createStatement();
                  rs = stt.executeQuery(query);

                  while (rs.next()) {
                        DT.setId(rs.getString(1));
                        DT.setTable(rs.getString(2));
                        DT.setDTable(rs.getString(2));
                        DT.setDist1(rs.getString(3));
                        DT.setDist2(rs.getString(4));
                        DT.setTabl(rs.getString(5));
                        DT.setTag(rs.getString(6));
                        DT.setClock(rs.getString(7));
                  }

                  //System.out.println("\t0 Table: " + DT.getTable());

            } catch (SQLException ex) {
                  ex.printStackTrace();
                  st.startLBStatus(VF_R.getLB_Status(), DT.RGY[0], 
                          "SelectDefaultTable: " + ex.toString(), 8000);
            }

      }

      public void SelectTables() {
            System.out.println(CC.YELLOW + "MakeCon ++++ SelectTables" + CC.RESET);
            try {
                  con = DriverManager.getConnection(
                          urlConnection, user, passw);
                  
                  String query = "SELECT * FROM Table_Names";
                  Statement st = con.createStatement();
                  ResultSet rs = st.executeQuery(query);

                  DT.getList_id().clear();
                  DT.getList_T().clear();
                  DT.getList_Dist1().clear();
                  DT.getList_Dist2().clear();
                  DT.getList_Tabl().clear();
                  DT.getList_Tag().clear();

                  while (rs.next()) {
                        DT.getList_id().add(rs.getString(1));
                        DT.getList_T().add(rs.getString(2));
                        DT.getList_Dist1().add(rs.getString(3));
                        DT.getList_Dist2().add(rs.getString(4));
                        DT.getList_Tabl().add(rs.getString(5));
                        DT.getList_Tag().add(rs.getString(6));
                  }
                  //addItem(DT.getList_id(), dt.getList_T(), dt.getList_Dist1(), dt.getList_Dist2(), dt.getList_Tabl(),
                  //      dt.getList_Tag1(), dt.getList_Tag2());
            } catch (SQLException ex) {
                  ex.printStackTrace();
                  st.startLBStatus(VF_R.getLB_Status(), DT.RGY[0], 
                          "SelectTables: " + ex.toString(), 8000);
            }
      }

      public void SelectATable(String table) {
            System.out.println(CC.YELLOW + "MakeCon ++++ SelectATable" + CC.RESET);
            System.out.println("\tTable: " + table);
            try {
                  con = DriverManager.getConnection(
                          urlConnection, user, passw);

                  String query = "SELECT * FROM Table_Names WHERE Table_Names = \""
                          + table.replaceAll("_", " ") + "\"";
                  System.out.println("\t" + query);
                  stt = con.createStatement();
                  rs = stt.executeQuery(query);

                  while (rs.next()) {
                        DT.setId(rs.getString(1));
                        //D.setTable(rs.getString(2));//SET FROM Action MI
                        DT.setDist1(rs.getString(3));
                        DT.setDist2(rs.getString(4));
                        DT.setTabl(rs.getString(5));
                        DT.setTag(rs.getString(6));
                        DT.setClock(rs.getString(7));
                  }
            } catch (SQLException ex) {
                  ex.printStackTrace();
                  st.startLBStatus(VF_R.getLB_Status(), DT.RGY[0], 
                          "SelectATable: " + ex.toString(), 8000);
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++
      public void SelectColumns(String table) {
            System.out.println(CC.YELLOW + "MakeCon ++++ SelectColumns" + CC.RESET);
            System.out.println("\tTable: " + table);
            try {
                  con = DriverManager.getConnection(
                          urlConnection, user, passw);
                  
                  String query = "SHOW COLUMNS FROM " + table;
                  //System.out.println("SHOW COLUMNS FROM " + table);
                  stt = con.createStatement();
                  rs = stt.executeQuery(query);

                  DT.getList_C().clear();
                  DT.getList_TP().clear();
                  DT.getList_NL().clear();

                  while (rs.next()) {
                        //jm.addColumn(rs.getString(1));
                        DT.getList_C().add(rs.getString(1));
                        DT.getList_TP().add(rs.getString(2));
                        DT.getList_NL().add(rs.getString(3));
                  }

                  //NEED METHOD
                  //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
                  for (int a = 0; a < DT.maxColumns - 1; a++) {
                        if (DT.getList_C().size() == a + 2) {
                              VF_R.getJT().setModel(DT.getDTMS()[a + 2]);
                        }

                        DT.getDTMS()[a + 2].setColumnCount(0);
                        DT.getDTMS()[a + 2].setRowCount((0));
                  }

                  for (int a = 0; a < DT.getList_C().size(); a++) {
                        for (int b = 0; b < DT.maxColumns - 1; b++) {
                              if (DT.getList_C().size() == b + 2) {
                                    DT.getDTMS()[b + 2].addColumn(DT.getList_C().get(a));
                              }
                        }
                  }

            } catch (SQLException ex) {
                  ex.printStackTrace();
                  st.startLBStatus(VF_R.getLB_Status(), DT.RGY[0], 
                          "SelectColumns: " + ex.toString(), 8000);
            }

      }

      public void SelectData(int cols, String table) {
            System.out.println(CC.YELLOW + "MakeCon ++++ SelectData" + CC.RESET);
            System.out.println("\tTable: " + table);
            System.out.println("\tCols: " + cols);
            try {
                  con = DriverManager.getConnection(
                          urlConnection, user, passw);

                  query = "SELECT * FROM " + table + " ORDER BY id";
                  stt = con.createStatement();
                  rs = stt.executeQuery(query);

                  SelectDataForListN(cols, "clear", null);
                  for (int a = 0; a < DT.maxColumns - 1; a++) {
                        DT.getDTMS()[a + 2].setRowCount(0);
                  }

                  Object[] rss = new Object[cols];
                  //int a = 0;
                  while (rs.next()) {
                        rss[0] = rs.getInt(1);
                        for (int a = 1; a < cols; a++) {
                              //if((a + 1) == cols){
                              rss[a] = rs.getString(a + 1);
                              //System.out.println("rs.getString(" + (a + 1) + "): " + rs.getString(a + 1));
                              //}
                        }

                        SelectDataForListN(cols, "add", rss);
                        DT.getDTMS()[cols].addRow(rss);
                  }
            } catch (SQLException ex) {
                  ex.printStackTrace();
                  st.startLBStatus(VF_R.getLB_Status(), DT.RGY[0], 
                          "SelectData: " + ex.toString(), 8000);

            }
      }

      private void SelectDataForListN(int cols, String op, Object[] toAdd) {
            int b = 0;
            for (int a = 0; a < cols; a++) {
                  if (op.equals("clear")) {
                        listsN[a].clear();
                        //System.out.println("\tlist_" + (a + 1) + " size: " + listsN[a].size());
                  } else if (op.equals("add")) {
                        //System.out.println();
                        if (toAdd[b] instanceof Integer) {
                              listsN[a].add((Integer) toAdd[b]);
                        } else if (toAdd[b] instanceof String) {
                              listsN[a].add(toAdd[b].toString());
                        }
                        //System.out.println("\tlist_" + (a + 1) + " adds: " + toAdd[b]);
                        b++;
                  }
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++
      public void ChangeDefault(String idd, String old_idd, String title, String d1, String d2, String tab, String tg1,
              String ck) {
            System.out.println(CC.YELLOW + "MakeCon ++++ ChangeDefault" + CC.RESET);
            try {
                  con = DriverManager.getConnection(
                          urlConnection, user, passw);
                  
                  String sql = "UPDATE Default_Table SET id = "
                          + idd + ", Name = '" + title + "' WHERE id = " + old_idd;

                  System.out.println(sql);

                  PreparedStatement stmt = con.prepareStatement(sql);
                  int i = stmt.executeUpdate();
                  if (i > 0) {
                        DT.setId(idd);
                        DT.setTable(title);
                        DT.setDTable(title);
                        DT.setDist1(d1);
                        DT.setDist2(d2);
                        DT.setTabl(tab);
                        DT.setTag(tg1);
                        DT.setClock(ck);

                        st.startLBStatus(VF_R.getLB_Status(), DT.RGY[1], "MCChangeDefault Done!", 4000);
                  } else {
                        st.startLBStatus(VF_R.getLB_Status(), DT.RGY[2], 
                                "ChangeDefault: " + DT.inter, 8000);
                  }

            } catch (SQLException ex) {
                  ex.printStackTrace();
                  st.startLBStatus(VF_R.getLB_Status(), DT.RGY[0], 
                          "ChangeDefault: " + ex.toString(), 8000);
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++
      public void Insert(String table, int n, ArrayList<String> nvs) {
            System.out.println(CC.YELLOW + "MakeCon ++++ Insert" + CC.RESET);
            System.out.println("\tTable: " + table);
            for (int a = 0; a < nvs.size(); a++) {
                  System.out.println("\tnv " + (a + 1) + ": " + nvs.get(a));
            }
            try {
                  con = DriverManager.getConnection(
                          urlConnection, user, passw);

                  String sql = "INSERT INTO "
                          + table
                          + " ("
                          + DT.getList_C().get(0)
                          + ", "
                          + DT.getList_C().get(1);

                  String end = ") VALUES(";
                  //++++++++++++++++++++++++++++++++
                  for (int b = 0; b < nvs.size() - 1; b++) {
                        sql += ", " + DT.getList_C().get(b + 2);
                  }

                  sql += end;

                  for (int b = 0; b < nvs.size(); b++) {
                        sql += "?,";
                  }

                  sql += "?)";
                  //++++++++++++++++++++++++++++++++
                  //System.out.println("INSERT SQL TEST: " + sql);
                  //System.out.println("n value: " + n);

                  pstt = con.prepareStatement(sql);

                  pstt.setInt(1, n);
                  for (int a = 0; a < nvs.size(); a++) {
                        pstt.setString(a + 2, nvs.get(a));
                  }

                  int i = pstt.executeUpdate();
                  if (i > 0) {
                        listsN[0].add(n);
                        for (int a = 0; a < nvs.size(); a++) {
                              listsN[a + 1].add(nvs.get(a));
                        }

                        st.startLBStatus(VF_R.getLB_Status(), DT.RGY[1], "MC-Insert 2 Done!", 4000);
                  } else {
                        st.startLBStatus(VF_R.getLB_Status(), DT.RGY[2], 
                                "Insert: " + DT.inter, 8000);
                  }
            } catch (SQLException ex) {
                  ex.printStackTrace();
                  st.startLBStatus(VF_R.getLB_Status(), DT.RGY[0], 
                          "Insert: " + ex.toString(), 8000);
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++
      public void UpdateRow(String table, Object[] cols, Object[] newvs, String id) {
            System.out.println(CC.YELLOW + "MakeCon ++++ UpdateRow[]" + CC.RESET);

            try {
                  con = DriverManager.getConnection(
                          urlConnection, user, passw);

                  //int newnv = -1;
                  String upd = upd = "UPDATE " + table + " SET ";;
                  String end = " WHERE id = " + id;
                  for (int a = 0; a < cols.length; a++) {//LOOPS N OF COL(CELL) CHANGED
                        //"UPDATE " + table + " SET " + col + " = " + newnv + " WHERE id= " + id
                        if (a > 0) {
                              //System.out.println("---Second");
                              upd += ", " + cols[a] + " = '" + newvs[a] + "'";
                        } else {
                              if (cols[0].equals("id")) {
                                    //System.out.println("---First id");
                                    upd += cols[a] + " = " + newvs[a];
                              } else {
                                    //System.out.println("---First");
                                    upd += cols[a] + " = '" + newvs[a] + "'";
                              }
                        }

                  }
                  upd += end;

                  System.out.println("\tUPD: " + upd);

                  pstt = con.prepareStatement(upd);
                  int ex = pstt.executeUpdate();
                  if (ex == 1) {
                        //System.out.println("\tDONE");
                        st.startLBStatus(VF_R.getLB_Status(), DT.RGY[1],
                                "MC-Update 1 Done!", 4000);
                  } else {
                        st.startLBStatus(VF_R.getLB_Status(), DT.RGY[2], 
                                "UpdateRow[]: " + DT.inter, 8000);
                  }

            } catch (SQLException ex) {
                  ex.printStackTrace();
                  st.startLBStatus(VF_R.getLB_Status(),
                          DT.RGY[0], "UpdateRow[]: " + ex.toString(), 8000);
            }
      }

      public void UpdateRow(String table, String col, String newv, String id) {
            System.out.println(CC.YELLOW + "MakeCon ++++ UpdateRow" + CC.RESET);

            try {
                  con = DriverManager.getConnection(
                          urlConnection, user, passw);

                  String upd = "ERROR";
                  if (col.equals("id")) {
                        upd = "UPDATE " + table + " SET " + col + " = " + newv + " WHERE id = " + id;
                  } else {
                        upd = "UPDATE " + table + " SET " + col + " = '" + newv + "' WHERE id = " + id;
                  }
                  System.out.println("\tUPD: " + upd);

                  pstt = con.prepareStatement(upd);
                  int ex = pstt.executeUpdate();
                  if (ex == 1) {
                        //System.out.println("\tDONE");
                        st.startLBStatus(VF_R.getLB_Status(), DT.RGY[1],
                                "MC-Update 1 Done!", 4000);
                  } else {
                        st.startLBStatus(VF_R.getLB_Status(), 
                                DT.RGY[2], "UpdateRow: " + DT.inter, 8000);
                  }
            } catch (SQLException ex) {
                  ex.printStackTrace();
                  st.startLBStatus(VF_R.getLB_Status(),
                          DT.RGY[0], "UpdateRow: " + ex.toString(), 8000);
            }
      }

      //+++++++++++++++++++++++++++++++++++++++++++++++++++
      public void Delete(String table, String id) {
            System.out.println(CC.YELLOW + "MakeCon ++++ Delete" + CC.RESET);
            try {
                  con = DriverManager.getConnection(
                          urlConnection, user, passw);

                  pstt = con.prepareStatement("DELETE FROM " + table
                          + " WHERE id = " + id);

                  int ex = pstt.executeUpdate();

                  if (ex == 1) {
                        st.startLBStatus(VF_R.getLB_Status(), DT.RGY[1], "MCDelete Done!", 4000);
                  } else {
                        st.startLBStatus(VF_R.getLB_Status(), DT.RGY[2], 
                                "Delete: " + DT.inter, 8000);
                  }
            } catch (SQLException ex) {
                  ex.printStackTrace();
                  st.startLBStatus(VF_R.getLB_Status(), DT.RGY[0], 
                          "Delete: " + ex.toString(), 8000);
            }
      }

      //+++++++++++++++++++++++++++++++++++++++++++++++++++
      public void UpdateTEST(String table, String[] cols, String[] newvs, String id) {
            int newnv = -1;
            String upd = upd = "UPDATE " + table + " SET ";;
            String end = " WHERE id = " + id;
            for (int a = 0; a < cols.length; a++) {//LOOPS N OF COL(CELL) CHANGED
                  //"UPDATE " + table + " SET " + col + " = " + newnv + " WHERE id= " + id
                  if (a > 0) {
                        System.out.println("---Second");
                        upd += ", " + cols[a] + " = '" + newvs[a] + "'";
                  } else {
                        if (cols[0].equals("id")) {
                              System.out.println("---First id");
                              upd += cols[a] + " = " + newvs[a];
                        } else {
                              System.out.println("---First");
                              upd += cols[a] + " = '" + newvs[a] + "'";
                        }
                  }

            }
            upd += end;

            System.out.println("\tUPD: " + upd);
      }

      public void InsertTEST(String table, int n, ArrayList<String> nvs) {
            String sql = "INSERT INTO "
                    + table
                    + " ("
                    + DT.getList_C().get(0)
                    + ", "
                    + DT.getList_C().get(1);

            String end = ") VALUES(";
            //+++++++++++++++++++++++++++++++++++++++
            for (int b = 0; b < nvs.size() - 1; b++) {
                  sql += ", " + DT.getList_C().get(b + 2);
            }

            sql += end;

            for (int b = 0; b < nvs.size(); b++) {
                  sql += "?,";
            }

            sql += "?)";
            //+++++++++++++++++++++++++++++++++++++++
            //System.out.println("INSERT SQL TEST: " + sql);
      }

      //+++++++++++++++++++++++++++++++++++++++++++++++++++
      public void MCInsertSelectD1(String table, String c1, ArrayList<String> list1) {//DISTINCT
            System.out.println(CC.YELLOW + "MakeCon ++++ MCInsertSelectD1" + CC.RESET);
            try {
                  con = DriverManager.getConnection(
                          urlConnection, user, passw);

                  String query = "SELECT DISTINCT " + c1 + " FROM " + table + " ORDER BY " + c1;
                  stt = con.createStatement();
                  System.out.println("\t" + query);
                  rs = stt.executeQuery(query);

                  list1.clear();

                  while (rs.next()) {
                        list1.add(rs.getString(1));
                  }

            } catch (SQLException ex) {
                  ex.printStackTrace();
                  st.startLBStatus(VF_R.getLB_Status(), DT.RGY[0], 
                          "MCInsertSelectD1: " + ex.toString(), 8000);
            }
      }

      public void MCInsertSelectD2(String table, String c1, String c2,
              ArrayList<String> list1, ArrayList<String> list2) {
            System.out.println(CC.YELLOW + "MakeCon ++++ MCInsertSelectD2" + CC.RESET);
            try {
                  con = DriverManager.getConnection(
                          urlConnection, user, passw);

                  String query = "SELECT DISTINCT " + c1 + ", " + c2 + " FROM " + table + " ORDER BY " + c1;
                  System.out.println("\t" + query);
                  stt = con.createStatement();
                  rs = stt.executeQuery(query);

                  list1.clear();
                  list2.clear();

                  while (rs.next()) {
                        list1.add(rs.getString(1));
                        list2.add(rs.getString(2));
                  }
            } catch (SQLException ex) {
                  ex.printStackTrace();
                  st.startLBStatus(VF_R.getLB_Status(), DT.RGY[0], 
                          "MCInsertSelectD2: " + ex.toString(), 8000);
            }
      }
      //=======================================================
      /*
      public void MCSelect2(String table) {
            try {
                  con = DriverManager.getConnection(
                          "jdbc:mysql://localhost:3306/TIME_STAM?allowPublicKeyRetrieval=true&useSSL=false",
                          "root",
                          "ccfmps00112");

                  String query = "SELECT * FROM " + table + " ORDER BY id";
                  Statement st = con.createStatement();
                  ResultSet rs = st.executeQuery(query);

                  dt.getList_1().clear();
                  dt.getList_2().clear();

                  jm2.setRowCount(0);

                  while (rs.next()) {
                        dt.getList_1().add(rs.getInt(1));
                        dt.getList_2().add(rs.getString(2));

                        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                        Object DTT[] = {rs.getInt(1), rs.getString(2)};

                        jm2.addRow(DTT);
                        //System.out.println(DTT[0] + "\t" + DTT[1] + "\t" + DTT[2] + "\t" + DTT[3] + "\t" + DTT[4]);
                  }
            } catch (SQLException ex) {
                  Logger.getLogger(VF_R.class.getName()).log(Level.SEVERE, null, ex);

                  st.startLBStatus(lb_Status, cl[0], ex.toString(), 8000);
            }
      }

      public void MCSelect3(String table) {
            try {
                  con = DriverManager.getConnection(
                          "jdbc:mysql://localhost:3306/TIME_STAM?allowPublicKeyRetrieval=true&useSSL=false",
                          "root",
                          "ccfmps00112");

                  String query = "SELECT * FROM " + table + " ORDER BY id";
                  Statement st = con.createStatement();
                  ResultSet rs = st.executeQuery(query);

                  dt.getList_1().clear();
                  dt.getList_2().clear();
                  dt.getList_3().clear();

                  jm3.setRowCount(0);

                  while (rs.next()) {
                        dt.getList_1().add(rs.getInt(1));
                        dt.getList_2().add(rs.getString(2));
                        dt.getList_3().add(rs.getString(3));

                        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                        Object DTT[] = {rs.getInt(1), rs.getString(2), rs.getString(3)};

                        jm3.addRow(DTT);
                        //System.out.println(DTT[0] + "\t" + DTT[1] + "\t" + DTT[2] + "\t" + DTT[3] + "\t" + DTT[4]);
                  }
            } catch (SQLException ex) {
                  Logger.getLogger(VF_R.class.getName()).log(Level.SEVERE, null, ex);

                  st.startLBStatus(lb_Status, cl[0], ex.toString(), 8000);
            }
      }

      public void MCSelect4(String table) {
            try {
                  con = DriverManager.getConnection(
                          "jdbc:mysql://localhost:3306/TIME_STAM?allowPublicKeyRetrieval=true&useSSL=false",
                          "root",
                          "ccfmps00112");

                  String query = "SELECT * FROM " + table + " ORDER BY id";
                  Statement st = con.createStatement();
                  ResultSet rs = st.executeQuery(query);

                  dt.getList_1().clear();
                  dt.getList_2().clear();
                  dt.getList_3().clear();
                  dt.getList_4().clear();

                  jm4.setRowCount(0);

                  while (rs.next()) {
                        dt.getList_1().add(rs.getInt(1));
                        dt.getList_2().add(rs.getString(2));
                        dt.getList_3().add(rs.getString(3));
                        dt.getList_4().add(rs.getString(4));

                        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                        Object DTT[] = {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)};

                        jm4.addRow(DTT);
                        //System.out.println(DTT[0] + "\t" + DTT[1] + "\t" + DTT[2] + "\t" + DTT[3] + "\t" + DTT[4]);
                  }
            } catch (SQLException ex) {
                  Logger.getLogger(VF_R.class.getName()).log(Level.SEVERE, null, ex);

                  st.startLBStatus(lb_Status, cl[0], ex.toString(), 8000);
            }
      }

      public void MCSelect5(String table) {
            try {
                  con = DriverManager.getConnection(
                          "jdbc:mysql://localhost:3306/TIME_STAM?allowPublicKeyRetrieval=true&useSSL=false",
                          "root",
                          "ccfmps00112");

                  String query = "SELECT * FROM " + table + " ORDER BY id";
                  Statement st = con.createStatement();
                  ResultSet rs = st.executeQuery(query);

                  dt.getList_1().clear();
                  dt.getList_2().clear();
                  dt.getList_3().clear();
                  dt.getList_4().clear();
                  dt.getList_5().clear();

                  jm5.setRowCount(0);

                  while (rs.next()) {
                        dt.getList_1().add(rs.getInt(1));
                        dt.getList_2().add(rs.getString(2));
                        dt.getList_3().add(rs.getString(3));
                        dt.getList_4().add(rs.getString(4));
                        dt.getList_5().add(rs.getString(5));

                        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                        Object DTT[] = {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                              rs.getString(5)};

                        jm5.addRow(DTT);
                        //System.out.println(DTT[0] + "\t" + DTT[1] + "\t" + DTT[2] + "\t" + DTT[3] + "\t" + DTT[4]);
                  }
            } catch (SQLException ex) {
                  Logger.getLogger(VF_R.class.getName()).log(Level.SEVERE, null, ex);

                  st.startLBStatus(lb_Status, cl[0], ex.toString(), 8000);
            }
      }

      public void MCSelect6(String table) {
            try {
                  con = DriverManager.getConnection(
                          "jdbc:mysql://localhost:3306/TIME_STAM?allowPublicKeyRetrieval=true&useSSL=false",
                          "root",
                          "ccfmps00112");

                  String query = "SELECT * FROM " + table + " ORDER BY id";

                  //System.out.println("----------------------QUERY: " + query);
                  Statement st = con.createStatement();
                  ResultSet rs = st.executeQuery(query);

                  dt.getList_1().clear();
                  dt.getList_2().clear();
                  dt.getList_3().clear();
                  dt.getList_4().clear();
                  dt.getList_5().clear();
                  dt.getList_6().clear();

                  jm6.setRowCount(0);

                  while (rs.next()) {
                        dt.getList_1().add(rs.getInt(1));
                        dt.getList_2().add(rs.getString(2));
                        dt.getList_3().add(rs.getString(3));
                        dt.getList_4().add(rs.getString(4));
                        dt.getList_5().add(rs.getString(5));
                        //System.out.println("rs.getString: " + rs.getString(6));
                        dt.getList_6().add(rs.getString(6));
                        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                        Object DTT[] = {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                              rs.getString(5), rs.getString(6)};

                        jm6.addRow(DTT);
                        //System.out.println(DTT[0] + "\t" + DTT[1] + "\t" + DTT[2] + "\t" + DTT[3] + "\t" + DTT[4]);
                  }
            } catch (SQLException ex) {
                  Logger.getLogger(VF_R.class.getName()).log(Level.SEVERE, null, ex);

                  st.startLBStatus(lb_Status, cl[0], ex.toString(), 8000);
            }
      }
      
      private void MCInsert2(String table, int n, String d1) {
            try {
                  con = DriverManager.getConnection(
                          "jdbc:mysql://localhost:3306/TIME_STAM?allowPublicKeyRetrieval=true&useSSL=false",
                          "root",
                          "ccfmps00112");

                  PreparedStatement stmt = con.prepareStatement("INSERT INTO " + table
                          + " (" + dt.getList_C().get(0) + ", " + dt.getList_C().get(1) + ") VALUES(?,?)");

                  stmt.setInt(1, n);
                  stmt.setString(2, d1);

                  int i = stmt.executeUpdate();
                  if (i > 0) {
                        dt.getList_1().add(n);
                        dt.getList_2().add(d1);

                        st.startLBStatus(lb_Status, cl[1], "MC-Insert 2 Done!", 4000);
                  } else {
                        st.startLBStatus(lb_Status, cl[2], inter, 48000);
                  }
            } catch (SQLException ex) {
                  Logger.getLogger(VF_R.class.getName()).log(Level.SEVERE, null, ex);

                  st.startLBStatus(lb_Status, cl[0], ex.toString(), 8000);
            }
      }

      private void MCInsert3(String table, int n, String d1, String d2) {
            try {
                  con = DriverManager.getConnection(
                          "jdbc:mysql://localhost:3306/TIME_STAM?allowPublicKeyRetrieval=true&useSSL=false",
                          "root",
                          "ccfmps00112");

                  PreparedStatement stmt = con.prepareStatement("INSERT INTO " + table
                          + " (" + dt.getList_C().get(0) + ", " + dt.getList_C().get(1) + ", "
                          + dt.getList_C().get(2) + ") VALUES(?,?,?)");

                  stmt.setInt(1, n);
                  stmt.setString(2, d1);
                  stmt.setString(3, d2);

                  int i = stmt.executeUpdate();
                  if (i > 0) {
                        dt.getList_1().add(n);
                        dt.getList_2().add(d1);
                        dt.getList_3().add(d2);

                        st.startLBStatus(lb_Status, cl[1], "MC-Insert 3 Done!", 4000);
                  } else {
                        st.startLBStatus(lb_Status, cl[2], inter, 8000);
                  }
            } catch (SQLException ex) {
                  Logger.getLogger(VF_R.class.getName()).log(Level.SEVERE, null, ex);

                  st.startLBStatus(lb_Status, cl[0], ex.toString(), 8000);
            }
      }

      private void MCInsert4(String table, int n, String d1, String d2, String d3) {
            try {
                  con = DriverManager.getConnection(
                          "jdbc:mysql://localhost:3306/TIME_STAM?allowPublicKeyRetrieval=true&useSSL=false",
                          "root",
                          "ccfmps00112");

                  PreparedStatement stmt = con.prepareStatement("INSERT INTO " + table
                          + " (" + dt.getList_C().get(0) + ", " + dt.getList_C().get(1) + ", "
                          + dt.getList_C().get(2) + ", " + dt.getList_C().get(3)
                          + ") VALUES(?,?,?,?)");

                  stmt.setInt(1, n);
                  stmt.setString(2, d1);
                  stmt.setString(3, d2);
                  stmt.setString(4, d3);

                  int i = stmt.executeUpdate();
                  if (i > 0) {
                        dt.getList_1().add(n);
                        dt.getList_2().add(d1);
                        dt.getList_3().add(d2);
                        dt.getList_4().add(d3);

                        st.startLBStatus(lb_Status, cl[1], "MC-Insert 4 Done!", 4000);
                  } else {
                        st.startLBStatus(lb_Status, cl[2], inter, 8000);
                  }
            } catch (SQLException ex) {
                  Logger.getLogger(VF_R.class.getName()).log(Level.SEVERE, null, ex);

                  st.startLBStatus(lb_Status, cl[0], ex.toString(), 8000);
            }
      }

      private void MCInsert5(String table, int n, String d1, String d2, String d3, String d4) {
            try {
                  con = DriverManager.getConnection(
                          "jdbc:mysql://localhost:3306/TIME_STAM?allowPublicKeyRetrieval=true&useSSL=false",
                          "root",
                          "ccfmps00112");

                  PreparedStatement stmt = con.prepareStatement("INSERT INTO " + table
                          + " (" + dt.getList_C().get(0) + ", " + dt.getList_C().get(1) + ", "
                          + dt.getList_C().get(2) + ", " + dt.getList_C().get(3) + ", "
                          + dt.getList_C().get(4) + ") VALUES(?,?,?,?,?)");

                  stmt.setInt(1, n);
                  stmt.setString(2, d1);
                  stmt.setString(3, d2);
                  stmt.setString(4, d3);
                  stmt.setString(5, d4);

                  int i = stmt.executeUpdate();
                  if (i > 0) {
                        dt.getList_1().add(n);
                        dt.getList_2().add(d1);
                        dt.getList_3().add(d2);
                        dt.getList_4().add(d3);
                        dt.getList_5().add(d4);

                        st.startLBStatus(lb_Status, cl[1], "MC-Insert 5 Done!", 4000);
                  } else {
                        st.startLBStatus(lb_Status, cl[2], inter, 8000);
                  }
            } catch (SQLException ex) {
                  Logger.getLogger(VF_R.class.getName()).log(Level.SEVERE, null, ex);

                  st.startLBStatus(lb_Status, cl[0], ex.toString(), 8000);
            }
      }

      private void MCInsert6(String table, int n, String d1, String d2, String d3, String d4, String d5) {
            try {
                  con = DriverManager.getConnection(
                          "jdbc:mysql://localhost:3306/TIME_STAM?allowPublicKeyRetrieval=true&useSSL=false",
                          "root",
                          "ccfmps00112");

                  PreparedStatement stmt = con.prepareStatement("INSERT INTO " + table
                          + " (" + dt.getList_C().get(0) + ", " + dt.getList_C().get(1) + ", "
                          + dt.getList_C().get(2) + ", " + dt.getList_C().get(3) + ", " + dt.getList_C().get(4)
                          + ", " + dt.getList_C().get(5) + ") VALUES(?,?,?,?,?,?)");

                  stmt.setInt(1, n);
                  stmt.setString(2, d1);
                  stmt.setString(3, d2);
                  stmt.setString(4, d3);
                  stmt.setString(5, d4);
                  stmt.setString(6, d5);

                  int i = stmt.executeUpdate();
                  if (i > 0) {
                        dt.getList_1().add(n);
                        dt.getList_2().add(d1);
                        dt.getList_3().add(d2);
                        dt.getList_4().add(d3);
                        dt.getList_5().add(d4);
                        dt.getList_6().add(d5);

                        st.startLBStatus(lb_Status, cl[1], "MC-Insert 6 Done!", 4000);
                  } else {
                        st.startLBStatus(lb_Status, cl[2], inter, 8000);
                  }

            } catch (SQLException ex) {
                  Logger.getLogger(VF_R.class.getName()).log(Level.SEVERE, null, ex);

                  st.startLBStatus(lb_Status, cl[0], ex.toString(), 8000);
            }
      }
      
            public void MCInsertSelectD1(String table, String c1, ArrayList<String> list1) {//DISTINCT
            try {
                  con = DriverManager.getConnection(
                          "jdbc:mysql://localhost:3306/TIME_STAM?allowPublicKeyRetrieval=true&useSSL=false",
                          "root",
                          "ccfmps00112");

                  String query = "SELECT DISTINCT " + c1 + " FROM " + table + " ORDER BY " + c1;
                  Statement st = con.createStatement();
                  ResultSet rs = st.executeQuery(query);

                  list1.clear();

                  while (rs.next()) {
                        list1.add(rs.getString(1));
                  }

            } catch (SQLException ex) {
                  Logger.getLogger(VF_R.class.getName()).log(Level.SEVERE, null, ex);
                  st.startLBStatus(lb_Status, cl[0], ex.toString(), 8000);
            }
      }

      public void MCInsertSelectD2(String table, String c1, String c2,
              ArrayList<String> list1, ArrayList<String> list2) {
            try {
                  con = DriverManager.getConnection(
                          "jdbc:mysql://localhost:3306/TIME_STAM?allowPublicKeyRetrieval=true&useSSL=false",
                          "root",
                          "ccfmps00112");

                  String query = "SELECT DISTINCT " + c1 + ", " + c2 + " FROM " + table + " ORDER BY " + c1;
                  Statement st = con.createStatement();
                  ResultSet rs = st.executeQuery(query);

                  list1.clear();
                  list2.clear();

                  while (rs.next()) {
                        list1.add(rs.getString(1));
                        list2.add(rs.getString(2));
                  }
            } catch (SQLException ex) {
                  Logger.getLogger(VF_R.class.getName()).log(Level.SEVERE, null, ex);

                  st.startLBStatus(lb_Status, cl[0], ex.toString(), 8000);
            }
      }

       */
}
