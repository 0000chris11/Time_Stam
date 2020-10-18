/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

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
      
      private static DefaultTableModel[] dtms = 
              new DefaultTableModel[DT.maxColumns];
      public static DefaultTableModel[] getDTMS(){
            return dtms;
      }
}
