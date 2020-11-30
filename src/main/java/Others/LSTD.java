package Others;

import views.first.VF_R;
import MC.DT;
import MC.DTSQL;
import Threads.Threads;
import SQLActions.SelectDistinctColumn;
import SQLActions.SelectDistinctColumns;
import com.cofii.myClasses.MSQL;
import com.cofii.myMethods.MList;
import com.cofii.myMethods.MText;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;

/**
 *
 * @author C0FII
 */
public class LSTD {

      //Data dt = new Data("LSTD");
      String CName = this.getClass().getName();

      //MethodM mm = new MethodM(CName, DT.CCount++);
      Threads th = new Threads(CName, DT.CCount++);
      MSQL ms = new MSQL(DTSQL.getURLConnection(), DTSQL.getUser(), DTSQL.getPassw());

      public void changeLSTD(String table, String D1, String D2, String IC, String TG1,
              String CK) {

            DT.setTable(MText.filterTextName(DT.getTable(), "ADD"));
            System.out.println("\tTable: " + table);
            System.out.println("\tD1: " + D1);
            System.out.println("\tD2: " + D2);
            System.out.println("\tTB: " + IC);
            System.out.println("\tTG1: " + TG1);
            System.out.println("\tCK: " + CK);

            filterEquals("Dist1", D1);
            filterEquals("Dist2", D2);
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //System.out.println("Tabl = " + TB);
            if (IC.equals("NONE")) {
                  //System.out.println("'\nTB = NOTHING");
                  VF_R.getLB_Icon().setIcon(null);
                  VF_R.getLB_Icon().setText("No image for col");
                  VF_R.getLB_Icon().setVisible(true);
                  VF_R.getSPL_SUB().setDividerLocation(1.0);
            } else if (IC.contains("C")) {//IMAGE
                  //System.out.println(CC.RED + "TEST: "+ TB + CC.RESET);
                  VF_R.getSPL_SUB().setDividerLocation(0.5);
                  VF_R.getLB_Icon().setText("Loading");
                  VF_R.getJT().setEnabled(false);
                  JTCellRenderer.setForegroundCell(Color.GRAY);
                  th.addLBIconThread(IC);
            }
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //System.out.println("TG1 = " + TG1);
            filterEquals("Tag1", TG1);
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //System.out.println("TG2 = " + TG2);
            changeCK(CK);
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            int pk = DT.getPrimaryKey();
            System.out.println("\tPrimary key: C" + pk);
            if(DT.getPrimaryKey() > 0){
                  VF_R.getJLBS()[pk - 1].setForeground(Color.YELLOW.darker());
            }else{
                  for(JLabel x: VF_R.getJLBS()){
                        x.setForeground(Color.WHITE);
                  }
            }
      }

      private void changeLSTDist1(int index, String table, String col) {
            boolean vis;//NO ADDING THE ELEMENTS AGAIN

            System.out.println("changeLSTDist1");
            System.out.println("\tindex: " + index);
            System.out.println("\ttable: " + table);
            System.out.println("\tcol: " + col);

            for (int a = 0; a < DT.maxColumns; a++) {
                  if (index + 1 == a + 1) {
                        vis = true;
                        if (VF_R.getJTFS()[a].getBackground().equals(DT.TFColor[1])) {
                              vis = false;
                        }

                        VF_R.getJTFS()[a].setBackground(DT.TFColor[1]);
                        //+++++++++++++++++++++++++++++++++++++++++++++++
                        SelectDistinctColumn sdc = new SelectDistinctColumn(DT.getList_DS()[a]);
                        ms.selectDistinctColumn(table, col, sdc);
                        if (sdc.rsValues) {
                              //mc.MCInsertSelectD1(table, col, DT.getList_DS()[a]);//listDs[a + 2]
                              MList.unTagList(DT.getList_DS()[a]);
                              MList.add_SetDefaultListModel(VF_R.getJLSTS()[a], DT.getList_DS()[a], vis);//dms[a + 2]
                        } else {
                              System.out.println("\tno elements distinct");
                        }
                  }
            }
      }

      private void changeLSTDist2(int fll1, int fll2, String table, String col1, String col2) {
            boolean vis = true;
            //System.out.println("\nchangeLSTDist2");
            for (int a = 0; a < DT.maxColumns - 1; a++) {
                  if (fll1 + 1 == a + 1 && fll2 + 1 == a + 2) {
                        //System.out.println("\ta: " + a);
                        if (VF_R.getJTFS()[a + 1].getBackground().equals(DT.TFColor[2])) {
                              vis = false;
                        }

                        VF_R.getJTFS()[a + 1].setBackground(DT.TFColor[2]);

                        SelectDistinctColumns sdc = new SelectDistinctColumns(DT.getList_DS()[a], DT.getList_DS()[a + 1]);
                        ms.selectDistinctColumns(table, new String[]{col1, col2}, col1, sdc);
                        if (sdc.rsValues) {
                              //mc.MCInsertSelectD2(table, col1, col2, DT.getList_DS()[a], DT.getList_DS()[a + 1]);//listDs[a + 2] & listDs[a + 3]
                              DT.getList_MXS()[a] = MList.mixRowList(DT.getList_DS()[a], DT.getList_DS()[a + 1], ": ");//listSs[a + 2]
                              MList.unTagList(DT.getList_MXS()[a]);//listSs[a + 2]
                              MList.add_SetDefaultListModel(VF_R.getJLSTS()[a + 1], DT.getList_MXS()[a], vis);//dms[a + 3]
                        }else{
                              System.out.println("\tno elements distinct (multiple columns)");
                        }
                  }
            }
      }

