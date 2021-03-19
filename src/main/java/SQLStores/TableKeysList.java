/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLStores;

import MC.DTSQL;
import com.cofii2.stores.IntString;
import java.util.ArrayList;

/**
 *
 * @author C0FII
 */
public class TableKeysList {

      private static ArrayList<TableKeysModel> listTK = new ArrayList<TableKeysModel>();

      //+++++++++++++++++++++++++++++++++++++++++
      public static void add(TableKeysModel tableFK) {
            boolean match = false;
            for (int a = 0; a < DTSQL.fixedTables.length; a++) {
                  if (tableFK.table.equalsIgnoreCase(DTSQL.fixedTables[a])) {
                        match = true;
                  }
            }
            if(!match){
                listTK.add(tableFK);
            }
      }
      public static int size(){
            return listTK.size();
      }
      public static void clear(){
            listTK.clear();
      }
      
      public static ArrayList<String> getTables(){
            ArrayList<String> list = new ArrayList<String>();
            for(TableKeysModel x : listTK){
                  list.add(x.table);
            }
            return list;
      }
      public static ArrayList<String> getConstraint_Type(){
            ArrayList<String> list = new ArrayList<String>();
            for(TableKeysModel x : listTK){
                  list.add(x.constraint_type);
            }
            return list;
      }
      public static ArrayList<IntString> getPKS(){
            ArrayList<IntString> list = new ArrayList<IntString>();
            for(TableKeysModel x : listTK){
                  list.add(x.pk);
            }
            return list;
      }
      public static ArrayList<IntString> getFKS(){
            ArrayList<IntString> list = new ArrayList<IntString>();
            for(TableKeysModel x : listTK){
                  list.add(x.fk);
            }
            return list;
      }
      public static ArrayList<String> getTablesR(){
            ArrayList<String> list = new ArrayList<String>();
            for(TableKeysModel x : listTK){
                  list.add(x.tableR);
            }
            return list;
      }
      public static ArrayList<String> getColumnsR(){
            ArrayList<String> list = new ArrayList<String>();
            for(TableKeysModel x : listTK){
                  list.add(x.columnR);
            }
            return list;
      }
}
