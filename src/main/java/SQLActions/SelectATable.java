/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import views.first.VF_R;
import MC.Status;
import MC.TableInfoC;
import com.cofii2.myClasses.CC;
import com.cofii2.myInterfaces.IActions;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author C0FII
 */
public class SelectATable implements IActions {

      @Override
      public void beforeQuery() {

      }

      @Override
      public void setData(ResultSet rs, int row) throws SQLException {
            /*
            DT.setId(rs.getString(1));
            DT.setTable(rs.getString(2));
            DT.setDist1(rs.getString(3));
            DT.setDist2(rs.getString(4));
            DT.setImageC(rs.getString(5));
            DT.setTag(rs.getString(6));
            DT.setClock(rs.getString(7));
            */
            int id = rs.getInt(1);
            String table = rs.getString(2);
            String dist1 = rs.getString(3);
            String dist2 = rs.getString(4);
            String imageC = rs.getString(5);
            String tag = rs.getString(6);
            String Clock = rs.getString(7);
            
            TableInfoC.setId(id);
            TableInfoC.setTable(table);
            TableInfoC.setDist1(dist1);
            TableInfoC.setDist2(dist2);
            TableInfoC.setImageC(imageC);
            TableInfoC.setTag(tag);
            TableInfoC.setClock(Clock);
      }

      @Override
      public void afterQuery(String query, boolean rsValue) {
            
      }

      @Override
      public void exception(SQLException ex, String query) {
            System.out.println(CC.RED + query + CC.RESET);
            ex.printStackTrace();
            Status.startLBStatus(VF_R.getLB_Status(), Color.RED,
                    "SelectATable: " + ex.toString(), 8000);
      }

}
