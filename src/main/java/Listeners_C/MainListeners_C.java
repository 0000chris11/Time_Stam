package Listeners_C;

import Listeners_C.BTN_PM_VC;
import Listeners_F.FocusBorder;
import Listeners_F.FocusBorder;
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
            addActionListenersToBTNS_CK_TB();
            addKeyListenerToTFS();
            
      }

      //++++++++++++++++++++++++++++++++++++++++++
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
      //SHARED LISTENER --- CHANGE LATER
      private void addActionListenersToBTNS_CK_TB(){
            BTN_CK_AL CKAL = new BTN_CK_AL();
            for(int a = 0; a < DT.maxColumns - 1; a++){
                  VC_R.getBTNS_Clock()[a].addActionListener(CKAL);
                  VC_R.getBTNS_Tabl()[a].addActionListener(CKAL);
            }
      }
      

      private void addKeyListenerToTFS() {
            TF_KL_VC KLVC = new TF_KL_VC();
            for (int a = 0; a < VC_R.getJTFS().length; a++) {
                  VC_R.getJTFS()[a].addKeyListener(KLVC);
            }
      }
}
