package First;

import static First.VF_R_DataCom.JF;
import static First.VF_R_DataCom.JT;
import static First.VF_R_DataCom.PT;
import static First.VF_R_DataCom.btn_plus;
import static First.VF_R_DataCom.btns_MC;
import static First.VF_R_DataCom.lb_Status;
import static First.VF_R_DataCom.tfs;
import smallComponenets.smallLB;
import MC.*;
import Listeners_F.MainListeners_F;
import Listeners_F.MIActionListener;
import Listeners_F.CK_FL;
import com.cofii.myMethods.MText;
import Others.*;
import Threads.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.text.AbstractDocument;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicTableUI;
import smallComponenets.smallBTN_C;
import smallComponenets.smallLST;
import smallComponenets.smallTF;
import javax.swing.JSeparator;
import javax.swing.plaf.metal.MetalToolBarUI;
import com.cofii.myClasses.VT;
import java.awt.BorderLayout;
import java.awt.FontMetrics;
import static First.VF_R_DataCom.SPL;
import static First.VF_R_DataCom.PL;

/**
 *
 * @author Christopher
 */
public class VF_R extends VF_R_DataCom {

      //Connection con;
      String CName = this.getClass().getName();

      //MethodM mm = new MethodM(CName, DT.CCount++);
      Components cp = new Components(CName, DT.CCount++);
      notMyMethods n_mm = new notMyMethods();
      //Data dt = new Data("VF_R");
      Status st = new Status();
      MainListeners_F ml = new MainListeners_F();
      LSTD lstd = new LSTD();
      Threads th = new Threads(CName, DT.CCount++);
      //ArraysM am = new ArraysM();
      MakeCon mc = new MakeCon(CName, DT.CCount++);
      //++++++++-+++++++++++++++++++++++++++++++++++++
      int state = 1;

      Thread scrollThread;
      Thread iconThread;

      //JScroller scThread = new JScroller();
      Thread addThread;

      //++++++++++++++++++++++++++++++++++++++++++++++
      public static void setColorToDItem(String table, String dtable) {
            //System.out.println("MTH - setColorToDItem");
            Font F = new Font("Dialog", Font.BOLD, 12);
            if (JMS_ChangeDTable.getItemCount() == 0) {
                  //System.out.println("###LTABLE IS NULL");
            } else {
                  //System.out.println("###COUNT: " + JMS_ChangeDTable.getItemCount());
                  for (int a = 0; a < JMS_ChangeDTable.getItemCount(); a++) {
                        JM_Select.getItem(a).setBackground(Color.BLACK);
                        JM_Select.getItem(a).setForeground(Color.WHITE);
                        JMS_ChangeDTable.getItem(a).setBackground(Color.BLACK);
                        JMS_ChangeDTable.getItem(a).setForeground(Color.WHITE);
                  }
                  for (int a = 0; a < JMS_ChangeDTable.getItemCount(); a++) {
                        String itemText = JM_Select.getItem(a).getText();
                        //System.out.println(CC.PURPLE + "ItemText: " + itemText + CC.RESET);
                        //System.out.println(CC.PURPLE + "\tdt.getTable: " + DT.getTable() + CC.RESET);
                        //System.out.println(CC.PURPLE + "\tdt.getDTable: " + DT.getDTable() + CC.RESET);
                        if (itemText.contains(" ")) {
                              itemText = itemText.replaceAll(" ", "_");
                        }

                        if (itemText.equals(table)
                                && itemText.equals(dtable)) {
                              JM_Select.getItem(a).setBackground(new Color(100, 100, 100));
                              JMS_ChangeDTable.getItem(a).setBackground(new Color(100, 100, 100));
                        } else if (itemText.equals(table)
                                && !itemText.equals(dtable)) {
                              JM_Select.getItem(a).setBackground(new Color(50, 50, 50));
                              JMS_ChangeDTable.getItem(a).setBackground(new Color(50, 50, 50));
                        } else if (!itemText.equals(table)
                                && itemText.equals(dtable)) {
                              JM_Select.getItem(a).setBackground(new Color(80, 80, 80));
                              JMS_ChangeDTable.getItem(a).setBackground(new Color(80, 80, 80));
                        }
                  }
            }
      }

      public static void addItemToMenus(ArrayList<String> L_id, ArrayList<String> L_Table) {
            MIActionListener MIAL = new MIActionListener();

            JM_Select.removeAll();
            JMS_ChangeDTable.removeAll();

            Collections.sort(L_Table);

            for (int a = 0; a < L_Table.size(); a++) {
                  JM_Select.add(new JMenuItem(L_Table.get(a)));
                  JMS_ChangeDTable.add(new JMenuItem(L_id.get(a) + ": " + L_Table.get(a)));
                  //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                  JM_Select.getItem(a).addActionListener(MIAL);
                  JMS_ChangeDTable.getItem(a).addActionListener(MIAL);
            }

      }

