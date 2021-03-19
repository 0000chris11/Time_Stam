/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import MC.MainInstances;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import views.createUpdate.VC_R_Comps;

/**
 *
 * @author C0FII
 */
public class rbDefault_AL implements ActionListener {

      private VC_R_Comps c = MainInstances.getVC_R_Comps();

      private int index;

      public rbDefault_AL(int index) {
            this.index = index;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
            JRadioButton rb = (JRadioButton) e.getSource();
            if (rb.isSelected()) {
                  c.getTFSDefaults()[index].setVisible(true);
            } else {
                  c.getTFSDefaults()[index].setVisible(false);
            }

            changeSize(rb);
      }
      
      private void changeSize(JRadioButton rb){
            if (rb.isSelected()) {
                  if (c.getUpdateStore() != null) {
                        c.getPanelsDefaults()[index].setMinimumSize(new Dimension(160, 27));
                        c.getPanelsDefaults()[index].setMaximumSize(new Dimension(160, 27));
                        c.getPanelsDefaults()[index].setPreferredSize(new Dimension(160, 27));
                  } else {
                        c.getPanelsDefaults()[index].setMinimumSize(new Dimension(130, 27));
                        c.getPanelsDefaults()[index].setMaximumSize(new Dimension(130, 27));
                        c.getPanelsDefaults()[index].setPreferredSize(new Dimension(130, 27));
                  }
            } else {
                  if (c.getUpdateStore() != null) {
                        c.getPanelsDefaults()[index].setMinimumSize(new Dimension(60, 27));
                        c.getPanelsDefaults()[index].setMaximumSize(new Dimension(60, 27));
                        c.getPanelsDefaults()[index].setPreferredSize(new Dimension(60, 27));
                  } else {
                        c.getPanelsDefaults()[index].setMinimumSize(new Dimension(30, 27));
                        c.getPanelsDefaults()[index].setMaximumSize(new Dimension(30, 27));
                        c.getPanelsDefaults()[index].setPreferredSize(new Dimension(30, 27));
                  }
            }
      }

}
