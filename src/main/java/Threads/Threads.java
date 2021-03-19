package Threads;

import MC.DT;
import MC.DTSQL;
import MC.notMyMethods;
import SQLActions.Insert;
import SQLActions.SelectData;
import SQLStores.TableDistC;
import SQLStores.TableTypeC;
import others2.DISTS;

import com.cofii2.methods.MList;
import com.cofii2.mysql.MSQL;
import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import views.first.VF_R;

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
      private static Thread scrollThread;
      private static Thread fireDataThread;

      private static Thread cellUpdate;
      //+++++++++++++++++++++++++++++++++++++++++++++++++++

      public void addOp() {
            addThread = new Thread(new Runnable() {
                  @Override
                  public void run() {
                        DT.bool_Add = true;
                        System.out.println("##1# TEST TF_1 TEXT: " + VF_R.getJTFS()[0].getText());
                        ArrayList<String> listNewValues = new ArrayList<String>();
                        boolean breakk = false;
                        for (int a = 0; a < DT.maxColumns; a++) {
                              breakk = wichComponent(a, listNewValues);
                              if(!breakk){
                                    break;
                              }
                        }
                        String[] columns = MList.getListToArray(String.class, DT.getList_C());
                        String[] newValues = MList.getListToArray(String.class, listNewValues);
                        //+++++++++++++++++++++++++++++++++++++++++
                        String table = TableDistC.getTable();
                        //+++++++++++++++++++++++++++++++++++++++++
                        //CHANGE WHEN THERE IS NO >ID< FIELD
                        //int mayor = MTable.getMayorId(VF_R.getJT(), 0);
                        Insert ins = new Insert();
                        for (int a = 0; a < DT.maxColumns; a++) {
                              if (VF_R.getJT().getColumnCount() == a + 1) {
                                    System.out.println("\t\tADD ++++ INSERTING " + (a + 1)
                                            + " COLUMNS");
                                    //INSERT INTO Youkai_Watch (, EP, Title, Time, Descr) VALUES ("185-A", "Busters Treasure - 7", "M", "EX X; Komasan; JB; F")
                                    ms.insert(table, columns, newValues, TableTypeC.getEX().index, ins);
                                    //mc.Insert(DT.getTable(), ++mayor, listNewValues);
                                    if (ins.success) {
                                          ms.selectData(table, new SelectData(a + 1));
                                    }
                              }
                        }
                        System.out.println("##2# TEST TF_1 TEXT: " + VF_R.getJTFS()[0].getText());
                        if (ins.success) {
                              DISTS.start(false, false);
                              /*
                              if (VF_R.getSPL().getRightComponent().getName().equals("LB_JT")) {
                                    VF_R.getSPL().setRightComponent(VF_R.getSC_JT());
                                    VF_R.getSPL().revalidate();
                              }
                              */
                              //VF_R.getJT().clearSelection();
                              n_mm.rez(VF_R.getJT(), DT.autoState);
                              System.out.println("##3# TEST TF_1 TEXT: " + VF_R.getJTFS()[0].getText());
                        }
                  }

            });
            addThread.start();

            scrollThread = new Thread(new Runnable() {
                  @Override
                  public void run() {
                        try {
                              cyb.await();
                              Thread.sleep(500);
                              addThread.join();
                              if (!TableDistC.getImageC().contains("NONE")) {
                                    //iconThread.join();
                              }
                              Thread.sleep(200);
                              VF_R.getSC_JT().getVerticalScrollBar().setValue(
                                      VF_R.getSC_JT().getVerticalScrollBar().getMaximum());
                        } catch (InterruptedException ex) {
                              ex.printStackTrace();
                        } catch (BrokenBarrierException bbe) {
                              bbe.printStackTrace();
                        }
                  }

            });
            scrollThread.start();
            fireDataThread = new Thread(new Runnable() {
                  @Override
                  public void run() {
                        try {
                              cyb.await();
                              DT.bool_Add = true;
                              scrollThread.join();
                              ((AbstractTableModel) VF_R.getJT().getModel()).fireTableDataChanged();
                              Thread.sleep(500);
                        } catch (InterruptedException ie) {
                              ie.printStackTrace();
                        } catch (BrokenBarrierException bbe) {
                              bbe.printStackTrace();
                        }
                        DT.bool_Add = false;
                  }

            });
            fireDataThread.start();

      }

      /**
       * 
       * @param a index of each column
       * @param listNewValues new values to add
       * @return continue
       */
      private boolean wichComponent(int a, ArrayList<String> listNewValues) {
            JTextField tf = null;
            JPanel jp = VF_R.getJTFPanel()[a];
            if (VF_R.tfPanelSelected[a].equalsIgnoreCase(VF_R.tfPanelTypes[0])) {
                  tf = VF_R.getJTFS()[a];

            } else if (VF_R.tfPanelSelected[a].equalsIgnoreCase(VF_R.tfPanelTypes[1])) {
                  tf = VF_R.getJTFES()[a];

            } else if (VF_R.tfPanelSelected[a].equalsIgnoreCase(VF_R.tfPanelTypes[2])) {
                  tf = VF_R.getJTF_CKS()[a];
            }

            if (jp.isVisible()) {
                  if ((a + 1) == TableTypeC.getEX().index) {//IF THE COLUMN IS AN AUTO_INCREMENT THE VALUE SHOULD BE AUTOMATIC
                        listNewValues.add(null);
                  } else {
                        listNewValues.add(tf.getText());
                  }
                  return true;
            }else{
                  return false;
            }
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
