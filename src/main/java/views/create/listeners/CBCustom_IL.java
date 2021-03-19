/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import MC.DT;
import MC.MainInstances;
import com.cofii2.custom.ComboBoxCellRenderer;
import com.cofii2.myInterfaces.ComboBoxsAction;
import com.cofii2.stores.IntObject;
import com.cofii2.stores.StringBoolean;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.util.EventObject;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import views.createUpdate.VC_R_Comps;
import views.createUpdate.VC_R_DataCom;

/**
 *
 * @author C0FII
 */
public class CBCustom_IL implements ComboBoxsAction {

      private VC_R_DataCom dt = MainInstances.getVC_R_DataCom();
      private VC_R_Comps c = MainInstances.getVC_R_Comps();
      private int count = 0;

      @Override
      public void action(EventObject e, IntObject[] array) {
            JComboBox cb = (JComboBox) e.getSource();
            JTextField tf = (JTextField) cb.getEditor().getEditorComponent();

            if (e instanceof ItemEvent) {
                  ItemEvent ie = (ItemEvent) e;

                  if (ie.getStateChange() == ItemEvent.SELECTED) {
                        //distControl();
                        forgroundChange();
                        function(array);
                        forgroundChange();
                  }
            } else {
                  //distControl();
                  forgroundChange();
                  function(array);
                  forgroundChange();

            }

      }

      /**
       * Not implement method: stopped bc i'll would have to manage types, tags and control TFS on VF_R
       */
      private void distControl() {
            for (int a = 0; a < DT.maxColumns - 1; a++) {
                  ComboBoxCellRenderer cr = (ComboBoxCellRenderer) c.getCBS_Customs()[a].getRenderer();
                  if (!c.getCBS_Customs()[a + 1].isVisible()) {
                        cr.set("Dist2", false);
                        //System.out.println("TEST distControl SET FALSE");
                  } else {
                        //ConcurrentModificationException FIX
                        cr.set("Dist2", true);
                  }
            }
            ((ComboBoxCellRenderer) c.getCBS_Customs()[DT.maxColumns - 1].getRenderer()).set("Dist2", false);
      }

      private void function(IntObject[] array){
            //System.out.println("TEST function ARRAY LENGTH: " + array.length);
            String dist = "NONE";
            int dc = 0;
            for (int a = 0; a < array.length; a++) {
                  int index = array[a].index;
                  String item = array[a].object.toString();
                  if (item.equals("Dist")) {
                        if (dist.equals("NONE")) {
                              dist = "X" + (++dc) + ": " + index;
                        } else {
                              dist = dist.replaceFirst(Integer.toString(dc), Integer.toString(++dc));
                              dist += "_" + (a + 1);
                        }
                  }
                  
            }
            dt.getLBADist().setText(dist);
            if (dist.equals("NONE")) {
                  dt.getLBADist().setForeground(Color.WHITE);
            } else {
                  dt.getLBADist().setForeground(Color.CYAN);
            }
      }
      