      private void changeLSTDTag(int fll) {
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (fll == a) {
                        if (!VF_R.getJLBS()[a].getText().contains("*")) {
                              VF_R.getJLBS()[a].setText("*" + VF_R.getJLBS()[a].getText());
                              MText.shortenLB(VF_R.getJLBS()[a]);
                        }
                  }
            }
      }

      private void changeCK(String CK) {
            if (!CK.equals("NONE")) {
                  //DT.chars[0] = CK.charAt(1);// COL NUM
                  //DT.strings[0] = Character.toString(DT.chars[0]);
                  //DT.ints[0] = Integer.parseInt(DT.strings[0]) - 1;//EX: 6 IS 5
                  int col = Character.getNumericValue(CK.charAt(1)) - 1;
                  System.out.println("\t####COL VALUE: " + col + " (CK: " + CK + ")");

                  for (int a = 0; a < DT.maxColumns; a++) {
                        if (a == col) {
                              System.out.println("\t\t###a: " + col);
                              if (VF_R.getJTFS()[a].getWidth() == 290) {
                                    VF_R.getJTFS()[a].setSize(160,
                                            VF_R.getJTFS()[a].getHeight());
                              }

                              VF_R.getClocks()[a].setVisible(true);
                              /*
                              VF_R.getTFS_MD()[a].setVisible(true);
                              VF_R.getTFS_MU()[a].setVisible(true);
                              VF_R.getTFS_SD()[a].setVisible(true);
                              VF_R.getTFS_SU()[a].setVisible(true);
                              VF_R.getLB_2DS()[a].setVisible(true);
                               */
                        } else {
                              VF_R.getJTFS()[a].setSize(290, VF_R.getJTFS()[a].getHeight());

                              VF_R.getClocks()[a].setVisible(false);
                              /*
                              VF_R.getTFS_MD()[a].setVisible(false);
                              VF_R.getTFS_MU()[a].setVisible(false);
                              VF_R.getTFS_SD()[a].setVisible(false);
                              VF_R.getTFS_SU()[a].setVisible(false);
                              VF_R.getLB_2DS()[a].setVisible(false);
                               */
                        }
                  }
            } else {
                  for (int a = 0; a < DT.maxColumns; a++) {
                        VF_R.getJTFS()[a].setSize(290, VF_R.getJTFS()[a].getHeight());
                        VF_R.getTFS_MD()[a].setVisible(false);
                        VF_R.getTFS_MU()[a].setVisible(false);
                        VF_R.getTFS_SD()[a].setVisible(false);
                        VF_R.getTFS_MU()[a].setVisible(false);
                        VF_R.getLB_2DS()[a].setVisible(false);
                  }
            }
      }

      private void filterEquals(String filter, String FL) {
            //System.out.println("\nfilterEquals (max Column - 1 = " + (dt.maxColumns - 1));
            System.out.println("Filter: " + filter);
            System.out.println("FL: " + FL);
            for (int a = 0; a < DT.maxColumns - 1; a++) {
                  //System.out.println("\ta = " + a);
                  if (FL.equals("NONE")) {
                        //System.out.println("\t\t" + filter + " at NONE " + " (" + FL + ")");
                        //System.out.println("\tFL.contains(\"X" +);
                  } else if (FL.contains("X" + (a + 1))) {
                        //System.out.println("\t\t" + filter + " at X" + (a + 1) + " (" + FL + ")");
                        int d = 2;
                        for (int b = 0; b < a + 1; b++) {
                              DT.ints[b] = Character.getNumericValue(FL.charAt(FL.indexOf(":") + d)) - 1;
                              DT.cols[b] = DT.getList_C().get(DT.ints[b]);
                              d += 2;
                        }
                        if (filter.equals("Dist1")) {
                              //System.out.println("\t\tDist1");
                              for (int b = 0; b < a + 1; b++) {
                                    changeLSTDist1(DT.ints[b], DT.getTable(), DT.cols[b]);
                              }
                        } else if (filter.equals("Dist2")) {
                              int c = 4;
                              int e = 0;
                              for (int b = a + 1; b < (a + 1) * 2; b++) {
                                    //4-6-8-12 -- 4-8-12-16        
                                    DT.ints[b] = Character.getNumericValue(FL.charAt(FL.indexOf(":") + c)) - 1;
                                    DT.cols[b] = DT.getList_C().get(DT.ints[b]);
                                    c += 4;

                                    changeLSTDist2(DT.ints[e++], DT.ints[e--], DT.getTable(),
                                            DT.cols[e++], DT.cols[e++]);
                              }
                        } else if (filter.equals("Tag1")) {
                              for (int b = 0; b < a + 1; b++) {
                                    changeLSTDTag(DT.ints[b]);
                              }
                        }
                  }
            }
      }
}
