/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Second;

import First.VF;
import MC.DT;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Christopher
 */
public class View_Create extends javax.swing.JFrame {

      Connection con;

      ArrayList<String> list_Table = new ArrayList<String>();
      ArrayList<String> list_Dist1 = new ArrayList<String>();
      ArrayList<String> list_Dist2 = new ArrayList<String>();
      ArrayList<String> list_Tabl = new ArrayList<String>();
      ArrayList<String> list_Tag1 = new ArrayList<String>();
      ArrayList<String> list_Tag2 = new ArrayList<String>();

      int count = 0;
      int i;

      VF vf = new VF();
      //Data dt = new Data("View_Create");

      private void listConvert(ArrayList<String> list_then, ArrayList<String> list_now) {
            for (int a = 0; a < list_then.size(); a++) {
                  list_now.add(list_then.get(a));
            }
      }

      private void MCCreateTable(String tablename, String col) {
            try {
                  con = DriverManager.getConnection(
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
      }

      private void MCCreateTable(String tablename, String col1, String col2) {
            try {
                  con = DriverManager.getConnection(
                          "jdbc:mysql://localhost:3306/TIME_STAM?allowPublicKeyRetrieval=true&useSSL=false",
                          "root",
                          "ccfmps00112");

                  PreparedStatement stmt = con.prepareStatement("CREATE TABLE " + tablename
                          + " (id INT NOT NULL AUTO_INCREMENT, "
                          + col1 + " VARCHAR(150) NOT NULL, "
                          + col2 + " VARCHAR(150) NOT NULL, "
                          + "PRIMARY KEY(id))ENGINE=INNODB");

                  i = stmt.executeUpdate();
                  if (i > 0) {
                        lbStatus(true, "MCCreateTable3 Done!");
                  }

            } catch (SQLException ex) {
                  Logger.getLogger(VF.class.getName()).log(Level.SEVERE, null, ex);
                  
                  lbStatus(false, ex.toString());
            }
      }

      private void MCCreateTable(String tablename, String col1, String col2, String col3) {
            try {
                  con = DriverManager.getConnection(
                          "jdbc:mysql://localhost:3306/TIME_STAM?allowPublicKeyRetrieval=true&useSSL=false",
                          "root",
                          "ccfmps00112");

                  PreparedStatement stmt = con.prepareStatement("CREATE TABLE " + tablename
                          + " (id INT NOT NULL AUTO_INCREMENT, "
                          + col1 + " VARCHAR(150) NOT NULL, "
                          + col2 + " VARCHAR(150) NOT NULL, "
                          + col3 + " VARCHAR(150) NOT NULL, "
                          + "PRIMARY KEY(id))ENGINE=INNODB");

                  i = stmt.executeUpdate();
                  if (i > 0) {
                        lbStatus(true, "MCCreateTable4 Done!");
                  }

            } catch (SQLException ex) {
                  Logger.getLogger(VF.class.getName()).log(Level.SEVERE, null, ex);
                  
                  lbStatus(false, ex.toString());
            }
      }

      private void MCCreateTable(String tablename, String col1, String col2, String col3, String col4) {
            try {
                  con = DriverManager.getConnection(
                          "jdbc:mysql://localhost:3306/TIME_STAM?allowPublicKeyRetrieval=true&useSSL=false",
                          "root",
                          "ccfmps00112");
                  ////ONLY VARCHAR SHOULD BE AVAIBLE IF THERE IS ONLY ON COLUMN

                  PreparedStatement stmt = con.prepareStatement("CREATE TABLE " + tablename
                          + " (id INT NOT NULL AUTO_INCREMENT, "
                          + col1 + " VARCHAR(150) NOT NULL, "
                          + col2 + " VARCHAR(150) NOT NULL, "
                          + col3 + " VARCHAR(150) NOT NULL, "
                          + col4 + " VARCHAR(150) NOT NULL, "
                          + "PRIMARY KEY(id))ENGINE=INNODB");

                  i = stmt.executeUpdate();
                  if (i > 0) {
                        lbStatus(true, "MCCreateTable5 Done!");
                  }

            } catch (SQLException ex) {
                  Logger.getLogger(VF.class.getName()).log(Level.SEVERE, null, ex);
                  
                  lbStatus(false, ex.toString());
            }
      }

      private void MCCreateTable(String tablename, String col2, String col3, String col4, String col5,
              String col6) {
            try {
                  con = DriverManager.getConnection(
                          "jdbc:mysql://localhost:3306/TIME_STAM?allowPublicKeyRetrieval=true&useSSL=false",
                          "root",
                          "ccfmps00112");
                  ////ONLY VARCHAR SHOULD BE AVAIBLE IF THERE IS ONLY ON COLUMN

                  PreparedStatement stmt = con.prepareStatement("CREATE TABLE " + tablename
                          + " (id INT NOT NULL AUTO_INCREMENT, "
                          + col2 + " VARCHAR(150) NOT NULL, "
                          + col3 + " VARCHAR(150) NOT NULL, "
                          + col4 + " VARCHAR(150) NOT NULL, "
                          + col5 + " VARCHAR(150) NOT NULL, "
                          + col6 + " VARCHAR(150) NOT NULL, "
                          + "PRIMARY KEY(id))ENGINE=INNODB");
                  
                  System.out.println("CREATE TABLE " + tablename
                          + " (id INT NOT NULL AUTO_INCREMENT, "
                          + col2 + " VARCHAR(150) NOT NULL, "
                          + col3 + " VARCHAR(150) NOT NULL, "
                          + col4 + " VARCHAR(150) NOT NULL, "
                          + col5 + " VARCHAR(150) NOT NULL, "
                          + col6 + " VARCHAR(150) NOT NULL, "
                          + "PRIMARY KEY(id))ENGINE=INNODB");

                  i = stmt.executeUpdate();
                  if (i > 0) {
                        lbStatus(true, "MCCreateTable6 Done!");
                  }

            } catch (SQLException ex) {
                  Logger.getLogger(VF.class.getName()).log(Level.SEVERE, null, ex);
                  
                  lbStatus(false, ex.toString());
            }
      }

      private void MCInsertTable(ArrayList<String> list1, String d1,
              ArrayList<String> list2, String d2,
              ArrayList<String> list3, String d3,
              ArrayList<String> list4, String d4,
              ArrayList<String> list5, String d5,
              ArrayList<String> list6, String d6) {
            try {
                  con = DriverManager.getConnection(
                          "jdbc:mysql://localhost:3306/TIME_STAM?allowPublicKeyRetrieval=true&useSSL=false",
                          "root",
                          "ccfmps00112");

                  PreparedStatement stmt = con.prepareStatement("INSERT INTO Table_Names "
                          + "(Table_Names, Dist1, Dist2, Tabl, Tag1, Tag2) VALUES (?,?,?,?,?,?)");
                  stmt.setString(1, d1);
                  stmt.setString(2, d2);
                  stmt.setString(3, d3);
                  stmt.setString(4, d4);
                  stmt.setString(5, d5);
                  stmt.setString(6, d6);
                  int i = stmt.executeUpdate();
                  if (i > 0) {
                        list1.add(d1);
                        list2.add(d2);
                        list3.add(d3);
                        list4.add(d4);
                        list5.add(d5);
                        list6.add(d6);
                        
                        lbStatus(true, "MCInsertTable_Names Done!");
                  }

            } catch (SQLException ex) {
                  Logger.getLogger(VF.class.getName()).log(Level.SEVERE, null, ex);
                  
                  lbStatus(false, ex.toString());
            }
      }

      private void tableExist(JTextField tf) {
            int z = 0;
            if (tf.getText().equals("")) {
                  z = 1;
            } else {
                  for (int a = 0; a < list_Table.size(); a++) {
                        if (list_Table.get(a).equalsIgnoreCase(tf.getText())) {//!!!!!!!!!!!!!!!!!!!
                              z = 1;
                        } else {
                              if (z == 1) {
                              } else {
                                    z = 0;
                              }
                        }
                  }
            }
            if (z >= 1) {
                  tf.setForeground(Color.RED);
                  btn_Create.setEnabled(false);
            } else if (z == 0) {
                  tf.setForeground(Color.WHITE);
                  btn_Create.setEnabled(true);
            }
      }

      private void bandWords(JTextField tf) {
            byte z = 0;
            if (tf.getText().equals("")) {
                  z = 1;
            } else {
                  for (int a = 0; a < DT.getBandW().size(); a++) {
                        if (tf.getText().contains(DT.getBandW().get(a))) {
                              z = 1;
                        } else {
                              if (z == 1) {
                              } else {
                                    z = 0;
                              }
                        }
                  }
            }

            if (z == 1) {
                  tf.setForeground(Color.RED);
                  btn_Create.setEnabled(false);
            } else if (z == 0) {
                  tf.setForeground(Color.WHITE);
                  btn_Create.setEnabled(true);
            }
      }

      private void setDist_to_tag(JLabel ref, JLabel D1, JLabel D2, JLabel Tb, JLabel T1, JLabel T2) {
            D1.setLocation(D1.getX(), ref.getY() + 40);
            D2.setLocation(D2.getX(), ref.getY() + 40);
            Tb.setLocation(Tb.getX(), ref.getY() + 40);
            T1.setLocation(T1.getX(), ref.getY() + 40);
            T2.setLocation(T2.getX(), ref.getY() + 40);
      }

      private void setDist_to_tag(JTextField ref, JTextField D1, JTextField D2, JTextField TB, JTextField T1, JTextField T2) {
            D1.setLocation(D1.getX(), ref.getY() + 40);
            D2.setLocation(D2.getX(), ref.getY() + 40);
            TB.setLocation(TB.getX(), ref.getY() + 40);
            T1.setLocation(T1.getX(), ref.getY() + 40);
            T2.setLocation(T2.getX(), ref.getY() + 40);
      }
      
      public void lbStatus(boolean v, String ex) {
            Thread t1 = new Thread(new Runnable() {
                  public void run() {
                        if (v == true) {
                              lb_Status.setForeground(Color.GREEN);
                              lb_Status.setText(ex);
                        }else{
                              lb_Status.setForeground(Color.RED);
                              lb_Status.setText(ex);
                        }
                        try {
                              Thread.sleep(4000);
                        } catch (InterruptedException ex1) {
                              Logger.getLogger(VF.class.getName()).log(Level.SEVERE, null, ex1);
                        }

                        lb_Status.setForeground(Color.WHITE);
                        lb_Status.setText("Waiting for action...");
                  }
            });
            
            t1.start();
      }

      public View_Create() {

      }

      public View_Create(ArrayList<String> tables, ArrayList<String> dists1,
              ArrayList<String> dists2, ArrayList<String> tabls, ArrayList<String> tags1,
              ArrayList<String> tags2) {
            //list_Table = tables;
            System.out.println("Constructor tables size: " + tables.size());
            for (int v = 0; v < tables.size(); v++) {
                  list_Table.add(tables.get(v));
                  //System.out.println(v + ": " + tables.get(v));
            }
            System.out.println("Constructor dists1 size: " + dists1.size());
            for (int v = 0; v < dists1.size(); v++) {
                  list_Dist1.add(dists1.get(v));
            }
            System.out.println("Constructor dists2 size: " + dists2.size());
            for (int v = 0; v < dists2.size(); v++) {
                  list_Dist2.add(dists2.get(v));
            }
            System.out.println("Constructor tabls size: " + tabls.size());
            for (int v = 0; v < tabls.size(); v++) {
                  list_Tabl.add(tabls.get(v));
            }
            System.out.println("Constructor tags1 size: " + tags1.size());
            for (int v = 0; v < tags1.size(); v++) {
                  list_Tag1.add(tags1.get(v));
            }
            System.out.println("Constructor tags2 size: " + tags2.size());
            for (int v = 0; v < tags2.size(); v++) {
                  list_Tag2.add(tags2.get(v));
            }

            initComponents();
            setSize(568, 239);
            jPanel1.setSize(jPanel1.getWidth() + 40, 189);
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            setDist_to_tag(lb_c2, lb_Dist1, lb_Dist2, lb_Tabl, lb_Tag1, lb_Tag2);
            setDist_to_tag(tf_c2, tf_Dist1, tf_Dist2, tf_Tabl, tf_Tag1, tf_Tag2);

            lb_Status.setLocation(lb_Status.getX(), lb_Dist1.getY() + 40);

            btn_minus.setVisible(false);
            //btn_Create.setForeground(Color.GRAY);
            //btn_Create.setEnabled(false);
            lb_c3.setVisible(false);
            tf_c3.setVisible(false);
            lb_c4.setVisible(false);
            tf_c4.setVisible(false);
            lb_c5.setVisible(false);
            tf_c5.setVisible(false);
            lb_c6.setVisible(false);
            tf_c6.setVisible(false);

            System.out.println("list_Table size: " + list_Table.size());
            for (int a = 0; a < list_Table.size(); a++) {
                  System.out.println(a + ": " + list_Table.get(a));
            }
      }

      /**
       * This method is called from within the constructor to initialize the
       * form. WARNING: Do NOT modify this code. The content of this method is
       * always regenerated by the Form Editor.
       */
      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            jPanel1 = new javax.swing.JPanel();
            lb_Name = new javax.swing.JLabel();
            tf_Name = new javax.swing.JTextField();
            lb_Status = new javax.swing.JLabel();
            btn_Create = new javax.swing.JButton();
            lb_c2 = new javax.swing.JLabel();
            tf_c2 = new javax.swing.JTextField();
            btn_plus = new javax.swing.JButton();
            lb_c3 = new javax.swing.JLabel();
            tf_c3 = new javax.swing.JTextField();
            tf_c4 = new javax.swing.JTextField();
            lb_c4 = new javax.swing.JLabel();
            tf_c5 = new javax.swing.JTextField();
            lb_c5 = new javax.swing.JLabel();
            btn_minus = new javax.swing.JButton();
            lb_Dist1 = new javax.swing.JLabel();
            tf_Dist1 = new javax.swing.JTextField();
            lb_Dist2 = new javax.swing.JLabel();
            tf_Dist2 = new javax.swing.JTextField();
            lb_Tabl = new javax.swing.JLabel();
            tf_Tabl = new javax.swing.JTextField();
            lb_Tag1 = new javax.swing.JLabel();
            tf_Tag1 = new javax.swing.JTextField();
            tf_Tag2 = new javax.swing.JTextField();
            lb_Tag2 = new javax.swing.JLabel();
            tf_c6 = new javax.swing.JTextField();
            lb_c6 = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setAlwaysOnTop(true);
            setMinimumSize(new java.awt.Dimension(398, 189));
            setResizable(false);
            getContentPane().setLayout(null);

            jPanel1.setBackground(new java.awt.Color(0, 0, 0));
            jPanel1.setLayout(null);

            lb_Name.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            lb_Name.setForeground(new java.awt.Color(255, 255, 255));
            lb_Name.setText("Name");
            jPanel1.add(lb_Name);
            lb_Name.setBounds(10, 20, 90, 24);

            tf_Name.setBackground(new java.awt.Color(51, 51, 51));
            tf_Name.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
            tf_Name.setForeground(new java.awt.Color(255, 255, 255));
            tf_Name.addFocusListener(new java.awt.event.FocusAdapter() {
                  public void focusGained(java.awt.event.FocusEvent evt) {
                        tf_NameFocusGained(evt);
                  }
            });
            tf_Name.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyReleased(java.awt.event.KeyEvent evt) {
                        tf_NameKeyReleased(evt);
                  }
            });
            jPanel1.add(tf_Name);
            tf_Name.setBounds(100, 20, 160, 27);

