/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import MC.DT;
import com.cofii.myClasses.CC;
import com.cofii.myInterfaces.IActions;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author C0FII
 */
public class SelectDefaultTable implements IActions {
      
      @Override
      public void beforeQuery() {


      }

      @Override
      public void setData(ResultSet rs) throws SQLException{
            
            DT.setId(rs.getString(1));
            DT.setTable(rs.getString(2));
            DT.setDTable(rs.getString(2));
            DT.setDist1(rs.getString(3));
            DT.setDist2(rs.getString(4));
            DT.setImageC(rs.getString(5));
            DT.setTag(rs.getString(6));
            DT.setClock(rs.getString(7));
            //GETTING NULLS FROM RESULTSET
      }

      @Override
      public void exception(SQLException sqle, String query) {
            System.out.println(CC.RED + query + CC.RESET);
            sqle.printStackTrace();
      }

      @Override
      public void afterQuery(String query, boolean rsValue) {
            System.out.println("###AfterQuery: " + query);
            System.out.println("Dist1: " + DT.getDist1());
            System.out.println("Dist2: " + DT.getDist2());
            System.out.println("Clock: " + DT.getClock());
      }

}
