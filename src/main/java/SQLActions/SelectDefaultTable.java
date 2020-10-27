/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import MC.DT;
import com.cofii.myInterfaces.IActions;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author C0FII
 */
public class SelectDefaultTable implements IActions {

      @Override
      public void beforeQuery() {

      }

      @Override
      public void setData(ResultSet rs) throws SQLException {
            DT.setId(rs.getString(1));
            DT.setTable(rs.getString(2));
            DT.setDTable(rs.getString(2));
            DT.setDist1(rs.getString(3));
            DT.setDist2(rs.getString(4));
            DT.setTabl(rs.getString(5));
            DT.setTag(rs.getString(6));
            DT.setClock(rs.getString(7));
      }

      @Override
      public void afterQuery() {
            
      }

      @Override
      public void exception(SQLException sqle) {
            sqle.printStackTrace();
      }

}
