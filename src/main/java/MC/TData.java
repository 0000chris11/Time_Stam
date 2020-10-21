/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MC;

import MC.DT;
import javax.swing.table.DefaultTableModel;

/**
 *Collection class that containins all values for Table funct
 * 
 * @author Christopher
 */
public class TData {
      
      private TData(){
            throw new IllegalStateException("PRIVATE CONSTRUCTOR");
      }
      
      public static DefaultTableModel[] dtms = 
              new DefaultTableModel[DT.maxColumns];
      
}
