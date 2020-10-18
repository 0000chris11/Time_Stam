package Create;

import Create.VC_R_DataCom;
import First.VF_R;
import Create.Listeners.MainListeners_C;
import MC.DT;
import Others.CC;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
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
            JP.setBounds(2, 2, 800, 500 - VF_R.getP3().getHeight() - 2);

            JF.add(JP2);
            JP2.setLayout(null);
            JP2.setBackground(Color.BLACK);
            JP2.setBounds(2, JP.getHeight() + 6, JP.getWidth(), VF_R.getP3().getHeight());

            JP2.add(lb_Status);
            Border bb = BorderFactory.createBevelBorder(BevelBorder.RAISED);
            Border be = BorderFactory.createEmptyBorder(1, 3, 1, 3);
            lb_Status.setBorder(new CompoundBorder(bb, be));

            lb_Status.setForeground(Color.WHITE);
            lb_Status.setFont(VF_R.getLB_Status().getFont());
            lb_Status.setBounds(VF_R.getLB_Status().getX(), VF_R.getLB_Status().getY(),
                    JP2.getWidth() - 100, VF_R.getLB_Status().getHeight());
            
            JP2.add(btn_Create);
            btn_Create.setMargin(new Insets(3, 1, 3, 1));
            btn_Create.setBounds(JP2.getWidth() - 90, lb_Status.getY(),
                    84, lb_Status.getHeight());

            JF.setSize(JP.getWidth() + 20, JP.getHeight() + JP2.getHeight() + 48);
            JF.setVisible(true);
      }

      //+++++++++++++++++++++++++++++++++++++++++++
      private void LBS_TFSConfig() {
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
                        //BUT TITLE / MAIN
                        tfs[a].setBounds(108, lby, 200, 27);
                  } else {
                        tfs[a].setBounds(108, 12, 200, 27);
                        tfs[a].setBackground(new Color(102,0,0));
                        //System.out.println(CC.PURPLE + "A: " + a + CC.RESET);
                  }
                  //++++++++++++++
                  lby += 33;
            }
      }

      private void BTNS_PMConfig() {
            int lby = tfs[1].getY();
            for (int a = 0; a < DT.maxColumns - 1; a++) {
                  //System.out.println(CC.PURPLE + "A: " + a + CC.RESET);
                  btns_m[a] = new smallBTN_C("-");
                  JP.add(btns_m[a]);
                  btns_m[a].setBounds(314, lby, 22, 27);

                  btns_p[a] = new smallBTN_C("+");
                  JP.add(btns_p[a]);
                  btns_p[a].setBounds(336, lby, 22, 27);

                  lby += 33;
            }
      }

      private void LBS_TFS_BTNS_PM_STARS() {
            //System.out.println(CC.YELLOW + "componentsConfig2" + CC.RESET);
            //System.out.println("lbs length: " + lbs.length);
            //System.out.println("tfs length: " + tfs.length);
            //System.out.println("btns_p length: " + btns_p.length);
            //System.out.println("btns_m length: " + btns_m.length);
            for (int a = 0; a < DT.maxColumns - 2; a++) {
                  lbs[a + 2].setVisible(false);//3 COL +
                  tfs[a + 2].setVisible(false);//3 COL +

                  btns_m[a + 1].setVisible(false);
                  btns_p[a + 1].setVisible(false);
            }
            btns_m[0].setEnabled(false);
            btns_p[DT.maxColumns - 2].setEnabled(false);
      }

      private void LBDist_SPConfig() {
            JP.add(SP_H1);
            SP_H1.setBounds(4, tfs[1].getY() - 10, JP.getWidth() - 10, 1);
            SP_H1.setForeground(Color.LIGHT_GRAY);

            JP.add(SP_V1);
            SP_V1.setOrientation(SwingConstants.VERTICAL);
            SP_V1.setBounds(btns_p[0].getX() + btns_p[0].getWidth() + 6,
                    4, 1, JP.getHeight() - 10);
            SP_V1.setForeground(Color.LIGHT_GRAY);

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
                  btns_Dist2[a].setEnabled(false);

                  JP.add(btns_Tabl[a]);
                  btns_Tabl[a].setBounds(lb_Tabl.getX(), lbs[a + 1].getY(), w, h);

                  JP.add(btns_Tag[a]);
                  btns_Tag[a].setBounds(lb_Tag.getX(), lbs[a + 1].getY(), w, h);

                  JP.add(btns_Clock[a]);
                  btns_Clock[a].setBounds(lb_Clock.getX(), lbs[a + 1].getY(), w, h);
            }
            BTNS_DistsSTARS();
      }

      private void BTNS_DistsSTARS() {
            //System.out.println("btns_Dist.length: " + btns_Dist.length);
            //System.out.println("btns_Dist2.length: " + btns_Dist2.length);
            //System.out.println("btns_Tabl.length: " + btns_Tabl.length);
            //System.out.println("btns_Tag.length: " + btns_Tag.length);
            //System.out.println("btns_Clock.length: " + btns_Clock.length);
            for (int a = 0; a < DT.maxColumns - 2; a++) {
                  //System.out.println(btns_Dist[a]);
                  btns_Dist[a + 1].setVisible(false);
                  btns_Dist2[a + 1].setVisible(false);
                  btns_Tabl[a + 1].setVisible(false);
                  btns_Tag[a + 1].setVisible(false);
                  btns_Clock[a + 1].setVisible(false);
            }
      }

      private void setRowArray() {
            for (int a = 0; a < row.length; a++) {
                  row[a][0] = lbs[a + 1];
                  row[a][1] = tfs[a + 1];
                  row[a][2] = btns_m[a];
                  row[a][3] = btns_p[a];
                  row[a][4] = btns_Dist[a];
                  row[a][5] = btns_Dist2[a];
                  row[a][6] = btns_Tabl[a];
                  row[a][7] = btns_Tag[a];
                  row[a][8] = btns_Clock[a];
            }
      }

      //+++++++++++++++++++++++++++++++++++++++++++
      private void setNameToComponents() {
            //System.out.println("setNameToComponents");
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (a == 0) {
                        lbs[a].setName("LB_Title");
                        tfs[a].setName("TF_Title");
                  } else {
                        //System.out.println("a");
                        lbs[a].setName("LB_" + (a + 1));
                        tfs[a].setName("TF_" + (a + 1));
                        btns_p[a - 1].setName("BNT_P" + (a + 1));
                        btns_m[a - 1].setName("BNT_M" + (a + 1));
                  }
            }
            lb_Dist.setName("lb_Dist");
            lb_Dist2.setName("lb_Dist2");
            lb_Tabl.setName("lb_Tabl");
            lb_Tag.setName("lb_Tag");
            lb_Clock.setName("lb_Clock");
            for (int a = 0; a < DT.maxColumns - 1; a++) {
                  //System.out.println("a: " + a);
                  btns_Dist[a].setName("btn_Dist_" + (a + 2));
                  btns_Dist2[a].setName("btn_Dist2_" + (a + 2));
                  btns_Tabl[a].setName("btn_Tabl_" + (a + 2));
                  btns_Tag[a].setName("btn_Tag_" + (a + 2));
                  btns_Clock[a].setName("btn_Clock_" + (a + 2));
            }
      }

      public VC_R() {
            System.out.println(CC.CYAN + "CLASS ### VC" + CC.RESET);
            frameConfig();

            System.out.println(CC.CYAN + "VC +++++ LBS_TFConfig" + CC.RESET);
            LBS_TFSConfig();

            System.out.println(CC.CYAN + "VC +++++ BTNS_PMConfig" + CC.RESET);
            BTNS_PMConfig();

            System.out.println(CC.CYAN + "VC +++++ LBS_TFS_BTNS_PM_STARS" + CC.RESET);
            LBS_TFS_BTNS_PM_STARS();

            System.out.println(CC.CYAN + "VC +++++ LBDist_SPConfig" + CC.RESET);
            LBDist_SPConfig();

            System.out.println(CC.CYAN + "VC +++++ BTNS_DistsConfig" + CC.RESET);
            BTNS_DistsConfig();
            
            System.out.println(CC.CYAN + "VC +++++ setRowArray" + CC.RESET);
            setRowArray();

            System.out.println(CC.CYAN + "VC +++++ setNameToComponents" + CC.RESET);
            setNameToComponents();

            System.out.println(CC.CYAN + "VC +++++ addAllListeners" + CC.RESET);
            ml.addAllListeners();

            System.out.println(CC.CYAN + "VC ### ENDS" + CC.RESET);
      }
}
