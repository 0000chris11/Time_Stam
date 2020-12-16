package views.first.listeners;

import views.first.listeners.MainListeners_F;
import views.first.VF_R;
import MC.notMyMethods;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import MC.CompReset;
import MC.DT;
import MC.DTSQL;
import SQLActions.SelectColumns;
import MC.Status;
import MC.TableInfoC;
import com.cofii.myMethods.MText;
import com.cofii.myClasses.CC;
import Others.LSTD;
import SQLActions.SelectATable;
import SQLActions.UpdateDefaultTable;
import com.cofii.myClasses.MSQL;
import com.cofii.myInterfaces.IActions;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
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

      MSQL ms = new MSQL(DTSQL.getURLConnection(), DTSQL.getUser(), DTSQL.getPassw());

      @Override
      public void actionPerformed(ActionEvent evt) {
            String ac = evt.getActionCommand();
            
            int id = TableInfoC.getId();
            String table = TableInfoC.getTable();
            String dist1 = TableInfoC.getDist1();
            String dist2 = TableInfoC.getDist2();
            String imageC = TableInfoC.getImageC();
            String tag = TableInfoC.getTag();
            String clock = TableInfoC.getClock();
            
            if (!ac.equals(table.replaceAll("_", " "))) {
                  System.out.println(CC.GREEN + "\n MIActionListener STARS" + CC.RESET);
                  boolean change = false;
                  //SAVING PREVIOUS ID
                  DT.setOld_id(id);
                  DT.bool_Sel = true;
                  //++++++++++++++++++++++++++++++++++++++++++++++++++++
                  System.out.println(CC.CYAN + "MIActionListener ++++ resetingAfter" + CC.RESET);
                  resetingAfter();
                  VF_R.getMI_DeleteThisTable().setEnabled(true);

                  System.out.println(CC.CYAN + "MIActionListener ++++ MCSelectATable" + CC.RESET);
                  if (ac.contains(":")) {
                        ac = ac.substring(ac.indexOf(":") + 2, ac.length());
                        System.out.println("\tcut: " + ac);
                        change = true;
                  }

                  table = ac;
                  ms.selectRowFromTable(DTSQL.mainTable, DTSQL.mainTableColumns[1], table.replaceAll("_", " "),
                          new SelectATable());
                  //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
                  System.out.println("MIActionListener ++++ Data");
                  System.out.println("\told id = " + DT.getOld_id());
                  System.out.println("\tcurrent id = " + TableInfoC.getId());
                  System.out.println("\tTable = " + table);
                  System.out.println("\tDist1 = " + dist1);
                  System.out.println("\tDist2 = " + dist2);
                  System.out.println("\tImageC = " + imageC);
                  System.out.println("\tTag1 = " + tag);
                  System.out.println("\tClock = " + clock);
                  //++++++++++++++++++++++++++++++++++++++++++++++++++++
                  if (change == true) {
                        System.out.println(CC.CYAN + "MIActionListener ++++ ChangeDefault" + CC.RESET);

                        ms.updateRow(DTSQL.defautlTable, 
                                DTSQL.mainTableColumns, TableInfoC.toArray(), 1, new UpdateDefaultTable());
                  }
                  //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
                  System.out.println(CC.CYAN + "MIActionListener ++++ MCSelectColumns" + CC.RESET);
                  //ms.SelectColumns(DT.getTable());
                  ms.selectColumns(table, new SelectColumns());

                  //+++++++++++++++++++++++++++++++++++++++++
                  System.out.println(CC.CYAN + "MIActionListener ++++ ChangeLB_TF and Select Data" + CC.RESET);
                  cp.changeLB_TFandSelectData(VF_R.getJT().getColumnCount(), DT.getList_C());
                  //VF_R.noRowsDetection();
                  VF_R.getSPL().setDividerLocation(0.4);
                  VF_R.getPL_UC().revalidate();
                  //+++++++++++++++++++++++++++++++++++++++++

                  System.out.println(CC.CYAN + "MIActionListener ++++ ChangeLSTD" + CC.RESET);
                  lstd.changeLSTD();

                  VF_R.setColorToDItem(table, DT.getDTable());

                  System.out.println(CC.CYAN + "MIActionListener ++++ addAllListener (DELETE)" + CC.RESET);

                  n_mm.rez(VF_R.getJT(), true);
                  System.out.println(CC.CYAN + "MIActionListener ++++ setRenderer and editor (DELETE?)" + CC.RESET);
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
                  System.out.print(CC.CYAN + "MIActionListener ++++ LOAD Icon" + CC.RESET);
                  if (!TableInfoC.getImageC().equals("NONE")) {
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
      private static void resetTF_LB(JComboBox cb, JLabel lb) {
            cb.setBackground(new Color(51, 51, 51));
            cb.setSize(290, cb.getHeight());

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
                  resetTF_LB(VF_R.getJCBS()[a], VF_R.getJLBS()[a]);
                  VF_R.getJCBS()[a].setSelectedItem("");
                  //HIDING LBS AND TFS FOR NEXT TABLE-SELECTION
                  VF_R.getJLBS()[a].setVisible(false);
                  VF_R.getJCBS()[a].setVisible(false);
                  //LISTS+++++++++++++++++++++++++++
                  DT.getList_DS()[a].clear();
                  if (a != DT.maxColumns - 1) {
                        DT.getList_MXS()[a].clear();
                  }
                  DT.getDLMS()[a].clear();
                  //CLOCK+++++++++++++++++++++++
                  VF_R.getTFS_MD()[a].setVisible(false);
                  VF_R.getTFS_MU()[a].setVisible(false);
                  VF_R.getLB_2DS()[a].setVisible(false);
                  VF_R.getTFS_SD()[a].setVisible(false);
                  VF_R.getTFS_SU()[a].setVisible(false);
                  
                  resetClock(VF_R.getTFS_MD()[a], VF_R.getTFS_MU()[a],
                          VF_R.getTFS_SD()[a], VF_R.getTFS_SU()[a]);
            }

            //VF_R.getJTFES()[0].requestFocus();

      }
}
