/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLStores;

import MC.DTSQL;
import java.util.ArrayList;

/**
 *
 * @author C0FII
 */
public class TablesDists {

      private static ArrayList<TableDist> listTI = new ArrayList<TableDist>();

      public static void addlistTI(TableDist ti) {
            boolean match = false;
            for (int a = 0; a < DTSQL.fixedTables.length; a++) {
                  if (ti.getTable().equalsIgnoreCase(DTSQL.fixedTables[a])) {
                        match = true;
                  }
            }
            if (!match) {
                  listTI.add(ti);
            }
      }

      public static void clear() {
            listTI.clear();
      }

      public static ArrayList<Integer> getIdList() {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (TableDist x : listTI) {
                  list.add(x.getId());
            }
            return list;
      }

      public static ArrayList<String> getTableList() {
            ArrayList<String> list = new ArrayList<String>();
            for (TableDist x : listTI) {
                  list.add(x.getTable());
            }
            return list;
      }

      public static ArrayList<String> getDist1List() {
            ArrayList<String> list = new ArrayList<String>();
            for (TableDist x : listTI) {
                  list.add(x.getDist1());
            }
            return list;
      }

      public static ArrayList<String> getDist2List() {
            ArrayList<String> list = new ArrayList<String>();
            for (TableDist x : listTI) {
                  list.add(x.getDist2());
            }
            return list;
      }

      public static ArrayList<String> getImageCList() {
            ArrayList<String> list = new ArrayList<String>();
            for (TableDist x : listTI) {
                  list.add(x.getImageC());
            }
            return list;
      }

      public static ArrayList<String> getTagList() {
            ArrayList<String> list = new ArrayList<String>();
            for (TableDist x : listTI) {
                  list.add(x.getTag());
            }
            return list;
      }

      public static ArrayList<String> getClockList() {
            ArrayList<String> list = new ArrayList<String>();
            for (TableDist x : listTI) {
                  list.add(x.getClock());
            }
            return list;
      }
}
