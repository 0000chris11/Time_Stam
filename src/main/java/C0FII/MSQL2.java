/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C0FII;

import com.cofii.myInterfaces.IActions;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class for Constructing query
 *
 * @author C0FII
 */
public class MSQL2 extends MSQLInit {

      private ArrayList<MDString> listTC = new ArrayList<MDString>();//TABLE, COLUMN
      private String table1;
      private String table2;
      private String join = "INNER JOIN";

      public MSQL2(MDString tables, MSQLConnect connection) {
            super(connection);
            this.table1 = tables.string1;
            this.table2 = tables.string2;
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public void addColumn(MDString mds) {
            if (mds.string1.equals(table1) || mds.string1.equals(table2)) {
                  listTC.add(mds);
            } else {
                  throw new IllegalArgumentException("First index on MDoubleString has to match tables");
            }
      }

      public void addAllColumns(ArrayList<MDString> list) {
            boolean match = true;
            for (MDString x : list) {
                  if (!x.string1.equals(table1) || !x.string1.equals(table2)) {
                        match = false;
                  }
            }
            if (match) {
                  this.listTC = list;
            } else {
                  throw new IllegalArgumentException("First index on MDoubleString has to match tables");
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public void selectTablesJoin(MDString match1, MDString match2, IActions ac) {
            try {
                  /*
            SELECT Table_Others.id, Table_Names.Name, Table_Others.pk FROM Table_Others 
            INNER JOIN Table_Names ON Table_Others.id=Table_Names.id;
                   */
                  sql = "SELECT ";
                  int size = listTC.size();
                  for (int a = 0; a < size; a++) {
                        String table = listTC.get(a).string1;
                        String column = listTC.get(a).string2;
                        sql += table + "." + column;

                        if (a != size - 1) {
                              sql += ", ";
                        }
                  }
                  sql += " FROM " + table1 + " " + join + " " + table2 + " ON ";

                  String table1Match = match1.string1;
                  String column1Match = match1.string2;
                  String table2Match = match2.string1;
                  String column2Match = match2.string2;

                  sql += table1Match + "." + column1Match + "=" + table2Match + "." + column2Match;
                  System.out.println(sql);
                  query(ac);
            } catch (SQLException ex) {
                  Logger.getLogger(MSQL2.class.getName()).log(Level.SEVERE, null, ex);
            }

      }
}
