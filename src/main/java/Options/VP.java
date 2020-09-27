/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Options;

import MC.MM;
import static Options.DT.JTEN;
import TestWindow.VT;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author Christopher
 */
public class VP extends DT {

      private DefaultMutableTreeNode getDefaultMutableTreeNode() {
            DefaultMutableTreeNode root = new DefaultMutableTreeNode("Options");
            //++++++++++++++++++++++++++++++++++++
            root.add(new DefaultMutableTreeNode("Star"));
            DefaultMutableTreeNode star = (DefaultMutableTreeNode) root.getChildAt(0);
            star.add(new DefaultMutableTreeNode("Dist Panel"));
            star.add(new DefaultMutableTreeNode("Table"));

            root.add(new DefaultMutableTreeNode("View"));
            DefaultMutableTreeNode view = (DefaultMutableTreeNode) root.getChildAt(1);
            addLookAndFeelNode(view);

            view.add(new DefaultMutableTreeNode("Color"));
            DefaultMutableTreeNode color = (DefaultMutableTreeNode) view.getChildAt(1);
            color.add(new DefaultMutableTreeNode("Dist Panel"));
            color.add(new DefaultMutableTreeNode("Table"));

            setItemListener(view);
            //++++++++++++++++++++++++++++++++++++

            return root;
      }

