package Listeners_C;

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
                              VC_R.getRow()[a + 1][b].setVisible(false);
                        }
                        VC_R.getJBTNS_P()[a].setVisible(true);
                        VC_R.getJBTNS_M()[a].setVisible(true);
                  }
                  //PLUS++++++++++++++++++++++++++++++++++++++
                  if (e.getSource() == VC_R.getJBTNS_P()[a]) {
                        for (int b = 0; b < 9; b++) {
                              VC_R.getRow()[a + 1][b].setVisible(true);
                        }

                        VC_R.getJBTNS_P()[a].setVisible(false);
                        VC_R.getJBTNS_M()[a].setVisible(false);
                  }
            }
      }

}
