/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.mainTable.listeners;

import MC.DTSQL;
import MC.MainInstances;
import SQLActions.SelectColumns;
import com.cofii2.myClasses.MSQL;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import views.mainTable.VMT;

/**
 *
 * @author C0FII
 */
public class CBTables_IL implements ItemListener {

      private VMT dt = MainInstances.getVMT();
      private MSQL ms = new MSQL(DTSQL.getURLConnection(), DTSQL.getUser(), DTSQL.getPassw());

      @Override
      public void itemStateChanged(ItemEvent e) {
            JComboBox cb = dt.getCBTables();
            JTextField tf = (JTextField) cb.getEditor().getEditorComponent();
            String text = tf.getText();
            if (!text.isEmpty()) {
                  String selected = cb.getSelectedItem().toString();
                  ms.selectColumns(selected, new SelectColumns());
            }
      }

}
