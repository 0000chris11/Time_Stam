/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import MC.DTSQL;
import MC.MainInstances;
import com.cofii2.methods.MComp;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import views.createUpdate.VC_R_Comps;

/**
 *
 * @author C0FII
 */
public class CBSTypes_IL implements ItemListener {

      private VC_R_Comps c = MainInstances.getVC_R_Comps();
      private int index = 0;

      public CBSTypes_IL(int index) {
            this.index = index;
      }

      @Override
      public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                  JComboBox cb = (JComboBox) e.getSource();
                  JTextField tf = c.getTFSTypes()[index];

                  btnChangeControl(cb);
                  
                  boolean[] array = DTSQL.mysqlTypesFixedSize;
                  int selected = cb.getSelectedIndex();
                  boolean bool = array[selected];

                  if (bool) {
                        //System.out.println("TEST enter types true (" + tf.getName() + ")");
                        tf.setVisible(true);
                        int intx = cb.getSelectedIndex();
                        tf.setText(Integer.toString(DTSQL.mysql_TypesIntDefaultSize[intx]));
                        MComp.setOnlyNumbersAllowed(tf, DTSQL.mysql_TypesIntMinSize[intx], DTSQL.mysql_TypesIntMaxSize[intx]);
                        tf.setToolTipText("Max " + DTSQL.mysql_TypesIntMaxSize[intx]);

                  } else {
                        tf.setVisible(false);

                  }

                  sizeChange(bool);

                  c.getPanelsTypes()[index].revalidate();
                  //*+++++++++++++++++++++++++++++++++
                  //enabledControl(index);
                  c.enabledControl();
            }

      }
      
      private void btnChangeControl(JComboBox cb){
            if(c.getUpdateStore() != null){
                        String typeC = c.getUpdateStore().getTypes()[index].string;
                        String type = cb.getSelectedItem().toString().toUpperCase();
                        int typeWidthC = c.getUpdateStore().getTypes()[index].index;
                        int typeWidth = Integer.parseInt(c.getTFSTypes()[index].getText());
                        if(type.equals(typeC) && typeWidth == typeWidthC){
                              c.getBTNSChange_Types()[index].setEnabled(false);
                        }else{
                              c.getBTNSChange_Types()[index].setEnabled(true);
                        }
                  }
      }

      private void enabledControl(int index) {
            System.out.println("TEST INDEX: " + index);
            boolean extra = MComp.areThisItemsMatchTheSelectedItem(DTSQL.extraTypes, c.getCBSTypes()[index]);
            if (extra) {
                  c.getRBSExtra()[index].setEnabled(true);
                  c.getRBSExtra()[index].setBackground(Color.BLACK);
                  /*
                        cbsExtra[a].setEnabled(true);
                        tfsIDEN1[a].setEnabled(true);
                        tfsIDEN2[a].setEnabled(true);
                   */
            } else {
                  c.getRBSExtra()[index].setEnabled(false);
                  c.getRBSExtra()[index].setBackground(new Color(255, 0, 0, 100));
            }

            boolean dist = MComp.areThisItemsMatchTheSelectedItem(DTSQL.distTypes, c.getCBSTypes()[index]);
            if (dist) {
                  c.getCBS_Customs()[index].setEnabled(true);
            } else {
                  c.getCBS_Customs()[index].setEnabled(false);
            }

            boolean imageC = MComp.areThisItemsMatchTheSelectedItem(DTSQL.imageCTypes, c.getCBSTypes()[index]);
            if (imageC) {
                  c.getBTNS_ImageC()[index].setEnabled(true);
            } else {
                  c.getBTNS_ImageC()[index].setEnabled(false);
            }

            boolean tag = MComp.areThisItemsMatchTheSelectedItem(DTSQL.tagTypes, c.getCBSTypes()[index]);
            if (tag) {
                  c.getBTNS_Tag()[index].setEnabled(true);
            } else {
                  c.getBTNS_Tag()[index].setEnabled(false);
            }

            boolean clock = MComp.areThisItemsMatchTheSelectedItem(DTSQL.clockTypes, c.getCBSTypes()[index]);
            if (clock) {
                  c.getBTNS_Clock()[index].setEnabled(true);
            } else {
                  c.getBTNS_Clock()[index].setEnabled(false);
            }
      }

      private void sizeChange(boolean bool) {
            if (bool) {
                  if (c.getUpdateStore() != null) {
                        c.getPanelsTypes()[index].setMinimumSize(new Dimension(270, 27));
                        c.getPanelsTypes()[index].setMaximumSize(new Dimension(270, 27));
                        c.getPanelsTypes()[index].setPreferredSize(new Dimension(270, 27));
                  } else {
                        c.getPanelsTypes()[index].setMinimumSize(new Dimension(240, 27));
                        c.getPanelsTypes()[index].setMaximumSize(new Dimension(240, 27));
                        c.getPanelsTypes()[index].setPreferredSize(new Dimension(240, 27));
                  }
            } else {
                  if (c.getUpdateStore() != null) {
                        c.getPanelsTypes()[index].setMinimumSize(new Dimension(230, 27));
                        c.getPanelsTypes()[index].setMaximumSize(new Dimension(230, 27));
                        c.getPanelsTypes()[index].setPreferredSize(new Dimension(230, 27));
                  }else{
                        c.getPanelsTypes()[index].setMinimumSize(new Dimension(200, 27));
                        c.getPanelsTypes()[index].setMaximumSize(new Dimension(200, 27));
                        c.getPanelsTypes()[index].setPreferredSize(new Dimension(200, 27));
                  }
            }
      }

}
