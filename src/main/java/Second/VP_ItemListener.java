/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Second;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Christopher
 */
public class VP_ItemListener implements ItemListener {

      @Override
      public void itemStateChanged(ItemEvent e) {
            DefaultMutableTreeNode root
                    = (DefaultMutableTreeNode) VP.getJTE().getModel().getRoot();
            int count = root.getChildAt(0).getChildCount();
            for (int a = 0; a < count; a++) {
                  Object object
                          = ((DefaultMutableTreeNode) root.getChildAt(0).getChildAt(a)).getUserObject();
                  JCheckBox cb = (JCheckBox) object;
                  if (e.getSource() == cb) {
                        if (cb.isSelected()) {
                              for (int b = 0; b < count; b++) {
                                    if (b != a) {
                                          Object objectO
                                                  = ((DefaultMutableTreeNode) root.getChildAt(0).getChildAt(b)).getUserObject();
                                          JCheckBox cbO = (JCheckBox) objectO;
                                          cbO.setSelected(false);
                                    }
                              }
                        }
                  }
            }
      }

}
