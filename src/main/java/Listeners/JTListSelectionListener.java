/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import First.VF_R;
import MC.DT;
import MC.MM;
import MC.MethodM;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Christopher
 */
public class JTListSelectionListener implements ListSelectionListener {

      //Data dt = new Data("JTListSelectionListener");
      String CName = this.getClass().getName();
      //MethodM mm = new MethodM(CName, DT.CCount++);

      @Override
      public void valueChanged(ListSelectionEvent evt) {
            if (VF_R.getJT().getSelectionModel().isSelectionEmpty()) {
                  VF_R.getBTNS_MC()[1].setEnabled(false);
                  VF_R.getBTNS_MC()[2].setEnabled(false);
            } else {
                  //System.out.println("\nENTERING valueChanged");
                  if (DT.bool_Del == false || DT.bool_Add == false) {
                        //System.out.println("----selected");
                        //((AbstractTableModel)VF_R.getJT().getModel()).fireTableCellUpdated(
                          //      VF_R.getJT().getSelectedRow(), VF_R.getJT().getSelectedColumn());
                        VF_R.getJPB().setVisible(false);
                        VF_R.getJPB().setForeground(Color.RED);
                        VF_R.getJPB().setValue(0);
                        //System.out.println("\tVALUE CHANGING");
                        //btn_Update.setEnabled(true);
                        VF_R.getBTNS_MC()[1].setEnabled(true);
                        VF_R.getBTNS_MC()[2].setEnabled(true);

                        MM.typeConvert();
                        //++++++++++++++++++++++++++++++++++++++++++++
                        for (int a = 0; a < DT.getList_R().size(); a++) {
                              //System.out.println("ListR " + a + ": "+ dt.getList_R().get(a));
                        }
                        for (int a = 0; a < DT.maxColumns - 1; a++) {
                              if (VF_R.getJT().getColumnCount() == a + 2) {
                                    for (int b = 0; b < a + 2; b++) {
                                          VF_R.getJTFS()[b].setText(DT.getList_R().get(b));
                                    }
                              }
                        }
                        //++++++++++++++++++++++++++++++++++++++++++++
                        if (VF_R.getLB_Icon().isVisible()) {
                              DT.chars[0] = DT.getTabl().charAt(1);
                              DT.strings[0] = Character.toString(DT.chars[0]);
                              DT.ints[0] = Integer.parseInt(DT.strings[0]);

                              int row = VF_R.getJT().getSelectedRow();
                              //int col = tbm.getColumnIndex(o);
                              int col = DT.ints[0] - 1;

                              //String ss = list_Icon.get(n2);
                              int z = 0;
                              String Data = VF_R.getJT().getValueAt(row, col).toString();
                              for (int a = 0; a < DT.getList_cutUrl().size(); a++) {
                                    //System.out.println("\tValueAt: " + JT.getValueAt(row, col).toString()+
                                    //      " is "+ list_cutUrl.get(a));
                                    if (VF_R.getJT().getValueAt(row, col).toString().contains("; ")) {
                                          String ss = VF_R.getJT().getValueAt(row, col).toString();
                                          Data = ss.substring(ss.indexOf("; ") + 2, ss.length());
                                    }
                                    if (Data.equals(DT.getList_cutUrl().get(a))) {
                                          z = 1;
                                          VF_R.getLB_Icon().setText(null);
                                          VF_R.getLB_Icon().setIcon(DT.getList_newIcon().get(a));
                                    } else {
                                          if (z == 1) {
                                          } else {
                                                VF_R.getLB_Icon().setIcon(null);
                                                VF_R.getLB_Icon().setText("NO COVER");
                                          }
                                    }
                              }
                        }
                  }
            }
      }
      
}
