/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.first.listeners;

import MC.DT;
import MC.TableInfoC;
import com.cofii2.methods.MTable;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import views.first.VF_R;

/**
 *
 * @author C0FII
 */
public class JT_LSL implements ListSelectionListener {

      //Data dt = new Data("JT_LSL");
      String CName = this.getClass().getName();
      //MethodM mm = new MethodM(CName, DT.CCount++);

      @Override
      public void valueChanged(ListSelectionEvent evt) {
            if (VF_R.getJT().getSelectionModel().isSelectionEmpty()) {
                  //DISABLE BTN DELETE AND UPDATE IF NO ROW IS SELECTED
                  VF_R.getBTNS_MC()[1].setEnabled(false);
                  VF_R.getBTNS_MC()[2].setEnabled(false);
            } else {
                  if (DT.bool_Del == false || DT.bool_Add == false) {
                        //RESETING PROGRESS BAR
                        VF_R.getJPB().setVisible(false);
                        VF_R.getJPB().setForeground(Color.RED);
                        VF_R.getJPB().setValue(0);
                        //DELETE AND UPDATE ENABLED
                        VF_R.getBTNS_MC()[1].setEnabled(true);
                        VF_R.getBTNS_MC()[2].setEnabled(true);

                        //UPDATE ROW LIST (LIST_R) - MAY BE UNNECESARY
                        MTable.typeConvert(VF_R.getJT(), DT.getList_R(),
                                VF_R.getJT().getSelectionModel().getMinSelectionIndex());
                        //++++++++++++++++++++++++++++++++++++++++++++
                        for (int a = 0; a < DT.getList_R().size(); a++) {
                              //System.out.println("ListR " + a + ": "+ dt.getList_R().get(a));
                        }
                        //SET TEXT TO RESPECTIVE TFS
                        for (int a = 0; a < DT.maxColumns; a++) {
                              if (VF_R.getJT().getColumnCount() == a + 1) {
                                    for (int b = 0; b < a + 1; b++) {
                                          //CASE FOR PRIMARY KEY; EVERY OTHER COLUMN CHANGE ITS NAME BUT THE PK ONE
                                          if (DT.getPrimaryKey() > 0) {
                                                if (b != DT.getPrimaryKey() - 1) {//IF PK SET TEXT TO ALL BUT PK COLUMN
                                                      if (VF_R.getJTFPanel()[b].getComponent(0).getName().contains("CB")) {
                                                            VF_R.getJTFES()[b].setText(DT.getList_R().get(b).toString());
                                                      }else{
                                                            VF_R.getJTFS()[b].setText(DT.getList_R().get(b).toString());
                                                      }
                                                }
                                          } else if ((int) DT.getExtra()[0] > 0) {
                                                if (b != (int) DT.getExtra()[0] - 1) {//IF EXT SET TEXT TO ALL BUT EXT COLUMN
                                                      if (VF_R.getJTFPanel()[b].getComponent(0).getName().contains("CB")) {
                                                            VF_R.getJTFES()[b].setText(DT.getList_R().get(b).toString());
                                                      }else{
                                                            VF_R.getJTFS()[b].setText(DT.getList_R().get(b).toString());
                                                      }
                                                }
                                          } else {
                                                if (VF_R.getJTFPanel()[b].getComponent(0).getName().contains("CB")) {
                                                            VF_R.getJTFES()[b].setText(DT.getList_R().get(b).toString());
                                                      }else{
                                                            VF_R.getJTFS()[b].setText(DT.getList_R().get(b).toString());
                                                      }
                                          }
                                    }
                              }
                        }
                        //++++++++++++++++++++++++++++++++++++++++++++
                        lb_IconChange();
                        //+++++++++++++++++++++++
                  }
            }
      }

      private void lb_IconChange() {
            String imageC = TableInfoC.getImageC();
            if (!imageC.equals("NONE")) {
                  //GET INDEX OF COLUMN FOR ICON RECOG
                  int row = VF_R.getJT().getSelectedRow();
                  int col = Character.getNumericValue(imageC.charAt(1)) - 1;

                  //MATCH CELL VALUE TO ICON URL NAME
                  int z = 0;
                  String value = VF_R.getJT().getValueAt(row, col).toString();
                  for (int a = 0; a < DT.getList_cutUrl().size(); a++) {
                        //IF TAG
                        if (VF_R.getJT().getValueAt(row, col).toString().contains("; ")) {
                              String ss = VF_R.getJT().getValueAt(row, col).toString();
                              value = ss.substring(ss.indexOf("; ") + 2, ss.length());
                        }
                        if (value.equals(DT.getList_cutUrl().get(a))) {
                              z = 1;
                              VF_R.getLB_Icon().setText(null);
                              ImageIcon ii = DT.getList_newIcon().get(a);
                              VF_R.getLB_Icon().setIcon(ii);
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
