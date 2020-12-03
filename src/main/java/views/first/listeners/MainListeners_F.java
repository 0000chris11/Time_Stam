package views.first.listeners;

import views.first.listeners.MITableOptions_AL;
import views.first.listeners.MIShow_AL;
import views.first.listeners.MIConfigOptions_AL;
import views.first.listeners.LSTS_VC;
import views.first.listeners.JT_ML;
import views.first.listeners.JT_LSL;
import views.first.listeners.FocusBorder;
import views.first.listeners.CK_KL;
import views.first.listeners.BTNS_TBActionListener;
import views.first.listeners.BTNS_MCActionListener;
import views.first.listeners.BTNS_CMouseListener;
import views.first.VF_R;
import MC.DT;
import com.cofii.myClasses.CC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListSelectionModel;
import views.Login.VL;

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

            //addFocusListenerToLSTS_OLD();
            //addActionListenerToBTNS_MC();
      }

      public void addAllListener() {
            if (VF_R.JPL_layout.equals("null")) {
                  addFocusListenersToJC();
            } else {
                  addFocusListenersToJC_GL();
            }

            addFocusBorderToJC_PC();
            addMouseListenerToTFS();

            addKeyListenersToTFS();
            addKeyListenersToCKS();

            addActionListenersToMIS();

            addActionListenerToBTNS_MC();
            addActionListenerToBTNS_P_M();
      }

      //++++++++++++++++++++++++++++++++++++++++++++
      //CHANGE NEEDED
      private void addTableModelListenerToJT() {
            JT_ML JTML = new JT_ML();
            VF_R.getJT().getModel().addTableModelListener(JTML);
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
      private void addMouseListenerToTFS() {
            BTNS_CMouseListener ML = new BTNS_CMouseListener();
            for (int a = 0; a < DT.maxColumns; a++) {
                  VF_R.getJTFS()[a].addMouseListener(ML);
            }
      }

      private void addFocusListenerToTFS_OLD() {
            //System.out.println("-----On Mehod = tf2 FocusListener count: " + tfs[1].getFocusListeners().length);
            TF_LST_FL TFSFL = new TF_LST_FL();
            for (int a = 0; a < VF_R.getJCBS().length; a++) {
                  if (VF_R.getJCBS()[a].getFocusListeners().length > 0) {
                        for (int b = 0; b < VF_R.getJCBS()[a].getFocusListeners().length; b++) {
                              if (VF_R.getJCBS()[a].getFocusListeners()[b].toString().contains("TF_LST_FL")) {
                                    //System.out.println("removing: " + tfs[a].getFocusListeners()[b]);
                                    VF_R.getJCBS()[a].removeFocusListener(VF_R.getJCBS()[a].getFocusListeners()[b]);
                              }
                        }
                        //System.out.println("\ttf2 FocusListener count: " + tfs[1].getFocusListeners().length);
                  }
                  if (VF_R.getJCBS()[a].getFocusListeners().length == 2) {
                        //System.out.println("\tTF_" + (a + 1) + " adding TFSFL");
                        //System.out.println("adding TF_LST_FL");
                        VF_R.getJCBS()[a].addFocusListener(TFSFL);
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
      private void addFocusBorderToJC_PC() {
            FocusBorder jcfl = new FocusBorder();
            for (int a = 0; a < DT.maxColumns; a++) {
                  VF_R.getJCBS()[a].addFocusListener(jcfl);
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
                  VF_R.getJCBS()[a].addFocusListener(TFSFL);
                  VF_R.getJLSTS()[a].addFocusListener(TFSFL);

            }
      }

      private void addFocusListenersToJC_GL() {
            TF_LST_FL_GL FL = new TF_LST_FL_GL();
            for (int a = 0; a < DT.maxColumns; a++) {
                  VF_R.getJCBS()[a].addFocusListener(FL);
                  VF_R.getJLSTS()[a].addFocusListener(FL);
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++
      private void addKeyListenersToTFS() {
            TFS_KL tkt = new TFS_KL();
            for (int a = 0; a < DT.maxColumns; a++) {
                  VF_R.getJTFS()[a].addKeyListener(tkt);
                  //VF_R.getJTFS()[a].addKeyListener(new TF_KL(
                    //      VF_R.getJCBS()[a], VF_R.getJTFS()[a]));
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
            //PRINT LISTENER AND OUTDATED LISTS +++++++++++++++
            MIShow_AL mial = new MIShow_AL();
            for (int a = 0; a < VF_R.getJMS_ShowList().getItemCount(); a++) {
                  VF_R.getJMS_ShowList().getItem(a).addActionListener(mial);
            }
            for (int a = 0; a < VF_R.getJMS_ShowListeners().getItemCount(); a++) {
                  VF_R.getJMS_ShowListeners().getItem(a).addActionListener(mial);
            }
            //ConfigOptions +++++++++++++++++++++++++++++++++++++
            MIConfigOptions_AL mio = new MIConfigOptions_AL();

            VF_R.getMI_AOT().addActionListener(mio);
            VF_R.getMI_AutoR().addActionListener(mio);
            VF_R.getMI_Grid().addActionListener(mio);
            VF_R.getSaveOp().addActionListener(mio);
            
            //MAIN QUERYS +++++++++++++++++++++++++++++++++++++
            MITableOptions_AL MITAL = new MITableOptions_AL();
            VF_R.getMI_CreateTable().addActionListener(MITAL);
            VF_R.getMI_UpdateTable().addActionListener(MITAL);
            VF_R.getMI_DeleteThisTable().addActionListener(MITAL);
            VF_R.getMI_DeleteTables().addActionListener(MITAL);
            
            //LOGIN +++++++++++++++++++++++++++++++++++++++++++
            VF_R.getMI_ChangeLogin().addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        System.out.println(CC.CYAN + "#### VL STARS ####" + CC.RESET);
                        new VL("Change");
                  }

            });
      }

}
