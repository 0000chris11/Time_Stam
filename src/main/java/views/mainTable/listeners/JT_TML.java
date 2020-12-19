/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.mainTable.listeners;

import MC.MainInstances;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import views.mainTable.VMT_DataCom;

/**
 *
 * @author C0FII
 */
public class JT_TML implements TableModelListener{

      private VMT_DataCom dt = MainInstances.getVMT_DataCom();
      
      @Override
      public void tableChanged(TableModelEvent e) {
            System.out.println("TABLE CHANGED");
            
      }
      
}
