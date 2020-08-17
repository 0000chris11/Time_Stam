/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners_F;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import First.VF_R;
import MC.DT;
import MC.MM;
import MC.MakeCon;
import MC.MethodM;
import Others.LSTD;
import MC.notMyMethods;
import Threads.Threads;
import javax.swing.JTable;

/**
 *
 * @author Christopher
 */
public class JTTableModelListener implements TableModelListener {

      //Data dt = new Data("JTTableModelListener");
      String CName = this.getClass().getName();
      //MethodM mm = new MethodM(CName, DT.CCount++);
      notMyMethods n_mm = new notMyMethods();
      MakeCon mc = new MakeCon(CName, DT.CCount++);
      LSTD lstd = new LSTD();
      Threads th = new Threads(CName, DT.CCount++);

      @Override
      public void tableChanged(TableModelEvent evt) {
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

                        int coln = VF_R.getJT().getSelectedColumn();
                        int rown = VF_R.getJT().getSelectedRow();
                        if (coln < 0 || rown < 0) {
                        } else {
                              Object data = VF_R.getJT().getValueAt(rown, coln);
                              //System.out.println("\tselectedColn(list_R): " + dt.getList_R().get(coln));
                              //System.out.println("\tdata: " + data);
                              if (!DT.getList_R().get(coln).equals(data)) {//ONLY UPDATES WHEN THE NEW VALUE IS DIFERENT FROM THE ORIGINAL
                                    //System.out.println("\t+ + + Diferent");
                                    String col = DT.getList_C().get(coln);

                                    DT.setTable(MM.filterTableName(DT.getTable(), "ADD"));

                                    mc.UpdateRow(DT.getTable(), col, data.toString(), DT.getList_R().get(0));
                                    lstd.changeLSTD(DT.getTable(), DT.getDist1(), DT.getDist2(), DT.getTabl(),
                                            DT.getTag(), DT.getClock());
                                    n_mm.rez(VF_R.getJT(), DT.autoState);
                                    //++++++++++++++++++++++++++++++
                                    th.setValueToCell(data, coln, rown);
                                    //++++++++++++++++++++++++++++++
                                    MM.typeConvert();
                              }
                        }
                  }
            }
            DT.cellSys = true;
            //System.out.println("TableChanged END");
      }

}
