package Listeners_F;

import First.VF_R;
import com.cofii.myMethods.MKey;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Christopher
 */
public class LSTSValueChanged implements ListSelectionListener {

      String CName = this.getClass().getName();
      //MethodM mm = new MethodM(CName, DT.CCount++);

      //Data dt = new Data();
      @Override
      public void valueChanged(ListSelectionEvent evt) {
            System.out.println("\nLST: ValueChanged");
            
            if (VF_R.getJLSTS()[0].isVisible() && VF_R.getJLSTS()[0].hasFocus()) {//LST_2
                  System.out.println("\tLST_2");
                  MKey.lst_ConfigDists_L(VF_R.getJLSTS()[0], 
                          null, VF_R.getJTFS()[1], 
                          VF_R.getJLBS()[1], evt);
                  
                  //mm.lst_ConfigDists_L(dt.getDm_2(), lst_2, null, tf_2, lb_2, evt);

            } else if (VF_R.getJLSTS()[1].isVisible() && VF_R.getJLSTS()[1].hasFocus()) {//LST_3
                  System.out.println("\tLST_3");
                  MKey.lst_ConfigDists_L(VF_R.getJLSTS()[1],
                          VF_R.getJTFS()[1], VF_R.getJTFS()[2],
                          VF_R.getJLBS()[2], evt);

            } else if (VF_R.getJLSTS()[2].isVisible() && VF_R.getJLSTS()[2].hasFocus()) {//LST_4
                  System.out.println("\tLST_4");
                  MKey.lst_ConfigDists_L(VF_R.getJLSTS()[2],
                          VF_R.getJTFS()[2], VF_R.getJTFS()[3],
                          VF_R.getJLBS()[3], evt);

            } else if (VF_R.getJLSTS()[3].isVisible() && VF_R.getJLSTS()[3].hasFocus()) {//LST_5
                  System.out.println("\tLST_5");
                  MKey.lst_ConfigDists_L(VF_R.getJLSTS()[3],
                          VF_R.getJTFS()[3], VF_R.getJTFS()[4],
                          VF_R.getJLBS()[4], evt);

            } else if (VF_R.getJLSTS()[4].isVisible() && VF_R.getJLSTS()[4].hasFocus()) {//LST_6
                  System.out.println("\tLST_6");
                  MKey.lst_ConfigDists_L(VF_R.getJLSTS()[4],
                          VF_R.getJTFS()[4], VF_R.getJTFS()[5],
                          VF_R.getJLBS()[5], evt);
            }
      }
}
