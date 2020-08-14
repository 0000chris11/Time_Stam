/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package First;

import Second.View_Update;
import ArrayMethods.ArraysM;
import Copy.Lots;
import static Copy.Lots.searchFilter;
import MC.Data;
import MC.MethodM;
import MC.Status;
import MC.notMyMethods;
import MC.Components;
import Listeners.ClockFocus;
import Listeners.CK_KL;
import Listeners.CCD;
import Listeners.LSTSKeyReleased;
import Listeners.LSTSValueChanged;
import Listeners.TF_LST_FL;
import Listeners.JTTableModelListener;
import Others.LimitTextD;
import Listeners.TFS_KL;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EventListener;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.MenuSelectionManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.util.LinkedHashSet;
import java.util.concurrent.TimeUnit;
import javax.swing.DefaultCellEditor;
import javax.swing.JComponent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.BrokenBarrierException;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.plaf.basic.BasicToolBarUI;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.AbstractDocument;
import Listeners.CCD;
import Listeners.MIActionListener;
import Listeners.MIShow_AL;
import Listeners.MIV_AL;
import MC.MakeCon;
import Threads.Threads;
import Others.LSTD;
import java.lang.reflect.Method;
import javax.swing.JToggleButton;
import Listeners.MainListeners_F;
import MC.DT;
import javax.swing.SwingUtilities;

/**
 *
 * @author Christopher
 */
public class VF extends JFrame{

      Connection con;

      String CName = this.getClass().getName();
      
      MethodM mm = new MethodM(CName, DT.CCount++);
      Components cp = new Components(CName, DT.CCount++);
      notMyMethods n_mm = new notMyMethods();
      Data dt = new Data();
      Status st = new Status();
      MainListeners_F ml = new MainListeners_F();
      LSTD lstd = new LSTD();
      Threads th = new Threads(CName, DT.CCount++);
      //ArraysM am = new ArraysM();
      MakeCon mc = new MakeCon(CName, DT.CCount++);
      //+++++++++++++++++++++++++++++++++++++++++++++
      
      private static JFrame JF = new JFrame();
      
      Color[] cl = {Color.RED, Color.GREEN, Color.YELLOW};
      final String inter = "Nothing Changed";

      private static JTable JT = new JTable();

      public static JTable getJT() {
            return JT;
      }

      public static JToggleButton getBTN_Show_All() {
            return btn_Show_All;
      }

      public static JLabel getLB_Title() {
            return lb_Title;
      }

      private static JScrollPane sc_JT = new JScrollPane(JT);

      public static JScrollPane getSC_JT() {
            return sc_JT;
      }

      private static JLabel lb_Icon = new JLabel();

      public static JLabel getLB_Icon() {
            return lb_Icon;
      }

      JPanel p3 = new JPanel();

      private static JLabel lb_Status = new JLabel("Waiting for Action...");

      public static JLabel getLB_Status() {
            return lb_Status;
      }

      JToolBar tb = new JToolBar();
      //JButton hide_id = new JButton();
      JButton[] btns_T = new JButton[]{new JButton(), new JButton()};

      //Components tb_cp = new Components(tb);
      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      private static JTextField[] tfs_MD = new JTextField[]{new JTextField("0"), new JTextField("0"),
            new JTextField("0"), new JTextField("0"), new JTextField("0")};
      private static JTextField[] tfs_MU = new JTextField[]{new JTextField("0"), new JTextField("0"),
            new JTextField("0"), new JTextField("0"), new JTextField("0")};
      private static JTextField[] tfs_SD = new JTextField[]{new JTextField("0"), new JTextField("0"),
            new JTextField("0"), new JTextField("0"), new JTextField("0")};
      private static JTextField[] tfs_SU = new JTextField[]{new JTextField("0"), new JTextField("0"),
            new JTextField("0"), new JTextField("0"), new JTextField("0")};

      public static JTextField[] getTFS_MD() {
            return tfs_MD;
      }

      public static JTextField[] getTFS_MU() {
            return tfs_MU;
      }

      public static JTextField[] getTFS_SD() {
            return tfs_SD;
      }

      public static JTextField[] getTFS_SU() {
            return tfs_SU;
      }

      private static JLabel[] lb_2ds = new JLabel[]{new JLabel(":"), new JLabel(":"), new JLabel(":"),
            new JLabel(":"), new JLabel(":")};

      public static JLabel[] getLB_2DS() {
            return lb_2ds;
      }
      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

      private static JButton[] btns_C;

      public static JButton[] getJBTNS_C() {
            return btns_C;
      }
      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      //private static ArrayList<String> list_IconUrl = new ArrayList<String>();
      //private static ArrayList<ImageIcon> list_newIcon = new ArrayList<ImageIcon>();
      //private static ArrayList<String> list_cutUrl = new ArrayList<String>();

      //String IconURL = "C:\\C0F\\About Music\\Album Front\\";
      //ImageIcon icon = new ImageIcon(dt.IconURL);
      //JLabel lb_img = new JLabel();
      private static JLabel[] lbs;

      public static JLabel[] getJLBS() {
            return lbs;
      }

      private static JTextField[] tfs;

      public static JTextField[] getJTFS() {
            return tfs;
      }

      private static JScrollPane[] scs;

      public static JScrollPane[] getJSCS() {
            return scs;
      }

      private static JList[] lsts;

      public static JList[] getJLSTS() {
            return lsts;
      }

      private static JButton[] btns_MC;

      public static JButton[] getBTNS_MC() {
            return btns_MC;
      }
      
      public static JScrollPane getJSC_P1(){
            return sc_p1;
      }
      
      public static JMenuItem getMI_SEEL(){
            return mi_seeL;
      }
      
      public static JMenuItem getMI_SEER(){
            return mi_seeR;
      }
      
      public static JFrame getJF(){
            return JF;
      }
      //+++++++++++++++++++++++++++++++++++++++++++++++++++++
      static DefaultTableModel jm2;
      static DefaultTableModel jm3;
      static DefaultTableModel jm4;
      static DefaultTableModel jm5;
      static DefaultTableModel jm6;

      TableModelListener[] lsts2;
      TableModelListener[] lsts3;
      TableModelListener[] lsts4;
      TableModelListener[] lsts5;
      TableModelListener[] lsts6;

      boolean getDefault = true;

      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
      private static JTextField tf_ce = new JTextField();
      private static DefaultCellEditor customCellEditor = new DefaultCellEditor(tf_ce);

      public static JTextField getTF_CE() {
            return tf_ce;
      }

      public static DefaultCellEditor getCustomCellEditor() {
            return customCellEditor;
      }
      

      int state = 1;

      Thread scrollThread;
      Thread iconThread;

      //JScroller scThread = new JScroller();
      Thread addThread;
      //++++++++++++++++++++++++++++++++++++++++++++++
      /*
      private void V_sbThread() {
            scrollThread = new Thread() {
                  public void run() {
                        try {
                              dt.getCYB().await();
                              System.out.println("\nV_sb STARTS");
                              System.out.println("\tV_sb is waiting");
                              Thread.sleep(500);
                              addThread.join();
                              if (!dt.getTabl().contains("NONE")) {
                                    iconThread.join();
                              }
                              Thread.sleep(200);
                              sc_JT.getVerticalScrollBar().setValue(sc_JT.getVerticalScrollBar().getMaximum());
                        } catch (InterruptedException ex) {
                              System.err.println("\tVs_sb... Fail... Horrible");
                              ex.printStackTrace();
                        } catch (BrokenBarrierException bbe) {
                              System.err.println("\tVs_sb... Fail... Horrible");
                              bbe.printStackTrace();
                        }
                        System.out.println("\tV_sb finished");
                  }
            };
      }

      private void fireDataThread() {
            new Thread() {
                  public void run() {
                        try {
                              dt.getCYB().await();
                              Data.bool_Add = true;
                              System.out.println("\nfireData STARTS // " + Data.bool_Add);
                              System.out.println("\tfireData is waiting");
                              scrollThread.join();
                              ((AbstractTableModel) JT.getModel()).fireTableDataChanged();
                              Thread.sleep(500);
                        } catch (InterruptedException ie) {
                              System.err.println("\tfireData... Fail... Horrible");
                              ie.printStackTrace();
                        } catch (BrokenBarrierException bbe) {
                              System.err.println("\tfireData... Fail... Horrible");
                              bbe.printStackTrace();
                        }
                        Data.bool_Add = false;
                        System.out.println("\tfireData finished");
                  }
            }.start();
      }
      */
      private void setColorToDItem(ArrayList<String> listTables, JMenu jm) {
            if (listTables.isEmpty()) {
            } else {
                  for (int a = 0; a < listTables.size(); a++) {
                        if (listTables.get(a).contains(dt.getDTable())) {
                              jm.getItem(a).setFont(new Font(
                                      jm.getItem(a).getFont().getName(),
                                      Font.BOLD,
                                      jm.getItem(a).getFont().getSize()));
                        }
                  }
            }
      }

