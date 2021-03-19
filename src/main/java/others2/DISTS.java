package others2;

import MC.DT;
import MC.DTSQL;
import MC.LKCustom;
import MC.Status;
import SQLActions.SelectDistinctColumn;
import SQLActions.SelectDistinctColumns;
import SQLStores.TableDistC;
import SQLStores.TableKeysC;
import SQLStores.TableTypeC;
import Threads.Threads;
import com.cofii2.methods.MFile;
import com.cofii2.methods.MImage;
import com.cofii2.methods.MList;
import com.cofii2.methods.MString;
import com.cofii2.methods.MText;
import com.cofii2.mysql.MSQL;
import com.cofii2.stores.CC;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import javax.swing.Icon;
import javax.swing.JLabel;
import views.first.VF_R;

/**
 *
 * @author C0FII
 */
public class DISTS {

      //MethodM mm = new MethodM(CName, DT.CCount++);
      private static Threads th = new Threads();
      private static MSQL ms = new MSQL(DTSQL.getURLConnection(), DTSQL.getUser(), DTSQL.getPassw());

      private static String table;
      private static String dist1;
      private static String dist2;
      private static String imageC;
      private static String imageCPath;
      private static String tag;
      private static String clock;

      private static boolean[] PKSelected = new boolean[DT.maxColumns];
      private static boolean[] FKSelected = new boolean[DT.maxColumns];

      public static final Color PKColor = Color.YELLOW.darker();
      public static final Color FKColor = Color.CYAN.darker();

      //+++++++++++++++++++++++++++++++++++++++++
      private DISTS() {
            throw new IllegalStateException("Private Constructor");
      }

      //+++++++++++++++++++++++++++++++++++++++++
      public static void start(boolean imageCReload, boolean rest) {
            System.out.println("\n### DISTS ###");
            if (rest) {
                  DISTS.table = TableDistC.getTable();
                  DISTS.dist1 = TableDistC.getDist1();
                  DISTS.dist2 = TableDistC.getDist2();
                  DISTS.imageC = TableDistC.getImageC();
                  DISTS.imageCPath = TableDistC.getImageCPath();
                  DISTS.tag = TableDistC.getTag();
                  DISTS.clock = TableDistC.getClock();

                  table = table.replace(" ", "_");
                  System.out.println("\tTable: " + table);
                  System.out.println("\tD1: " + dist1);
                  System.out.println("\tD2: " + dist2);
                  System.out.println("\tIC: " + imageC);
                  System.out.println("\tICPath: " + imageCPath);
                  System.out.println("\tTG1: " + tag);
                  System.out.println("\tCK: " + clock);
                  //+++++++++++++++++++++++++++++++++++++++
                  booleanPK_FKSelected();
                  typesConfig();
            }
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            filterEquals("Dist1", dist1);
            filterEquals("Dist2", dist2);
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //System.out.println("Tabl = " + TB);
            if (imageCReload) {
                  if (imageC.equals("NONE") || imageCPath.equals("NONE")) {
                        //System.out.println("'\nTB = NOTHING");

                        for (int a = 0; a < DT.maxIcons; a++) {
                              VF_R.getLBSIcons()[a].setIcon(null);
                              VF_R.getLBSIcons()[a].setText("No image for col");
                              if (a != 0) {
                                    VF_R.getLBSIcons()[a].setVisible(false);
                              }
                        }

                        if (VF_R.getP3().getComponent(1).getClass().getName().contains("Progress")) {
                              VF_R.getP3().remove(VF_R.getJPB());
                              VF_R.getP3().add(VF_R.getLB_Status(), 1);
                              VF_R.getP3().revalidate();
                        }
                        //VF_R.getLB_Icon().setVisible(true);
                        VF_R.getSPL_SUB().setDividerLocation(1.0);
                        VF_R.getMi_ReloadImageC().setEnabled(false);

                  } else if (imageC.contains("C") && !imageCPath.equals("NONE")) {//IMAGE
                        imageCStart();
                  }
            }
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            filterEquals("Tag1", tag);
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //System.out.println("TG2 = " + TG2);
            if (rest) {
                  changeCK(clock);
                  //CLEAR JTFES
                  for (int a = 0; a < VF_R.getJT().getColumnCount(); a++) {
                        VF_R.getJTFES()[a].setText("");
                  }
            }
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            System.out.println("\n### DISTS ENDS ###");
      }

