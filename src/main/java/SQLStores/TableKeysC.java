/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLStores;

import com.cofii2.stores.IntString;

/**
 *
 * @author C0FII
 */
public class TableKeysC {
      
      private static String table;
      private static String constraint_type;//NOT USABLE
      private static IntString[] pk;
      private static IntString[] fk;
      private static String[] tableR;
      private static String[] columnR;
      
      public static String getTable(){
            return table;
      }
      public static String getConstraint_Type(){
            return constraint_type;
      }
      public static IntString[] getPK(){
            return pk;
      }
      public static IntString[] getFK(){
            return fk;
      }
      public static String[] getTableR(){
            return tableR;
      }
      public static String[] getColumnR(){
            return columnR;
      }
      
      public static void setTable(String table){
            TableKeysC.table = table;
      }
      public static void setConstraint_Type(String constraint_type){
            TableKeysC.constraint_type = constraint_type;
      }
      public static void setPK(IntString[] pk){
            TableKeysC.pk = pk;
      }
      public static void setFK(IntString[] fk){
            TableKeysC.fk = fk;
      }
      public static void setTableR(String[] tableR){
            TableKeysC.tableR = tableR;
      }
      public static void setColumnR(String[] columnR){
            TableKeysC.columnR = columnR;
      }
}
