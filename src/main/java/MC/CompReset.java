/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MC;

import java.util.ArrayList;
import First.VF_R;
import SQLActions.SelectData;
import com.cofii.myClasses.MSQL;
import com.cofii.myMethods.MText;

/**
 *
 * @author Christopher
 */
public class CompReset {

      String CName = this.getClass().getName();
      MakeCon mc = new MakeCon(CName, DT.CCount++);
      MSQL ms = new MSQL(DT.urlConnection, DT.user, DT.passw);

      public void changeLB_TF(int cc, ArrayList<String> listC) {
            System.out.println("\tColumnCount: " + cc);

            String[] cols = new String[listC.size()];//TEXT FOR LABELS
            for (int a = 0; a < cols.length; a++) {
                  System.out.println("\tlistC " + a + ": " + listC.get(a));
                  cols[a] = listC.get(a);
            }

            String ed2 = MText.filterTextName(DT.getTable(), "TAKE");
            DT.setTable(MText.filterTextName(DT.getTable(), "ADD"));
            //++++++++++++++++++++++++++++++++++++++++++++++++
            VF_R.getLB_Title().setText(ed2);

            for (int a = 0; a < DT.maxColumns ; a++) {//Limit of 2 to 6
                  if (cc == a + 1) {
                        if (VF_R.JPL_layout.equals("null")) {
                              //IF IS 1 COL THE LB_ICON BE BELLOW TFS[0]
                              VF_R.getLB_Icon().setLocation(VF_R.getLB_Icon().getX(),
                                      VF_R.getJTFS()[a].getY() + 66);
                        }

                        //MAKE COMPONENTS UNDER LIMIT VISIBLE
                        for (int b = 0; b < a + 1; b++) {
                              //1, 2, 3, 4, 5
                              VF_R.getJLBS()[b].setText((b + 1) + ". " + cols[b]);
                              MText.shortenLB(VF_R.getJLBS()[b]);

                              VF_R.getJLBS()[b].setVisible(true);
                              VF_R.getJTFS()[b].setVisible(true);
                              VF_R.getBTNS_C()[b].setVisible(true);
                        }
                        //HIDES OUT LENGTH COMPONENTS
                        for (int b = 0; b < DT.maxColumns - (a + 1); b++) {//4
                              VF_R.getJLBS()[b + (1 + a)].setVisible(false);
                              VF_R.getJTFS()[b + (1 + a)].setVisible(false);
                              VF_R.getBTNS_C()[b + (0 + a)].setVisible(false);
                        }

                        //mc.SelectData(a + 1, DT.getTable());
                        ms.selectData(DT.getTable(), new SelectData(a + 1));
                  }
            }
      }
}
