/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Second;

import First.VF;
import MC.DT;
import MC.Data;
import mMethods.MM;
import MC.MethodM;
import MC.Status;
import mMethods.MList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Christopher
 */
public class View_Update extends javax.swing.JFrame {

      Connection con;
      VF vf = new VF();
      
      String CName = this.getClass().getName();
      
      //MethodM mm = new MethodM(CName, DT.CCount++);
      Status st;
      Color[] cl = {Color.RED, Color.GREEN, Color.YELLOW};
      final String inter = "Nothing Changed";
      
      //Data dt = new Data("View_Update");

      ArrayList<String> list_D = new ArrayList<String>();
      ArrayList<String> list_T = new ArrayList<String>();
      ArrayList<String> list_C = new ArrayList<String>();
      ArrayList<String> list_TP = new ArrayList<String>();
      ArrayList<String> list_NL = new ArrayList<String>();
      //++++++++++++++++++++++++++++++++++++++++++++++++++++
      JPanel panel3;
      //++++++++++++++++++++++++++++++++++++++++++++++++++++
      ImageIcon icon_on;
      ImageIcon icon_off;
      JLabel lb_left = new JLabel();
      JLabel lb_right = new JLabel();
      JLabel lb_Status = new JLabel("Waiting for Action...");
      JButton btn_d2 = new JButton();
      JButton btn_d3 = new JButton();
      JButton btn_d4 = new JButton();
      JButton btn_d5 = new JButton();
      JButton btn_d6 = new JButton();
      JButton btn_p = new JButton();

      JButton btn_dist1 = new JButton();
      JButton btn_dist2 = new JButton();
      JButton btn_tag1 = new JButton();
      JButton btn_tabl = new JButton();
      //++++++++++++++++++++++++++++++++++++++++++++
      JTextField[] jtf;
      JComboBox[] jcb;
      JCheckBox[] jcbx;

      JComboBox[] jcb2;
      JButton[] jbdd = new JButton[]{btn_dist1, btn_dist2, btn_tag1, btn_tabl};

      public void tf_Control(JTextField tf, String index) {
            if (tf.getText().isEmpty()) {
                  System.out.println("EMPTY");
                  tf.setForeground(Color.RED);
            } else if (tf.getText().equals(index)) {
                  tf.setForeground(new Color(0, 204, 204));
                  System.out.println("EQUALS COLUMN");
            } else {
                  int z = 0;
                  for (int a = 0; a < DT.getBandW().size(); a++) {
                        if (tf.getText().equals(DT.getBandW().get(a))) {
                              tf.setForeground(Color.RED);
                              z = 1;
                        } else {
                              if (z == 1) {
                              } else {
                                    //System.out.println("CLEAR");
                                    tf.setForeground(Color.WHITE);
                              }
                        }
                  }

            }
      }

      //public void tf_Control(JTextField tf, ArrayList<String> list) {
      //}
      public void setDist1Visible() {
            if (cb_D1.getSelectedItem().equals("NONE")) {
                  cb_D1_1.setVisible(false);
                  cb_D1_2.setVisible(false);
                  cb_D1_3.setVisible(false);
                  cb_D1_4.setVisible(false);
            } else if (cb_D1.getSelectedItem().equals("X1")) {
                  cb_D1_1.setVisible(true);
                  cb_D1_2.setVisible(false);
                  cb_D1_3.setVisible(false);
                  cb_D1_4.setVisible(false);
            } else if (cb_D1.getSelectedItem().equals("X2")) {
                  cb_D1_1.setVisible(true);
                  cb_D1_2.setVisible(true);
                  cb_D1_3.setVisible(false);
                  cb_D1_4.setVisible(false);
            } else if (cb_D1.getSelectedItem().equals("X3")) {
                  cb_D1_1.setVisible(true);
                  cb_D1_2.setVisible(true);
                  cb_D1_3.setVisible(true);
                  cb_D1_4.setVisible(false);
            } else if (cb_D1.getSelectedItem().equals("X4")) {
                  cb_D1_1.setVisible(true);
                  cb_D1_2.setVisible(true);
                  cb_D1_3.setVisible(true);
                  cb_D1_4.setVisible(true);
            }
      }

      public void setDist2Visible() {
            if (cb_D2.getSelectedItem().equals("NONE")) {
                  cb_D2_1.setVisible(false);
                  cb_D2_2.setVisible(false);
            } else if (cb_D2.getSelectedItem().equals("X1")) {
                  cb_D2_1.setVisible(true);
                  cb_D2_2.setVisible(false);
            } else if (cb_D2.getSelectedItem().equals("X2")) {
                  cb_D2_1.setVisible(true);
                  cb_D2_2.setVisible(true);
            }
      }

      public void setTag1Visible() {
            if (cb_T1.getSelectedItem().equals("NONE")) {
                  cb_T1_1.setVisible(false);
                  cb_T1_2.setVisible(false);
                  cb_T1_3.setVisible(false);
                  cb_T1_4.setVisible(false);
            } else if (cb_T1.getSelectedItem().equals("X1")) {
                  cb_T1_1.setVisible(true);
                  cb_T1_2.setVisible(false);
                  cb_T1_3.setVisible(false);
                  cb_T1_4.setVisible(false);
            } else if (cb_T1.getSelectedItem().equals("X2")) {
                  cb_T1_1.setVisible(true);
                  cb_T1_2.setVisible(true);
                  cb_T1_3.setVisible(false);
                  cb_T1_4.setVisible(false);
            } else if (cb_T1.getSelectedItem().equals("X3")) {
                  cb_T1_1.setVisible(true);
                  cb_T1_2.setVisible(true);
                  cb_T1_3.setVisible(true);
                  cb_T1_4.setVisible(false);
            } else if (cb_T1.getSelectedItem().equals("X4")) {
                  cb_T1_1.setVisible(true);
                  cb_T1_2.setVisible(true);
                  cb_T1_3.setVisible(true);
                  cb_T1_4.setVisible(true);
            }
      }

      //ITEM CHANGED
      public void setlb_Dist1Name() {
            if (cb_D1.getSelectedItem().equals("NONE")) {
                  lb_NDist1.setText("Dist1: NONE");
            } else if (cb_D1.getSelectedItem().equals("X1")) {
                  lb_NDist1.setText("Dist1: " + cb_D1.getSelectedItem() + ": "
                          + cb_D1_1.getSelectedItem());
            } else if (cb_D1.getSelectedItem().equals("X2")) {
                  lb_NDist1.setText("Dist1: " + cb_D1.getSelectedItem() + ": "
                          + cb_D1_1.getSelectedItem() + "_"
                          + cb_D1_2.getSelectedItem());
            } else if (cb_D1.getSelectedItem().equals("X3")) {
                  lb_NDist1.setText("Dist1: " + cb_D1.getSelectedItem() + ": "
                          + cb_D1_1.getSelectedItem() + "_"
                          + cb_D1_2.getSelectedItem() + "_"
                          + cb_D1_3.getSelectedItem());
            } else if (cb_D1.getSelectedItem().equals("X4")) {
                  lb_NDist1.setText("Dist1: " + cb_D1.getSelectedItem() + ": "
                          + cb_D1_1.getSelectedItem() + "_"
                          + cb_D1_2.getSelectedItem() + "_"
                          + cb_D1_3.getSelectedItem() + "_"
                          + cb_D1_4.getSelectedItem());
            }
      }

      public void setlb_Dist2Name() {
            if (cb_D2.getSelectedItem().equals("NONE")) {
                  lb_NDist2.setText("Dist2: NONE");
            } else if (cb_D2.getSelectedItem().equals("X1")) {
                  lb_NDist2.setText("Dist2: " + cb_D2.getSelectedItem() + ": "
                          + cb_D2_1.getSelectedItem());
            } else if (cb_D2.getSelectedItem().equals("X2")) {
                  lb_NDist2.setText("Dist2: " + cb_D2.getSelectedItem() + ": "
                          + cb_D2_1.getSelectedItem() + "_"
                          + cb_D2_2.getSelectedItem());
            }
      }

      public void setlb_Tag1Name() {
            if (cb_T1.getSelectedItem().equals("NONE")) {
                  lb_NTag1.setText("Tag1: NONE");
            } else if (cb_T1.getSelectedItem().equals("X1")) {
                  lb_NTag1.setText("Tag1: " + cb_T1.getSelectedItem() + ": "
                          + cb_T1_1.getSelectedItem());
            } else if (cb_T1.getSelectedItem().equals("X2")) {
                  lb_NTag1.setText("Tag1: " + cb_T1.getSelectedItem() + ": "
                          + cb_T1_1.getSelectedItem() + "_"
                          + cb_T1_2.getSelectedItem());
            } else if (cb_T1.getSelectedItem().equals("X3")) {
                  lb_NTag1.setText("Tag1: " + cb_T1.getSelectedItem() + ": "
                          + cb_T1_1.getSelectedItem() + "_"
                          + cb_T1_2.getSelectedItem() + "_"
                          + cb_T1_3.getSelectedItem());
            } else if (cb_T1.getSelectedItem().equals("X4")) {
                  lb_NTag1.setText("Tag1: " + cb_T1.getSelectedItem() + ": "
                          + cb_T1_1.getSelectedItem() + "_"
                          + cb_T1_2.getSelectedItem() + "_"
                          + cb_T1_3.getSelectedItem() + "_"
                          + cb_T1_4.getSelectedItem());
            }
      }
      //+++++++++++++++++++++++++++++++++++++++++++++++++++++
      public void cb_Dist1Control() {
            if (cb_D1.getSelectedItem().equals("NONE")) {
                  lb_NDist1.setForeground(Color.WHITE);
                  btn_dist1.setEnabled(true);
            } else if (cb_D1.getSelectedItem().equals("X1")) {
                  lb_NDist1.setForeground(Color.WHITE);
                  btn_dist1.setEnabled(true);
            } else if (cb_D1.getSelectedItem().equals("X2")) {
                  if (cb_D1_1.getSelectedItem().equals(cb_D1_2.getSelectedItem())) {
                        lb_NDist1.setForeground(Color.RED);
                        btn_dist1.setEnabled(false);
                  } else {
                        lb_NDist1.setForeground(Color.WHITE);
                        btn_dist1.setEnabled(true);
                  }
            } else if (cb_D1.getSelectedItem().equals("X3")) {
                  if (cb_D1_1.getSelectedItem().equals(cb_D1_2.getSelectedItem())
                          || cb_D1_1.getSelectedItem().equals(cb_D1_3.getSelectedItem())) {
                        lb_NDist1.setForeground(Color.RED);
                        btn_dist1.setEnabled(false);
                  } else if (cb_D1_2.getSelectedItem().equals(cb_D1_3.getSelectedItem())) {
                        lb_NDist1.setForeground(Color.RED);
                        btn_dist1.setEnabled(false);
                  } else {
                        lb_NDist1.setForeground(Color.WHITE);
                        btn_dist1.setEnabled(true);
                  }
            } else if (cb_D1.getSelectedItem().equals("X4")) {
                  if (cb_D1_1.getSelectedItem().equals(cb_D1_2.getSelectedItem())
                          || cb_D1_1.getSelectedItem().equals(cb_D1_3.getSelectedItem())
                          || cb_D1_1.getSelectedItem().equals(cb_D1_4.getSelectedItem())) {
                        lb_NDist1.setForeground(Color.RED);
                        btn_dist1.setEnabled(false);
                  } else if (cb_D1_2.getSelectedItem().equals(cb_D1_3.getSelectedItem())
                          || cb_D1_2.getSelectedItem().equals(cb_D1_4.getSelectedItem())) {
                        lb_NDist1.setForeground(Color.RED);
                        btn_dist1.setEnabled(false);
                  } else if (cb_D1_3.getSelectedItem().equals(cb_D1_4.getSelectedItem())) {
                        lb_NDist1.setForeground(Color.RED);
                        btn_dist1.setEnabled(false);
                  } else {
                        lb_NDist1.setForeground(Color.WHITE);
                        btn_dist1.setEnabled(true);
                  }
            }
            //setRightON();
      }

      public void cb_Dist2Control() {
            if (cb_D2.getSelectedItem().equals("NONE")) {
                  lb_NDist2.setForeground(Color.WHITE);
                  btn_dist2.setEnabled(true);
            } else if (cb_D2.getSelectedItem().equals("X1")) {
                  lb_NDist2.setForeground(Color.WHITE);
                  btn_dist2.setEnabled(true);
            } else if (cb_D2.getSelectedItem().equals("X2")) {
                  if (cb_D2_1.getSelectedItem().equals(cb_D2_2.getSelectedItem())) {
                        lb_NDist2.setForeground(Color.RED);
                        btn_dist2.setEnabled(false);
                  } else {
                        lb_NDist2.setForeground(Color.WHITE);
                        btn_dist2.setEnabled(true);
                  }
            }
            //setRightON();
      }