      private void addItemToMenus(ArrayList<String> L_id, ArrayList<String> L_Table) {
            MIActionListener MIAL = new MIActionListener();

            JM2.removeAll();
            mi_OP_Change.removeAll();

            Collections.sort(L_Table);

            for (int a = 0; a < L_Table.size(); a++) {
                  JM2.add(new JMenuItem(L_Table.get(a)));
                  mi_OP_Change.add(new JMenuItem(L_id.get(a) + ": " + L_Table.get(a)));
                  //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                  JM2.getItem(a).addActionListener(MIAL);
                  mi_OP_Change.getItem(a).addActionListener(MIAL);
            }
            setColorToDItem(L_Table, mi_OP_Change);
      }
      //+++++++++++++++++++++++++++++++++++++++++++++++++
      private void fillTableSize(JScrollPane sc, JTable table, int columns) {

            int scroll = sc.getWidth();
            int col1;
            int col2;
            int col3;
            int col4;
            int col5;
            int col6;

            int sum;
            int rest;
            double result = 0;

            System.out.println("JScroll Width: " + scroll);

            if (columns == 2) {
                  col1 = table.getColumnModel().getColumn(0).getWidth();
                  col2 = table.getColumnModel().getColumn(1).getWidth();

                  sum = col1 + col2;
                  rest = scroll - sum;
                  result = rest / 2;

            } else if (columns == 3) {
                  col1 = table.getColumnModel().getColumn(0).getWidth();
                  col2 = table.getColumnModel().getColumn(1).getWidth();
                  col3 = table.getColumnModel().getColumn(2).getWidth();

                  sum = col1 + col2 + col3;
                  rest = scroll - sum;
                  result = rest / 3;
            } else if (columns == 4) {
                  col1 = table.getColumnModel().getColumn(0).getWidth();
                  col2 = table.getColumnModel().getColumn(1).getWidth();
                  col3 = table.getColumnModel().getColumn(2).getWidth();
                  col4 = table.getColumnModel().getColumn(3).getWidth();

                  sum = col1 + col2 + col3 + col4;
                  rest = scroll - sum;
                  result = rest / 4;
            } else if (columns == 5) {
                  col1 = table.getColumnModel().getColumn(0).getWidth();
                  col2 = table.getColumnModel().getColumn(1).getWidth();
                  col3 = table.getColumnModel().getColumn(2).getWidth();
                  col4 = table.getColumnModel().getColumn(3).getWidth();
                  col5 = table.getColumnModel().getColumn(4).getWidth();

                  sum = col1 + col2 + col3 + col4 + col5;
                  System.out.println("Sum of Columns: " + sum);
                  rest = scroll - sum;
                  System.out.println("Rest: " + rest);
                  result = rest / 5;
            } else if (columns == 6) {
                  col1 = table.getColumnModel().getColumn(0).getWidth();
                  col2 = table.getColumnModel().getColumn(1).getWidth();
                  col3 = table.getColumnModel().getColumn(2).getWidth();
                  col4 = table.getColumnModel().getColumn(3).getWidth();
                  col5 = table.getColumnModel().getColumn(4).getWidth();
                  col6 = table.getColumnModel().getColumn(5).getWidth();

                  sum = col1 + col2 + col3 + col4 + col5 + col6;
                  rest = scroll - sum;
                  result = rest / 6;
            }

            int result0 = (int) result;
            for (int a = 0; a < table.getColumnCount(); a++) {
                  System.out.println("Column " + a + ": " + table.getColumnModel().getColumn(a).getWidth());
                  System.out.println("Result: " + result0);

                  table.getColumnModel().getColumn(a).setWidth(
                          table.getColumnModel().getColumn(a).getWidth() + result0);
            }
      }

