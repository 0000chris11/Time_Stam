/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MC;

import java.util.ArrayList;
import views.first.VF_R;
import SQLActions.SelectData;
import com.cofii.myClasses.MSQL;
import com.cofii.myMethods.MText;

/**
 *
 * @author Christopher
 */
public class CompReset {

      String CName = this.getClass().getName();
      MSQL ms = new MSQL(DTSQL.getURLConnection(), DTSQL.getUser(), DTSQL.getPassw());

      public void changeLB_TFandSelectData(int cc, ArrayList<String> listC) {
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

            for (int a = 0; a < DT.maxColumns ; a++) {//Limit of 1 to 6
                  if (cc == a + 1) {
                        if (VF_R.JPL_layout.equals("null")) {
                              //IF IS 1 COL THE LB_ICON BE BELLOW TFS[0]
                              VF_R.getLB_Icon().setLocation(VF_R.getLB_Icon().getX(),
                                      VF_R.getJCBS()[a].getY() + 66);
                        }

                        //MAKE COMPONENTS UNDER LIMIT VISIBLE
                        for (int b = 0; b < a + 1; b++) {
                              //1, 2, 3, 4, 5
                              VF_R.getJLBS()[b].setText((b + 1) + ". " + cols[b]);
                              MText.shortenLB(VF_R.getJLBS()[b]);

                              VF_R.getJLBS()[b].setVisible(true);
                              VF_R.getJTFPanel()[b].setVisible(true);
                              VF_R.getBTNS_C()[b].setVisible(true);
                              
                              if(VF_R.getJTFPanel()[b].getComponent(0).getName().contains("TF")){
                                    VF_R.getJTFPanel()[b].remove(VF_R.getJTFS()[b]);
                                    VF_R.getJTFPanel()[b].add(VF_R.getJCBS()[b], 0);
                              }
                        }
                        //HIDES OUT LENGTH COMPONENTS
                        for (int b = 0; b < DT.maxColumns - (a + 1); b++) {//4
                              VF_R.getJLBS()[b + (1 + a)].setVisible(false);
                              VF_R.getJTFPanel()[b + (1 + a)].setVisible(false);
                              VF_R.getBTNS_C()[b + (1 + a)].setVisible(false);
                        }

                        //mc.SelectData(a + 1, DT.getTable());
                        ms.selectData(DT.getTable(), new SelectData(a + 1));
                  }
            }
      }
}
