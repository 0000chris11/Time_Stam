/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MC;

import MC.DT;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *Collection class that containins all values for Table funct
 * 
 * @author Christopher
 */
public class DTT {
      
      private DTT(){
            throw new IllegalStateException("PRIVATE CONSTRUCTOR");
      }
      
      private static DefaultTableModel[] dtms = 
              new DefaultTableModel[DT.maxColumns];
      
      
      //++++++++++++++++++++++++++++++++++++++++++
      public static DefaultTableModel[] getDTMS() {
            return dtms;
      }
      
      
      /*
      private static DefaultTableModel[] dtms = new DefaultTableModel[]{
            null, null, 
            new CustomTableModel(2), new CustomTableModel(3), 
            new CustomTableModel(4), new CustomTableModel(5), 
            new CustomTableModel(6)};
      
      private static TableModel[] dtms2 = new TableModel[]{
            null, null, 
            new CustomTableModel(2), new CustomTableModel(3), 
            new CustomTableModel(4), new CustomTableModel(5), 
            new CustomTableModel(6)};
      */
}
