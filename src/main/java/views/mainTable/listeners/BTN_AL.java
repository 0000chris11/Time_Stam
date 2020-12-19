/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.mainTable.listeners;

import MC.MainInstances;
import com.cofii2.myMethods.MComp;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import views.mainTable.VMT_DataCom;

/**
 *
 * @author C0FII
 */
public class BTN_AL implements ActionListener {

      private VMT_DataCom dt = MainInstances.getVMT_DataCom();
      private JToggleButton[] array;
      private JPanel panel;
      private JComboBox cb;

      public BTN_AL(JToggleButton[] array, JPanel panel, JComboBox cb) {
            this.array = array;
            this.panel = panel;
            this.cb = cb;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
            MComp.setButtonGroup(e, array);
            CardLayout cd = (CardLayout) panel.getLayout();
            if (array[0].isSelected()) {
                  cd.show(panel, "DISTS");
            } else if (array[1].isSelected()) {
                  if (!dt.getJTDists().getSelectionModel().isSelectionEmpty()) {
                        cd.show(panel, "TYPES");
                  }else{
                        cd.show(panel, "LB_TYPES");
                  }
                  cb.setVisible(true);
            }
      }

}
