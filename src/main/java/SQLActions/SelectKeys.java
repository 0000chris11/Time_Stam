/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import SQLStores.TableKeysList;
import SQLStores.TableKeysModel;
import com.cofii2.myInterfaces.IActions;
import com.cofii2.stores.IntString;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author C0FII
 */
public class SelectKeys implements IActions {

      private ArrayList<IntString> listPK = new ArrayList<IntString>();
      private ArrayList<IntString> listFK = new ArrayList<IntString>();
      //private String table = "";

      @Override
      public void beforeQuery() {
            TableKeysList.clear();

      }

      @Override
      public void setData(ResultSet rs, int row) throws SQLException {

            //++++++++++++++++++++++++++++++++++++++++
            String table = rs.getString(1);
            //if (this.table.equals(table)) {
                  String constraint_type = rs.getString(2);

                  int ordinal_position = rs.getInt(3);
                  String column_name = rs.getString(4);

                  IntString pk = new IntString(0, null);
                  IntString fk = new IntString(0, null);

                  if (constraint_type.equals("PRIMARY KEY")) {
                        pk = new IntString(ordinal_position, column_name);
                        //listPK.add(new IntString(ordinal_position, column_name));
                  } else if (constraint_type.equals("FOREIGN KEY")) {
                        fk = new IntString(ordinal_position, column_name);
                        //listFK.add(new IntString(ordinal_position, column_name));
                  }

                  String tableR = rs.getString(5);//REFERENCED_TABLE_NAME
                  String columnR = rs.getString(6);//REFERENCED_COLUMN_NAME

                  /*
            System.out.println("\n\ttable: " + table + " (" + row + ")");
            System.out.println("\tconstraint_type: " + constraint_type);
            System.out.println("\tordinal_position: " + ordinal_position);
            System.out.println("\tcolumn_name: " + column_name);
            System.out.println("\ttableR: " + tableR);
            System.out.println("\tcolumnR: " + columnR);
                   */
                  TableKeysList.add(new TableKeysModel(table, constraint_type, pk, fk, tableR, columnR));

            //} else {
                  //listPK.clear();
                  //listFK.clear();

                  //this.table = table;
            //}

      }

      @Override
      public void afterQuery(String query, boolean rsValue) {
            if (rsValue) {

            }
      }

      @Override
      public void exception(SQLException ex, String query) {
            ex.printStackTrace();
      }

}
