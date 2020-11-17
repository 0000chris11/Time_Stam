package First.Listeners;

import First.Listeners.MainListeners_F;
import First.VF_R;
import MC.notMyMethods;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import MC.MakeCon;
import MC.CompReset;
import MC.DT;
import SQLActions.SelectColumns;
import MC.Status;
import com.cofii.myMethods.MText;
import com.cofii.myClasses.CC;
import Others.LSTD;
import SQLActions.SelectATable;
import com.cofii.myClasses.MSQL;
import com.cofii.myInterfaces.IActions;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Christopher
 */
public class JTChanged_AL implements ActionListener {

      //Data dt = new Data("JTChanged_AL");
      String CName = this.getClass().getName();

      //MethodM mm = new MethodM(CName, DT.CCount++);
      notMyMethods n_mm = new notMyMethods();
      CompReset cp = new CompReset();
      LSTD lstd = new LSTD();
      MainListeners_F ml = new MainListeners_F();

      MakeCon mc = new MakeCon(CName, DT.CCount++);
      MSQL ms = new MSQL(DT.urlConnection, DT.user, DT.passw);

      @Override
      public void actionPerformed(ActionEvent evt) {
            String ac = evt.getActionCommand();
            if (!ac.equals(DT.getTable().replaceAll("_", " "))) {
                  System.out.println(CC.GREEN + "\n MIActionListener STARS" + CC.RESET);
                  boolean change = false;
                  //SAVING PREVIOUS ID
                  DT.setOld_id(DT.getId());
                  DT.bool_Sel = true;
                  //++++++++++++++++++++++++++++++++++++++++++++++++++++
                  System.out.println("MIActionListener ++++ resetingAfter");
                  resetingAfter();
                  VF_R.getMI_DeleteThisTable().setEnabled(true);

                  System.out.println("MIActionListener ++++ MCSelectATable");
                  if (ac.contains(":")) {
                        ac = ac.substring(ac.indexOf(":") + 2, ac.length());
                        System.out.println("\tcut: " + ac);
                        change = true;
                  }
                  
                  DT.setTable(MText.filterTextName(ac, "ADD"));//DELETE
                  ms.selectRowFromTable(DT.mainTable, DT.mainColumn, DT.getTable().replaceAll("_", " "), 
                          new SelectATable());
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
                  //ms.SelectColumns(DT.getTable());
                  ms.selectColumns(DT.getTable(), new SelectColumns());

                  System.out.println("MIActionListener ++++ ChangeLB_TF");
                  cp.changeLB_TFandSelectData(VF_R.getJT().getColumnCount(), DT.getList_C());
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

            } else {
                  Status.startLBStatus(VF_R.getLB_Status(), Color.YELLOW,
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
      private static void resetTF_LB(JTextField tf, JLabel lb) {
            tf.setBackground(new Color(51, 51, 51));
            tf.setSize(290, tf.getHeight());

            String l = lb.getText();
            if (l.contains("*")) {//?????????
                  lb.setText(l.substring(l.indexOf("*") + 1, l.length()));
            }

      }

      private static void resetClock(JTextField MD, JTextField MU,
              JTextField SD, JTextField SU) {
            MD.setText("0");
            MU.setText("0");
            SD.setText("0");
            SU.setText("0");
      }

      private void resetingAfter() {
            VF_R.getJPB().setVisible(false);
            VF_R.getJPB().setForeground(Color.RED);
            VF_R.getJPB().setValue(0);

            VF_R.getBTN_Show_All().setSelected(false);
            //CHANGE LB & TFS TO ITS ORIGINAL LOOK
            for (int a = 0; a < DT.maxColumns; a++) {
                  resetTF_LB(VF_R.getJTFS()[a], VF_R.getJLBS()[a]);
                  //System.out.println("TF_" + (a + 1) + " Width: " + tfs[1].getWidth());
                  VF_R.getJTFS()[a].setText("");
            }
            //HIDING LBS AND TFS FOR NEXT TABLE-SELECTION
            for (int a = 0; a < DT.maxColumns; a++) {
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
            for (int a = 0; a < DT.maxColumns; a++) {
                  VF_R.getClocks()[a].setVisible(false);

                  resetClock(VF_R.getTFS_MD()[a], VF_R.getTFS_MU()[a],
                          VF_R.getTFS_SD()[a], VF_R.getTFS_SU()[a]);
            }
            //+++++++++++++++++++++++++++++++++++++++
            //setBackgroundToTable();
      }
}
