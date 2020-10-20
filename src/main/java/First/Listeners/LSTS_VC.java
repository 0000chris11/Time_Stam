package First.Listeners;

import First.VF_R;
import MC.DT;
import com.cofii.myMethods.MKey;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Christopher
 */
public class LSTS_VC implements ListSelectionListener {

      String CName = this.getClass().getName();
      //MethodM mm = new MethodM(CName, DT.CCount++);

      //Data dt = new Data();
      @Override
      public void valueChanged(ListSelectionEvent evt) {
            System.out.println("\nLST: ValueChanged");

            for (int a = 0; a < DT.maxColumns; a++) {
                  if (VF_R.getJLSTS()[a].isVisible() && VF_R.getJLSTS()[a].hasFocus()) {
                        System.out.println("\tLST_" + (a + 1));
                        if (a == 0) {
                              MKey.lst_ConfigDists_L(VF_R.getJLSTS()[a],
                                      null, VF_R.getJTFS()[a],
                                      VF_R.getJLBS()[a]);
                              
                        }else{
                              MKey.lst_ConfigDists_L(VF_R.getJLSTS()[a], 
                                      VF_R.getJTFS()[a - 1], VF_R.getJTFS()[a], 
                                      VF_R.getJLBS()[a]);
                        }
                  }
            }
            /*
            if (VF_R.getJLSTS()[0].isVisible() && VF_R.getJLSTS()[0].hasFocus()) {//LST_1
                  System.out.println("\tLST_1");
                  MKey.lst_ConfigDists_L(VF_R.getJLSTS()[0],
                          null, VF_R.getJTFS()[0],
                          VF_R.getJLBS()[0], evt);

                  //mm.lst_ConfigDists_L(dt.getDm_2(), lst_2, null, tf_2, lb_2, evt);
            } else if (VF_R.getJLSTS()[1].isVisible() && VF_R.getJLSTS()[1].hasFocus()) {//LST_2
                  System.out.println("\tLST_2");
                  MKey.lst_ConfigDists_L(VF_R.getJLSTS()[1],
                          VF_R.getJTFS()[0], VF_R.getJTFS()[1],
                          VF_R.getJLBS()[1], evt);

            } else if (VF_R.getJLSTS()[2].isVisible() && VF_R.getJLSTS()[2].hasFocus()) {//LST_3
                  System.out.println("\tLST_3");
                  MKey.lst_ConfigDists_L(VF_R.getJLSTS()[2],
                          VF_R.getJTFS()[1], VF_R.getJTFS()[2],
                          VF_R.getJLBS()[2], evt);

            } else if (VF_R.getJLSTS()[3].isVisible() && VF_R.getJLSTS()[3].hasFocus()) {//LST_4
                  System.out.println("\tLST_4");
                  MKey.lst_ConfigDists_L(VF_R.getJLSTS()[3],
                          VF_R.getJTFS()[2], VF_R.getJTFS()[3],
                          VF_R.getJLBS()[3], evt);

            } else if (VF_R.getJLSTS()[4].isVisible() && VF_R.getJLSTS()[4].hasFocus()) {//LST_5
                  System.out.println("\tLST_5");
                  MKey.lst_ConfigDists_L(VF_R.getJLSTS()[4],
                          VF_R.getJTFS()[3], VF_R.getJTFS()[4],
                          VF_R.getJLBS()[4], evt);
            }
            */
      }
}
