package Threads;

import views.first.VF_R;
import java.io.File;
import javax.swing.ImageIcon;
import java.util.concurrent.BrokenBarrierException;
import MC.DT;
import MC.DTSQL;
import MC.TableInfoC;
import MC.notMyMethods;
import com.cofii2.myMethods.MImage;
import com.cofii2.myMethods.MTable;
import com.cofii2.myClasses.CC;
import Others.LSTD;
import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;
import javax.swing.table.AbstractTableModel;
import SQLActions.Insert;
import SQLActions.SelectData;
import com.cofii2.myClasses.MSQL;
import com.cofii2.myMethods.MList;

/**
 *
 * @author Christopher
 */
public class Threads {

      //Data dt = new Data();
      String CName = this.getClass().getName();

      //MethodM mm = new MethodM(CName, DT.CCount++);
      notMyMethods n_mm = new notMyMethods();
      MSQL ms = new MSQL(DTSQL.getURLConnection(), DTSQL.getUser(), DTSQL.getPassw());

      //BTNS_MCActionListener BMA = new BTNS_MCActionListener();
      private static CyclicBarrier cyb = new CyclicBarrier(2);

      private static Thread addThread;
      private static Thread iconThread;
      private static Thread scrollThread;
      private static Thread fireDataThread;

      private static Thread cellUpdate;

      //+++++++++++++++++++++++++++++++++++++++++++++++++++
      public Threads(String from, int CC) {
            DT.getConstructorName(DT.cons, CName, from, CC);
      }
      //+++++++++++++++++++++++++++++++++++++++++++++++++++

      public void addOp() {
            addThread = new Thread(new Runnable() {
                  @Override
                  public void run() {
                        DT.bool_Add = true;
                        System.out.println("\tADD ++++ addThread starts");

                        ArrayList<String> listNewValues = new ArrayList<String>();
                        for (int a = 0; a < DT.maxColumns; a++) {
                              if (VF_R.getJCBS()[a].isVisible()) {
                                    if ((a + 1) == (int) DT.getExtra()[0]) {//AUTO VALUE REPLACE WITH NULL
                                          listNewValues.add(null);
                                    } else {
                                          listNewValues.add(VF_R.getJCBS()[a].getSelectedItem().toString());
                                    }
                              } 
                        }
                        String[] columns = MList.getListToArray(String.class, DT.getList_C());
                        String[] newValues = MList.getListToArray(String.class, listNewValues);
                        //+++++++++++++++++++++++++++++++++++++++++
                        String table = TableInfoC.getTable();
                        //+++++++++++++++++++++++++++++++++++++++++
                        //CHANGE WHEN THERE IS NO >ID< FIELD
                        int mayor = MTable.getMayorId(VF_R.getJT(), 0);
                        Insert ins = new Insert();
                        for (int a = 0; a < DT.maxColumns; a++) {
                              if (VF_R.getJT().getColumnCount() == a + 1) {
                                    System.out.println("\t\tADD ++++ INSERTING " + (a + 1)
                                            + " COLUMNS");
                                    //INSERT INTO Youkai_Watch (, EP, Title, Time, Descr) VALUES ("185-A", "Busters Treasure - 7", "M", "EX X; Komasan; JB; F")
                                    ms.insert(table, columns, newValues, (int) DT.getExtra()[0], ins);
                                    //mc.Insert(DT.getTable(), ++mayor, listNewValues);
                                    if (ins.success) {
                                          ms.selectData(table, new SelectData(a + 1));
                                    }
                              }
                        }
                        if (ins.success) {
                              new LSTD().changeLSTD();

                              VF_R.getJT().clearSelection();
                              n_mm.rez(VF_R.getJT(), DT.autoState);
                        }
                        System.out.println("\tADD ++++ addStar Finished");
                  }

            });
            addThread.start();
            scrollThread = new Thread(new Runnable() {
                  @Override
                  public void run() {
                        try {
                              cyb.await();
                              System.out.println("\nV_sb STARTS");
                              System.out.println("\tV_sb is waiting for \"addThread\" to finish");
                              Thread.sleep(500);
                              addThread.join();
                              if (!TableInfoC.getImageC().contains("NONE")) {
                                    System.out.println("\tV_sb is waiting for \"iconThread\" to finish");
                                    iconThread.join();
                              }
                              Thread.sleep(200);
                              VF_R.getSC_JT().getVerticalScrollBar().setValue(
                                      VF_R.getSC_JT().getVerticalScrollBar().getMaximum());
                        } catch (InterruptedException ex) {
                              System.err.println("\tVs_sb... Fail... Horrible");
                              ex.printStackTrace();
                        } catch (BrokenBarrierException bbe) {
                              System.err.println("\tVs_sb... Fail... Horrible");
                              bbe.printStackTrace();
                        }
                        System.out.println("\tV_sb finished");
                  }

            });
            scrollThread.start();
            fireDataThread = new Thread(new Runnable() {
                  @Override
                  public void run() {
                        try {
                              cyb.await();
                              DT.bool_Add = true;
                              System.out.println("\nfireData STARTS // " + DT.bool_Add);
                              System.out.println("\tfireData is waiting for \"scrollThread\" to end");
                              scrollThread.join();
                              ((AbstractTableModel) VF_R.getJT().getModel()).fireTableDataChanged();
                              Thread.sleep(500);
                        } catch (InterruptedException ie) {
                              System.err.println("\tfireData... Fail... Horrible");
                              ie.printStackTrace();
                        } catch (BrokenBarrierException bbe) {
                              System.err.println("\tfireData... Fail... Horrible");
                              bbe.printStackTrace();
                        }
                        DT.bool_Add = false;
                        System.out.println(CC.GREEN + "\tfireData finished (ADD FINISH)"
                                + CC.RESET);
                  }

            });
            fireDataThread.start();
      }

