package Others;

import views.first.VF_R;
import MC.DT;
import MC.LKCustom;
import MC.DTSQL;
import MC.TableInfoC;
import Threads.Threads;
import SQLActions.SelectDistinctColumn;
import SQLActions.SelectDistinctColumns;
import com.cofii.myClasses.MSQL;
import com.cofii.myMethods.MList;
import com.cofii.myMethods.MText;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;

/**
 *
 * @author C0FII
 */
public class LSTD {

      String CName = this.getClass().getName();

      //MethodM mm = new MethodM(CName, DT.CCount++);
      Threads th = new Threads(CName, DT.CCount++);
      MSQL ms = new MSQL(DTSQL.getURLConnection(), DTSQL.getUser(), DTSQL.getPassw());
      
      private String table;
      private String dist1;
      private String dist2;
      private String imageC;
      private String tag;
      private String clock;

      public void changeLSTD() {
            this.table = TableInfoC.getTable();
            this.dist1 = TableInfoC.getDist1();
            this.dist2 = TableInfoC.getDist2();
            this.imageC = TableInfoC.getImageC();
            this.tag = TableInfoC.getTag();
            this.clock = TableInfoC.getClock();

            table = table.replaceAll(" ", "_");
            System.out.println("Table: " + table);
            System.out.println("D1: " + dist1);
            System.out.println("D2: " + dist2);
            System.out.println("IC: " + imageC);
            System.out.println("TG1: " + tag);
            System.out.println("CK: " + clock);
            //+++++++++++++++++++++++++++++++++++++++
            extraConfig();
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            filterEquals("Dist1", dist1);
            filterEquals("Dist2", dist2);
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //System.out.println("Tabl = " + TB);
            if (imageC.equals("NONE")) {
                  //System.out.println("'\nTB = NOTHING");
                  VF_R.getLB_Icon().setIcon(null);
                  VF_R.getLB_Icon().setText("No image for col");
                  //VF_R.getLB_Icon().setVisible(true);
                  VF_R.getSPL_SUB().setDividerLocation(1.0);
            } else if (imageC.contains("C")) {//IMAGE
                  //System.out.println(CC.RED + "TEST: "+ TB + CC.RESET);
                  VF_R.getSPL_SUB().setDividerLocation(0.5);
                  VF_R.getLB_Icon().setText("Loading");
                  VF_R.getJT().setEnabled(false);
                  VF_R.getJT().setForeground(Color.GRAY);//TEST IF NOT WORK USE
                  //MComp setForground
                  th.addLBIconThread(imageC);
            }
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //System.out.println("TG1 = " + TG1);
            filterEquals("Tag1", tag);
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //System.out.println("TG2 = " + TG2);
            changeCK(clock);
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

      }

      private void extraConfig() {
            int pk = DT.getPrimaryKey();
            System.out.println("Primary key: C" + pk);
            if (DT.getPrimaryKey() > 0) {
                  for (int a = 0; a < DT.maxColumns; a++) {
                        if (a == pk - 1) {
                              VF_R.getJLBS()[a].setForeground(Color.YELLOW);
                              if (VF_R.getJTFPanel()[a].getComponent(0).getName().contains("CB")) {
                                    VF_R.getJTFPanel()[a].remove(VF_R.getJCBS()[a]);
                                    VF_R.getJTFPanel()[a].add(VF_R.getJTFS()[a], 0);
                              }
                              VF_R.getJTFS()[a].setBackground(LKCustom.BK_PK);
                        } else {
                              VF_R.getJLBS()[a].setForeground(Color.WHITE);
                        }
                  }
            } else {
                  for (JLabel x : VF_R.getJLBS()) {
                        x.setForeground(Color.WHITE);
                  }
            }

            int extra = (int) DT.getExtra()[0];
            System.out.println("Extra: C" + extra);
            if (extra > 0) {
                  for (int a = 0; a < DT.maxColumns; a++) {
                        if (a == extra - 1) {
                              //VF_R.getJCBS()[a].removeAllItems();
                              VF_R.getJTFS()[a].setBackground(LKCustom.BK_AUTO_INCR_IDEN);
                              VF_R.getJTFS()[a].setFont(LKCustom.FONT_AUTO_INCREMENT);
                              String extraT = DT.getExtra()[1].toString();
                              if (extraT.equalsIgnoreCase("AUTO_INCREMENT")) {
                                    System.out.println("\tAUTO_INCREMENT");
                                    VF_R.getJTFS()[a].setEnabled(false);
                                    VF_R.getJTFS()[a].setText(LKCustom.TEXT_AUTO_INCREMENT);
                              } else if (extraT.equalsIgnoreCase("IDENTITY")) {
                                    System.out.println("\tIDENTITY");
                                    VF_R.getJTFS()[a].setEnabled(false);
                                    VF_R.getJTFS()[a].setText(LKCustom.TEXT_IDENTITY);
                              } else {
                                    VF_R.getJTFS()[a].setEnabled(true);
                                    VF_R.getJTFS()[a].setText("");
                                    System.out.println("\tNONE");
                              }
                        } else {
                              VF_R.getJCBS()[a].setEnabled(true);

                              VF_R.getJTFS()[a].setBackground(LKCustom.BK_NORMAL);
                              VF_R.getJTFS()[a].setFont(LKCustom.FONT_NORMAL);
                              VF_R.getJTFS()[a].setText("");

                              VF_R.getJTFES()[a].setBackground(LKCustom.BK_NORMAL);
                              VF_R.getJTFES()[a].setFont(LKCustom.FONT_NORMAL);
                              VF_R.getJTFES()[a].setText("");
                        }
                  }
            } else {
                  for (int a = 0; a < DT.maxColumns; a++) {
                        if (pk == 0) {
                              VF_R.getJTFS()[a].setBackground(LKCustom.BK_NORMAL);
                              VF_R.getJTFS()[a].setFont(LKCustom.FONT_NORMAL);
                              VF_R.getJTFS()[a].setForeground(Color.WHITE);
                              VF_R.getJTFS()[a].setText("");
                              VF_R.getJTFS()[a].setEnabled(true);
                        }
                  }
            }
      }

