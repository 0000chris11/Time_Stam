/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Options;

import TestWindow.VT;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author Christopher
 */
public class VP {

      JFrame JF = new JFrame();
      JPanel JP = new JPanel();
      private static JTree JTE;

      public static JTree getJTE() {
            return JTE;
      }
      JScrollPane SC_JTE;

      private void setComponentFitOnJFrame(JComponent jc, JFrame jf) {
            jc.setBounds(2, 2,
                    jf.getWidth() - 21,
                    jf.getHeight() - 44);

            System.out.println("JP Bounds: " + jc.getBounds());
      }

      private DefaultMutableTreeNode getDefaultMutableTreeNode() {
            DefaultMutableTreeNode root = new DefaultMutableTreeNode("Options");
            //++++++++++++++++++++++++++++++++++++
            root.add(new DefaultMutableTreeNode("Look and Feel"));
            boolean b;
            for (int a = 0; a < UIManager.getInstalledLookAndFeels().length; a++) {
                  String name = UIManager.getInstalledLookAndFeels()[a].getName();
                  b = false;
                  if (name.equals(UIManager.getLookAndFeel().getName())) {
                        b = true;
                  }
                  ((DefaultMutableTreeNode) root.getChildAt(0)).add(
                          new DefaultMutableTreeNode(new JCheckBox(name, b)));
            }
            root.add(new DefaultMutableTreeNode("View Options"));
            ((DefaultMutableTreeNode) root.getChildAt(1)).add(
                          new DefaultMutableTreeNode("Dist Panel"));
            ((DefaultMutableTreeNode) root.getChildAt(1)).add(
                          new DefaultMutableTreeNode("Table"));
            
            setItemListener(root);
            //++++++++++++++++++++++++++++++++++++
            
            return root;
      }

      private void setItemListener(DefaultMutableTreeNode root) {
            for (int a = 0; a < root.getChildAt(0).getChildCount(); a++) {
                  Object object
                          = ((DefaultMutableTreeNode) root.getChildAt(0).getChildAt(a)).getUserObject();
                  ((JCheckBox) object).addItemListener(new VP_ItemListener());
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++
      private void frameConfig() {
            JF.setDefaultCloseOperation(3);
            JF.setLayout(null);
            JF.setSize(1070, 727);
            JF.setLocationRelativeTo(null);
            JF.setAlwaysOnTop(true);

            JF.add(JP);
            JP.setBackground(Color.BLACK);
            JP.setLayout(null);
            setComponentFitOnJFrame(JP, JF);
      }

      private void testConfig() {
            VT vt = new VT();
            vt.add(new JButton("repaint JTree"));
            vt.add(new JButton("is JTree still editing?"));
            for (int a = 0; a < vt.getBTNS().size(); a++) {
                  vt.getBTNS().get(a).addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                              String ac = e.getActionCommand();
                              if(ac.equals(vt.getBTNS().get(0).getText())){
                                    System.out.println(vt.getBTNS().get(0).getText());
                                    JTE.repaint();
                              }else if(ac.equals(vt.getBTNS().get(1).getText())){
                                    System.out.println(vt.getBTNS().get(1).getText());
                                    System.out.println(JTE.isEditing());
                              }
                        }
                  });
            }
            vt.setVisible(true);
      }

      private void JTEConfig() {
            JTE = new JTree(getDefaultMutableTreeNode());
            SC_JTE = new JScrollPane(JTE);
            JP.add(SC_JTE);

            JTE.setRootVisible(false);
            JTE.setShowsRootHandles(true);
            JTE.setEditable(true);
            JTE.putClientProperty("JTree.lineStyle", "Horizontal");
            JTE.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
            JTE.setCellRenderer(new VP_CellRenderer());
            JTE.setCellEditor(new VP_CellEditor());

            JTE.setBounds(0, 0, 180, JP.getHeight() + 100);
            SC_JTE.setBounds(4, 4, 150, JP.getHeight() - 8);
            JTE.setBackground(Color.LIGHT_GRAY.brighter());
      }

      public VP() {
            frameConfig();
            testConfig();
            JTEConfig();

            //+++++++++++++++++++++++
            JF.setVisible(true);
      }

      public static void main(String[] args) {
            new VP();
      }
}
