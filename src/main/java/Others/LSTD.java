package Others;

import First.VF_R;
import MC.DT;
import MC.Data;
import MC.MM;
import MC.MethodM;
import Threads.Threads;
import java.awt.Color;
import MC.MakeCon;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author Christopher
 */
public class LSTD {

      //Data dt = new Data("LSTD");
      String CName = this.getClass().getName();
      
      //MethodM mm = new MethodM(CName, DT.CCount++);
      Threads th = new Threads(CName, DT.CCount++);
      MakeCon mc = new MakeCon(CName, DT.CCount++);

      ArrayList<String>[] listDs = new ArrayList[]{null, null, DT.getListD_2(), DT.getListD_3(),
            DT.getListD_4(), DT.getListD_5(), DT.getListD_6()};
      ArrayList<String>[] listSs = new ArrayList[]{null, null, DT.getList_S23(), DT.getList_S34(),
            DT.getList_S45(), DT.getList_S56()};
      DefaultListModel[] dms = new DefaultListModel[]{null, null, DT.getDm_2(),
            DT.getDm_3(), DT.getDm_4(), DT.getDm_5(), DT.getDm_6()};

      public void changeLSTD(String table, String D1, String D2, String TB, String TG1, 
              String CK) {
            DT.setTable(MM.filterTableName(DT.getTable(), "ADD"));
            System.out.println("\tTable: " + table);
            System.out.println("\tD1: " + D1);
            System.out.println("\tD2: " + D2);
            System.out.println("\tTB: " + TB);
            System.out.println("\tTG1: " + TG1);
            System.out.println("\tCK: " + CK);
            //System.out.println("D1 = " + D1);
            //System.out.println("-----filterEquals(\"Dist1\", D1) == " + D1);
            filterEquals("Dist1", D1);
            //System.out.println("D2 = " + D2);
            filterEquals("Dist2", D2);
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //System.out.println("Tabl = " + TB);
            if (TB.equals("NONE")) {
                  //System.out.println("'\nTB = NOTHING");
                  VF_R.getLB_Icon().setIcon(null);
                  VF_R.getLB_Icon().setText(null);
                  VF_R.getLB_Icon().setVisible(false);
            } else if (TB.contains("C")) {
                  //System.out.println(CC.RED + "TEST: "+ TB + CC.RESET);
                  VF_R.getLB_Icon().setText("Loading");
                  th.addLBIconThread(TB);
            }
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //System.out.println("TG1 = " + TG1);
            filterEquals("Tag1", TG1);
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //System.out.println("TG2 = " + TG2);
            changeCK(CK);

      }

      private void changeLSTDist1(int index, String table, String col) {
            boolean vis;

            for (int a = 0; a < DT.maxColumns - 1; a++) {
                  if (index + 1 == a + 2) {
                        vis = true;
                        if (VF_R.getJTFS()[a + 1].getBackground().equals(DT.TFColor[1])) {
                              vis = false;
                        }
                        VF_R.getJTFS()[a + 1].setBackground(DT.TFColor[1]);

                        mc.MCInsertSelectD1(table, col, listDs[a + 2]);
                        MM.unTagList(listDs[a + 2]);
                        MM.add_Set(VF_R.getJLSTS()[a], listDs[a + 2], dms[a + 2], vis);
                  }
            }
      }

      private void changeLSTDist2(int fll1, int fll2, String table, String col1, String col2) {
            boolean vis = true;
            //System.out.println("\nchangeLSTDist2");
            for (int a = 0; a < DT.maxColumns - 2; a++) {
                  if (fll1 + 1 == a + 2 && fll2 + 1 == a + 3) {
                        //System.out.println("\ta: " + a);
                        if (VF_R.getJTFS()[a + 2].getBackground().equals(DT.TFColor[2])) {
                              vis = false;
                        }

                        VF_R.getJTFS()[a + 2].setBackground(DT.TFColor[2]);
                        mc.MCInsertSelectD2(table, col1, col2, listDs[a + 2], listDs[a + 3]);
                        MM.mixList(listDs[a + 2], listDs[a + 3], listSs[a + 2]);
                        MM.unTagList(listSs[a + 2]);
                        MM.add_Set(VF_R.getJLSTS()[a + 1], listSs[a + 2], dms[a + 3], vis);
                  }
            }
      }

      private void changeLSTDTag(int fll) {
            for (int a = 0; a < DT.maxColumns - 1; a++) {
                  if (fll == a + 1) {
                        if (!VF_R.getJLBS()[a + 1].getText().contains("*")) {
                              VF_R.getJLBS()[a + 1].setText("*" + VF_R.getJLBS()[a + 1].getText());
                              MM.shortenLB(VF_R.getJLBS()[a + 1]);
                        }
                  }
            }
      }

