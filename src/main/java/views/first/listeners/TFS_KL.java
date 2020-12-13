package views.first.listeners;

import views.first.VF_R;
import MC.DT;
import MC.LK_F;
import com.cofii.myMethods.MComp;
import com.cofii.myMethods.MKey;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author C0FII
 */
public class TFS_KL implements KeyListener {

      private int count = 0;

      @Override
      public void keyTyped(KeyEvent evt) {
      }

      @Override
      public void keyPressed(KeyEvent evt) {
            //LOOP CBS COMPONENTS++++++++++++++++++++++++++++
            System.out.println("\nKEYPRESSED");
            int cc = VF_R.getJT().getColumnCount();    
            MComp.setLoopComponents(VF_R.getJTFES(), cc, evt);
      }

      @Override
      public void keyReleased(KeyEvent evt) {
            //System.out.println("keyReleased");
            if (KeyEvent.VK_RIGHT == evt.getKeyCode()) {
            } else if (KeyEvent.VK_LEFT == evt.getKeyCode()) {
            } else {
                  TFAllButR_L(evt);
            }

      }
      //++++++++++++++++++++++++++++++++++++++++

      private void TFAllButR_L(KeyEvent evt) {
            if (!evt.isControlDown() || !evt.isAltDown()) {
                  //System.out.println("\tKEY: BUT LEFT & RIGHT");

                  if (VF_R.getJTFES()[1].hasFocus()) {
                        //System.out.println("\t\tTF_2");
                        if (VF_R.getJTFES()[1].getBackground().equals(LK_F.BK_DIST1)
                                || VF_R.getJTFES()[1].getBackground().equals(LK_F.BK_DIST2)) {
                              /*
                              MKey.tf_ConfigDists_K(VF_R.getJLBS()[1],
                                      VF_R.getJCBS()[1], VF_R.getJLSTS()[0],
                                      DT.getList_DS()[1], evt);//listsD[0]
                               */
                        } else {
                              //MKey.keyReleasedN_T(VF_R.getJCBS()[1], evt)
                        }
                  } else {
                        //++++++++++++++++++++++++++++++++++++++++++++
                        for (int a = 2; a < 6; a++) {
                              if (VF_R.getJCBS()[a].hasFocus()) {
                                    //System.out.println("\t\tTF_" + (a + 1));
                                    if (VF_R.getJCBS()[a].getBackground().equals(LK_F.BK_DIST1)
                                            || VF_R.getJCBS()[a].getBackground().equals(LK_F.BK_DIST2)) {
                                          if (DT.getList_MXS()[a].size() > 0) {
                                                //System.out.println("\t\tTF_" + (a + 1) + " KeyReleased FUSED");
                                                /*
                                                MKey.tf_ConfigDists_K(VF_R.getJLBS()[a],
                                                        VF_R.getJCBS()[a - 1], VF_R.getJCBS()[a],
                                                        VF_R.getJLSTS()[a - 1],
                                                        DT.getList_MXS()[a], evt);
                                                 */
                                          } else {
                                                //System.out.println("\t\tTF_" + (a + 1) + " KeyReleased NORMAL");
                                                /*
                                                MKey.tf_ConfigDists_K(VF_R.getJLBS()[a],
                                                        VF_R.getJCBS()[a - 1], VF_R.getJCBS()[a],
                                                        VF_R.getJLSTS()[a - 1],
                                                        DT.getList_DS()[a - 1], evt);//listsD[a - 1]
                                                 */
                                          }
                                    } else {
                                          //MKey.keyReleasedN_T(VF_R.getJCBS()[a], evt);
                                    }
                              }
                        }
                  }
            }
      }

}
