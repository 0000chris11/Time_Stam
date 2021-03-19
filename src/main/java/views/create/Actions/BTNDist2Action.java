/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.Actions;

import MC.DT;
import MC.MainInstances;
import com.cofii2.methods.MComp;
import com.cofii2.methods.MList;
import com.cofii2.methods.MString;
import com.cofii2.myInterfaces.IMultiSelection;
import com.cofii2.stores.DInt;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.EventObject;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import views.createUpdate.VC_R_Comps;
import views.createUpdate.VC_R_DataCom;

/**
 *
 * @author C0FII
 */
public class BTNDist2Action implements IMultiSelection {

      private VC_R_DataCom dt = MainInstances.getVC_R_DataCom();
      private VC_R_Comps c = MainInstances.getVC_R_Comps();

      private ArrayList<Integer> list;

      private String[] options = {"selected", "unselected", "disabled"};
      private int[] times = new int[DT.maxColumns - 1];

      private boolean doo = true;

      @Override
      public void action(EventObject e, ArrayList<Integer> list) {          
            if (doo) {
                  this.list = list;
                  setLBDist2();

                  //dist2EnabledControl2();
                  if (e instanceof ActionEvent) {
                        dist2EnabledControl4(list);
                        setLBDist(e);
                        setLinesAction(e);
                  }
            }
      }
      //+++++++++++++++++++++++++++++++++++++++++++++++++
      private void setLBDist2() {
            String value = MString.getCustomDist2Format(list);

            JLabel lb = dt.getLBADist2();
            lb.setText(value);
            if (value.equals("NONE")) {
                  lb.setForeground(Color.WHITE);
            } else {
                  lb.setForeground(Color.CYAN);
            }
      }
      
      private void setLBDist(EventObject e) {
            ArrayList<Integer> listDist = MComp.getSelectedButtons(e, c.getBTNS_Dist(), true);
            String value = MString.getCustomDist2Format(listDist);

            JLabel lb = dt.getLBADist();
            lb.setText(value);
            if (value.equals("NONE")) {
                  lb.setForeground(Color.WHITE);
            } else {
                  lb.setForeground(Color.CYAN);
            }
      }
      
      private void setLinesAction(EventObject e) {
            JToggleButton btn = (JToggleButton) e.getSource();
            if (btn.isSelected()) {
                  int index = MComp.getLastDigitCharsCountAtEnd(btn.getName()) - 1;
                  dt.getGlass().startTwo(index, index, index + 1, index);
            }
      }
      //+++++++++++++++++++++++++++++++++++++++++++++++++
      public void dist2EnabledControl() {
            //DInt[] array = MString.getCustomDist2Selected(dt.getLBADist2().getText());
            boolean[] selected = new boolean[DT.maxColumns - 1];
            for (int b = 0; b < DT.maxColumns - 1; b++) {
                  //JToggleButton btn = c.getBTNS_Dist2()[b];
                  for (int a = 0; a < list.size(); a++) {
                        int index = list.get(a);
                        selected[index - 1] = true;

                        if (a + 1 == index) {
                              if (index == 1) {
                                    c.getBTNS_Dist2()[b + 1].setEnabled(false);
                                    selected[index] = false;
                              } else if (index == DT.maxColumns - 2) {
                                    c.getBTNS_Dist2()[b - 1].setEnabled(false);
                                    selected[index - 2] = false;
                              } else {
                                    c.getBTNS_Dist2()[b - 1].setEnabled(false);
                                    c.getBTNS_Dist2()[b + 1].setEnabled(false);
                                    selected[index] = false;
                                    selected[index - 2] = false;
                              }
                        }
                  }
                  if (selected[b]) {
                  }
            }
      }

      public void dist2EnabledControl2() {
            doo = false;
            for (int a = 0; a < DT.maxColumns - 1; a++) {
                  times[a] = 0;
            }
            for (int a = 0; a < DT.maxColumns - 1; a++) {
                  if (c.getBTNS_Dist2()[a].isSelected() && c.getBTNS_Dist2()[a].isEnabled()) {
                        if (a != 0) {
                              c.getBTNS_Dist2()[a - 1].setEnabled(false);
                              times[a - 1]++;
                        }
                        if (a != DT.maxColumns - 2) {
                              System.out.println("//////////// NEXT ONE TURNS ----" + (a + 1) + "-" + (a + 2) + "---- FALSE");
                              c.getBTNS_Dist2()[a + 1].setEnabled(false);
                              System.out.println("\tbtns_Dist2[3]: " + c.getBTNS_Dist2()[2].isEnabled());
                              times[a + 1]++;
                        }
                  } else if (!c.getBTNS_Dist2()[a].isSelected() && c.getBTNS_Dist2()[a].isEnabled()) {
                        if (a != 0) {
                              if (times[a - 1] == 2) {
                                    c.getBTNS_Dist2()[a - 1].setEnabled(true);
                              }
                              times[a - 1]--;
                        }
                        if (a != DT.maxColumns - 2) {
                              if (times[a + 1] == 1) {
                                    System.out.println("//////////// NEXT ONE TURNS --------- TRUE");
                                    c.getBTNS_Dist2()[a + 1].setEnabled(true);
                              }
                              times[a + 1]--;
                        }
                  }
            }
            System.out.println("\tbtns_Dist2[3]: " + c.getBTNS_Dist2()[2].isEnabled());
            doo = true;
      }

      public void dist2EnabledControl3() {
            doo = false;
            for (int a = 0; a < DT.maxColumns - 1; a++) {
                  times[a] = 0;
            }
            for (int a = 0; a < DT.maxColumns - 1; a++) {
                  if (c.getBTNS_Dist2()[a].isSelected() && c.getBTNS_Dist2()[a].isEnabled()) {
                        if (a != 0) {
                              c.getBTNS_Dist2()[a - 1].setEnabled(false);
                        }
                        if (a != DT.maxColumns - 2) {
                              System.out.println("//////////// NEXT ONE TURNS ----" + (a + 1) + "-" + (a + 2) + "---- FALSE");
                              c.getBTNS_Dist2()[a + 1].setEnabled(false);
                              System.out.println("\tbtns_Dist2[3]: " + c.getBTNS_Dist2()[2].isEnabled());
                        }
                  } else if (!c.getBTNS_Dist2()[a].isSelected() && c.getBTNS_Dist2()[a].isEnabled()) {
                        if (a != 0) {
                              if (a - 1 != 0) {
                                    if (!c.getBTNS_Dist2()[a - 2].isSelected()) {
                                          c.getBTNS_Dist2()[a - 1].setEnabled(true);
                                    }
                              }
                        }
                  }
            }
            System.out.println("\tbtns_Dist2[3]: " + c.getBTNS_Dist2()[2].isEnabled());
            doo = true;
      }

      public void dist2EnabledControl4(ArrayList<Integer> list) {
            for (int a = 0; a < list.size(); a++) {
                  int index = list.get(a) - 1;
                  for (int b = 0; b < DT.maxColumns; b++) {
                        if (index == b) {
                              c.getBTNS_Dist()[b].setSelected(false);
                              c.getBTNS_Dist()[b + 1].setSelected(false);
                        }
                  }
            }
      }
}
