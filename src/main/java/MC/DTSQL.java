/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MC;

import com.cofii2.stores.DString;
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
      public static final String INFORMATION_SCHEMA = "INFORMATION_SCHEMA";
      public static final String KEY_COLUMN_USAGE = "KEY_COLUMN_USAGE";
      public static final String[] bandDB = new String[]{
            INFORMATION_SCHEMA,
            "MYSQL",
            "PERFORMANCE_SCHEMA",
            "SYS",
            "WORLD",
            "ROOTCONFIG"};

      private static String[] bwE_mysql = {
            "FROM", "WHERE", "SHOW", "WITH", "TABLE", "DATABASE", "SCHEMA", "COLUMNS", "COLUMN",
            "ALTER", "ALTER TABLE", "ADD", "ADD COLUMN", "ADD CONSTRAINT", "CONSTRAINT", "AFTER",
            "SET", "SET DEFAULT", "DEFAULT", "FOREIGN", "FOREIGN KEY", "KEY", "PRIMARY KEY", "REFERENCES",
            "INSERT", "INTO", "INSERT INTO", "VALUES", "SELECT", "AUTO_INCREMENT", "IDENTITY", "RENAME",
            "RENAME COLUMN", "TO", "USE", "CREATE", "CREATE TABLE", "CREATE DATABASE", "DROP", "DROP TABLE",
            "DROP DATABASE", "DROP COLUMN", "DROP DEFAULT", "DELETE", "DELETE FROM", "LIMIT",
            "SHOW COLUMNS FROM", "SHOW TABLES", "SHOW DATABASES", "ORDER", "BY", "ORDER BY", "CURRENT",
            "CURRENT USER", "SCHEMAS", "SHOW SCHEMAS", "DISTINCT", "SELECT DISTINCT", "SELECT USER FROM",
            "INT", "BIGINT", "BINARY", "BLOB", "TINYINT", "CHAR", "CURSOR", "DECIMAL", "DOUBLE", "FLOAT", "LONGBLOB",
            "MEDIUMBLOB", "MEDIUMINT", "NUMERIC", "NVARCHAR", "REAL", "SMALLINT", "TINYBLOB", "VARBINARY",
            "SQL"};
      private static String[] bwC_mysql = {"-", "*", "=", "+", "(", ")", ",", ";", ":", "[", "]", "{", "}", ".", "¿", "?", "\"", "¡", "\\",
            "/", "&", "%", "#", "\"", "!", "|", "~", "^", "@", "__"};
      private static ArrayList<String> bandWE_mysql = new ArrayList<String>(Arrays.asList(bwE_mysql));
      private static ArrayList<String> bandWC_mysql = new ArrayList<String>(Arrays.asList(bwC_mysql));
      //++++++++++++++++++++++++++++++++++++++++++++
      public static final int INT_MIN_WIDTH = 1;
      public static final int TINYINT_MIN_WIDTH = 1;
      public static final int SMALLINT_MIN_WIDTH = 1;
      public static final int MEDIUMINT_MIN_WIDTH = 1;
      public static final int BIGINT_MIN_WIDTH = 1;
      public static final int CHAR_MIN_WIDTH = 1;
      public static final int VARCHAR_MIN_WIDTH = 1;
      
      public static final int INT_DEFAULT_WIDTH = 11;
      public static final int TINYINT_DEFAULT_WIDTH = 4;
      public static final int SMALLINT_DEFAULT_WIDTH = 6;
      public static final int MEDIUMINT_DEFAULT_WIDTH = 9;
      public static final int BIGINT_DEFAULT_WIDTH = 20;
      public static final int CHAR_DEFAULT_WIDTH = 1;
      public static final int VARCHAR_DEFAULT_WIDTH = 80;
      
      public static final int INT_MAX_WIDTH = 11;
      public static final int TINYINT_MAX_WIDTH = 4;
      public static final int SMALLINT_MAX_WIDTH = 6;
      public static final int MEDIUMINT_MAX_WIDTH = 9;
      public static final int BIGINT_MAX_WIDTH = 20;
      public static final int CHAR_MAX_WIDTH = 255;
      public static final int VARCHAR_MAX_WIDTH = 16383;

      public static final String[] mysqlTypes = new String[]{
            "INT", "TINYINT", "SMALLINT", "MEDIUMINT", "BIGINT", 
            "FLOAT", "DOUBLE",
            "CHAR", "VARCHAR",
            "BOOLEAN/TINYINT(1)",
            "TIME", "DATE", "DATETIME", "TIMESTAMP",
            "BINARY", "VARBINARY"}; 
      
      public static final String[] mysqlTypesFixedWidth = new String[]{
            "INT", "TINYINT", "SMALLINT", "MEDIUMINT", "BIGINT", 
            "CHAR", "VARCHAR",
            "TIME", "DATE", "DATETIME", "TIMESTAMP",
            "BINARY", "VARBINARY"};
      
      public static final boolean[] mysqlTypesFixedSize = new boolean[]{
            true, true, true, true, true,
            false,false,
            true, true,
            false,
            false, false, false, false,
            false, false};
      public static final int[] mysql_TypesIntMinSize = {
            INT_MIN_WIDTH, TINYINT_MIN_WIDTH, SMALLINT_MIN_WIDTH, MEDIUMINT_MIN_WIDTH, BIGINT_MIN_WIDTH,
            -1, -1,
            CHAR_MIN_WIDTH, VARCHAR_MIN_WIDTH
            -1,
            -1, -1, -1, -1,
            -1, -1};
      public static final int[] mysql_TypesIntDefaultSize = new int[]{
            INT_DEFAULT_WIDTH, TINYINT_DEFAULT_WIDTH, SMALLINT_DEFAULT_WIDTH, MEDIUMINT_DEFAULT_WIDTH, BIGINT_DEFAULT_WIDTH,
            -1, -1,
            CHAR_DEFAULT_WIDTH, VARCHAR_DEFAULT_WIDTH, 
            -1,
            -1, -1, -1, -1,
            -1, -1};
      public static final int[] mysql_TypesIntMaxSize = new int[]{
            INT_MAX_WIDTH, TINYINT_MAX_WIDTH, SMALLINT_MAX_WIDTH, MEDIUMINT_MAX_WIDTH, BIGINT_MAX_WIDTH,
            -1, -1,
            CHAR_MAX_WIDTH, VARCHAR_MAX_WIDTH, 
            -1,
            -1, -1, -1, -1,
            -1, -1};

      /*
      "INT", "TINYINT", "SMALLINT", "MEDIUMINT", "BIGINT", 
            "FLOAT", "DOUBLE",
            "CHAR", "VARCHAR",
            "BOOLEAN/TINYINT(1)",
            "TIME", "DATE", "DATETIME", "TIMESTAMP",
            "BINARY", "VARBINARY"
      */
      
      //VC_R CONTROL +++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public static final String[] extraTypes = {"INT", "TINYINT", "SMALLINT", "MEDIUMINT", "BIGINT"};
      public static final String[] distTypes = {"CHAR", "VARCHAR"};
      public static final String[] dist2Types = {"INT", "TINYINT", "SMALLINT", "MEDIUMINT", "BIGINT",
            "FLOAT", "DOUBLE",
            "CHAR", "VARCHAR",
            "BOOLEAN/TINYINT(1)",
            "TIME", "DATE", "DATETIME", "TIMESTAMP",};
      public static final String[] clockTypes = {"CHAR", "VARCHAR", "TIME", "DATETIME", "TIMESTAMP"};
      public static final String[] tagTypes = {"CHAR", "VARCHAR"};
      public static final String[] imageCTypes = {"CHAR", "VARCHAR"};
      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public static final String IconURL = "C:\\C0F\\About Music\\Album Front\\";

      private static String initDataBase = "RootConfig";
      private static String dataBase;

      public static final String defaultUserTable = "DefaultUser";
      public static final String[] defaultUserTableColumns = new String[]{
            "Name", "Passw", "DATAB"};
      //MAIN TABLE VARIABLES ++++++++++++++++++++++++++++++++
      public static final String mainTable = "Table_Names";
      public static final String[] mainTableColumns = new String[]{
            "id", "Name", "Dist1", "Dist2", "ImageC", "ImageC_Path", "Tag", "Clock"};
      public static final String[] mainTableTypes = new String[]{
            "INT(11)", "VARCHAR(100)", "VARCHAR(100)", "VARCHAR(100)", "VARCHAR(200)",
            "VARCHAR(100)", "VARCHAR(50)"};
      public static final boolean[] mainTableNulls = new boolean[]{
            false, false, false, false, false, false, false};
      
      public static final String defautlTable = "Default_Table";
      private static String defaultTableValue;
      //SAME COLUMNS AS mainTableColumns
      //SAME TYPES AS mainTableTypes
      //SAME NULLS AS mainTableNulls

      public static final String configTable = "Table_Config";
      public static final String[] configTableColumns = new String[]{
            "id", "Name", "Value"};
      public static final String[] configTableTypes = new String[]{
            "INT(11)", "VARCHAR(50)", "TINYINT(1)"};
      public static final boolean[] configTableNulls = new boolean[]{
            false, false, false};
      public static final Object[][] configTableValues = new Object[][]{
            {1, "AlwaysOnTop", false}, {2, "AutoReziseTable", false}, {3, "ShowGrid", false}};

      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public static final String[] fixedTables = {
            mainTable,
            defautlTable,
            configTable};
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

      public static String initURLConnection
              = "jdbc:" + dbms + "://" + server + ":" + portNumber + "/" + initDataBase
              + defaultConnectionProps;

      private static String User;
      public static final String rootUser = "root";
      private static String Passw;
      public static final String rootPassw = null;
      //++++++++++++++++++++++++++++++++++++++
      private static boolean mainTableExist;
      private static boolean PKTableExist;
      private static boolean configTableExist;
      private static boolean defaultTableExist;

      //++++++++++++++++++++++++++++++++++++++
      private static final String table1 = "table_names";
      private static final String table2 = "table_types";
      public static final DString match1 = new DString(table1, "id");
      public static final DString match2 = new DString(table2, "id");
      public static final DString[] listDS = new DString[]{
            new DString(table1, "id"),
            new DString(table1, "Name"),
            new DString(table1, "Dist1"),
            new DString(table1, "Dist2"),
            new DString(table1, "ImageC"),
            new DString(table1, "Tag"),
            new DString(table1, "Clock"),
            new DString(table2, "pkc")};

      //++++++++++++++++++++++++++++++++++++++
      public static ArrayList<String> getBandWE_mysql() {
            return bandWE_mysql;
      }

      public static ArrayList<String> getBandWC_mysql() {
            return bandWC_mysql;
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

      public static void setInitDataBase(String database) {
            initURLConnection
                    = "jdbc:" + dbms + "://" + server + ":" + portNumber + "/" + database
                    + defaultConnectionProps;
      }

      //+++++++++++++++++++++++++++++++++++++++
      public static String getURLConnection() {
            return URLConnection;
      }

      //+++++++++++++++++++++++++++++++++++++++
      public static String getDefaultTableValue() {
            return defaultTableValue;
      }

      public static void setDefaultTableValue(String v) {
            defaultTableValue = v;
      }

      //+++++++++++++++++++++++++++++++++++++++
      public static boolean getMainTableExist() {
            return mainTableExist;
      }

      public static void setMainTableExist(boolean v) {
            mainTableExist = v;
      }
      
      public static boolean getPKTableExist(){
            return PKTableExist;
      }
      
      public static void setPKTableExist(boolean v){
            PKTableExist = v;
      }

      public static boolean getConfigTableExist() {
            return configTableExist;
      }

      public static void setConfigTableExist(boolean v) {
            configTableExist = v;
      }

      public static boolean getDefaultTableExist() {
            return defaultTableExist;
      }

      public static void setDefaultTableExist(boolean v) {
            defaultTableExist = v;
      }
}
