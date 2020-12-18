/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.mainTable.listeners;

import com.cofii2.myMethods.MComp;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author C0FII
 */
public class BTN_AL implements ActionListener {

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
                  cd.show(panel, "TYPES");
                  cb.setVisible(true);
            }
      }

}