      private void reziseText(JTextField tf) {
            int txSize = tf.getText().length();
            int tfWidth = tf.getWidth();

            System.out.println("txSize: " + txSize);
            System.out.println("tfWidth: " + tfWidth);
            if (txSize > 5) {
                  System.out.println("SIZZZZZZZ");
                  tfWidth += 5;
                  tf.setSize(tfWidth, tf.getHeight());

            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public void controlBtnUpdate(ArrayList<String> list, JTextField tf) {
            int z = 0;
            if (tf.getText().equals("")) {
                  z = 1;
            } else {
                  for (int a = 0; a < list.size(); a++) {
                        if (list.get(a).equals(tf.getText())) {
                              z = 1;
                              //a = list.size();
                        } else {
                              if (z == 1) {
                              } else {
                                    z = 0;
                              }
                        }
                  }
            }
            if (z >= 1) {
                  //System.out.println("UPDATE TO FALSE");
                  btn_UPD.setEnabled(false);
            } else if (z == 0) {
                  //System.out.println("UPDATE TO TRUE");
                  btn_UPD.setEnabled(true);
            }
      }

      private void setColorforBasicButton(ArrayList<JButton> btns) {
            for (int a = 0; a < btns.size(); a++) {
                  btns.get(a).addMouseListener(new MouseListener() {
                        public void mouseClicked(MouseEvent arg0) {
                        }

                        public void mousePressed(MouseEvent e) {
                              //System.out.println("---------Press");
                              //setBackground(Color.GRAY);
                        }

                        public void mouseReleased(MouseEvent e) {
                              //System.out.println("---------Released");
                              //setBackground(Color.WHITE);
                        }

                        public void mouseEntered(MouseEvent arg0) {
                        }

                        public void mouseExited(MouseEvent arg0) {
                        }
                  });
            }
      }

      private void otherListeners(){
            MIShow_AL misal = new MIShow_AL();
            MIV_AL mival = new MIV_AL();
            
            mi_STables.addActionListener(misal);
            mi_SColumns.addActionListener(misal);
            mi_SDists.addActionListener(misal);
            mi_SListD.addActionListener(misal);
            
            mi_seeL.addActionListener(mival);
            mi_seeR.addActionListener(mival);
      }
      
      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      private void clockConfig() {
            int x_tm = 6;
            int x_bm = x_tm + 6;
            int x_ts = x_bm + 26;
            int x_bs = x_ts + 6;
            int b = 1;
            int py = 2;
            int t2 = 15;
            int tf_y = tfs[1].getY() - 4;
            int tf_h = tfs[b].getHeight() + 4;

            CK_KL CKT = new CK_KL();
            ClockFocus CF = new ClockFocus();
            //System.out.println("tfs Heights: " + tf_h);
            Font FT = new Font("Dialog", Font.BOLD, 20);
            Font FL = new Font("Dialog", Font.BOLD, 26);
            Color[] c = {new Color(51, 51, 51), Color.WHITE};
            BasicButtonUI bbui = new BasicButtonUI();
            for (int a = 0; a < tfs_MD.length; a++) {//a: 0 to 4   b: 1 to 5
                  p1.add(tfs_MD[a]);
                  p1.add(tfs_MU[a]);
                  p1.add(tfs_SD[a]);
                  p1.add(tfs_SU[a]);
                  //p1.add(btns_hp[a]);
                  //p1.add(btns_hm[a]);
                  //p1.add(btns_mp[a]);
                  //p1.add(btns_mm[a]);
                  //p1.add(btns_sp[a]);
                  //p1.add(btns_sm[a]);
                  //+++++++++++++++++++++++++++++++++++++++++
                  tfs_MD[a].setBackground(c[0]);
                  tfs_MU[a].setBackground(c[0]);
                  tfs_SD[a].setBackground(c[0]);
                  tfs_SU[a].setBackground(c[0]);
                  tfs_MD[a].setFont(FT);
                  tfs_MU[a].setFont(FT);
                  tfs_SD[a].setFont(FT);
                  tfs_SU[a].setFont(FT);
                  tfs_MD[a].setForeground(c[1]);
                  tfs_MU[a].setForeground(c[1]);
                  tfs_SD[a].setForeground(c[1]);
                  tfs_SU[a].setForeground(c[1]);
                  tfs_MD[a].setHorizontalAlignment(0);
                  tfs_MU[a].setHorizontalAlignment(0);
                  tfs_SD[a].setHorizontalAlignment(0);
                  tfs_SU[a].setHorizontalAlignment(0);

                  //btns_hp[a].setUI(bbui);
                  //btns_hm[a].setUI(bbui);
                  //btns_mp[a].setUI(bbui);
                  //btns_mm[a].setUI(bbui);
                  //btns_sp[a].setUI(bbui);
                  //btns_sm[a].setUI(bbui);
                  //++++++++++++++++++++++++++++++++++++++++++
                  //tfs_h[a].setLocation(tfs[1].getX(), tfs[1].getY() + t1);
                  tfs_MD[a].setBounds(tfs[1].getX() + 163, tf_y + py,
                          30, tf_h);
                  //btns_hp[a].setBounds(tfs_MD[0].getX() + 32, tfs_MD[0].getY() + t1, 10, 10);
                  //btns_hm[a].setBounds(tfs_MD[0].getX() + 32, tfs_MD[0].getY() + t2, 10, 10);

                  tfs_MU[a].setBounds(tfs_MD[0].getX() + 26, tf_y + py,
                          30, tf_h);
                  //btns_mp[a].setBounds(tfs_MU[0].getX() + 32, tfs_MD[0].getY() + t1, 10, 10);
                  //btns_mm[a].setBounds(tfs_MU[0].getX() + 32, tfs_MD[0].getY() + t2, 10, 10);

                  tfs_SD[a].setBounds(tfs_MU[0].getX() + 44, tf_y + py,
                          30, tf_h);
                  //btns_sp[a].setBounds(tfs_SD[0].getX() + 32, tfs_MD[0].getY() + t1, 10, 10);
                  //btns_sm[a].setBounds(tfs_SD[0].getX() + 32, tfs_MD[0].getY() + t2, 10, 10);

                  tfs_SU[a].setBounds(tfs_SD[0].getX() + 26, tf_y + py,
                          30, tf_h);
                  //System.out.println("btns_hp[" + a + "] location" + btns_hp[a].getLocation());
                  //System.out.println("btns_mp[" + a + "] location" + btns_hm[a].getLocation());
                  py += 33;
                  //t2 += 33;
                  b++;
                  //+++++++++++++++++++++++++++++++++++++
                  tfs_MD[a].setVisible(false);
                  tfs_MU[a].setVisible(false);
                  tfs_SD[a].setVisible(false);
                  tfs_SU[a].setVisible(false);
                  //btns_hp[a].setVisible(false);
                  //btns_hm[a].setVisible(false);
                  //btns_mp[a].setVisible(false);
                  //btns_mm[a].setVisible(false);
                  //btns_sp[a].setVisible(false);
                  //btns_sm[a].setVisible(false);
                  //+++++++++++++++++++++++++++++++
                  ((AbstractDocument) tfs_MD[a].getDocument()).setDocumentFilter(
                          new LimitTextD("D"));
                  ((AbstractDocument) tfs_MU[a].getDocument()).setDocumentFilter(
                          new LimitTextD("U"));
                  ((AbstractDocument) tfs_SD[a].getDocument()).setDocumentFilter(
                          new LimitTextD("D"));
                  ((AbstractDocument) tfs_SU[a].getDocument()).setDocumentFilter(
                          new LimitTextD("U"));

                  tfs_MD[a].addKeyListener(CKT);
                  tfs_MU[a].addKeyListener(CKT);
                  tfs_SD[a].addKeyListener(CKT);
                  tfs_SU[a].addKeyListener(CKT);
                  tfs_MD[a].addFocusListener(CF);
                  tfs_MU[a].addFocusListener(CF);
                  tfs_SD[a].addFocusListener(CF);
                  tfs_SU[a].addFocusListener(CF);
                  //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                  p1.add(lb_2ds[a]);
                  lb_2ds[a].setBounds((tfs_MU[0].getX() + tfs_MU[0].getWidth() + 2),
                          tfs_MU[a].getY() - 3,
                          20, tfs_MU[0].getHeight());
                  lb_2ds[a].setFont(FL);
                  lb_2ds[a].setForeground(Color.WHITE);
                  lb_2ds[a].setHorizontalTextPosition(0);
                  lb_2ds[a].setVisible(false);
            }
            //System.out.println("\ntfs 2: "+ tfs[1].getY());
            //System.out.println("tfs 3: "+ tfs[2].getY());
            //System.out.println("tfs 4: "+ tfs[3].getY());
            //System.out.println("tfs 5: "+ tfs[4].getY());
            //System.out.println("tfs 6: "+ tfs[5].getY());
            lb_2ds[4].setForeground(Color.RED);
      }

      private void actionTBComponents() {
            btns_T[0].addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent evt) {
                        //JT.getColumn(0);
                        System.out.println("\nPRESS");
                        //++++++++++++++++++++++++++++++++++++++++++++
                        mm.printListSelectionListeners(JT);
                  }
            });
      }

      private void toolbarConfig() {
            JF.add(tb);
            tb.setUI(new BasicToolBarUI());
            int x_tb = sc_p1.getWidth() + sc_JT.getWidth() + 2;
            tb.setOrientation(JToolBar.VERTICAL);
            tb.setLayout(null);
            tb.setBounds(x_tb, 2, 40, sc_JT.getHeight());
            tb.setBackground(Color.BLACK);

            //System.out.println("Toolbar UI: " + tb.getUI());
            tb.add(btns_T[0]);
            btns_T[0].setUI(new BasicButtonUI());
            btns_T[0].setBounds(2, 2, 36, 30);
            btns_T[0].setEnabled(true);
            mm.setImageIcon(btns_T[0], "C:\\C0F\\Image\\X Icons\\H small.png");

            actionTBComponents();
            //System.out.println("sc_JT Height: " + sc_JT.getHeight());
            //System.out.println("TB Bounds: " + tb.getBounds());
            //System.out.println("btn hide_id Bounds: " + hide_id.getBounds());
      }

      private void frameConfig() {
            JF.setSize(1270, 627);
            sc_p1.setSize(446, 522);
            p1.setPreferredSize(new Dimension(446, 521));
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            JT.setUI(new BasicTableUI());

            int x = sc_p1.getX() + sc_p1.getWidth();
            sc_JT.setLocation(x - 2, 0);
            sc_JT.setSize(764, 522);
            JT.setSize(758, JT.getHeight());
            JT.setBackground(Color.BLACK);
            JT.setFont(new Font("Dialog", Font.PLAIN, 20));
            JT.setRowHeight(23);
            JT.setForeground(Color.WHITE);
            JT.setAutoCreateRowSorter(true);
            JT.setGridColor(Color.GRAY);
            JF.add(sc_JT);
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            int y3 = sc_p1.getHeight();
            int w3 = sc_p1.getWidth() + sc_JT.getWidth() - 7;
            p3.setLocation(sc_p1.getX() + 3, y3);
            p3.setSize(w3, 40);
            p3.setLayout(null);
            p3.setBackground(Color.BLACK);
            JF.add(p3);

            componentsConfig();
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            toolbarConfig();
            //++++++++++++++++++++++++++++++++++++++
            clockConfig();
      }

      private void componentsConfig() {
            lbs[0].setBounds(6, 38, 100, 27);
            tfs[0].setBounds(107, 38, 70, 27);

            lbs[1].setBounds(6, 72, 120, 27);
            tfs[1].setBounds(107, 72, 290, 27);

            scs[0].setVisible(false);
            scs[1].setVisible(false);
            scs[2].setVisible(false);
            scs[3].setVisible(false);
            scs[4].setVisible(false);

            p1.add(lb_Icon);
            lb_Icon.setSize(225, 225);
            float f = (sc_p1.getWidth() / 2) - (lb_Icon.getWidth() / 2);

            System.out.println("Graphic needed: X(" + ((lb_Icon.getWidth() / 3) - 2) + ")"
                    + " Y(225)");

            lb_Icon.setBounds((int) f, 500, 225, 225);
            lb_Icon.setForeground(Color.WHITE);
            lb_Icon.setHorizontalAlignment(0);
            lb_Icon.setVerticalTextPosition(0);
            lb_Icon.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

            btn_UPD.setEnabled(false);
            btn_DEL.setEnabled(false);
            //+++++++++++++++++++++++
            p3.add(lb_Status);
            lb_Status.setLocation(6, 6);
            lb_Status.setSize(p3.getWidth() - 100, 28);
            lb_Status.setForeground(Color.WHITE);
            lb_Status.setFont(new Font("Dialog", Font.BOLD, 16));
            lb_Status.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

            p1.remove(btn_Show_All);
            p3.add(btn_Show_All);
            btn_Show_All.setLocation(lb_Status.getWidth() + 10, 4);
            btn_Show_All.setSize(80, 28);
      }

      //+++++++++++++++++++++++++++++++++++++++
      private void setNameToComponents() {
            for (int a = 0; a < lbs.length; a++) {
                  lbs[a].setName("LB_" + (a + 1));
            }
            for (int a = 0; a < tfs.length; a++) {
                  tfs[a].setName("TF_" + (a + 1));
            }
            for (int a = 0; a < scs.length; a++) {
                  scs[a].setName("SC_" + (a + 2));
            }
            for (int a = 0; a < lsts.length; a++) {
                  lsts[a].setName("LST_" + (a + 2));
            }
            for (int a = 0; a < btns_C.length; a++) {
                  btns_C[a].setName("BTNC_" + (a + 2));
            }
            for (int a = 0; a < tfs_MD.length; a++) {
                  tfs_MD[a].setName("TF_MD_" + (a + 2));
                  tfs_MU[a].setName("TF_MU_" + (a + 2));
                  tfs_SD[a].setName("TF_SD_" + (a + 2));
                  tfs_SU[a].setName("TF_SU_" + (a + 2));
                  lb_2ds[a].setName("LB_2D_" + (a + 2));
            }
            //++++++++++++++++++++++++++++++++
            JM2.setName("JM2");
            mi_OP_Change.setName("mi_OP_Change");

            btns_MC[0].setName("BTN_ADD");
            btns_MC[1].setName("BTN_UPD");
            btns_MC[2].setName("BTN_DEL");

      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public VF() {
            initComponents();
            lbs = new JLabel[]{lb_1, lb_2, lb_3, lb_4, lb_5, lb_6};
            tfs = new JTextField[]{tf_1, tf_2, tf_3, tf_4, tf_5, tf_6};
            scs = new JScrollPane[]{sc_2, sc_3, sc_4, sc_5, sc_6};
            lsts = new JList[]{lst_2, lst_3, lst_4, lst_5, lst_6};
            btns_C = new JButton[]{btn_c2, btn_c3, btn_c4, btn_c5, btn_c6};
            btns_MC = new JButton[]{btn_ADD, btn_UPD, btn_DEL};

            frameConfig();

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //ADDING ITEM TO THE JMENU FROM TABLE_NAMES+++++++++++++++++
            System.out.println("\nSELECT TABLES");
            mc.SelectTables();

            //SELECTING DEFAULT TABLE+++++++++++++++++++++++++
            if (getDefault == true) {
                  System.out.println("SELECT DEFAULT TABLE");
                  mc.SelectDefaultTable();
            } else {

            }
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++
            addItemToMenus(dt.getList_id(), dt.getList_T());
            setNameToComponents();

            mm.printListSelectionListeners(JT);

            //ADDING COLUMNS AND ROWS FROM DEFAULT_TABLE++++++++++++++++++
            dt.setTable(mm.filterTableName(dt.getTable(), "ADD"));
            System.out.println("SELECT COLUMNS AND ROWS");
            mc.SelectColumns(dt.getTable());
            //typeDetection();
            //--------------------------------------------------------------------------------------------------------------------
            System.out.println("------ChangeLB_TF");
            cp.changeLB_TF(JT.getColumnCount(), dt.getList_C());
            System.out.println("------addKeyListenerToTFS");

            System.out.println("------ChangeLSTD");
            lstd.changeLSTD(dt.getTable(), dt.getDist1(), dt.getDist2(), dt.getTabl(), dt.getTag(),
                    dt.getClock());
            
            //addKeyListenerToLSTS();
            //--------------------------------------------------------------------------------------------------------------------
            System.out.println("SELECT CONFIG");
            mc.SelectConfig();
            mi_AOT.setSelected(dt.getList_BL().get(0));
            JF.setAlwaysOnTop(dt.getList_BL().get(0));

            mi_AutoR.setSelected(dt.getList_BL().get(1));
            n_mm.rez(JT, dt.getList_BL().get(1));
            dt.autoState = dt.getList_BL().get(1);

            mi_Grid.setSelected(dt.getList_BL().get(2));
            JT.setShowGrid(dt.getList_BL().get(2));
            //----------------------------------------------------------------------------------------------------------------------
            System.out.println("------addAllListenerToCJS");
            ml.addAllListenerLoop();
            otherListeners();
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++        
            JComponent component = new JTextField();
            ((JTextField) component).setFont(new Font(JT.getFont().getName(), JT.getFont().getStyle(), JT.getFont().getSize() + 4));

            tf_ce.setFont(JT.getFont());
            tf_ce.setBorder(null);
            Font f = JT.getFont();
            tf_ce.setFont(new Font(f.getName(), f.getStyle(), f.getSize()));

            //DefaultCellEditor customCellEditor = new DefaultCellEditor(tf_ce);
            for (int i = 0; i < JT.getColumnCount(); i++) {
                  JT.getColumnModel().getColumn(i).setCellEditor(customCellEditor);
            }
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //mm.threadHandle(scrollThread);
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //System.out.println("\nHeap Size: \t" + Runtime.getRuntime().totalMemory());
            //System.out.println("Heap Max Size: \t" + Runtime.getRuntime().maxMemory());
            //System.out.println("Heap Free Size: \t" + Runtime.getRuntime().freeMemory());
            //mm.printFor(dt.getList_T());
            //System.out.println("JT UI: " + JT.getUI());
            //setLists();

            //System.out.println("REST: " + (tfs[1].getY() - tfs[0].getY()));
            //System.out.println("LB_2 Bounds: " + lbs[1].getBounds());
            //System.out.println("TF_2 Bounds: " + tfs[1].getBounds());
            System.out.println("END");
      }

      public VF(String table) {
            System.out.println("S: " + table);
            frameConfig();

            mc.SelectTables();
            addItemToMenus(dt.getList_id(), dt.getList_T());

            mc.SelectConfig();
            mi_AOT.setSelected(dt.getList_BL().get(0));
            JF.setAlwaysOnTop(dt.getList_BL().get(0));

            mi_AutoR.setSelected(dt.getList_BL().get(1));
            n_mm.rez(JT, dt.getList_BL().get(1));
            dt.autoState = dt.getList_BL().get(1);

            mi_Grid.setSelected(dt.getList_BL().get(2));
            JT.setShowGrid(dt.getList_BL().get(2));

      }

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            jTextField1 = new javax.swing.JTextField();
            sc_p1 = new javax.swing.JScrollPane();
            p1 = new javax.swing.JPanel();
            lb_2 = new javax.swing.JLabel();
            tf_2 = new javax.swing.JTextField();
            lb_Title = new javax.swing.JLabel();
            lb_3 = new javax.swing.JLabel();
            tf_3 = new javax.swing.JTextField();
            lb_4 = new javax.swing.JLabel();
            tf_4 = new javax.swing.JTextField();
            lb_5 = new javax.swing.JLabel();
            tf_5 = new javax.swing.JTextField();
            btn_Find = new javax.swing.JButton();
            sc_3 = new javax.swing.JScrollPane();
            lst_3 = new javax.swing.JList<>();
            btn_ADD = new javax.swing.JButton();
            sc_5 = new javax.swing.JScrollPane();
            lst_5 = new javax.swing.JList<>();
            lb_1 = new javax.swing.JLabel();
            tf_1 = new javax.swing.JTextField();
            btn_UPD = new javax.swing.JButton();
            lb_6 = new javax.swing.JLabel();
            tf_6 = new javax.swing.JTextField();
            sc_4 = new javax.swing.JScrollPane();
            lst_4 = new javax.swing.JList<>();
            sc_6 = new javax.swing.JScrollPane();
            lst_6 = new javax.swing.JList<>();
            sc_2 = new javax.swing.JScrollPane();
            lst_2 = new javax.swing.JList<>();
            btn_DEL = new javax.swing.JButton();
            btn_Show_All = new javax.swing.JToggleButton();
            btn_minus = new javax.swing.JButton();
            btn_plus = new javax.swing.JButton();
            btn_c6 = new javax.swing.JButton();
            btn_c2 = new javax.swing.JButton();
            btn_c3 = new javax.swing.JButton();
            btn_c4 = new javax.swing.JButton();
            btn_c5 = new javax.swing.JButton();
            MB = new javax.swing.JMenuBar();
            JM1 = new javax.swing.JMenu();
            jMenu1 = new javax.swing.JMenu();
            mi_STables = new javax.swing.JMenuItem();
            mi_SColumns = new javax.swing.JMenuItem();
            mi_SDists = new javax.swing.JMenuItem();
            mi_OP_REF = new javax.swing.JMenuItem();
            mi_SListD = new javax.swing.JMenuItem();
            mi_AOT = new javax.swing.JCheckBoxMenuItem();
            mi_AutoR = new javax.swing.JCheckBoxMenuItem();
            mi_Grid = new javax.swing.JCheckBoxMenuItem();
            jSeparator3 = new javax.swing.JPopupMenu.Separator();
            mi_seeL = new javax.swing.JCheckBoxMenuItem();
            mi_seeR = new javax.swing.JCheckBoxMenuItem();
            jSeparator1 = new javax.swing.JPopupMenu.Separator();
            mi_saveOp = new javax.swing.JMenuItem();
            JM2 = new javax.swing.JMenu();
            mi_SL_Ranma = new javax.swing.JMenuItem();
            mi_SL_GG = new javax.swing.JMenuItem();
            JM3 = new javax.swing.JMenu();
            mi_OP_Change = new javax.swing.JMenu();
            mi_Create = new javax.swing.JMenuItem();
            mi_Update = new javax.swing.JMenuItem();
            mi_Delete = new javax.swing.JMenuItem();

            jTextField1.setText("jTextField1");

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            addWindowStateListener(new java.awt.event.WindowStateListener() {
                  public void windowStateChanged(java.awt.event.WindowEvent evt) {
                        formWindowStateChanged(evt);
                  }
            });
            getContentPane().setLayout(null);

            sc_p1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            sc_p1.setEnabled(false);
            sc_p1.setFocusable(false);

            p1.setBackground(new java.awt.Color(0, 0, 0));
            p1.setLayout(null);

            lb_2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_2.setForeground(new java.awt.Color(255, 255, 255));
            lb_2.setText("COL2");
            p1.add(lb_2);
            lb_2.setBounds(6, 72, 120, 27);

            tf_2.setBackground(new java.awt.Color(51, 51, 51));
            tf_2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            tf_2.setForeground(new java.awt.Color(255, 255, 255));
            p1.add(tf_2);
            tf_2.setBounds(107, 72, 290, 27);

            lb_Title.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
            lb_Title.setForeground(new java.awt.Color(255, 255, 255));
            lb_Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lb_Title.setText("Ranma 1/2");
            p1.add(lb_Title);
            lb_Title.setBounds(6, 6, 137, 24);

            lb_3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_3.setForeground(new java.awt.Color(255, 255, 255));
            lb_3.setText("COL3");
            p1.add(lb_3);
            lb_3.setBounds(6, 281, 120, 27);

            tf_3.setBackground(new java.awt.Color(51, 51, 51));
            tf_3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            tf_3.setForeground(new java.awt.Color(255, 255, 255));
            p1.add(tf_3);
            tf_3.setBounds(107, 281, 290, 27);

            lb_4.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_4.setForeground(new java.awt.Color(255, 255, 255));
            lb_4.setText("COL4");
            p1.add(lb_4);
            lb_4.setBounds(6, 490, 120, 27);

            tf_4.setBackground(new java.awt.Color(51, 51, 51));
            tf_4.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            tf_4.setForeground(new java.awt.Color(255, 255, 255));
            p1.add(tf_4);
            tf_4.setBounds(107, 490, 290, 27);

            lb_5.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_5.setForeground(new java.awt.Color(255, 255, 255));
            lb_5.setText("COL5");
            p1.add(lb_5);
            lb_5.setBounds(6, 699, 120, 27);

            tf_5.setBackground(new java.awt.Color(51, 51, 51));
            tf_5.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            tf_5.setForeground(new java.awt.Color(255, 255, 255));
            p1.add(tf_5);
            tf_5.setBounds(107, 699, 290, 27);

            btn_Find.setText("FIND");
            btn_Find.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_FindActionPerformed(evt);
                  }
            });
            p1.add(btn_Find);
            btn_Find.setBounds(231, 40, 80, 23);

            sc_3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            sc_3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

            lst_3.setBackground(new java.awt.Color(51, 51, 51));
            lst_3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lst_3.setForeground(new java.awt.Color(255, 255, 255));
            sc_3.setViewportView(lst_3);

            p1.add(sc_3);
            sc_3.setBounds(107, 314, 290, 170);

            btn_ADD.setText("ADD");
            p1.add(btn_ADD);
            btn_ADD.setBounds(317, 40, 80, 23);

            sc_5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            sc_5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

            lst_5.setBackground(new java.awt.Color(51, 51, 51));
            lst_5.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lst_5.setForeground(new java.awt.Color(255, 255, 255));
            lst_5.setModel(new javax.swing.AbstractListModel<String>() {
                  String[] strings = { " " };
                  public int getSize() { return strings.length; }
                  public String getElementAt(int i) { return strings[i]; }
            });
            sc_5.setViewportView(lst_5);

            p1.add(sc_5);
            sc_5.setBounds(107, 732, 290, 170);

            lb_1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_1.setForeground(new java.awt.Color(255, 255, 255));
            lb_1.setText("1. ID");
            p1.add(lb_1);
            lb_1.setBounds(6, 38, 100, 27);

            tf_1.setBackground(new java.awt.Color(51, 0, 0));
            tf_1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            tf_1.setForeground(new java.awt.Color(255, 255, 255));
            tf_1.setText("1");
            p1.add(tf_1);
            tf_1.setBounds(107, 38, 70, 27);

            btn_UPD.setText("UPDATE");
            p1.add(btn_UPD);
            btn_UPD.setBounds(317, 9, 80, 23);

            lb_6.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lb_6.setForeground(new java.awt.Color(255, 255, 255));
            lb_6.setText("COL6");
            p1.add(lb_6);
            lb_6.setBounds(6, 908, 120, 27);

            tf_6.setBackground(new java.awt.Color(51, 51, 51));
            tf_6.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            tf_6.setForeground(new java.awt.Color(255, 255, 255));
            p1.add(tf_6);
            tf_6.setBounds(107, 908, 290, 27);

            sc_4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            sc_4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

            lst_4.setBackground(new java.awt.Color(51, 51, 51));
            lst_4.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lst_4.setForeground(new java.awt.Color(255, 255, 255));
            sc_4.setViewportView(lst_4);

            p1.add(sc_4);
            sc_4.setBounds(107, 523, 290, 170);

            sc_6.setForeground(new java.awt.Color(255, 255, 255));
            sc_6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            sc_6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

            lst_6.setBackground(new java.awt.Color(51, 51, 51));
            lst_6.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lst_6.setForeground(new java.awt.Color(255, 255, 255));
            sc_6.setViewportView(lst_6);

            p1.add(sc_6);
            sc_6.setBounds(107, 941, 290, 170);

            sc_2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            sc_2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

            lst_2.setBackground(new java.awt.Color(51, 51, 51));
            lst_2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
            lst_2.setForeground(new java.awt.Color(255, 255, 255));
            sc_2.setViewportView(lst_2);

            p1.add(sc_2);
            sc_2.setBounds(107, 105, 290, 170);

            btn_DEL.setText("DELETE");
            p1.add(btn_DEL);
            btn_DEL.setBounds(231, 9, 80, 23);

            btn_Show_All.setText("Show All");
            btn_Show_All.addItemListener(new java.awt.event.ItemListener() {
                  public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        btn_Show_AllItemStateChanged(evt);
                  }
            });
            p1.add(btn_Show_All);
            btn_Show_All.setBounds(317, 1130, 80, 23);

            btn_minus.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
            btn_minus.setText("-");
            btn_minus.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_minusActionPerformed(evt);
                  }
            });
            p1.add(btn_minus);
            btn_minus.setBounds(190, 40, 36, 23);

            btn_plus.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
            btn_plus.setText("+");
            btn_plus.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_plusActionPerformed(evt);
                  }
            });
            p1.add(btn_plus);
            btn_plus.setBounds(190, 9, 36, 23);
            p1.add(btn_c6);
            btn_c6.setBounds(402, 910, 18, 27);
            p1.add(btn_c2);
            btn_c2.setBounds(402, 72, 18, 27);
            p1.add(btn_c3);
            btn_c3.setBounds(402, 281, 18, 27);
            p1.add(btn_c4);
            btn_c4.setBounds(402, 490, 18, 27);
            p1.add(btn_c5);
            btn_c5.setBounds(402, 700, 18, 27);

            sc_p1.setViewportView(p1);

            getContentPane().add(sc_p1);
            sc_p1.setBounds(0, 0, 430, 1500);

            JM1.setText("Options");

            jMenu1.setText("Show Lists");

            mi_STables.setText("Tables");
            jMenu1.add(mi_STables);

            mi_SColumns.setText("Columns");
            jMenu1.add(mi_SColumns);

            mi_SDists.setText("Dists");
            jMenu1.add(mi_SDists);

            mi_OP_REF.setText("Refresh");
            mi_OP_REF.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        mi_OP_REFActionPerformed(evt);
                  }
            });
            jMenu1.add(mi_OP_REF);

            mi_SListD.setText("ListD");
            jMenu1.add(mi_SListD);

            JM1.add(jMenu1);

            mi_AOT.setText("Always On Top");
            mi_AOT.addItemListener(new java.awt.event.ItemListener() {
                  public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        mi_AOTItemStateChanged(evt);
                  }
            });
            JM1.add(mi_AOT);

            mi_AutoR.setSelected(true);
            mi_AutoR.setText("Auto-Rezise");
            mi_AutoR.addChangeListener(new javax.swing.event.ChangeListener() {
                  public void stateChanged(javax.swing.event.ChangeEvent evt) {
                        mi_AutoRStateChanged(evt);
                  }
            });
            JM1.add(mi_AutoR);

            mi_Grid.setText("Show Grid");
            mi_Grid.addChangeListener(new javax.swing.event.ChangeListener() {
                  public void stateChanged(javax.swing.event.ChangeEvent evt) {
                        mi_GridStateChanged(evt);
                  }
            });
            JM1.add(mi_Grid);
            JM1.add(jSeparator3);

            mi_seeL.setSelected(true);
            mi_seeL.setText("See Left Panel");
            mi_seeL.addItemListener(new java.awt.event.ItemListener() {
                  public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        mi_seeLItemStateChanged(evt);
                  }
            });
            mi_seeL.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        mi_seeLActionPerformed(evt);
                  }
            });
            JM1.add(mi_seeL);

            mi_seeR.setSelected(true);
            mi_seeR.setText("See Right Panel");
            mi_seeR.addItemListener(new java.awt.event.ItemListener() {
                  public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        mi_seeRItemStateChanged(evt);
                  }
            });
            mi_seeR.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        mi_seeRActionPerformed(evt);
                  }
            });
            JM1.add(mi_seeR);
            JM1.add(jSeparator1);

            mi_saveOp.setText("Save Options");
            mi_saveOp.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        mi_saveOpActionPerformed(evt);
                  }
            });
            JM1.add(mi_saveOp);

            MB.add(JM1);

            JM2.setText("Select");

            mi_SL_Ranma.setText("Ranma 1/2");
            JM2.add(mi_SL_Ranma);

            mi_SL_GG.setText("Game Grumps");
            JM2.add(mi_SL_GG);

            MB.add(JM2);

            JM3.setText("Table");

            mi_OP_Change.setText("Change Default");
            JM3.add(mi_OP_Change);

            mi_Create.setText("Create Table");
            mi_Create.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        mi_CreateActionPerformed(evt);
                  }
            });
            JM3.add(mi_Create);

            mi_Update.setText("Update Table");
            mi_Update.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        mi_UpdateActionPerformed(evt);
                  }
            });
            JM3.add(mi_Update);

            mi_Delete.setText("Delete Table");
            JM3.add(mi_Delete);

            MB.add(JM3);

            setJMenuBar(MB);

            pack();
      }// </editor-fold>//GEN-END:initComponents

      private void mi_CreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_CreateActionPerformed
            //View_Create vc = new View_Create(dt.getList_T(), dt.getList_Dist1(), dt.getList_Dist2(),
            //      dt.getList_Tabl(), dt.getList_Tag1(), dt.getList_Tag2());
            //vc.setVisible(true);


      }//GEN-LAST:event_mi_CreateActionPerformed

      private void mi_OP_REFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_OP_REFActionPerformed
            //addItem(dt.getList_id(), dt.getList_T(), dt.getList_Dist1(), dt.getList_Dist2(), dt.getList_Tabl(),
            //     dt.getList_Tag1(), dt.getList_Tag2());
            tfs[0].setVisible(false);
            tfs[1].setVisible(false);
            tfs[2].setVisible(false);
            tfs[3].setVisible(false);
            tfs[4].setVisible(false);
            tfs[5].setVisible(false);
            if (tfs_MD[4].isVisible()) {
                  System.out.println("VISIBLE");
                  System.out.println("Location: " + tfs_MD[4].getLocation());
                  System.out.println("Size: " + tfs_MD[4].getSize());
                  if (tfs[4].getParent() == p1) {
                        System.out.println("tfs[4] does belong to p1");
                  } else {
                        System.out.println("tfs[4] does NOT belong to p1");
                  }
            } else {
                  System.out.println("?!");
            }
            tfs_MD[4].setVisible(true);
            tfs_MD[4].setBackground(Color.WHITE);
            tfs_MD[4].setForeground(Color.BLACK);
      }//GEN-LAST:event_mi_OP_REFActionPerformed

      private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
            //System.out.println("\nWindow State is Changing");
            if (state % 2 == 0) {
                  //setSize(1108, 582);
                  //System.out.println("\tMINIMIZE");
                  sc_p1.setSize(446, sc_p1.getHeight() - 196);
                  //sc_p1.setSize(446, 326);
                  //jPanel1.setPreferredSize(new Dimension(430, p1.getHeight() - 352));

                  sc_JT.setSize(sc_JT.getWidth() - 186, sc_JT.getHeight() - 196);
                  //JT.setSize(742, JT.getHeight() - 352);
            } else {
                  //System.out.println("\tMAXIMIZE");
                  sc_p1.setSize(446, sc_p1.getHeight() + 196);
                  //sc_p1.setSize(446, 718);
                  //jPanel1.setPreferredSize(new Dimension(430, p1.getHeight() + 352));

                  sc_JT.setSize(sc_JT.getWidth() + 186, sc_JT.getHeight() + 196);
                  //JT.setSize(742, JT.getHeight() + 352);
            }
            //System.out.println("\tSTATE: " + state);
            state++;
      }//GEN-LAST:event_formWindowStateChanged

      private void mi_AutoRStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_mi_AutoRStateChanged
            if (mi_AutoR.isSelected()) {
                  dt.autoState = true;
                  n_mm.rez(JT, dt.autoState);
            } else {
                  dt.autoState = false;
            }
      }//GEN-LAST:event_mi_AutoRStateChanged

      private void btn_Show_AllItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btn_Show_AllItemStateChanged
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                  if (JT.getColumnCount() == 2) {
                        if (tfs[1].getBackground().equals(new Color(0, 0, 51))
                                || tfs[1].getBackground().equals(new Color(0, 0, 81))) {
                              scs[0].setVisible(true);
                        }

                        p1.setPreferredSize(new Dimension(p1.getWidth(), sc_p1.getHeight()));
                  } else if (JT.getColumnCount() == 3) {
                        if (tfs[1].getBackground().equals(new Color(0, 0, 51))
                                || tfs[1].getBackground().equals(new Color(0, 0, 81))) {
                              lbs[2].setLocation(lbs[2].getX(), tfs[1].getY() + 209);
                              tfs[2].setLocation(tfs[2].getX(), tfs[1].getY() + 209);
                              btns_C[1].setLocation(btns_C[1].getX(), btns_C[0].getY() + 209);

                              scs[0].setVisible(true);
                        }
                        if (tfs[2].getBackground().equals(new Color(0, 0, 51))
                                || tfs[2].getBackground().equals(new Color(0, 0, 81))) {

                              scs[1].setLocation(scs[1].getX(), tfs[2].getY() + 33);
                              scs[1].setVisible(true);
                        }

                        p1.setPreferredSize(new Dimension(p1.getWidth(), 444));
                  } else if (JT.getColumnCount() == 4) {
                        if (tfs[1].getBackground().equals(new Color(0, 0, 51))
                                || tfs[1].getBackground().equals(new Color(0, 0, 81))) {
                              lbs[2].setLocation(lbs[2].getX(), tfs[1].getY() + 209);
                              tfs[2].setLocation(tfs[2].getX(), tfs[1].getY() + 209);
                              btns_C[1].setLocation(btns_C[1].getX(), tfs[1].getY() + 209);

                              lbs[3].setLocation(lbs[3].getX(), tfs[1].getY() + 242);
                              tfs[3].setLocation(tfs[3].getX(), tfs[1].getY() + 242);
                              btns_C[2].setLocation(btns_C[2].getX(), tfs[1].getY() + 242);

                              scs[0].setVisible(true);
                        }
                        if (tfs[2].getBackground().equals(new Color(0, 0, 51))
                                || tfs[2].getBackground().equals(new Color(0, 0, 81))) {
                              lbs[3].setLocation(lbs[3].getX(), tfs[2].getY() + 209);
                              tfs[3].setLocation(tfs[3].getX(), tfs[2].getY() + 209);
                              btns_C[2].setLocation(btns_C[2].getX(), tfs[2].getY() + 209);

                              scs[1].setLocation(scs[1].getX(), tfs[2].getY() + 33);
                              scs[1].setVisible(true);
                        }
                        if (tfs[3].getBackground().equals(new Color(0, 0, 51))
                                || tfs[3].getBackground().equals(new Color(0, 0, 81))) {

                              scs[2].setLocation(scs[2].getX(), tfs[3].getY() + 33);
                              scs[2].setVisible(true);
                        }
                        p1.setPreferredSize(new Dimension(p1.getWidth(), 686));
                  } else if (JT.getColumnCount() == 5) {
                        if (tfs[1].getBackground().equals(new Color(0, 0, 51))
                                || tfs[1].getBackground().equals(new Color(0, 0, 81))) {
                              lbs[2].setLocation(lbs[2].getX(), tfs[1].getY() + 209);
                              tfs[2].setLocation(tfs[2].getX(), tfs[1].getY() + 209);
                              btns_C[1].setLocation(btns_C[1].getX(), tfs[1].getY() + 209);

                              lbs[3].setLocation(lbs[3].getX(), tfs[1].getY() + 242);
                              tfs[3].setLocation(tfs[3].getX(), tfs[1].getY() + 242);
                              btns_C[2].setLocation(btns_C[2].getX(), tfs[1].getY() + 242);

                              lbs[4].setLocation(lbs[4].getX(), tfs[1].getY() + 275);
                              tfs[4].setLocation(tfs[4].getX(), tfs[1].getY() + 275);
                              btns_C[3].setLocation(btns_C[3].getX(), tfs[1].getY() + 275);

                              scs[0].setVisible(true);
                        }
                        if (tfs[2].getBackground().equals(new Color(0, 0, 51))
                                || tfs[2].getBackground().equals(new Color(0, 0, 81))) {
                              lbs[3].setLocation(lbs[3].getX(), tfs[2].getY() + 209);
                              tfs[3].setLocation(tfs[3].getX(), tfs[2].getY() + 209);
                              btns_C[2].setLocation(btns_C[2].getX(), tfs[2].getY() + 209);

                              lbs[4].setLocation(lbs[4].getX(), tfs[2].getY() + 242);
                              tfs[4].setLocation(tfs[4].getX(), tfs[2].getY() + 242);
                              btns_C[3].setLocation(btns_C[3].getX(), tfs[2].getY() + 242);

                              scs[1].setLocation(scs[1].getX(), tfs[2].getY() + 33);
                              scs[1].setVisible(true);
                        }
                        if (tfs[3].getBackground().equals(new Color(0, 0, 51))
                                || tfs[3].getBackground().equals(new Color(0, 0, 81))) {
                              lbs[4].setLocation(lbs[4].getX(), tfs[3].getY() + 209);
                              tfs[4].setLocation(tfs[4].getX(), tfs[3].getY() + 209);
                              btns_C[3].setLocation(btns_C[3].getX(), tfs[3].getY() + 209);

                              scs[2].setLocation(scs[2].getX(), tfs[3].getY() + 33);
                              scs[2].setVisible(true);
                        }
                        if (tfs[4].getBackground().equals(new Color(0, 0, 51))
                                || tfs[4].getBackground().equals(new Color(0, 0, 81))) {

                              scs[3].setLocation(scs[3].getX(), tfs[4].getY() + 33);
                              scs[3].setVisible(true);
                        }

                        p1.setPreferredSize(new Dimension(p1.getWidth(), 928));
                  } else if (JT.getColumnCount() == 6) {

                        if (tfs[1].getBackground().equals(new Color(0, 0, 51))
                                || tfs[1].getBackground().equals(new Color(0, 0, 81))) {
                              lbs[2].setLocation(lbs[2].getX(), tfs[1].getY() + 209);
                              tfs[2].setLocation(tfs[2].getX(), tfs[1].getY() + 209);
                              btns_C[1].setLocation(btns_C[1].getX(), tfs[1].getY() + 209);

                              lbs[3].setLocation(lbs[3].getX(), tfs[1].getY() + 242);
                              tfs[3].setLocation(tfs[3].getX(), tfs[1].getY() + 242);
                              btns_C[2].setLocation(btns_C[2].getX(), tfs[1].getY() + 242);

                              lbs[4].setLocation(lbs[4].getX(), tfs[1].getY() + 275);
                              tfs[4].setLocation(tfs[4].getX(), tfs[1].getY() + 275);
                              btns_C[3].setLocation(btns_C[3].getX(), tfs[1].getY() + 275);

                              lbs[5].setLocation(lbs[5].getX(), tfs[1].getY() + 308);
                              tfs[5].setLocation(tfs[5].getX(), tfs[1].getY() + 308);
                              btns_C[4].setLocation(btns_C[4].getX(), tfs[1].getY() + 308);
                              //SETLOCATION TO ALL TF & LB ???

                              scs[0].setVisible(true);
                        }
                        if (tfs[2].getBackground().equals(new Color(0, 0, 51))
                                || tfs[2].getBackground().equals(new Color(0, 0, 81))) {
                              lbs[3].setLocation(lbs[3].getX(), tfs[2].getY() + 209);
                              tfs[3].setLocation(tfs[3].getX(), tfs[2].getY() + 209);
                              btns_C[2].setLocation(btns_C[2].getX(), tfs[2].getY() + 209);

                              lbs[4].setLocation(lbs[4].getX(), tfs[2].getY() + 242);
                              tfs[4].setLocation(tfs[4].getX(), tfs[2].getY() + 242);
                              btns_C[3].setLocation(btns_C[3].getX(), tfs[2].getY() + 242);

                              lbs[5].setLocation(lbs[5].getX(), tfs[2].getY() + 275);
                              tfs[5].setLocation(tfs[5].getX(), tfs[2].getY() + 275);
                              btns_C[4].setLocation(btns_C[4].getX(), tfs[2].getY() + 275);

                              scs[1].setLocation(scs[1].getX(), tfs[2].getY() + 33);
                              scs[1].setVisible(true);
                        }
                        if (tfs[3].getBackground().equals(new Color(0, 0, 51))
                                || tfs[3].getBackground().equals(new Color(0, 0, 81))) {
                              lbs[4].setLocation(lbs[4].getX(), tfs[3].getY() + 209);
                              tfs[4].setLocation(tfs[4].getX(), tfs[3].getY() + 209);
                              btns_C[3].setLocation(btns_C[3].getX(), tfs[3].getY() + 209);

                              lbs[5].setLocation(lbs[5].getX(), tfs[3].getY() + 242);
                              tfs[5].setLocation(tfs[5].getX(), tfs[3].getY() + 242);
                              btns_C[4].setLocation(btns_C[4].getX(), tfs[3].getY() + 242);

                              scs[2].setLocation(scs[2].getX(), tfs[3].getY() + 33);
                              scs[2].setVisible(true);
                        }
                        if (tfs[4].getBackground().equals(new Color(0, 0, 51))
                                || tfs[4].getBackground().equals(new Color(0, 0, 81))) {
                              lbs[5].setLocation(lbs[5].getX(), tfs[4].getY() + 209);
                              tfs[5].setLocation(tfs[5].getX(), tfs[4].getY() + 209);
                              btns_C[4].setLocation(btns_C[4].getX(), tfs[4].getY() + 209);

                              scs[3].setLocation(scs[3].getX(), tfs[4].getY() + 33);
                              scs[3].setVisible(true);
                        }
                        if (tfs[5].getBackground().equals(new Color(0, 0, 51))
                                || tfs[5].getBackground().equals(new Color(0, 0, 81))) {

                              scs[4].setLocation(scs[4].getX(), tfs[5].getY() + 33);
                              scs[4].setVisible(true);
                        } else {

                        }

                        p1.setPreferredSize(new Dimension(p1.getWidth(), 1170));

                        sc_p1.revalidate();
                        sc_p1.repaint();
                  }
            } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
                  if (JT.getColumnCount() == 2) {
                        scs[0].setVisible(false);

                  } else if (JT.getColumnCount() == 3) {
                        scs[0].setVisible(false);
                        scs[1].setVisible(false);

                        lbs[2].setLocation(lbs[2].getX(), tfs[1].getY() + 33);
                        tfs[2].setLocation(tfs[2].getX(), tfs[1].getY() + 33);
                        btns_C[1].setLocation(btns_C[1].getX(), tfs[1].getY() + 33);

                  } else if (JT.getColumnCount() == 4) {
                        scs[0].setVisible(false);
                        scs[1].setVisible(false);
                        scs[2].setVisible(false);

                        lbs[2].setLocation(lbs[2].getX(), tfs[1].getY() + 33);
                        tfs[2].setLocation(tfs[2].getX(), tfs[1].getY() + 33);
                        btns_C[1].setLocation(btns_C[1].getX(), tfs[1].getY() + 33);

                        lbs[3].setLocation(lbs[3].getX(), tfs[1].getY() + 66);
                        tfs[3].setLocation(tfs[3].getX(), tfs[1].getY() + 66);
                        btns_C[2].setLocation(btns_C[2].getX(), tfs[1].getY() + 66);

                  } else if (JT.getColumnCount() == 5) {
                        scs[0].setVisible(false);
                        scs[1].setVisible(false);
                        scs[2].setVisible(false);
                        scs[3].setVisible(false);

                        lbs[2].setLocation(lbs[2].getX(), tfs[1].getY() + 33);
                        tfs[2].setLocation(tfs[2].getX(), tfs[1].getY() + 33);
                        btns_C[1].setLocation(btns_C[1].getX(), tfs[1].getY() + 33);

                        lbs[3].setLocation(lbs[3].getX(), tfs[1].getY() + 66);
                        tfs[3].setLocation(tfs[3].getX(), tfs[1].getY() + 66);
                        btns_C[2].setLocation(btns_C[2].getX(), tfs[1].getY() + 66);

                        lbs[4].setLocation(lbs[4].getX(), tfs[1].getY() + 99);
                        tfs[4].setLocation(tfs[4].getX(), tfs[1].getY() + 99);
                        btns_C[3].setLocation(btns_C[3].getX(), tfs[1].getY() + 99);

                  } else if (JT.getColumnCount() == 6) {
                        scs[0].setVisible(false);
                        scs[1].setVisible(false);
                        scs[2].setVisible(false);
                        scs[3].setVisible(false);
                        scs[4].setVisible(false);

                        lbs[2].setLocation(lbs[2].getX(), tfs[1].getY() + 33);
                        tfs[2].setLocation(tfs[2].getX(), tfs[1].getY() + 33);
                        btns_C[1].setLocation(btns_C[1].getX(), tfs[1].getY() + 33);

                        lbs[3].setLocation(lbs[3].getX(), tfs[1].getY() + 66);
                        tfs[3].setLocation(tfs[3].getX(), tfs[1].getY() + 66);
                        btns_C[2].setLocation(btns_C[2].getX(), tfs[1].getY() + 66);

                        lbs[4].setLocation(lbs[4].getX(), tfs[1].getY() + 99);
                        tfs[4].setLocation(tfs[4].getX(), tfs[1].getY() + 99);
                        btns_C[3].setLocation(btns_C[3].getX(), tfs[1].getY() + 99);

                        lbs[5].setLocation(lbs[5].getX(), tfs[1].getY() + 132);
                        tfs[5].setLocation(tfs[5].getX(), tfs[1].getY() + 132);
                        btns_C[4].setLocation(btns_C[4].getX(), tfs[1].getY() + 132);
                  }
                  p1.setPreferredSize(new Dimension(p1.getWidth(), sc_p1.getHeight()));

                  sc_p1.revalidate();
                  sc_p1.repaint();
            }
      }//GEN-LAST:event_btn_Show_AllItemStateChanged

      private void btn_FindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_FindActionPerformed
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);

            String text = JOptionPane.showInputDialog(jf, "Insert Word:");
            String element;
            int z = -1;

            for (int c = 0; c < JT.getColumnCount(); c++) {
                  for (int r = 0; r < JT.getRowCount(); r++) {
                        if (JT.getValueAt(r, c) instanceof String) {
                              element = (String) JT.getValueAt(r, c);
                        } else {
                              element = JT.getValueAt(r, c).toString();
                        }
                        if (text.equals(element)) {
                              JT.changeSelection(r, c, false, false);
                              System.out.println("ELEMENT FOUND AT: " + "C" + c + "R" + r);
                              System.out.println("COLUMN: " + c);
                              System.out.println("ROW: " + r);
                              z = 1;
                        } else {
                              if (z == 1) {
                              } else {
                                    //System.out.println("NOTHING FOUND");
                              }
                        }
                  }
            }
            if (z == -1) {
                  st.startLBStatus(lb_Status, cl[0], "Nothing Found", 5000);
            }
      }//GEN-LAST:event_btn_FindActionPerformed

      private void btn_plusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_plusActionPerformed
            Font f = JT.getFont();
            int fsize = f.getSize();
            int rheight = JT.getRowHeight();
            JT.setFont(new Font(f.getName(), f.getSize(), ++fsize));
            JT.setRowHeight(++rheight);
            tf_ce.setFont(new Font(f.getName(), f.getSize(), ++fsize));
            n_mm.rez(JT, dt.autoState);
      }//GEN-LAST:event_btn_plusActionPerformed

      private void btn_minusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_minusActionPerformed
            Font f = JT.getFont();
            int fsize = f.getSize();
            int rheight = JT.getRowHeight();
            JT.setFont(new Font(f.getName(), f.getSize(), --fsize));
            JT.setRowHeight(--rheight);
            tf_ce.setFont(new Font(f.getName(), f.getSize(), --fsize));
            n_mm.rez(JT, dt.autoState);
      }//GEN-LAST:event_btn_minusActionPerformed

      private void mi_GridStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_mi_GridStateChanged
            if (mi_Grid.isSelected()) {
                  JT.setShowGrid(true);
            } else {
                  JT.setShowGrid(false);
            }
      }//GEN-LAST:event_mi_GridStateChanged

      private void mi_AOTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mi_AOTItemStateChanged
            if (mi_AOT.isSelected()) {
                  setAlwaysOnTop(true);
            } else {
                  setAlwaysOnTop(false);
            }
      }//GEN-LAST:event_mi_AOTItemStateChanged

      private void mi_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_UpdateActionPerformed
            ArrayList<String> list_LST = new ArrayList<String>();
            list_LST.add(dt.getTable());
            list_LST.add(dt.getDist1());
            list_LST.add(dt.getDist2());
            list_LST.add(dt.getTabl());
            list_LST.add(dt.getTag());
            list_LST.add(dt.getClock());

            View_Update vu = new View_Update(list_LST, dt.getList_T(), dt.getList_C(),
                    dt.getList_TP(), dt.getList_NL());
            vu.setVisible(true);
            //this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            dispose();
      }//GEN-LAST:event_mi_UpdateActionPerformed

      private void mi_saveOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_saveOpActionPerformed
            if (mi_AOT.getState() != dt.getList_BL().get(0)) {
                  mc.UpdateConfig(mi_AOT.getState(), 1);
            } else {
                  //System.out.println("mi_AOT hasn't changed");
            }
            if (mi_AutoR.getState() != dt.getList_BL().get(1)) {
                  mc.UpdateConfig(mi_AutoR.getState(), 2);
            } else {
                  //System.out.println("mi_AutoR hasn't changed");
            }
            if (mi_Grid.getState() != dt.getList_BL().get(2)) {
                  mc.UpdateConfig(mi_Grid.getState(), 3);
            } else {
                  //System.out.println("mi_Grid hasn't changed");
            }

      }//GEN-LAST:event_mi_saveOpActionPerformed

      private void mi_seeLItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mi_seeLItemStateChanged

      }//GEN-LAST:event_mi_seeLItemStateChanged

      private void mi_seeRItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mi_seeRItemStateChanged

      }//GEN-LAST:event_mi_seeRItemStateChanged

      private void mi_seeLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_seeLActionPerformed
            /*
            if (mi_seeL.isSelected()) {
                  setSize(1226, 582);
                  sc_p1.setVisible(true);

                  int x = sc_p1.getX() + sc_p1.getWidth();
                  sc_JT.setLocation(x - 2, sc_JT.getY());
            } else {
                  if (mi_seeR.isSelected()) {
                        sc_p1.setVisible(false);
                        sc_JT.setLocation(sc_p1.getX(), sc_JT.getY());
                        setSize(sc_JT.getWidth() + 14, getHeight());
                  } else {
                        mi_seeL.setSelected(true);
                  }
            }
            */
      }//GEN-LAST:event_mi_seeLActionPerformed

      private void mi_seeRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_seeRActionPerformed
            /*
            if (mi_seeR.isSelected()) {
                  sc_JT.setVisible(true);
                  setSize(1226, 582);
            } else {
                  if (mi_seeL.isSelected()) {
                        sc_JT.setVisible(false);
                        setSize(sc_p1.getWidth() + 14, getHeight());
                  } else {
                        mi_seeR.setSelected(true);
                  }
            }
            */
      }//GEN-LAST:event_mi_seeRActionPerformed

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
                  java.util.logging.Logger.getLogger(VF.class
                          .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                  java.util.logging.Logger.getLogger(VF.class
                          .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                  java.util.logging.Logger.getLogger(VF.class
                          .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                  java.util.logging.Logger.getLogger(VF.class
                          .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>
            //</editor-fold>
            //</editor-fold>
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        System.out.println("Main Thread STARS");
                        new VF().setVisible(true);
                  }
            });
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private static javax.swing.JMenu JM1;
      private static javax.swing.JMenu JM2;
      private static javax.swing.JMenu JM3;
      private static javax.swing.JMenuBar MB;
      private static javax.swing.JButton btn_ADD;
      private static javax.swing.JButton btn_DEL;
      private static javax.swing.JButton btn_Find;
      private static javax.swing.JToggleButton btn_Show_All;
      private static javax.swing.JButton btn_UPD;
      private static javax.swing.JButton btn_c2;
      private static javax.swing.JButton btn_c3;
      private static javax.swing.JButton btn_c4;
      private static javax.swing.JButton btn_c5;
      private static javax.swing.JButton btn_c6;
      private static javax.swing.JButton btn_minus;
      private static javax.swing.JButton btn_plus;
      private static javax.swing.JMenu jMenu1;
      private static javax.swing.JPopupMenu.Separator jSeparator1;
      private static javax.swing.JPopupMenu.Separator jSeparator3;
      private static javax.swing.JTextField jTextField1;
      private static javax.swing.JLabel lb_1;
      private static javax.swing.JLabel lb_2;
      private static javax.swing.JLabel lb_3;
      private static javax.swing.JLabel lb_4;
      private static javax.swing.JLabel lb_5;
      private static javax.swing.JLabel lb_6;
      private static javax.swing.JLabel lb_Title;
      private static javax.swing.JList<String> lst_2;
      private static javax.swing.JList<String> lst_3;
      private static javax.swing.JList<String> lst_4;
      private static javax.swing.JList<String> lst_5;
      private static javax.swing.JList<String> lst_6;
      private static javax.swing.JCheckBoxMenuItem mi_AOT;
      private static javax.swing.JCheckBoxMenuItem mi_AutoR;
      private static javax.swing.JMenuItem mi_Create;
      private static javax.swing.JMenuItem mi_Delete;
      private static javax.swing.JCheckBoxMenuItem mi_Grid;
      private static javax.swing.JMenu mi_OP_Change;
      private static javax.swing.JMenuItem mi_OP_REF;
      private static javax.swing.JMenuItem mi_SColumns;
      private static javax.swing.JMenuItem mi_SDists;
      private static javax.swing.JMenuItem mi_SL_GG;
      private static javax.swing.JMenuItem mi_SL_Ranma;
      private static javax.swing.JMenuItem mi_SListD;
      private static javax.swing.JMenuItem mi_STables;
      private static javax.swing.JMenuItem mi_Update;
      private static javax.swing.JMenuItem mi_saveOp;
      private static javax.swing.JCheckBoxMenuItem mi_seeL;
      private static javax.swing.JCheckBoxMenuItem mi_seeR;
      private static javax.swing.JPanel p1;
      private static javax.swing.JScrollPane sc_2;
      private static javax.swing.JScrollPane sc_3;
      private static javax.swing.JScrollPane sc_4;
      private static javax.swing.JScrollPane sc_5;
      private static javax.swing.JScrollPane sc_6;
      private static javax.swing.JScrollPane sc_p1;
      private static javax.swing.JTextField tf_1;
      private static javax.swing.JTextField tf_2;
      private static javax.swing.JTextField tf_3;
      private static javax.swing.JTextField tf_4;
      private static javax.swing.JTextField tf_5;
      private static javax.swing.JTextField tf_6;
      // End of variables declaration//GEN-END:variables
}