      public void cb_Tag1Control() {
            if (cb_T1.getSelectedItem().equals("NONE")) {
                  lb_NTag1.setForeground(Color.WHITE);
                  btn_tag1.setEnabled(true);
            } else if (cb_T1.getSelectedItem().equals("X1")) {
                  lb_NTag1.setForeground(Color.WHITE);
                  btn_tag1.setEnabled(true);
            } else if (cb_T1.getSelectedItem().equals("X2")) {
                  if (cb_T1_1.getSelectedItem().equals(cb_T1_2.getSelectedItem())) {
                        lb_NTag1.setForeground(Color.RED);
                        btn_tag1.setEnabled(false);
                  } else {
                        lb_NTag1.setForeground(Color.WHITE);
                        btn_tag1.setEnabled(true);
                  }
            } else if (cb_T1.getSelectedItem().equals("X3")) {
                  if (cb_T1_1.getSelectedItem().equals(cb_T1_2.getSelectedItem())
                          || cb_T1_1.getSelectedItem().equals(cb_T1_3.getSelectedItem())) {
                        lb_NTag1.setForeground(Color.RED);
                        btn_tag1.setEnabled(false);
                  } else if (cb_T1_2.getSelectedItem().equals(cb_T1_3.getSelectedItem())) {
                        lb_NTag1.setForeground(Color.RED);
                        btn_tag1.setEnabled(false);
                  } else {
                        lb_NTag1.setForeground(Color.WHITE);
                        btn_tag1.setEnabled(true);
                  }
            } else if (cb_T1.getSelectedItem().equals("X4")) {
                  if (cb_T1_1.getSelectedItem().equals(cb_T1_2.getSelectedItem())
                          || cb_T1_1.getSelectedItem().equals(cb_T1_3.getSelectedItem())
                          || cb_T1_1.getSelectedItem().equals(cb_T1_4.getSelectedItem())) {
                        lb_NTag1.setForeground(Color.RED);
                        btn_tag1.setEnabled(false);
                  } else if (cb_T1_2.getSelectedItem().equals(cb_T1_3.getSelectedItem())
                          || cb_T1_2.getSelectedItem().equals(cb_T1_4.getSelectedItem())) {
                        lb_NTag1.setForeground(Color.RED);
                        btn_tag1.setEnabled(false);
                  } else if (cb_T1_3.getSelectedItem().equals(cb_T1_4.getSelectedItem())) {
                        lb_NTag1.setForeground(Color.RED);
                        btn_tag1.setEnabled(false);
                  } else {
                        lb_NTag1.setForeground(Color.WHITE);
                        btn_tag1.setEnabled(true);
                  }
            }
            //setRightON();
      }
      //++++++++++++++++++++++++++++++++++++++++++++++++++++
      private void frameConfig() {
            sc_panel1.setLocation(2, 2);
            sc_panel1.setSize(panel2.getWidth() + 114, panel2.getHeight() + 4);
            //panel1.setSize(panel2.getWidth(), panel2.getHeight() + 200);
            panel1.setPreferredSize(new Dimension(panel2.getWidth(), panel2.getHeight() + 200));
            int width = sc_panel1.getWidth() + 4;
            panel2.setLocation(width, 4);
            panel2.setSize(434, sc_panel1.getHeight() - 5);
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++
            panel3 = new JPanel();
            int y3 = sc_panel1.getHeight() + 2;
            int w3 = sc_panel1.getWidth() + 2 + panel2.getWidth();
            panel3.setLocation(4, y3);
            panel3.setSize(w3 - 2, 50);
            panel3.setBackground(Color.BLACK);
            panel3.setLayout(null);
            add(panel3);

            //btn_change = new JButton();
            btn_change.setLocation(panel3.getWidth() - 120, 9);
            //panel1.remove(btn_change);
            panel3.add(btn_change);

            lb_Status.setLocation(6, btn_change.getY() + 4);
            lb_Status.setSize(w3 - 14, 24);
            lb_Status.setFont(new Font("Dialog", Font.BOLD, 16));
            lb_Status.setForeground(Color.WHITE);
            lb_Status.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            panel3.add(lb_Status);

            int wx = sc_panel1.getWidth() + panel2.getWidth() + 28;
            setSize(wx - 1, 489);//489
            //++++++++++++++++++++++++++++++++++++++++++++++++++
            btn_change.setVisible(false);
      }

      /*
      public void createLB_LR() {
            BufferedImage bimage_off = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
            BufferedImage bimage_on = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
            Graphics2D g_off = bimage_off.createGraphics();
            Graphics2D g_on = bimage_on.createGraphics();

            g_off.setColor(Color.RED);
            g_off.fillOval(0, 0, 20, 20);
            //g_off.dispose();

            g_on.setColor(Color.GREEN);
            g_on.fillOval(0, 0, 20, 20);
            //g_on.dispose();

            icon_off = new ImageIcon(bimage_off);
            icon_off.setDescription("OFF");
            icon_on = new ImageIcon(bimage_on);
            icon_on.setDescription("ON");

            lb_left.setIcon(icon_on);
            lb_left.setLocation(btn_change.getX() - 54, panel3.getHeight() / 2 - 10);
            lb_left.setSize(20, 20);
            panel3.add(lb_left);

            lb_right.setIcon(icon_off);
            lb_right.setLocation(btn_change.getX() - 26, panel3.getHeight() / 2 - 10);
            lb_right.setSize(20, 20);
            panel3.add(lb_right);
      }
       */
      
