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
public class CreatePKTable implements IUpdates{

      @Override
      public void executeResultRowN() {
            System.out.println("\tPK Table creation FAIL");
      }

      @Override
      public void executeResult0() {
            System.out.println("\tPK Table has been created");
      }

      @Override
      public void exception(SQLException ex) {
            ex.printStackTrace();
      }
      
}
