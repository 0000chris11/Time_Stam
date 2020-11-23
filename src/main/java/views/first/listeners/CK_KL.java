package views.first.listeners;

import views.first.VF_R;
import MC.DT;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * KeyListener for the Clock
 *
 * @author Christopher
 */
public class CK_KL implements KeyListener {

      @Override
      public void keyTyped(KeyEvent arg0) {
      }

      @Override
      public void keyPressed(KeyEvent evt) {
            //System.out.println("keyPressed");
            if (KeyEvent.VK_RIGHT == evt.getKeyCode()) {
                  if (evt.isControlDown()) {
                        //System.out.println("\tCTRL + RIGHT");
                        changeFocusRight();
                  }
            } else if (KeyEvent.VK_LEFT == evt.getKeyCode()) {
                  if (evt.isControlDown()) {
                        //System.out.println("\tCTRL + LEFT");
                        changeFocusLeft();
                  }
            } else if (KeyEvent.VK_UP == evt.getKeyCode()) {
                  changeFocusUp();
            } else if (KeyEvent.VK_DOWN == evt.getKeyCode()) {
                  changeFocusDown();
            }
      }

      @Override
      public void keyReleased(KeyEvent evt) {
            //System.out.println("keyReleased");
            if (!evt.isControlDown()) {
                  if (KeyEvent.VK_DOWN == evt.getKeyCode()
                          || KeyEvent.VK_UP == evt.getKeyCode()) {
                        //CHANGE INDEX (UP or DOWN)
                        JTextField jtfC = (JTextField) evt.getSource();
                        int value = Integer.parseInt(jtfC.getText());
                        for (int a = 0; a < DT.maxColumns; a++) {
                              //MATCH BASED ON LOCATION
                              if (jtfC.getLocation().equals(VF_R.getTFS_MD()[a].getLocation())) {
                                    setIndexMD(evt, a, value);
                              } else if (jtfC.getLocation().equals(VF_R.getTFS_MU()[a].getLocation())) {
                                    setIndexMU(evt, a, value);
                              } else if (jtfC.getLocation().equals(VF_R.getTFS_SD()[a].getLocation())) {
                                    setIndexSD(evt, a, value);
                              } else if (jtfC.getLocation().equals(VF_R.getTFS_SU()[a].getLocation())) {
                                    setIndexSU(evt, a, value);
                              }
                        }
                  }
            } else if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
                  //SET CLOCK TEXT TO TF
                  for (int a = 0; a < DT.maxColumns; a++) {
                        String timeValue = "E";//ERROR (DOESN'T CHANGE)
                        if (VF_R.getTFS_MD()[a].isVisible()) {
                              timeValue = VF_R.getTFS_MD()[a].getText()
                                      + VF_R.getTFS_MU()[a].getText() + ":"
                                      + VF_R.getTFS_SD()[a].getText()
                                      + VF_R.getTFS_SU()[a].getText();
                              //+++++++++++++++++++++++++++++++++++++++++
                              //IF TF ALLOWES TAGS
                              if (VF_R.getJTFS()[a].getText().contains("; ")) {
                                    timeValue = VF_R.getJTFS()[a].getText().substring(0,
                                            VF_R.getJTFS()[a].getText().lastIndexOf("; ") + 2)
                                            + timeValue;
                              }

                              VF_R.getJTFS()[a].setText(timeValue);
                        }
                  }
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++
      private void setIndexMD(KeyEvent evt, int a, int V) {
            //RESET LOOP NOT IMPLEMENTED
            if (KeyEvent.VK_DOWN == evt.getKeyCode()) {
                  if (V < 5) {//ONLY IT'LL COUNT UP IF IS 4 MAX
                        VF_R.getTFS_MD()[a].setText(Integer.toString(++V));
                  }
            } else if (KeyEvent.VK_UP == evt.getKeyCode()) {
                  if (V > 0) {
                        VF_R.getTFS_MD()[a].setText(Integer.toString(--V));
                  }
            }
      }

      private void setIndexMU(KeyEvent evt, int a, int V) {
            if (KeyEvent.VK_DOWN == evt.getKeyCode()) {
                  if (V < 9) {
                        VF_R.getTFS_MU()[a].setText(Integer.toString(++V));
                  }
            } else if (KeyEvent.VK_UP == evt.getKeyCode()) {
                  if (V > 0) {
                        VF_R.getTFS_MU()[a].setText(Integer.toString(--V));
                  }
            }
      }

      private void setIndexSD(KeyEvent evt, int a, int V) {
            if (KeyEvent.VK_DOWN == evt.getKeyCode()) {
                  if (V < 5) {
                        VF_R.getTFS_SD()[a].setText(Integer.toString(++V));
                  }
            } else if (KeyEvent.VK_UP == evt.getKeyCode()) {
                  if (V > 0) {
                        VF_R.getTFS_SD()[a].setText(Integer.toString(--V));
                  }
            }
      }

      private void setIndexSU(KeyEvent evt, int a, int V) {
            if (KeyEvent.VK_DOWN == evt.getKeyCode()) {
                  if (V < 9) {
                        VF_R.getTFS_SU()[a].setText(Integer.toString(++V));
                  }
            } else if (KeyEvent.VK_UP == evt.getKeyCode()) {
                  if (V > 0) {
                        VF_R.getTFS_SU()[a].setText(Integer.toString(--V));
                  }
            }
      }

      //+++++++++++++++++++++++++++++++++++++++++++++
      private void changeFocusRight() {
            //System.out.println("\tChange Focus Right");
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (VF_R.getTFS_MD()[a].hasFocus()) {
                        VF_R.getTFS_MU()[a].requestFocus();

                  } else if (VF_R.getTFS_MU()[a].hasFocus()) {
                        VF_R.getTFS_SD()[a].requestFocus();

                  } else if (VF_R.getTFS_SD()[a].hasFocus()) {
                        VF_R.getTFS_SU()[a].requestFocus();

                  } else if (VF_R.getTFS_SU()[a].hasFocus()) {
                        VF_R.getJTFS()[a].requestFocus();
                  }
            }
      }

