package views.first.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import views.first.VF_R;
import MC.DT;
import MC.DTSQL;
import MC.Status;
import MC.notMyMethods;
import com.cofii.myClasses.CC;
import Others.LSTD;
import SQLActions.DeleteRow;
import SQLActions.SelectData;
import SQLActions.Update;
import Threads.Threads;
import com.cofii.myClasses.MSQL;
import com.cofii.myMethods.MList;
import java.awt.Color;

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

            if (evt.getSource() == VF_R.getBTNS_MC()[0]) {
                  System.out.println(CC.GREEN + "\nADD DATA" + CC.RESET);
                  th.addOp();
            } else if (evt.getSource() == VF_R.getBTNS_MC()[1]) {
                  System.out.println(CC.GREEN + "\nUPDATE DATA" + CC.RESET);
                  updOp();
            } else if (evt.getSource() == VF_R.getBTNS_MC()[2]) {
                  System.out.println(CC.GREEN + "\nDELETE DATA" + CC.RESET);
                  delOp();
            }
      }
      
      private void updOp() {
            
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
                              if (!DT.getList_R().get(b).equals(VF_R.getJTFS()[b].getText()) 
                                      && !VF_R.getJTFS()[b].getText().equals("")//CHANGE WHEN U ALLOWED NULL FIELDS
                                      && VF_R.getJTFS()[b].isVisible()) {
                                    
                                    newData.add(VF_R.getJTFS()[b].getText());
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
            ms.updateRow(DT.getTable(), cols, newData.toArray(), "id", DT.getList_R().get(0), 
                    new Update("UpdateRow", VF_R.getLB_Status()));
            //mc.SelectData(colN, DT.getTable());
            ms.selectData(DT.getTable(), new SelectData(colN));

            colIndexs.clear();
            new LSTD().changeLSTD(DT.getTable(), DT.getDist1(), DT.getDist2(), 
                    DT.getImageC(), DT.getTag(), DT.getClock());

            DT.bool_Upd = false;
            System.out.println(CC.GREEN + "\n\tUPDATED DATA" + CC.RESET);
      }

      private void delOp() {
            DT.bool_Del = true;
            //System.out.println("\nDELETING DATA");

            String[] cols = MList.getListToArray(String.class, DT.getList_C());
            Object[] values = MList.getListToArray(Object.class, DT.getList_R());
            ms.deleteRow(DT.getTable(), cols, values, new DeleteRow(values));
            //mc.DeleteRow(DT.getTable(), DT.getList_R().get(0));
            for (int a = 0; a < DT.maxColumns - 1; a++) {
                  if (VF_R.getJT().getColumnCount() == a + 2) {
                        //mc.SelectData(a + 2, DT.getTable());
                        ms.selectData(DT.getTable(), new SelectData(a + 2));
                  }
            }

            VF_R.getJT().clearSelection();
            new LSTD().changeLSTD(DT.getTable(), DT.getDist1(), DT.getDist2(), 
                    DT.getImageC(), DT.getTag(), DT.getClock());

            //sc_JT.getVerticalScrollBar().setValue(sc_JT.getVerticalScrollBar().getMaximum());
            DT.bool_Del = false;
            System.out.println(CC.GREEN + "\n\tDELETE DATA" + CC.RESET);
      }
      
}
