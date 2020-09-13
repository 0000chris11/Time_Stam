package Options;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

/**
 *
 * @author Christopher
 */
public class VP_CellRenderer implements TreeCellRenderer {

      DefaultTreeCellRenderer defaultRenderer = new DefaultTreeCellRenderer();
      JCheckBox CB = new JCheckBox();
      
      public VP_CellRenderer(){
            Font F = defaultRenderer.getFont();
            CB.setFont(new Font(F.getName(), Font.PLAIN, F.getSize()));
      }

      @Override
      public Component getTreeCellRendererComponent(JTree tree, Object value,
              boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            //System.out.println("getTreeCellRendererComponent");
            Component returnValue;
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
            Object userObject = node.getUserObject();

            //System.out.println("\tValue: " + value);
            if (node.isLeaf()) {
                  if (userObject instanceof JCheckBox) {
                        CB = (JCheckBox) userObject;
                        //System.out.println("\t\t// CB.getText(): "
                          //      + CB.getText());
                        returnValue = CB;
                  } else {
                        returnValue = defaultRenderer.getTreeCellRendererComponent(
                                tree, value, leaf, expanded, leaf, row, hasFocus);
                  }
            }else{
                  returnValue = defaultRenderer.getTreeCellRendererComponent(
                                tree, value, leaf, expanded, leaf, row, hasFocus);
            }

            normalAndSelected(selected);

            return returnValue;
      }

      private void normalAndSelected(boolean sel) {
            if (sel) {
                  CB.setBackground(Color.DARK_GRAY);
                  CB.setForeground(Color.WHITE);
                  defaultRenderer.setBackground(Color.DARK_GRAY);
                  defaultRenderer.setForeground(Color.WHITE);
            } else {
                  CB.setBackground(new Color(0, 0, 0, 0));
                  CB.setForeground(Color.BLACK);
                  defaultRenderer.setBackground(new Color(0, 0, 0, 0));
                  defaultRenderer.setForeground(Color.BLACK);
            }
      }
}
