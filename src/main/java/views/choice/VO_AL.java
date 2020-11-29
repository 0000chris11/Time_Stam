/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.choice;

import views.choice.VO;
import views.first.VF_R;
import MC.DT;
import MC.DTSQL;
import MC.MakeCon;
import SQLActions.DeleteTable;
import com.cofii.myClasses.MSQL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import smallComponenets.JPanelGradient;

/**
 *
 * @author Christopher
 */
public class VO_AL implements ActionListener {

      MakeCon mc = new MakeCon(this.getClass().toString(), DT.CCount++);
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
