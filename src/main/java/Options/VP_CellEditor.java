/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Options;

import MC.MM;
import Others.CC;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.event.CellEditorListener;
import javax.swing.text.JTextComponent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellEditor;

/**
 *
 * @author Christopher
 */
public class VP_CellEditor extends AbstractCellEditor implements TreeCellEditor{
      
      VP_CellRenderer renderer = new VP_CellRenderer();
      static DefaultMutableTreeNode defaultNode;
      static Component returnValue;

      @Override
      public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
            returnValue = renderer.getTreeCellRendererComponent(tree, value,
                    true, expanded, leaf, row, true);
            
            //VP.getJTE().repaint(0, 0, 1, 1);
            //fireEditingStopped();
            
            return returnValue;
      }

      @Override
      public Object getCellEditorValue() {
            String text;
            if(returnValue instanceof JCheckBox){
                  text = ((JCheckBox) returnValue).getText();
            }else{
                  text = returnValue.getClass().toString();
            }
            System.out.println(CC.YELLOW + "getCellEditorValue: " + text + CC.RESET);
            return returnValue;
      }

      @Override
      public boolean isCellEditable(EventObject anEvent) {
            return MM.isCellEditableForCheckBoxAndDefaults(
                    anEvent, VP.getJTE(), defaultNode);
      }
      
}