      public void createBTN_AD() {
            ImageIcon ix = new ImageIcon("C:\\C0F\\Image\\X Icons\\Q small.png");
            ImageIcon ix2 = new ImageIcon("C:\\C0F\\Image\\X Icons\\Q small2.png");
            ImageIcon ip = new ImageIcon("C:\\C0F\\Image\\X Icons\\+ small.png");

            Icon ixc = (Icon) ix;
            Icon ixc2 = (Icon) ix2;
            Icon ipc = (Icon) ip;

            btn_d2.setIcon(ixc);
            btn_d3.setIcon(ixc);
            btn_d4.setIcon(ixc);
            btn_d5.setIcon(ixc);
            btn_d6.setIcon(ixc);
            btn_p.setIcon(ipc);
            //++++++++++++++++++++++++++++
            int h = tf_c2.getHeight();
            int x2 = cb_D1_4.getX() + cb_D1_4.getWidth() + 6;
            ChangeDeleteC dc = new ChangeDeleteC();

            for (int a = 0; a < jbdd.length; a++) {
                  jbdd[a].setIcon(ixc2);
                  jbdd[a].setLocation(x2, jcb2[a].getY());
                  jbdd[a].setSize(40, h);
                  jbdd[a].addActionListener(dc);

                  panel2.add(jbdd[a]);
            }
            //+++++++++++++++++++++++++++++++++++++++++++++++++++
            int x1 = cb_c2.getX() + cb_c2.getWidth() + 6;
            //int yres = tf_c3.getY() - tf_c2.getY();
            btn_d2.setLocation(x1, tf_c2.getY());
            btn_d3.setLocation(x1, tf_c3.getY());
            btn_d4.setLocation(x1, tf_c4.getY());
            btn_d5.setLocation(x1, tf_c5.getY());
            btn_d6.setLocation(x1, tf_c6.getY());
            btn_p.setLocation(x1, tf_nc.getY());

            btn_d2.setSize(40, h);
            btn_d3.setSize(40, h);
            btn_d4.setSize(40, h);
            btn_d5.setSize(40, h);
            btn_d6.setSize(40, h);
            btn_p.setSize(40, h);
            //++++++++++++++++++++++++++++++++++++++++++++++++++
            btn_d2.addActionListener(dc);
            btn_d3.addActionListener(dc);
            btn_d4.addActionListener(dc);
            btn_d5.addActionListener(dc);
            btn_d6.addActionListener(dc);

            btn_p.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent event) {
                        if (tf_nc.getText().isEmpty()) {
                        } else {
                              int value = getJOptionPane(list_D.get(0), tf_nc.getText());
                              if (value == 0) {

                                    String st;
                                    if (cbx_nc.isSelected()) {
                                          st = null;
                                    } else {
                                          st = "NOT NULL";
                                    }
                                    MCAddColumn(tf_nc.getText(),
                                            cb_nc.getSelectedItem().toString(), st);

                                    int size = list_C.size() - 1;

                                    if (size == 2) {
                                          System.out.println("\tAdding Column 3");
                                          lb_c3.setVisible(true);
                                          tf_c3.setText(tf_nc.getText());
                                          tf_c3.setVisible(true);
                                          cbx_c3.setSelected(cbx_nc.isSelected());
                                          cbx_c3.setVisible(true);
                                          cb_c3.setSelectedItem(cb_nc.getSelectedItem());
                                          cb_c3.setVisible(true);
                                          btn_d3.setVisible(true);

                                    } else if (size == 3) {
                                          System.out.println("\tAdding Column 4");
                                          lb_c4.setVisible(true);
                                          tf_c4.setText(tf_nc.getText());
                                          tf_c4.setVisible(true);
                                          cbx_c4.setSelected(cbx_nc.isSelected());
                                          cbx_c4.setVisible(true);
                                          cb_c4.setSelectedItem(cb_nc.getSelectedItem());
                                          cb_c4.setVisible(true);
                                          btn_d4.setVisible(true);

                                    } else if (size == 4) {
                                          System.out.println("\tAdding Column 5");
                                          lb_c5.setVisible(true);
                                          tf_c5.setText(tf_nc.getText());
                                          tf_c5.setVisible(true);
                                          cbx_c5.setSelected(cbx_nc.isSelected());
                                          cbx_c5.setVisible(true);
                                          cb_c5.setSelectedItem(cb_nc.getSelectedItem());
                                          cb_c5.setVisible(true);
                                          btn_d5.setVisible(true);

                                    } else if (size == 5) {
                                          System.out.println("\tAdding Column 6");
                                          lb_c6.setVisible(true);
                                          tf_c6.setText(tf_nc.getText());
                                          tf_c6.setVisible(true);
                                          cbx_c6.setSelected(cbx_nc.isSelected());
                                          cbx_c6.setVisible(true);
                                          cb_c6.setSelectedItem(cb_nc.getSelectedItem());
                                          cb_c6.setVisible(true);
                                          btn_d6.setVisible(true);
                                    }
                              }
                        }
                        btn_PControl();
                  }
            });

            panel1.add(btn_d2);
            panel1.add(btn_d3);
            panel1.add(btn_d4);
            panel1.add(btn_d5);
            panel1.add(btn_d6);
            panel1.add(btn_p);
      }

      public void setTF_LBValues() {
            MList.printFor(list_C);
            
            if (list_C.size() == 2) {
                  lb_c3.setVisible(false);
                  lb_c4.setVisible(false);
                  lb_c5.setVisible(false);
                  lb_c6.setVisible(false);
                  tf_c3.setVisible(false);
                  tf_c4.setVisible(false);
                  tf_c5.setVisible(false);
                  tf_c6.setVisible(false);
                  btn_d3.setVisible(false);
                  btn_d4.setVisible(false);
                  btn_d5.setVisible(false);
                  btn_d6.setVisible(false);

                  tf_c2.setText(list_C.get(1));
            } else if (list_C.size() == 3) {
                  lb_c4.setVisible(false);
                  lb_c5.setVisible(false);
                  lb_c6.setVisible(false);
                  tf_c4.setVisible(false);
                  tf_c5.setVisible(false);
                  tf_c6.setVisible(false);
                  btn_d4.setVisible(false);
                  btn_d5.setVisible(false);
                  btn_d6.setVisible(false);

                  tf_c2.setText(list_C.get(1));
                  tf_c3.setText(list_C.get(2));
            } else if (list_C.size() == 4) {
                  lb_c5.setVisible(false);
                  lb_c6.setVisible(false);
                  tf_c5.setVisible(false);
                  tf_c6.setVisible(false);
                  btn_d5.setVisible(false);
                  btn_d6.setVisible(false);

                  tf_c2.setText(list_C.get(1));
                  tf_c3.setText(list_C.get(2));
                  tf_c4.setText(list_C.get(3));
            } else if (list_C.size() == 5) {
                  lb_c6.setVisible(false);
                  tf_c6.setVisible(false);
                  btn_d6.setVisible(false);

                  tf_c2.setText(list_C.get(1));
                  tf_c3.setText(list_C.get(2));
                  tf_c4.setText(list_C.get(3));
                  tf_c5.setText(list_C.get(4));
            } else if (list_C.size() == 6) {
                  tf_c2.setText(list_C.get(1));
                  tf_c3.setText(list_C.get(2));
                  tf_c4.setText(list_C.get(3));
                  tf_c5.setText(list_C.get(4));
                  tf_c6.setText(list_C.get(5));
            }
      }

      public void setCBX_CB() {
            int c = 1;

            if (list_C.size() == 2) {
                  cbx_c3.setVisible(false);
                  cb_c3.setVisible(false);
                  cbx_c4.setVisible(false);
                  cb_c4.setVisible(false);
                  cbx_c5.setVisible(false);
                  cb_c5.setVisible(false);
                  cbx_c6.setVisible(false);
                  cb_c6.setVisible(false);

                  cb_c2.setSelectedItem(list_TP.get(1));

                  if (list_NL.get(1).equals("YES")) {
                        cbx_c2.setSelected(true);
                  } else {
                        cbx_c2.setSelected(false);
                  }
            } else if (list_C.size() == 3) {
                  cbx_c4.setVisible(false);
                  cb_c4.setVisible(false);
                  cbx_c5.setVisible(false);
                  cb_c5.setVisible(false);
                  cbx_c6.setVisible(false);
                  cb_c6.setVisible(false);

                  for (int a = 0; a < 2; a++) {
                        jcb[a].setSelectedItem(list_TP.get(c));
                        if (list_NL.get(c++).equals("YES")) {
                              jcbx[a].setSelected(true);
                        } else {
                              jcbx[a].setSelected(false);
                        }
                  }
            } else if (list_C.size() == 4) {
                  cbx_c5.setVisible(false);
                  cb_c5.setVisible(false);
                  cbx_c6.setVisible(false);
                  cb_c6.setVisible(false);

                  for (int a = 0; a < 3; a++) {
                        jcb[a].setSelectedItem(list_TP.get(c));
                        if (list_NL.get(c++).equals("YES")) {
                              jcbx[a].setSelected(true);
                        } else {
                              jcbx[a].setSelected(false);
                        }
                  }
            } else if (list_C.size() == 5) {
                  cbx_c6.setVisible(false);
                  cb_c6.setVisible(false);

                  for (int a = 0; a < 4; a++) {
                        jcb[a].setSelectedItem(list_TP.get(c));
                        if (list_NL.get(c++).equals("YES")) {
                              jcbx[a].setSelected(true);
                        } else {
                              jcbx[a].setSelected(false);
                        }
                  }
            } else if (list_C.size() == 6) {
                  for (int a = 0; a < 5; a++) {
                        jcb[a].setSelectedItem(list_TP.get(c));
                        if (list_NL.get(c++).equals("YES")) {
                              jcbx[a].setSelected(true);
                        } else {
                              jcbx[a].setSelected(false);
                        }
                  }
            }
      }

      public void setCBValues() {
            //DIST1
            String dist1 = list_D.get(1);
            char[] tc = new char[4];
            if (dist1.equals("NONE")) {
                  cb_D1.setSelectedItem("NONE");
                  cb_D1_1.setVisible(false);
                  cb_D1_2.setVisible(false);
                  cb_D1_3.setVisible(false);
                  cb_D1_4.setVisible(false);
            } else if (dist1.contains("X1")) {
                  cb_D1.setSelectedItem("X1");
                  cb_D1_2.setVisible(false);
                  cb_D1_3.setVisible(false);
                  cb_D1_4.setVisible(false);
                  
                  //System.out.println("Dist1: " + dist1);
                  //System.out.println(dist1.charAt(dist1.length() - 1));
                  
                  tc[0] = dist1.charAt(dist1.length() - 1);
                  cb_D1_1.setSelectedItem(tc[0]);
            } else if (dist1.contains("X2")) {
                  cb_D1.setSelectedItem("X2");
                  cb_D1_3.setVisible(false);
                  cb_D1_4.setVisible(false);

                  tc[0] = dist1.charAt(dist1.indexOf(":") + 2);
                  tc[1] = dist1.charAt(dist1.indexOf(":") + 4);
                  cb_D1_1.setSelectedItem(tc[0]);
                  cb_D1_2.setSelectedItem(tc[1]);
            } else if (dist1.contains("X3")) {
                  cb_D1.setSelectedItem("X3");
                  cb_D1_4.setVisible(false);

                  tc[0] = dist1.charAt(dist1.indexOf(":") + 2);
                  tc[1] = dist1.charAt(dist1.indexOf(":") + 4);
                  tc[2] = dist1.charAt(dist1.indexOf(":") + 6);
                  cb_D1_1.setSelectedItem(tc[0]);
                  cb_D1_2.setSelectedItem(tc[1]);
                  cb_D1_3.setSelectedItem(tc[2]);
            } else if (dist1.contains("X4")) {
                  cb_D1.setSelectedItem("X4");

                  tc[0] = dist1.charAt(dist1.indexOf(":") + 2);
                  tc[1] = dist1.charAt(dist1.indexOf(":") + 4);
                  tc[2] = dist1.charAt(dist1.indexOf(":") + 6);
                  tc[3] = dist1.charAt(dist1.indexOf(":") + 8);
                  System.out.println("Dist1 are: " + tc[0] + "_" + tc[1] + "_" + tc[2] + "_" + tc[3]);
                  cb_D1_1.setSelectedItem(tc[0]);
                  cb_D1_2.setSelectedItem(tc[1]);
                  cb_D1_3.setSelectedItem(tc[2]);
                  cb_D1_4.setSelectedItem(tc[3]);
            }
            //DIST2
            String dist2 = list_D.get(2);
            String[] ts = new String[2];
            if (dist2.equals("NONE")) {
                  cb_D2.setSelectedItem("NONE");
                  cb_D2_1.setVisible(false);
                  cb_D2_2.setVisible(false);
            }
            if (dist2.contains("X1")) {
                  cb_D2.setSelectedItem("X1");
                  cb_D2_2.setVisible(false);

                  ts[0] = dist2.substring(dist1.indexOf(":") + 2);
                  System.out.println("ts[0]: " + ts[0]);
                  cb_D2_1.setSelectedItem(ts[0]);
            } else if (dist2.contains("X2")) {
                  cb_D2.setSelectedItem("X2");
                  //"X2: 2-3_4-5"
                  ts[0] = dist2.substring(dist1.indexOf(":") + 2, 7);
                  ts[1] = dist2.substring(dist1.indexOf(":") + 6);
                  cb_D2_1.setSelectedItem(ts[0]);
                  cb_D2_2.setSelectedItem(ts[1]);
            }

            //TABL NOTHING TO FILTER
            //TAG1
            String tag1 = list_D.get(4);
            if (tag1.equals("NONE")) {
                  cb_T1.setSelectedItem("NONE");
                  cb_T1_1.setVisible(false);
                  cb_T1_2.setVisible(false);
                  cb_T1_3.setVisible(false);
                  cb_T1_4.setVisible(false);
            } else if (tag1.contains("X1")) {
                  cb_T1.setSelectedItem("X1");
                  cb_T1_2.setVisible(false);
                  cb_T1_3.setVisible(false);
                  cb_T1_4.setVisible(false);

                  tc[0] = tag1.charAt(tag1.indexOf(":") + 2);
                  cb_T1_1.setSelectedItem(tc[0]);
            } else if (tag1.contains("X2")) {
                  cb_T1_3.setVisible(false);
                  cb_T1_4.setVisible(false);

                  tc[0] = tag1.charAt(tag1.indexOf(":") + 2);
                  tc[1] = tag1.charAt(tag1.indexOf(":") + 4);
                  cb_T1_1.setSelectedItem(tc[0]);
                  cb_T1_2.setSelectedItem(tc[1]);
            } else if (tag1.contains("X3")) {
                  cb_T1_4.setVisible(false);

                  tc[0] = tag1.charAt(tag1.indexOf(":") + 2);
                  tc[1] = tag1.charAt(tag1.indexOf(":") + 4);
                  tc[2] = tag1.charAt(tag1.indexOf(":") + 6);
                  cb_T1_1.setSelectedItem(tc[0]);
                  cb_T1_2.setSelectedItem(tc[1]);
                  cb_T1_3.setSelectedItem(tc[2]);
            } else if (tag1.contains("X4")) {
                  tc[0] = tag1.charAt(tag1.indexOf(":") + 2);
                  tc[1] = tag1.charAt(tag1.indexOf(":") + 4);
                  tc[2] = tag1.charAt(tag1.indexOf(":") + 6);
                  tc[3] = tag1.charAt(tag1.indexOf(":") + 8);
                  cb_T1_1.setSelectedItem(tc[0]);
                  cb_T1_2.setSelectedItem(tc[1]);
                  cb_T1_3.setSelectedItem(tc[2]);
                  cb_T1_4.setSelectedItem(tc[3]);
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++++
      private void setLeftON() {
            if (list_C.size() == 2) {
                  if (tf_name.getForeground().equals(Color.WHITE)
                          || tf_name.getForeground().equals(new Color(0, 204, 204))
                          && tf_c2.getForeground().equals(Color.WHITE)
                          || tf_c2.getForeground().equals(new Color(0, 204, 204))) {
                        System.out.println("ON");
                        lb_left.setIcon(icon_on);
                  } else {
                        System.out.println("OFF");
                        lb_left.setIcon(icon_off);
                  }
            } else if (list_C.size() == 3) {
                  if (tf_name.getForeground().equals(Color.WHITE)
                          || tf_name.getForeground().equals(new Color(0, 204, 204))
                          && tf_c2.getForeground().equals(Color.WHITE)
                          || tf_c2.getForeground().equals(new Color(0, 204, 204))
                          && tf_c3.getForeground().equals(Color.WHITE)
                          || tf_c3.getForeground().equals(new Color(0, 204, 204))) {
                        System.out.println("ON");
                        lb_left.setIcon(icon_on);
                  } else {
                        System.out.println("OFF");
                        lb_left.setIcon(icon_off);
                  }
            } else if (list_C.size() == 4) {
                  if (tf_name.getForeground().equals(Color.WHITE)
                          || tf_name.getForeground().equals(new Color(0, 204, 204))
                          && tf_c2.getForeground().equals(Color.WHITE)
                          || tf_c2.getForeground().equals(new Color(0, 204, 204))
                          && tf_c3.getForeground().equals(Color.WHITE)
                          || tf_c3.getForeground().equals(new Color(0, 204, 204))
                          && tf_c4.getForeground().equals(Color.WHITE)
                          || tf_c4.getForeground().equals(new Color(0, 204, 204))) {
                        System.out.println("ON");
                        lb_left.setIcon(icon_on);
                  } else {
                        System.out.println("OFF");
                        lb_left.setIcon(icon_off);
                  }
            } else if (list_C.size() == 5) {
                  if (tf_name.getForeground().equals(Color.WHITE)
                          || tf_name.getForeground().equals(new Color(0, 204, 204))
                          && tf_c2.getForeground().equals(Color.WHITE)
                          || tf_c2.getForeground().equals(new Color(0, 204, 204))
                          && tf_c3.getForeground().equals(Color.WHITE)
                          || tf_c3.getForeground().equals(new Color(0, 204, 204))
                          && tf_c4.getForeground().equals(Color.WHITE)
                          || tf_c4.getForeground().equals(new Color(0, 204, 204))
                          && tf_c5.getForeground().equals(Color.WHITE)
                          || tf_c5.getForeground().equals(new Color(0, 204, 204))) {
                        lb_left.setIcon(icon_on);
                        System.out.println("ON");
                  } else {
                        lb_left.setIcon(icon_off);
                        System.out.println("OFF");
                  }
            } else if (list_C.size() == 6) {
                  if (tf_name.getForeground().equals(Color.WHITE)
                          || tf_name.getForeground().equals(new Color(0, 204, 204))
                          && tf_c2.getForeground().equals(Color.WHITE)
                          || tf_c2.getForeground().equals(new Color(0, 204, 204))
                          && tf_c3.getForeground().equals(Color.WHITE)
                          || tf_c3.getForeground().equals(new Color(0, 204, 204))
                          && tf_c4.getForeground().equals(Color.WHITE)
                          || tf_c4.getForeground().equals(new Color(0, 204, 204))
                          && tf_c5.getForeground().equals(Color.WHITE)
                          || tf_c5.getForeground().equals(new Color(0, 204, 204))
                          && tf_c6.getForeground().equals(Color.WHITE)
                          || tf_c6.getForeground().equals(new Color(0, 204, 204))) {
                        lb_left.setIcon(icon_on);
                        System.out.println("ON");
                  } else {
                        lb_left.setIcon(icon_off);
                        System.out.println("OFF");
                  }
            }
      }

      private void setRightON() {
            if (lb_NDist1.getForeground().equals(Color.WHITE)
                    && lb_NDist2.getForeground().equals(Color.WHITE)
                    && lb_NTabl.getForeground().equals(Color.WHITE)
                    && lb_NTag1.getForeground().equals(Color.WHITE)) {
                  System.out.println("LB_RIGHT ~ON~");
                  lb_right.setIcon(icon_on);
            } else {
                  System.out.println("LB_RIGHT ~OFF~");
                  lb_right.setIcon(icon_off);
            }
      }

      private void TF_AR_BTNControl(ArrayList<String> list, JTextField tf,
              JButton btn) {
            int z = 0;
            if (tf.getText().isEmpty()) {
                  tf.setForeground(Color.RED);
                  btn.setEnabled(false);

            } else {
                  for (int a = 0; a < list.size(); a++) {
                        if (tf.getText().equals(list.get(a))) {
                              tf.setForeground(Color.RED);
                              btn.setEnabled(false);
                              z = 1;
                        } else {
                              if (z == 1) {
                              } else {
                                    tf.setForeground(Color.WHITE);
                                    btn.setEnabled(true);
                              }
                        }
                  }
            }
      }

      private void TF_AR_Control(ArrayList<String> list, JTextField tf) {
            int z = 0;
            for (int a = 0; a < DT.getBandW().size(); a++) {
                  if (tf.getText().contains(DT.getBandW().get(a))) {//CASE 0: EQUALS ELEMENT ON BANDW
                        System.out.println("CASE 0: EQUALS ELEMENT ON BANDW");
                        tf.setForeground(new Color(102, 0, 0));
                        z = 2;
                  }
            }
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if (z == 2) {
            } else {
                  z = 0;
                  if (tf.getText().isEmpty()) {//CASE 1: CLASH WITH FOCUSLOST
                        //System.out.println("CASE 1: EMPTY");
                        tf.setForeground(Color.RED);
                  } else {
                        for (int a = 0; a < list.size(); a++) {
                              if (tf.getText().equals(list.get(a))) {//CASE 2: EQUALS ELEMENT ON THE LIST
                                    //System.out.println("CASE 2: EQUALS ELEMENT ON THE LIST");
                                    tf.setForeground(new Color(0, 204, 204));
                                    z = 1;
                              } else {
                                    if (z == 1) {
                                    } else {
                                          String cut = list.get(a).replaceAll(" ", "_");
                                          if (tf.getText().equals(cut)) {//CASE 3: EQUALS ELEMENT ON THE LIST
                                                //System.out.println("CASE 3: EQUALS ELEMENT ON THE LIST WITH _");
                                                // WITH "_"
                                                tf.setForeground(new Color(0, 204, 204));
                                          } else {//CASE 4: DOESN'T EQUAL ANYTHING
                                                //System.out.println("CASE 4: DOESN'T EQUAL ANYTHING");
                                                tf.setForeground(Color.WHITE);
                                          }
                                    }
                              }
                        }
                  }
            }
      }

      private void btn_PControl() {
            if (list_C.size() == 6 || tf_nc.getText().isEmpty()) {
                  btn_p.setVisible(false);
            } else {
                  btn_p.setVisible(true);
            }
      }

      private void btn_DControl() {
            if (list_C.size() == 2) {
                  btn_d2.setEnabled(false);
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++++
      //CHANGE OR DELETE
      public int getJOptionPane_L(String table, int i) {
            //System.out.println("\tbtn_d" + i + " was selected");
            Object[] op = {"Change", "Delete"};

            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);

            int value = JOptionPane.showOptionDialog(jf,
                    "Column " + i + " Selected",
                    "DELETE FROM " + table,
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null, op, op[0]);

            return value;
      }

      public int getJOptionPane_R(String table, int i) {
            //System.out.println("\tbtn_dd" + i + " was selected");
            Object[] op = {"Yes", "No"};

            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);

            //int p = i == 1 ? 4 : 6;
            String p = "ERROR";
            if (i == 1) {
                  p = "Dist1";
            } else if (i == 2) {
                  p = "Dist2";
            } else if (i == 3) {
                  p = "Tag1";
            } else if (i == 4) {
                  p = "Tabl";
            }
            int value = JOptionPane.showOptionDialog(jf,
                    "Change " + p,
                    "CHANGE DISTS FROM " + table,
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null, op, op[1]);

            return value;
      }

      //ADD COLUMN
      public int getJOptionPane(String table, String colName) {
            Object[] op = {"Change", "Delete"};

            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);

            int value = JOptionPane.showOptionDialog(jf,
                    "Add Column " + colName + "?",
                    "ADD COL FROM " + table,
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null, op, op[0]);

            return value;
      }

      public String getCBDist1Selection() {
            String cb = "ERROR";
            System.out.println("cb_D1_1.getSelectedItem().toString(): " + 
                    cb_D1.getSelectedItem().toString());
            
            if (cb_D1.getSelectedItem().toString().equals("X1")) {
                  cb = "Dist1: " + cb_D1.getSelectedItem().toString() + ": "
                          + cb_D1_1.getSelectedItem().toString();
            } else if (cb_D1.getSelectedItem().toString().equals("X2")) {
                  cb = "Dist1: " + cb_D1.getSelectedItem().toString() + ": "
                          + cb_D1_1.getSelectedItem().toString() + "_"
                          + cb_D1_2.getSelectedItem().toString();
            } else if (cb_D1.getSelectedItem().toString().equals("X3")) {
                  cb = "Dist1: " + cb_D1.getSelectedItem().toString() + ": "
                          + cb_D1_1.getSelectedItem().toString() + "_"
                          + cb_D1_2.getSelectedItem().toString() + "_"
                          + cb_D1_3.getSelectedItem().toString();
            } else if (cb_D1.getSelectedItem().toString().equals("X4")) {
                  cb = "Dist1: " + cb_D1.getSelectedItem().toString() + ": "
                          + cb_D1_1.getSelectedItem().toString() + "_"
                          + cb_D1_2.getSelectedItem().toString() + "_"
                          + cb_D1_3.getSelectedItem().toString() + "_"
                          + cb_D1_4.getSelectedItem().toString();
            } else {
                  cb = "Dist1: NONE";
            }
            return cb;
      }

      public String getCBDist2Selection() {
            String cb = "ERROR";
            if (cb_D1.getSelectedItem().toString().equals("X1")) {
                  cb = "Dist2: " + cb_D2.getSelectedItem().toString() + ": "
                          + cb_D2_1.getSelectedItem().toString();
            } else if (cb_D2.getSelectedItem().toString().equals("X2")) {
                  cb = "Dist2: " + cb_D2.getSelectedItem().toString() + ": "
                          + cb_D2_1.getSelectedItem().toString() + "_"
                          + cb_D2_2.getSelectedItem().toString();
            } else {
                  cb = "Dist2: NONE";
            }
            return cb;
      }

      public String getCBTag1Selection() {
            String cb = "ERROR";
            if (cb_T1.getSelectedItem().toString().equals("X1")) {
                  cb = "Tag1: " + cb_T1.getSelectedItem().toString() + ": "
                          + cb_T1_1.getSelectedItem().toString();
            } else if (cb_T1.getSelectedItem().toString().equals("X2")) {
                  cb = "Tag1: " + cb_T1.getSelectedItem().toString() + ": "
                          + cb_T1_1.getSelectedItem().toString() + "_"
                          + cb_T1_2.getSelectedItem().toString();
            } else if (cb_T1.getSelectedItem().toString().equals("X3")) {
                  cb = "Tag1: " + cb_T1.getSelectedItem().toString() + ": "
                          + cb_T1_1.getSelectedItem().toString() + "_"
                          + cb_T1_2.getSelectedItem().toString() + "_"
                          + cb_T1_3.getSelectedItem().toString();
            } else if (cb_T1.getSelectedItem().toString().equals("X4")) {
                  cb = "Tag1: " + cb_T1.getSelectedItem().toString() + ": "
                          + cb_T1_1.getSelectedItem().toString() + "_"
                          + cb_T1_2.getSelectedItem().toString() + "_"
                          + cb_T1_3.getSelectedItem().toString() + "_"
                          + cb_T1_4.getSelectedItem().toString();
            } else {
                  cb = "Tag1: NONE";
            }
            return cb;
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++++
      public void MCDropColumn(int col) {
            try {
                  con = DriverManager.getConnection(
                          "jdbc:mysql://localhost:3306/TIME_STAM?allowPublicKeyRetrieval=true&useSSL=false",
                          "root",
                          "ccfmps00112");

                  Statement stmt = con.createStatement();
                  //ALTER TABLE table_name DROP COLUMN column_name;
                  String sql = "ALTER TABLE " + list_D.get(0)//list_D.get(0)
                          + " DROP COLUMN " + list_C.get(--col);//list_C.get(--col)

                  System.out.println(sql);
                  int i = stmt.executeUpdate(sql);
                  //System.out.println("SQL: " + sql + "'\n stmt: " + i);
                  if (i == 0) {
                        //System.out.println("UPDATE!");
                        list_C.remove(--col);

                        String mes = "MCColumn " + list_C.get(--col)
                                + "(" + col + ")" + " DROP!";
                        st.startLBStatus(lb_Status, cl[1], mes, 4000);
                  } else {
                        System.out.println("NOT UPDATE!");
                        st.startLBStatus(lb_Status, cl[2], inter, 8000);
                  }
            } catch (SQLException ex) {
                  Logger.getLogger(VF.class
                          .getName()).log(Level.SEVERE, null, ex);

                  st.startLBStatus(lb_Status, cl[0], ex.toString(), 8000);
            }
      }

      private void tfDeletionC2() {
            if (list_C.size() + 1 == 6) {
                  System.out.println("\t\tDelete 2C on a 6C Table");
                  tf_c6.setVisible(false);
                  lb_c6.setVisible(false);
                  btn_d6.setVisible(false);

                  tf_c2.setText(tf_c3.getText());
                  tf_c3.setText(tf_c4.getText());
                  tf_c4.setText(tf_c5.getText());
                  tf_c5.setText(tf_c6.getText());
            } else if (list_C.size() + 1 == 5) {
                  System.out.println("\t\tDelete 2C on a 5C Table");
                  tf_c5.setVisible(false);
                  lb_c5.setVisible(false);
                  btn_d5.setVisible(false);

                  tf_c2.setText(tf_c3.getText());
                  tf_c3.setText(tf_c4.getText());
                  tf_c4.setText(tf_c5.getText());
            } else if (list_C.size() + 1 == 4) {
                  System.out.println("\t\tDelete 2C on a 4C Table");
                  tf_c4.setVisible(false);
                  lb_c4.setVisible(false);
                  btn_d4.setVisible(false);

                  tf_c2.setText(tf_c3.getText());
                  tf_c3.setText(tf_c4.getText());
            } else if (list_C.size() + 1 == 3) {
                  System.out.println("\t\tDelete 2C on a 3C Table");
                  tf_c3.setVisible(false);
                  lb_c3.setVisible(false);
                  btn_d3.setVisible(false);

                  tf_c2.setText(tf_c3.getText());
            }
      }

      private void tfDeletionC3() {
            if (list_C.size() + 1 == 6) {
                  System.out.println("\t\tDelete 3C on a 6C Table");
                  tf_c6.setVisible(false);
                  lb_c6.setVisible(false);
                  btn_d6.setVisible(false);

                  tf_c3.setText(tf_c4.getText());
                  tf_c4.setText(tf_c5.getText());
                  tf_c5.setText(tf_c6.getText());
            } else if (list_C.size() + 1 == 5) {
                  System.out.println("\t\tDelete 3C on a 5C Table");
                  tf_c5.setVisible(false);
                  lb_c5.setVisible(false);
                  btn_d5.setVisible(false);

                  tf_c3.setText(tf_c4.getText());
                  tf_c4.setText(tf_c5.getText());
            } else if (list_C.size() + 1 == 4) {
                  System.out.println("\t\tDelete 3C on a 4C Table");
                  tf_c4.setVisible(false);
                  lb_c4.setVisible(false);
                  btn_d4.setVisible(false);

                  tf_c3.setText(tf_c4.getText());
            } else if (list_C.size() + 1 == 3) {
                  System.out.println("\t\tDelete 3C on a 3C Table");
                  tf_c3.setVisible(false);
                  lb_c3.setVisible(false);
                  btn_d3.setVisible(false);

                  //tf_c2.setText(tf_c3.getText());
            }
      }

      private void tfDeletionC4() {
            if (list_C.size() + 1 == 6) {
                  System.out.println("\t\tDelete 4C on a 6C Table");
                  tf_c6.setVisible(false);
                  lb_c6.setVisible(false);
                  btn_d6.setVisible(false);

                  tf_c4.setText(tf_c5.getText());
                  tf_c5.setText(tf_c6.getText());
            } else if (list_C.size() + 1 == 5) {
                  System.out.println("\t\tDelete 4C on a 5C Table");
                  tf_c5.setVisible(false);
                  lb_c5.setVisible(false);
                  btn_d5.setVisible(false);

                  tf_c4.setText(tf_c5.getText());
            } else if (list_C.size() + 1 == 4) {
                  System.out.println("\t\tDelete 4C on a 4C Table");
                  tf_c4.setVisible(false);
                  lb_c4.setVisible(false);
                  btn_d4.setVisible(false);

                  //tf_c3.setText(tf_c4.getText());
            }
      }

      private void tfDeletionC5() {
            if (list_C.size() + 1 == 6) {
                  System.out.println("\t\tDelete 5C on a 6C Table");
                  tf_c6.setVisible(false);
                  lb_c6.setVisible(false);
                  btn_d6.setVisible(false);

                  tf_c5.setText(tf_c6.getText());
            } else if (list_C.size() + 1 == 5) {
                  System.out.println("\t\tDelete 5C on a 5C Table");
                  tf_c5.setVisible(false);
                  lb_c5.setVisible(false);
                  btn_d5.setVisible(false);

            }
      }

      private void tfDeletionC6() {
            if (list_C.size() + 1 == 6) {
                  System.out.println("\t\tDelete 6C on a 6C Table");
                  tf_c6.setVisible(false);
                  lb_c6.setVisible(false);
                  btn_d6.setVisible(false);
            }
      }

      public void MCAddColumn(String ncol, String type, String extra) {
            try {
                  con = DriverManager.getConnection(
                          "jdbc:mysql://localhost:3306/TIME_STAM?allowPublicKeyRetrieval=true&useSSL=false",
                          "root",
                          "ccfmps00112");

                  Statement stmt = con.createStatement();
                  //ALTER TABLE table_name ADD COLUMN column_name type_column;
                  String sql = "ERROR";
                  if (extra.equals("NORMAL")) {
                        sql = "ALTER TABLE " + list_D.get(0)
                                + " ADD COLUMN " + ncol + " " + type;

                  } else if (extra.equals("NOT NULL")) {
                        sql = "ALTER TABLE " + list_D.get(0)
                                + " ADD COLUMN " + ncol + " " + type + " " + extra;
                  }

                  System.out.println(sql);
                  int i = stmt.executeUpdate(sql);
                  //System.out.println(i);
                  if (i == 0) {
                        //System.out.println("COLUMN ADDED!");
                        list_C.add(ncol);
                        list_TP.add(type);

                        String mes = "MCColumn " + ncol + " ADDED!";
                        st.startLBStatus(lb_Status, cl[1], mes, 4000);
                  } else {
                        //System.out.println("NOT UPDATE!");
                        st.startLBStatus(lb_Status, cl[2], inter, 8000);
                  }
            } catch (SQLException ex) {
                  Logger.getLogger(VF.class
                          .getName()).log(Level.SEVERE, null, ex);

                  st.startLBStatus(lb_Status, cl[0], ex.toString(), 8000);
            }
      }

      private String MCChange1Column(boolean lbStatus, int ocol, String ncol,
              String type, boolean extra) {
            try {
                  Connection con = DriverManager.getConnection(
                          "jdbc:mysql://localhost:3306/TIME_STAM?allowPublicKeyRetrieval=true&useSSL=false",
                          "root",
                          "ccfmps00112");

                  Statement stmt = con.createStatement();
                  String sql = "ERROR";
                  if (extra == true) {
                        sql = "ALTER TABLE " + list_D.get(0) + " CHANGE "
                                + list_C.get(--ocol) + " " + ncol + " " + type;
                  } else {
                        sql = "ALTER TABLE " + list_D.get(0) + " CHANGE "
                                + list_C.get(--ocol) + " " + ncol + " " + type + " NOT NULL";
                  }

                  System.out.println("SQL: " + sql);
                  int i = stmt.executeUpdate(sql);
                  //String value = "ERROR";
                  if (i == 0) {
                        if (lbStatus == false) {
                              ncol = "MCColumn " + ocol + " Changed! - ";
                        } else {
                              st.startLBStatus(lb_Status, cl[1], "MCColumn " + ocol + " Changed!", 4000);
                        }
                  } else {
                        if (lbStatus == false) {
                              ncol = "???????????? - ";
                        } else {
                              st.startLBStatus(lb_Status, cl[2], inter, 8000);
                        }
                  }

            } catch (SQLException ex) {
                  Logger.getLogger(VF.class.getName()).log(Level.SEVERE, null, ex);
                  if (lbStatus == false) {
                        ncol = "MCColumn " + ocol + " Changed! - ";
                  } else {
                        st.startLBStatus(lb_Status, cl[0], ex.toString(), 8000);
                  }
            }
            return ncol;
      }

      private void MCUpdateDists(String table, String dt, String nd) {
            try {
                  con = DriverManager.getConnection(
                          "jdbc:mysql://localhost:3306/TIME_STAM?allowPublicKeyRetrieval=true&useSSL=false",
                          "root",
                          "ccfmps00112");
                  //+++++++++++++++++++++++++++
                  if(table.contains("_")){
                        table = table.replaceAll("_", " ");
                  }
                  //+++++++++++++++++++++++++++
                  Statement stmt = con.createStatement();
                  //ALTER TABLE table_name ADD COLUMN column_name type_column;
                  String sql = "UPDATE Table_Names SET " + dt + " = \""
                          + nd + "\" WHERE Table_Names = " + "\""+ table + "\"";

                  System.out.println(sql);
                  int i = stmt.executeUpdate(sql);
                  if (i > 0) {
                        list_D.set(1, nd);
                        //vf.setDist1(list_D.get(1));

                        st.startLBStatus(lb_Status, cl[1], "Dist1 Changed!", 4000);
                  } else {
                        //System.out.println("NOT UPDATE!");
                        st.startLBStatus(lb_Status, cl[2], inter, 8000);
                  }

            } catch (SQLException ex) {
                  Logger.getLogger(VF.class
                          .getName()).log(Level.SEVERE, null, ex);

                  st.startLBStatus(lb_Status, cl[0], ex.toString(), 8000);
            }
      }

      public View_Update() {
            initComponents();
            frameConfig();
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //createLB_LR();
            createBTN_AD();
      }

      public View_Update(ArrayList<String> listD, ArrayList<String> listT, 
              ArrayList<String> listC, ArrayList<String> listTP, ArrayList<String> listNL) {
            initComponents();
            for (int a = 0; a < listD.size(); a++) {
                  list_D.add(listD.get(a));
            }
            for (int a = 0; a < listT.size(); a++) {
                  list_T.add(listT.get(a));
            }
            for (int a = 0; a < listC.size(); a++) {
                  list_C.add(listC.get(a));
            }
            for (int a = 0; a < listTP.size(); a++) {
                  list_TP.add(listTP.get(a));
            }
            for (int a = 0; a < listNL.size(); a++) {
                  list_NL.add(listNL.get(a));
            }
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            jtf = new JTextField[]{tf_c2, tf_c3, tf_c4, tf_c5, tf_c6};
            jcb = new JComboBox[]{cb_c2, cb_c3, cb_c4, cb_c5, cb_c6};
            jcbx = new JCheckBox[]{cbx_c2, cbx_c3, cbx_c4, cbx_c5, cbx_c6};

            jcb2 = new JComboBox[]{cb_D1, cb_D2, cb_T1, cb_TB};
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            frameConfig();
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //createLB_LR();
            createBTN_AD();
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
            tf_name.setText(listD.get(0));
            lb_ODist1.setText("Dist1: " + listD.get(1));
            lb_ODist2.setText("Dist2: " + listD.get(2));
            lb_OTabl.setText("Tabl: " + listD.get(3));
            lb_OTag1.setText("Tag1: " + listD.get(4));
            lb_OTag2.setText("Tag2: " + listD.get(5));
            //btn_change.setEnabled(false);
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
            setTF_LBValues();
            setCBX_CB();
            setCBValues();
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
            btn_DControl();
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
            this.addWindowListener(new WindowAdapter() {
                  @Override
                  public void windowClosing(WindowEvent e) {
                        vf.setVisible(true);
                  }
            });
            //EXTRA-------------------------
            panel1.setToolTipText(null);
            sc_panel1.setToolTipText(null);
      }

      /**
       * This method is called from within the constructor to initialize the
       * form. WARNING: Do NOT modify this code. The content of this method is
       * always regenerated by the Form Editor.
       */
      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            panel2 = new javax.swing.JPanel();
            cb_D1 = new javax.swing.JComboBox<>();
            cb_D1_1 = new javax.swing.JComboBox<>();
            cb_D1_2 = new javax.swing.JComboBox<>();
            cb_D1_3 = new javax.swing.JComboBox<>();
            cb_D1_4 = new javax.swing.JComboBox<>();
            cb_D2_2 = new javax.swing.JComboBox<>();
            cb_D2_1 = new javax.swing.JComboBox<>();
            cb_D2 = new javax.swing.JComboBox<>();
            lb_Dist2 = new javax.swing.JLabel();
            lb_Tabl = new javax.swing.JLabel();
            cb_TB = new javax.swing.JComboBox<>();
            lb_Tag1 = new javax.swing.JLabel();
            cb_T1 = new javax.swing.JComboBox<>();
            cb_T1_1 = new javax.swing.JComboBox<>();
            cb_T1_2 = new javax.swing.JComboBox<>();
            cb_T1_3 = new javax.swing.JComboBox<>();
            cb_T1_4 = new javax.swing.JComboBox<>();
            jLabel1 = new javax.swing.JLabel();
            lb_Tag2 = new javax.swing.JLabel();
            lb_Dist3 = new javax.swing.JLabel();
            lb_OTag2 = new javax.swing.JLabel();
            lb_ODist2 = new javax.swing.JLabel();
            lb_NDist2 = new javax.swing.JLabel();
            lb_NTag1 = new javax.swing.JLabel();
            jSeparator2 = new javax.swing.JSeparator();
            lb_NTabl = new javax.swing.JLabel();
            lb_new = new javax.swing.JLabel();
            lb_ODist1 = new javax.swing.JLabel();
            lb_old = new javax.swing.JLabel();
            jSeparator3 = new javax.swing.JSeparator();
            lb_NDist1 = new javax.swing.JLabel();
            lb_OTag1 = new javax.swing.JLabel();
            lb_NTag2 = new javax.swing.JLabel();
            lb_OTabl = new javax.swing.JLabel();
            sc_panel1 = new javax.swing.JScrollPane();
            panel1 = new javax.swing.JPanel();
            tf_c2 = new javax.swing.JTextField();
            lb_c2 = new javax.swing.JLabel();
            lb_name = new javax.swing.JLabel();
            tf_name = new javax.swing.JTextField();
            lb_c3 = new javax.swing.JLabel();
            tf_c3 = new javax.swing.JTextField();
            lb_c4 = new javax.swing.JLabel();
            tf_c4 = new javax.swing.JTextField();
            tf_c5 = new javax.swing.JTextField();
            lb_c5 = new javax.swing.JLabel();
            lb_c6 = new javax.swing.JLabel();
            tf_c6 = new javax.swing.JTextField();
            jSeparator1 = new javax.swing.JSeparator();
            btn_change = new javax.swing.JButton();
            lb_nc = new javax.swing.JLabel();
            jSeparator4 = new javax.swing.JSeparator();
            tf_nc = new javax.swing.JTextField();
            cb_nc = new javax.swing.JComboBox<>();
            cb_c6 = new javax.swing.JComboBox<>();
            cb_c2 = new javax.swing.JComboBox<>();
            cb_c3 = new javax.swing.JComboBox<>();
            cb_c4 = new javax.swing.JComboBox<>();
            cb_c5 = new javax.swing.JComboBox<>();
            cbx_nc = new javax.swing.JCheckBox();
            cbx_c2 = new javax.swing.JCheckBox();
            cbx_c3 = new javax.swing.JCheckBox();
            cbx_c4 = new javax.swing.JCheckBox();
            cbx_c5 = new javax.swing.JCheckBox();
            cbx_c6 = new javax.swing.JCheckBox();
            lb_name1 = new javax.swing.JLabel();
            lb_name2 = new javax.swing.JLabel();
            lb_name3 = new javax.swing.JLabel();
            lb_name4 = new javax.swing.JLabel();
            jSeparator5 = new javax.swing.JSeparator();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setAlwaysOnTop(true);
            getContentPane().setLayout(null);

            panel2.setBackground(new java.awt.Color(0, 0, 0));
            panel2.setLayout(null);

            cb_D1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            cb_D1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE", "X1", "X2", "X3", "X4" }));
            cb_D1.addItemListener(new java.awt.event.ItemListener() {
                  public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        cb_D1ItemStateChanged(evt);
                  }
            });
            panel2.add(cb_D1);
            cb_D1.setBounds(80, 10, 90, 28);

            cb_D1_1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            cb_D1_1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5", "6" }));
            cb_D1_1.addItemListener(new java.awt.event.ItemListener() {
                  public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        cb_D1_1ItemStateChanged(evt);
                  }
            });
            panel2.add(cb_D1_1);
            cb_D1_1.setBounds(180, 10, 50, 28);

            cb_D1_2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            cb_D1_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5", "6" }));
            cb_D1_2.setSelectedIndex(1);
            cb_D1_2.addItemListener(new java.awt.event.ItemListener() {
                  public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        cb_D1_2ItemStateChanged(evt);
                  }
            });
            panel2.add(cb_D1_2);
            cb_D1_2.setBounds(230, 10, 50, 28);

            cb_D1_3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            cb_D1_3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5", "6" }));
            cb_D1_3.setSelectedIndex(2);
            cb_D1_3.addItemListener(new java.awt.event.ItemListener() {
                  public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        cb_D1_3ItemStateChanged(evt);
                  }
            });
            panel2.add(cb_D1_3);
            cb_D1_3.setBounds(280, 10, 50, 28);

            cb_D1_4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            cb_D1_4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5", "6" }));
            cb_D1_4.setSelectedIndex(3);
            cb_D1_4.addItemListener(new java.awt.event.ItemListener() {
                  public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        cb_D1_4ItemStateChanged(evt);
                  }
            });
            panel2.add(cb_D1_4);
            cb_D1_4.setBounds(330, 10, 50, 28);

            cb_D2_2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            cb_D2_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2-3", "3-4", "4-5", "5-6" }));
            cb_D2_2.setSelectedIndex(1);
            cb_D2_2.addItemListener(new java.awt.event.ItemListener() {
                  public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        cb_D2_2ItemStateChanged(evt);
                  }
            });
            panel2.add(cb_D2_2);
            cb_D2_2.setBounds(250, 46, 60, 28);

            cb_D2_1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            cb_D2_1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2-3", "3-4", "4-5", "5-6" }));
            cb_D2_1.addItemListener(new java.awt.event.ItemListener() {
                  public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        cb_D2_1ItemStateChanged(evt);
                  }
            });
            panel2.add(cb_D2_1);
            cb_D2_1.setBounds(180, 46, 70, 28);

            cb_D2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            cb_D2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE", "X1", "X2" }));
            cb_D2.addItemListener(new java.awt.event.ItemListener() {
                  public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        cb_D2ItemStateChanged(evt);
                  }
            });
            panel2.add(cb_D2);
            cb_D2.setBounds(80, 46, 90, 28);

            lb_Dist2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_Dist2.setForeground(new java.awt.Color(255, 255, 255));
            lb_Dist2.setText("Dist2");
            panel2.add(lb_Dist2);
            lb_Dist2.setBounds(10, 46, 70, 28);

            lb_Tabl.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_Tabl.setForeground(new java.awt.Color(255, 255, 255));
            lb_Tabl.setText("Tabl");
            panel2.add(lb_Tabl);
            lb_Tabl.setBounds(10, 154, 70, 28);

            cb_TB.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            cb_TB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE", "C2", "C3", "C4", "C5", "C6" }));
            cb_TB.addItemListener(new java.awt.event.ItemListener() {
                  public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        cb_TBItemStateChanged(evt);
                  }
            });
            panel2.add(cb_TB);
            cb_TB.setBounds(80, 154, 90, 28);

            lb_Tag1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_Tag1.setForeground(new java.awt.Color(255, 255, 255));
            lb_Tag1.setText("Tag1");
            panel2.add(lb_Tag1);
            lb_Tag1.setBounds(10, 82, 70, 28);

            cb_T1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            cb_T1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE", "X1", "X2", "X3", "X4" }));
            cb_T1.addItemListener(new java.awt.event.ItemListener() {
                  public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        cb_T1ItemStateChanged(evt);
                  }
            });
            panel2.add(cb_T1);
            cb_T1.setBounds(80, 82, 90, 28);

            cb_T1_1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            cb_T1_1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5", "6" }));
            cb_T1_1.addItemListener(new java.awt.event.ItemListener() {
                  public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        cb_T1_1ItemStateChanged(evt);
                  }
            });
            panel2.add(cb_T1_1);
            cb_T1_1.setBounds(180, 82, 50, 28);

            cb_T1_2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            cb_T1_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5", "6" }));
            cb_T1_2.setSelectedIndex(1);
            cb_T1_2.addItemListener(new java.awt.event.ItemListener() {
                  public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        cb_T1_2ItemStateChanged(evt);
                  }
            });
            panel2.add(cb_T1_2);
            cb_T1_2.setBounds(230, 82, 50, 28);

            cb_T1_3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            cb_T1_3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5", "6" }));
            cb_T1_3.setSelectedIndex(2);
            cb_T1_3.addItemListener(new java.awt.event.ItemListener() {
                  public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        cb_T1_3ItemStateChanged(evt);
                  }
            });
            panel2.add(cb_T1_3);
            cb_T1_3.setBounds(280, 82, 50, 28);

            cb_T1_4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            cb_T1_4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5", "6" }));
            cb_T1_4.setSelectedIndex(3);
            cb_T1_4.addItemListener(new java.awt.event.ItemListener() {
                  public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        cb_T1_4ItemStateChanged(evt);
                  }
            });
            panel2.add(cb_T1_4);
            cb_T1_4.setBounds(330, 82, 50, 28);

            jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(153, 0, 0));
            jLabel1.setText("NOT FUNCTIONAL YET");
            panel2.add(jLabel1);
            jLabel1.setBounds(80, 118, 210, 28);

            lb_Tag2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_Tag2.setForeground(new java.awt.Color(255, 255, 255));
            lb_Tag2.setText("Tag2");
            panel2.add(lb_Tag2);
            lb_Tag2.setBounds(10, 118, 70, 28);

            lb_Dist3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_Dist3.setForeground(new java.awt.Color(255, 255, 255));
            lb_Dist3.setText("Dist1");
            panel2.add(lb_Dist3);
            lb_Dist3.setBounds(10, 10, 70, 28);

            lb_OTag2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_OTag2.setForeground(new java.awt.Color(153, 153, 153));
            lb_OTag2.setText("Tag2: NONE");
            panel2.add(lb_OTag2);
            lb_OTag2.setBounds(10, 320, 160, 28);

            lb_ODist2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_ODist2.setForeground(new java.awt.Color(255, 255, 255));
            lb_ODist2.setText("Dist2: ");
            panel2.add(lb_ODist2);
            lb_ODist2.setBounds(10, 260, 160, 28);

            lb_NDist2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_NDist2.setForeground(new java.awt.Color(255, 255, 255));
            lb_NDist2.setText("Dist2: NONE");
            panel2.add(lb_NDist2);
            lb_NDist2.setBounds(180, 260, 160, 28);

            lb_NTag1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_NTag1.setForeground(new java.awt.Color(255, 255, 255));
            lb_NTag1.setText("Tag1: NONE");
            panel2.add(lb_NTag1);
            lb_NTag1.setBounds(180, 290, 160, 28);
            panel2.add(jSeparator2);
            jSeparator2.setBounds(0, 220, 370, 10);

            lb_NTabl.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_NTabl.setForeground(new java.awt.Color(255, 255, 255));
            lb_NTabl.setText("Tabl: NONE");
            panel2.add(lb_NTabl);
            lb_NTabl.setBounds(180, 350, 170, 28);

            lb_new.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_new.setForeground(new java.awt.Color(255, 255, 255));
            lb_new.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lb_new.setText("New");
            panel2.add(lb_new);
            lb_new.setBounds(190, 190, 160, 28);

            lb_ODist1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_ODist1.setForeground(new java.awt.Color(255, 255, 255));
            lb_ODist1.setText("Dist1: ");
            panel2.add(lb_ODist1);
            lb_ODist1.setBounds(10, 230, 160, 28);

            lb_old.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_old.setForeground(new java.awt.Color(255, 255, 255));
            lb_old.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lb_old.setText("Old");
            panel2.add(lb_old);
            lb_old.setBounds(10, 190, 160, 28);
            panel2.add(jSeparator3);
            jSeparator3.setBounds(0, 188, 370, 10);

            lb_NDist1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_NDist1.setForeground(new java.awt.Color(255, 255, 255));
            lb_NDist1.setText("Dist1: NONE");
            panel2.add(lb_NDist1);
            lb_NDist1.setBounds(180, 230, 160, 28);

            lb_OTag1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_OTag1.setForeground(new java.awt.Color(255, 255, 255));
            lb_OTag1.setText("Tag1: ");
            panel2.add(lb_OTag1);
            lb_OTag1.setBounds(10, 290, 160, 28);

            lb_NTag2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_NTag2.setForeground(new java.awt.Color(153, 153, 153));
            lb_NTag2.setText("Tag2: NONE");
            panel2.add(lb_NTag2);
            lb_NTag2.setBounds(180, 320, 160, 28);

            lb_OTabl.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_OTabl.setForeground(new java.awt.Color(255, 255, 255));
            lb_OTabl.setText("Tabl: ");
            panel2.add(lb_OTabl);
            lb_OTabl.setBounds(10, 350, 150, 28);

            getContentPane().add(panel2);
            panel2.setBounds(520, 0, 390, 390);

            sc_panel1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            sc_panel1.setToolTipText(null);
            sc_panel1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

            panel1.setBackground(new java.awt.Color(0, 0, 0));
            panel1.setLayout(null);

            tf_c2.setBackground(new java.awt.Color(51, 51, 51));
            tf_c2.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
            tf_c2.setForeground(new java.awt.Color(0, 204, 204));
            tf_c2.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyReleased(java.awt.event.KeyEvent evt) {
                        tf_c2KeyReleased(evt);
                  }
            });
            panel1.add(tf_c2);
            tf_c2.setBounds(110, 110, 150, 28);

            lb_c2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_c2.setForeground(new java.awt.Color(255, 255, 255));
            lb_c2.setText("Column 2");
            panel1.add(lb_c2);
            lb_c2.setBounds(10, 110, 90, 28);

            lb_name.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_name.setForeground(new java.awt.Color(255, 255, 255));
            lb_name.setText("Table Name");
            panel1.add(lb_name);
            lb_name.setBounds(10, 60, 90, 28);

            tf_name.setBackground(new java.awt.Color(51, 51, 51));
            tf_name.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
            tf_name.setForeground(new java.awt.Color(0, 204, 204));
            tf_name.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyReleased(java.awt.event.KeyEvent evt) {
                        tf_nameKeyReleased(evt);
                  }
            });
            panel1.add(tf_name);
            tf_name.setBounds(110, 60, 150, 28);

            lb_c3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_c3.setForeground(new java.awt.Color(255, 255, 255));
            lb_c3.setText("Column 3");
            panel1.add(lb_c3);
            lb_c3.setBounds(10, 150, 90, 28);

            tf_c3.setBackground(new java.awt.Color(51, 51, 51));
            tf_c3.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
            tf_c3.setForeground(new java.awt.Color(0, 204, 204));
            tf_c3.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyReleased(java.awt.event.KeyEvent evt) {
                        tf_c3KeyReleased(evt);
                  }
            });
            panel1.add(tf_c3);
            tf_c3.setBounds(110, 150, 150, 28);

            lb_c4.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_c4.setForeground(new java.awt.Color(255, 255, 255));
            lb_c4.setText("Column 4");
            panel1.add(lb_c4);
            lb_c4.setBounds(10, 190, 90, 28);

            tf_c4.setBackground(new java.awt.Color(51, 51, 51));
            tf_c4.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
            tf_c4.setForeground(new java.awt.Color(0, 204, 204));
            tf_c4.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyReleased(java.awt.event.KeyEvent evt) {
                        tf_c4KeyReleased(evt);
                  }
            });
            panel1.add(tf_c4);
            tf_c4.setBounds(110, 190, 150, 28);

            tf_c5.setBackground(new java.awt.Color(51, 51, 51));
            tf_c5.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
            tf_c5.setForeground(new java.awt.Color(0, 204, 204));
            tf_c5.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyReleased(java.awt.event.KeyEvent evt) {
                        tf_c5KeyReleased(evt);
                  }
            });
            panel1.add(tf_c5);
            tf_c5.setBounds(110, 230, 150, 28);

            lb_c5.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_c5.setForeground(new java.awt.Color(255, 255, 255));
            lb_c5.setText("Column 5");
            panel1.add(lb_c5);
            lb_c5.setBounds(10, 230, 90, 28);

            lb_c6.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_c6.setForeground(new java.awt.Color(255, 255, 255));
            lb_c6.setText("Column 6");
            panel1.add(lb_c6);
            lb_c6.setBounds(10, 270, 90, 28);

            tf_c6.setBackground(new java.awt.Color(51, 51, 51));
            tf_c6.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
            tf_c6.setForeground(new java.awt.Color(0, 204, 204));
            tf_c6.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyReleased(java.awt.event.KeyEvent evt) {
                        tf_c6KeyReleased(evt);
                  }
            });
            panel1.add(tf_c6);
            tf_c6.setBounds(110, 270, 150, 28);
            panel1.add(jSeparator1);
            jSeparator1.setBounds(0, 310, 440, 10);

            btn_change.setText("CHANGE");
            btn_change.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_changeActionPerformed(evt);
                  }
            });
            panel1.add(btn_change);
            btn_change.setBounds(220, 390, 110, 32);

            lb_nc.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_nc.setForeground(new java.awt.Color(255, 255, 255));
            lb_nc.setText("New Col");
            panel1.add(lb_nc);
            lb_nc.setBounds(10, 320, 100, 28);
            panel1.add(jSeparator4);
            jSeparator4.setBounds(0, 96, 440, 10);

            tf_nc.setBackground(new java.awt.Color(51, 51, 51));
            tf_nc.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
            tf_nc.setForeground(new java.awt.Color(255, 0, 0));
            tf_nc.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyReleased(java.awt.event.KeyEvent evt) {
                        tf_ncKeyReleased(evt);
                  }
            });
            panel1.add(tf_nc);
            tf_nc.setBounds(110, 320, 150, 28);

            cb_nc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "varchar(50)", "varchar(100)", "varchar(200)", "time" }));
            panel1.add(cb_nc);
            cb_nc.setBounds(288, 320, 140, 28);

            cb_c6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "varchar(50)", "varchar(100)", "varchar(200)", "time" }));
            panel1.add(cb_c6);
            cb_c6.setBounds(288, 270, 140, 28);

            cb_c2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "varchar(50)", "varchar(100)", "varchar(200)", "time" }));
            panel1.add(cb_c2);
            cb_c2.setBounds(288, 110, 140, 28);

            cb_c3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "varchar(50)", "varchar(100)", "varchar(200)", "time" }));
            panel1.add(cb_c3);
            cb_c3.setBounds(288, 150, 140, 28);

            cb_c4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "varchar(50)", "varchar(100)", "varchar(200)", "time" }));
            panel1.add(cb_c4);
            cb_c4.setBounds(288, 190, 140, 28);

            cb_c5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "varchar(50)", "varchar(100)", "varchar(200)", "time" }));
            panel1.add(cb_c5);
            cb_c5.setBounds(288, 230, 140, 28);
            panel1.add(cbx_nc);
            cbx_nc.setBounds(264, 320, 26, 28);
            panel1.add(cbx_c2);
            cbx_c2.setBounds(264, 110, 26, 28);
            panel1.add(cbx_c3);
            cbx_c3.setBounds(264, 150, 26, 28);
            panel1.add(cbx_c4);
            cbx_c4.setBounds(264, 190, 26, 28);
            panel1.add(cbx_c5);
            cbx_c5.setBounds(264, 230, 26, 28);
            panel1.add(cbx_c6);
            cbx_c6.setBounds(264, 270, 26, 28);

            lb_name1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_name1.setForeground(new java.awt.Color(255, 255, 255));
            lb_name1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            lb_name1.setText("TYPE");
            panel1.add(lb_name1);
            lb_name1.setBounds(330, 10, 100, 28);

            lb_name2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_name2.setForeground(new java.awt.Color(255, 255, 255));
            lb_name2.setText("COLUMNS");
            panel1.add(lb_name2);
            lb_name2.setBounds(10, 10, 90, 28);

            lb_name3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_name3.setForeground(new java.awt.Color(255, 255, 255));
            lb_name3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lb_name3.setText("NAMES");
            panel1.add(lb_name3);
            lb_name3.setBounds(130, 10, 110, 28);

            lb_name4.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_name4.setForeground(new java.awt.Color(255, 255, 255));
            lb_name4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lb_name4.setText("NULL");
            panel1.add(lb_name4);
            lb_name4.setBounds(250, 10, 60, 28);
            panel1.add(jSeparator5);
            jSeparator5.setBounds(0, 44, 440, 10);

            sc_panel1.setViewportView(panel1);

            getContentPane().add(sc_panel1);
            sc_panel1.setBounds(0, 0, 520, 430);

            pack();
      }// </editor-fold>//GEN-END:initComponents

      private void tf_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_nameKeyReleased
            TF_AR_Control(list_T, tf_name);//REPLACE TF_CONTROL
            setLeftON();
            //bntChangeControl();
      }//GEN-LAST:event_tf_nameKeyReleased

      private void tf_c2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_c2KeyReleased
            tf_Control(tf_c2, list_C.get(1));
            setLeftON();
            //bntChangeControl();
      }//GEN-LAST:event_tf_c2KeyReleased

      private void tf_c3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_c3KeyReleased
            tf_Control(tf_c3, list_C.get(2));
            setLeftON();
            //bntChangeControl();
      }//GEN-LAST:event_tf_c3KeyReleased

      private void tf_c4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_c4KeyReleased
            tf_Control(tf_c4, list_C.get(3));
            setLeftON();
            //bntChangeControl();
      }//GEN-LAST:event_tf_c4KeyReleased

      private void tf_c5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_c5KeyReleased
            tf_Control(tf_c5, list_C.get(4));
            setLeftON();
            //bntChangeControl();
      }//GEN-LAST:event_tf_c5KeyReleased

      private void tf_c6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_c6KeyReleased
            tf_Control(tf_c6, list_C.get(5));
            setLeftON();
            //bntChangeControl();
      }//GEN-LAST:event_tf_c6KeyReleased

      private void cb_D1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_D1ItemStateChanged
            setDist1Visible();
            cb_Dist1Control();
            setlb_Dist1Name();

            setRightON();
            //bntChangeControl();
      }//GEN-LAST:event_cb_D1ItemStateChanged

      private void cb_D2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_D2ItemStateChanged
            setDist2Visible();
            cb_Dist2Control();
            setlb_Dist2Name();

            setRightON();
            //bntChangeControl();
      }//GEN-LAST:event_cb_D2ItemStateChanged

      private void cb_T1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_T1ItemStateChanged
            setTag1Visible();
            cb_Tag1Control();
            setlb_Tag1Name();

            setRightON();
            //bntChangeControl();
      }//GEN-LAST:event_cb_T1ItemStateChanged

      private void cb_TBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_TBItemStateChanged
            lb_NTabl.setText("Tabl: " + cb_TB.getSelectedItem());
            setRightON();
            //bntChangeControl();
      }//GEN-LAST:event_cb_TBItemStateChanged

      private void cb_D1_1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_D1_1ItemStateChanged
            cb_Dist1Control();
            setlb_Dist1Name();

            setRightON();
            //bntChangeControl();
      }//GEN-LAST:event_cb_D1_1ItemStateChanged

      private void cb_D1_2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_D1_2ItemStateChanged
            cb_Dist1Control();
            setlb_Dist1Name();

            setRightON();
            //bntChangeControl();
      }//GEN-LAST:event_cb_D1_2ItemStateChanged

      private void cb_D1_3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_D1_3ItemStateChanged
            cb_Dist1Control();
            setlb_Dist1Name();

            setRightON();
            //bntChangeControl();
      }//GEN-LAST:event_cb_D1_3ItemStateChanged

      private void cb_D1_4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_D1_4ItemStateChanged
            cb_Dist1Control();
            setlb_Dist1Name();

            setRightON();
            //bntChangeControl();
      }//GEN-LAST:event_cb_D1_4ItemStateChanged

      private void cb_D2_1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_D2_1ItemStateChanged
            cb_Dist2Control();
            setlb_Dist2Name();

            setRightON();
            //bntChangeControl();
      }//GEN-LAST:event_cb_D2_1ItemStateChanged

      private void cb_D2_2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_D2_2ItemStateChanged
            cb_Dist2Control();
            setlb_Dist2Name();

            setRightON();
            //bntChangeControl();
      }//GEN-LAST:event_cb_D2_2ItemStateChanged

      private void cb_T1_1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_T1_1ItemStateChanged
            cb_Tag1Control();
            setlb_Tag1Name();

            setRightON();
            //bntChangeControl();
      }//GEN-LAST:event_cb_T1_1ItemStateChanged

      private void cb_T1_2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_T1_2ItemStateChanged
            cb_Tag1Control();
            setlb_Tag1Name();

            setRightON();
            //bntChangeControl();
      }//GEN-LAST:event_cb_T1_2ItemStateChanged

      private void cb_T1_3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_T1_3ItemStateChanged
            cb_Tag1Control();
            setlb_Tag1Name();

            setRightON();
            //bntChangeControl();
      }//GEN-LAST:event_cb_T1_3ItemStateChanged

      private void cb_T1_4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_T1_4ItemStateChanged
            cb_Tag1Control();
            setlb_Tag1Name();

            setRightON();
            //bntChangeControl();
      }//GEN-LAST:event_cb_T1_4ItemStateChanged

      private void btn_changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_changeActionPerformed
            ArrayList<Integer> num_col = new ArrayList<Integer>();
            ArrayList<String> new_col = new ArrayList<String>();

            ArrayList<Integer> num_cb = new ArrayList<Integer>();
            ArrayList<String> new_cb = new ArrayList<String>();

            int c = 1;

            String ntable = "ERROR";
            boolean tableNameS = false;

            if (list_C.size() == 2) {
                  //IF THE TABLE NAME IS THE SAME AS IT WAS
                  if (list_D.get(0).equals(tf_name.getText())) {
                        tableNameS = false;
                  } else {
                        tableNameS = true;
                        ntable = tf_name.getText().replaceAll(" ", "_");
                  }
                  //IF THE 2ND COLUMN NAME IS THE SAME AS IT WAS
                  if (list_C.get(1).equals(tf_c2.getText())) {
                  } else {
                        num_col.add(2);
                        new_col.add(tf_c2.getText());
                  }
                  if (list_TP.get(1).equals(cb_c2.getSelectedItem())) {
                        num_cb.add(2);
                        new_cb.add(cb_c2.getSelectedItem().toString());
                  }

            } else if (list_C.size() == 3) {
                  if (list_D.get(0).equals(tf_name.getText())) {
                        tableNameS = false;
                  } else {
                        tableNameS = true;
                        ntable = tf_name.getText().replaceAll(" ", "_");
                  }
                  //TEST+++++++++++++++++++++++++++++++++++
                  for (int a = 0; a < 2; a++) {
                        if (list_C.get(c++).equals(jtf[a].getText())) {//1
                              num_col.add(c);//2
                              new_col.add(jtf[a].getText());
                        }
                  }
                  c = 1;
                  for (int a = 0; a < 2; a++) {
                        if (list_TP.get(c++).equals(jcb[a].getSelectedItem())) {//1
                              new_cb.add(jcb[a].getSelectedItem().toString());
                        }
                  }
                  //++++++++++++++++++++++++++++++++++++++++++++++++++
                  /*
                  if (list_TP.get(1).equals(cb_c2.getSelectedItem())) {
                        new_cb.add(cb_c2.getSelectedItem().toString());
                  }
                   *//*
                  if (dt.getList_C().get(1).equals(tf_c2.getText())) {
                  } else {
                        num_col.add(2);
                        new_col.add(tf_c2.getText());
                  }
                  if (list_C.get(2).equals(tf_c3.getText())) {
                  } else {
                        num_col.add(3);
                        new_col.add(tf_c3.getText());
                  }
                   */
                  //+++++++++++++++++++++++++++++++++

            } else if (list_C.size() == 4) {
                  if (list_D.get(0).equals(tf_name.getText())) {
                        tableNameS = false;
                  } else {
                        tableNameS = true;
                        ntable = tf_name.getText().replaceAll(" ", "_");
                  }

                  for (int a = 0; a < 3; a++) {
                        if (list_C.get(c++).equals(jtf[a].getText())) {//1
                              num_col.add(c);//2
                              new_col.add(jtf[a].getText());
                        }
                  }
                  c = 1;
                  for (int a = 0; a < 3; a++) {
                        if (list_TP.get(c++).equals(jcb[a].getSelectedItem())) {//1
                              new_cb.add(jcb[a].getSelectedItem().toString());
                        }
                  }
            } else if (list_C.size() == 5) {
                  if (list_D.get(0).equals(tf_name.getText())) {
                        tableNameS = false;
                  } else {
                        tableNameS = true;
                        ntable = tf_name.getText().replaceAll(" ", "_");
                  }
                  for (int a = 0; a < 4; a++) {
                        if (list_C.get(c++).equals(jtf[a].getText())) {//1
                              num_col.add(c);//2
                              new_col.add(jtf[a].getText());
                        }
                  }
                  c = 1;
                  for (int a = 0; a < 4; a++) {
                        if (list_TP.get(c++).equals(jcb[a].getSelectedItem())) {//1
                              new_cb.add(jcb[a].getSelectedItem().toString());
                        }
                  }
            } else if (list_C.size() == 6) {
                  if (list_D.get(0).equals(tf_name.getText())) {
                        tableNameS = false;
                  } else {
                        tableNameS = true;
                        ntable = tf_name.getText().replaceAll(" ", "_");
                  }

                  for (int a = 0; a < 5; a++) {
                        if (list_C.get(c++).equals(jtf[a].getText())) {//1
                              num_col.add(c);//2
                              new_col.add(jtf[a].getText());
                        }
                  }
                  c = 1;
                  for (int a = 0; a < 5; a++) {
                        if (list_TP.get(c++).equals(jcb[a].getSelectedItem())) {//1
                              new_cb.add(jcb[a].getSelectedItem().toString());
                        }
                  }
            }
            //++++++++++++++++++++++++++++++++++++++++++++++++++

            /*for (int d = 0; d < new_col.size(); d++) {
                  System.out.println("Data " + num_col.get(d) + ": " + new_col.get(d));
            }*/
            //++++++++++++++++++++++++++++++++++++++
            int[] nc = new int[5];//2 to 6
            String value = "";

            if (new_col.size() == 1) {
                  //ALTER TABLE table_name CHANGE column_name new_columnn_name type_column;
                  //MCChangeColumn
                  //nc[0] = num_col.get(0);
                  System.out.println("\nCol Number: " + num_col.get(0));
                  System.out.println("Old Col Name: " + list_C.get(--nc[0]));
                  System.out.println("New Col Name: " + new_col.get(0));
                  int index = - 1;
                  if (new_cb.size() == 0) {
                        index = num_col.get(0) - 2;
                        value = MCChange1Column(true, num_col.get(0),
                                new_col.get(0),
                                jcb[index].getSelectedItem().toString(),
                                jcbx[index].isSelected());
                  } else if (new_cb.size() == 1) {
                        //value = MCChange1Column(true, num_col.get(0), new_col.get(0),
                        //new_cb.get(0));
                  }

                  System.out.println("Value: " + value);
            } else if (new_col.size() == 2) {
                  for (int a = 0; a < num_col.size(); a++) {
                        nc[a] = num_col.get(a);//2
                        System.out.println("\nCol Number " + (++a) + ": " + num_col.get(a));
                        System.out.println("Old Col Name " + (++a) + ": " + list_C.get(--nc[a]));
                        System.out.println("New Col Name " + (++a) + ": " + new_col.get(a));

                        //value += MCChange1Column(false, num_col.get(a), new_col.get(a));
                        System.out.println("Value: " + value);
                  }
                  st.startLBStatus(lb_Status, cl[1], value, 8000);
            }

            //---------------------------------------------------------
            if (tableNameS
                    == true) {
                  System.out.println("Table Name has changed to: " + ntable);
            }
            /*
            try {
                  Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/TIME_STAM?allowPublicKeyRetrieval=true&useSSL=false",
                        "root",
                        "ccfmps00112");

                  Statement stmt = con.createStatement();
                  String sql = "CREATE TABLE " + tablename
                  + " (id INT NOT NULL AUTO_INCREMENT, "
                  + col + " VARCHAR(150) NOT NULL, "
                  + "PRIMARY KEY(id))ENGINE=INNODB";

                  i = stmt.executeUpdate(sql);
                  if (i > 0) {
                        lbStatus(true, "MCCreateTable2 Done!");
                  }

            } catch (SQLException ex) {
                  Logger.getLogger(VF.class.getName()).log(Level.SEVERE, null, ex);

                  lbStatus(false, ex.toString());
            }
             */

      }//GEN-LAST:event_btn_changeActionPerformed

      private void tf_ncKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_ncKeyReleased
            btn_PControl();
            //+++++++++++++++++++++++++++++++++++++++++++++
            TF_AR_BTNControl(DT.getBandW(), tf_nc, btn_p);//tf_control
      }//GEN-LAST:event_tf_ncKeyReleased

      /**
       * @param args the command line arguments
       */
      public static void main(String args[]) {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
             */
            try {
                  for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                              javax.swing.UIManager.setLookAndFeel(info.getClassName());
                              break;

                        }
                  }
            } catch (ClassNotFoundException ex) {
                  java.util.logging.Logger.getLogger(View_Update.class
                          .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                  java.util.logging.Logger.getLogger(View_Update.class
                          .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                  java.util.logging.Logger.getLogger(View_Update.class
                          .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                  java.util.logging.Logger.getLogger(View_Update.class
                          .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        new View_Update().setVisible(true);
                  }
            });

      }

      public class ChangeDeleteC implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent evt) {
                  System.out.println(">>>>>>>>>>>>>PRESS<<<<<<<<<<<<<");
                  JButton btnC = (JButton) evt.getSource();
                  int value = -1;
                  int col = -1;
                  //System.out.println("BTN GETY: " + btnC.getY());
                  //System.out.println("\nget Icon: " + btnC.getIcon() + "\n");
                  String gi = btnC.getIcon().toString();
                  //System.out.println("GI B: " + gi);
                  gi = gi.substring(gi.indexOf("s\\") + 2, gi.length());
                  //System.out.println("GI: " + gi);

                  if (gi.equals("Q small.png")) {
                        System.out.println("\tLEFT PANEL");
                        if (btnC.getY() == tf_c2.getY()) {
                              col = 2;
                              value = getJOptionPane_L(list_D.get(0), col);
                        } else if (btnC.getY() == tf_c3.getY()) {
                              col = 3;
                              value = getJOptionPane_L(list_D.get(0), col);
                        } else if (btnC.getY() == tf_c4.getY()) {
                              col = 4;
                              value = getJOptionPane_L(list_D.get(0), col);
                        } else if (btnC.getY() == tf_c5.getY()) {
                              col = 5;
                              value = getJOptionPane_L(list_D.get(0), col);
                        } else if (btnC.getY() == tf_c6.getY()) {
                              col = 6;
                              value = getJOptionPane_L(list_D.get(0), col);
                        }

                        //+++++++LEFT+PANEL+++++++++++++++++++++++++++++++++++++
                        if (value == 0) {
                              String xv = "ERROR";
                              if (jcbx[col - 2].isSelected()) {
                                    xv = "YES";
                              } else {
                                    xv = "NO";
                              }

                              if (!jtf[col - 2].getText().equals(list_C.get(col - 1))
                                      || !jcb[col - 2].getSelectedItem().equals(list_TP.get(col - 1))
                                      || !xv.equals(list_NL.get(col - 1))) {
                                    System.out.println("Something is Diferent!");

                                    MCChange1Column(true, col,
                                            jtf[col - 2].getText(),
                                            jcb[col - 2].getSelectedItem().toString(),
                                            jcbx[col - 2].isSelected());

                                    //+++++++++++++++++++++++++++++++++++++++++++++++++
                                    if (!jtf[col - 2].getText().equals(list_C.get(col - 1))) {
                                          System.out.println("\nlist_C previos element at "
                                                  + (col - 1) + ": " + list_C.get(col - 1));
                                          System.out.println("\tlist_C replaced by "
                                                  + (col - 1) + ": " + jtf[col - 2].getText());

                                          list_C.set(col - 1, jtf[col - 2].getText());
                                    }
                                    if (!jcb[col - 2].getSelectedItem().equals(list_TP.get(col - 1))) {
                                          System.out.println("\nlist_TP previos element at "
                                                  + (col - 1) + ": " + list_TP.get(col - 1));
                                          System.out.println("\tlist_TP replaced by "
                                                  + (col - 1) + ": " + jcb[col - 2].getSelectedItem().toString());

                                          list_TP.set(col - 1, jcb[col - 2].getSelectedItem().toString());
                                    }
                                    if (!xv.equals(list_NL.get(col - 1))) {
                                          System.out.println("\nlist_NL previos element at "
                                                  + (col - 1) + ": " + list_NL.get(col - 1));
                                          System.out.println("\tlist_NL replaced by "
                                                  + (col - 1) + ": " + xv);

                                          list_NL.set(col - 1, xv);
                                    }

                              } else {
                                    st.startLBStatus(lb_Status, cl[2],
                                            inter, 6000);
                              }
                        } else if (value == 1) {
                              System.out.println("\nD - PROCESS");
                              MCDropColumn(col);
                              //TF HIDE UPDATE LISTC
                              if (col == 2) {
                                    System.out.println("\tDeleting Column 2");
                                    tfDeletionC2();
                              } else if (col == 3) {
                                    System.out.println("\tDeleting Column 3");
                                    tfDeletionC3();
                              } else if (col == 4) {
                                    System.out.println("\tDeleting Column 4");
                                    tfDeletionC4();
                              } else if (col == 5) {
                                    System.out.println("\tDeleting Column 5");
                                    tfDeletionC5();
                              } else if (col == 6) {
                                    System.out.println("\tDeleting Column 6");
                                    tfDeletionC6();
                              }
                        }
                        //++++RIGHT+PANEL++++++++++++++++++++++++++++++++++++++
                  } else if (gi.equals("Q small2.png")) {

                        System.out.println("\tRIGHT PANEL");
                        if (btnC.getY() == cb_D1.getY()) {
                              col = 1;
                              value = getJOptionPane_R(list_D.get(0), col);
                        } else if (btnC.getY() == cb_D2.getY()) {
                              col = 2;
                              value = getJOptionPane_R(list_D.get(0), col);
                        } else if (btnC.getY() == cb_T1.getY()) {
                              col = 3;
                              value = getJOptionPane_R(list_D.get(0), col);
                        } else if (btnC.getY() == cb_TB.getY()) {
                              col = 4;
                              value = getJOptionPane_R(list_D.get(0), col);
                        }

                        if (value == 0) {
                              String sub = "ERROR";
                              String cb_text = "ERROR";
                              //REPLACE lb_N for cbs's Selection
                              if (col == 1) {
                                    cb_text = getCBDist1Selection();
                                    System.out.println("cb_text Dist1: " + cb_text);

                                    if (!lb_ODist1.getText().equals(cb_text)) {
                                          sub = lb_NDist1.getText();
                                          sub = sub.substring(sub.indexOf(": ") + 2);
                                          MCUpdateDists(list_D.get(0), "Dist1", sub);
                                    } else {
                                          st.startLBStatus(lb_Status, cl[2], inter, 5000);
                                    }
                              } else if (col == 2) {
                                    cb_text = getCBDist2Selection();
                                    System.out.println("cb_text Dist2: " + cb_text);

                                    if (!lb_ODist2.getText().equals(cb_text)) {
                                          sub = lb_NDist2.getText();
                                          sub = sub.substring(sub.indexOf(": ") + 2);
                                          MCUpdateDists(list_D.get(0), "Dist2", sub);
                                    } else {
                                          st.startLBStatus(lb_Status, cl[2], inter, 5000);
                                    }
                              } else if (col == 3) {
                                    cb_text = getCBTag1Selection();
                                    System.out.println("cb_text Tag1: " + cb_text);

                                    if (!lb_OTag1.getText().equals(cb_text)) {
                                          sub = lb_NTag1.getText();
                                          sub = sub.substring(sub.indexOf(": ") + 2);
                                          MCUpdateDists(list_D.get(0), "Tag1", sub);
                                    } else {
                                          st.startLBStatus(lb_Status, cl[2], inter, 5000);
                                    }
                              } else if (col == 4) {
                                    cb_text = "Tabl: " + cb_TB.getSelectedItem();
                                    System.out.println("cb_text Tabl: " + cb_text);

                                    if (!lb_OTabl.getText().equals(cb_text)) {
                                          sub = lb_NTabl.getText();
                                          sub = sub.substring(sub.indexOf(": ") + 2);
                                          MCUpdateDists(list_D.get(0), "Tabl", sub);
                                    } else {
                                          st.startLBStatus(lb_Status, cl[2], inter, 5000);
                                    }
                              }
                        }
                  } else {
                        System.out.println("##################ERROR");
                  }
                  //++++++++++++++++++++++++++++++++++++++++++
                  btn_DControl();
                  btn_PControl();
                  //+++++++++++++++++++++++++++++++++++++++++++
                  //System.out.println("Value is " + value);
                  //2. ONLY CB
                  /*if(jcb[col - 2].getSelectedItem().equals(list_TP.get(col - 1))){  
                        }else {
                              MCChange1Column(true, col, 
                                      jtf[col - 2].getText(), 
                                      jcb[col - 2].getSelectedItem().toString(), 
                                      jcbx[col - 2].isSelected());
                        }*/
                  //3. ONLY CBX
                  //4. NAME & CB
                  //5. NAME & CBX
                  //6. CB & CBX
                  //7 NAME, CB & CBX
            }
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private javax.swing.JButton btn_change;
      private javax.swing.JComboBox<String> cb_D1;
      private javax.swing.JComboBox<String> cb_D1_1;
      private javax.swing.JComboBox<String> cb_D1_2;
      private javax.swing.JComboBox<String> cb_D1_3;
      private javax.swing.JComboBox<String> cb_D1_4;
      private javax.swing.JComboBox<String> cb_D2;
      private javax.swing.JComboBox<String> cb_D2_1;
      private javax.swing.JComboBox<String> cb_D2_2;
      private javax.swing.JComboBox<String> cb_T1;
      private javax.swing.JComboBox<String> cb_T1_1;
      private javax.swing.JComboBox<String> cb_T1_2;
      private javax.swing.JComboBox<String> cb_T1_3;
      private javax.swing.JComboBox<String> cb_T1_4;
      private javax.swing.JComboBox<String> cb_TB;
      private javax.swing.JComboBox<String> cb_c2;
      private javax.swing.JComboBox<String> cb_c3;
      private javax.swing.JComboBox<String> cb_c4;
      private javax.swing.JComboBox<String> cb_c5;
      private javax.swing.JComboBox<String> cb_c6;
      private javax.swing.JComboBox<String> cb_nc;
      private javax.swing.JCheckBox cbx_c2;
      private javax.swing.JCheckBox cbx_c3;
      private javax.swing.JCheckBox cbx_c4;
      private javax.swing.JCheckBox cbx_c5;
      private javax.swing.JCheckBox cbx_c6;
      private javax.swing.JCheckBox cbx_nc;
      private javax.swing.JLabel jLabel1;
      private javax.swing.JSeparator jSeparator1;
      private javax.swing.JSeparator jSeparator2;
      private javax.swing.JSeparator jSeparator3;
      private javax.swing.JSeparator jSeparator4;
      private javax.swing.JSeparator jSeparator5;
      private javax.swing.JLabel lb_Dist2;
      private javax.swing.JLabel lb_Dist3;
      private javax.swing.JLabel lb_NDist1;
      private javax.swing.JLabel lb_NDist2;
      private javax.swing.JLabel lb_NTabl;
      private javax.swing.JLabel lb_NTag1;
      private javax.swing.JLabel lb_NTag2;
      private javax.swing.JLabel lb_ODist1;
      private javax.swing.JLabel lb_ODist2;
      private javax.swing.JLabel lb_OTabl;
      private javax.swing.JLabel lb_OTag1;
      private javax.swing.JLabel lb_OTag2;
      private javax.swing.JLabel lb_Tabl;
      private javax.swing.JLabel lb_Tag1;
      private javax.swing.JLabel lb_Tag2;
      private javax.swing.JLabel lb_c2;
      private javax.swing.JLabel lb_c3;
      private javax.swing.JLabel lb_c4;
      private javax.swing.JLabel lb_c5;
      private javax.swing.JLabel lb_c6;
      private javax.swing.JLabel lb_name;
      private javax.swing.JLabel lb_name1;
      private javax.swing.JLabel lb_name2;
      private javax.swing.JLabel lb_name3;
      private javax.swing.JLabel lb_name4;
      private javax.swing.JLabel lb_nc;
      private javax.swing.JLabel lb_new;
      private javax.swing.JLabel lb_old;
      private javax.swing.JPanel panel1;
      private javax.swing.JPanel panel2;
      private javax.swing.JScrollPane sc_panel1;
      private javax.swing.JTextField tf_c2;
      private javax.swing.JTextField tf_c3;
      private javax.swing.JTextField tf_c4;
      private javax.swing.JTextField tf_c5;
      private javax.swing.JTextField tf_c6;
      private javax.swing.JTextField tf_name;
      private javax.swing.JTextField tf_nc;
      // End of variables declaration//GEN-END:variables
}
