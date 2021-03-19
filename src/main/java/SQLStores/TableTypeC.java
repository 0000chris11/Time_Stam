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
public class TableTypeC {

      private static String table;
      private static IntString ex;
      
      public static String getTable(){
            return table;
      }
      public static void setTable(String table){
            TableTypeC.table = table;
      }
      
      public static IntString getEX(){
            return ex;
      }
      public static void setEX(IntString ex){
            TableTypeC.ex = ex;
      }
}
