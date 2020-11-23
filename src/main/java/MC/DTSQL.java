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
      
      public static final String urlConnection
              = "jdbc:mysql://localhost:3306/"
              +  dataBase + "?allowPublicKeyRetrieval=true&"
              + "useSSL=false&"
              + "useJDBCCompliantTimezoneShift=true&"
              + "useLegacyDatetimeCode=false&"
              + "serverTimezone=UTC";
      
      public static final String user = "root";
      final public static String passw = "ccfmps00112";
      //++++++++++++++++++++++++++++++++++++++
      public static ArrayList<String> getBandW() {
            return bandW;
      }
}
