package Listeners;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import First.VF;

/**
 *
 * @author Christopher
 */
public class MIV_AL implements ActionListener {

      public void actionPerformed(ActionEvent evt) {
            String ac = evt.getActionCommand();

            if (ac.contains("Left")) {
                  if (VF.getMI_SEEL().isSelected()) {
                        VF.getJF().setSize(1226, 582);
                        VF.getJSC_P1().setVisible(true);

                        int x = VF.getJSC_P1().getX() + VF.getJSC_P1().getWidth();
                        VF.getSC_JT().setLocation(x - 2, VF.getSC_JT().getY());
                  } else {
                        if (VF.getMI_SEER().isSelected()) {
                              VF.getJSC_P1().setVisible(false);
                              VF.getSC_JT().setLocation(VF.getJSC_P1().getX(), VF.getSC_JT().getY());
                              VF.getJF().setSize(VF.getSC_JT().getWidth() + 14, VF.getJF().getHeight());
                        } else {
                              VF.getMI_SEEL().setSelected(true);
                        }
                  }
            } else if (ac.contains("Right")) {
                  if (VF.getMI_SEER().isSelected()) {
                        VF.getSC_JT().setVisible(true);
                        VF.getJF().setSize(1226, 582);
                        
                  } else {
                        if (VF.getMI_SEEL().isSelected()) {
                              VF.getSC_JT().setVisible(false);
                              VF.getJF().setSize(VF.getJSC_P1().getWidth() + 14, VF.getJF().getHeight());
                        } else {
                              VF.getMI_SEER().setSelected(true);
                        }
                  }
            }
      }
}
