package Listeners;

import MC.DT;
import Others.CC;
import Second.VC_R;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Christopher
 */
public class BTN_PM_VC implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {
            for (int a = 0; a < DT.maxColumns - 2; a++) {
                  //MINUS
                  if (e.getSource() == VC_R.getJBTNS_M()[a + 1]) {//EX: 3
                        for (int b = 0; b < 9; b++) {
                              VC_R.getRow()[a + 2][b].setVisible(false);
                        }
                        //VC_R.getJLBS()[a + 2].setVisible(false);
                        //VC_R.getJTFS()[a + 2].setVisible(false);
                        //VC_R.getJBTNS_P()[a + 1].setVisible(false);
                        //VC_R.getJBTNS_M()[a + 1].setVisible(false);
                        //VC_R.getBTNS_Dist()[a + 1].setVisible(false);
                        //VC_R.getBTNS_Dist2()[a + 1].setVisible(false);
                        //VC_R.getBTNS_Tabl()[a + 1].setVisible(false);
                        //VC_R.getBTNS_Tag()[a + 1].setVisible(false);
                        //VC_R.getBTNS_Clock()[a + 1].setVisible(false);

                        VC_R.getJBTNS_P()[a].setVisible(true);
                        VC_R.getJBTNS_M()[a].setVisible(true);
                  }

                  //PLUS
                  if (e.getSource() == VC_R.getJBTNS_P()[a]) {
                        VC_R.getJLBS()[a + 2].setVisible(true);
                        VC_R.getJTFS()[a + 2].setVisible(true);
                        VC_R.getJBTNS_P()[a + 1].setVisible(true);
                        VC_R.getJBTNS_M()[a + 1].setVisible(true);
                        VC_R.getBTNS_Dist()[a + 1].setVisible(true);
                        VC_R.getBTNS_Dist2()[a + 1].setVisible(true);
                        VC_R.getBTNS_Tabl()[a + 1].setVisible(true);
                        VC_R.getBTNS_Tag()[a + 1].setVisible(true);
                        VC_R.getBTNS_Clock()[a + 1].setVisible(true);

                        VC_R.getJBTNS_P()[a].setVisible(false);
                        VC_R.getJBTNS_M()[a].setVisible(false);
                  }
            }
      }

}