      private void changeCK(String CK) {
            if (!CK.equals("NONE")) {
                  DT.chars[0] = CK.charAt(1);
                  DT.strings[0] = Character.toString(DT.chars[0]);
                  DT.ints[0] = Integer.parseInt(DT.strings[0]) - 1;//EX: 6 TO 5

                  for (int a = 1; a < VF_R.getJTFS().length; a++) {
                        if (a == DT.ints[0]) {
                              if (VF_R.getJTFS()[DT.ints[0]].getWidth() == 290) {
                                    VF_R.getJTFS()[DT.ints[0]].setSize(VF_R.getJTFS()[DT.ints[0]].getWidth() - 130,
                                            VF_R.getJTFS()[DT.ints[0]].getHeight());
                              }
                              VF_R.getTFS_MD()[DT.ints[0] - 1].setVisible(true);
                              VF_R.getTFS_MU()[DT.ints[0] - 1].setVisible(true);
                              VF_R.getTFS_SD()[DT.ints[0] - 1].setVisible(true);
                              VF_R.getTFS_SU()[DT.ints[0] - 1].setVisible(true);
                              VF_R.getLB_2DS()[DT.ints[0] - 1].setVisible(true);
                        } else {
                              VF_R.getJTFS()[a].setSize(290, VF_R.getJTFS()[a].getHeight());

                              VF_R.getTFS_MD()[a - 1].setVisible(false);
                              VF_R.getTFS_MU()[a - 1].setVisible(false);
                              VF_R.getTFS_SD()[a - 1].setVisible(false);
                              VF_R.getTFS_SU()[a - 1].setVisible(false);
                              VF_R.getLB_2DS()[a - 1].setVisible(false);
                        }
                  }
            } else {
                  for (int a = 0; a < VF_R.getTFS_MD().length; a++) {//FIXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                        VF_R.getJTFS()[a + 1].setSize(290, VF_R.getJTFS()[1].getHeight());
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
            
            for (int a = 0; a < DT.maxColumns - 1; a++) {
                  //System.out.println("\ta = " + a);
                  if (FL.equals("NONE")) {
                        //System.out.println("\t\t" + filter + " at NONE " + " (" + FL + ")");
                        //System.out.println("\tFL.contains(\"X" +);
                  } else if (FL.contains("X" + (a + 1))) {
                        //System.out.println("\t\t" + filter + " at X" + (a + 1) + " (" + FL + ")");
                        int d = 2;
                        for (int b = 0; b < a + 1; b++) {
                              DT.chars[b] = FL.charAt(FL.indexOf(":") + d);
                              //System.out.println("\t\t\tdt.chars[b]: " + DT.chars[b]);
                              DT.strings[b] = Character.toString(DT.chars[b]);
                              DT.ints[b] = Integer.parseInt(DT.strings[b]) - 1;
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
                                    DT.chars[b] = FL.charAt(FL.indexOf(":") + c);//4-6-8-12 -- 4-8-12-16                                   
                                    DT.strings[b] = Character.toString(DT.chars[b]);
                                    DT.ints[b] = Integer.parseInt(DT.strings[b]) - 1;
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
            //+++++++++++++++++++++++++++++++++++++++++++++++++++
            /*
            if (FL.equals("NONE")) {
            } else if (FL.contains("X1")) {
                  dt.chars[0] = FL.charAt(FL.indexOf(":") + 2);
                  dt.strings[0] = Character.toString(dt.chars[0]);
                  dt.ints[0] = Integer.parseInt(dt.strings[0]) - 1;
                  dt.cols[0] = dt.getList_C().get(dt.ints[0]);

                  if (filter.equals("Dist1")) {
                        changeLSTDist1(dt.ints[0], dt.getTable(), dt.cols[0]);

                  } else if (filter.equals("Dist2")) {
                        dt.chars[1] = FL.charAt(FL.indexOf(":") + 4);
                        dt.strings[1] = Character.toString(dt.chars[1]);
                        dt.ints[1] = Integer.parseInt(dt.strings[1]) - 1;
                        dt.cols[1] = dt.getList_C().get(dt.ints[1]);

                        changeLSTDist2(dt.ints[0], dt.ints[1], dt.getTable(), dt.cols[0], dt.cols[1]);
                  } else if (filter.equals("Tag1")) {
                        //System.out.println("-X1- Changing LST Tag1");
                        changeLSTDTag(dt.ints[0]);
                  }
                  //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            } else if (FL.contains("X2")) {
                  d = 2;
                  for (int a = 0; a < 2; a++) {
                        dt.chars[a] = FL.charAt(FL.indexOf(":") + d);
                        dt.strings[a] = Character.toString(dt.chars[a]);
                        dt.ints[a] = Integer.parseInt(dt.strings[a]) - 1;
                        dt.cols[a] = dt.getList_C().get(dt.ints[a]);
                        d += 2;
                  }

                  if (filter.equals("Dist1")) {
                        for (int a = 0; a < 2; a++) {
                              changeLSTDist1(dt.ints[a], dt.getTable(), dt.cols[a]);
                        }

                  } else if (filter.equals("Dist2")) {
                        int b = 0;
                        int e = 6;
                        for (int a = 2; a < 4; a++) {
                              dt.chars[a] = FL.charAt(FL.indexOf(":") + e);
                              dt.strings[a] = Character.toString(dt.chars[a]);
                              dt.ints[a] = Integer.parseInt(dt.strings[a]) - 1;
                              dt.cols[a] = dt.getList_C().get(dt.ints[a]);
                              e += 2;

                              changeLSTDist2(dt.ints[b++], dt.ints[b--], dt.getTable(),
                                      dt.cols[b++], dt.cols[b++]);
                        }
                  } else if (filter.equals("Tag1")) {
                        for (int a = 0; a < 2; a++) {
                              changeLSTDTag(dt.ints[a]);
                        }
                  }
                  //++++++++++++++++++++++++++++++++++++++++++++++++
            } else if (FL.contains("X3")) {
                  d = 2;
                  for (int c = 0; c < 3; c++) {
                        dt.chars[c] = FL.charAt(FL.indexOf(":") + c + d);
                        dt.strings[c] = Character.toString(dt.chars[c]);
                        dt.ints[c] = Integer.parseInt(dt.strings[c]) - 1;
                        dt.cols[c] = dt.getList_C().get(dt.ints[c]);
                        d++;
                  }
                  //t1 = FL.charAt(FL.indexOf(":") + 2);
                  //t2 = FL.charAt(FL.indexOf(":") + 4);
                  //t3 = FL.charAt(FL.indexOf(":") + 6);
                  //tt1 = Character.toString(t1);
                  //tt2 = Character.toString(t2);
                  //tt3 = Character.toString(t3);
                  //iFill1 = Integer.parseInt(tt1) - 1;
                  //iFill2 = Integer.parseInt(tt2) - 1;
                  //iFill3 = Integer.parseInt(tt3) - 1;
                  //col1 = dt.getList_C().get(iFill1);
                  //col2 = dt.getList_C().get(iFill2);
                  //col3 = dt.getList_C().get(iFill3);

                  if (filter.equals("Dist1")) {
                        for (int a = 0; a < 3; a++) {
                              changeLSTDist1(dt.ints[a], dt.getTable(), dt.cols[a]);
                        }
                  } else if (filter.equals("Dist2")) {
                        int b = 0;
                        int a = 8;
                        for (int c = 3; c < 6; c++) {
                              dt.chars[c] = FL.charAt(FL.indexOf(":") + a);
                              dt.strings[c] = Character.toString(dt.chars[c]);
                              dt.ints[c] = Integer.parseInt(dt.strings[c]) - 1;
                              dt.cols[c] = dt.getList_C().get(dt.ints[c]);
                              a += 2;

                              changeLSTDist2(dt.ints[b++], dt.ints[b--], dt.getTable(),
                                      dt.cols[b++], dt.cols[b++]);
                        }

                  } else if (filter.equals("Tag1")) {
                        for (int a = 0; a < 3; a++) {
                              changeLSTDTag(dt.ints[a]);
                        }
                  }
                  //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            } else if (FL.contains("X4")) {
                  d = 2;
                  for (int c = 0; c < 4; c++) {
                        dt.chars[c] = FL.charAt(FL.indexOf(":") + c + d);
                        dt.strings[c] = Character.toString(dt.chars[c]);
                        dt.ints[c] = Integer.parseInt(dt.strings[c]) - 1;
                        dt.cols[c] = dt.getList_C().get(dt.ints[c]);
                        d++;
                  }

                  if (filter.equals("Dist1")) {
                        for (int a = 0; a < 4; a++) {
                              changeLSTDist1(dt.ints[a], dt.getTable(), dt.cols[a]);
                        }

                  } else if (filter.equals("Dist2")) {
                        int b = 0;
                        for (int c = 4; c < 8; c++) {
                              dt.chars[c] = FL.charAt(FL.indexOf(":") + c + c);
                              dt.strings[c] = Character.toString(dt.chars[c]);
                              dt.ints[c] = Integer.parseInt(dt.strings[c]) - 1;
                              dt.cols[c] = dt.getList_C().get(dt.ints[c]);

                              changeLSTDist2(dt.ints[b++], dt.ints[b--], dt.getTable(),
                                      dt.cols[b++], dt.cols[b++]);
                        }
                  } else if (filter.equals("Tag1")) {
                        for (int a = 0; a < 4; a++) {
                              changeLSTDTag(dt.ints[a]);
                        }
                  }
            }
            */
      }
}
