package MC;

import views.create.VC_R2;
import views.first.VF_R;
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

      MSQL ms = new MSQL(DTSQL.getURLConnection(), DTSQL.getUser(), DTSQL.getPassw());
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
      //REPLACE++++++++++++++++++++++
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

      //REPLACE++++++++++++++++++++++
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
      //REPLACE++++++++++++++++++++++
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
      //REPLACE++++++++++++++++++++++
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
      //REPLACE++++++++++++++++++++++
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
