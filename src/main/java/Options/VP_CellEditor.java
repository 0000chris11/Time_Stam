/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Options;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.JTree;
import javax.swing.event.CellEditorListener;
import javax.swing.tree.TreeCellEditor;

/**
 *
 * @author Christopher
 */
public class VP_CellEditor extends AbstractCellEditor implements TreeCellEditor{
      
      VP_CellRenderer renderer = new VP_CellRenderer();
      Component returnValue;

      @Override
      public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
            returnValue = renderer.getTreeCellRendererComponent(tree, value,
                    true, expanded, leaf, row, true);
            
            VP.getJTE().repaint();
            this.fireEditingStopped();
            
            return returnValue;
      }

      @Override
      public Object getCellEditorValue() {
            
            return returnValue;
      }

      @Override
      public boolean isCellEditable(EventObject anEvent) {
            boolean returnValue;
            if(anEvent instanceof MouseEvent){
                  returnValue = true;
            }else{
                  returnValue = false;
            }
            return returnValue;
      }
      
}
