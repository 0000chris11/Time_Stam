/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Options;

import TestWindow.VT;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author Christopher
 */
public class VP {

      JFrame JF = new JFrame();
      JSplitPane SPL = new JSplitPane(1);
      JPanel JP = new JPanel();
      private static JTree JTE;
      public static JTree getJTE() {
            return JTE;
      }
      JScrollPane SC_JTE;
      
      JLabel lb_T = new JLabel();
      JLabel[] lb_Icon = new JLabel[UIManager.getInstalledLookAndFeels().length];
      JSeparator sp_T = new JSeparator(SwingConstants.HORIZONTAL);

      private void setComponentFitOnJFrame(JComponent jc, JFrame jf) {
            jc.setBounds(2, 2,
                    jf.getWidth() - 21,
                    jf.getHeight() - 44);

            System.out.println("JP Bounds: " + jc.getBounds());
      }
      //++++++++++++++++++++++++++++++++++++++++++++++
      private DefaultMutableTreeNode getDefaultMutableTreeNode() {
            DefaultMutableTreeNode root = new DefaultMutableTreeNode("Options");
            //++++++++++++++++++++++++++++++++++++
            root.add(new DefaultMutableTreeNode("View"));
            
            DefaultMutableTreeNode view = (DefaultMutableTreeNode) root.getChildAt(0);
            addLookAndFeelNode(view);

            view.add(new DefaultMutableTreeNode("Color"));
            DefaultMutableTreeNode color = (DefaultMutableTreeNode) view.getChildAt(1);
            color.add(new DefaultMutableTreeNode("Dist Panel"));
            color.add(new DefaultMutableTreeNode("Table"));
            
            setItemListener(view);
            //++++++++++++++++++++++++++++++++++++
            
            return root;
      }
      
      private void addLookAndFeelNode(DefaultMutableTreeNode node){
            node.add(new DefaultMutableTreeNode("Look and Feel"));
            boolean b;
            for (int a = 0; a < UIManager.getInstalledLookAndFeels().length; a++) {
                  String name = UIManager.getInstalledLookAndFeels()[a].getName();
                  b = false;
                  if (name.equals(UIManager.getLookAndFeel().getName())) {
                        b = true;
                  }
                  ((DefaultMutableTreeNode) node.getChildAt(0)).add(
                          new DefaultMutableTreeNode(new JCheckBox(name, b)));
            }
      }
      //++++++++++++++++++++++++++++++++++++++++++++++
      private void setItemListener(DefaultMutableTreeNode node) {
            for (int a = 0; a < node.getChildAt(0).getChildCount(); a++) {
                  Object object
                          = ((DefaultMutableTreeNode) node.getChildAt(0).getChildAt(a)).getUserObject();
                  ((JCheckBox) object).addItemListener(new VP_ItemListener());
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++
      private void frameConfig() {
            JF.setDefaultCloseOperation(3);
            JF.setLayout(null);
            JF.setSize(800, 400);
            JF.setLocationRelativeTo(null);
            JF.setAlwaysOnTop(true);

            JF.add(SPL);
            //SPL.setLayout(null);
            setComponentFitOnJFrame(SPL, JF);
            SPL.setOneTouchExpandable(true);          
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
            SPL.setLeftComponent(SC_JTE);

            JTE.setRootVisible(false);
            JTE.setShowsRootHandles(true);
            JTE.setEditable(true);
            JTE.putClientProperty("JTree.lineStyle", "Horizontal");
            JTE.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
            JTE.setCellRenderer(new VP_CellRenderer());
            JTE.setCellEditor(new VP_CellEditor());

            JTE.setBounds(0, 0, 180, JP.getHeight() + 100);
            SC_JTE.setBounds(4, 4, 150, JP.getHeight() - 8);
            SC_JTE.setMinimumSize(new Dimension(200, SC_JTE.getHeight()));
            JTE.setBackground(Color.LIGHT_GRAY.brighter());
      }
      
      private void panelConfig(){
            SPL.setRightComponent(JP);
            JP.setBackground(Color.BLACK);
            JP.setLayout(null);
            
            
            JP.add(lb_T);
            lb_T.setBounds(8, 8, JP.getWidth() - 16, 30);
            lb_T.setForeground(Color.WHITE);
            JP.add(sp_T);
            sp_T.setBounds(4, lb_T.getY() + lb_T.getHeight() + 4, 
                    100, 2);
            sp_T.setForeground(Color.WHITE);
            System.out.println("lb_T bounds: " + lb_T.getBounds());
            System.out.println("sp_T bounds: " + sp_T.getBounds());
      }

      public VP() {
            frameConfig();
            testConfig();
            JTEConfig();
            panelConfig();
            //+++++++++++++++++++++++
            SPL.setDividerLocation(0.3);
            JF.setVisible(true);
      }

      public static void main(String[] args) {
            new VP();
      }
}
