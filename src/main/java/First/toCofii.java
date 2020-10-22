/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package First;

import MC.DT;
import Others.CC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author C0FII
 */
public class toCofii {

      Actions ac;

      private Connection con;
      private String query;
      private Statement stt;
      private PreparedStatement pstt;
      private ResultSet rs;

      private String urlConnection;
      private String user;
      private String passw;

      public toCofii(String urlConnection, String user, String passw) {
            this.urlConnection = urlConnection;
            this.user = user;
            this.passw = passw;
      }
      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public void SelectColumns(String table, Actions ac) {
            System.out.println(CC.YELLOW + "MakeCon ++++ SelectColumns" + CC.RESET);
            System.out.println(CC.YELLOW + "\tTable: " + table + CC.RESET);

            try {
                  con = DriverManager.getConnection(
                          urlConnection, user, passw);

                  String query = "SHOW COLUMNS FROM " + table;
                  //System.out.println("SHOW COLUMNS FROM " + table);
                  stt = con.createStatement();
                  rs = stt.executeQuery(query);

                  ac.beforeQuery();
                  
                  while (rs.next()) {
                        ac.setData(rs);
                  }

                  ac.afterQuery();

            } catch (SQLException ex) {
                  ac.exception(ex);

            }
      }

      public int getColumnCount(String table) {
            System.out.println(CC.YELLOW + "MakeCon ++++ getColumnCount" + CC.RESET);
            System.out.println("\tTable: " + table);

            int returnValue = -1;

            try {
                  con = DriverManager.getConnection(
                          urlConnection, user, passw);

                  String query = "SELECT COUNT(*) FROM " + table;
                  stt = con.createStatement();
                  rs = stt.executeQuery(query);

                  while (rs.next()) {
                        returnValue = rs.getInt(1);
                  }
            } catch (SQLException ex) {
                  ex.printStackTrace();
                  returnValue = -1;
            }
            return returnValue;
      }

}