      public static void tableDeletedState() {
            boolean b = false;
            lb_Title.setVisible(b);
            for (int a = 0; a < btns_MC.length; a++) {
                  btns_MC[a].setVisible(b);
            }
            for (int a = 0; a < lbs.length; a++) {
                  lbs[a].setVisible(b);
                  tfs[a].setVisible(b);
                  if (a != lbs.length - 1) {
                        tfs_MD[a].setVisible(b);
                        tfs_MU[a].setVisible(b);
                        lb_2ds[a].setVisible(b);
                        tfs_SD[a].setVisible(b);
                        tfs_SU[a].setVisible(b);
                        btns_C[a].setVisible(b);
                  }
            }
            lb_Icon.setVisible(b);
            JPB.setVisible(b);
      }

      public static void setLB_JTToCenter(JLabel LB, JComponent JC) {
            //System.out.println("##########setLB_JTToCenter");
            FontMetrics FM = LB.getFontMetrics(LB.getFont());

            int x = (JC.getWidth() - (int) FM.stringWidth(LB.getText())) / 2;

            int y = (FM.getAscent()
                    + (JC.getHeight() - (FM.getAscent() + FM.getDescent())) / 2);

            //System.out.println("\tJC getX: " + JC.getX());
            //System.out.println("\tX: " + x);
            //System.out.println("\tY: " + y);
            //System.out.println("\tP3 getHeight: " + VF_R.getP3().getHeight());
            LB.setLocation(JC.getX() + x, y - JC.getY());
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      private void controlBtnUpdate(ArrayList<String> list, JTextField tf) {
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
                  btns_MC[1].setEnabled(false);
            } else if (z == 0) {
                  //System.out.println("UPDATE TO TRUE");
                  btns_MC[1].setEnabled(true);
            }
      }

      //SEND TO MAINLISTENERS
      private void otherListeners() {
            /*
            MIShow_AL misal = new MIShow_AL();
            MIV_AL mival = new MIV_AL();
            for (int a = 0; a < JMS_ShowList.getItemCount(); a++) {
                  JMS_ShowList.getItem(a).addActionListener(misal);
            }
            for (int a = 0; a < JMS_ShowListeners.getItemCount(); a++) {
                  JMS_ShowListeners.getItem(a).addActionListener(misal);
            }
            mi_seeL.addActionListener(mival);
            mi_seeR.addActionListener(mival);
             */
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      private void setTableCellEditor() {
            Font f = JT.getFont();

            tf_ce.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 3));
            tf_ce.setBorder(Data.compoundBorder_N);
            tf_ce.setFont(new Font(f.getName(), f.getStyle(), f.getSize()));
            tf_ce.setMargin(new Insets(1, 2, 1, 2));

            sc_JT.setViewportView(JT);

            JT.setDefaultEditor(String.class, DTCellEditor);

