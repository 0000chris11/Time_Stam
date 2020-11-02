package First;

import static First.VF_R_DataCom.JF;
import static First.VF_R_DataCom.JT;
import static First.VF_R_DataCom.btn_plus;
import static First.VF_R_DataCom.btns_MC;
import static First.VF_R_DataCom.lb_Status;
import static First.VF_R_DataCom.tfs;
import smallComponenets.smallLB;
import MC.DT;
import MC.CompReset;
import MC.notMyMethods;
import MC.MakeCon;
import MC.Status;
import First.Listeners.MainListeners_F;
import First.Listeners.JTChanged_AL;
import First_Old.CK_FL;
import com.cofii.myMethods.MText;
import com.cofii.myClasses.CC;
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
import SQLActions.SelectColumns;
import com.cofii.myClasses.MLayout;
import com.cofii.myMethods.MTable;
import Others.LimitTextD;
import Others.JTCellRenderer;
import Others.LSTD;
import SQLActions.SelectTables;
import com.cofii.myClasses.MSQL;
import static First.VF_R_DataCom.PL_U;
import static First.VF_R_DataCom.SPL_SUB;
import SQLActions.SelectConfig;
import SQLActions.SelectDefaultTable;

/**
 *
 * @author C0FII
 */
public class VF_R extends VF_R_DataCom {

      //Connection con;
      String CName = this.getClass().getName();

      //MethodM mm = new MethodM(CName, DT.CCount++);
      CompReset cp = new CompReset();
      notMyMethods n_mm = new notMyMethods();
      MainListeners_F ml = new MainListeners_F();
      LSTD lstd = new LSTD();
      Threads th = new Threads(CName, DT.CCount++);
      //ArraysM am = new ArraysM();
      MakeCon mc = new MakeCon(CName, DT.CCount++);
      MSQL ms = new MSQL(DT.urlConnection, DT.user, DT.passw);
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
            JTChanged_AL MIAL = new JTChanged_AL();

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
            for (int a = 0; a < DT.maxColumns; a++) {
                  lbs[a].setVisible(b);
                  tfs[a].setVisible(b);

                  clocks[a].setVisible(b);
                  btns_C[a].setVisible(b);

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
            tf_ce.setBorder(DT.compoundBorder_N);
            tf_ce.setFont(new Font(f.getName(), f.getStyle(), f.getSize()));
            tf_ce.setMargin(new Insets(1, 2, 1, 2));

            //sc_JT.setViewportView(JT);
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
            JF.setSize(DT.defaultFrameSize);
            JF.setLayout(new BorderLayout());
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.setResizable(true);
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            menuBarConfig();
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            splitConfig();
            //+++++++++++++++++++++++++++++++++++++++++++++
            tableConfig();
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            statusPanelConfig();
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            toolbarConfig();
            //++++++++++++++++++++++++++++++++++++++
            setNameToComponents();

      }

      private void splitConfig() {
            JF.add(SPL, BorderLayout.CENTER);
            SPL.setOneTouchExpandable(true);
            SPL.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
            SPL.setLeftComponent(SPL_SUB);
            SPL.setRightComponent(sc_JT);

            SPL_SUB.setOneTouchExpandable(true);
            SPL_SUB.setTopComponent(PL_U);
            SPL_SUB.setBottomComponent(sc_PL_B);
            //+++++++++++++++++++++++++++++++++++++++++++++
            subSplitUpConfig();
            subSplitDownConfig();
            //*++++++++++++++++++++++++++++++++++++++++++++
            setComponentsToArray();
            componentsVisibility();
            //++++++++++++++++++++++++++
            if (JPL_layout.equals("null")) {
                  System.out.println("\tNull Layout for LeftPanel");
                  PL_UC.setLayout(null);
                  setNullLayoutComponentsSize();
            } else {
                  System.out.println("\tGroup Layout for LeftPanel");
                  GroupLayout gl = new GroupLayout(PL_UC);
                  PL_UC.setLayout(gl);

                  MLayout ml = new MLayout(gl, DT.maxColumns);
                  ml.useFiveAndOneSequence(lbs, tfs, clocks, scs, btns_C);
            }
            clockConfig();
            splitSizeConfig();
      }

