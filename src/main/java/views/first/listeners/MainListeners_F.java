package views.first.listeners;

import MC.DT;
import MC.MainInstances;
import MC.Status;
import com.cofii2.stores.CC;
import com.cofii2.methods.MComp;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import views.Login.VL;
import views.first.VF_R;
import views.mainTable.VMT;
import views.mainTable.VMT_DataCom;

/**
 *
 * @author Christopher
 */
public class MainListeners_F {

      public void addAllListener() {
            VF_R.getJT().getModel().addTableModelListener(new JT_ML());
            VF_R.getJT().getSelectionModel().addListSelectionListener(new JT_LSL());

            addFocusBorderToJC_PC();
            addMouseListenerToTFS();

            addKeyListenersToTFS();
            addKeyListenersToCKS();
            addChangeListenerToCB();

            addActionListenersToMIS();

            addActionListenerToBTNS_MC();
            addActionListenerToBTNS_P_M();

            addMouseListenerToBTN_C();
      }

      //++++++++++++++++++++++++++++++++++++++++++++
      private void addMouseListenerToTFS() {
            BTNS_CMouseListener ML = new BTNS_CMouseListener();
            for (int a = 0; a < DT.maxColumns; a++) {
                  VF_R.getJTFES()[a].addMouseListener(ML);
                  VF_R.getJTFS()[a].addMouseListener(ML);
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++
      private void addMouseListenerToBTN_C() {
            BTNS_CMouseListener BTNCML = new BTNS_CMouseListener();
            for (JButton x : VF_R.getBTNS_C()) {
                  x.addMouseListener(BTNCML);
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
            for (int a = 0; a < DT.maxColumns; a++) {
                  //VF_R.getJTFES()[a].addFocusListener(new FocusBorderCustom());//BORDER STUCKED WHEN FOCUS
                  VF_R.getJTFS()[a].addFocusListener(new FocusBorder());
                  //VF_R.getJLSTS()[a].addFocusListener(jcfl);
                  VF_R.getTFS_MD()[a].addFocusListener(new FocusBorder());
                  VF_R.getTFS_MU()[a].addFocusListener(new FocusBorder());
                  VF_R.getTFS_SD()[a].addFocusListener(new FocusBorder());
                  VF_R.getTFS_SU()[a].addFocusListener(new FocusBorder());
            }
      }

      private void addChangeListenerToCB() {
            /*
            System.out.println("#########PopupMenu: " + VF_R.getJCBS()[0].getComponentPopupMenu().toString());
            System.out.println("#########PopupMenu: " + VF_R.getJCBS()[0]);
            System.out.println("#########PopupMenu's SelectionModel: " + 
                    VF_R.getJCBS()[0].getComponentPopupMenu().getSelectionModel().toString());
            
            for (JComboBox x : VF_R.getJCBS()) {
                  x.getComponentPopupMenu().getSelectionModel().addChangeListener(new ChangeListener(){
                        @Override
                        public void stateChanged(ChangeEvent e) {
                              System.out.println("CHANGELISTENER " + e.getSource().getClass().getName());
                        }
                        
                  });
            }
             */
      }

      //++++++++++++++++++++++++++++++++++++++++++++
      private void addKeyListenersToTFS() {
            //TFS_KL tkt = new TFS_KL();
            for (int a = 0; a < DT.maxColumns; a++) {
                  VF_R.getJTFS()[a].addKeyListener(new TF_KL_Custom(VF_R.getJTFS()[a]));

                  VF_R.getJTFES()[a].addKeyListener(new TF_KL_Custom(
                          VF_R.getJCBS()[a], VF_R.getJTFES()[a]));

            }
      }

      private void addKeyListenersToCKS() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  JTextField[] clock = MComp.getClock(
                          VF_R.getTFS_MD()[a], VF_R.getTFS_MU()[a], VF_R.getTFS_SD()[a], VF_R.getTFS_SU()[a]);

                  CK_KL_Custom KL = new CK_KL_Custom(clock);

                  for (JComponent x : clock) {
                        x.addKeyListener(KL);
                  }
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
            //TABLES INFO +++++++++++++++++++++++++++++++++++++
            VF_R.getMI_ShowTablesInfo().addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        System.out.println(CC.CYAN + "#### VMT STARS ###" + CC.RESET);
                        if (MainInstances.getVMT() == null) {
                              MainInstances.setVMT_DataCom(new VMT_DataCom());
                              MainInstances.setVMT(new VMT());
                        }else{
                              Status.startLBStatus(VF_R.getLB_Status(), Color.YELLOW, "Main Table Window is already open", 4000);
                        }
                  }

            });
      }

}