      public void addLBIconThread(String TB) {
            System.out.println(CC.RED + "addLBIconThread" + CC.RESET);
            iconThread = new Thread() {
                  public void run() {
                        //Data dt = new Data();
                        VF_R.getJPB().setMaximum(VF_R.getJT().getRowCount());
                        VF_R.getJPB().setValue(0);
                        VF_R.getJPB().setVisible(true);
                        //System.out.println(CC.RED + "\tRUN" + CC.RESET);
                        //System.out.println(CC.RED + "\tJPB is visible: " + VF_R.getJPB().isVisible() 
                        //+ CC.RESET);
                        DT.getList_IconUrl().clear();
                        DT.getList_newIcon().clear();
                        DT.getList_cutUrl().clear();
                        //-------------------------------------------------------------------------------
                        int col = Character.getNumericValue(TB.charAt(1)) - 1;

                        DT.cols[0] = DT.getList_C().get(col);//UNUSED?
                        //++++++++++++++++++++++++++++++++++++++++++++++++++++++
                        Object data;
                        String textIcon = "ERROR";
                        String textUrl = "ERROR";
                        File file;
                        ImageIcon icon;
                        for (int a = 0; a < VF_R.getJT().getRowCount(); a++) {
                              VF_R.getJPB().setValue((a + 1));

                              data = VF_R.getJT().getValueAt(a, col);
                              if (data.toString().contains("; ")) {

                                    textIcon = data.toString();
                                    textIcon = DTSQL.IconURL + textIcon.substring(
                                            textIcon.indexOf(";") + 2, textIcon.length()) + ".jpg";
                                    textUrl = textIcon;

                              } else {
                                    textUrl = DTSQL.IconURL + data.toString() + ".jpg";
                                    textIcon = DTSQL.IconURL + data.toString() + ".jpg";
                              }
                              //++++++++++++++++++++++++++++++++++++++++++++
                              if (textIcon.contains("/")) {
                                    //System.out.println("\tData/Text contains >>/<<");
                                    textIcon = textIcon.replaceAll("/", "Slash");
                              }
                              if (textIcon.contains("<")) {
                                    //System.out.println("\tData/Text contains >> < <<");
                                    textIcon = textIcon.replaceAll("<", "Bracket");
                              }
                              if (textIcon.contains("?")) {
                                    //System.out.println("\tData/Text contains >>?<<");
                                    textIcon = textIcon.replace("?", "");
                              }
                              if (textIcon.contains(": ")) {
                                    //System.out.println("\tData/Text contains >>: <<");
                                    textIcon = textIcon.replaceAll(": ", " ");

                              }
                              //++++++++++++++++++++++++++++++++++++++++++++
                              //System.out.println("\tData/Text: " + textIcon + " or .png");
                              //++++++++++++++++++++++++++++++++++++++++++++
                              if (textIcon.contains("-SINGLE-") || textIcon.contains("NO ALBUM")) {
                                    VF_R.getLB_Icon().setIcon(null);
                                    //System.out.println("\t\tNO ALBUM ICON FOR " + textIcon);
                              } else {
                                    file = new File(textIcon);
                                    if (file.exists()) {
                                          if (DT.getList_IconUrl().contains(textUrl)) {
                                          } else {
                                                //System.out.println("\t\tFile Exists!!!!!!! - jpg");
                                                //list_Icon.add(resizeIcon(new ImageIcon(file.getPath())));
                                                icon = new ImageIcon(file.getPath());
                                                DT.getList_IconUrl().add(textUrl);
                                                DT.getList_newIcon().add(MImage.resizeIcon(icon));
                                          }
                                    } else {
                                          textIcon = DTSQL.IconURL + data.toString() + ".png";
                                          file = new File(textIcon);
                                          if (file.exists()) {
                                                if (DT.getList_IconUrl().contains(textUrl)) {
                                                } else {
                                                      icon = new ImageIcon(file.getPath());
                                                      DT.getList_IconUrl().add(textUrl);
                                                      DT.getList_newIcon().add(MImage.resizeIcon(icon));
                                                }
                                          } else {
                                                //System.out.println("\t\tFile NOT FOUND");
                                          }
                                    }
                              }
                              //System.out.println();
                        }

                        //TEST BOTH ARRAY (iconUrl & newicon) PATHS, TO COMPARE THEM
                        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                        String holePath;
                        String cutPath;
                        for (int a = 0; a < DT.getList_IconUrl().size(); a++) {
                              holePath = DT.getList_IconUrl().get(a).toString();
                              cutPath = holePath.substring(holePath.indexOf("Front\\") + 6, holePath.length() - 4);
                              System.out.println("cutPath " + a + ": " + cutPath);
                              DT.getList_cutUrl().add(cutPath);
                        }
                        if (VF_R.getJPB().getValue() == VF_R.getJT().getRowCount()) {
                              VF_R.getJPB().setForeground(Color.GREEN);
                        }
                        VF_R.getLB_Icon().setText("Ready!");

                        VF_R.getJTCL().setDefaultForeground(Color.GRAY);
                        VF_R.getJT().setEnabled(true);
                  }
            };
            iconThread.start();
      }

