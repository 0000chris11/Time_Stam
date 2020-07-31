package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import MC.MethodM;
import First.VF_R;
import First.VF_R;
import MC.DT;
import MC.MakeCon;
import MC.notMyMethods;
import Others.CC;
import Others.LSTD;
import Threads.Threads;
import java.util.concurrent.BrokenBarrierException;

/**
 *
 * @author Christopher
 */
public class BTNS_MCActionListener implements ActionListener {

      //Data dt = new Data();
      String CName = this.getClass().getName();
      
      //MethodM mm = new MethodM(CName, DT.CCount++);
      notMyMethods n_mm = new notMyMethods();
      MakeCon mc = new MakeCon(CName, DT.CCount++);
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
            ArrayList<String> newData = new ArrayList<String>();
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            int colN = -1;
            //int hc = 0;
            for (int a = 0; a < DT.maxColumns; a++) {
                  //System.out.println("UPD ListC " + a + ": "+ dt.getList_C().get(a));
            }
            for (int a = 0; a < DT.maxColumns; a++) {
                  //System.out.println("UPD ListR " + a + ": "+ dt.getList_R().get(a));
            }
            for (int a = 0; a < DT.maxColumns - 1; a++) {
                  if (VF_R.getJT().getColumnCount() == a + 2) {
                        for (int b = 0; b < a + 2; b++) {
                              if (!DT.getList_R().get(b).equals(VF_R.getJTFS()[b].getText()) 
                                      && !VF_R.getJTFS()[b].getText().equals("")
                                      && VF_R.getJTFS()[b].isVisible()) {
                                    
                                    newData.add(VF_R.getJTFS()[b].getText());
                                    colIndexs.add(b);
                                    //hc++;
                              }
                        }
                        colN = a + 2;
                  }
            }
            
            System.out.println("\tcolIndexs Size: " + colIndexs.size());
            System.out.println("\tnewData Size: " + newData.toArray().length);
            
            String[] cols = new String[colIndexs.size()];
            for(int a = 0; a < colIndexs.size(); a++){
                  //System.out.println("\tcolIndexs[" + a + "] = " + colIndexs.get(a));
                  cols[a] = DT.getList_C().get(colIndexs.get(a));
                  //System.out.println("\tcols[" + a + "] = " + cols[a]);
            }
            
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //UpdateRow(String table, Object[] cols, Object[] newvs, String id) {
            mc.UpdateRow(DT.getTable(), cols, newData.toArray(), DT.getList_R().get(0));
            mc.SelectData(colN, DT.getTable());

            colIndexs.clear();
            new LSTD().changeLSTD(DT.getTable(), DT.getDist1(), DT.getDist2(), 
                    DT.getTabl(), DT.getTag(), DT.getClock());

            DT.bool_Upd = false;
            System.out.println(CC.GREEN + "\n\tUPDATE DATA" + CC.RESET);
      }

      private void delOp() {
            DT.bool_Del = true;
            //System.out.println("\nDELETING DATA");

            mc.Delete(DT.getTable(), DT.getList_R().get(0));
            for (int a = 0; a < DT.maxColumns - 1; a++) {
                  if (VF_R.getJT().getColumnCount() == a + 2) {
                        mc.SelectData(a + 2, DT.getTable());
                  }
            }

            VF_R.getJT().clearSelection();
            new LSTD().changeLSTD(DT.getTable(), DT.getDist1(), DT.getDist2(), 
                    DT.getTabl(), DT.getTag(), DT.getClock());

            //sc_JT.getVerticalScrollBar().setValue(sc_JT.getVerticalScrollBar().getMaximum());
            DT.bool_Del = false;
            System.out.println(CC.GREEN + "\n\tDELETE DATA" + CC.RESET);
      }
      
}
