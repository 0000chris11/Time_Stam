/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.Actions;

import MC.DT;
import MC.MainInstances;
import com.cofii2.methods.MComp;
import com.cofii2.methods.MString;
import com.cofii2.myInterfaces.IMultiSelection;
import java.awt.Color;
import java.awt.event.ActionEvent;
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
public class BTNDistAction implements IMultiSelection {

      private VC_R_DataCom dt = MainInstances.getVC_R_DataCom();
      private VC_R_Comps c = MainInstances.getVC_R_Comps();

      private ArrayList<Integer> list;

      @Override
      public void action(EventObject e, ArrayList<Integer> list) {
            this.list = list;
            setLBDist();
            
            if (e instanceof ActionEvent) {
                  distdist2Control2(list);
                  setLBDist2(e);
                  setLinesAction(e);

            }
            c.enabledControl();
      }

      //+++++++++++++++++++++++++++++++++++++++++++++++++++++
      private void setLBDist() {
            String value = MString.getCustomDistTagFormat(list);

            JLabel lb = dt.getLBADist();
            lb.setText(value);
            if (value.equals("NONE")) {
                  lb.setForeground(Color.WHITE);
            } else {
                  lb.setForeground(Color.CYAN);
            }
      }

      private void setLBDist2(EventObject e) {
            ArrayList<Integer> listDist2 = MComp.getSelectedButtons(e, c.getBTNS_Dist2(), true);
            String value = MString.getCustomDist2Format(listDist2);

            JLabel lb = dt.getLBADist2();
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
                  int index = MComp.getLastDigitCharsCountAtEnd(btn.getName());
                  if (index == 1) {
                        dt.getGlass().startOne(index, index);
                  } else if (index == c.getColumnDisplayed()) {
                        dt.getGlass().startOne(index, index - 1);
                  } else {
                        dt.getGlass().startTwo(index, index - 1, index, index);
                  }
            }
      }

      //+++++++++++++++++++++++++++++++++++++++++++++++++++++
      public void distdist2Control(boolean bool) {
            int[] array = MString.getCustomDistTagSelected(dt.getLBADist().getText());
            if (array != null) {
                  for (int b = 0; b < DT.maxColumns - 1; b++) {
                        int length = c.getBTNS_Dist2()[b].getName().length();
                        String text = c.getBTNS_Dist2()[b].getName();
                        //System.out.println("TEST TEXT BTNS DIST 2: " + text);
                        int index1 = text.charAt(length - 1);
                        int index2 = text.charAt(length - 3);
                        for (int a = 0; a < array.length; a++) {
                              if (array[a] == index1 || array[a] == index2) {
                                    c.getBTNS_Dist2()[b].setEnabled(false);
                                    break;
                              } else {
                                    if (!bool) {
                                          c.getBTNS_Dist2()[b].setEnabled(true);
                                    }
                              }
                        }
                  }
            } else {
                  for (int b = 0; b < DT.maxColumns; b++) {
                        if (!bool) {
                              c.getBTNS_Dist2()[b].setEnabled(true);
                        }
                  }
            }
      }

      public void distdist2Control2(ArrayList<Integer> list) {
            for (int a = 0; a < list.size(); a++) {
                  int index = list.get(a) - 1;
                  for (int b = 0; b < DT.maxColumns - 1; b++) {
                        if (index == b) {
                              if (b == 0) {
                                    c.getBTNS_Dist2()[b].setSelected(false);//CHECK IF ITS STAR LISTENER
                              } else if (b == DT.maxColumns - 2) {
                                    c.getBTNS_Dist2()[b - 1].setSelected(false);
                              } else {
                                    c.getBTNS_Dist2()[b - 1].setSelected(false);
                                    c.getBTNS_Dist2()[b].setSelected(false);
                              }
                        }
                  }
            }
      }

}
