package Options;

import Others.CC;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Locale;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTree;
import javax.swing.UIManager;
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
            
            Font F = UIManager.getFont("Tree.font");
            CB.setFont(new Font(F.getName(), Font.PLAIN, F.getSize()));
            
            defaultRenderer.setOpaque(true);
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
            
            normalAndSelected(selected, returnValue);

            return returnValue;
      }

      private void normalAndSelected(boolean sel, Component c) {
            JComponent jc = (JComponent) c;
            jc.setOpaque(true);
            jc.setForeground(Color.BLACK);
            if (sel) {
                  //CB.setBackground(Color.DARK_GRAY);
                  //CB.setForeground(Color.WHITE);
                  jc.setBackground(Color.CYAN.darker());
                  
            } else {
                  //CB.setBackground(new Color(0, 0, 0, 0));
                  //CB.setForeground(Color.BLACK);
                  jc.setBackground(Color.WHITE);
            }
      }
}
