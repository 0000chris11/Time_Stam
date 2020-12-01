package views.first.listeners;

import views.first.VF_R;
import MC.DT;
import MC.LK;
import com.cofii.myMethods.MComp;
import com.cofii.myMethods.MKey;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

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
            int cc = VF_R.getJT().getColumnCount();
            System.out.println("\n\n" + ++count + " " + evt.getComponent().getName());
            System.out.println("\tcolumn count: " + cc);

            MComp.setLoopComponents(VF_R.getJTFS(), cc, evt);
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (VF_R.getJTFS()[a].hasFocus()) {
                        MComp.setCountComponents(VF_R.getJTFS()[a], evt);
                  }
            }

            if (KeyEvent.VK_RIGHT == evt.getKeyCode()) {
                  if (evt.isControlDown()) {
                        //System.out.println("\tCTRL + RIGHT");
                        for (int a = 0; a < DT.maxColumns; a++) {
                              if (VF_R.getJCBS()[a].hasFocus()) {
                                    VF_R.getTFS_MD()[a].requestFocus();
                              }
                        }
                  }
            } else if (KeyEvent.VK_LEFT == evt.getKeyCode()) {
                  if (evt.isControlDown()) {
                        //System.out.println("\tCTRL + LEFT");
                        for (int a = 0; a < DT.maxColumns; a++) {
                              if (VF_R.getJCBS()[a].hasFocus()) {
                                    VF_R.getTFS_SU()[a].requestFocus();
                              }
                        }
                  }
            }
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
      private void changeFocusDownLoop() {
            for (int a = 0; a < VF_R.getJT().getColumnCount(); a++) {
                  //System.out.println("\tDOWN// B: a = " + a);
                  if (a == VF_R.getJT().getColumnCount() - 1) {//Last one to the First one                  
                        //if (VF_R.getJCBS()[a].getBackground().equals(C)) {
                        if (VF_R.getJCBS()[a].hasFocus()) {
                              //System.out.println("\tDOWN// Last One to First One");
                              VF_R.getJCBS()[0].requestFocus();
                        }
                        //}
                  } else {
                        if (VF_R.getJCBS()[a].hasFocus()) {
                              //System.out.println("\tDOWN// tf_1 has the focus");
                              VF_R.getJCBS()[a + 1].requestFocus();
                        }
                  }
            }
      }

      private void changeFocusUpLoop() {
            //System.out.println("SC Size = " + SC);
            for (int a = 0; a < VF_R.getJT().getColumnCount(); a++) {
                  //System.out.println("\tUP// B: a = " + a);
                  if (a == 0) {//Without asking for background && First to the Last one
                        if (VF_R.getJCBS()[a].hasFocus()) {
                              //System.out.println("\tUP// First One to Last One");
                              VF_R.getJCBS()[VF_R.getJT().getColumnCount() - 1].requestFocus();
                        }
                  } else {
                        //if (VF_R.getJCBS()[a].getBackground().equals(C)) {
                        if (VF_R.getJCBS()[a].hasFocus()) {
                              //System.out.println("\tUP// normal");
                              VF_R.getJCBS()[a - 1].requestFocus();
                        }
                        //}
                  }
            }
      }

      //+++++++++++++++++++++++++++++++++++++++
      private void TFAllButR_L(KeyEvent evt) {
            if (!evt.isControlDown() || !evt.isAltDown()) {
                  //System.out.println("\tKEY: BUT LEFT & RIGHT");

                  if (VF_R.getJCBS()[1].hasFocus()) {
                        //System.out.println("\t\tTF_2");
                        if (VF_R.getJCBS()[1].getBackground().equals(LK.CP_BK_DIST1)
                                || VF_R.getJCBS()[1].getBackground().equals(LK.CP_BK_DIST2)) {
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
                                    if (VF_R.getJCBS()[a].getBackground().equals(LK.CP_BK_DIST1)
                                            || VF_R.getJCBS()[a].getBackground().equals(LK.CP_BK_DIST2)) {
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
