package views.first.listeners;

import views.first.VF_R;
import com.cofii2.methods.MComp;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 * KeyListener for the Clock (CUSTOM BC I NEED TO ASK EVERY TIME WICH COMPONENT
 * IS ON JTFPANEL)
 *
 * @author C0FII
 */
public class CK_KL_Custom implements KeyListener {

      private JTextField[] Clock;

      public CK_KL_Custom(JTextField[] clock) {
            Clock = clock;
      }

      @Override
      public void keyTyped(KeyEvent arg0) {
      }

      @Override
      public void keyPressed(KeyEvent evt) {
            //System.out.println("keyPressed");
            int index = MComp.getLastDigitCharsCountAtEnd(Clock[0].getName());
            if (KeyEvent.VK_RIGHT == evt.getKeyCode() || KeyEvent.VK_LEFT == evt.getKeyCode()) {
                  if (evt.isControlDown()) {
                        JComponent[] JC = VF_R.getIndexComponent();
                        for (int a = 0; a < 4; a++) {
                              if (evt.getComponent().getName().equals(Clock[a].getName())) {
                                    if (KeyEvent.VK_RIGHT == evt.getKeyCode()) {
                                          if (a != 3) {//IF ITS NOT THE LAST ONE
                                                Clock[a + 1].requestFocus();
                                          } else {
                                                JC[index - 1].requestFocus();
                                          }
                                    } else if (KeyEvent.VK_LEFT == evt.getKeyCode()) {
                                          if (a != 0) {//IF ITS NOT THE FIRST ONE
                                                Clock[a - 1].requestFocus();
                                          } else {
                                                JC[index - 1].requestFocus();
                                          }
                                    }
                              }
                        }
                  }
            }
      }

      @Override
      public void keyReleased(KeyEvent e) {
            System.out.println("keyReleased");
            changeIndex(e);
            enterConfig(e);
      }

      private void enterConfig(KeyEvent e){
            if (KeyEvent.VK_ENTER == e.getKeyCode()) {
                  System.out.println("\tENTER");
                  int index = MComp.getLastDigitCharsCountAtEnd(Clock[0].getName());
                  String newText = Clock[0].getText() + Clock[1].getText() + ":" + Clock[2].getText() + Clock[3].getText();
                  JTextField tf = (JTextField) VF_R.getJTFPanel()[index - 1].getComponent(0);
                  
                  if (VF_R.getJLBS()[index - 1].getText().contains("*") && !tf.getText().isEmpty()) {
                        tf.setText(tf.getText() + "; " + newText);
                  } else {
                        tf.setText(newText);
                  }
            }
      }
      
      private void changeIndex(KeyEvent e) {
            if (!e.isControlDown()) {
                  if (KeyEvent.VK_DOWN == e.getKeyCode()
                          || KeyEvent.VK_UP == e.getKeyCode()) {
                        //CHANGE INDEX (UP or DOWN)
                        JTextField jtfC = (JTextField) e.getSource();
                        int value = Integer.parseInt(jtfC.getText());
                        //MATCH BASED ON LOCATION

                        if (e.getComponent() == Clock[0]) {
                              setIndexMD(e, value);
                        } else if (e.getComponent() == Clock[1]) {
                              setIndexMU(e, value);
                        } else if (e.getComponent() == Clock[2]) {
                              setIndexSD(e, value);
                        } else if (e.getComponent() == Clock[3]) {
                              setIndexSU(e, value);
                        }

                  }
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++   
      private void setIndexMD(KeyEvent e, int text) {
            if (KeyEvent.VK_DOWN == e.getKeyCode()) {
                  if (text < 5) {//ONLY IT'LL COUNT UP IF IS 4 MAX
                        Clock[0].setText(Integer.toString(++text));
                  }
            } else if (KeyEvent.VK_UP == e.getKeyCode()) {
                  if (text > 0) {
                        Clock[0].setText(Integer.toString(--text));
                  }
            }
      }

      private void setIndexMU(KeyEvent evt, int text) {
            if (KeyEvent.VK_DOWN == evt.getKeyCode()) {
                  if (text < 9) {
                        Clock[1].setText(Integer.toString(++text));
                  }
            } else if (KeyEvent.VK_UP == evt.getKeyCode()) {
                  if (text > 0) {
                        Clock[1].setText(Integer.toString(--text));
                  }
            }
      }

      private void setIndexSD(KeyEvent evt, int text) {
            if (KeyEvent.VK_DOWN == evt.getKeyCode()) {
                  if (text < 5) {
                        Clock[2].setText(Integer.toString(++text));
                  }
            } else if (KeyEvent.VK_UP == evt.getKeyCode()) {
                  if (text > 0) {
                        Clock[2].setText(Integer.toString(--text));
                  }
            }
      }

      private void setIndexSU(KeyEvent evt, int text) {
            if (KeyEvent.VK_DOWN == evt.getKeyCode()) {
                  if (text < 9) {
                        Clock[3].setText(Integer.toString(++text));
                  }
            } else if (KeyEvent.VK_UP == evt.getKeyCode()) {
                  if (text > 0) {
                        Clock[3].setText(Integer.toString(--text));
                  }
            }
      }
}