      private void changeLSTDist1(int index, String table, String col) {
            boolean vis;//NO ADDING THE ELEMENTS AGAIN

            System.out.println("\nchangeLSTDist1");
            System.out.println("\tindex: " + index);
            System.out.println("\ttable: " + table);
            System.out.println("\tcol: " + col);

            for (int a = 0; a < DT.maxColumns; a++) {
                  if (index + 1 == a + 1) {
                        if (VF_R.getJTFPanel()[a].getComponent(0).getName().contains("TF")) {
                              VF_R.getJTFPanel()[a].remove(VF_R.getJTFS()[a]);
                              VF_R.getJTFPanel()[a].add(VF_R.getJCBS()[a], 0);
                        }
                        vis = true;
                        if (VF_R.getJTFES()[a].getBackground().equals(LKCustom.BK_DIST1)) {
                              vis = false;
                        }

                        VF_R.getJCBS()[a].setPreferredSize(new Dimension());
                        VF_R.getJTFES()[a].setBackground(LKCustom.BK_DIST1);
                        //+++++++++++++++++++++++++++++++++++++++++++++++
                        SelectDistinctColumn sdc = new SelectDistinctColumn(DT.getList_DS()[a]);
                        ms.selectDistinctColumn(table, col, sdc);
                        if (sdc.rsValues) {
                              //mc.MCInsertSelectD1(table, col, DT.getList_DS()[a]);//listDs[a + 2]
                              System.out.println("\tElements To Distinct");
                              MList.unTagList(DT.getList_DS()[a]);
                              //MList.add_SetDefaultListModel(VF_R.getJLSTS()[a], DT.getList_DS()[a], vis);//dms[a + 2]
                              MList.add_SetListModel(VF_R.getJCBS()[a], DT.getList_DS()[a]);
                              VF_R.getJCBS()[a].setPreferredSize(new Dimension());
                        } else {
                              System.out.println("\tno elements distinct");
                        }
                  }
            }
      }

      private void changeLSTDist2(int fll1, int fll2, String table, String col1, String col2) {
            System.out.println("\tfll1: " + fll1 + ", fll2: " + fll2 + ", table: " + table + ", col1: " + col1 + ", col2: " + col2);
            boolean vis = true;
            //System.out.println("\nchangeLSTDist2");
            for (int a = 0; a < DT.maxColumns - 1; a++) {
                  if (fll1 + 1 == a + 1 && fll2 + 1 == a + 2) {
                        //System.out.println("\ta: " + a);
                        if (VF_R.getJTFPanel()[a].getComponent(0).getName().contains("CB")) {
                              VF_R.getJTFPanel()[a].remove(VF_R.getJCBS()[a]);
                              VF_R.getJTFPanel()[a].add(VF_R.getJTFS()[a], 0);
                        }
                        if (VF_R.getJTFPanel()[a + 1].getComponent(0).getName().contains("TF")) {
                              VF_R.getJTFPanel()[a + 1].remove(VF_R.getJTFS()[a + 1]);
                              VF_R.getJTFPanel()[a + 1].add(VF_R.getJCBS()[a + 1], 0);
                        }

                        if (VF_R.getJTFES()[a + 1].getBackground().equals(LKCustom.BK_DIST2)) {
                              vis = false;
                        }

                        VF_R.getJTFS()[a].setBackground(LKCustom.BK_DIST2);
                        VF_R.getJTFES()[a + 1].setBackground(LKCustom.BK_DIST2);

                        SelectDistinctColumns sdc = new SelectDistinctColumns(DT.getList_DS()[a], DT.getList_DS()[a + 1]);
                        ms.selectDistinctColumns(table, new String[]{col1, col2}, col1, sdc);
                        if (sdc.rsValues) {
                              //mc.MCInsertSelectD2(table, col1, col2, DT.getList_DS()[a], DT.getList_DS()[a + 1]);//listDs[a + 2] & listDs[a + 3]
                              DT.getList_MXS()[a] = MList.mixRowList(DT.getList_DS()[a], DT.getList_DS()[a + 1], ": ");//listSs[a + 2]
                              MList.unTagList(DT.getList_MXS()[a]);//listSs[a + 2]
                              //MList.add_SetDefaultListModel(VF_R.getJLSTS()[a + 1], DT.getList_MXS()[a], vis);//dms[a + 3]
                              //NOW         MList.add_SetListModel(jcb, al);
                              MList.add_SetListModel(VF_R.getJCBS()[a + 1], DT.getList_MXS()[a]);
                              VF_R.getJCBS()[a + 1].setPreferredSize(new Dimension());
                        } else {
                              System.out.println("\tno elements distinct (multiple columns)");
                        }
                  }
            }
      }

