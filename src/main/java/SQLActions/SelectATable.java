/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import views.first.VF_R;
import MC.DT;
import MC.Status;
import com.cofii.myClasses.CC;
import com.cofii.myInterfaces.IActions;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author C0FII
 */
public class SelectATable implements IActions {

      @Override
      public void beforeQuery() {

      }

      @Override
      public void setData(ResultSet rs, int row) throws SQLException{
            DT.setId(rs.getString(1));
            DT.setTable(rs.getString(2));
            DT.setDist1(rs.getString(3));
            DT.setDist2(rs.getString(4));
            DT.setImageC(rs.getString(5));
            DT.setTag(rs.getString(6));
            DT.setClock(rs.getString(7));
      }

      @Override
      public void afterQuery(String query, boolean rsValue) {
            System.out.println("###AfterQuery: " + query);
            System.out.println("Table: " + DT.getTable());
            System.out.println("Dist1: " + DT.getDist1());
            System.out.println("Dist2: " + DT.getDist2());
            System.out.println("ImageC: " + DT.getImageC());
            System.out.println("Tag: " + DT.getTag());
            System.out.println("Clock: " + DT.getClock());
      }

      @Override
      public void exception(SQLException ex, String query) {
            System.out.println(CC.RED + query + CC.RESET);
            ex.printStackTrace();
            Status.startLBStatus(VF_R.getLB_Status(), Color.RED,
                          "SelectATable: " + ex.toString(), 8000);
      }

}
