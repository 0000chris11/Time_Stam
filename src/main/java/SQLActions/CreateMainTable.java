/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLActions;

import com.cofii2.myInterfaces.IUpdates;
import java.sql.SQLException;

/**
 *
 * @author C0FII
 */
public class CreateMainTable implements IUpdates{

      @Override
      public void executeResultRowN() {
            System.out.println("\tMain Table creation FAIL");
      }

      @Override
      public void executeResult0() {
            System.out.println("\tMain Table has been created");
      }

      @Override
      public void exception(SQLException sqle) {
            sqle.printStackTrace();
      }
      
}
