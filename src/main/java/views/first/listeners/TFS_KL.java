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
            int cc = VF_R.getJT().getColumnCount();
            System.out.println("\nKEYPRESSED");

            for (JComboBox x : VF_R.getJCBS()) {
                  if (x.getEditor().getEditorComponent().hasFocus()) {
                        if (evt.isAltDown() || evt.isControlDown()) {
                              x.setPopupVisible(false);

                        } else if (!evt.isAltDown() && !evt.isControlDown()) {
                              x.setPopupVisible(true);
                        }
                  }
            }

            int TFN = 0;
            MComp.setLoopComponents(VF_R.getJTFS(), cc, evt);
            for (int a = 0; a < DT.maxColumns; a++) {
                  JTextField tf = VF_R.getJTFS()[a];
                  if (tf.hasFocus()) {
                        TFN = a;
                        System.out.println("\t" + tf.getName());
                        System.out.println("\t\tsetCountComponents: " + tf.getText());
                        MComp.setCountComponents(tf, evt);
                        System.out.println("\t\tsetCountComponents: " + tf.getText());
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
            System.out.println("\tsetCountComponents (END): " + VF_R.getJCBS()[TFN].getSelectedItem().toString());
            System.out.println("\tsetCountComponents (END): " + VF_R.getJTFS()[TFN].getText());
            
      }

      @Override
      public void keyReleased(KeyEvent evt) {
            //System.out.println("keyReleased");
            if (KeyEvent.VK_RIGHT == evt.getKeyCode()) {
            } else if (KeyEvent.VK_LEFT == evt.getKeyCode()) {
            } else {
                  //TFAllButR_L(evt);
            }

      }
      //++++++++++++++++++++++++++++++++++++++++

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
