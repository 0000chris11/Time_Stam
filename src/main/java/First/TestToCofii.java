/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package First;

import com.cofii.myClasses.CC;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            
      }
              
      public static void main(String[] args){
            new TestToCofii();
      }
}
