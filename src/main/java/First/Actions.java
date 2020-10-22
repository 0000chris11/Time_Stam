/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package First;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author C0FII
 */
public interface Actions {
      
      public void beforeQuery();
      public void setData(ResultSet rs) throws SQLException;
      public void afterQuery();
      public void exception(SQLException ex);
}
