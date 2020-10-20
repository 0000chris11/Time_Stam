/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MC;

import java.util.ArrayList;
import First.VF_R;
import com.cofii.myMethods.MText;

/**
 *
 * @author Christopher
 */
public class CompReset {

      String CName = this.getClass().getName();
      MakeCon mc = new MakeCon(CName, DT.CCount++);

      public void changeLB_TF(int cc, ArrayList<String> listC) {
            System.out.println("\tColumnCount: " + cc);

            String[] cols = new String[listC.size()];//TEXT FOR LABELS
            for (int a = 0; a < cols.length; a++) {
                  System.out.println("\tlistC " + a + ": " + listC.get(a));
                  cols[a] = listC.get(a);
            }
            //String[] cols = {null, null, col2, col3, col4, col5, col6};

            String ed2 = MText.filterTextName(DT.getTable(), "TAKE");
            DT.setTable(MText.filterTextName(DT.getTable(), "ADD"));
            //++++++++++++++++++++++++++++++++++++++++++++++++
            VF_R.getLB_Title().setText(ed2);

            for (int a = 0; a < DT.maxColumns - 1; a++) {//Limit of 2 to 6
                  if (cc == a + 2) {
                        //System.out.println("\nCOLUMN NUMBER: " + (a + 2));
                        for (int b = 0; b < a; b++) {
                              //0, 1, 2, 3, 4
                              //VF_R.getJLBS()[b + 2].setLocation(6, VF_R.getJLBS()[b + 1].getY() + 33);
                              //VF_R.getJTFS()[b + 2].setLocation(107, VF_R.getJTFS()[b + 1].getY() + 33);
                              //VF_R.getBTNS_C()[b + 1].setLocation(402, VF_R.getBTNS_C()[b].getY() + 33);
                        }
                        if (VF_R.JPL_layout.equals("null")) {
                              VF_R.getLB_Icon().setLocation(VF_R.getLB_Icon().getX(),
                                      VF_R.getJTFS()[a + 1].getY() + 66);
                        }

                        //MAKE COMPONENTS UNDER LIMIT VISIBLE
                        for (int b = 0; b < a + 1; b++) {
                              //1, 2, 3, 4, 5
                              VF_R.getJLBS()[b + 1].setText((b + 2) + ". " + cols[b + 1]);
                              MText.shortenLB(VF_R.getJLBS()[b + 1]);

                              VF_R.getJLBS()[b + 1].setVisible(true);
                              VF_R.getJTFS()[b + 1].setVisible(true);
                              VF_R.getBTNS_C()[b].setVisible(true);
                        }
                        //HIDES OUT LENGTH COMPONENTS
                        for (int b = 0; b < VF_R.getJLBS().length - (a + 2); b++) {//4
                              VF_R.getJLBS()[b + (2 + a)].setVisible(false);
                              VF_R.getJTFS()[b + (2 + a)].setVisible(false);
                              VF_R.getBTNS_C()[b + (1 + a)].setVisible(false);
                        }

                        mc.SelectData(a + 2, DT.getTable());
                  }
            }
      }
}
