package First.Listeners;

import First.VF_R;
import MC.DT;
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

      //CLASS FOR FOCUS CHANGE
      String CName = this.getClass().getName();

      //private MethodM mm = new MethodM(CName, DT.CCount++);
      //private Data dt = new Data("TFS_KL");
      private final Color[] C = new Color[]{new Color(51, 51, 51), new Color(0, 0, 51),
            new Color(0, 0, 81)};

      //private final ArrayList<String>[] listsD = new ArrayList[5];
      private final ArrayList<String>[] listsS = new ArrayList[4];
      //int[] sizeS = new int[]{DT.getList_S23().size(), DT.getList_S34().size(),
        //    DT.getList_S45().size(), DT.getList_S56().size()};

      //private int SC = -1;
      public TFS_KL() {
            /*
            listsD[0] = DT.getListD_2();
            listsD[1] = DT.getListD_3();
            listsD[2] = DT.getListD_4();
            listsD[3] = DT.getListD_5();
            listsD[4] = DT.getListD_6();
            
            listsS[0] = DT.getList_S23();
            listsS[1] = DT.getList_S34();
            listsS[2] = DT.getList_S45();
            listsS[3] = DT.getList_S56();
            */
      }

      @Override
      public void keyTyped(KeyEvent evt) {
            //System.out.println("keyTyped");
      }

      @Override
      public void keyPressed(KeyEvent evt) {
            //System.out.println("keyPressed");
            //int sizeC = dt.getList_C().size();
            if (KeyEvent.VK_DOWN == evt.getKeyCode()) {
                  if (evt.isControlDown() && !evt.isAltDown()) {
                        //System.out.println("CRTL + DOWN");
                        changeFocusDownLoop();
                  } else if (evt.isAltDown() && !evt.isControlDown()) {
                        countDownUp(evt);
                  }
            } else if (KeyEvent.VK_UP == evt.getKeyCode()) {
                  if (evt.isControlDown() && !evt.isAltDown()) {
                        //System.out.println("CRTL + UP");
                        changeFocusUpLoop();
                  }else if(evt.isAltDown() && !evt.isControlDown()){
                        countDownUp(evt);
                  }
            } else if (KeyEvent.VK_RIGHT == evt.getKeyCode()) {
                  if (evt.isControlDown()) {
                        //System.out.println("\tCTRL + RIGHT");
                        for (int a = 0; a < DT.maxColumns; a++) {
                              if (VF_R.getJTFS()[a].hasFocus()) {
                                    VF_R.getTFS_MD()[a].requestFocus();
                              }
                        }
                  }
            } else if (KeyEvent.VK_LEFT == evt.getKeyCode()) {
                  if (evt.isControlDown()) {
                        //System.out.println("\tCTRL + LEFT");
                        for (int a = 0; a < DT.maxColumns; a++) {
                              if (VF_R.getJTFS()[a].hasFocus()) {
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
                        //if (VF_R.getJTFS()[a].getBackground().equals(C)) {
                        if (VF_R.getJTFS()[a].hasFocus()) {
                              //System.out.println("\tDOWN// Last One to First One");
                              VF_R.getJTFS()[0].requestFocus();
                        }
                        //}
                  } else {
                        if (VF_R.getJTFS()[a].hasFocus()) {
                              //System.out.println("\tDOWN// tf_1 has the focus");
                              VF_R.getJTFS()[a + 1].requestFocus();
                        }
                  }
            }
      }

      private void changeFocusUpLoop() {
            //System.out.println("SC Size = " + SC);
            for (int a = 0; a < VF_R.getJT().getColumnCount(); a++) {
                  //System.out.println("\tUP// B: a = " + a);
                  if (a == 0) {//Without asking for background && First to the Last one
                        if (VF_R.getJTFS()[a].hasFocus()) {
                              //System.out.println("\tUP// First One to Last One");
                              VF_R.getJTFS()[VF_R.getJT().getColumnCount() - 1].requestFocus();
                        }
                  } else {
                        //if (VF_R.getJTFS()[a].getBackground().equals(C)) {
                        if (VF_R.getJTFS()[a].hasFocus()) {
                              //System.out.println("\tUP// normal");
                              VF_R.getJTFS()[a - 1].requestFocus();
                        }
                        //}
                  }
            }
      }

      //+++++++++++++++++++++++++++++++++++++++
      private void countDownUp(KeyEvent evt) {
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (VF_R.getJTFS()[a].hasFocus()) {
                        MKey.keyReleasedN_T(VF_R.getJTFS()[a], evt);
                  }
            }
      }

      //+++++++++++++++++++++++++++++++++++++++
      private void TFAllButR_L(KeyEvent evt) {
            if (!evt.isControlDown() || !evt.isAltDown()) {
                  //System.out.println("\tKEY: BUT LEFT & RIGHT");

                  if (VF_R.getJTFS()[1].hasFocus()) {
                        //System.out.println("\t\tTF_2");
                        if (VF_R.getJTFS()[1].getBackground().equals(C[1])
                                || VF_R.getJTFS()[1].getBackground().equals(C[2])) {
                              
                              MKey.tf_ConfigDists_K(VF_R.getJLBS()[1],
                                      VF_R.getJTFS()[1], VF_R.getJLSTS()[0],
                                      DT.getList_DS()[1], evt);//listsD[0]
                        } else {
                              //MKey.keyReleasedN_T(VF_R.getJTFS()[1], evt)
                        }
                  } else {
                        //++++++++++++++++++++++++++++++++++++++++++++
                        for (int a = 2; a < 6; a++) {
                              if (VF_R.getJTFS()[a].hasFocus()) {
                                    //System.out.println("\t\tTF_" + (a + 1));
                                    if (VF_R.getJTFS()[a].getBackground().equals(C[1])
                                            || VF_R.getJTFS()[a].getBackground().equals(C[2])) {
                                          if (DT.getList_MXS()[a].size() > 0) {
                                                //System.out.println("\t\tTF_" + (a + 1) + " KeyReleased FUSED");
                                                MKey.tf_ConfigDists_K(VF_R.getJLBS()[a],
                                                        VF_R.getJTFS()[a - 1], VF_R.getJTFS()[a],
                                                        VF_R.getJLSTS()[a - 1],
                                                        DT.getList_MXS()[a], evt);
                                          } else {
                                                //System.out.println("\t\tTF_" + (a + 1) + " KeyReleased NORMAL");
                                                MKey.tf_ConfigDists_K(VF_R.getJLBS()[a],
                                                        VF_R.getJTFS()[a - 1], VF_R.getJTFS()[a],
                                                        VF_R.getJLSTS()[a - 1],
                                                        DT.getList_DS()[a - 1], evt);//listsD[a - 1]
                                          }
                                    } else {
                                          MKey.keyReleasedN_T(VF_R.getJTFS()[a], evt);
                                    }
                              }
                        }
                  }
            }
      }

}
