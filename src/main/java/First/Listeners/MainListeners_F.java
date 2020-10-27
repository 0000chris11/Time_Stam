package First.Listeners;

import First.Listeners.MITableOptions_AL;
import First.Listeners.MIShow_AL;
import First.Listeners.MIOptions_IL;
import First.Listeners.LSTS_VC;
import First.Listeners.JT_ML;
import First.Listeners.JT_LSL;
import First.Listeners.FocusBorder;
import First.Listeners.CK_KL;
import First.Listeners.BTNS_TBActionListener;
import First.Listeners.BTNS_MCActionListener;
import First.Listeners.BTNS_CMouseListener;
import First.VF_R;
import MC.DT;
import javax.swing.DefaultListSelectionModel;

/**
 *
 * @author Christopher
 */
public class MainListeners_F {

      //Data dt = new Data("MainListeners_F");
      public void addAllListenerLoop() {
            addTableModelListenerToJT();
            addListSelectionListenerToJT();
            //addKeyListenerToTFS_OLD();
            //addFocusListenerToTFS_OLD();
            addValueChangedListenerToLSTS();
            //addActionLIstenerToBTN_C();
            addMouseListenerToBTN_C();
            addMouseListenerToTFS();
            //addFocusListenerToLSTS_OLD();
            //addActionListenerToBTNS_MC();
      }

      public void addAllListener() {
            addFocusListenersToJC();
            addFocusListenersToJC_PC();

            addKeyListenersToTFS();
            addKeyListenersToCKS();

            addActionListenersToMIS();
            addItemListenersToMIS();

            addActionListenerToBTNS_MC();
            addActionListenerToBTNS_P_M();
            addActionListenerToMITable();
      }

      //++++++++++++++++++++++++++++++++++++++++++++
      //CHANGE NEEDED
      private void addTableModelListenerToJT() {
            JT_ML JTML = new JT_ML();
            VF_R.getJT().getModel().addTableModelListener(JTML);
            /*
            for (int a = 2; a < DT.getDTMS().length; a++) {
                  if (DT.getList_C().size() == a) {
                        if (DT.getDTMS()[a].getTableModelListeners().length > 0) {
                              for (int b = 0; b < DT.getDTMS()[a].getTableModelListeners().length; b++) {

                                    if (DT.getDTMS()[a].getTableModelListeners()[b].equals("TableModelListener")) {

                                          DT.getDTMS()[a].removeTableModelListener(
                                                  DT.getDTMS()[a].getTableModelListeners()[b]);
                                    }
                              }
                        }
                        if (DT.getDTMS()[a].getTableModelListeners().length == 1) {
                              DT.getDTMS()[a].addTableModelListener(JTML);
                        }
                  }
            }*/
      }
      
      private void addTableModelListenerToJTNew(){
            
      }

