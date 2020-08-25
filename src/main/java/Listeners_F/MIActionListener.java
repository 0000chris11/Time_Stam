package Listeners_F;

import First.VF_R;
import MC.MethodM;
import MC.notMyMethods;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import MC.MakeCon;
import MC.Components;
import MC.DT;
import MC.MM;
import MC.Status;
import Others.CC;
import Others.LSTD;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Christopher
 */
public class MIActionListener implements ActionListener {

      //Data dt = new Data("MIActionListener");
      String CName = this.getClass().getName();
      
      //MethodM mm = new MethodM(CName, DT.CCount++);
      notMyMethods n_mm = new notMyMethods();
      Components cp = new Components(CName, DT.CCount++);
      LSTD lstd = new LSTD();
      MainListeners_F ml = new MainListeners_F();
      MakeCon mc = new MakeCon(CName, DT.CCount++);
      Status st = new Status();

      public MIActionListener() {

      }

      @Override
      public void actionPerformed(ActionEvent evt) {
            String ac = evt.getActionCommand();
            if (!ac.equals(DT.getTable().replaceAll("_", " "))) {

                  System.out.println(CC.GREEN + "\n MIActionListener STARS" + CC.RESET);
                  boolean change = false;

                  DT.setOld_id(DT.getId());
                  DT.bool_Sel = true;

                  System.out.println("MIActionListener ++++ resetingAfter");
                  resetingAfter();
                  VF_R.getMI_DeleteThisTable().setEnabled(true);

                  System.out.println("MIActionListener ++++ MCSelectATable");

                  if (ac.contains(":")) {
                        ac = ac.substring(ac.indexOf(":") + 2, ac.length());
                        System.out.println("\tcut: " + ac);
                        change = true;
                  }
                  //System.out.println("MIActionListener ++++ Table: " + DT.getTable());
                  DT.setTable(MM.filterTableName(ac, "ADD"));
                  //System.out.println("MIActionListener ++++ Table: " + dt.getTable());
                  mc.SelectATable(DT.getTable());
                  //dt.setTable(mm.filterTableName(ac, "ADD"));
                  //+++++++++++++++++++++++++++++++++++++++++++++++++++++++

                  System.out.println("MIActionListener ++++ Data");
                  System.out.println("\told id = " + DT.getOld_id());
                  System.out.println("\tcurrent id = " + DT.getId());
                  System.out.println("\tTable = " + DT.getTable());
                  System.out.println("\tDist1 = " + DT.getDist1());
                  System.out.println("\tDist2 = " + DT.getDist2());
                  System.out.println("\tTabl = " + DT.getTabl());
                  System.out.println("\tTag1 = " + DT.getTag());
                  System.out.println("\tClock = " + DT.getClock());
                  //++++++++++++++++++++++++++++++++++++++++++++++++++++
                  if (change == true) {
                        System.out.println("MIActionListener ++++ ChangeDefault");

                        mc.ChangeDefault(DT.getId(), DT.getOld_id(), DT.getTable(), DT.getDist1(),
                                DT.getDist2(), DT.getTabl(), DT.getTag(), DT.getClock());
                  }
                  //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
                  System.out.println("MIActionListener ++++ MCSelectColumns");
                  mc.SelectColumns(DT.getTable());
                  
                  System.out.println("MIActionListener ++++ ChangeLB_TF");
                  cp.changeLB_TF(VF_R.getJT().getColumnCount(), DT.getList_C());
                  VF_R.noRowsDetection();
                  
                  System.out.println("MIActionListener ++++ ChangeLSTD");
                  lstd.changeLSTD(DT.getTable(), DT.getDist1(), DT.getDist2(), DT.getTabl(),
                          DT.getTag(), DT.getClock());

                  VF_R.setColorToDItem(DT.getTable(), DT.getDTable());

                  System.out.println("MIActionListener ++++ addAllListener");
                  ml.addAllListenerLoop();

                  n_mm.rez(VF_R.getJT(), true);
                  System.out.println("MIActionListener ++++ setRenderer and editor");
                  VF_R.setTableRenderer();
                  for (int z = 0; z < VF_R.getJT().getColumnCount(); z++) {
                        VF_R.getJT().getColumnModel().getColumn(z).
                                setCellEditor(VF_R.getDTCellEditor());
                  }
                  new Thread() {
                        public void run() {
                              try {
                                    Thread.sleep(1000);
                              } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                              }
                              VF_R.getJT().setPreferredScrollableViewportSize(VF_R.getJT().getSize());
                              //System.out.println("JT preferredSize: " + VF_R.getJT().getSize());
                        }
                  }.start();
                  //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
                  System.out.print("MIActionListener ++++ LOAD Icon");
                  if (!DT.getTabl().equals("NONE")) {
                        System.out.println(CC.GREEN + "\tYES" + CC.RESET);
                        VF_R.getLB_Icon().setVisible(true);
                        VF_R.getLB_Icon().setText("Loading");
                        VF_R.getJT().setEnabled(false);
                  } else {
                        System.out.println(CC.RED + "\tNO" + CC.RESET);
                  }
                  DT.bool_Sel = false;
                  System.out.println(CC.GREEN + "\n MIActionListener ENDS" + CC.RESET);
            }else{
                  st.startLBStatus(VF_R.getLB_Status(), Color.YELLOW, 
                          "This Table is already selected", 3000);
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++++
      private void setBackgroundToTable() {
            JTable JT = VF_R.getJT();
            JT.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
                  @Override
                  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                        Component c = super.getTableCellRendererComponent(
                                table, value, isSelected, hasFocus, row, column);

                        c.setBackground(Color.BLUE);
                        return this;
                  }
            });
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++++
      private void resetingAfter() {
            VF_R.getJPB().setVisible(false);
            VF_R.getJPB().setForeground(Color.RED);
            VF_R.getJPB().setValue(0);

            VF_R.getBTN_Show_All().setSelected(false);
            //System.out.println("1: tf_3 background: " + tfs[2].getBackground());
            MM.resetTF_LB(VF_R.getJTFS()[0], null);
            for (int a = 1; a < 6; a++) {
                  MM.resetTF_LB(VF_R.getJTFS()[a], VF_R.getJLBS()[a]);
                  //System.out.println("TF_" + (a + 1) + " Width: " + tfs[1].getWidth());
                  VF_R.getJTFS()[a].setText("");
            }
            //System.out.println("2: tf_3 background: " + tfs[2].getBackground());
            for (int a = 2; a < 6; a++) {
                  VF_R.getJLBS()[a].setVisible(false);
                  VF_R.getJTFS()[a].setVisible(false);
            }

            VF_R.getJTFS()[0].requestFocus();
            //++++++++++++++++++++++++++++++++++++++
            DT.getDm_2().clear();
            DT.getDm_3().clear();
            DT.getDm_4().clear();
            DT.getDm_5().clear();
            DT.getDm_6().clear();

            DT.getListD_2().clear();
            DT.getListD_3().clear();
            DT.getListD_4().clear();
            DT.getListD_5().clear();
            DT.getListD_6().clear();
            DT.getList_S23().clear();
            DT.getList_S34().clear();
            DT.getList_S45().clear();
            DT.getList_S56().clear();
            //++++++++++++++++++++++++++++++++++++++
            for (int a = 0; a < VF_R.getTFS_MD().length; a++) {
                  MM.resetClock(VF_R.getTFS_MD()[a], VF_R.getTFS_MU()[a],
                          VF_R.getTFS_SD()[a], VF_R.getTFS_SU()[a], VF_R.getLB_2DS()[a]);
            }
            //+++++++++++++++++++++++++++++++++++++++
            //setBackgroundToTable();
      }
}