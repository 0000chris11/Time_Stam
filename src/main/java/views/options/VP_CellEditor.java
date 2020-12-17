/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.options;

import com.cofii2.myClasses.CC;
import com.cofii2.myMethods.MCell;
import java.awt.Component;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellEditor;

/**
 *
 * @author C0FII
 */
public class VP_CellEditor extends AbstractCellEditor implements TreeCellEditor{
      
      VP_CellRenderer renderer = new VP_CellRenderer();
      static DefaultMutableTreeNode defaultNode;
      static Component returnValue;

      @Override
      public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
            returnValue = renderer.getTreeCellRendererComponent(tree, value,
                    true, expanded, leaf, row, true);
            
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
            return MCell.isCellEditableForCheckBoxAndDefaults(anEvent, VP.JTEN);
      }
      
}