      private void changeLSTDTag(int fll) {
            System.out.println("\tindex: " + fll);
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
                              System.out.println("\t\tclock appear in C" + (a + 1));
                              if (VF_R.getJTFPanel()[a].getComponent(0).getName().contains("CB")) {
                                    VF_R.getJTFPanel()[a].remove(VF_R.getJCBS()[a]);
                                    VF_R.getJTFPanel()[a].add(VF_R.getJTFS()[a], 0);
                              }

                              if (VF_R.getJTFES()[a].getWidth() == 290) {
                                    VF_R.getJTFES()[a].setSize(160,
                                            VF_R.getJTFES()[a].getHeight());
                              }

                              //VF_R.getClocks()[a].setVisible(true);
                              VF_R.getTFS_MD()[a].setVisible(true);
                              VF_R.getTFS_MU()[a].setVisible(true);
                              VF_R.getTFS_SD()[a].setVisible(true);
                              VF_R.getTFS_SU()[a].setVisible(true);
                              VF_R.getLB_2DS()[a].setVisible(true);

                        } else {
                              System.out.println("\t\tclock not appearing in C" + (a + 1));
                              VF_R.getJCBS()[a].setSize(290, VF_R.getJCBS()[a].getHeight());

                              //VF_R.getClocks()[a].setVisible(false);
                              VF_R.getTFS_MD()[a].setVisible(false);
                              VF_R.getTFS_MU()[a].setVisible(false);
                              VF_R.getTFS_SD()[a].setVisible(false);
                              VF_R.getTFS_SU()[a].setVisible(false);
                              VF_R.getLB_2DS()[a].setVisible(false);

                        }
                  }
            } else {
                  for (int a = 0; a < DT.maxColumns; a++) {
                        VF_R.getJCBS()[a].setSize(290, VF_R.getJCBS()[a].getHeight());
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
            System.out.println("\nFilter: " + filter);
            System.out.println("FL: " + FL);

            int[] colNN = new int[DT.maxColumns];
            String[] coll = new String[DT.maxColumns];

            //int colN = 0;//COL INDEX - 1
            //String col = "ERROR";//COL NAME
            int sp = 0;//SPACE NEEDED BETWEEN DIGITS (X3: 4_5_6) = (4, 5, 6)

            for (int a = 0; a < DT.maxColumns; a++) {
                  if (FL.equals("NONE")) {
                        // X1: 5       | X1: 2-3 | NONE   | X1: 5     | C4
                  } else if (FL.contains("X" + (a + 1))) {//DETERMINE HOW MANY TIME A OPTION WILL LOOP
                        sp = 2;
                        //FOR DIST1 AND TAG
                        for (int b = 0; b < a + 1; b++) {//IF ITS X1 THAN IS GONNA DO 1 LOOP, TAKING 1 DIGIT, AND SO ON
                              colNN[b] = Character.getNumericValue(FL.charAt(FL.indexOf(":") + sp)) - 1;
                              coll[b] = DT.getList_C().get(colNN[b]);
                              sp += 2;
                        }
                        //+++++++++++++++++++++++++++++++++++++++++++
                        if (filter.equals("Dist1")) {
                              for (int b = 0; b < a + 1; b++) {//CHANGE CB-TF PROPERTIES
                                    changeLSTDist1(colNN[b], table, coll[b]);
                              }
                        } else if (filter.equals("Dist2")) {

                              sp = 2;
                              for (int b = 0; b < (a + 1) * 2; b++) {//1L = 2, 2L = 4, 3L = 6, 4L = 8 (X1: 1-2, X2: 3-4_5-6)
                                    colNN[b] = Character.getNumericValue(FL.charAt(FL.indexOf(":") + sp)) - 1;
                                    coll[b] = DT.getList_C().get(colNN[b]);
                                    sp += 2;
                              }
                              int c = 0;
                              for (int b = 0; b < (a + 1); b++) {
                                    changeLSTDist2(colNN[c++], colNN[c--], table, coll[c++], coll[c++]);
                              }

                        } else if (filter.equals("Tag1")) {
                              for (int b = 0; b < a + 1; b++) {
                                    changeLSTDTag(colNN[b]);
                              }
                        }
                  }
            }
      }
}
