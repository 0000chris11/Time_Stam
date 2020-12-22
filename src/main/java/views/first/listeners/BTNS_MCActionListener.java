package views.first.listeners;

import MC.DT;
import MC.DTSQL;
import MC.Status;
import MC.TableInfoC;
import MC.notMyMethods;
import Others.LSTD;
import SQLActions.DeleteRow;
import SQLActions.SelectData;
import SQLActions.Update;
import Threads.Threads;
import com.cofii2.stores.CC;
import com.cofii2.mysql.MSQL;
import com.cofii2.methods.MList;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import views.first.VF_R;

/**
 *
 * @author C0FII
 */
public class BTNS_MCActionListener implements ActionListener {

      //Data dt = new Data();
      String CName = this.getClass().getName();
      
      //MethodM mm = new MethodM(CName, DT.CCount++);
      notMyMethods n_mm = new notMyMethods();
      MSQL ms = new MSQL(DTSQL.getURLConnection(), DTSQL.getUser(), DTSQL.getPassw());
      Threads th = new Threads(CName, DT.CCount++);

      //public static Thread scrollThread;

      @Override
      public void actionPerformed(ActionEvent evt) {
            //dt.setTable(mm.filterTableName(dt.getTable(), "ADD"));
            String table = TableInfoC.getTable();
            if (evt.getSource() == VF_R.getBTNS_MC()[0]) {
                  System.out.println(CC.GREEN + "\nADD DATA" + CC.RESET);
                  th.addOp();
            } else if (evt.getSource() == VF_R.getBTNS_MC()[1]) {
                  System.out.println(CC.GREEN + "\nUPDATE DATA" + CC.RESET);
                  updOp(table);
            } else if (evt.getSource() == VF_R.getBTNS_MC()[2]) {
                  System.out.println(CC.GREEN + "\nDELETE DATA" + CC.RESET);
                  delOp(table);
            }
      }
      
      private void updOp(String table) {
            
            DT.bool_Upd = true;

            ArrayList<Integer> colIndexs = new ArrayList<Integer>();
            ArrayList<Object> newData = new ArrayList<Object>();
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            int colN = -1;
            //int hc = 0;
            for (int a = 0; a < DT.maxColumns; a++) {
                  //System.out.println("UPD ListC " + a + ": "+ dt.getList_C().get(a));
            }
            for (int a = 0; a < DT.maxColumns; a++) {
                  //System.out.println("UPD ListR " + a + ": "+ dt.getList_R().get(a));
            }
            //+++++++++++++++++++++++++++++++++++++++++
            System.out.println("\tUPD ++++ starts");
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (VF_R.getJT().getColumnCount() == a + 1) {
                        for (int b = 0; b < a + 1; b++) {
                              //COMPARING EACH TFS WITH THE SELECTED ROW
                              if (!DT.getList_R().get(b).equals(VF_R.getJCBS()[b].getSelectedItem().toString()) 
                                      && !VF_R.getJCBS()[b].getSelectedItem().toString().equals("")//CHANGE WHEN U ALLOWED NULL FIELDS
                                      && VF_R.getJCBS()[b].isVisible()) {
                                    
                                    newData.add(VF_R.getJCBS()[b].getSelectedItem().toString());
                                    colIndexs.add(b);
                                    //hc++;
                              }else{
                                    Status.startLBStatus(VF_R.getLB_Status(), Color.YELLOW, 
                                            "??????", 10000);
                              }
                        }
                        colN = a + 1;
                  }
            }
            
            System.out.println("\tcolIndexs Size: " + colIndexs.size());
            System.out.println("\tnewData Size: " + newData.toArray().length);
            
            //PASSING THE INDEX IN ORDER TO FIND THE COLUMN NAME
            String[] cols = new String[colIndexs.size()];
            for(int a = 0; a < colIndexs.size(); a++){
                  //System.out.println("\tcolIndexs[" + a + "] = " + colIndexs.get(a));
                  cols[a] = DT.getList_C().get(colIndexs.get(a));
                  //System.out.println("\tcols[" + a + "] = " + cols[a]);
            }            
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            
            //mc.UpdateRow(DT.getTable(), cols, newData.toArray(), DT.getList_R().get(0));
            ms.updateRow(table, cols, newData.toArray(), "id", DT.getList_R().get(0), 
                    new Update("UpdateRow", VF_R.getLB_Status()));
            //mc.SelectData(colN, DT.getTable());
            ms.selectData(table, new SelectData(colN));

            colIndexs.clear();
            new LSTD().changeLSTD();

            DT.bool_Upd = false;
            System.out.println(CC.GREEN + "\n\tUPDATED DATA" + CC.RESET);
      }

      private void delOp(String table) {
            DT.bool_Del = true;
            //System.out.println("\nDELETING DATA");

            String[] cols = MList.getListToArray(String.class, DT.getList_C());
            Object[] values = MList.getListToArray(Object.class, DT.getList_R());
            ms.deleteRow(table, cols, values, new DeleteRow(values));
            //mc.DeleteRow(DT.getTable(), DT.getList_R().get(0));
            for (int a = 0; a < DT.maxColumns - 1; a++) {
                  if (VF_R.getJT().getColumnCount() == a + 2) {
                        //mc.SelectData(a + 2, DT.getTable());
                        ms.selectData(table, new SelectData(a + 2));
                  }
            }

            VF_R.getJT().clearSelection();
            new LSTD().changeLSTD();

            //sc_JT.getVerticalScrollBar().setValue(sc_JT.getVerticalScrollBar().getMaximum());
            DT.bool_Del = false;
            System.out.println(CC.GREEN + "\n\tDELETE DATA" + CC.RESET);
      }
      
}
