package First.Listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import First.VF_R;
import MC.DT;
import javax.swing.JComponent;

/**
 *
 * @author Christopher
 */
public class TF_LST_FL implements FocusListener {

      @Override
      public void focusGained(FocusEvent evt) {
            int forSize = DT.maxColumns - 1;//DEPENDING ON WICH TF HAD THE FOCUS THE REMAINIG (COUNTING UP) WILL BE MOVE
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (VF_R.getJTFS()[a].hasFocus()) {
                        if (VF_R.getJTFS()[a].getBackground().equals(DT.TFColor[1])
                                || VF_R.getJTFS()[a].getBackground().equals(DT.TFColor[2])) {
                              focusGainedFor(forSize, a + 1);
                        }
                  }
                  forSize--;
            }
      }

      @Override
      public void focusLost(FocusEvent evt) {
            String JC = ((JComponent) evt.getSource()).getName();
            int forSize = DT.maxColumns - 1;
            for (int a = 0; a < DT.maxColumns; a++) {
                  if ((JC.equals("TF_" + (a + 1))
                          && (VF_R.getJTFS()[a].getBackground().equals(DT.TFColor[1])
                          || VF_R.getJTFS()[a].getBackground().equals(DT.TFColor[2])))
                          || JC.equals("LST_" + (a + 1))) {

                        focusLostFor(a, forSize);
                  }
                  forSize--;
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++
      private void focusGainedFor(int forSize, int res) {
            VF_R.getLB_Icon().setVisible(false);

            //int r = getNumToSum(forSize);
            if (forSize != 0) {//IF THE LAST TF HAD THE FOCUS THEN YOU CAN'T MOVE OTHERS
                  int b = 209;//SPACE NEEDED TO FIT LST IN BETWEEN COMPONENTS
                  for (int a = 0; a < forSize; a++) {
                        VF_R.getJLBS()[a + res].setLocation(6, VF_R.getJLBS()[res - 1].getY() + b);
                        VF_R.getJTFS()[a + res].setLocation(107, VF_R.getJTFS()[res - 1].getY() + b);
                        VF_R.getBTNS_C()[a + res].setLocation(402, VF_R.getBTNS_C()[res - 1].getY() + b);

                        b += 33;
                  }
                  //+++++++++++++++++++++++++++++++
                  ClockFocusGained(forSize, res);
            }
            //00 or 11
            VF_R.getJSCS()[res - 1].setLocation(107, VF_R.getJTFS()[res - 1].getY() + 33);
            VF_R.getJSCS()[res - 1].setVisible(true);
      }

      private void focusLostFor(int index, int forSize) {
            if (VF_R.getJLSTS()[index].getValueIsAdjusting() == true) {// = 0
            } else {
                  if (!DT.getImageC().equals("NONE")) {
                        VF_R.getLB_Icon().setVisible(true);
                  }

                  VF_R.getJSCS()[index].setVisible(false);
                  if (forSize != 0) {
                        int b = 33;
                        int r = getNumToSum(forSize);
                        for (int a = 0; a < forSize; a++) {// 4 to 3

                              VF_R.getJLBS()[a + r].setLocation(6, VF_R.getJLBS()[r - 1].getY() + b);
                              VF_R.getJTFS()[a + r].setLocation(107, VF_R.getJTFS()[r - 1].getY() + b);
                              VF_R.getBTNS_C()[a + r].setLocation(402, VF_R.getBTNS_C()[r - 1].getY() + b);

                              b += 33;
                        }
                        ClockFocusLost(forSize, r);
                  }
            }
      }

      private void ClockFocusGained(int forSize, int index) {
            String CK = DT.getClock();
            if (!CK.equals("NONE")) {
                  //DT.chars[0] = CK.charAt(1);
                  //DT.strings[0] = Character.toString(DT.chars[0]);
                  //DT.ints[0] = Integer.parseInt(DT.strings[0]) - 1;//EX: 4 TO 3

                  int col = Character.getNumericValue(CK.charAt(1)) - 1;
                  System.out.println("\t####COL VALUE: " + col + " (CK: " + CK + ")");
                  //FOCUS TF_5
                  //forSize = 1
                  //index = 5

                  int d = 5;
                  for (int b = 0; b < forSize; b++) {
                        if (col == d) {//FINDING THE CLOCK
                              int dis = getDistance(index, col + 1, 209);

                              VF_R.getClocks()[col].setLocation(270, VF_R.getTFS_MD()[index - 1].getY() + dis);
                              /*
                              VF_R.getTFS_MD()[col].setLocation(
                                      270, VF_R.getTFS_MD()[index - 1].getY() + dis);//res - 2

                              VF_R.getTFS_MU()[col].setLocation(
                                      296, VF_R.getTFS_MU()[index - 1].getY() + dis);

                              VF_R.getLB_2DS()[col].setLocation(
                                      328, VF_R.getLB_2DS()[index - 1].getY() + dis);

                              VF_R.getTFS_SD()[col].setLocation(
                                      340, VF_R.getTFS_SD()[index - 1].getY() + dis);

                              VF_R.getTFS_SU()[col].setLocation(
                                      366, VF_R.getTFS_SU()[index - 1].getY() + dis);
                              */
                        }
                        d--;
                  }

            }
      }

      private void ClockFocusLost(int forSize, int index) {
            String CK = DT.getClock();
            if (!CK.equals("NONE")) {
                  //DT.chars[0] = CK.charAt(1);
                  //DT.strings[0] = Character.toString(DT.chars[0]);
                  //DT.ints[0] = Integer.parseInt(DT.strings[0]) - 1;//EX: 4 TO 3

                  int col = Character.getNumericValue(CK.charAt(1)) - 1;
                  System.out.println("\t####COL VALUE: " + col + " (CK: " + CK + ")");

                  //System.out.println("\tClockFocusLost");
                  int d = 5;
                  for (int b = 0; b < forSize; b++) {
                        if (col == d) {
                              int dis = getDistance(index, col + 1, 33);
                              //System.out.println("\t\tCK is on: C" + (1 + d));
                              VF_R.getClocks()[col].setLocation(
                                      270, VF_R.getTFS_MD()[index - 1].getY() + dis);
                              /*
                              VF_R.getTFS_MD()[col].setLocation(
                                      270, VF_R.getTFS_MD()[index - 1].getY() + dis);//5

                              VF_R.getTFS_MU()[col].setLocation(
                                      296, VF_R.getTFS_MU()[index - 1].getY() + dis);

                              VF_R.getLB_2DS()[col].setLocation(
                                      328, VF_R.getLB_2DS()[index - 1].getY() + dis);

                              VF_R.getTFS_SD()[col].setLocation(
                                      340, VF_R.getTFS_SD()[index - 1].getY() + dis);

                              VF_R.getTFS_SU()[col].setLocation(
                                      366, VF_R.getTFS_SU()[index - 1].getY() + dis);
                              */
                        }
                        d--;
                  }

            }
      }
      //*++++++++++++++++++++++++++++++++++++++++++++++++++
      private int getNumToSum(int num) {
            int returnValue = -1;
            int res = DT.maxColumns - 1;
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (num == a) {
                        returnValue = res;
                  }
                  res--;
            }

            return returnValue;
      }

      public int getDistance(int pointA, int pointB, int initValue) {
            int disP = pointB - pointA;
            int dis = initValue;
            for (int a = 0; a < DT.maxColumns - 1; a++) {
                  if (disP == a + 1) {
                        dis = dis + (33 * a);
                  }
            }
            return disP;
      }
}
