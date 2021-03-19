/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import MC.DT;
import MC.Status;
import SQLStores.TableDist;
import SQLStores.TablesDists;
import com.cofii2.myInterfaces.IActions;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import views.first.VF_R;

/**
 *
 * @author C0FII
 */
public class SelectTables implements IActions {

      @Override
      public void beforeQuery() {
            TablesDists.clear();
      }

      @Override
      public void setData(ResultSet rs, int row) throws SQLException {
            
            int id = rs.getInt(1);
            String table = rs.getString(2);
            String dist1 = rs.getString(3);
            String dist2 = rs.getString(4);
            String imageC = rs.getString(5);
            String imageCPath = rs.getString(6);
            String tag = rs.getString(7);
            String clock = rs.getString(8);
            /*
            System.out.println("\tid: " + id);
            System.out.println("\ttable: " + table);
            System.out.println("\tdist1: " + dist1);
            System.out.println("\tdist2: " + dist2);
            System.out.println("\timageC: " + imageC);
            System.out.println("\timageCPath: " + imageCPath);
            System.out.println("\ttag: " + tag);
            System.out.println("\tclock: " + clock);
            */
            
            TablesDists.addlistTI(new TableDist(id, table, dist1, dist2, imageC, imageCPath, tag, clock));
      }

      @Override
      public void afterQuery(String query, boolean rsValue) {
            DT.setRTable(rsValue);
      }

      @Override
      public void exception(SQLException ex, String query) {
            ex.printStackTrace();
            Status.startLBStatus(VF_R.getLB_Status(), Color.RED,
                    "SelectTables: " + ex.toString(), 8000);

      }

}
