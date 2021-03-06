/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.first.listeners;

import MC.DT;
import MC.DTSQL;
import MC.notMyMethods;
import SQLActions.Update;
import SQLStores.TableDistC;
import Threads.Threads;
import others2.DISTS;

import com.cofii2.methods.MTable;
import com.cofii2.mysql.MSQL;
import com.cofii2.stores.CC;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import views.first.VF_R;

/**
 *
 * @author Christopher
 */
public class JT_ML implements TableModelListener {

      //Data dt = new Data("JT_ML");
      String CName = this.getClass().getName();
      //MethodM mm = new MethodM(CName, DT.CCount++);
      notMyMethods n_mm = new notMyMethods();
      MSQL ms = new MSQL(DTSQL.getURLConnection(), DTSQL.getUser(), DTSQL.getPassw());
      Threads th = new Threads();

      @Override
      public void tableChanged(TableModelEvent evt) {
            System.out.println(CC.PURPLE + "tableChanged" + CC.RESET);
            /*
            System.out.println("+++TableChanged: "
                    + " \nbool_Add: " + Data.bool_Add
                    + " \nbool_Upd: " + Data.bool_Upd
                    + " \nbool_Del: " + Data.bool_Del
                    + " \nbool_Sel: " + Data.bool_Sel
                    + " \nbool_Chan: " + Data.bool_Chan);
             */
            if (DT.bool_Add == false && DT.bool_Upd == false && DT.bool_Del == false
                    && DT.bool_Sel == false && DT.bool_Chan == false) {
                  if (DT.cellSys == true) {
                        String table = TableDistC.getTable();
                        
                        int coln = VF_R.getJT().getSelectedColumn();
                        int rown = VF_R.getJT().getSelectedRow();
                        if (coln < 0 || rown < 0) {
                        } else {
                              Object data = VF_R.getJT().getValueAt(rown, coln);
                              //System.out.println("\tselectedColn(list_R): " + dt.getList_R().get(coln));
                              //System.out.println("\tdata: " + data);
                              if (!DT.getList_R().get(coln).equals(data)) {//ONLY UPDATES WHEN THE NEW VALUE IS DIFERENT FROM THE ORIGINAL
                                    System.out.println("\t+ + + Diferent");
                                    String col = DT.getList_C().get(coln);

                                    //mc.UpdateRow(DT.getTable(), col, data.toString(), DT.getList_R().get(0));
                                    ms.updateRow(table, col, data, 
                                            DT.getList_C().get(0), DT.getList_R().get(0),
                                            new Update("UpdateRow", VF_R.getLB_Status()));
                                    
                                    DISTS.start(false, false);
                                    n_mm.rez(VF_R.getJT(), DT.autoState);
                                    //++++++++++++++++++++++++++++++
                                    th.setValueToCell(data, coln, rown);
                                    //+MAYBE+UNNECESARY++++++++++++++++++++++++++++
                                    MTable.typeConvert(VF_R.getJT(), DT.getList_R(),
                                            VF_R.getJT().getSelectionModel().getMinSelectionIndex());
                              }else{
                                    System.out.println("\t- - - Same");
                              }
                        }
                  }
            }
            DT.cellSys = true;
      }

}
