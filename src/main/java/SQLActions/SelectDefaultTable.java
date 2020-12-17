/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import MC.DT;
import MC.DTSQL;
import MC.TableInfoC;
import com.cofii2.myClasses.CC;
import com.cofii2.myInterfaces.IActions;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author C0FII
 */
public class SelectDefaultTable implements IActions {

      private String Table;

      @Override
      public void beforeQuery() {

      }

      @Override
      public void setData(ResultSet rs, int row) throws SQLException {
            int id = rs.getInt(1);
            String table = rs.getString(2);
            DT.setDTable(table);
            Table = table;
            String dist1 = rs.getString(3);
            String dist2 = rs.getString(4);
            String imageC = rs.getString(5);
            String tag = rs.getString(6);
            String clock = rs.getString(7);

            System.out.println("\tid: " + id);
            System.out.println("\ttable: " + table);
            System.out.println("\tdist1: " + dist1);
            System.out.println("\tdist2: " + dist2);
            System.out.println("\timageC: " + imageC);
            System.out.println("\ttag: " + tag);
            System.out.println("\tclock: " + clock);

            TableInfoC.setId(id);
            TableInfoC.setTable(table);
            TableInfoC.setDist1(dist1);
            TableInfoC.setDist2(dist2);
            TableInfoC.setImageC(imageC);
            TableInfoC.setTag(tag);
            TableInfoC.setClock(clock);

      }

      @Override
      public void afterQuery(String query, boolean value) {
            if (value) {
                  DTSQL.setDefaultTableValue(Table);
            } else {
                  DTSQL.setDefaultTableValue(null);
            }
      }

      @Override
      public void exception(SQLException sqle, String query) {
            System.out.println(CC.RED + query + CC.RESET);
            sqle.printStackTrace();
      }

}
