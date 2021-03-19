package views.first;

import MC.CompReset;
import MC.DT;
import MC.DTSQL;
import MC.DTT;
import MC.notMyMethods;
import SQL.DefaultConnection;
import SQL.SQLQuerys;
import SQLActions.CreateConfigTable;
import SQLActions.CreateDefaultTable;
import SQLActions.CreateMainTable;
import SQLActions.InsertConfigTable;
import SQLActions.SelectColumns;
import SQLActions.SelectConfig;
import SQLActions.SelectCurrentKeys;
import SQLActions.SelectDefaultTable;
import SQLActions.SelectKeys;
import SQLActions.SelectTables;
import SQLActions.TablesExistFQ;
import SQLStores.TableDistC;
import Threads.*;
import others2.DISTS;
import others2.LimitTextD;

import com.cofii2.components.swing.ButtonGradient;
import com.cofii2.components.swing.ComboBoxE;
import com.cofii2.components.swing.LabelCustom;
import com.cofii2.components.swing.TextFieldClock;
import com.cofii2.components.swing.TextFieldCustom;
import com.cofii2.custom.LKCustom2;
import com.cofii2.methods.MComp;
import com.cofii2.myAClasses.MLayout;
import com.cofii2.mysql.MSQL;
import com.cofii2.mysql.MSQL1;
import com.cofii2.stores.CC;
import com.cofii2.stores.IntString;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JPopupMenu.Separator;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.plaf.metal.MetalToolBarUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import static views.first.VF_R_DataCom.JMS_ShowList;
import views.first.listeners.JF_FL;
import views.first.listeners.MainListeners_F;
import views.loginMain.VL;

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
      Threads th = new Threads();
      MSQL ms = new MSQL(DTSQL.getURLConnection(), DTSQL.getUser(), DTSQL.getPassw());
      //++++++++-+++++++++++++++++++++++++++++++++++++
      private static boolean dropAddColumn = false;
      int state = 1;
      //+++++++++++++++++++++++++++++++++++++++++++++
      public static void tableDeletedState() {
            boolean b = false;
            lb_Title.setText("No table selected");
            for (int a = 0; a < btns_MC.length; a++) {
                  btns_MC[a].setEnabled(b);
            }
            for (int a = 0; a < DT.maxColumns; a++) {
                  lbs[a].setVisible(b);
                  tfPanel[a].setVisible(b);
                  
                  btns_C[a].setVisible(b);
            }
            for (JLabel x : lbs_Icons) {
                  x.setVisible(b);
            }
            lb_JT.setText("No table selected");
            SPL.setRightComponent(lb_JT);
      }

      //CONFIG++++++++++++++++++++++++++++++++++++++++++++++++++
      private void frameConfig() {
            JF.setLayout(new BorderLayout());
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.setResizable(true);
            JF.addFocusListener(new JF_FL());
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            menuBarConfig();
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            splitConfig();
            //+++++++++++++++++++++++++++++++++++++++++++++
            tableConfig();
            setDTMS();
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            statusPanelConfig();
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //toolbarConfig();
            //++++++++++++++++++++++++++++++++++++++
            setArrayListToArray();
            //++++++++++++++++++++++++++++++++++++++
            setNameToComponents();
      }

      private void splitConfig() {
            JF.add(SPL, BorderLayout.CENTER);
            SPL.setBackground(Color.BLACK);
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
            componentsConfig();
            //++++++++++++++++++++++++++

            if (JPL_layout.equals("null")) {
                  PL_UC.setLayout(null);
                  setNullLayoutComponentsSize();
                  clockNullLayout();
            } else {
                  GroupLayout gl = new GroupLayout(PL_UC);
                  PL_UC.setLayout(gl);

                  JComponent[][] components = new JComponent[DT.maxColumns][3];
                  for (int a = 0; a < 3; a++) {
                        for (int b = 0; b < DT.maxColumns; b++) {
                              if (a == 0) {
                                    components[b][a] = VF_R.getJLBS()[b];
                              } else if (a == 1) {
                                    components[b][a] = VF_R.getJTFPanel()[b];
                              } else if (a == 2) {
                                    components[b][a] = VF_R.getBTNS_C()[b];
                              }
                        }
                  }

                  //MList.printFor(components);
                  //System.out.println("Double Array Components: " + components);
                  MLayout.lineSequence(gl, components);
                  //lineSequence(gl, components);
                  componentsGroupLayout();
            }

      }

      private void subSplitUpConfig() {
            PL_U.setLayout(new BorderLayout());
            PL_U.add(PL_UT, BorderLayout.NORTH);
            PL_U.add(sc_PL_UC, BorderLayout.CENTER);

            MComp.setActionToPL_U();

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
            PL_B.setLayout(new FlowLayout());
            //PL_B.setPreferredSize(new Dimension(sc_PL_B.getPreferredSize().width));
            PL_B.setBackground(Color.BLACK);
            for (int a = 0; a < DT.maxIcons; a++) {
                  lbs_Icons[a] = new JLabel("NO ICON SELECTED");

                  PL_B.add(lbs_Icons[a]);
                  lbs_Icons[a].setPreferredSize(new Dimension(225, 255));//INITIAL SIZE
                  lbs_Icons[a].setFont(new Font("Dialog", Font.PLAIN, 24));
                  lbs_Icons[a].setForeground(Color.WHITE);
                  lbs_Icons[a].setHorizontalAlignment(0);
                  lbs_Icons[a].setVerticalTextPosition(0);
                  //lbs_Icons[a].setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
            }

            //+++++++++++++++++++++++++++++++++++++++++
            lbs_Icons[0].setVisible(true);
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
            p3.add(Box.createHorizontalStrut(6), 0);
            p3.add(lb_Status, 1);
            p3.add(Box.createHorizontalStrut(6), 2);
            p3.add(btns_MC[2], 3);
            p3.add(Box.createHorizontalStrut(6), 4);
            p3.add(btns_MC[1], 5);
            p3.add(Box.createHorizontalStrut(2), 6);
            p3.add(btns_MC[3], 7);
            p3.add(Box.createHorizontalStrut(2), 8);
            p3.add(btns_MC[0], 9);
            p3.add(Box.createHorizontalStrut(6), 10);

            lb_Status.setPreferredSize(LKCustom2.P3_1ST_COMPONENT_PREF_SIZE);//1172
            lb_Status.setMaximumSize(new Dimension(Short.MAX_VALUE, 28));
            lb_Status.setForeground(Color.WHITE);
            lb_Status.setFont(new Font("Dialog", Font.BOLD, 16));
            Border bb = BorderFactory.createBevelBorder(BevelBorder.RAISED);
            Border be = BorderFactory.createEmptyBorder(1, 6, 1, 3);
            lb_Status.setBorder(new CompoundBorder(bb, be));

            Dimension d = new Dimension(80, 28);
            Insets in = new Insets(1, 1, 1, 1);

            btns_MC[2].setPreferredSize(d);
            btns_MC[2].setMaximumSize(d);

            btns_MC[1].setPreferredSize(d);
            btns_MC[1].setMaximumSize(d);

            btns_MC[3].setPreferredSize(d);
            btns_MC[3].setMaximumSize(d);

            btns_MC[0].setPreferredSize(d);
            btns_MC[0].setMaximumSize(d);

            btns_MC[2].setMargin(in);
            btns_MC[1].setMargin(in);
            btns_MC[3].setMargin(in);
            btns_MC[0].setMargin(in);

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
            JM_Options.add(mi_changeLogin);
            JM_Options.add(mi_showTablesInfo);
            JM_Options.add(new Separator());
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
            JM_Table.add(JMS_TableOptions);
            JMS_TableOptions.add(mi_ClearValuesWhenDeleted);
            JMS_TableOptions.add(new Separator());
            JMS_TableOptions.add(mi_ReloadImageC);

            JM_Table.add(new Separator());

            JM_Table.add(JMS_ChangeDTable);
            JM_Table.add(sep3);
            JM_Table.add(mi_CreateTable);
            JM_Table.add(mi_UpdateTable);
            JM_Table.add(mi_DeleteTables);
            JM_Table.add(mi_DeleteThisTable);
            /*
            if(JMS_ShowList.getParent() instanceof JMenu){
               JMenuItem mi = (JMenuItem) JMS_ShowList;
               mi.setBackground(Color.PINK);
               mi.setForeground(Color.BLACK);
               //mi.setFont();
               
            }
            */
            JMS_ShowList.setBackground(Color.BLACK);
            JM_Options.getMenuComponent(4).setBackground(Color.BLACK);
      }
      //DELETE
      private void menuBarLook() {
            //System.out.println("MTH - menuBarLook");
            Color backgroung = Color.BLACK;
            Font F = new Font("Dialog", Font.PLAIN, 12);
            //=============================================
            JMB.setBackground(backgroung);
            JMB.setForeground(Color.WHITE);

            for (int a = 0; a < JMB.getComponentCount(); a++) {
                  JMB.getComponent(a).setForeground(Color.WHITE);

                  if (JMB.getComponent(a) instanceof JMenu) {
                        JMenu JM = ((JMenu) JMB.getComponent(a));

                        for (int b = 0; b < JM.getMenuComponentCount(); b++) {
                              String str = JM.getMenuComponent(b).getClass().toString();

                              if (str.contains("Separator")) {
                                    ((JSeparator) JM.getMenuComponent(b)).setOpaque(true);

                              } else if (str.endsWith("JMenu")) {
                                    if (JM.getMenuComponent(b) instanceof JMenu) {
                                          JMenu JMS = ((JMenu) JM.getMenuComponent(b));
                                          System.out.println("TEST JMS: " + JMS.getText());
                                          JMS.setOpaque(true);
                                          System.out.println("\tItem Count: " + JMS.getItemCount());
                                          for (int c = 0; c < JMS.getItemCount(); c++) {
                                                System.out.println("\t\t" + (a + 1) + ": " + JMS.getItem(c).getClass().toString());
                                                JMS.getItem(c).setBackground(backgroung);
                                                JMS.getItem(c).setForeground(Color.WHITE);
                                                JMS.getItem(c).setFont(F);
                                          }
                                    }

                              } else {//MENU-ITEM
                                    ((JMenuItem) JM.getMenuComponent(b)).setOpaque(true);
                              }
                              //+++++++++++++++++++++++++++++++++++++++++++
                              JM.getMenuComponent(b).setBackground(backgroung);
                              JM.getMenuComponent(b).setForeground(Color.WHITE);
                              JM.getMenuComponent(b).setFont(F);
                        }
                  }
            }
      }

      //----------------------------------------------------------------------
      private void tableConfig() {
            JT.setUI(new BasicTableUI());

            //sc_JT.setSize(766, 522);
            sc_JT.setVerticalScrollBarPolicy(22);
            sc_JT.getViewport().setBackground(Color.BLACK);

            //JT.setBounds(6, 6, 758, 516);
            //JT.setPreferredSize(new Dimension(758, JT.getHeight()));
            JT.setBackground(Color.BLACK);
            JT.setForeground(Color.WHITE);
            JT.setFont(new Font("Dialog", Font.PLAIN, 20));
            JT.setRowHeight(23);
            //JT.setForeground(Color.WHITE);
            JT.setAutoCreateRowSorter(true);
            JT.setGridColor(Color.GRAY);
            JT.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JT.setRowSelectionAllowed(true);
            JT.setSelectionBackground(LKCustom2.BK_DIST2);

            lb_JT.setSize(600, 70);
            lb_JT.setForeground(Color.BLACK);
            lb_JT.setFont(LKCustom2.FONT_BIG_LB_MESSAGE);

      }
      //DELETE
      private void setDTMS() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  DTT.getDTMS()[a] = new DefaultTableModel();
                  DT.getDLMS()[a] = new DefaultListModel();
            }
      }

      private void clockConfig() {
            int h = cbs[0].getHeight();
            Font FL = new Font("Dialog", Font.BOLD, 26);
            Dimension cks = new Dimension(30, 27);
            Dimension lb2 = new Dimension(10, 27);

            for (int a = 0; a < DT.maxColumns; a++) {
                  JTextField MD = tfs_MD[a];
                  JTextField MU = tfs_MU[a];
                  JLabel LB2D = lb_2ds[a];;
                  JTextField SD = tfs_SD[a];;
                  JTextField SU = tfs_SU[a];
                  //++++++++++++++++++++++++++++++++++++++++++++
                  MD.setBackground(LKCustom2.BK_NORMAL);
                  MU.setBackground(LKCustom2.BK_NORMAL);
                  SD.setBackground(LKCustom2.BK_NORMAL);
                  SU.setBackground(LKCustom2.BK_NORMAL);
                  MD.setFont(LKCustom2.FONT_NORMAL);
                  MU.setFont(LKCustom2.FONT_NORMAL);
                  LB2D.setFont(LKCustom2.FONT_NORMAL);
                  SD.setFont(LKCustom2.FONT_NORMAL);
                  SU.setFont(LKCustom2.FONT_NORMAL);
                  MD.setForeground(Color.WHITE);
                  MU.setForeground(Color.WHITE);
                  LB2D.setForeground(Color.WHITE);
                  SD.setForeground(Color.WHITE);
                  SU.setForeground(Color.WHITE);
                  MD.setHorizontalAlignment(0);
                  MU.setHorizontalAlignment(0);
                  SD.setHorizontalAlignment(0);
                  SU.setHorizontalAlignment(0);
                  //++++++++++++++++++++++++++++++++++++++++++
                  MD.setPreferredSize(cks);
                  MD.setMaximumSize(cks);
                  MU.setPreferredSize(cks);
                  MU.setMaximumSize(cks);
                  LB2D.setMinimumSize(new Dimension(16, 27));
                  LB2D.setPreferredSize(new Dimension(16, 27));
                  LB2D.setMaximumSize(new Dimension(16, 27));
                  SD.setPreferredSize(cks);
                  SD.setMaximumSize(cks);
                  SU.setPreferredSize(cks);
                  SU.setMaximumSize(cks);
                  //+++++++++++++++++++++++++++++++++++++
                  ((AbstractDocument) MD.getDocument()).setDocumentFilter(
                          new LimitTextD("D"));
                  ((AbstractDocument) MU.getDocument()).setDocumentFilter(
                          new LimitTextD("U"));
                  ((AbstractDocument) SD.getDocument()).setDocumentFilter(
                          new LimitTextD("D"));
                  ((AbstractDocument) SU.getDocument()).setDocumentFilter(
                          new LimitTextD("U"));

                  //CK_FL CF = new CK_FL();
                  //MD.addFocusListener(CF);
                  //MU.addFocusListener(CF);
                  //SD.addFocusListener(CF);
                  //SU.addFocusListener(CF);
                  //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                  LB2D.setPreferredSize(lb2);
                  LB2D.setMaximumSize(lb2);
                  LB2D.setFont(FL);
                  LB2D.setForeground(Color.WHITE);
                  LB2D.setHorizontalTextPosition(0);
            }

      }

      private void clockNullLayout() {
            int h = cbs[0].getHeight();
            for (int a = 0; a < DT.maxColumns; a++) {
                  //clocksPanel[a].setLocation(cbs[a].getX() + 160, cbs[a].getY());
                  //clocksPanel[a].setSize(196, h);
                  //clocks[a].setSize(130, h);
            }
      }

      private void componentsGroupLayout() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  tfPanel[a].setMinimumSize(new Dimension(100, 27));
                  tfPanel[a].setMaximumSize(new Dimension(Short.MAX_VALUE, 27));
                  btns_C[a].setMinimumSize(new Dimension(20, 27));
                  btns_C[a].setMaximumSize(new Dimension(20, 27));
            }
      }
      //DELETE
      private void actionTBComponents() {
            btns_TB[0].addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent evt) {
                        //JT.getColumn(0);
                        System.out.println("\nPRESS");
                  }
            });
      }
      //DELETE
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

            TB.add(btns_TB[0]);
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
      //DELETE
      private void setArrayListToArray() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  DT.getList_DS()[a] = new ArrayList<String>();
                  if (a != DT.maxColumns - 1) {
                        DT.getList_MXS()[a] = new ArrayList<String>();
                  }
            }
      }

      //+++++++++++++++++++++
      private void componentsConfig() {
            lb_Title.setVisible(true);
            btns_MC[1].setEnabled(false);
            btns_MC[2].setEnabled(false);

            for (int a = 0; a < DT.maxColumns; a++) {
                  lbs[a] = new LabelCustom();

                  tfPanel[a] = new JPanel();
                  tfPanel[a].setName("TFPANEL_" + (a + 1));
                  tfs[a] = new TextFieldCustom();
                  cbs[a] = new ComboBoxE();
                  pClocks[a] = new TextFieldClock();

                  tfsE[a] = (JTextField) cbs[a].getEditor().getEditorComponent();
                  tfsE[a].setBackground(LKCustom2.BK_NORMAL);
                  //tfs[a].putClientProperty("TextField.focus", Color.BLACK);

                  tfClocks[a] = ((TextFieldClock) pClocks[a]).getTF();
                  tfs_MD[a] = ((TextFieldClock) pClocks[a]).getMD();
                  tfs_MU[a] = ((TextFieldClock) pClocks[a]).getMU();
                  lb_2ds[a] = ((TextFieldClock) pClocks[a]).getLB2();
                  tfs_SD[a] = ((TextFieldClock) pClocks[a]).getSD();
                  tfs_SU[a] = ((TextFieldClock) pClocks[a]).getSU();

                  //tfPanel[a].setLayout(new BoxLayout(tfPanel[a], BoxLayout.X_AXIS));
                  tfPanel[a].setBackground(Color.BLACK);

                  tfCL[a] = new CardLayout() {
                        @Override
                        public void show(Container parent, String name) {
                              super.show(parent, name);
                              for (int a = 0; a < DT.maxColumns; a++) {
                                    if (parent.getName().equals("TFPANEL_" + (a + 1))) {
                                          tfPanelSelected[a] = name;
                                    }
                              }

                        }

                  };
                  tfPanel[a].setLayout(tfCL[a]);
                  tfPanel[a].add(tfs[a], tfPanelTypes[0]);
                  tfPanel[a].add(cbs[a], tfPanelTypes[1]);
                  tfPanel[a].add(pClocks[a], tfPanelTypes[2]);

                  tfCL[a].show(tfPanel[a], tfPanelTypes[0]);
                  /*
                  tfPanel[a].add(cbs[a]);
                  tfPanel[a].add(tfs_MD[a]);
                  tfPanel[a].add(tfs_MU[a]);
                  tfPanel[a].add(lb_2ds[a]);
                  tfPanel[a].add(tfs_SD[a]);
                  tfPanel[a].add(tfs_SU[a]);
                   */

                  btns_C[a] = new ButtonGradient();
            }
            //================================
            clockConfig();
      }
      //+++++++++++++++++++++
      //DELETE
      private void setNullLayoutComponentsSize() {
            int disLY = 0;
            int disTY = 0;
            System.out.println(SPL.getBackground());
            for (int a = 0; a < DT.maxColumns; a++) {
                  PL_UC.add(lbs[a]);
                  PL_UC.add(cbs[a]);

                  lbs[a].setBounds(6, 38 + disLY, 100, 27);
                  if (a == 0) {
                        lbs[a].setText("1. Id");
                        cbs[a].setBounds(10, 38, 110, 27);
                  } else {
                        cbs[a].setBounds(107, 72 + disTY, 290, 27);
                        disTY += 33;
                  }
                  disLY += 33;
            }

            for (int a = 0; a < DT.maxColumns; a++) {
                  scs[a].setSize(290, 170);

                  PL_UC.add(scs[a]);
                  PL_UC.add(btns_C[a]);

                  btns_C[a].setLocation(402, cbs[a].getY());
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
            PL_U.setName("PL_U");
            PL_UT.setName("PL_T");
            PL_UC.setName("PL_C");
            p3.setName("P3");
            sc_JT.setName("SC_JT");
            JT.setName("JT");
            lb_JT.setName("LB_JT");

            SPL_SUB.setName("SPL_SUB");
            //+++++++++++++++++++++++++++++++
            setNameToMenus();
            //+++++++++++++++++++++++++++++++
            TB.setName("TB");
            //+++++++++++++++++++++++++++++++
            lb_Title.setName("lb_Title");
            int c = 0;
            for (JLabel x : lbs_Icons) {
                  x.setName("lb_Icon_" + ++c);
            }
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
                  //tfPanel[a].setName("TFPANEL_" + (a + 1));
                  cbs[a].setName("CB_" + (a + 1));
                  tfs[a].setName("TF_" + (a + 1));
                  tfsE[a].setName("TFE_" + (a + 1));
                  tfClocks[a].setName("TFC_" + (a + 1));
                  //scs[a].setName("SC_" + (a + 1));
                  //lsts[a].setName("LST_" + (a + 1));
                  btns_C[a].setName("BTNC_" + (a + 1));

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

      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      private void afterFirstQuerySuccess() {
            SQLQuerys.setSchemaForKeys(DTSQL.getDatabase());
            getTypes();
            creatingNeededTables();
            //++++++++++++++++++++++++++++++++++
            System.out.println(CC.CYAN + "\nMAIN +++++ SELECT TABLES" + CC.RESET);
            ms.selectData(DTSQL.mainTable, new SelectTables());

            if (DT.getRTable()) {
                  //SELECTING DEFAULT TABLE++++++++++++++++++++++++
                  System.out.println(CC.CYAN + "MAIN +++++ SELECT DEFAULT TABLE" + CC.RESET);
                  ms.selectRowFromTable(DTSQL.defautlTable, 1, new SelectDefaultTable());
                  SQLQuerys.setTableForCurrentKeys(TableDistC.getTable().replaceAll(" ", "_"));
                  MSQL1 ms1 = new MSQL1(new DefaultConnection());
                  ms1.select(SQLQuerys.SELECT_KEYS_FROM_CURRENT, new SelectCurrentKeys());
                  //ADDING ITEM TO THE JMENU FROM TABLE_NAMES+++++++++++++++++
                  String table = TableDistC.getTable();
                  MENU.addItemToMenus();
                  MENU.setColorToDItem(table, DT.getDTable());

                  //ADDING COLUMNS AND ROWS FROM DEFAULT_TABLE++++++++++++++++++
                  System.out.println(CC.CYAN + "MAIN +++++ SELECT COLUMNS AND ROWS" + CC.RESET);
                  ms.selectColumns(table, new SelectColumns());
                  //--------------------------------------------------------------------------------------------------------------------
                  System.out.println(CC.CYAN + "MAIN +++++ ChangeLB_TF and SelectData" + CC.RESET);
                  cp.changeLB_TFandSelectData(JT.getColumnCount(), DT.getList_C());
                  MComp.setCustomTableCellRenderer(JT);
                  MComp.setCustomTableCellEditor(JT);
                  //noRowsDetection();

                  System.out.println(CC.CYAN + "\nMAIN +++++ ChangeLSTD" + CC.RESET);
                  DISTS.start(true, true);
                  //--------------------------------------------------------------------------------------------------------------------
            } else {//IF THERE IS NO TABLE ADDED TO MAINTABLES
                  SPL_SUB.setTopComponent(lb_PL);
                  lb_PL.setForeground(Color.RED);
                  lb_PL.setFont(new Font("Dialog", Font.BOLD, 40));

                  JMenuItem mi = new JMenuItem("No tables created yet");
                  mi.setBackground(Color.BLACK);
                  mi.setForeground(Color.WHITE);
                  mi.setEnabled(false);
                  JM_Select.add(mi);
            }
            //menuBarLook();
            //+++++++++++++++++++++++++++++++++++++++++++++++++
            System.out.println(CC.CYAN + "MAIN +++++ SELECT CONFIG" + CC.RESET);
            //mc.SelectConfig();
            //ms.selectTables(DT.configTable, new SelectConfig());
            ms.selectData(DTSQL.configTable, new SelectConfig());
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
            ml.addAllListener();
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
            star();
            System.out.println(CC.CYAN + "MAIN +++++ END\n" + CC.RESET);
            //System.out.println("Table: " + dt.getTable());
      }

      private void getTypes() {
            DefaultConnection dc = new DefaultConnection();

            MSQL1 ms1 = new MSQL1(dc);
            ms1.select(SQLQuerys.SELECT_KEYS, new SelectKeys());

      }

      private void creatingNeededTables() {
            if (!DTSQL.getMainTableExist()) {//CREATING MAIN TABLE IF DOESN'T EXIST
                  ms.createTable(DTSQL.mainTable,
                          DTSQL.mainTableColumns, DTSQL.mainTableTypes, DTSQL.mainTableNulls,
                          "id", null, null, new IntString(1, "AUTO_INCREMENT"),
                          new CreateMainTable());
            }
            if (!DTSQL.getConfigTableExist()) {
                  ms.createTable(DTSQL.configTable,
                          DTSQL.configTableColumns, DTSQL.configTableTypes, DTSQL.configTableNulls,
                          null, null, null,
                          new CreateConfigTable());
                  //INSERTING DEFAULT VALUES
                  for (int a = 0; a < DTSQL.configTableValues[0].length; a++) {
                        ms.insert(DTSQL.configTable,
                                DTSQL.configTableColumns, DTSQL.configTableValues[a], 0,
                                new InsertConfigTable());
                  }
            }
            if (!DTSQL.getDefaultTableExist()) {
                  ms.createTable(DTSQL.defautlTable,
                          DTSQL.mainTableColumns, DTSQL.mainTableTypes, DTSQL.mainTableNulls,
                          "id", null, null, new IntString(1, "AUTO_INCREMENT"),
                          new CreateDefaultTable());
            }
      }

      public VF_R() {
            System.out.println(CC.CYAN + "CLASS ### MAIN" + CC.RESET);
            frameConfig();
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            System.out.println(CC.CYAN + "CHECKING IF MAIN TABLE EXIST (FIRST QUERY) ++++++++++++++++" + CC.RESET);

            ms.selectTables(new TablesExistFQ());
            if (!DT.getWrongPassword()) {//IF FIRST QUERY FAILS BC WRONG PASSWORD
                  afterFirstQuerySuccess();
            }
      }

      private void star() {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        try {
                              ms.getConnection().close();
                        } catch (SQLException ex) {
                              Logger.getLogger(VF_R.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        tfsE[1].putClientProperty("TextField.highlight", Color.RED);
                        JF.setSize(LKCustom2.MAIN_FRAME_SIZE);
                        MComp.setFrameToCenterOfScreen(JF);
                        SPL.setSize(LKCustom2.MAIN_FRAME_SIZE);//TAKING THE PORCENTAGE OF THE SPLITS
                        SPL_SUB.setSize(LKCustom2.MAIN_FRAME_SIZE);

                        SPL.setDividerLocation(0.4);
                        String imageC = TableDistC.getImageC();
                        if (imageC != null) {
                              if (imageC.equals("NONE")) {
                                    SPL_SUB.setDividerLocation(1.0);
                              } else {
                                    SPL_SUB.setDividerLocation(0.6);
                              }
                        } else {
                              SPL_SUB.setDividerLocation(1.0);
                        }
                        SPL.revalidate();
                        SPL_SUB.revalidate();

                        VL.getJF().dispose();
                        JF.setVisible(true);

                        
                        //System.out.println("### SHOW LIST BACKGROUND: " + JMS_ShowList.getBackground());
                        new VT_T();
                  }

            });
      }

      //++++++++++++++++++++++++++++++++++++++++++++++
      /*
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
       */
      public static boolean getDropAddColumn(){
            return dropAddColumn;
      }
      public static void setDropAddColumn(boolean dropAddColumn){
            VF_R.dropAddColumn = dropAddColumn;
      }
      
      public static int DEFAULT_INDEX = 0;

      public static boolean isComponentNameAt(JPanel jp, JComponent jc) {
            boolean returnValue = false;
            //System.out.println("isCA");
            //System.out.println("\tgetComponent: " + jp.getComponent(DEFAULT_INDEX).getName());
            //System.out.println("\tJC: " + jc.getName());
            if (jp.getComponent(DEFAULT_INDEX).getName() == jc.getName()) {
                  //System.out.println("\ttrue");
                  returnValue = true;
            } else {
                  //System.out.println("\tfalse");
                  returnValue = false;
            }
            return returnValue;
      }

      public static JComponent[] getIndexComponent() {
            JComponent[] JC = new JComponent[DT.maxColumns];
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (VF_R.isComponentNameAt(VF_R.getJTFPanel()[a], VF_R.getJTFS()[a])) {
                        JC[a] = VF_R.getJTFS()[a];
                  } else {
                        JC[a] = VF_R.getJTFES()[a];
                  }
            }
            return JC;
      }
}
