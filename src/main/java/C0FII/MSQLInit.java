/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C0FII;

import com.cofii.myInterfaces.IActions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author C0FII
 */
public class MSQLInit {

      public Connection con;
      public String sql;
      public Statement stt;
      public PreparedStatement pstt;
      public ResultSet rs;

      public MSQLInit(MSQLConnect msc) {
            System.out.println("does this constructo happens twice");
            try {
                  con = DriverManager.getConnection(
                          msc.URLConnection, msc.User, msc.Password);
            } catch (SQLException ex) {
                  Logger.getLogger(MSQLInit.class.getName()).log(Level.SEVERE, null, ex);
            }

      }
      
      public void query(IActions ac) throws SQLException {
            stt = con.createStatement();
            rs = stt.executeQuery(sql);

            if (ac != null) {
                  ac.beforeQuery();
                  int row = 0;
                  boolean rsValue = false;
                  while (rs.next()) {
                        row++;
                        rsValue = true;
                        ac.setData(rs, row);
                  }

                  ac.afterQuery(sql, rsValue);
            } else {
                  throw new NullPointerException("IAction can't be null");
            }
      }
      
      public Connection getConnection() {
            return con;
      }
}
