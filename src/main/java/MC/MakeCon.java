package MC;

import Create.VC_R2;
import First.VF_R;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.cofii.myClasses.CC;
import SQLActions.SelectTables;
import com.cofii.myClasses.MSQL;
import java.awt.Color;

/**
 *
 * @author Christopher
 */
public class MakeCon {

      MSQL ms = new MSQL(DT.urlConnection, DT.user, DT.passw);
      String CName = this.getClass().getName();

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

      //++++++++++++++++++++++++++++++++++++++++++++++++++
      public void CreateTable(String table, String[] cols, int c) {
            System.out.println(CC.YELLOW + "MakeCon ++++ CreateTable" + CC.RESET);
            try {
                  con = DriverManager.getConnection(
                          urlConnection, user, passw);

                  stt = con.createStatement();
                  String TYPE = "VARCHAR(150)";
                  String TYPE2 = "NOT NULL";
                  //2
                  //++++++++++++++++++++++++++++++++++++++++
                  String sql = "CREATE TABLE " + table.replaceAll(" ", "_") 
                          + " (id INT NOT NULL AUTO_INCREMENT, ";

                  for (int a = 0; a < c - 1; a++) {
                        sql += cols[a] + " " + TYPE + " " + TYPE2 + ", ";
                  }

                  sql += "PRIMARY KEY(id))ENGINE=INNODB";
                  //++++++++++++++++++++++++++++++++++++++++
                  System.out.println("\tTable: " + table);
                  for (int a = 0; a < cols.length - 1; a++) {
                        System.out.println("\tCol " + (a + 2) + ": " + cols[a]);
                  }
                  System.out.println("\tC: " + c);
                  System.out.println("\t" + sql);
                  //+++++++++++++++++++++++++++++++++++++++
                  int i = stt.executeUpdate(sql);
                  
                  if (i > 0) {
                        Status.startLBStatus(VC_R2.getLB_Status(), Color.GREEN,
                          "MC-CreateTable Done!", 5000);
                  }else{
                        Status.startLBStatus(VC_R2.getLB_Status(), Color.YELLOW,
                          DT.inter, 7000);
                  }
                  //++++++++++++++++++++++++++++++++++++++++

            } catch (SQLException ex) {
                  ex.printStackTrace();
                  Status.startLBStatus(VC_R2.getLB_Status(), Color.RED,
                          "CreateTable - " + ex.toString(), 7000);
            }
      }

      public boolean InsertTable(String table, String dist, String dist2, String imageC,
              String tag, String clock) {
            System.out.println(CC.YELLOW + "MakeCon ++++ InsertTable" + CC.RESET);
            try{
                  con = DriverManager.getConnection(urlConnection, user, passw);
                  
                  String sql = "INSERT INTO Table_Names "
                          + "(Table_Names, Dist1, Dist2, ImageC, Tag1, Clock) "
                          + "VALUES (?,?,?,?,?,?)";             
                  pstt = con.prepareStatement(sql);
                  
                  System.out.println("\tTable: " + table);
                  System.out.println("\tDist: " + dist);
                  System.out.println("\tDist2: " + dist2);
                  System.out.println("\tImageC: " + imageC);
                  System.out.println("\tTag: " + tag);
                  System.out.println("\tClock: " + clock);
                  
                  pstt.setString(1, table);
                  pstt.setString(2, dist);
                  pstt.setString(3, dist2);
                  pstt.setString(4, imageC);
                  pstt.setString(5, tag);
                  pstt.setString(6, clock);
                  
                  int i = pstt.executeUpdate();
                  if (i > 0) {
                        //DT.getList_id().add();
                        //DT.getList_T().add(table);
                        //DT.getList_Dist1().add(dist);
                        //DT.getList_Dist2().add(dist2);
                        //DT.getList_ImageC().add(imageC);
                        //DT.getList_Tag().add(tag);
                        //DT.getList_Clock().add(clock);
                        //ms.selectTables(DT.mainTable, new SelectTables());
                        ms.selectData(DT.mainTable, new SelectTables());
                        
                        
                        Status.startLBStatus(VC_R2.getLB_Status(), Color.GREEN,
                          "MC-InsertTable Done!", 5000);
                        
                        return true;
                  }else{
                        Status.startLBStatus(VC_R2.getLB_Status(), Color.YELLOW,
                          DT.inter, 7000);
                        return false;
                  }
                  
            }catch(SQLException ex){
                  ex.printStackTrace();
                  Status.startLBStatus(VC_R2.getLB_Status(), Color.RED, ex.toString(), 8000);
                  return false;
            }
      }
      
      public boolean DeleteTable(String table){
            System.out.println(CC.YELLOW + "MakeCon ++++ DeleteTable" + CC.RESET);
            try{
                  con = DriverManager.getConnection(urlConnection, user, passw);
                  
                  String sql = "DROP TABLE " + 
                          table.replaceAll(" ", "_");
                  pstt = con.prepareStatement(sql);
                  System.out.println("\t" + sql);

                  int i = pstt.executeUpdate();
                  if (i == 0) {
                        DT.getList_T().remove(table);
                        Status.startLBStatus(VF_R.getLB_Status(), Color.GREEN, 
                                "MC-DeleteTable Done!", 4000);
                        return true;
                  } else {
                        Status.startLBStatus(VF_R.getLB_Status(), DT.RGY[2],
                                "DeleteTable: " + DT.inter, 8000);
                        return false;
                  }
                  
            }catch(SQLException ex){
                  ex.printStackTrace();
                  Status.startLBStatus(VF_R.getLB_Status(), Color.RED, 
                          "DeleteTable: " + ex.toString(), 8000);
                  return false;
            }
      }
      
