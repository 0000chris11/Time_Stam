/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Create.Listeners;

import Create.VC_R2;
import MC.DT;
import com.cofii.myMethods.MComp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author C0FII
 */
public class RBType2_AL implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {
            int num = MComp.setButtonGroup(e, VC_R2.getRBTypes2()) - 1;
            VC_R2.setRB_Types2Selected(num + 1);
            boolean visible = false;
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (num == a) {
                        visible = true;
                  } else {
                        visible = false;
                  }

                  VC_R2.getCombTypes2()[a].setVisible(visible);
                  //++++++++++++++++++++++++++++++++++++++++++++++
                  if (num == a) {
                        if (VC_R2.getCombTypes2()[a].getSelectedIndex() == 1) {
                              visible = true;
                        } else {
                              visible = false;
                        }
                  }
                  VC_R2.getTFSTypes1()[a].setVisible(visible);
                  VC_R2.getTFSTypes2()[a].setVisible(visible);
            }
      }

}