      private void splitSizeConfig() {
            //SPL.setPreferredSize(new Dimension(500, SPL.getPreferredSize().height));

            //SPL_SUB.setPreferredSize(new Dimension(460, 700));
            //PL_U.setPreferredSize(new Dimension(PL_U.getPreferredSize().width, 450));
            //sc_PL_B.setPreferredSize(new Dimension(sc_PL_B.getPreferredSize().width, 250));
            //sc_JT.setPreferredSize(new Dimension(400, sc_JT.getPreferredSize().height));
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //SPL.setDividerLocation(0.4);
            //SPL.revalidate();
            //SPL.repaint();
            SPL_SUB.setDividerLocation(0.6);
            SPL_SUB.revalidate();
            SPL_SUB.repaint();
      }

      private void subSplitUpConfig() {
            PL_U.setLayout(new BorderLayout());
            PL_U.add(PL_UT, BorderLayout.NORTH);
            PL_U.add(sc_PL_UC, BorderLayout.CENTER);

            //PL_U+++++++++++++++++++++++++++++++++++++++++
            PL_UT.setLayout(new BoxLayout(PL_UT, BoxLayout.X_AXIS));
            PL_UT.setBackground(Color.BLACK);
            PL_UT.setBorder(new LineBorder(Color.WHITE, 1));
            PL_UT.setMaximumSize(new Dimension(PL_UT.getPreferredSize().width, 40));

            PL_UT.add(Box.createHorizontalStrut(10));
            PL_UT.add(lb_Title);
            lb_Title.setFont(new Font("Dialog", Font.BOLD, 18));
            lb_Title.setForeground(Color.WHITE);
            lb_Title.setPreferredSize(new Dimension(
                    lb_Title.getPreferredSize().width, 27));

            //PL_U+++++++++++++++++++++++++++++++++++++++++
            sc_PL_UC.setPreferredSize(new Dimension(sc_PL_UC.getPreferredSize().width, 450));
            sc_PL_UC.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            Dimension d = new Dimension(PL_UC.getPreferredSize().width, 1000);
            PL_UC.setMinimumSize(d);
            PL_UC.setPreferredSize(d);
            PL_UC.setMaximumSize(d);
            PL_UC.setBackground(Color.BLACK);
            PL_UC.setBorder(new LineBorder(Color.WHITE, 1));

      }

