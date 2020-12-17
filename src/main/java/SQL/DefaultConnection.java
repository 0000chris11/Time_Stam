/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import MC.DTSQL;
import com.cofii2.mysql.Connect;

/**
 *
 * @author C0FII
 */
public class DefaultConnection extends Connect{
      
      private static final String urlConnection = DTSQL.getURLConnection();
      private static final String user = DTSQL.getUser();
      private static final String password = DTSQL.getPassw();
      
      public DefaultConnection() {
            super(urlConnection, user, password);
      }
      
}
