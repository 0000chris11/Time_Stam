/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLStores;

import com.cofii2.stores.IntString;

/**
 *Class for stroring tables column types
 * 
 * @author C0FII
 */
public class TableType {
      
      private int id = -1;
      private String table = null;
      //private String type = null;
      //private boolean nulll = true;//DEFAULT
      private IntString pk = null;
      private IntString fk = null;
      //private String defaultt = null;
      private IntString ex = null;
      
      public TableType(int id, String table, IntString pk, IntString fk, IntString ex){
            this.id = id;
            this.table = table;
            this.pk = pk;
            this.fk = fk;
            this.ex = ex;
      }
      
      public int getId(){
            return id;
      }
      public void setId(int id){
            this.id = id;
      }
      
      public String getTable(){
            return table;
      }
      public void setTable(String table){
            this.table = table;
      }
      
      public IntString getPK(){
            return pk;
      }
      public void setPK(IntString pk){
            this.pk = pk;
      }
      
      public IntString getFK(){
            return fk;
      }
      public void setFK(IntString fk){
            this.fk = fk;
      }
      
      public IntString getEX(){
            return ex;
      }
      public void setEX(IntString ex){
            this.ex = ex;
      }
}
