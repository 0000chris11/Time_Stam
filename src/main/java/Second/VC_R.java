package Second;

import First.VF_R;
import Listeners.MainListeners_C;
import MC.DT;
import Others.CC;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import smallComponenets.smallBTN_C;
import smallComponenets.smallBTN_TG;
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
            JP.setBounds(2, 2, 800, 500);

            JF.setSize(JP.getWidth() + 20, JP.getHeight() + 44);
            JF.setVisible(true);
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
            JP.add(SP_H1);
            SP_H1.setBounds(4, tfs[1].getY() - 10, JP.getWidth() - 10, 1);
            SP_H1.setForeground(Color.LIGHT_GRAY);

            JP.add(SP_V1);
            SP_V1.setOrientation(SwingConstants.VERTICAL);
            SP_V1.setBounds(btns_p[1].getX() + btns_p[1].getWidth() + 6,
                    4, 1, JP.getHeight() - 10);
            SP_V1.setForeground(Color.LIGHT_GRAY);
            //++++++++++++++++++++++++++++++
            int y = 10;
            int w = 80;
            int h = 27;
            JP.add(lb_Dist);
            lb_Dist.setBounds(SP_V1.getX() + 12, y, w, h);

            JP.add(lb_Dist2);
            lb_Dist2.setBounds(lb_Dist.getX() + 80, y, w, h);

            JP.add(lb_Tabl);
            lb_Tabl.setBounds(lb_Dist2.getX() + 80, y, w, h);

            JP.add(lb_Tag);
            lb_Tag.setBounds(lb_Tabl.getX() + 80, y, w, h);

            JP.add(lb_Clock);
            lb_Clock.setBounds(lb_Tag.getX() + 80, y, w, h);

            int xs = SP_V1.getX() + 80;
            for (int a = 0; a < SP_VS.length; a++) {
                  SP_VS[a] = new JSeparator();

                  JP.add(SP_VS[a]);
                  SP_VS[a].setOrientation(SwingConstants.VERTICAL);
                  SP_VS[a].setBounds(xs, y, 1, JP.getHeight() - 10);
                  SP_VS[a].setForeground(Color.LIGHT_GRAY);
                  xs += 80;
            }
            //+++++++++++++++++
            BTNS_DistsConfig();
      }

      private void BTNS_DistsConfig() {
            int w = 54;
            int h = 27;

            int gB = smallBTN_TG.blueWhite;
            int gC = smallBTN_TG.cyanWhite;
            int gG = smallBTN_TG.greenWhite;
            int gY = smallBTN_TG.yellowWhite;

            for (int a = 0; a < DT.maxColumns - 1; a++) {
                  btns_Dist[a] = new smallBTN_TG(w, h, gB);
                  btns_Dist2[a] = new smallBTN_TG(w, h, gB);
                  btns_Tabl[a] = new smallBTN_TG(w, h, gC);
                  btns_Tag[a] = new smallBTN_TG(w, h, gG);
                  btns_Clock[a] = new smallBTN_TG(w, h, gY);

                  JP.add(btns_Dist[a]);
                  btns_Dist[a].setBounds(lb_Dist.getX(), lbs[a + 1].getY(), w, h);

                  JP.add(btns_Dist2[a]);
                  btns_Dist2[a].setBounds(lb_Dist2.getX(), lbs[a + 1].getY(), w, h);

                  JP.add(btns_Tabl[a]);
                  btns_Tabl[a].setBounds(lb_Tabl.getX(), lbs[a + 1].getY(), w, h);

                  JP.add(btns_Tag[a]);
                  btns_Tag[a].setBounds(lb_Tag.getX(), lbs[a + 1].getY(), w, h);

                  JP.add(btns_Clock[a]);
                  btns_Clock[a].setBounds(lb_Clock.getX(), lbs[a + 1].getY(), w, h);
            }
            BTNS_DistsConfig2();
      }

      private void BTNS_DistsConfig2() {
            System.out.println("btns_Dist.length: " + btns_Dist.length);
            System.out.println("btns_Dist2.length: " + btns_Dist2.length);
            System.out.println("btns_Tabl.length: " + btns_Tabl.length);
            System.out.println("btns_Tag.length: " + btns_Tag.length);
            System.out.println("btns_Clock.length: " + btns_Clock.length);
            for (int a = 0; a < DT.maxColumns - 2; a++) {
                  System.out.println(btns_Dist[a]);
                  btns_Dist[a + 1].setVisible(false);
                  btns_Dist2[a + 1].setVisible(false);
                  btns_Tabl[a + 1].setVisible(false);
                  btns_Tag[a + 1].setVisible(false);
                  btns_Clock[a + 1].setVisible(false);
            }
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
            lb_Dist.setName("lb_Dist");
            lb_Dist2.setName("lb_Dist2");
            lb_Tabl.setName("lb_Tabl");
            lb_Tag.setName("lb_Tag");
            lb_Clock.setName("lb_Clock");
            for (int a = 0; a < DT.maxColumns - 1; a++) {
                  btns_Dist[a].setName("btn_Dist_" + (a + 2));
                  btns_Dist2[a].setName("btn_Dist2_" + (a + 2));
                  btns_Tabl[a].setName("btn_Tabl_" + (a + 2));
                  btns_Tag[a].setName("btn_Tag_" + (a + 2));
                  btns_Clock[a].setName("btn_Clock_" + (a + 2));
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
