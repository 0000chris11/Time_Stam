package Listeners;

import First.VF_R;
import MC.DT;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Christopher
 */
public class CK_KL implements KeyListener {

      //private String Op = "E";

      /*public CK_KL(String op) {
            if (op.equals("U") || op.equals("D")) {
                  Op = op;
            }
      }*/
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
                        JTextField jtfC = (JTextField) evt.getSource();
                        int V = Integer.parseInt(jtfC.getText());
                        //System.out.println("\tJTFC Location: " + jtfC.getLocation());
                        for (int a = 0; a < 5; a++) {
                              //System.out.println("\tMD Location: " + VF_R.getTFS_MD()[a].getLocation());
                              if (jtfC.getLocation().equals(VF_R.getTFS_MD()[a].getLocation())) {
                                    setIndexMD(evt, a, V);
                              } else if (jtfC.getLocation().equals(VF_R.getTFS_MU()[a].getLocation())) {
                                    setIndexMU(evt, a, V);
                              } else if (jtfC.getLocation().equals(VF_R.getTFS_SD()[a].getLocation())) {
                                    setIndexSD(evt, a, V);
                              } else if (jtfC.getLocation().equals(VF_R.getTFS_SU()[a].getLocation())) {
                                    setIndexSU(evt, a, V);
                              }
                        }
                  }
            } else if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
                  //System.out.println("\nENTER");
                  for (int a = 0; a < 5; a++) {
                        String time = "E";
                        if (VF_R.getTFS_MD()[a].isVisible()) {
                              time = VF_R.getTFS_MD()[a].getText()
                                      + VF_R.getTFS_MU()[a].getText() + ":"
                                      + VF_R.getTFS_SD()[a].getText()
                                      + VF_R.getTFS_SU()[a].getText();
                              //+++++++++++++++++++++++++++++++++++++++++
                              //System.out.println("\tText: " + VF_R.getJTFS()[a + 1].getText());
                              if (VF_R.getJTFS()[a + 1].getText().contains("; ")) {
                                    //System.out.println("\tcontains > ; <");
                                    time = VF_R.getJTFS()[a + 1].getText().substring(0,
                                            VF_R.getJTFS()[a + 1].getText().lastIndexOf("; ") + 2)
                                            + time;
                              } else {
                                    //System.out.println("\tnormal");
                              }
                              VF_R.getJTFS()[a + 1].setText(time);
                        }
                  }
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++
      private void setIndexMD(KeyEvent evt, int a, int V) {
            if (KeyEvent.VK_DOWN == evt.getKeyCode()) {
                  if (V < 5) {
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
            for (int a = 0; a < 5; a++) {
                  if (VF_R.getTFS_MD()[a].hasFocus()) {
                        VF_R.getTFS_MU()[a].requestFocus();

                  } else if (VF_R.getTFS_MU()[a].hasFocus()) {
                        VF_R.getTFS_SD()[a].requestFocus();

                  } else if (VF_R.getTFS_SD()[a].hasFocus()) {
                        VF_R.getTFS_SU()[a].requestFocus();

                  } else if (VF_R.getTFS_SU()[a].hasFocus()) {
                        VF_R.getJTFS()[a + 1].requestFocus();
                  }
            }
      }

      private void changeFocusLeft() {
            //System.out.println("\nChange Focus Right");
            for (int a = 0; a < 5; a++) {
                  if (VF_R.getTFS_MD()[a].hasFocus()) {
                        VF_R.getJTFS()[a + 1].requestFocus();

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
            for (int a = 0; a < VF_R.getTFS_MD().length; a++) {
                  if (VF_R.getTFS_MD()[a].hasFocus() || VF_R.getTFS_MU()[a].hasFocus()
                          || VF_R.getTFS_SD()[a].hasFocus() || VF_R.getTFS_SU()[a].hasFocus()) {
                        VF_R.getJTFS()[a].requestFocus();
                  }
            }
      }

      private void changeFocusDown() {
            for (int a = 0; a < VF_R.getTFS_MD().length; a++) {
                  if (VF_R.getTFS_MD()[a].hasFocus() || VF_R.getTFS_MU()[a].hasFocus()
                          || VF_R.getTFS_SD()[a].hasFocus() || VF_R.getTFS_SU()[a].hasFocus()) {
                        if (DT.maxColumns != (a + 2)) {
                              VF_R.getJTFS()[a + 2].requestFocus();
                        }
                  }
            }
      }
}
