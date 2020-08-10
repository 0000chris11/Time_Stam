package Listeners;

import Listeners.FocusBorder;
import MC.DT;
import Second.VC_R;

/**
 *
 * @author Christopher
 */
public class MainListeners_C {

      public void addAllListeners() {
            addFocusListenerToJC();
            addActionListenersToBTNS_PM();
      }

      private void addFocusListenerToJC() {
            FocusBorder FB = new FocusBorder();
            for (int a = 0; a < DT.maxColumns; a++) {
                  VC_R.getJTFS()[a].addFocusListener(FB);
            }
      }

      private void addActionListenersToBTNS_PM() {
            BTN_PM_VC PMC = new BTN_PM_VC();
            for (int a = 0; a < DT.maxColumns - 1; a++) {
                  VC_R.getJBTNS_P()[a].addActionListener(PMC);
                  VC_R.getJBTNS_M()[a].addActionListener(PMC);
            }
      }
}