      public void RemoveTableFromTN(String table){
            System.out.println(CC.YELLOW + "MakeCon ++++ RemoveTableFromTN" + CC.RESET);
            try{
                  con = DriverManager.getConnection(urlConnection, user, passw);
                  
                  String sql = "DELETE FROM Table_Names WHERE Table_Names = \""
                          + table + "\"";
                  pstt = con.prepareStatement(sql);
                  System.out.println("\t" + sql);

                  int i = pstt.executeUpdate();
                  if (i == 1) {
                        Status.startLBStatus(VF_R.getLB_Status(), Color.GREEN, 
                                "MC-RemoveTableFromTN Done!", 4000);
                  } else {
                        Status.startLBStatus(VF_R.getLB_Status(), Color.YELLOW,
                                "RemoveTableFromTN: " + DT.inter, 8000);
                  }
                  
            }catch(SQLException ex){
                  ex.printStackTrace();
                  Status.startLBStatus(VF_R.getLB_Status(), Color.RED, 
                          "RemoveTableFromTN: " + ex.toString(), 8000);
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
                  DT.getList_ImageC().clear();
                  DT.getList_Tag().clear();
                  DT.getList_Clock().clear();

                  while (rs.next()) {
                        DT.getList_id().add(rs.getString(1));
                        DT.getList_T().add(rs.getString(2));
                        DT.getList_Dist1().add(rs.getString(3));
                        DT.getList_Dist2().add(rs.getString(4));
                        DT.getList_ImageC().add(rs.getString(5));
                        DT.getList_Tag().add(rs.getString(6));
                        DT.getList_Clock().add(rs.getString(7));
                  }
                  //addItem(DT.getList_id(), dt.getList_T(), dt.getList_Dist1(), dt.getList_Dist2(), dt.getList_ImageC(),
                  //      dt.getList_Tag1(), dt.getList_Tag2());
            } catch (SQLException ex) {
                  ex.printStackTrace();
                  Status.startLBStatus(VF_R.getLB_Status(), DT.RGY[0],
                          "SelectTables: " + ex.toString(), 8000);
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
                        DT.setImageC(tab);
                        DT.setTag(tg1);
                        DT.setClock(ck);

                        Status.startLBStatus(VF_R.getLB_Status(), DT.RGY[1], "MCChangeDefault Done!", 4000);
                  } else {
                        Status.startLBStatus(VF_R.getLB_Status(), DT.RGY[2],
                                "ChangeDefault: " + DT.inter, 8000);
                  }

            } catch (SQLException ex) {
                  ex.printStackTrace();
                  Status.startLBStatus(VF_R.getLB_Status(), DT.RGY[0],
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
                        //listsN[0].add(n);
                        for (int a = 0; a < nvs.size(); a++) {
                              //listsN[a + 1].add(nvs.get(a));
                        }

                        Status.startLBStatus(VF_R.getLB_Status(), DT.RGY[1], "MC-Insert 2 Done!", 4000);
                  } else {
                        Status.startLBStatus(VF_R.getLB_Status(), DT.RGY[2],
                                "Insert: " + DT.inter, 8000);
                  }
            } catch (SQLException ex) {
                  ex.printStackTrace();
                  Status.startLBStatus(VF_R.getLB_Status(), DT.RGY[0],
                          "Insert: " + ex.toString(), 8000);
            }
      }
      //+++++++++++++++++++++++++++++++++++++++++++++++++++
      public void DeleteRow(String table, Object id) {
            System.out.println(CC.YELLOW + "MakeCon ++++ DeleteRow" + CC.RESET);
            try {
                  con = DriverManager.getConnection(
                          urlConnection, user, passw);

                  pstt = con.prepareStatement("DELETE FROM " + table
                          + " WHERE id = " + id);

                  int ex = pstt.executeUpdate();

                  if (ex == 1) {
                        Status.startLBStatus(VF_R.getLB_Status(), DT.RGY[1], 
                                "MCDeleteRow Done!", 4000);
                  } else {
                        Status.startLBStatus(VF_R.getLB_Status(), DT.RGY[2],
                                "DeleteRow: " + DT.inter, 8000);
                  }
            } catch (SQLException ex) {
                  ex.printStackTrace();
                  Status.startLBStatus(VF_R.getLB_Status(), DT.RGY[0],
                          "DeleteRow: " + ex.toString(), 8000);
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
                  Status.startLBStatus(VF_R.getLB_Status(), DT.RGY[0],
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
                  Status.startLBStatus(VF_R.getLB_Status(), DT.RGY[0],
                          "MCInsertSelectD2: " + ex.toString(), 8000);
            }
      }
}
