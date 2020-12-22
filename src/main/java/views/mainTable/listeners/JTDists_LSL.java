/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.mainTable.listeners;

import MC.DTSQL;
import MC.MainInstances;
import com.cofii2.mysql.MSQL;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import views.mainTable.VMT_DataCom;
import views.mainTable.sql.SelectColumns;

/**
 *
 * @author C0FII
 */
public class JTDists_LSL implements ListSelectionListener {

      private VMT_DataCom dt = MainInstances.getVMT_DataCom();
      private MSQL ms = new MSQL(DTSQL.getURLConnection(), DTSQL.getUser(), DTSQL.getPassw());

      @Override
      public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) {
                  if (dt.getJTDists().getSelectionModel().isSelectionEmpty()) {
                        dt.getCD().show(dt.getPU(), "LB_TYPES");

                  } else {
                        int row = dt.getJTDists().getSelectedRow();
                        String table = dt.getJTDists().getValueAt(row, 1).toString();
                        System.out.println("TABLE: " + table);
                        ms.selectColumns(table, new SelectColumns());

                  }
            }
      }
}
