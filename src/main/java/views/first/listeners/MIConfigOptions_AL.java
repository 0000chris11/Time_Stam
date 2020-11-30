package views.first.listeners;

import views.first.VF_R;
import MC.DT;
import MC.DTSQL;
import MC.Status;
import MC.notMyMethods;
import SQLActions.SelectConfig;
import SQLActions.Update;
import com.cofii.myClasses.MSQL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;

/**
 *
 * @author C0FII
 */
public class MIConfigOptions_AL implements ActionListener {

      MSQL ms = new MSQL(DTSQL.getURLConnection(), DTSQL.getUser(), DTSQL.getPassw());

      @Override
      public void actionPerformed(ActionEvent e) {
            String item = ((JComponent) e.getSource()).getName();

            setFOptions(e, item);
            //setPanelsOptions(e, item);
            //+++++++++++++++++++++++++
            if (e.getActionCommand().contains("Save")) {
                  //Data dt = new Data("MIConfigOptions_AL");
                  int c = 0;
                  if (VF_R.getMI_AOT().getState() != DT.getList_BL().get(0)) {
                        //mc.UpdateConfig(VF_R.getMI_AOT().getState(), 1);
                        ms.updateRow(DTSQL.configTable,
                                DTSQL.configTableColumns[2], VF_R.getMI_AOT().getState(),
                                "id", 1, new Update("UpdateConfig", VF_R.getLB_Status()));
                        c++;
                  }
                  if (VF_R.getMI_AutoR().getState() != DT.getList_BL().get(1)) {
                        //mc.UpdateConfig(VF_R.getMI_AutoR().getState(), 2);
                        ms.updateRow(DTSQL.configTable,
                                DTSQL.configTableColumns[2], VF_R.getMI_AutoR().getState(),
                                "id", 2, new Update("UpdateConfig", VF_R.getLB_Status()));
                        c++;
                  }
                  if (VF_R.getMI_Grid().getState() != DT.getList_BL().get(2)) {
                        //mc.UpdateConfig(VF_R.getMI_Grid().getState(), 3);
                        ms.updateRow(DTSQL.configTable,
                                DTSQL.configTableColumns[2], VF_R.getMI_Grid().getState(),
                                "id", 3, new Update("UpdateConfig", VF_R.getLB_Status()));
                        c++;
                  }
                  if (c == 0) {
                        Status.startLBStatus(
                                VF_R.getLB_Status(), DT.RGY[2], "Nothing has changed.", 6000);
                  } else {
                        //mc.SelectConfig();
                        //ms.selectTables(DT.configTable, new SelectConfig());
                        ms.selectData(DTSQL.configTable, new SelectConfig());
                  }

            }
      }

      private void setFOptions(ActionEvent e, String item) {
            if (item.contains("mi_AOT")) {
                  if (VF_R.getMI_AOT().isSelected()) {
                        VF_R.getJF().setAlwaysOnTop(true);
                  } else {
                        VF_R.getJF().setAlwaysOnTop(false);
                  }

            } else if (item.contains("mi_AutoR")) {
                  boolean b = false;
                  if (VF_R.getMI_AutoR().isSelected()) {
                        b = true;
                  }
                  new notMyMethods().rez(VF_R.getJT(), b);

            } else if (item.contains("mi_Grid")) {
                  if (VF_R.getMI_Grid().isSelected()) {
                        VF_R.getJT().setShowGrid(true);
                  } else {
                        VF_R.getJT().setShowGrid(false);
                  }
            }
      }
}
