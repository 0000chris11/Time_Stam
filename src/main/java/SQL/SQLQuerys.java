/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

/**
 *
 * @author C0FII
 */
public class SQLQuerys {

      public static String SELECT_KEYS = null;
      public static String SELECT_KEYS_FROM_CURRENT = null;

      private static String schema;

      public static void setSchemaForKeys(String schema) {
            SQLQuerys.schema = schema;
            SELECT_KEYS = "SELECT "
                    + "t.table_name, "
                    + "t.constraint_type, "
                    + "k.ORDINAL_POSITION, "
                    + "k.column_name, "
                    + "k.REFERENCED_TABLE_NAME, "
                    + "k.REFERENCED_COLUMN_NAME "
                    + "FROM information_schema.table_constraints t JOIN information_schema.key_column_usage k "
                    + "USING(constraint_name,table_schema,table_name) "
                    + "WHERE (t.constraint_type='PRIMARY KEY' OR t.constraint_type= 'FOREIGN KEY') "
                    + "AND t.table_schema ='" + SQLQuerys.schema + "' ORDER BY t.table_name";
      }

      public static void setTableForCurrentKeys(String table) {
            SELECT_KEYS_FROM_CURRENT = "SELECT "
                    + "t.table_name, "
                    + "t.constraint_type, "
                    + "k.ORDINAL_POSITION, "
                    + "k.column_name, "
                    + "k.REFERENCED_TABLE_NAME, "
                    + "k.REFERENCED_COLUMN_NAME "
                    + "FROM information_schema.table_constraints t JOIN information_schema.key_column_usage k "
                    + "USING(constraint_name,table_schema,table_name) "
                    + "WHERE (t.constraint_type='PRIMARY KEY' OR t.constraint_type= 'FOREIGN KEY') "
                    + "AND t.table_schema ='" + schema + "' AND t.table_name = '" + table + "' ORDER BY t.table_name";
            /*
            SELECT t.table_name, t.constraint_type, k.ORDINAL_POSITION, k.column_name, k.REFERENCED_TABLE_NAME, 
            k.REFERENCED_COLUMN_NAME 
            FROM information_schema.table_constraints t 
            JOIN information_schema.key_column_usage k USING(constraint_name,table_schema,table_name) 
            WHERE (t.constraint_type='PRIMARY KEY' OR t.constraint_type= 'FOREIGN KEY') 
            AND t.table_schema = 'rootconfig'  ORDER BY t.table_name
             */
      }

}
