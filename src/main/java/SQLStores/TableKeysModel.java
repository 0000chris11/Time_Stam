/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLStores;

import com.cofii2.stores.IntString;

/**
 *
 * @author C0FII
 */
public class TableKeysModel {
      
      String table;
      String constraint_type;
      IntString pk;
      IntString fk;
      String tableR;
      String columnR;
      
      public TableKeysModel(String table, String constraint_type, IntString pk, IntString fk, String tableR, String columnR){
            this.table = table;
            this.constraint_type = constraint_type;
            this.pk = pk;
            this.fk = fk;
            this.tableR = tableR;
            this.columnR = columnR;
      }
}