      //+++++++++++++++++++++++++++++++++++++++++
      private static void booleanPK_FKSelected() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  PKSelected[a] = false;
                  FKSelected[a] = false;
            }
      }

      private static void typesConfig() {

            int extra = TableTypeC.getEX().index;

            System.out.println("\tEX: " + extra + " (" + TableTypeC.getEX().string + ")");

            if (extra > 0) {
                  extraConfig(extra);
            } else {
                  for (int a = 0; a < DT.maxColumns; a++) {
                        VF_R.getJTFS()[a].setBackground(LKCustom.BK_NORMAL);
                        VF_R.getJTFS()[a].setFont(LKCustom.FONT_NORMAL);
                        VF_R.getJTFS()[a].setForeground(Color.WHITE);
                        VF_R.getJTFS()[a].setText("");
                        VF_R.getJTFS()[a].setEnabled(true);
                  }
            }
            //+++++++++++++++++++++++++++++++++
            int pkLength = TableKeysC.getPK().length;
            System.out.println("\n\tpkLength: " + pkLength);
            for (int a = 0; a < pkLength; a++) {
                  int pk = TableKeysC.getPK()[a].index;
                  System.out.println("\t\tPK: " + pk + " (" + TableKeysC.getPK()[a].string + ")");
                  if (pk > 0) {
                        pkConfig(pk);
                  }
            }
            for(int a = 0; a < VF_R.getJT().getColumnCount(); a++){
                  if(!PKSelected[a]){
                        VF_R.getJLBS()[a].setIcon(null);
                  }
            }

            int fkLength = TableKeysC.getFK().length;
            System.out.println("\n\tfkLength: " + fkLength);
            for (int a = 0; a < fkLength; a++) {
                  int fk = TableKeysC.getFK()[a].index;
                  System.out.println("\t\tFK: " + fk + " (" + TableKeysC.getFK()[a].string + ")");
                  if (fk > 0) {
                        fkConfig(fk);
                  }
            }
            /*
            for(int a = 0; a < VF_R.getJT().getColumnCount(); a++){
                  if(!FKSelected[a]){
                        VF_R.getJLBS()[a].setIcon(null);
                  }
            }
            */
            /*
            if (pk > 0 && fk > 0) {

            } else if (pk > 0) {
                  pkConfig(pk);
            } else if (fk > 0) {
                  fkConfig(fk);
            } else {
                  for (JLabel x : VF_R.getJLBS()) {
                        x.setIcon(null);
                  }
            }
             */
      }

      private static void pkConfig(int pk) {
            for (int a = 0; a < VF_R.getJT().getColumnCount(); a++) {              
                  JLabel lb = VF_R.getJLBS()[a];
                  if (a == pk - 1) {
                        
                        int w = 20;
                        int h = lb.getPreferredSize().height - 2;

                        MImage.setOption(MImage.DRAW_CIRCLE);
                        MImage.setColor(PKColor);

                        Icon ii = MImage.resizeIcon(null, w, h);
                        lb.setIcon(ii);

                        VF_R.getJTFPanelCL()[a].show(VF_R.getJTFPanel()[a], VF_R.tfPanelTypes[0]);
                        //VF_R.getJTFS()[a].setBackground(LKCustom.BK_PK);
                        PKSelected[a] = true;
                  }
            }
      }

      private static void fkConfig(int fk) {
            for (int a = 0; a < DT.maxColumns; a++) {
                  JLabel lb = VF_R.getJLBS()[a];
                  if (a == fk - 1) {
                        int w = 20;
                        int h = lb.getPreferredSize().height - 2;

                        if (!PKSelected[a]) {//ONLY PK
                              MImage.setOption(MImage.DRAW_CIRCLE);
                              MImage.setColor(FKColor);

                        } else {//PK & FK
                              MImage.setOption(MImage.DRAW_CIRCLES);
                              MImage.setColors(new Color[]{PKColor, FKColor});

                        }

                        Icon ii = MImage.resizeIcon(null, w, h);
                        lb.setIcon(ii);

                        VF_R.getJTFPanelCL()[a].show(VF_R.getJTFPanel()[a], VF_R.tfPanelTypes[1]);

                        FKSelected[a] = true;
                  } 
            }
      }

      private static void extraConfig(int extra) {
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (a == extra - 1) {
                        //VF_R.getJCBS()[a].removeAllItems();
                        VF_R.getJTFS()[a].setBackground(LKCustom.BK_AUTO_INCR_IDEN);
                        VF_R.getJTFS()[a].setFont(LKCustom.FONT_AUTO_INCREMENT);
                        String extraT = TableTypeC.getEX().string;
                        if (extraT.equalsIgnoreCase("AUTO_INCREMENT")) {
                              //System.out.println("\tAUTO_INCREMENT");
                              VF_R.getJTFS()[a].setEnabled(false);
                              VF_R.getJTFS()[a].setText(LKCustom.TEXT_AUTO_INCREMENT);
                        } else if (extraT.equalsIgnoreCase("IDENTITY")) {
                              //System.out.println("\tIDENTITY");
                              VF_R.getJTFS()[a].setEnabled(false);
                              VF_R.getJTFS()[a].setText(LKCustom.TEXT_IDENTITY);
                        } else {
                              VF_R.getJTFS()[a].setEnabled(true);
                              VF_R.getJTFS()[a].setText("");
                              //System.out.println("\tNONE");
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
      }

      //+++++++++++++++++++++++++++++++++++++++++
      private static void changeLSTDist1(int index, String table, String col) {
            boolean vis;//NO ADDING THE ELEMENTS AGAIN

            //System.out.println("\nchangeLSTDist1");
            //System.out.println("\tindex: " + index);
            //System.out.println("\ttable: " + table);
            //System.out.println("\tcol: " + col);
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (index + 1 == a + 1) {
                        VF_R.getJTFPanelCL()[a].show(VF_R.getJTFPanel()[a], VF_R.tfPanelTypes[1]);

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
                              MList.unTagList(DT.getList_DS()[a]);
                              //MList.add_SetDefaultListModel(VF_R.getJLSTS()[a], DT.getList_DS()[a], vis);//dms[a + 2]
                              MList.add_SetListModel(VF_R.getJCBS()[a], DT.getList_DS()[a]);
                              //VF_R.getJTFES()[a].setText("");
                              VF_R.getJCBS()[a].setPreferredSize(new Dimension());
                        } else {
                        }
                  }
            }
      }

      private static void changeLSTDist2(int fll1, int fll2, String table, String col1, String col2) {
            //System.out.println("\tfll1: " + fll1 + ", fll2: " + fll2 + ", table: " + table + ", col1: " + col1 + ", col2: " + col2);
            boolean vis = true;
            //System.out.println("\nchangeLSTDist2");
            for (int a = 0; a < DT.maxColumns - 1; a++) {
                  if (fll1 + 1 == a + 1 && fll2 + 1 == a + 2) {
                        VF_R.getJTFPanelCL()[a].show(VF_R.getJTFPanel()[a], VF_R.tfPanelTypes[0]);
                        VF_R.getJTFPanelCL()[a + 1].show(VF_R.getJTFPanel()[a + 1], VF_R.tfPanelTypes[1]);

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
                              //VF_R.getJTFES()[a + 1].setText("");
                              VF_R.getJCBS()[a + 1].setPreferredSize(new Dimension());
                        } else {
                        }
                  }
            }
      }

      private static void changeLSTDTag(int fll) {
            //System.out.println("\tindex: " + fll);
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (fll == a) {
                        if (!VF_R.getJLBS()[a].getText().contains("*")) {
                              VF_R.getJLBS()[a].setText("*" + VF_R.getJLBS()[a].getText());
                              MText.shortenLB(VF_R.getJLBS()[a]);
                        }
                  }
            }
      }

      private static void changeCK(String CK) {
            if (!CK.equals("NONE")) {
                  //DT.chars[0] = CK.charAt(1);// COL NUM
                  //DT.strings[0] = Character.toString(DT.chars[0]);
                  //DT.ints[0] = Integer.parseInt(DT.strings[0]) - 1;//EX: 6 IS 5
                  int col = Character.getNumericValue(CK.charAt(1)) - 1;
                  //System.out.println("\t####COL VALUE: " + col + " (CK: " + CK + ")");

                  for (int a = 0; a < DT.maxColumns; a++) {
                        if (a == col) {
                              //System.out.println("\t\tclock appear in C" + (a + 1));
                              VF_R.getJTFPanelCL()[a].show(VF_R.getJTFPanel()[a], VF_R.tfPanelTypes[2]);
                              /*
                              if (VF_R.getJTFPanel()[a].getComponent(0).getName().contains("CB")) {
                                    VF_R.getJTFPanel()[a].remove(VF_R.getJCBS()[a]);
                                    VF_R.getJTFPanel()[a].add(VF_R.getJTFS()[a], 0);
                              }
                               */
 /*
                              if (VF_R.getJTFES()[a].getWidth() == 290) {
                                    VF_R.getJTFES()[a].setSize(160,
                                            VF_R.getJTFES()[a].getHeight());
                              }
                               */
 /*
                              //VF_R.getClocks()[a].setVisible(true);
                              VF_R.getTFS_MD()[a].setVisible(true);
                              VF_R.getTFS_MU()[a].setVisible(true);
                              VF_R.getTFS_SD()[a].setVisible(true);
                              VF_R.getTFS_SU()[a].setVisible(true);
                              VF_R.getLB_2DS()[a].setVisible(true);
                               */

                        } else {
                              /*
                              VF_R.getJCBS()[a].setSize(290, VF_R.getJCBS()[a].getHeight());

                              //VF_R.getClocks()[a].setVisible(false);
                              VF_R.getTFS_MD()[a].setVisible(false);
                              VF_R.getTFS_MU()[a].setVisible(false);
                              VF_R.getTFS_SD()[a].setVisible(false);
                              VF_R.getTFS_SU()[a].setVisible(false);
                              VF_R.getLB_2DS()[a].setVisible(false);
                               */

                        }
                  }
            } else {
                  /*
                  for (int a = 0; a < DT.maxColumns; a++) {
                        VF_R.getJCBS()[a].setSize(290, VF_R.getJCBS()[a].getHeight());
                        VF_R.getTFS_MD()[a].setVisible(false);
                        VF_R.getTFS_MU()[a].setVisible(false);
                        VF_R.getTFS_SD()[a].setVisible(false);
                        VF_R.getTFS_MU()[a].setVisible(false);
                        VF_R.getLB_2DS()[a].setVisible(false);
                  }
                   */
            }
      }

      private static void filterEquals(String filter, String FL) {
            //System.out.println("\nfilterEquals (max Column - 1 = " + (dt.maxColumns - 1));
            //System.out.println("\nFilter: " + filter);
            //System.out.println("FL: " + FL);

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

      //++++++++++++++++++++++++++++++++++++++++++++++++++++
      public static void imageCStart() {
            System.out.println(CC.CYAN + "\taddLBIconThread" + CC.RESET);

            //System.out.println("TEST imageCStart");
            String[] listFiles = new File(imageCPath).list();
            int filesLength = listFiles.length;

            resetImageC(filesLength);

            int colIndex = Character.getNumericValue(imageC.charAt(1)) - 1;
            //System.out.println("\tColIndex: " + colIndex);
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++

            if (imageCPath.charAt(imageCPath.length() - 1) != '\\') {
                  imageCPath += "\\";
            }

            for (int a = 0; a < filesLength; a++) {
                  DT.getList_IconHolePath().add(imageCPath + listFiles[a]);//HOLE PATH
                  //System.out.println("\tlistFiles " + (a + 1) + ": " + listFiles[a]);
                  String name = MFile.getSplitFilePath(listFiles[a])[0];
                  name = MString.getRemoveCustomFormattedString(name);
                  DT.getList_IconName().add(name);//NAME ONLY
                  //58%Slash%2 Days Black Coat Riku

                  //VF_R.getJPB().setValue((a + 1));
            }

            //System.out.println("\tMatch");
            VF_R.getMi_ReloadImageC().setEnabled(true);

            VF_R.getLBSIcons()[0].setText("Ready!");
            VF_R.getLBSIcons()[0].repaint();

            Status.startLBStatus(VF_R.getLB_Status(), Color.GREEN, "ImageC Reloaded!", 2000);

      }

      private static void resetImageC(int filesLength) {
            //System.out.println("TEST resetImageC");
            VF_R.getSPL_SUB().setDividerLocation(0.5);

            VF_R.getLBSIcons()[0].setText("Loading");
            for (int a = 1; a < DT.maxIcons; a++) {
                  VF_R.getLBSIcons()[a].setVisible(false);
            }

            VF_R.getMi_ReloadImageC().setEnabled(false);

            DT.getList_IconUrl().clear();
            DT.getList_Icon().clear();
            DT.getList_cutUrl().clear();

            DT.getList_IconHolePath().clear();
            DT.getList_IconName().clear();
      }

      private static String imageCTagSystem(int a, int colIndex, String textUrl) {
            String value = VF_R.getJT().getValueAt(a, colIndex).toString();
            if (value.contains("; ")) {//LAST TAG++++++++++++++
                  //System.out.println("\timageCPath: " + imageCPath);
                  textUrl = imageCPath + value.substring(
                          value.indexOf(";") + 2, value.length()) + ".jpg";

            } else {
                  textUrl = imageCPath + value + ".jpg";
            }
            return textUrl;
      }
}
