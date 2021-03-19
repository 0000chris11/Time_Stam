/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.first.listeners;

import MC.DT;
import SQLStores.TableDistC;
import SQLStores.TableKeysC;
import SQLStores.TableTypeC;
import com.cofii2.methods.MImage;
import com.cofii2.methods.MString;
import com.cofii2.methods.MTable;
import com.cofii2.stores.CC;
import java.awt.Dimension;
import javax.swing.Icon;
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

                  //System.out.println("TEST SELECTION IS EMPTY");
            } else {
                  //System.out.println("TEST SELECTION --- OUT");
                  if (DT.bool_Del == false || DT.bool_Add == false) {
                        //System.out.println("TEST SELECTION --- IN");
                        //RESETING PROGRESS BAR
                        /*
                        VF_R.getJPB().setVisible(false);
                        VF_R.getJPB().setForeground(Color.RED);
                        VF_R.getJPB().setValue(0);
                         */
                        //DELETE AND UPDATE ENABLED
                        VF_R.getBTNS_MC()[1].setEnabled(true);
                        VF_R.getBTNS_MC()[2].setEnabled(true);

                        //UPDATE ROW LIST (LIST_R) - MAY BE UNNECESARY
                        MTable.typeConvert(VF_R.getJT(), DT.getList_R(),
                                VF_R.getJT().getSelectionModel().getMinSelectionIndex());
                        //++++++++++++++++++++++++++++++++++++++++++++
                        //int pk = TableKeysC.getPK().index;
                        int ex = TableTypeC.getEX().index;
                        //SET TEXT TO RESPECTIVE TFS
                        for (int a = 0; a < DT.maxColumns; a++) {
                              if (VF_R.getJT().getColumnCount() == a + 1) {
                                    for (int b = 0; b < a + 1; b++) {
                                          //CASE FOR PRIMARY KEY; EVERY OTHER COLUMN CHANGE ITS NAME BUT THE PK ONE
                                          for (int c = 0; c < TableKeysC.getPK().length; c++) {
                                                int pk = TableKeysC.getPK()[c].index;
                                                if (pk > 0 || ex > 0) {
                                                      if (b != pk - 1 || b != ex - 1) {//IF PK SET TEXT TO ALL BUT PK COLUMN
                                                            setTextTo(b);
                                                      }
                                                } else {
                                                      setTextTo(b);
                                                }
                                          }
                                    }
                              }
                        }
                        //++++++++++++++++++++++++++++++++++++++++++++
                        lb_IconChange2();
                        //+++++++++++++++++++++++
                  }
            }
      }

      private void setTextTo(int b) {
            String selected = VF_R.tfPanelSelected[b];
            if (selected.equalsIgnoreCase(VF_R.tfPanelTypes[0])) {
                  VF_R.getJTFS()[b].setText(DT.getList_R().get(b).toString());
            } else if (selected.equalsIgnoreCase(VF_R.tfPanelTypes[1])) {
                  VF_R.getJTFES()[b].setText(DT.getList_R().get(b).toString());
            } else if (selected.equalsIgnoreCase(VF_R.tfPanelTypes[2])) {
                  VF_R.getJTF_CKS()[b].setText(DT.getList_R().get(b).toString());
            }
      }

      private void lb_IconChange() {
            String imageC = TableDistC.getImageC();
            if (!imageC.equals("NONE")) {
                  //GET INDEX OF COLUMN FOR ICON RECOG
                  int row = VF_R.getJT().getSelectedRow();
                  int col = Character.getNumericValue(imageC.charAt(1)) - 1;

                  //MATCH CELL VALUE TO ICON URL NAME
                  int z = 0;
                  System.out.println("TEST JTLST ICON CHANGE");
                  String value = VF_R.getJT().getValueAt(row, col).toString();
                  for (int a = 0; a < DT.getList_cutUrl().size(); a++) {
                        String cutUrl = DT.getList_cutUrl().get(a);
                        System.out.println("\tValue: " + value);
                        System.out.println("\tcutUrl: " + cutUrl);
                        //IF TAG
                        if (VF_R.getJT().getValueAt(row, col).toString().contains("; ")) {
                              String ss = VF_R.getJT().getValueAt(row, col).toString();
                              value = ss.substring(ss.indexOf("; ") + 2, ss.length());
                        }
                        if (value.equals(cutUrl)) {
                              z = 1;
                              VF_R.getLBSIcons()[0].setText(null);
                              ImageIcon ii = DT.getList_Icon().get(a);
                              VF_R.getLBSIcons()[0].setIcon(ii);
                        } else {
                              if (z == 1) {
                              } else {
                                    VF_R.getLBSIcons()[0].setIcon(null);
                                    VF_R.getLBSIcons()[0].setText("NO MATCH");
                              }
                        }
                  }
            }
      }

      private void lb_IconChange2() {
            String imageC = TableDistC.getImageC();
            if (!imageC.equals("NONE")) {
                  //GET INDEX OF COLUMN FOR ICON RECOG
                  int row = VF_R.getJT().getSelectedRow();
                  int col = Character.getNumericValue(imageC.charAt(1)) - 1;
                  String value = VF_R.getJT().getValueAt(row, col).toString();
                  String[] values = MString.getTags(value, 2);
                  MImage.setOption(MImage.DRAW_IMAGE);

                  boolean[] iconsMatch = new boolean[DT.maxIcons];
                  for (boolean x : iconsMatch) {
                        x = false;
                  }
                  for (int a = 0; a < DT.getList_IconName().size(); a++) {
                        String url = DT.getList_IconName().get(a);

                        if (values.length == 1) {
                              hideLBSICONS();
                              if (value.equals(url)) {
                                    VF_R.getLBSIcons()[0].setText(null);

                                    Icon ii = new ImageIcon(DT.getList_IconHolePath().get(a));
                                    Dimension newD = MImage.getScaledDownDimension_AR(
                                            ii.getIconWidth(), ii.getIconHeight(), 255, 255);

                                    VF_R.getLBSIcons()[0].setPreferredSize(newD);

                                    ii = MImage.resizeIcon((ImageIcon) ii, newD);

                                    VF_R.getLBSIcons()[0].setIcon(ii);
                                    break;
                              } else {
                                    //System.out.println("TEST ICON SELECTION");
                                    //System.out.println("\tvalue: " + value);
                                    //System.out.println("\turl: " + url);
                                    VF_R.getLBSIcons()[0].setIcon(null);
                                    VF_R.getLBSIcons()[0].setText("NO MATCH");
                              }
                        } else {
                              System.out.println(CC.CYAN + "TEST MATCH 2" + CC.RESET);
                              for (int b = 0; b < values.length; b++) {
                                    VF_R.getLBSIcons()[b].setVisible(true);
                                    if (values[b].equals(url)) {
                                          VF_R.getLBSIcons()[b].setText(null);

                                          Icon ii = new ImageIcon(DT.getList_IconHolePath().get(a));
                                          Dimension newD = MImage.getScaledDownDimension_AR(
                                                  ii.getIconWidth(), ii.getIconHeight(), 255, 255);

                                          VF_R.getLBSIcons()[b].setPreferredSize(newD);
                                          ii = MImage.resizeIcon((ImageIcon) ii, newD);

                                          VF_R.getLBSIcons()[b].setIcon(ii);
                                          iconsMatch[b] = true;
                                    } else {
                                          if (!iconsMatch[b]) {
                                                System.out.println("\tvalue: " + values[b] + " (" + (b + 1) + ")");
                                                System.out.println("\turl: " + url);
                                                VF_R.getLBSIcons()[b].setIcon(null);
                                                VF_R.getLBSIcons()[b].setText("NO MATCH");

                                                iconsMatch[b] = false;
                                          }
                                    }
                              }
                        }
                  }
            }
      }

      private void hideLBSICONS() {
            for (int a = 1; a < DT.maxIcons; a++) {
                  VF_R.getLBSIcons()[a].setVisible(false);
            }
      }
}