            for (int i = 0; i < JT.getColumnCount(); i++) {
                  JT.getColumnModel().getColumn(i).setCellEditor(DTCellEditor);
            }
      }

      public static void setTableRenderer() {
            //System.out.println("#######setTableRenderer (column count: " + JT.getColumnCount());
            JTCellRenderer jtcr = new JTCellRenderer();

            for (int a = 0; a < JT.getColumnCount(); a++) {
                  JT.getColumnModel().getColumn(a).setCellRenderer(jtcr);
            }

            //System.out.println("+++++++++++GETFONT: " + JT.getFont());
            //System.out.println("Selection Model: " + JT.getSelectionModel().toString());
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      private void frameConfig() {
            JF.setSize(Data.defaultFrameSize);
            JF.setLayout(new BorderLayout());
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.setResizable(true);
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            menuBarConfig();
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            leftPanelConfig();
            //+++++++++++++++++++++++++++++++++++++++++++++
            tableConfig();
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            statusPanelConfig();
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //IF - WISH LAYOUT TO USE ON P1

            //IF - WISH LAYOUT TO USE ON P1
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            toolbarConfig();
            //++++++++++++++++++++++++++++++++++++++

            //++++++++++++++++++
            setNameToComponents();

      }

      private void leftPanelConfig() {
            JF.add(SPL, BorderLayout.CENTER);
            SPL.setOneTouchExpandable(true);
            SPL.setPreferredSize(new Dimension(500, SPL.getPreferredSize().height));
            SPL.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
            SPL.setLeftComponent(PL);
            SPL.setRightComponent(sc_JT);

            //sc_p1.setFocusable(false);
            //sc_p1.setEnabled(false);
            //sc_p1.setBounds(2, 22, 446, 522);
            //sc_p1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            //sc_p1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
            //p1.setSize(446, 521);
            PL.setPreferredSize(new Dimension(460, PL.getPreferredSize().height));
            //PL.setBackground(Color.BLACK);
            PL.setFocusable(false);

            PL.setLayout(new BorderLayout());
            PL.add(PL_T, BorderLayout.NORTH);
            PL_T.setLayout(new BoxLayout(PL_T, BoxLayout.X_AXIS));
            PL_T.setBackground(Color.BLACK);
            PL_T.setBorder(new LineBorder(Color.WHITE, 1));
            PL_T.setPreferredSize(new Dimension(PL_T.getPreferredSize().width, 40));

            PL_T.add(Box.createHorizontalStrut(10));
            PL_T.add(lb_Title);
            lb_Title.setFont(new Font("Dialog", Font.BOLD, 18));
            lb_Title.setForeground(Color.WHITE);
            lb_Title.setPreferredSize(new Dimension(
                    lb_Title.getPreferredSize().width, 27));
            
            PL.add(PL_C, BorderLayout.CENTER);
            PL_C.setBackground(Color.BLACK);
            PL_C.setBorder(new LineBorder(Color.WHITE, 1));

            setComponentsToArray();
            
            if (JPL_layout.equals("null")) {
                  PL_C.setLayout(null);

                  setComponentsSize();
                  componentsConfig();
            } else {
                  GroupLayout gl = new GroupLayout(PL_C);
                  PL.setLayout(gl);

            }
            clockConfig();
      }

      private void statusPanelConfig() {
            JF.add(p3, BorderLayout.SOUTH);
            //int y3 = sc_P1.getHeight() + 22;
            //int w3 = sc_P1.getWidth() + sc_JT.getWidth() + 40;
            //F_R.getSC_P1().getWidth() + VF_R.getSC_JT().getWidth() + 40
            //p3.setLocation(sc_P1.getX(), y3 + 1);
            //p3.setSize(w3 - 2, 40)
            p3.setPreferredSize(new Dimension(p3.getPreferredSize().width, 40));
            p3.setSize(p3.getPreferredSize());
            p3.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
            p3.setLayout(new BoxLayout(p3, BoxLayout.X_AXIS));
            p3.setBackground(Color.BLACK);
            //++++++++++++++++++++++++++++++++++++++
            p3.add(Box.createHorizontalStrut(6));
            p3.add(lb_Status);
            lb_Status.setPreferredSize(new Dimension(500, 28));//1172
            lb_Status.setMaximumSize(new Dimension(Short.MAX_VALUE, 28));
            lb_Status.setForeground(Color.WHITE);
            lb_Status.setFont(new Font("Dialog", Font.BOLD, 16));
            Border bb = BorderFactory.createBevelBorder(BevelBorder.RAISED);
            Border be = BorderFactory.createEmptyBorder(1, 6, 1, 3);
            lb_Status.setBorder(new CompoundBorder(bb, be));

            Dimension d = new Dimension(80, 28);
            Insets in = new Insets(1, 1, 1, 1);
            p3.add(Box.createHorizontalStrut(6));
            p3.add(btns_MC[2]);
            btns_MC[2].setPreferredSize(d);
            btns_MC[2].setMaximumSize(d);
            p3.add(Box.createHorizontalStrut(2));
            p3.add(btns_MC[1]);
            btns_MC[1].setPreferredSize(d);
            btns_MC[1].setMaximumSize(d);
            p3.add(Box.createHorizontalStrut(2));
            p3.add(btns_MC[3]);
            btns_MC[3].setPreferredSize(d);
            btns_MC[3].setMaximumSize(d);
            p3.add(Box.createHorizontalStrut(2));
            p3.add(btns_MC[0]);
            btns_MC[0].setPreferredSize(d);
            btns_MC[0].setMaximumSize(d);

            btns_MC[2].setMargin(in);
            btns_MC[1].setMargin(in);
            btns_MC[3].setMargin(in);
            btns_MC[0].setMargin(in);

            p3.add(Box.createHorizontalStrut(6));
            //p3.add(btn_Show_All);
            //btn_Show_All.setPreferredSize(new Dimension(80, 24));
            //btn_Show_All.setMargin(new Insets(1, 1, 1, 1));
      }

      //----------------------------------------------------------------------
      private void menuBarConfig() {
            JF.add(JMB, BorderLayout.NORTH);
            JMB.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
            JMB.setSize(JMB.getPreferredSize());
            //JMB.setBounds(0, 0, JF.getWidth() - 16, 24);
            //++++++++++++++++++++++++++++++++++++++++
            JMB.add(JM_Options);
            JM_Options.add(JMS_ShowList);
            JMS_ShowList.add(mi_STables);
            JMS_ShowList.add(mi_SColumns);
            JMS_ShowList.add(mi_SDists);
            JMS_ShowList.add(mi_SListD);
            JMS_ShowList.add(mi_SJFComponents);
            JMS_ShowList.add(mi_SP1Components);
            JM_Options.add(JMS_ShowListeners);
            JMS_ShowListeners.add(mi_S_JTFS_KL);
            JMS_ShowListeners.add(mi_S_JTFS_FL);
            JMS_ShowListeners.add(mi_S_JTFS_ML);
            JMS_ShowListeners.add(mi_S_JLSTS_LSL);
            JMS_ShowListeners.add(mi_S_JLSTS_FL);
            //System.out.println("JMS_ShowListener Count: " + JMS_ShowListeners.getItemCount());
            JM_Options.add(sep0);
            JM_Options.add(mi_AOT);
            JM_Options.add(mi_AutoR);
            JM_Options.add(mi_Grid);
            JM_Options.add(sep1);
            JM_Options.add(mi_seeL);
            JM_Options.add(mi_seeR);
            JM_Options.add(sep2);
            JM_Options.add(mi_SaveOp);
            //++++++++++++++++++++++++++++++++++++++++
            JMB.add(JM_Select);
            //++++++++++++++++++++++++++++++++++++++++
            JMB.add(JM_Table);
            JM_Table.add(JMS_ChangeDTable);
            JM_Table.add(sep3);
            JM_Table.add(mi_CreateTable);
            JM_Table.add(mi_UpdateTable);
            JM_Table.add(mi_DeleteTables);
            JM_Table.add(mi_DeleteThisTable);

      }

      private void menuBarLook() {
            //System.out.println("MTH - menuBarLook");
            Color back = new Color(32, 32, 32);
            Font F = new Font("Dialog", Font.PLAIN, 12);
            //=============================================
            //System.out.println("JM_Select: " + JM_Select.getMenuComponentCount() + "\n");
            JMB.setBackground(back);
            JMB.setForeground(Color.WHITE);

            for (int a = 0; a < JMB.getComponentCount(); a++) {
                  //System.out.println("JMB Component " + a + " - " + JMB.getComponent(a).getName());
                  JMB.getComponent(a).setForeground(Color.WHITE);

                  JMenu JM = ((JMenu) JMB.getComponent(a));

                  for (int b = 0; b < JM.getMenuComponentCount(); b++) {
                        //System.out.println("\tJM " + a + " Component " + b + " - "
                        //      + JM.getMenuComponent(b).getName());
                        //==============================================
                        String str = JM.getMenuComponent(b).getClass().toString();

                        if (str.contains("Separator")) {
                              //System.out.println("\t\tSeparator");
                              ((JSeparator) JM.getMenuComponent(b)).setOpaque(true);

                        } else if (str.endsWith("JMenu")) {
                              //++++++++++++++++++++++++++++++++
                              //System.out.println("\t\tMenu");
                              JMenu JMS = ((JMenu) JM.getMenuComponent(b));

                              JMS.setOpaque(true);
                              //JMS.setBackground(back);

                              for (int c = 0; c < JMS.getItemCount(); c++) {
                                    //System.out.println("\t\tJMS " + b + " Component " + c + " - "
                                    //      + JMS.getItem(c).getName());
                                    JMS.getItem(c).setBackground(back);
                                    JMS.getItem(c).setForeground(Color.WHITE);
                                    JMS.getItem(c).setFont(F);
                              }
                              //++++++++++++++++++++++++++++++++
                        } else {
                              //System.out.println("\t\tMenuItem");
                              ((JMenuItem) JM.getMenuComponent(b)).setOpaque(true);
                        }
                        //+++++++++++++++++++++++++++++++++++++++++++
                        JM.getMenuComponent(b).setBackground(back);
                        JM.getMenuComponent(b).setForeground(Color.WHITE);
                        JM.getMenuComponent(b).setFont(F);
                  }
            }
      }

      //----------------------------------------------------------------------
      private void tableConfig() {
            //JF.getContentPane().add(sc_JT);
            JT.setUI(new BasicTableUI());
            //int x = sc_P1.getX() + sc_P1.getWidth();
            //sc_JT.setLayout(null);
            //sc_JT.setLocation(x - 2, 22);
            sc_JT.setPreferredSize(new Dimension(300, sc_JT.getPreferredSize().height));
            sc_JT.setSize(766, 522);
            sc_JT.setVerticalScrollBarPolicy(22);
            //sc_JT.setPreferredSize(new Dimension(764, 522));
            PT.setLayout(null);
            PT.setPreferredSize(new Dimension(300, PT.getPreferredSize().height));
            PT.setBackground(Color.RED);
            //PT.setBounds(2, 2, 769, 518);
            PT.add(JT);
            JT.setBounds(6, 6, 758, 516);
            //JT.setPreferredSize(new Dimension(758, JT.getHeight()));
            JT.setBackground(Color.BLACK);
            JT.setFont(new Font("Dialog", Font.PLAIN, 20));
            JT.setRowHeight(23);
            //JT.setForeground(Color.WHITE);
            JT.setAutoCreateRowSorter(true);
            JT.setGridColor(Color.GRAY);
            JT.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JT.setRowSelectionAllowed(true);
            JT.setSelectionBackground(DT.TFColor[2]);
            //JT.setPreferredScrollableViewportSize();
            JT.setPreferredScrollableViewportSize(PT.getPreferredSize());
            //System.out.println("PT size: " + PT.getSize());
            //System.out.println("SC_JT size: " + sc_JT.getSize());
            //System.out.println("JT size: " + JT.getSize());
            //+++++++++++++++++++++++++++++++++++++++++++++
            //JF.add(lb_JT);
            lb_JT.setVisible(false);
            lb_JT.setSize(600, 70);
            lb_JT.setForeground(Color.BLACK);
            lb_JT.setFont(new Font("Dialog", Font.BOLD, 40));
            setLB_JTToCenter(lb_JT, sc_JT);
      }

      public static void noRowsDetection() {
            System.out.print(CC.CYAN + "MAIN +++++ noRowsDetection: " + CC.RESET);
            if (JT.getRowCount() == 0) {
                  sc_JT.setVisible(false);
                  lb_JT.setVisible(true);
                  System.out.println(CC.CYAN + "NO" + CC.RESET);
                  System.out.println("\tlb_JT visible: " + lb_JT.isVisible());
                  System.out.println("\tlb_JT Location: " + lb_JT.getLocation());
            } else {
                  sc_JT.setVisible(true);
                  lb_JT.setVisible(false);
                  System.out.println(CC.CYAN + "YES" + CC.RESET);
            }
      }

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

            CK_FL CF = new CK_FL();
            //System.out.println("tfs Heights: " + tf_h);
            Font FT = new Font("Dialog", Font.BOLD, 20);
            Font FL = new Font("Dialog", Font.BOLD, 26);
            Color[] c = {new Color(51, 51, 51), Color.WHITE};

            for (int a = 0; a < tfs_MD.length; a++) {//a: 0 to 4   b: 1 to 5
                  PL_C.add(tfs_MD[a]);
                  PL_C.add(tfs_MU[a]);
                  PL_C.add(tfs_SD[a]);
                  PL_C.add(tfs_SU[a]);
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

                  tfs_MD[a].addFocusListener(CF);
                  tfs_MU[a].addFocusListener(CF);
                  tfs_SD[a].addFocusListener(CF);
                  tfs_SU[a].addFocusListener(CF);
                  //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                  PL_C.add(lb_2ds[a]);
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
            btns_TB[0].addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent evt) {
                        //JT.getColumn(0);
                        System.out.println("\nPRESS");

                        //++++++++++++++++++++++++++++++++++++++++++++
                        if (tfs[1].isShowing()) {
                              System.out.println("\tShowing...");
                        }
                        /*
                        Border bor = tfs[1].getBorder();
                        Graphics g = tfs[1].getGraphics();
                        System.out.println(g.toString());

                        bor.paintBorder(tfs[1], g, 0, 0, tfs[1].getWidth() + 2, tfs[1].getHeight() + 2);
                        g.setColor(Color.RED);
                         */
                  }
            });
      }

      private void toolbarConfig() {
            MetalToolBarUI mtbUI = new MetalToolBarUI();
            //UIManager.getDefaults()
            //System.out.println("UIManager AuxiliaryLookAndFeels: " 
            //      + UIManager.getLookAndFeel());
            JF.add(TB, BorderLayout.EAST);
            TB.setOrientation(JToolBar.VERTICAL);
            Dimension d = new Dimension(44, TB.getPreferredSize().height);
            TB.setMinimumSize(d);
            TB.setPreferredSize(d);
            TB.setMaximumSize(d);
            TB.setSize(d);
            TB.setUI(mtbUI);
            //TB.setUI(new BasicToolBarUI());
            //int x_tb = sc_P1.getWidth() + sc_JT.getWidth() - 2;
            TB.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
            TB.setLayout(null);
            //TB.setBounds(x_tb, 22, 42, sc_JT.getHeight());
            TB.setBackground(Color.BLACK);
            TB.setFloatable(false);

            //System.out.println("Toolbar UI: " + TB.getUI());
            //MetalButtonUI mbUI = new MetalButtonUI();
            TB.add(btns_TB[0]);
            btns_TB[0].setBounds(6, 8, 32, 30);//+30Y
            btns_TB[0].setEnabled(true);
            //mm.setImageIcon(btns_TB[0], "C:\\C0F\\Image\\X Icons\\H small.png");
            //+++++++++++++++++++++++++++++++
            //System.out.println("BTNS_MC BG: " + btns_MC[0].getBackground());
            Insets in = new Insets(1, 1, 1, 1);
            TB.add(btn_minus);
            TB.add(btn_plus);
            //btn_minus.setUI(mbUI);
            btn_minus.setBounds(6, 44, 32, 20);
            btn_minus.setMargin(in);
            //btn_plus.setUI(mbUI);
            btn_plus.setBounds(6, 70, 32, 20);
            btn_plus.setMargin(in);
            //btn_minus.setBackground(new ColorUIResource(238,238,238));
            //btn_plus.setBackground(null);

            actionTBComponents();
            //System.out.println("sc_JT Height: " + sc_JT.getHeight());
            //System.out.println("TB Bounds: " + TB.getBounds());
            //System.out.println("btn hide_id Bounds: " + hide_id.getBounds());
      }

      private void componentsConfig() {
            /*
            lbs[0].setBounds(6, 38, 100, 27);
            tfs[0].setBounds(107, 38, 70, 27);

            lbs[1].setBounds(6, 72, 120, 27);
            tfs[1].setBounds(107, 72, 290, 27);
             */

            
            //+++++++++++++++++++++++++
            lb_Title.setVisible(true);
            lbs[0].setVisible(true);
            lbs[1].setVisible(true);
            tfs[0].setVisible(true);
            tfs[0].setBackground(new Color(51, 0, 0));
            tfs[1].setVisible(true);

            scs[0].setVisible(false);
            scs[1].setVisible(false);
            scs[2].setVisible(false);
            scs[3].setVisible(false);
            scs[4].setVisible(false);
            //+++++++++++++++++++++++++++++++++++++++++
            PL_C.add(lb_Icon);
            lb_Icon.setFont(new Font("Dialog", Font.PLAIN, 24));
            lb_Icon.setSize(225, 225);
            float f = (sc_P1.getWidth() / 2) - (lb_Icon.getWidth() / 2);
            lb_Icon.setBounds((int) f, 500, 225, 225);
            lb_Icon.setForeground(Color.WHITE);
            lb_Icon.setHorizontalAlignment(0);
            lb_Icon.setVerticalTextPosition(0);
            lb_Icon.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

            PL_C.add(JPB);
            JPB.setBounds(lb_Icon.getX(), lb_Icon.getY() - 8,
                    lb_Icon.getWidth(), 18);
            JPB.setBackground(Color.BLACK);
            JPB.setForeground(Color.RED);
            JPB.setMinimum(0);
            JPB.setVisible(false);
            //+++++++++++++++++++++++++++++++++++++++++++++
            //System.out.println("Graphic needed: 73 225
            //+++++++++++++++++++++++++++++++++++++++++++++
            btns_MC[1].setEnabled(false);
            btns_MC[2].setEnabled(false);
      }

      private void mcButtonsConfig() {
            /*
            Insets in = new Insets(1, 1, 1, 1);

            PL.add(btns_MC[2]);
            PL.add(btns_MC[1]);
            PL.add(btns_MC[3]);
            PL.add(btns_MC[0]);
            //btns_MC[2].setBounds(231, 9, 80, 23);
            //btns_MC[1].setBounds(317, 9, 80, 23);
            //btns_MC[3].setBounds(231, 40, 80, 23);
            //btns_MC[0].setBounds(317, 40, 80, 23);
            btns_MC[2].setMargin(in);
            btns_MC[1].setMargin(in);
            btns_MC[3].setMargin(in);
            btns_MC[0].setMargin(in);
             */
      }

      private void setComponentsToArray() {
            lbs = new JLabel[DT.maxColumns];
            //=================================
            tfs = new JTextField[DT.maxColumns];
            //+++++++++++++++++++++
            int disLY = 0;
            int disTY = 0;
            for (int a = 0; a < DT.maxColumns; a++) {
                  lbs[a] = new smallLB();
                  tfs[a] = new smallTF();
            }
            //================================
            scs = new JScrollPane[DT.maxColumns - 1];
            //+++++++++++++++++++++++++++++
            lsts = new JList[DT.maxColumns - 1];
            //+++++++++++++++++++++++++++++
            btns_C = new JButton[DT.maxColumns - 1];
            //+++++++++++++++++++++++++++++
            for (int a = 0; a < DT.maxColumns - 1; a++) {
                  lsts[a] = new smallLST();
                  scs[a] = new JScrollPane(lsts[a]);
                  scs[a].setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
                  scs[a].setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

                  btns_C[a] = new smallBTN_C(null);
            }
            //++++++++++++++++++++++++++++++++++++++
            
      }

      private void setComponentsSize() {
            int disLY = 0;
            int disTY = 0;
            for (int a = 0; a < DT.maxColumns; a++) {
                  PL_C.add(lbs[a]);
                  PL_C.add(tfs[a]);

                  lbs[a].setBounds(6, 38 + disLY, 100, 27);
                  if (a == 0) {
                        lbs[a].setText("1. Id");
                        tfs[a].setBounds(107, 38, 110, 27);
                  } else {
                        tfs[a].setBounds(107, 72 + disTY, 290, 27);
                        disTY += 33;
                  }
                  disLY += 33;
            }

            for (int a = 0; a < DT.maxColumns - 1; a++) {
                  scs[a].setSize(290, 170);

                  PL_C.add(scs[a]);
                  PL_C.add(btns_C[a]);

                  btns_C[a].setLocation(402, tfs[a + 1].getY());
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      private void setNameToMenus() {
            JMB.setName("JMB");

            JM_Options.setName("JM_Options");
            //++++++++++++++++++++++++++
            JMS_ShowList.setName("JMS_ShowList");
            mi_STables.setName("mi_STables");
            mi_SColumns.setName("mi_SColumns");
            mi_SDists.setName("mi_SDists");
            mi_SListD.setName("mi_SListD");
            mi_SJFComponents.setName("mi_SJFComponents");
            mi_SP1Components.setName("mi_SP1Components");
            //++++++++++++++++++++++++++
            JMS_ShowListeners.setName("JMS_ShowListeners");
            mi_S_JTFS_FL.setName("mi_S_JTFS_FL");
            mi_S_JTFS_KL.setName("mi_S_SJTFS_KL");
            mi_S_JTFS_ML.setName("mi_S_JTFS_ML");
            mi_S_JLSTS_FL.setName("mi_S_JLSTS_FL");
            mi_S_JLSTS_LSL.setName("mi_S_JLSTS_LSL");
            //++++++++++++++++++++++++++
            mi_AOT.setName("mi_AOT");
            mi_AutoR.setName("mi_AutoR");
            mi_Grid.setName("mi_Grid");
            mi_seeL.setName("mi_seeL");
            mi_seeR.setName("mi_seeR");
            mi_SaveOp.setName("mi_SaveOp");
            //++++++++++++++++++++++++++
            JM_Select.setName("JM_Select");
            //++++++++++++++++++++++++++
            JM_Table.setName("JM_Table");
            JMS_ChangeDTable.setName("JMS_ChangeDTable");
            //++++++++++++++++++++++++++
            mi_CreateTable.setName("mi_CreateTable");
            mi_UpdateTable.setName("mi_UpdateTable");
            mi_DeleteTables.setName("mi_DeleteTables");
            mi_DeleteThisTable.setName("mi_DeleteThisTable");
            //++++++++++++++++++++++++++
            sep0.setName("sep0");
            sep1.setName("sep1");
            sep2.setName("sep2");
            sep3.setName("sep3");
      }

      private void setNameToComponents() {
            sc_P1.setName("SC_P1");
            SPL.setName("SPL");
            PL.setName("PL");
            PL_T.setName("PL_T");
            PL_C.setName("PL_C");
            p3.setName("P3");
            sc_JT.setName("SC_JT");
            JT.setName("JT");
            //+++++++++++++++++++++++++++++++
            setNameToMenus();
            //+++++++++++++++++++++++++++++++
            TB.setName("TB");
            //+++++++++++++++++++++++++++++++
            lb_Title.setName("lb_Title");
            lb_Icon.setName("lb_Icon");
            JPB.setName("JPB");
            //+++++++++++++++++++++++++++++++++++++++
            btns_TB[0].setName("BTN_H");
            btn_minus.setName("btn_minus");
            btn_plus.setName("btn_plus");
            btns_MC[0].setName("BTN_ADD");
            btns_MC[1].setName("BTN_UPD");
            btns_MC[2].setName("BTN_DEL");
            btns_MC[3].setName("BTN_FIND");
            //+++++++++++++++++++++++++++++++++++++++
            //System.out.println("lbs Length: " + lbs.length);
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
            JM_Select.setName("JM_Select");
            JMS_ChangeDTable.setName("mi_OP_Change");
            //mi_SaveOp.setName();
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      private void testConfig() {
            VT vt = new VT();
            JTextField tf = new JTextField();
            vt.add(tf);
            JButton btn = new JButton("SET");
            vt.add(btn);
            JButton btn2 = new JButton("GET");
            vt.add(btn2);
            JButton btn3 = new JButton("PREF SIZE");
            vt.add(btn3);
            JButton btn4 = new JButton("JF COMPONENTS");
            vt.add(btn4);

            btn.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        SPL.setDividerLocation(0.4);
                        JF.revalidate();
                        JF.repaint();
                  }

            });
            btn2.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        System.out.println("PreferredSize: "
                                + btns_MC[2].getPreferredSize());
                        System.out.println("MaxSize: "
                                + btns_MC[2].getMaximumSize());
                  }

            });
            btn3.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {

                        System.out.println("SPL pref W: " + SPL.getPreferredSize().width);
                        System.out.println("TB pref W: " + TB.getPreferredSize().width);
                        System.out.println("JF W: " + JF.getWidth());

                        SPL.setPreferredSize(new Dimension(400, SPL.getPreferredSize().height));
                  }

            });
            btn4.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        for (int a = 0; a < JF.getContentPane().getComponentCount(); a++) {
                              if (JF.getContentPane().getLayout() instanceof BorderLayout) {
                                    System.out.println(JF.getContentPane().getComponent(a).getName() + ": "
                                            + ((BorderLayout) JF.getContentPane().getLayout()).getConstraints(
                                                    JF.getContentPane().getComponent(a)));
                              } else {
                                    System.out.println(JF.getClass().toString() + " "
                                            + "is not instanceof BorderLayout");
                              }
                        };
                  }

            });
            vt.pack();
            vt.setVisible(true);

      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public VF_R() {
            System.out.println(CC.CYAN + "CLASS ### MAIN" + CC.RESET);
            frameConfig();
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //ADDING ITEM TO THE JMENU FROM TABLE_NAMES+++++++++++++++++
            System.out.println(CC.CYAN + "\nMAIN +++++ SELECT TABLES" + CC.RESET);
            mc.SelectTables();

            //SELECTING DEFAULT TABLE++++++++++++++++++++++++
            if (getDefault == true) {
                  System.out.println(CC.CYAN + "MAIN +++++ SELECT DEFAULT TABLE" + CC.RESET);
                  mc.SelectDefaultTable();
            } else {

            }
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++
            addItemToMenus(DT.getList_id(), DT.getList_T());
            menuBarLook();
            setColorToDItem(DT.getTable(), DT.getDTable());
            //menuFont();
            //ADDING COLUMNS AND ROWS FROM DEFAULT_TABLE++++++++++++++++++
            DT.setTable(MText.filterTextName(DT.getTable(), "ADD"));

            System.out.println(CC.CYAN + "MAIN +++++ SELECT COLUMNS AND ROWS" + CC.RESET);
            mc.SelectColumns(DT.getTable());
            //--------------------------------------------------------------------------------------------------------------------
            System.out.println(CC.CYAN + "MAIN +++++ ChangeLB_TF" + CC.RESET);
            cp.changeLB_TF(JT.getColumnCount(), DT.getList_C());
            noRowsDetection();
            System.out.println(CC.CYAN + "MAIN +++++ addKeyListenerToTFS" + CC.RESET);

            System.out.println(CC.CYAN + "MAIN +++++ ChangeLSTD" + CC.RESET);
            lstd.changeLSTD(DT.getTable(), DT.getDist1(), DT.getDist2(), DT.getTabl(), DT.getTag(),
                    DT.getClock());
            //--------------------------------------------------------------------------------------------------------------------
            System.out.println(CC.CYAN + "MAIN +++++ SELECT CONFIG" + CC.RESET);
            mc.SelectConfig();
            //System.out.println("\tAOT BL: " + dt.getList_BL().get(0));
            mi_AOT.setSelected(DT.getList_BL().get(0));
            JF.setAlwaysOnTop(DT.getList_BL().get(0));

            //System.out.println("\tAutoR BL: " + dt.getList_BL().get(1));
            mi_AutoR.setSelected(DT.getList_BL().get(1));
            n_mm.rez(JT, DT.getList_BL().get(1));
            DT.autoState = DT.getList_BL().get(1);

            //System.out.println("\tGrid BL: " + dt.getList_BL().get(2));
            mi_Grid.setSelected(DT.getList_BL().get(2));
            JT.setShowGrid(DT.getList_BL().get(2));
            //----------------------------------------------------------------------------------------------------------------------
            mi_seeL.setSelected(true);
            mi_seeR.setSelected(true);
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++        
            System.out.println(CC.CYAN + "MAIN +++++ addAllListenerToCJS" + CC.RESET);
            ml.addAllListenerLoop();
            ml.addAllListener();
            otherListeners();
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++        
            setTableCellEditor();
            setTableRenderer();
            //*++++++++++++++++++++++++++++++++++++++++++++++++++++
            //System.out.println("\nHeap Size: \t" + Runtime.getRuntime().totalMemory());
            //System.out.println("Heap Max Size: \t" + Runtime.getRuntime().maxMemory());
            //System.out.println("Heap Free Size: \t" + Runtime.getRuntime().freeMemory());
            //*++++++++++++++++++++++++++++++++++++++++++++++++++++
            mi_SJFComponents.setText(mi_SJFComponents.getText() + " ("
                    + JF.getContentPane().getComponentCount() + ")");
            mi_SP1Components.setText(mi_SP1Components.getText() + " ("
                    + PL_C.getComponentCount() + ")");
            //*++++++++++++++++++++++++++++++++++++++++++++++++++++          
            testConfig();
            SPL.setDividerLocation(0.4);
            SPL.revalidate();
            SPL.repaint();
            System.out.println(CC.CYAN + "MAIN +++++ END\n" + CC.RESET);
            //System.out.println("Table: " + dt.getTable());
      }

      public VF_R(String table) {
            System.out.println("S: " + table);
            frameConfig();

            mc.SelectTables();
            addItemToMenus(DT.getList_id(), DT.getList_T());

            mc.SelectConfig();
            mi_AOT.setSelected(DT.getList_BL().get(0));
            JF.setAlwaysOnTop(DT.getList_BL().get(0));

            mi_AutoR.setSelected(DT.getList_BL().get(1));
            n_mm.rez(JT, DT.getList_BL().get(1));
            DT.autoState = DT.getList_BL().get(1);

            mi_Grid.setSelected(DT.getList_BL().get(2));
            JT.setShowGrid(DT.getList_BL().get(2));

      }

      public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                  public void run() {
                        VF_R vf = new VF_R();
                        vf.getJF().setVisible(true);

                  }
            });

      }
}
