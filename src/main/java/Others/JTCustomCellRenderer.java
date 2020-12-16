/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Others;

import MC.LKCustom;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Christopher
 */
public class JTCustomCellRenderer extends DefaultTableCellRenderer {

     private Color Colr = Color.WHITE;
      
      public void setForegroundCell(Color color){
            Colr = color;
      }

      @Override
      public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);

            //count++;

            setBorder(new EmptyBorder(1, 4, 1, 4));
            c.setFont(new Font("Dialog", Font.PLAIN, 20));
            c.setForeground(Colr);

            if (isSelected) {
            } else {
                  if (column == 0) {
                        c.setBackground(LKCustom.BK_NORMAL);
                  } else if (column == 1) {
                        c.setBackground(Color.BLACK);
                  }
            }
            
            return this;
      }
}
