package Listeners_F;

import First.VF;
import cofii.MKey;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Christopher
 */
public class LSTSKeyReleased implements KeyListener {

      String CName = this.getClass().getName();
      
      //MethodM mm = new MethodM(CName, DT.CCount++);

      @Override
      public void keyTyped(KeyEvent evt) {

      }

      @Override
      public void keyPressed(KeyEvent evt) {

      }

      @Override
      public void keyReleased(KeyEvent evt) {
            System.out.println("\nKeyReleased");

            for (int a = 0; a < 5; a++) {
                  if (a == 0) {
                        if (VF.getJLSTS()[a].isVisible() && 
                                VF.getJLSTS()[a].hasFocus()) {
                              
                              System.out.println("\tLST_" + (a + 2));
                              MKey.lst_ConfigDists_K(VF.getJLSTS()[a].getModel(),
                                      VF.getJLSTS()[a],
                                      null, VF.getJTFS()[a + 1],
                                      VF.getJLBS()[a + 1], evt);
                              //mm.lst_ConfigDists_K(dt.getDm_2(), lst_2, null, tf_2, lb_2, evt);
                              //mm.lst_ConfigDists_K(dt.getDm_3(), lst_3, tf_2, tf_3, lb_3, evt);
                              //mm.lst_ConfigDists_K(dt.getDm_4(), lst_4, tf_3, tf_4, lb_4, evt);
                              //mm.lst_ConfigDists_K(dt.getDm_5(), lst_5, tf_4, tf_5, lb_5, evt);
                              //mm.lst_ConfigDists_K(dt.getDm_6(), lst_6, tf_5, tf_6, lb_6, evt);
                        } else {
                              if (VF.getJLSTS()[a].isVisible() && 
                                VF.getJLSTS()[a].hasFocus()) {
                                    
                                    System.out.println("\tLST_" + (a + 2));
                                    MKey.lst_ConfigDists_K(VF.getJLSTS()[a].getModel(),
                                            VF.getJLSTS()[a],
                                            VF.getJTFS()[a], VF.getJTFS()[a + 1],
                                            VF.getJLBS()[a + 1], evt);
                              }
                        }
                  }
            }
      }

}
