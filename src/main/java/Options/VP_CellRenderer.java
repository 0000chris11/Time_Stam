
package Options;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

/**
 *
 * @author Christopher
 */
public class VP_CellRenderer implements TreeCellRenderer{

      DefaultTreeCellRenderer defaultRenderer = new DefaultTreeCellRenderer();
      JCheckBox CB = new JCheckBox();
              
      @Override
      public Component getTreeCellRendererComponent(JTree tree, Object value, 
              boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            Component returnValue;
            Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
            
            if(userObject instanceof JCheckBox){
                  CB = (JCheckBox) userObject;
                  returnValue = CB;
            }else{
                  returnValue = defaultRenderer.getTreeCellRendererComponent(
                          tree, value, leaf, expanded, leaf, row, hasFocus);
            }
            
            normalAndSelected(selected);
            
            return returnValue;
      }
      
      private void normalAndSelected(boolean sel){
            if(sel){
                  CB.setBackground(Color.BLACK);
                  CB.setForeground(Color.WHITE);
            }else{
                  CB.setBackground(new Color(0,0,0,0));
                  CB.setForeground(Color.BLACK);
            }
      }
}
