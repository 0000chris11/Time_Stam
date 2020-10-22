/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package First;

import Others.CC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author C0FII
 */
public class TestToCofii {
      
      String urlConnection;
      String user;
      String passw; 
      
      public void set(){
            urlConnection
              = "jdbc:mysql://localhost:3306/"
              + "TIME_STAM?allowPublicKeyRetrieval=true&"
              + "useSSL=false&"
              + "useJDBCCompliantTimezoneShift=true&"
              + "useLegacyDatetimeCode=false&"
              + "serverTimezone=UTC";
            
            user = "root";
            passw = "ccfmps00112";
      }
      
      public TestToCofii(){
            set();
            //++++++++++++++++++++++++++++++++++++++++++++
            toCofii tc = new toCofii(urlConnection, user, passw);
            System.out.println(CC.PURPLE + "\tColumn Count: " + tc.getColumnCount("Ranma") + CC.RESET);
            
            tc.SelectColumns("Ranma", new Actions(){
                  @Override
                  public void beforeQuery() {
                        System.out.println(CC.PURPLE + "\tBefore Query" + CC.RESET);
                  }

                  @Override
                  public void setData(ResultSet rs) {
                        try {
                              System.out.println(CC.PURPLE + "\trs: " + rs.getString(1) + CC.RESET);
                        } catch (SQLException ex) {
                              ex.printStackTrace();
                        }
                  }

                  @Override
                  public void afterQuery() {
                        System.out.println(CC.PURPLE + "\tAfter Query" + CC.RESET);
                  }

                  @Override
                  public void exception(SQLException ex) {
                        System.out.println(CC.PURPLE + "\tException!" + CC.RESET);
                  }
            });
      }
              
      public static void main(String[] args){
            new TestToCofii();
      }
}
