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
      
      private DTSQL(){
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
      
      public static final String dataBase = "TIME_STAM";
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
      
      public static final String defaultURLConnection
              = "jdbc:" + dbms + "://" + server + ":" + portNumber + "/" + dataBase 
              + defaultConnectionProps;
      
      public static final String initURLConnection
              = "jdbc:" + dbms + "://" + server + ":" + portNumber + "/" + defaultConnectionProps;
      
      /*
      conn = DriverManager.getConnection(
                   "jdbc:" + this.dbms + "://" +
                   this.serverName +
                   ":" + this.portNumber + "/",
                   connectionProps);
      */
      
      public static final String rootUser = "root";
      final public static String passw = "ccfmps00112";
      //++++++++++++++++++++++++++++++++++++++
      public static ArrayList<String> getBandW() {
            return bandW;
      }
}
