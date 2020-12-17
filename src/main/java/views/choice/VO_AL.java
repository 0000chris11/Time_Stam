/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.choice;

import views.choice.VO;
import MC.DTSQL;
import SQLActions.DeleteTable;
import com.cofii2.myClasses.MSQL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author C0FII
 */
public class VO_AL implements ActionListener {

      MSQL ms = new MSQL(DTSQL.getURLConnection(), DTSQL.getUser(), DTSQL.getPassw());
      private String QT;
      private String Table;

      @Override
      public void actionPerformed(ActionEvent e) {
            if (QT.equals("Delete this table?")) {
                  if (e.getActionCommand().equals("Yes")) {
                        ms.deleteTable(Table, new DeleteTable(Table));
                  }
                  VO.getJF().dispose();
            }
      }

      public VO_AL(String qt, String table) {
            QT = qt;
            Table = table;
      }

}
