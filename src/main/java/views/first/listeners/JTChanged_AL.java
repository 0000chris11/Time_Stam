package views.first.listeners;

import MC.CompReset;
import MC.DT;
import MC.DTSQL;
import MC.Status;
import MC.notMyMethods;
import SQL.DefaultConnection;
import SQL.SQLQuerys;
import SQLActions.SelectATable;
import SQLActions.SelectColumns;
import SQLActions.SelectCurrentKeys;
import SQLActions.UpdateDefaultTable;
import SQLStores.TableDistC;
import others2.DISTS;

import com.cofii2.methods.MComp;
import com.cofii2.mysql.MSQL;
import com.cofii2.mysql.MSQL1;
import com.cofii2.stores.CC;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import views.first.MENU;
import views.first.VF_R;

/**
 *
 * @author C0FII
 */
public class JTChanged_AL implements ActionListener {

      //Data dt = new Data("JTChanged_AL");
      String CName = this.getClass().getName();

      //MethodM mm = new MethodM(CName, DT.CCount++);
      private static notMyMethods n_mm = new notMyMethods();
      private static CompReset cp = new CompReset();
      MainListeners_F ml = new MainListeners_F();

      private static MSQL ms = new MSQL(DTSQL.getURLConnection(), DTSQL.getUser(), DTSQL.getPassw());

      @Override
      public void actionPerformed(ActionEvent evt) {
            action(evt.getActionCommand());
      }

      public static void action(String ac){ 
            int id = TableDistC.getId();
            String table = TableDistC.getTable();
            String dist1 = TableDistC.getDist1();
            String dist2 = TableDistC.getDist2();
            String imageC = TableDistC.getImageC();
            String imageCPath = TableDistC.getImageCPath();
            String tag = TableDistC.getTag();
            String clock = TableDistC.getClock();
            
            if (!ac.equals(table.replaceAll("_", " ")) || VF_R.getDropAddColumn()) {
                  System.out.println(CC.GREEN + "\n### MIActionListener ###" + CC.RESET);
                  boolean change = false;
                  //SAVING PREVIOUS ID
                  DT.setOld_id(id);
                  DT.bool_Sel = true;
                  //++++++++++++++++++++++++++++++++++++++++++++++++++++
                  System.out.println("\tMIActionListener ++++ resetingAfter");
                  resetingAfter();
                  VF_R.getMI_DeleteThisTable().setEnabled(true);

                  System.out.println("\tMIActionListener ++++ MCSelectATable");
                  if (ac.contains(":")) {
                        ac = ac.substring(ac.indexOf(":") + 2, ac.length());
                        System.out.println("\tcut: " + ac);
                        change = true;
                  }

                  table = ac;
                  ms.selectRowFromTable(DTSQL.mainTable, DTSQL.mainTableColumns[1], table.replaceAll("_", " "),
                          new SelectATable());
                  SQLQuerys.setTableForCurrentKeys(table.replaceAll(" ", "_"));
                  MSQL1 ms1 = new MSQL1(new DefaultConnection());
                  ms1.select(SQLQuerys.SELECT_KEYS_FROM_CURRENT, new SelectCurrentKeys());
                  //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
                  System.out.println("\t\told id = " + DT.getOld_id());
                  System.out.println("\t\tcurrent id = " + TableDistC.getId());
                  System.out.println("\t\tTable = " + table);
                  System.out.println("\t\tDist1 = " + dist1);
                  System.out.println("\t\tDist2 = " + dist2);
                  System.out.println("\t\tImageC = " + imageC);
                  System.out.println("\t\tImageCPath = " + imageCPath);
                  System.out.println("\t\tTag1 = " + tag);
                  System.out.println("\t\tClock = " + clock);
                  //++++++++++++++++++++++++++++++++++++++++++++++++++++
                  if (change) {
                        System.out.println(CC.CYAN + "MIActionListener ++++ ChangeDefault" + CC.RESET);

                        ms.updateRow(DTSQL.defautlTable, 
                                DTSQL.mainTableColumns, TableDistC.toArray(), 1, new UpdateDefaultTable());
                  }
                  //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
                  System.out.println("\tMIActionListener ++++ MCSelectColumns");
                  //ms.SelectColumns(DT.getTable());
                  ms.selectColumns(table, new SelectColumns());
                  //+++++++++++++++++++++++++++++++++++++++++
                  System.out.println("\tMIActionListener ++++ ChangeLB_TF and Select Data");
                  cp.changeLB_TFandSelectData(VF_R.getJT().getColumnCount(), DT.getList_C());
                  MComp.setCustomTableCellRenderer(VF_R.getJT());
                  MComp.setCustomTableCellEditor(VF_R.getJT());
                  //VF_R.noRowsDetection();
                  VF_R.getSPL().setDividerLocation(0.4);
                  VF_R.getPL_UC().revalidate();
                  //+++++++++++++++++++++++++++++++++++++++++         
                  DISTS.start(true, true);

                  MENU.setColorToDItem(table, DT.getDTable());
                  n_mm.rez(VF_R.getJT(), true);
                  //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
                  DT.bool_Sel = false;
                  System.out.println(CC.GREEN + "\nMIActionListener ENDS" + CC.RESET);

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

      private static void resetingAfter() {
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