      private void addListSelectionListenerToJT() {
            JT_LSL JTL = new JT_LSL();
            DefaultListSelectionModel dlsm = (DefaultListSelectionModel) VF_R.getJT().getSelectionModel();

            if (dlsm.getListSelectionListeners().length > 0) {
                  for (int a = 0; a < dlsm.getListSelectionListeners().length; a++) {
                        if (dlsm.getListSelectionListeners()[a].toString().contains("ListSelectionListener")) {
                              //System.out.println("JT removes: " + JTL.toString());
                              VF_R.getJT().getSelectionModel().removeListSelectionListener(JTL);
                        }

                  }
            }
            if (dlsm.getListSelectionListeners().length == 1) {
                  //System.out.println("JT adds " + JTL.toString());
                  VF_R.getJT().getSelectionModel().addListSelectionListener(JTL);
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++
      private void addKeyListenerToTFS_OLD() {
            TFS_KL tkt = new TFS_KL();
            for (int a = 0; a < VF_R.getJTFS().length; a++) {
                  if (VF_R.getJTFS()[a].getKeyListeners().length > 0) {
                        VF_R.getJTFS()[a].removeKeyListener(tkt);
                  }
                  if (VF_R.getJTFS()[a].getKeyListeners().length == 0) {
                        VF_R.getJTFS()[a].addKeyListener(tkt);
                  }

            }
      }

      private void addMouseListenerToTFS() {
            BTNS_CMouseListener BTNCML = new BTNS_CMouseListener();
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (VF_R.getJTFS()[a].getMouseListeners().length > 0) {
                        for (int b = 0; b < VF_R.getJTFS()[a].getMouseListeners().length; b++) {
                              if (VF_R.getJTFS()[a].getMouseListeners()[b].toString().contains("MouseListener")) {
                                    VF_R.getJTFS()[a].removeMouseListener(BTNCML);
                              }
                        }
                  }
                  if (VF_R.getJTFS()[a].getMouseListeners().length == 3) {
                        //System.out.println(tfs[a + 1].getName() + " adds: " + BTNCML.toString());
                        VF_R.getJTFS()[a].addMouseListener(BTNCML);
                  }
            }
      }

      private void addFocusListenerToTFS_OLD() {
            //System.out.println("-----On Mehod = tf2 FocusListener count: " + tfs[1].getFocusListeners().length);
            TF_LST_FL TFSFL = new TF_LST_FL();
            for (int a = 1; a < VF_R.getJTFS().length; a++) {
                  if (VF_R.getJTFS()[a].getFocusListeners().length > 0) {
                        for (int b = 0; b < VF_R.getJTFS()[a].getFocusListeners().length; b++) {
                              if (VF_R.getJTFS()[a].getFocusListeners()[b].toString().contains("TF_LST_FL")) {
                                    //System.out.println("removing: " + tfs[a].getFocusListeners()[b]);
                                    VF_R.getJTFS()[a].removeFocusListener(VF_R.getJTFS()[a].getFocusListeners()[b]);
                              }
                        }
                        //System.out.println("\ttf2 FocusListener count: " + tfs[1].getFocusListeners().length);
                  }
                  if (VF_R.getJTFS()[a].getFocusListeners().length == 2) {
                        //System.out.println("\tTF_" + (a + 1) + " adding TFSFL");
                        //System.out.println("adding TF_LST_FL");
                        VF_R.getJTFS()[a].addFocusListener(TFSFL);
                  }
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++
      private void addFocusListenerToLSTS_OLD() {
            TF_LST_FL TFSFL = new TF_LST_FL();
            for (int a = 0; a < VF_R.getJLSTS().length; a++) {
                  if (VF_R.getJLSTS()[a].getFocusListeners().length > 0) {
                        for (int b = 0; b < VF_R.getJLSTS()[a].getFocusListeners().length; b++) {
                              if (VF_R.getJLSTS()[a].getFocusListeners()[b].toString().contains("TF_LST_FL")) {
                                    //System.out.println("removing: " + lsts[a].getFocusListeners()[b]);
                                    VF_R.getJLSTS()[a].removeFocusListener(VF_R.getJLSTS()[a].getFocusListeners()[b]);
                              }
                        }
                        //System.out.println("\ttf2 FocusListener count: " + tfs[1].getFocusListeners().length);
                  }
                  if (VF_R.getJLSTS()[a].getFocusListeners().length == 1) {
                        //System.out.println("LST_" + (a + 2) + " adds: " + TFSFL.toString());
                        VF_R.getJLSTS()[a].addFocusListener(TFSFL);
                  }
            }
      }

      private void addValueChangedListenerToLSTS() {
            LSTS_VC lstsVC = new LSTS_VC();
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (VF_R.getJLSTS()[a].getListSelectionListeners().length > 0) {
                        VF_R.getJLSTS()[a].removeListSelectionListener(lstsVC);
                  }
                  if (VF_R.getJLSTS()[a].getListSelectionListeners().length == 0) {
                        VF_R.getJLSTS()[a].addListSelectionListener(lstsVC);
                  }
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++
      private void addMouseListenerToBTN_C() {
            BTNS_CMouseListener BTNCML = new BTNS_CMouseListener();
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (VF_R.getBTNS_C()[a].getMouseListeners().length > 0) {
                        for (int b = 0; b < VF_R.getBTNS_C()[a].getMouseListeners().length; b++) {
                              if (VF_R.getBTNS_C()[a].getMouseListeners()[b].toString().contains("MouseListener")) {
                                    VF_R.getBTNS_C()[a].removeMouseListener(BTNCML);
                              }
                        }
                  }
                  if (VF_R.getBTNS_C()[a].getMouseListeners().length == 1) {
                        //System.out.println(btns_C[a].getName() + " adds: " + BTNCML.toString());
                        VF_R.getBTNS_C()[a].addMouseListener(BTNCML);
                  }
            }
      }

      private void addActionListenerToBTNS_MC() {
            //System.out.println("\tSTAR OF addActionListenerToBTNS_MC");
            BTNS_MCActionListener BMA = new BTNS_MCActionListener();

            for (int a = 0; a < VF_R.getBTNS_MC().length; a++) {
                  VF_R.getBTNS_MC()[a].addActionListener(BMA);

            }
            //System.out.println("\tEND OF addActionListenerToBTNS_MC");
      }

      private void addActionListenerToBTNS_P_M() {
            BTNS_TBActionListener BTNS_TB = new BTNS_TBActionListener();
            VF_R.getBTN_PLUS().addActionListener(BTNS_TB);
            VF_R.getBTN_MINUS().addActionListener(BTNS_TB);
      }

      ///================================================
      private void addFocusListenersToJC_PC() {
            FocusBorder jcfl = new FocusBorder();
            for (int a = 0; a < DT.maxColumns; a++) {
                  VF_R.getJTFS()[a].addFocusListener(jcfl);
                  VF_R.getJLSTS()[a].addFocusListener(jcfl);
                  VF_R.getTFS_MD()[a].addFocusListener(jcfl);
                  VF_R.getTFS_MU()[a].addFocusListener(jcfl);
                  VF_R.getTFS_SD()[a].addFocusListener(jcfl);
                  VF_R.getTFS_SU()[a].addFocusListener(jcfl);

            }
      }

      private void addFocusListenersToJC() {
            TF_LST_FL TFSFL = new TF_LST_FL();
            for (int a = 0; a < DT.maxColumns; a++) {
                  VF_R.getJTFS()[a].addFocusListener(TFSFL);
                  VF_R.getJLSTS()[a].addFocusListener(TFSFL);

            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++
      private void addKeyListenersToTFS() {
            TFS_KL tkt = new TFS_KL();
            for (int a = 0; a < DT.maxColumns; a++) {
                  VF_R.getJTFS()[a].addKeyListener(tkt);
            }
      }

      private void addKeyListenersToCKS() {
            CK_KL ckkl = new CK_KL();
            for (int a = 0; a < DT.maxColumns; a++) {
                  VF_R.getTFS_MD()[a].addKeyListener(ckkl);
                  VF_R.getTFS_MU()[a].addKeyListener(ckkl);
                  VF_R.getTFS_SD()[a].addKeyListener(ckkl);
                  VF_R.getTFS_SU()[a].addKeyListener(ckkl);
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++
      private void addActionListenersToMIS() {
            MIShow_AL mial = new MIShow_AL();
            for (int a = 0; a < VF_R.getJMS_ShowList().getItemCount(); a++) {
                  VF_R.getJMS_ShowList().getItem(a).addActionListener(mial);
            }
            for (int a = 0; a < VF_R.getJMS_ShowListeners().getItemCount(); a++) {
                  VF_R.getJMS_ShowListeners().getItem(a).addActionListener(mial);
            }
      }

      private void addItemListenersToMIS() {
            MIOptions_IL mio = new MIOptions_IL();

            VF_R.getMI_AOT().addActionListener(mio);
            VF_R.getMI_AutoR().addActionListener(mio);
            VF_R.getMI_Grid().addActionListener(mio);

            VF_R.getSaveOp().addActionListener(mio);
      }

      private void addActionListenerToMITable() {
            MITableOptions_AL MITAL = new MITableOptions_AL();
            VF_R.getMI_CreateTable().addActionListener(MITAL);
            VF_R.getMI_UpdateTable().addActionListener(MITAL);
            VF_R.getMI_DeleteThisTable().addActionListener(MITAL);
            VF_R.getMI_DeleteTables().addActionListener(MITAL);
      }

      //================================================
      private void addKeyListenerToLSTS() {

            /*LSTSKeyReleased LSTSKR = new LSTSKeyReleased();
            for (int a = 0; a < lsts.length; a++) {
                  lsts[a].removeKeyListener(LSTSKR);
                  lsts[a].addKeyListener(LSTSKR);
            }
             */
      }

}