      private void subSplitDownConfig() {
            sc_PL_B.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            sc_PL_B.setPreferredSize(new Dimension(sc_PL_B.getPreferredSize().width, 250));
            PL_B.setLayout(new BorderLayout());
            //PL_B.setPreferredSize(new Dimension(sc_PL_B.getPreferredSize().width));
            PL_B.setBackground(Color.BLACK);
            PL_B.add(lb_Icon, BorderLayout.CENTER);
            PL_B.add(JPB, BorderLayout.SOUTH);

            //PL_B+++++++++++++++++++++++++++++++++++++++++
            PL_B.add(lb_Icon);
            lb_Icon.setPreferredSize(new Dimension(225, 255));
            lb_Icon.setFont(new Font("Dialog", Font.PLAIN, 24));
            lb_Icon.setForeground(Color.WHITE);
            lb_Icon.setHorizontalAlignment(0);
            lb_Icon.setVerticalTextPosition(0);
            lb_Icon.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

            PL_B.add(JPB);
            JPB.setMaximumSize(new Dimension(Short.MAX_VALUE, 26));
            JPB.setBackground(Color.BLACK);
            JPB.setForeground(Color.RED);
            JPB.setMinimum(0);

            lb_Icon.setVisible(true);
            JPB.setVisible(true);
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

            JM_Options.add(sep0);
            JM_Options.add(mi_AOT);
            JM_Options.add(mi_AutoR);
            JM_Options.add(mi_Grid);
            JM_Options.add(sep1);
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
            JT.setUI(new BasicTableUI());

            //sc_JT.setSize(766, 522);
            sc_JT.setVerticalScrollBarPolicy(22);

            //JT.setBounds(6, 6, 758, 516);
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
            //JT.setPreferredScrollableViewportSize(PT.getPreferredSize());
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
            int tf_h = tfs[0].getHeight() - 4;
            Font FT = new Font("Dialog", Font.BOLD, 20);
            Font FL = new Font("Dialog", Font.BOLD, 26);
            Color[] c = {new Color(51, 51, 51), Color.WHITE};
            Dimension cks = new Dimension(30, tf_h);
            Dimension cks2 = new Dimension(10, tf_h);
            int tfCW = 160;

            for (int a = 0; a < DT.maxColumns; a++) {//a: 0 to 4   b: 1 to 5
                  clocks[a] = new JPanel();
                  PL_UC.add(clocks[a]);
                  clocks[a].setLayout(new BoxLayout(clocks[a], BoxLayout.X_AXIS));
                  clocks[a].setBackground(Color.DARK_GRAY);
                  clocks[a].setSize(200, tf_h);
                  clocks[a].setLocation(tfs[a].getX() + tfCW + 4, tfs[a].getY());
                  //++++++++++++++++++++++++++++++
                  tfs_MD[a] = new JTextField("0");
                  tfs_MU[a] = new JTextField("0");
                  lb_2ds[a] = new JLabel(":");
                  tfs_SD[a] = new JTextField("0");
                  tfs_SU[a] = new JTextField("0");
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
                  tfs_MD[a].setPreferredSize(cks);
                  tfs_MD[a].setMaximumSize(cks);
                  tfs_MU[a].setPreferredSize(cks);
                  tfs_MU[a].setMaximumSize(cks);
                  tfs_SD[a].setPreferredSize(cks);
                  tfs_SD[a].setMaximumSize(cks);
                  tfs_SU[a].setPreferredSize(cks);
                  tfs_SU[a].setMaximumSize(cks);
                  //+++++++++++++++++++++++++++++++++++++
                  clocks[a].setVisible(false);
                  //+++++++++++++++++++++++++++++++
                  ((AbstractDocument) tfs_MD[a].getDocument()).setDocumentFilter(
                          new LimitTextD("D"));
                  ((AbstractDocument) tfs_MU[a].getDocument()).setDocumentFilter(
                          new LimitTextD("U"));
                  ((AbstractDocument) tfs_SD[a].getDocument()).setDocumentFilter(
                          new LimitTextD("D"));
                  ((AbstractDocument) tfs_SU[a].getDocument()).setDocumentFilter(
                          new LimitTextD("U"));

                  CK_FL CF = new CK_FL();
                  tfs_MD[a].addFocusListener(CF);
                  tfs_MU[a].addFocusListener(CF);
                  tfs_SD[a].addFocusListener(CF);
                  tfs_SU[a].addFocusListener(CF);
                  //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                  lb_2ds[a].setPreferredSize(cks2);
                  lb_2ds[a].setMaximumSize(cks2);
                  lb_2ds[a].setFont(FL);
                  lb_2ds[a].setForeground(Color.WHITE);
                  lb_2ds[a].setHorizontalTextPosition(0);
                  lb_2ds[a].setVisible(false);
            }
            for (int a = 0; a < DT.maxColumns; a++) {
                  for (int b = 0; b < DT.maxColumns; b++) {
                        clocks[a].add(tfs_MD[b]);
                        clocks[a].add(tfs_MU[b]);
                        clocks[a].add(lb_2ds[b]);
                        clocks[a].add(tfs_SD[b]);
                        clocks[a].add(tfs_SU[b]);
                  }
                  clocks[a].setSize(130, tf_h);
            }
      }

