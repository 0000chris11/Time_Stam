package Second;

import First.VF_R;
import Listeners.MainListeners_C;
import MC.DT;
import Others.CC;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import smallComponenets.smallBTN_C;
import smallComponenets.smallLB;
import smallComponenets.smallTF;

/**
 *
 * @author Christopher
 */
public class VC_R extends VC_R_DataCom {

      MainListeners_C ml = new MainListeners_C();

      private void frameConfig() {
            VF_R.getJF().setAlwaysOnTop(false);

            JF.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            JF.setLayout(null);
            JF.setLocation(VF_R.getJF().getX() + 100, VF_R.getJF().getY() + 60);

            JF.add(JP);
            JP.setLayout(null);
            JP.setBounds(2, 2, 600, 500);

            JF.setSize(JP.getWidth() + 20, JP.getHeight() + 44);
            JF.setVisible(true);
            /*
            JF.setAlwaysOnTop(true);
            new Thread() {
                  public void run() {
                        do {
                              try {
                                    Thread.sleep(500);
                              } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                              }
                              if (VC_R.this.JF.isShowing()) {
                                    System.out.println(CC.PURPLE + "VC_R False" + CC.RESET);
                                    JF.setAlwaysOnTop(false);
                              }
                        } while (!VC_R.this.JF.isShowing());
                  }
            }.start();
             */
      }

      private void componentsConfig() {
            //JLabel lb = new JLabel();
            //lb.setSize(VF_R.getJLBS()[0].getWidth(), VF_R.getJLBS()[0].getHeight());
            //lb.setForeground(Color.WHITE);
            //lb.setFont(VF_R.getJLBS()[0].getFont());
            //+++++++++++++
            int lby = 24;
            for (int a = 0; a < DT.maxColumns; a++) {
                  lbs[a] = new smallLB();
                  JP.add(lbs[a]);

                  if (a == 0) {
                        lbs[a].setText("Table");
                        lbs[a].setBounds(6, 12, 100, 27);
                  } else {
                        lbs[a].setBounds(6, lby, 100, 27);
                        lbs[a].setText("Column " + (a + 1));
                  }
                  tfs[a] = new smallTF();
                  JP.add(tfs[a]);

                  if (a >= 1) {
                        tfs[a].setBounds(108, lby, 200, 27);

                        btns_m[a] = new smallBTN_C("-");
                        JP.add(btns_m[a]);
                        btns_m[a].setBounds(314, lby, 22, 27);

                        btns_p[a] = new smallBTN_C("+");
                        JP.add(btns_p[a]);
                        btns_p[a].setBounds(336, lby, 22, 27);
                  } else {
                        tfs[a].setBounds(108, 12, 200, 27);
                  }
                  //++++++++++++++
                  lby += 33;
            }
            JP.add(SP1);
            SP1.setBounds(4, tfs[1].getY() - 10, JP.getWidth() - 10, 1);
            SP1.setForeground(Color.LIGHT_GRAY);
      }

      private void componentsConfig2() {
            for (int a = 0; a < DT.maxColumns - 2; a++) {
                  lbs[a + 2].setVisible(false);
                  tfs[a + 2].setVisible(false);
                  btns_m[a + 2].setVisible(false);
                  btns_p[a + 2].setVisible(false);
            }
            btns_m[1].setEnabled(false);
            btns_p[DT.maxColumns - 1].setEnabled(false);
      }

      private void setNameToComponents() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (a == 0) {
                        lbs[a].setName("LB_Title");
                        tfs[a].setName("TF_Title");
                  } else {
                        lbs[a].setName("LB_" + (a + 1));
                        tfs[a].setName("TF_" + (a + 1));
                        btns_p[a].setName("BNT_P" + (a + 1));
                        btns_m[a].setName("BNT_M" + (a + 1));
                  }
            }
      }

      public VC_R() {
            frameConfig();
            componentsConfig();
            componentsConfig2();

            setNameToComponents();

            ml.addAllListeners();

      }
}
