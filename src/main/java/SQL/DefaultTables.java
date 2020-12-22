/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import com.cofii2.stores.DString;

/**
 *
 * @author C0FII
 */
public class DefaultTables extends DString{
      
      private static final String table1 = "table_names";
      private static final String table2 = "table_types";
      
      public DefaultTables() {
            super(table1, table2);
      }
      
}
