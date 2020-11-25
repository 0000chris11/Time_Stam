/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MC;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author C0FII
 */
public class DTSQL {

      private DTSQL() {
            throw new IllegalStateException("Private Constructor");
      }

      public static final String[] bandUsers = new String[]{
            "mysql.infoschema",
            "mysql.session",
            "mysql.sys"};
      public static final String[] bandDB = new String[]{
            "INFORMATION_SCHEMA",
            "MYSQL",
            "PERFORMANCE_SCHEMA",
            "SYS",
            "WORLD"};

      private static String[] bw = {" FROM ", " WHERE ", " SHOW ", " WITH ", "-",
            " TABLE "};
      private static ArrayList<String> bandW = new ArrayList<String>(Arrays.asList(bw));

      public static final String IconURL = "C:\\C0F\\About Music\\Album Front\\";

      private static final String initDataBase = "RootConfig";
      private static String dataBase;

      public static final String defaultUserTable = "DefaultUser";

      public static final String mainTable = "Table_Names";
      public static final String mainColumn = "Table_Names";
      public static final String defautlTable = "Default_Table";
      public static final String defaultColumn = "Name";
      public static final String configTable = "Table_Config";
      public static final String configColumn = "Value";

      public static final String[] mainTableColumns = new String[]{
            "id", "Table_Names", "Dist1", "Dist2", "ImageC", "Tag1", "Clock"};
      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      private static final String dbms = "mysql";
      private static final String server = "localhost";
      private static final String portNumber = "3306";
      private static final String defaultConnectionProps
              = "?allowPublicKeyRetrieval=true&"
              + "useSSL=false&"
              + "useJDBCCompliantTimezoneShift=true&"
              + "useLegacyDatetimeCode=false&"
              + "serverTimezone=UTC";

      private static String URLConnection
              = "jdbc:" + dbms + "://" + server + ":" + portNumber + "/" + dataBase
              + defaultConnectionProps;

      public static final String initURLConnection
              = "jdbc:" + dbms + "://" + server + ":" + portNumber + "/" + initDataBase
              + defaultConnectionProps;

      private static String User;
      public static final String rootUser = "root";
      private static String Passw;
      public static final String rootPassw = "ccfmps00112";

      //++++++++++++++++++++++++++++++++++++++
      public static ArrayList<String> getBandW() {
            return bandW;
      }

      public static String getUser() {
            return User;
      }

      public static void setUser(String user) {
            User = user;
      }

      public static String getPassw() {
            return Passw;
      }

      public static void setPassw(String passw) {
            Passw = passw;
      }

      public static String getDatabase() {
            return dataBase;
      }

      public static void setDatabase(String db) {
            dataBase = db;
            URLConnection
              = "jdbc:" + dbms + "://" + server + ":" + portNumber + "/" + dataBase
              + defaultConnectionProps;
      }
      //+++++++++++++++++++++++++++++++++++++++
      public static String getURLConnection(){
            return URLConnection;
      }
}