      /**
       * Not implement method: stopped bc i'll would have to manage types, tags and control TFS on VF_R
       * 
       * @param array Array of result of each selection of Visible Combox
       */
      private void functionWithDist(IntObject[] array) {
            String dist = "NONE";
            int dc = 0;
            String dist2 = "NONE";
            int d2c = 0;
            System.out.println("TEST FUNCTION");
            //System.out.println("TEST function TF FOREGROUND: " + tf.getForeground());
            //System.out.println("TEST function ComboBoxCellRenderer.foregroundDisable: " + ComboBoxCellRenderer.foregroundDisable);
            for (int a = 0; a < array.length; a++) {
                  String item = array[a].object.toString();
                  Color foreground = c.getTFE_Customs()[a].getForeground();
                  boolean nextVisible;
                  if (a != DT.maxColumns - 1) {
                        nextVisible = c.getCBS_Customs()[a + 1].isVisible();
                  } else {
                        nextVisible = false;
                  }
                  System.out.println("\titem: " + item);
                  System.out.println("\tforeground: " + foreground);

                  if (item.equals("Dist")) {
                        System.out.println("\t\tOPTION 1 - " + (a + 1));
                        if (dist.equals("NONE")) {
                              dist = "X" + (++dc) + ": " + (a + 1);
                        } else {
                              dist = dist.replaceFirst(Integer.toString(dc), Integer.toString(++dc));
                              dist += "_" + (a + 1);
                        }
                        if (a != DT.maxColumns - 1 /* && c.getTFE_Customs()[a].getText().equals("Dist2")*/) {
                              c.getCBS_Customs()[a + 1].setEnabled(true);
                              c.getTFE_Customs()[a + 1].setText("NONE");
                        }
                  } else if (item.equals("Dist2") && nextVisible
                          && !foreground.equals(ComboBoxCellRenderer.foregroundDisable)) {
                        System.out.println("\t\tOPTION 2 - " + (a + 1));
                        if (dist2.equals("NONE")) {
                              dist2 = "X" + (++d2c) + ": " + (a + 1) + "-" + (a + 2);
                        } else {
                              dist2 = dist2.replaceFirst(Integer.toString(d2c), Integer.toString(++d2c));
                              dist2 += "_" + (a + 1) + "-" + (a + 2);
                        }
                        if (a != DT.maxColumns - 1) {
                              c.getCBS_Customs()[a + 1].setEnabled(false);
                              c.getTFE_Customs()[a + 1].setText(" - - - - - - ");

                        }
                  } else {
                        System.out.println("\t\tOPTION 3 - " + (a + 1));
                        if (a != DT.maxColumns - 1/* && c.getTFE_Customs()[a].getText().equals("Dist2")*/) {
                              c.getCBS_Customs()[a + 1].setEnabled(true);
                              c.getTFE_Customs()[a + 1].setText("NONE");
                        }
                  }
            }

            //((ListCellRenderer) c.getCBS_FK()[0].getItemAt(0))
            //++++++++++++++++++++++++++++++++++++++++++
            //System.out.println("TEST CBCustom_IL " + (++count));
            dt.getLBADist().setText(dist);
            if (dist.equals("NONE")) {
                  dt.getLBADist().setForeground(Color.WHITE);
            } else {
                  dt.getLBADist().setForeground(Color.CYAN);
            }
            dt.getLBADist2().setText(dist2);
            if (dist2.equals("NONE")) {
                  dt.getLBADist2().setForeground(Color.WHITE);
            } else {
                  dt.getLBADist2().setForeground(Color.CYAN);
            }
      }

      private void forgroundChange() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  JComboBox cb = c.getCBS_Customs()[a];
                  JTextField tf = c.getTFE_Customs()[a];
                  ComboBoxCellRenderer renderer = (ComboBoxCellRenderer) cb.getRenderer();
                  for (StringBoolean x : renderer.getDisablesItems()) {
                        String string = x.string;
                        boolean bool = x.bool;
                        if (cb.getSelectedItem().toString().equals(string) && !bool) {
                              tf.setForeground(ComboBoxCellRenderer.foregroundDisable);
                              break;
                        } else {
                              tf.setForeground(Color.WHITE);
                        }
                  }
            }

      }

      /**
       * Couln't continue bc first i need to change all DISTS to the same format
       * (X2: ?_?)
       */
      private void variousTypes(IntObject[] array) {
            String[] values = new String[c.getCustoms().length - 1];
            for (String x : values) {
                  x = "NONE";
            }

            for (int a = 0; a < array.length; a++) {
                  int index = array[a].index;
                  String item = array[a].object.toString();
                  for (int b = 0; b < c.getCustoms().length; b++) {
                        if (item.equals(c.getCustoms()[b].toString())) {
                              if (b != 0) {//ANYTHING BUT NONE
                                    if (values[b].equals("")) {

                                    }
                              }
                        }
                  }

            }
      }
}