      private void changeFocusLeft() {
            //System.out.println("\nChange Focus Right");
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (VF_R.getTFS_MD()[a].hasFocus()) {
                        VF_R.getJTFS()[a].requestFocus();

                  } else if (VF_R.getTFS_MU()[a].hasFocus()) {
                        VF_R.getTFS_MD()[a].requestFocus();

                  } else if (VF_R.getTFS_SD()[a].hasFocus()) {
                        VF_R.getTFS_MU()[a].requestFocus();

                  } else if (VF_R.getTFS_SU()[a].hasFocus()) {
                        VF_R.getTFS_SD()[a].requestFocus();
                  }
            }
      }

      private void changeFocusUp() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (VF_R.getTFS_MD()[a].hasFocus() || VF_R.getTFS_MU()[a].hasFocus()
                          || VF_R.getTFS_SD()[a].hasFocus() || VF_R.getTFS_SU()[a].hasFocus()) {
                        if (a == 0) {
                              VF_R.getJTFS()[DT.maxColumns - 1].requestFocus();
                        } else {
                              VF_R.getJTFS()[a - 1].requestFocus();
                        }
                  }
            }
      }

      private void changeFocusDown() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (VF_R.getTFS_MD()[a].hasFocus() || VF_R.getTFS_MU()[a].hasFocus()
                          || VF_R.getTFS_SD()[a].hasFocus() || VF_R.getTFS_SU()[a].hasFocus()) {
                        if (a == DT.maxColumns - 1) {
                              VF_R.getJTFS()[0].requestFocus();
                        } else {
                              VF_R.getJTFS()[a + 1].requestFocus();
                        }
                  }
            }
      }
}