      private void addLookAndFeelNode(DefaultMutableTreeNode node) {
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
                  ((JCheckBox) object).addItemListener(new CB_ItemListener());
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++
      private void frameConfig() {
            JFN.setDefaultCloseOperation(3);
            JFN.setLayout(new GridLayout());
            JFN.setSize(800, 400);
            JFN.setLocationRelativeTo(null);
            JFN.setAlwaysOnTop(true);

            JFN.add(SPLN);
            //SPLN.setLayout(null);
            MM.setComponentFitOnJFrame(SPLN, JFN);
            SPLN.setOneTouchExpandable(true);
      }

      private void testConfig() {
            VT vt = new VT();
            vt.addButton(new JButton("repaint JTree"));
            vt.addButton(new JButton("is JTree still editing?"));
            vt.addButton(new JButton("get Right Panel Components"));

            ActionListener al = new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        String ac = e.getActionCommand();
                        if (ac.equals(vt.getBTNS().get(0).getText())) {
                              System.out.println(vt.getBTNS().get(0).getText());
                              JTEN.repaint();
                        } else if (ac.equals(vt.getBTNS().get(1).getText())) {
                              System.out.println(vt.getBTNS().get(1).getText());
                              System.out.println(JTEN.isEditing());
                        } else if (ac.equals(vt.getBTNS().get(2).getText())) {
                              System.out.println(vt.getBTNS().get(2).getText());
                              for (int a = 0; a < JPN.getComponentCount(); a++) {
                                    System.out.println("\t" + (a + 1)
                                            + JPN.getComponent(a).getClass());
                              }
                        }
                  }

            };
            for(int a = 0; a < vt.getBTNS().size(); a++){
                  vt.getBTNS().get(a).addActionListener(al);
            }
            vt.setVisible(true);
      }

      private void JTEConfig() {
            JTEN = new JTree(getDefaultMutableTreeNode());
            SC_JTEN = new JScrollPane(JTEN);
            SPLN.setLeftComponent(SC_JTEN);

            JTEN.setRootVisible(false);
            JTEN.setShowsRootHandles(true);
            JTEN.setEditable(true);
            JTEN.putClientProperty("JTree.lineStyle", "Horizontal");
            JTEN.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
            JTEN.addTreeSelectionListener(new JTE_SelectionListener());
            JTEN.setCellRenderer(new VP_CellRenderer());
            JTEN.setCellEditor(new VP_CellEditor());

            JTEN.setBounds(0, 0, 180, JPN.getHeight() + 100);
            SC_JTEN.setBounds(4, 4, 150, JPN.getHeight() - 8);
            SC_JTEN.setMinimumSize(new Dimension(200, SC_JTEN.getHeight()));
            JTEN.setBackground(Color.LIGHT_GRAY.brighter());
      }

      private void panelConfig() {
            SPLN.setRightComponent(JPN);
            //JPN.setOpaque(false);
            JPN.setBackground(Color.BLACK);
            
            JPN.setLayout(new BoxLayout(JPN, BoxLayout.Y_AXIS));

            //jps[a].setBackground(Color.DARK_GRAY);
            //jps[a].setName("Title Panel");
            //jps[a].setLayout(new BoxLayout(jps[a], BoxLayout.Y_AXIS));
            JPN.add(lb_Title);
            lb_Title.setBorder(new EmptyBorder(2, 4, 0, 0));
            Font F = UIManager.getFont("Label.font");
            lb_Title.setFont(new Font(F.getName(), F.getStyle(), F.getSize() + 6));
            lb_Title.setForeground(Color.WHITE);
            JPN.add(sp_Title);
            sp_Title.setMaximumSize(new Dimension(sp_Title.getMaximumSize().width,
            10));
            //sp_Title.setBorder(new EmptyBorder(10, 2, 0, 4));//DOESN'T WORK

                  
            //JPN.add(Box.createVerticalStrut(2));

            //jps[0].add(lb_Title);
            //jps[0].add(sp_Title);
            //panelSetUp();
            //JPN.add(lb_Title);
            //+++++++++++++++++++++++++++
            /*
            lb_Title.setBounds(8, 8, JPN.getWidth() - 16, 30);
            lb_Title.setForeground(Color.WHITE);
            //JPN.add(sp_Title);
            sp_Title.setBounds(4, lb_Title.getY() + lb_Title.getHeight() + 4,
                    100, 2);
            sp_Title.setForeground(Color.WHITE);
            System.out.println("lb_Title bounds: " + lb_Title.getBounds());
            System.out.println("sp_Title bounds: " + sp_Title.getBounds());
             */
            //+++++++++++++++++++++++++++
      }

      private void panelSetUp() {
            for (int a = 0; a < jps.length; a++) {
                  jps[a] = new JPanel();
                  if (a > 1) {
                        JPN.add("JP" + (a + 2), jps[a]);
                  }

            }
            JPN.add("JP Null", jps[0]);
            JPN.add("JP Start-Dist Panel", jps[1]);

            GroupLayout glay = new GroupLayout(jps[0]);
            jps[0].setLayout(glay);
            glay.setAutoCreateContainerGaps(true);
            glay.setAutoCreateGaps(true);

            SequentialGroup sh = glay.createSequentialGroup();
            SequentialGroup sv = glay.createSequentialGroup();

            ParallelGroup ph1 = glay.createParallelGroup(GroupLayout.Alignment.LEADING);

            glay.setHorizontalGroup(sh);
            glay.setVerticalGroup(sv);
            sh.addGroup(ph1);
            ph1.addComponent(lb_Title);
            ph1.addComponent(sp_Title);

            sv.addComponent(lb_Title);
            sv.addComponent(sp_Title);
            //ph1.addComponent(SPLN);
      }

      public static void radioButtonSetUp(int count, String[] txs) {
            rbtns = new JRadioButton[count];
            ButtonGroup bg = new ButtonGroup();
            for (int a = 0; a < count; a++) {
                  rbtns[a] = new JRadioButton(txs[a], false);
                  rbtns[a].setForeground(Color.WHITE);
                  rbtns[a].setOpaque(false);
                  rbtns[a].setBackground(new Color(0,0,0,0));
                  //rbtns[a].setSize();
                  bg.add(rbtns[a]);
                  JPN.add(rbtns[a]);
                  System.out.println((a + 1) + ": " + rbtns[a].getPreferredSize());
            }
            
      }

      public VP() {
            frameConfig();
            testConfig();
            JTEConfig();
            panelConfig();
            //+++++++++++++++++++++++
            SPLN.setDividerLocation(0.3);
            JFN.setVisible(true);
      }

      public static void main(String[] args) {
            new VP();
      }
}
