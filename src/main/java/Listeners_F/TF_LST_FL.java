package Listeners_F;

import First.VF;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import First.VF_R;
import MC.DT;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.BorderUIResource;

/**
 *
 * @author Christopher
 */
public class TF_LST_FL implements FocusListener {

      //Data dt = new Data("TF_LST_FL");
      //Border[] brs = new LineBorder[]{new LineBorder(Color.WHITE)};

      //Graphics g2;
      //private static JComponent cS = null;

      @Override
      public void focusGained(FocusEvent evt) {
            //System.out.println("\nFocusGained");
            int b = 4;
            for (int a = 0; a < 5; a++) {
                  if (VF_R.getJTFS()[a + 1].hasFocus()) {
                        if (VF_R.getJTFS()[a + 1].getBackground().equals(DT.TFColor[1])
                                || VF_R.getJTFS()[a + 1].getBackground().equals(DT.TFColor[2])) {
                              focusGainedFor(b);
                        }
                  }
                  b--;
                  //0 = 4
                  //1 = 3
                  //2 = 2
                  //4 = 1
                  //5 = 0
            }
      }

      @Override
      public void focusLost(FocusEvent evt) {
            //System.out.println("\nFocusLost");
            String JC = ((JComponent) evt.getSource()).getName();
            int b = 4;
            for (int a = 0; a < 5; a++) {
                  if (JC.equals("TF_" + (a + 2))) {
                        //VF_R.getJTFS()[a + 1].setBorder(brs[0]);
                        //SwingUtilities.updateComponentTreeUI(VF_R.getJTFS()[a + 1]);
                  }
                  //System.out.println("\tSource name" + JC);
                  if ((JC.equals("TF_" + (a + 2))
                          && (VF_R.getJTFS()[a + 1].getBackground().equals(DT.TFColor[1])
                          || VF_R.getJTFS()[a + 1].getBackground().equals(DT.TFColor[2])))
                          || JC.equals("LST_" + (a + 2))) {

                        //System.out.println("\tTF_" + (a + 2) + " or LST_" + (a + 2));
                        focusLostFor(a, b);
                  }
                  b--;
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++
      private void focusGainedFor(int forSize) {
            VF_R.getLB_Icon().setVisible(false);

            int r = getNumToSum(forSize);
            if (forSize != 0) {
                  int b = 209;
                  //System.out.println("r value: " + r);
                  for (int a = 0; a < forSize; a++) {// 3 or 4
                        // +2 or +3
                        VF_R.getJLBS()[a + r].setLocation(6, VF_R.getJLBS()[r - 1].getY() + b);
                        //1,1,0 or 2,2,1
                        VF_R.getJTFS()[a + r].setLocation(107, VF_R.getJTFS()[r - 1].getY() + b);

                        VF_R.getBTNS_C()[a + (r - 1)].setLocation(402, VF_R.getBTNS_C()[r - 2].getY() + b);

                        b += 33;
                  }
                  //+++++++++++++++++++++++++++++++
                  ClockFocusGained(forSize, r);
            }
            //00 or 11
            VF_R.getJSCS()[r - 2].setLocation(107, VF_R.getJTFS()[r - 1].getY() + 33);
            VF_R.getJSCS()[r - 2].setVisible(true);
      }

      private void focusLostFor(int lst_sc, int forSize) {
            if (VF_R.getJLSTS()[lst_sc].getValueIsAdjusting() == true) {// = 0
            } else {
                  if (!DT.getTabl().equals("NONE")) {
                        VF_R.getLB_Icon().setVisible(true);
                  }

                  VF_R.getJSCS()[lst_sc].setVisible(false);
                  if (forSize != 0) {
                        int b = 33;
                        int r = getNumToSum(forSize);
                        for (int a = 0; a < forSize; a++) {// 4 to 3

                              VF_R.getJLBS()[a + r].setLocation(6, VF_R.getJLBS()[r - 1].getY() + b);
                              // 4 - 3 = 1
                              VF_R.getJTFS()[a + r].setLocation(107, VF_R.getJTFS()[r - 1].getY() + b);

                              VF_R.getBTNS_C()[a + (r - 1)].setLocation(402, VF_R.getBTNS_C()[r - 2].getY() + b);

                              b += 33;
                        }
                        ClockFocusLost(forSize, r);
                  }
            }
      }

      private void ClockFocusGained(int forSize, int res) {
            String CK = DT.getClock();
            if (!CK.equals("NONE")) {
                  DT.chars[0] = CK.charAt(1);
                  DT.strings[0] = Character.toString(DT.chars[0]);
                  DT.ints[0] = Integer.parseInt(DT.strings[0]) - 1;//EX: 4 TO 3

                  //System.out.println("\tClockFocusGained");
                  for (int a = 0; a < 4; a++) {
                        if (forSize == (a + 1)) {//Focus on TF_5
                              //System.out.println("\t\tFocus on TF_" + (6 - (a + 1)));
                              int PA = 6 - (a + 1);
                              int c = 308;
                              int d = 5;
                              for (int b = 0; b < (a + 1); b++) {
                                    if (DT.ints[0] == d) {//IF CK = 6
                                          int dis = getDistanceGained(PA, DT.ints[0] + 1);
                                          //System.out.println("\t\tCK is on: C" + (1 + d));
                                          //System.out.println("\t\tTEST " + VF_R.getTFS_MD()[res - 2].getName() + " is referenced");
                                          //ints = 5(6) // 5 - 1 = 4(CK6) // ref: 
                                          VF_R.getTFS_MD()[DT.ints[0] - 1].setLocation(270, VF_R.getTFS_MD()[res - 2].getY() + dis);//res - 2

                                          VF_R.getTFS_MU()[DT.ints[0] - 1].setLocation(296, VF_R.getTFS_MU()[res - 2].getY() + dis);

                                          VF_R.getLB_2DS()[DT.ints[0] - 1].setLocation(328, VF_R.getLB_2DS()[res - 2].getY() + dis);

                                          VF_R.getTFS_SD()[DT.ints[0] - 1].setLocation(340, VF_R.getTFS_SD()[res - 2].getY() + dis);

                                          VF_R.getTFS_SU()[DT.ints[0] - 1].setLocation(366, VF_R.getTFS_SU()[res - 2].getY() + dis);
                                    }
                                    c -= 33;
                                    d--;
                              }
                        }
                  }
            }
      }

      private void ClockFocusLost(int forSize, int res) {
            String CK = DT.getClock();
            if (!CK.equals("NONE")) {
                  DT.chars[0] = CK.charAt(1);
                  DT.strings[0] = Character.toString(DT.chars[0]);
                  DT.ints[0] = Integer.parseInt(DT.strings[0]) - 1;//EX: 4 TO 3

                  //System.out.println("\tClockFocusLost");
                  for (int a = 0; a < 4; a++) {
                        if (forSize == (a + 1)) {
                              //System.out.println("\t\tFocus on TF_" + (6 - (a + 1)));
                              int PA = 6 - (a + 1);
                              int d = 5;
                              for (int b = 0; b < (a + 1); b++) {
                                    if (DT.ints[0] == d) {
                                          int dis = getDistanceLost(PA, 1 + d);
                                          //System.out.println("\t\tCK is on: C" + (1 + d));
                                          VF_R.getTFS_MD()[DT.ints[0] - 1].setLocation(270, VF_R.getTFS_MD()[res - 2].getY() + dis);//5

                                          VF_R.getTFS_MU()[DT.ints[0] - 1].setLocation(296, VF_R.getTFS_MU()[res - 2].getY() + dis);

                                          VF_R.getLB_2DS()[DT.ints[0] - 1].setLocation(328, VF_R.getLB_2DS()[res - 2].getY() + dis);

                                          VF_R.getTFS_SD()[DT.ints[0] - 1].setLocation(340, VF_R.getTFS_SD()[res - 2].getY() + dis);

                                          VF_R.getTFS_SU()[DT.ints[0] - 1].setLocation(366, VF_R.getTFS_SU()[res - 2].getY() + dis);
                                    }
                                    d--;
                              }
                        }
                  }

            }
      }

      private int getNumToSum(int num) {
            int res = -1;
            if (num == 4) {//TF_2
                  res = 2;
            } else if (num == 3) {//TF_3
                  res = 3;
            } else if (num == 2) {//TF_4
                  res = 4;
            } else if (num == 1) {//TF_5
                  res = 5;
            } else if (num == 0) {
                  res = 6;
            }
            return res;
      }

      public int getDistanceGained(int pointA, int pointB) {
            int dis = pointB - pointA;
            if (dis == 4) {
                  dis = 308;
            } else if (dis == 3) {
                  dis = 275;
            } else if (dis == 2) {
                  dis = 242;
            } else if (dis == 1) {
                  dis = 209;
            }
            //C2
            //209 C3
            //242 C4
            //275 C5
            //308 C6
            //System.out.println("--------------PointA: " + pointA);
            //System.out.println("--------------PointB: " + pointB);
            //System.out.println("--------------Distance: " + dis);
            return dis;
      }

      public int getDistanceLost(int pointA, int pointB) {
            int dis = pointB - pointA;
            if (dis == 4) {
                  dis = 132;
            } else if (dis == 3) {
                  dis = 99;
            } else if (dis == 2) {
                  dis = 66;
            } else if (dis == 1) {
                  dis = 33;
            }
            //C2
            //33 C3
            //66 C4
            //99 C5
            //132 C6
            //System.out.println("--------------PointA: " + pointA);
            //System.out.println("--------------PointB: " + pointB);
            //System.out.println("--------------Distance: " + dis);
            return dis;
      }

      //+++++++++++++++++++++++++++++++++++++
      /*
      private void setGraphics(JComponent jc) {
            //System.out.println("setgraphics");
            //g2 = (Graphics2D) VF_R.getPL().getGraphics();

            //g2.setColor(Color.RED);
            //g2.drawRect(jc.getX(), jc.getY(), jc.getWidth() + 2, jc.getHeight() + 2);
            new Thread() {
                  @Override
                  public void run() {
                        try{
                              Thread.sleep(70);
                        }catch(InterruptedException ex){
                              ex.printStackTrace();
                        }
                        //cS = jc;
                        System.out.println("\npaintComponent");
                        VF_R.getPL().paintComponents(VF_R.getPL().getGraphics());
                  }
            }.start();

      }
      */
      //+++++++++++++++++++++++++++++++++++++
      private void oldState() {
            /*
if (tf_6.getBackground().equals(new Color(0, 0, 51))
                    || tf_6.getBackground().equals(new Color(0, 0, 81))) {
                  //jPanel1.setPreferredSize(new Dimension(430, 520));
                  //sc_p1.getVerticalScrollBar().set
                  if (btn_Show_All.isSelected()) {
                  } else {
                        lb_Icon.setVisible(false);

                        sc_6.setLocation(107, tf_6.getY() + 33);
                        sc_6.setVisible(true);
                  }
            }
             *//*
            if (tf_6.getBackground().equals(new Color(0, 0, 51))
                    || tf_6.getBackground().equals(new Color(0, 0, 81))) {
                  //jPanel1.setPreferredSize(new Dimension(430, 310));
                  if (btn_Show_All.isSelected()) {
                  } else {
                        if (lst_6.getValueIsAdjusting() == true) {
                        } else {
                              if (dt.getTabl().equals("NONE")) {
                              } else {
                                    lb_Icon.setVisible(true);
                              }
                              sc_6.setVisible(false);
                        }
                  }
            }
             */
      }

}