      private void actionTBComponents() {
            btns_TB[0].addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent evt) {
                        //JT.getColumn(0);
                        System.out.println("\nPRESS");
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

      private void componentsVisibility() {
            /*
            lbs[0].setBounds(6, 38, 100, 27);
            tfs[0].setBounds(107, 38, 70, 27);

            lbs[1].setBounds(6, 72, 120, 27);
            tfs[1].setBounds(107, 72, 290, 27);
             */
            //+++++++++++++++++++++++++
            lb_Title.setVisible(true);

            for (int a = 0; a < DT.maxColumns; a++) {
                  scs[a].setVisible(false);
            }
            //+++++++++++++++++++++++++++++++++++++++++++++
            btns_MC[1].setEnabled(false);
            btns_MC[2].setEnabled(false);
      }

      private void setComponentsToArray() {
            //=================================
            for (int a = 0; a < DT.maxColumns; a++) {
                  lbs[a] = new smallLB();
                  tfs[a] = new smallTF();
            }
            //================================
            for (int a = 0; a < DT.maxColumns; a++) {
                  lsts[a] = new smallLST();
                  scs[a] = new JScrollPane(lsts[a]);

                  scs[a].setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
                  scs[a].setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

                  btns_C[a] = new smallBTN_C(null);
            }
            //++++++++++++++++++++++++++++++++++++++

      }

      private void setNullLayoutComponentsSize() {
            int disLY = 0;
            int disTY = 0;
            System.out.println(SPL.getBackground());
            for (int a = 0; a < DT.maxColumns; a++) {
                  PL_UC.add(lbs[a]);
                  PL_UC.add(tfs[a]);

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

                  PL_UC.add(scs[a]);
                  PL_UC.add(btns_C[a]);

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
            sep3.setName("sep3");
      }

      private void setNameToComponents() {
            SPL.setName("SPL");
            PL_U.setName("PL");
            PL_UT.setName("PL_T");
            PL_UC.setName("PL_C");
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
            for (int a = 0; a < DT.maxColumns; a++) {
                  lbs[a].setName("LB_" + (a + 1));
                  tfs[a].setName("TF_" + (a + 1));
                  scs[a].setName("SC_" + (a + 1));
                  lsts[a].setName("LST_" + (a + 1));
                  btns_C[a].setName("BTNC_" + (a + 1));

                  clocks[a].setName("Clock_" + (a + 1));
                  tfs_MD[a].setName("TF_MD_" + (a + 1));
                  tfs_MU[a].setName("TF_MU_" + (a + 1));
                  tfs_SD[a].setName("TF_SD_" + (a + 1));
                  tfs_SU[a].setName("TF_SU_" + (a + 1));
                  lb_2ds[a].setName("LB_2D_" + (a + 1));
            }
            //++++++++++++++++++++++++++++++++
            JM_Select.setName("JM_Select");
            JMS_ChangeDTable.setName("mi_OP_Change");
            //mi_SaveOp.setName();
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public VF_R() {
            System.out.println(CC.CYAN + "CLASS ### MAIN" + CC.RESET);
            frameConfig();
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //ADDING ITEM TO THE JMENU FROM TABLE_NAMES+++++++++++++++++
            System.out.println(CC.CYAN + "\nMAIN +++++ SELECT TABLES" + CC.RESET);
            ms.selectData(DT.mainTable, new SelectTables());
            //SELECTING DEFAULT TABLE++++++++++++++++++++++++
            if (getDefault == true) {
                  System.out.println(CC.CYAN + "MAIN +++++ SELECT DEFAULT TABLE" + CC.RESET);
                  DT.setTable(ms.selectValueFromTable(DT.defautlTable, DT.defaultColumn, 1).toString());
                  ms.selectRowFromTable(DT.mainTable, DT.mainColumn,
                          DT.getTable().replaceAll("_", " "), new SelectDefaultTable());
            }
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++
            addItemToMenus(DT.getList_id(), DT.getList_T());
            menuBarLook();
            setColorToDItem(DT.getTable(), DT.getDTable());
            //ADDING COLUMNS AND ROWS FROM DEFAULT_TABLE++++++++++++++++++
            DT.setTable(MText.filterTextName(DT.getTable(), "ADD"));

            System.out.println(CC.CYAN + "MAIN +++++ SELECT COLUMNS AND ROWS" + CC.RESET);
            ms.selectColumns(DT.getTable(), new SelectColumns());
            //--------------------------------------------------------------------------------------------------------------------
            System.out.println(CC.CYAN + "MAIN +++++ ChangeLB_TF and SelectData" + CC.RESET);
            cp.changeLB_TF(JT.getColumnCount(), DT.getList_C());
            noRowsDetection();

            System.out.println(CC.CYAN + "MAIN +++++ ChangeLSTD" + CC.RESET);
            lstd.changeLSTD(DT.getTable(), DT.getDist1(), DT.getDist2(), DT.getTabl(), DT.getTag(),
                    DT.getClock());
            //--------------------------------------------------------------------------------------------------------------------
            System.out.println(CC.CYAN + "MAIN +++++ SELECT CONFIG" + CC.RESET);
            //mc.SelectConfig();
            //ms.selectTables(DT.configTable, new SelectConfig());
            ms.selectData(DT.configTable, new SelectConfig());
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
                    + PL_UC.getComponentCount() + ")");
            //*++++++++++++++++++++++++++++++++++++++++++++++++++++          
            System.out.println(CC.CYAN + "MAIN +++++ END\n" + CC.RESET);
            //System.out.println("Table: " + dt.getTable());
      }

      public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                  public void run() {
                        VF_R vf = new VF_R();
                        vf.getJF().setVisible(true);
                        
                        SPL.setDividerLocation(0.4);
                        //SPL.revalidate();
                        //SPL.repaint();
                        SPL_SUB.setDividerLocation(0.6);
                        //SPL_SUB.revalidate();
                        //SPL_SUB.repaint();

                        new VT_T();
                  }
            });
      }
}