      public void setValueToCell(Object data, int coln, int rown) {
            cellUpdate = new Thread(new Runnable() {
                  public void run() {
                        //System.out.println("Thread N3 is Starting");
                        try {
                              Thread.sleep(300);

                        } catch (InterruptedException ex) {
                              ex.printStackTrace();
                        }
                        if (coln == 0) {
                              DT.cellSys = false;
                              if (data instanceof String) {

                                    //System.out.println("\tString");
                                    Object ndata = Integer.parseInt((String) data);
                                    VF_R.getJT().getModel().setValueAt(ndata, rown, 0);

                              } else if (data instanceof Integer) {
                                    //System.out.println("\tInteger");
                              }
                        }
                  }
            });
            cellUpdate.start();
      }

      /*
      
      
      public void scrollerThread() {
            scrollThread = new Thread() {
                  public void run() {
                        try {
                              dt.getCYB().await();
                              
                              System.out.println("\nV_sb STARTS");
                              System.out.println("\tV_sb is waiting");
                              Thread.sleep(500);
                              BMA.getAddThread().join();
                              if (!dt.getImageC().contains("NONE")) {
                                    iconThread.join();
                              }
                              Thread.sleep(200);
                              VF_R.getSC_JT().getVerticalScrollBar().setValue(VF_R.getSC_JT().getVerticalScrollBar().getMaximum());
                        } catch (InterruptedException ex) {
                              System.err.println("\tVs_sb... Fail... Horrible");
                              ex.printStackTrace();
                        } catch (BrokenBarrierException bbe) {
                              System.err.println("\tVs_sb... Fail... Horrible");
                              bbe.printStackTrace();
                        }
                        System.out.println("\tV_sb finished");
                  }
            };
      }
       */
}
