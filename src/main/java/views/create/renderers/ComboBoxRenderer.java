/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.renderers;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Christopher
 */
public class ComboBoxRenderer extends JLabel implements ListCellRenderer {

      public ComboBoxRenderer() {
            setOpaque(true);
            setBorder(BorderFactory.createEmptyBorder());
      }

      @Override
      public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

            setText(value.toString());
            Color background;
            Color foreground;
            
            if (isEnabled()) {
                  if (isSelected) {
                        background = Color.BLUE.darker();
                        foreground = Color.WHITE;
                  } else {
                        background = Color.GRAY;
                        foreground = Color.WHITE.darker();
                  }
            } else {
                  background = Color.RED.darker();
                  foreground = Color.RED.brighter();
            }
            
            setBackground(background);
            setForeground(foreground);
            
            return this;
      }

}
