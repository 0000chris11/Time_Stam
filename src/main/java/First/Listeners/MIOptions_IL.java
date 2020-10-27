package First.Listeners;

import First.VF_R;
import MC.DT;
import MC.MakeCon;
import MC.Status;
import MC.notMyMethods;
import SQLActions.SelectConfig;
import SQLActions.UpdateTable;
import com.cofii.myClasses.MSQL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;

/**
 *
 * @author C0FII
 */
public class MIOptions_IL implements ActionListener {

      MakeCon mc = new MakeCon(this.getClass().getName(), DT.CCount++);
      MSQL ms = new MSQL(DT.urlConnection, DT.user, DT.passw);

      @Override
      public void actionPerformed(ActionEvent e) {
            String item = ((JComponent) e.getSource()).getName();

            setFOptions(e, item);
            //setPanelsOptions(e, item);
            //+++++++++++++++++++++++++
            if (e.getActionCommand().contains("Save")) {
                  //Data dt = new Data("MIOptions_IL");

                  if (VF_R.getMI_AOT().getState() != DT.getList_BL().get(0)) {
                        //mc.UpdateConfig(VF_R.getMI_AOT().getState(), 1);
                        ms.updateRow(DT.configTable,
                                DT.configColumn, VF_R.getMI_AOT().getState(),
                                "id", 1, new UpdateTable("UpdateConfig: "));

                  } else if (VF_R.getMI_AutoR().getState() != DT.getList_BL().get(1)) {
                        //mc.UpdateConfig(VF_R.getMI_AutoR().getState(), 2);
                        ms.updateRow(DT.configTable,
                                DT.configColumn, VF_R.getMI_AutoR().getState(),
                                "id", 2, new UpdateTable("UpdateConfig: "));
                        
                  } else if (VF_R.getMI_Grid().getState() != DT.getList_BL().get(2)) {
                        //mc.UpdateConfig(VF_R.getMI_Grid().getState(), 3);
                        ms.updateRow(DT.configTable,
                                DT.configColumn, VF_R.getMI_Grid().getState(),
                                "id", 3, new UpdateTable("UpdateConfig: "));
                        
                  } else {
                        Status.startLBStatus(
                                VF_R.getLB_Status(), DT.RGY[2], "Nothing has changed.", 6000);
                  }
                  //mc.SelectConfig();
                  ms.selectTables(DT.configTable, new SelectConfig());

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