            lb_Status.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            lb_Status.setForeground(new java.awt.Color(255, 255, 255));
            lb_Status.setText("Status");
            lb_Status.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            jPanel1.add(lb_Status);
            lb_Status.setBounds(10, 310, 500, 23);

            btn_Create.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            btn_Create.setText("Create");
            btn_Create.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_CreateActionPerformed(evt);
                  }
            });
            jPanel1.add(btn_Create);
            btn_Create.setBounds(270, 20, 74, 30);

            lb_c2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            lb_c2.setForeground(new java.awt.Color(255, 255, 255));
            lb_c2.setText("Column 2");
            jPanel1.add(lb_c2);
            lb_c2.setBounds(10, 60, 90, 24);

            tf_c2.setBackground(new java.awt.Color(51, 51, 51));
            tf_c2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
            tf_c2.setForeground(new java.awt.Color(255, 255, 255));
            tf_c2.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyReleased(java.awt.event.KeyEvent evt) {
                        tf_c2KeyReleased(evt);
                  }
            });
            jPanel1.add(tf_c2);
            tf_c2.setBounds(100, 60, 160, 28);

            btn_plus.setText("+");
            btn_plus.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_plusActionPerformed(evt);
                  }
            });
            jPanel1.add(btn_plus);
            btn_plus.setBounds(270, 60, 40, 30);

            lb_c3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            lb_c3.setForeground(new java.awt.Color(255, 255, 255));
            lb_c3.setText("Column 3");
            jPanel1.add(lb_c3);
            lb_c3.setBounds(10, 100, 90, 24);

            tf_c3.setBackground(new java.awt.Color(51, 51, 51));
            tf_c3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
            tf_c3.setForeground(new java.awt.Color(255, 255, 255));
            tf_c3.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyReleased(java.awt.event.KeyEvent evt) {
                        tf_c3KeyReleased(evt);
                  }
            });
            jPanel1.add(tf_c3);
            tf_c3.setBounds(100, 100, 160, 27);

            tf_c4.setBackground(new java.awt.Color(51, 51, 51));
            tf_c4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
            tf_c4.setForeground(new java.awt.Color(255, 255, 255));
            tf_c4.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyReleased(java.awt.event.KeyEvent evt) {
                        tf_c4KeyReleased(evt);
                  }
            });
            jPanel1.add(tf_c4);
            tf_c4.setBounds(100, 140, 160, 27);

            lb_c4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            lb_c4.setForeground(new java.awt.Color(255, 255, 255));
            lb_c4.setText("Column 4");
            jPanel1.add(lb_c4);
            lb_c4.setBounds(10, 140, 90, 24);

            tf_c5.setBackground(new java.awt.Color(51, 51, 51));
            tf_c5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
            tf_c5.setForeground(new java.awt.Color(255, 255, 255));
            tf_c5.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyReleased(java.awt.event.KeyEvent evt) {
                        tf_c5KeyReleased(evt);
                  }
            });
            jPanel1.add(tf_c5);
            tf_c5.setBounds(100, 180, 160, 27);

            lb_c5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            lb_c5.setForeground(new java.awt.Color(255, 255, 255));
            lb_c5.setText("Column 5");
            jPanel1.add(lb_c5);
            lb_c5.setBounds(10, 180, 90, 24);

            btn_minus.setText("-");
            btn_minus.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_minusActionPerformed(evt);
                  }
            });
            jPanel1.add(btn_minus);
            btn_minus.setBounds(310, 100, 40, 30);

            lb_Dist1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            lb_Dist1.setForeground(new java.awt.Color(255, 255, 255));
            lb_Dist1.setText("Dist1");
            jPanel1.add(lb_Dist1);
            lb_Dist1.setBounds(10, 270, 40, 19);

            tf_Dist1.setBackground(new java.awt.Color(51, 51, 51));
            tf_Dist1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
            tf_Dist1.setForeground(new java.awt.Color(255, 255, 255));
            tf_Dist1.setText("NONE");
            tf_Dist1.addFocusListener(new java.awt.event.FocusAdapter() {
                  public void focusGained(java.awt.event.FocusEvent evt) {
                        tf_Dist1FocusGained(evt);
                  }
                  public void focusLost(java.awt.event.FocusEvent evt) {
                        tf_Dist1FocusLost(evt);
                  }
            });
            jPanel1.add(tf_Dist1);
            tf_Dist1.setBounds(50, 270, 50, 27);

            lb_Dist2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            lb_Dist2.setForeground(new java.awt.Color(255, 255, 255));
            lb_Dist2.setText("Dist2");
            jPanel1.add(lb_Dist2);
            lb_Dist2.setBounds(110, 270, 40, 19);

            tf_Dist2.setBackground(new java.awt.Color(51, 51, 51));
            tf_Dist2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
            tf_Dist2.setForeground(new java.awt.Color(255, 255, 255));
            tf_Dist2.setText("NONE");
            tf_Dist2.addFocusListener(new java.awt.event.FocusAdapter() {
                  public void focusGained(java.awt.event.FocusEvent evt) {
                        tf_Dist2FocusGained(evt);
                  }
                  public void focusLost(java.awt.event.FocusEvent evt) {
                        tf_Dist2FocusLost(evt);
                  }
            });
            jPanel1.add(tf_Dist2);
            tf_Dist2.setBounds(150, 270, 50, 27);

            lb_Tabl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            lb_Tabl.setForeground(new java.awt.Color(255, 255, 255));
            lb_Tabl.setText("Tabl");
            jPanel1.add(lb_Tabl);
            lb_Tabl.setBounds(210, 270, 40, 19);

            tf_Tabl.setBackground(new java.awt.Color(51, 51, 51));
            tf_Tabl.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
            tf_Tabl.setForeground(new java.awt.Color(255, 255, 255));
            tf_Tabl.setText("NONE");
            tf_Tabl.addFocusListener(new java.awt.event.FocusAdapter() {
                  public void focusGained(java.awt.event.FocusEvent evt) {
                        tf_TablFocusGained(evt);
                  }
                  public void focusLost(java.awt.event.FocusEvent evt) {
                        tf_TablFocusLost(evt);
                  }
            });
            jPanel1.add(tf_Tabl);
            tf_Tabl.setBounds(250, 270, 50, 27);

            lb_Tag1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            lb_Tag1.setForeground(new java.awt.Color(255, 255, 255));
            lb_Tag1.setText("Tag1");
            jPanel1.add(lb_Tag1);
            lb_Tag1.setBounds(310, 270, 40, 19);

            tf_Tag1.setBackground(new java.awt.Color(51, 51, 51));
            tf_Tag1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
            tf_Tag1.setForeground(new java.awt.Color(255, 255, 255));
            tf_Tag1.setText("NONE");
            tf_Tag1.addFocusListener(new java.awt.event.FocusAdapter() {
                  public void focusGained(java.awt.event.FocusEvent evt) {
                        tf_Tag1FocusGained(evt);
                  }
                  public void focusLost(java.awt.event.FocusEvent evt) {
                        tf_Tag1FocusLost(evt);
                  }
            });
            jPanel1.add(tf_Tag1);
            tf_Tag1.setBounds(350, 270, 50, 27);

            tf_Tag2.setBackground(new java.awt.Color(51, 51, 51));
            tf_Tag2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
            tf_Tag2.setForeground(new java.awt.Color(255, 255, 255));
            tf_Tag2.setText("NONE");
            tf_Tag2.addFocusListener(new java.awt.event.FocusAdapter() {
                  public void focusGained(java.awt.event.FocusEvent evt) {
                        tf_Tag2FocusGained(evt);
                  }
                  public void focusLost(java.awt.event.FocusEvent evt) {
                        tf_Tag2FocusLost(evt);
                  }
            });
            jPanel1.add(tf_Tag2);
            tf_Tag2.setBounds(450, 270, 50, 27);

            lb_Tag2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            lb_Tag2.setForeground(new java.awt.Color(255, 255, 255));
            lb_Tag2.setText("Tag2");
            jPanel1.add(lb_Tag2);
            lb_Tag2.setBounds(410, 270, 40, 19);

            tf_c6.setBackground(new java.awt.Color(51, 51, 51));
            tf_c6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
            tf_c6.setForeground(new java.awt.Color(255, 255, 255));
            tf_c6.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyReleased(java.awt.event.KeyEvent evt) {
                        tf_c6KeyReleased(evt);
                  }
            });
            jPanel1.add(tf_c6);
            tf_c6.setBounds(100, 220, 160, 27);

            lb_c6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            lb_c6.setForeground(new java.awt.Color(255, 255, 255));
            lb_c6.setText("Column 6");
            jPanel1.add(lb_c6);
            lb_c6.setBounds(10, 220, 90, 24);

            getContentPane().add(jPanel1);
            jPanel1.setBounds(6, 6, 520, 350);

            pack();
      }// </editor-fold>//GEN-END:initComponents

      private void btn_CreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CreateActionPerformed
            //System.out.println("JFRAME Size: " + getSize());
            //jPanel1.setSize(jPanel1.getWidth(), jPanel1.getHeight()-5);
            //System.out.println("JPanel Height: " + jPanel1.getHeight());
            String dist1 = tf_Dist1.getText();
            String dist2 = tf_Dist2.getText();
            String tabl = tf_Tabl.getText();
            String tag1 = tf_Tag1.getText();
            String tag2 = tf_Tag2.getText();

            String tableN = tf_Name.getText();
            if (tableN.contains(" ")) {
                  tableN = tableN.replaceAll(" ", "_");
            }

            if (count == 0) {
                  System.out.println(" 2 COLS");
                  MCCreateTable(tableN, tf_c2.getText());
            } else if (count == 1) {
                  System.out.println(" 3 COLS");
                  MCCreateTable(tableN, tf_c2.getText(), tf_c3.getText());
            } else if (count == 2) {//4
                  System.out.println(" 4 COLS");
                  MCCreateTable(tableN, tf_c2.getText(), tf_c3.getText(), tf_c4.getText());
            } else if (count == 3) {
                  System.out.println(" 5 COLS");
                  MCCreateTable(tableN, tf_c2.getText(), tf_c3.getText(), tf_c4.getText(),
                          tf_c5.getText());
            } else if (count == 4) {
                  System.out.println(" 6 COLS");
                  MCCreateTable(tableN, tf_c2.getText(), tf_c3.getText(), tf_c4.getText(),
                          tf_c5.getText(), tf_c6.getText());
            }
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if (i > 0) {
            } else {
                  MCInsertTable(list_Table, tf_Name.getText(),
                          list_Dist1, dist1,
                          list_Dist2, dist2,
                          list_Tabl, tabl,
                          list_Tag1, tag1,
                          list_Tag2, tag2);

                  System.out.println("List_T Size: " + list_Table.size());
                  for (int a = 0; a < list_Table.size(); a++) {
                        System.out.println(a + ": " + list_Table.get(a) + " - "
                                + list_Dist1.get(a) + " - " + list_Dist2.get(a) + " - "
                                + list_Tabl.get(a) + " - " + list_Tag1.get(a) + " - "
                                + list_Tag2.get(a));
                  }
                  //--------------------------HERE
                  //vf.MCSelectTables(list_Table);
                  //vf.setList(list_Table, list_Dist1, list_Dist2, list_Tabl, list_Tag1, list_Tag2);
            }
      }//GEN-LAST:event_btn_CreateActionPerformed

      private void tf_NameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_NameKeyReleased
            tableExist(tf_Name);
            bandWords(tf_Name);
      }//GEN-LAST:event_tf_NameKeyReleased

      private void btn_plusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_plusActionPerformed
            if (count <= 3) {
                  setSize(getWidth(), getHeight() + 40);
                  jPanel1.setSize(jPanel1.getWidth(), jPanel1.getHeight() + 40);
                  lb_Status.setLocation(lb_Status.getX(), lb_Status.getY() + 40);

            }
            if (count <= 2) {
                  btn_plus.setLocation(btn_plus.getX(), btn_plus.getY() + 40);
            }
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if (count == 0) {
                  btn_minus.setVisible(true);

                  setDist_to_tag(lb_c3, lb_Dist1, lb_Dist2, lb_Tabl, lb_Tag1, lb_Tag2);
                  setDist_to_tag(tf_c3, tf_Dist1, tf_Dist2, tf_Tabl, tf_Tag1, tf_Tag2);

                  lb_c3.setVisible(true);
                  tf_c3.setVisible(true);

                  count++;
                  System.out.println("COUNT: " + count);
            } else if (count == 1) {
                  btn_minus.setLocation(btn_minus.getX(), btn_minus.getY() + 40);

                  setDist_to_tag(lb_c4, lb_Dist1, lb_Dist2, lb_Tabl, lb_Tag1, lb_Tag2);
                  setDist_to_tag(tf_c4, tf_Dist1, tf_Dist2, tf_Tabl, tf_Tag1, tf_Tag2);

                  lb_c4.setVisible(true);
                  tf_c4.setVisible(true);
                  count++;
                  System.out.println("COUNT: " + count);
            } else if (count == 2) {
                  btn_minus.setLocation(btn_minus.getX(), btn_minus.getY() + 40);

                  setDist_to_tag(lb_c5, lb_Dist1, lb_Dist2, lb_Tabl, lb_Tag1, lb_Tag2);
                  setDist_to_tag(tf_c5, tf_Dist1, tf_Dist2, tf_Tabl, tf_Tag1, tf_Tag2);

                  lb_c5.setVisible(true);
                  tf_c5.setVisible(true);

                  count++;
                  System.out.println("COUNT: " + count);
            } else if (count == 3) {
                  btn_minus.setLocation(btn_minus.getX(), btn_minus.getY() + 40);

                  setDist_to_tag(lb_c6, lb_Dist1, lb_Dist2, lb_Tabl, lb_Tag1, lb_Tag2);
                  setDist_to_tag(tf_c6, tf_Dist1, tf_Dist2, tf_Tabl, tf_Tag1, tf_Tag2);

                  lb_c6.setVisible(true);
                  tf_c6.setVisible(true);

                  btn_plus.setVisible(false);

                  count++;
            }
      }//GEN-LAST:event_btn_plusActionPerformed

      private void btn_minusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_minusActionPerformed
            if (count >= 1 && count <= 4) {//!!!!!!!!!!!!!!!!!!
                  setSize(getWidth(), getHeight() - 40);
                  jPanel1.setSize(jPanel1.getWidth(), jPanel1.getHeight() - 40);
                  lb_Status.setLocation(lb_Status.getX(), lb_Status.getY() - 40);
            }
            if (count >= 2 && count <= 4) {//!!!!!!!!!!!!!!!!!!
                  btn_minus.setLocation(btn_minus.getX(), btn_minus.getY() - 40);
            }
            if (count >= 1 && count <= 3) {
                  btn_plus.setLocation(btn_plus.getX(), btn_plus.getY() - 40);
            }//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if (count == 1) {
                  btn_minus.setVisible(false);

                  lb_c3.setVisible(false);
                  tf_c3.setVisible(false);

                  setDist_to_tag(lb_c2, lb_Dist1, lb_Dist2, lb_Tabl, lb_Tag1, lb_Tag2);
                  setDist_to_tag(tf_c2, tf_Dist1, tf_Dist2, tf_Tabl, tf_Tag1, tf_Tag2);

                  count--;
                  System.out.println("COUNT: " + count);
            } else if (count == 2) {
                  lb_c4.setVisible(false);
                  tf_c4.setVisible(false);

                  setDist_to_tag(lb_c3, lb_Dist1, lb_Dist2, lb_Tabl, lb_Tag1, lb_Tag2);
                  setDist_to_tag(tf_c3, tf_Dist1, tf_Dist2, tf_Tabl, tf_Tag1, tf_Tag2);

                  count--;
                  System.out.println("COUNT: " + count);
            } else if (count == 3) {
                  lb_c5.setVisible(false);
                  tf_c5.setVisible(false);

                  setDist_to_tag(lb_c4, lb_Dist1, lb_Dist2, lb_Tabl, lb_Tag1, lb_Tag2);
                  setDist_to_tag(tf_c4, tf_Dist1, tf_Dist2, tf_Tabl, tf_Tag1, tf_Tag2);

                  count--;
                  System.out.println("COUNT: " + count);
            } else if (count == 4) {
                  btn_plus.setVisible(true);

                  lb_c6.setVisible(false);
                  tf_c6.setVisible(false);

                  setDist_to_tag(lb_c5, lb_Dist1, lb_Dist2, lb_Tabl, lb_Tag1, lb_Tag2);
                  setDist_to_tag(tf_c5, tf_Dist1, tf_Dist2, tf_Tabl, tf_Tag1, tf_Tag2);

                  count--;
                  System.out.println("COUNT: " + count);
            }
      }//GEN-LAST:event_btn_minusActionPerformed

      private void tf_NameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_NameFocusGained
            //setSize(getWidth() + 2, getHeight());
            //System.out.println("Size: Value: "+ getSize());
      }//GEN-LAST:event_tf_NameFocusGained

      private void tf_Dist1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_Dist1FocusGained
            //System.out.println("IN FOCUS");
            if (tf_Dist1.getText().equals("NONE")) {
                  //System.out.println("EQUALS NONE");
                  tf_Dist1.setText("");
            }
      }//GEN-LAST:event_tf_Dist1FocusGained

      private void tf_Dist1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_Dist1FocusLost
            //System.out.println("NOT IN FOCUS");
            if (tf_Dist1.getText().equals("")) {
                  //System.out.println("EQUALS NOTHING");
                  tf_Dist1.setText("NONE");
            }
      }//GEN-LAST:event_tf_Dist1FocusLost

      private void tf_Dist2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_Dist2FocusGained
            if (tf_Dist2.getText().equals("NONE")) {
                  tf_Dist2.setText("");
            }
      }//GEN-LAST:event_tf_Dist2FocusGained

      private void tf_Dist2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_Dist2FocusLost
            if (tf_Dist2.getText().equals("")) {
                  tf_Dist2.setText("NONE");
            }
      }//GEN-LAST:event_tf_Dist2FocusLost

      private void tf_TablFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_TablFocusGained
            if (tf_Tabl.getText().equals("NONE")) {
                  tf_Tabl.setText("");
            }
      }//GEN-LAST:event_tf_TablFocusGained

      private void tf_TablFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_TablFocusLost
            if (tf_Tabl.getText().equals("")) {
                  tf_Tabl.setText("NONE");
            }
      }//GEN-LAST:event_tf_TablFocusLost

      private void tf_Tag1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_Tag1FocusGained
            if (tf_Tag1.getText().equals("NONE")) {
                  tf_Tag1.setText("");
            }
      }//GEN-LAST:event_tf_Tag1FocusGained

      private void tf_Tag1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_Tag1FocusLost
            if (tf_Tag1.getText().equals("")) {
                  tf_Tag1.setText("NONE");
            }
      }//GEN-LAST:event_tf_Tag1FocusLost

      private void tf_Tag2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_Tag2FocusGained
            if (tf_Tag2.getText().equals("NONE")) {
                  tf_Tag2.setText("");
            }
      }//GEN-LAST:event_tf_Tag2FocusGained

      private void tf_Tag2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_Tag2FocusLost
            if (tf_Tag2.getText().equals("")) {
                  tf_Tag2.setText("NONE");
            }
      }//GEN-LAST:event_tf_Tag2FocusLost

      private void tf_c2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_c2KeyReleased
            bandWords(tf_c2);
      }//GEN-LAST:event_tf_c2KeyReleased

      private void tf_c3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_c3KeyReleased
            bandWords(tf_c3);
      }//GEN-LAST:event_tf_c3KeyReleased

      private void tf_c4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_c4KeyReleased
            bandWords(tf_c4);
      }//GEN-LAST:event_tf_c4KeyReleased

      private void tf_c5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_c5KeyReleased
            bandWords(tf_c5);
      }//GEN-LAST:event_tf_c5KeyReleased

      private void tf_c6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_c6KeyReleased
            bandWords(tf_c6);
      }//GEN-LAST:event_tf_c6KeyReleased

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
                  java.util.logging.Logger.getLogger(View_Create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                  java.util.logging.Logger.getLogger(View_Create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                  java.util.logging.Logger.getLogger(View_Create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                  java.util.logging.Logger.getLogger(View_Create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        new View_Create().setVisible(true);
                  }
            });
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private javax.swing.JButton btn_Create;
      private javax.swing.JButton btn_minus;
      private javax.swing.JButton btn_plus;
      private javax.swing.JPanel jPanel1;
      private javax.swing.JLabel lb_Dist1;
      private javax.swing.JLabel lb_Dist2;
      private javax.swing.JLabel lb_Name;
      private javax.swing.JLabel lb_Status;
      private javax.swing.JLabel lb_Tabl;
      private javax.swing.JLabel lb_Tag1;
      private javax.swing.JLabel lb_Tag2;
      private javax.swing.JLabel lb_c2;
      private javax.swing.JLabel lb_c3;
      private javax.swing.JLabel lb_c4;
      private javax.swing.JLabel lb_c5;
      private javax.swing.JLabel lb_c6;
      private javax.swing.JTextField tf_Dist1;
      private javax.swing.JTextField tf_Dist2;
      private javax.swing.JTextField tf_Name;
      private javax.swing.JTextField tf_Tabl;
      private javax.swing.JTextField tf_Tag1;
      private javax.swing.JTextField tf_Tag2;
      private javax.swing.JTextField tf_c2;
      private javax.swing.JTextField tf_c3;
      private javax.swing.JTextField tf_c4;
      private javax.swing.JTextField tf_c5;
      private javax.swing.JTextField tf_c6;
      // End of variables declaration//GEN-END:variables
}
