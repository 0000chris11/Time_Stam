/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create;

import views.create.listeners.BTN_Dists;
import views.create.listeners.BTN_MP_AL;
import views.create.listeners.CBType1_IL;
import views.create.listeners.CBExtra_IL;
import views.create.Actions.SingleSelectionButton;
import views.create.renderers.ComboBoxRenderer;
import MC.DT;
import MC.DTSQL;
import MC.LK_C;
import MC.TablesInfo;
import Others.LimitN;
import com.cofii.myClasses.MLayout;
import com.cofii.myInterfaces.SerializationExceptionAction;
import com.cofii.myMethods.MComp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ListCellRenderer;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.JTextComponent;
import org.apache.commons.lang3.SerializationException;
import smallComponenets.NumberOTF;
import smallComponenets.smallBTN_C;
import smallComponenets.smallBTN_TG;
import smallComponenets.smallCHBX;
import smallComponenets.smallCOMBX;
import smallComponenets.smallLB;
import smallComponenets.smallTF;
import views.create.Actions.BTN_AControl;
import views.create.Actions.PKAction;
import views.create.Actions.RBExtraAction;
import views.create.Actions.TFS_KControl;
import views.create.Actions.Table_KControlException;
import views.create.listeners.BTN_CU_AL;
import views.create.listeners.VCListener;
import views.create.listeners.rbDefault_AL;
import views.create.mTFControl.AKeyMatchActions3;
import views.create.mTFControl.MBTN_Control;
import views.create.mTFControl.MTF_Control3;
import views.create.mTFControl.MTXControlData;
import views.create.mTFControl.UpdateList;
import views.first.listeners.MITableOptions_AL;

/**
 *
 * @author C0FII
 */
public class VC_R2 {

      private VC_R_DataCom dt = MITableOptions_AL.getVCreateData();

      //CHANGE THEM LATER++++++++++++++++++++++++++++++++++++++++++++
      private void beforeComponentsConfig() {
            for (int a = 0; a < dt.headers.length; a++) {
                  dt.headers[a] = new smallLB(dt.headers_t[a]);
            }

            dt.panelExtra.setLayout(new BoxLayout(dt.panelExtra, BoxLayout.X_AXIS));
            dt.panelExtra.add(dt.rbExtra, 0);
            dt.panelExtra.add(dt.combExtra, 1);
            dt.panelExtra.add(dt.tfIDEN1, 2);
            dt.panelExtra.add(dt.tfIDEN2, 3);
            dt.panelExtra.add(Box.createGlue());

            dt.panelDefault.setLayout(new BoxLayout(dt.panelDefault, BoxLayout.X_AXIS));
            dt.panelDefault.add(dt.rbDefault, 0);
            dt.panelDefault.add(dt.tfDefault, 1);
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++
      private <T> T[] getColumn(Class<T> clas, T[][] doubleArray, int col) {
            T[] returnObject = (T[]) Array.newInstance(clas, doubleArray.length);
            for (int a = 0; a < doubleArray.length; a++) {
                  returnObject[a] = (T) doubleArray[a][col];
            }
            return returnObject;
      }

      private <T> void listToArray(ArrayList<T> list, T[] array) {
            for (int a = 0; a < list.size(); a++) {
                  array[a] = list.get(a);
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++
      private void startCreate() {
            for (int a = 0; a < dt.compsD.length; a++) {
                  for (int b = 0; b < dt.compsD[a].length; b++) {
                        if (a > 1) {
                              dt.compsD[a][b].setVisible(false);
                        }
                  }
            }
            //++++++++++++++++++++++++++++++++++++
            componentsConfig();
      }

      //+++++++++++++++++++++++++++++++++++++++++++++
      private void componentsConfig() {

            /*
            "Cols Number", 
            "Field", "Sub", "Add", "Type", "Null", "Key", "Default", "Extra",
            "Dist1", "Dist2", "ImageC", "Tag", "Clock"
             */
            for (int a = 0; a < DT.maxColumns; a++) {
                  dt.lbs[a] = (smallLB) getColumn(JComponent.class, dt.compsD, 0)[a + 1];//COLS NUMBER
                  dt.tfs[a] = (smallTF) getColumn(JComponent.class, dt.compsD, 1)[a + 1];//FIELD
                  dt.btns_m[a] = (smallBTN_C) getColumn(JComponent.class, dt.compsD, 2)[a + 1];//SUB
                  dt.btns_p[a] = (smallBTN_C) getColumn(JComponent.class, dt.compsD, 3)[a + 1];//ADD
                  dt.combsTypes[a] = (smallCOMBX) getColumn(JComponent.class, dt.compsD, 4)[a + 1];//TYPE
                  dt.checkbsNull[a] = (smallCHBX) getColumn(JComponent.class, dt.compsD, 5)[a + 1];//NULLS
                  dt.rbsPK[a] = (JRadioButton) getColumn(JComponent.class, dt.compsD, 6)[a + 1];//KEY
                  dt.panelsDefaults[a] = (JPanel) getColumn(JComponent.class, dt.compsD, 7)[a + 1];//DEFAULT
                  dt.panelsExtra[a] = (JPanel) getColumn(JComponent.class, dt.compsD, 8)[a + 1];//EXTRA
                  dt.btns_Dist[a] = (smallBTN_TG) getColumn(JComponent.class, dt.compsD, 9)[a + 1];//DIST1
                  dt.btns_Dist2[a] = (smallBTN_TG) getColumn(JComponent.class, dt.compsD, 10)[a + 1];//DIST2
                  dt.btns_ImageC[a] = (smallBTN_TG) getColumn(JComponent.class, dt.compsD, 11)[a + 1];//IMAGEC
                  dt.btns_Tag[a] = (smallBTN_TG) getColumn(JComponent.class, dt.compsD, 12)[a + 1];//TAG
                  dt.btns_Clock[a] = (smallBTN_TG) getColumn(JComponent.class, dt.compsD, 13)[a + 1];//CLOCK
                  //++++++++++++++++++++++++++++++++++++++++++++++               
            }
            //=======================================================
            dt.btns_m[0].setEnabled(false);
            dt.btns_p[DT.maxColumns - 1].setEnabled(false);
            dt.headers[10].setForeground(Color.GRAY);//DIST2
            //+++++++++++++++++++++++++++++++++++++++++
            extraPanels();
            defaultPanels();
            //+++++++++++++++++++++++++++++++++++++++++
            setNames();
            setSizes();
            setColorAndOthers();
            setListeners();
      }

      private void setNames() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  dt.lbs[a].setName("LB_" + (a + 1));
                  dt.lbOrigText[a] = "Column " + (a + 1);

                  dt.tfs[a].setName("TF_" + (a + 1));
                  dt.btns_m[a].setName("BTN_M_" + (a + 1));
                  dt.btns_p[a].setName("BTN_P_" + (a + 1));
                  dt.combsTypes[a].setName("COMBTYPE_" + (a + 1));
                  dt.checkbsNull[a].setName("CHECKBNULL_" + (a + 1));
                  dt.rbsPK[a].setName("RBPK_" + (a + 1));

                  dt.panelsDefaults[a].setName("PANEL_D_" + (a + 1));
                  dt.rbsDefaults[a].setName("RBD_" + (a + 1));
                  dt.tfsDefaults[a].setName("TFD_" + (a + 1));

                  dt.panelsExtra[a].setName("PANEL_EX_" + (a + 1));
                  dt.rbsExtra[a].setName("RB_EX_" + (a + 1));
                  dt.combsExtra[a].setName("CB_EX_" + (a + 1));
                  dt.tfsIDEN1[a].setName("TFS_IDEN1_" + (a + 1));
                  dt.tfsIDEN2[a].setName("TFS_IDEN2_" + (a + 1));

                  dt.btns_Dist[a].setName("BTN_DIST_" + (a + 1));
                  dt.btns_Dist2[a].setName("BTN_DIST2_" + (a + 1));
                  dt.btns_ImageC[a].setName("BTN_IMAGEC_ " + (a + 1));
                  dt.btns_Tag[a].setName("BTN_TAG_" + (a + 1));
                  dt.btns_Clock[a].setName("BTN_CLOCK_ " + (a + 1));
            }
      }

      private void setColorAndOthers() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  dt.panelsExtra[a].setBackground(LK_C.BK_PANELC);
                  dt.panelsDefaults[a].setBackground(LK_C.BK_PANELC);
                  dt.rbsPK[a].setBackground(LK_C.BK_PANELC);
                  dt.rbsExtra[a].setBackground(LK_C.BK_PANELC);
                  dt.rbsDefaults[a].setBackground(LK_C.BK_PANELC);

                  dt.tfsDefaults[a].setForeground(Color.GRAY);

                  dt.panelsExtra[a].setOpaque(true);
                  dt.panelsDefaults[a].setOpaque(true);
                  dt.btns_Dist2[a].setEnabled(false);
                  dt.rbsExtra[a].setOpaque(true);
                  dt.combsExtra[a].setOpaque(true);
                  dt.tfsIDEN1[a].setOpaque(true);
                  dt.tfsIDEN2[a].setOpaque(true);

                  dt.combsExtra[a].setVisible(false);
                  dt.tfsIDEN1[a].setVisible(false);
                  dt.tfsIDEN2[a].setVisible(false);
                  dt.tfsDefaults[a].setVisible(false);

                  if (a == 0) {
                        dt.combsTypes[a].setSelectedIndex(0);
                  } else {
                        dt.combsTypes[a].setSelectedIndex(1);
                  }
            }
      }

      private void setSizes() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  dt.tfs[a].setMinimumSize(LK_C.DIMENS_TFS_MIN);

                  dt.panelsExtra[a].setMinimumSize(LK_C.DIMENS_PEXTRA_MIN);
                  dt.panelsExtra[a].setMaximumSize(LK_C.DIMENS_PEXTRA_MAX);

                  dt.tfsDefaults[a].setMinimumSize(LK_C.DIMENS_TFSD_MIN);
                  dt.tfsDefaults[a].setPreferredSize(LK_C.DIMENS_TFSD_PREF);

                  dt.combsExtra[a].setMinimumSize(LK_C.DIMENS_COMBEX_MIN);
                  dt.combsExtra[a].setMaximumSize(LK_C.DIMENS_COMBEX_MAX);

                  dt.tfsIDEN1[a].setMinimumSize(LK_C.DIMENS_TFSIDEN_FIX);
                  dt.tfsIDEN1[a].setPreferredSize(LK_C.DIMENS_TFSIDEN_FIX);
                  dt.tfsIDEN1[a].setMaximumSize(LK_C.DIMENS_TFSIDEN_FIX);
                  dt.tfsIDEN2[a].setMinimumSize(LK_C.DIMENS_TFSIDEN_FIX);
                  dt.tfsIDEN2[a].setPreferredSize(LK_C.DIMENS_TFSIDEN_FIX);
                  dt.tfsIDEN2[a].setMaximumSize(LK_C.DIMENS_TFSIDEN_FIX);
            }
      }

      private void setListeners() {
            BTN_MP_AL btnAC = new BTN_MP_AL();
            CBType1_IL cbListener1 = new CBType1_IL();
            BTN_Dists btnDis = new BTN_Dists();
            SingleSelectionButton rbPKListener = new SingleSelectionButton(dt.rbsPK, new PKAction());

            SingleSelectionButton rbExtraListener = new SingleSelectionButton(dt.rbsExtra, new RBExtraAction());
            CBExtra_IL cbListener2 = new CBExtra_IL();

            for (int a = 0; a < DT.maxColumns; a++) {
                  MTF_Control3 mtf = new MTF_Control3(new TFS_KControl());
                  mtf.addList(DTSQL.getBandWE_mysql(), MTF_Control3.EQUAL_MATCH);
                  mtf.addList(DTSQL.getBandWC_mysql(), MTF_Control3.CONTAIN_MATCH);
                  mtf.addList(dt.list_C, MTF_Control3.DUPLICATED_ELEMENTS);
                  mtf.setMinusIndex(2, a);
                  dt.tfs[a].addKeyListener(mtf);

                  MBTN_Control mbtn = new MBTN_Control(null, new BTN_AControl());
                  mbtn.addList(dt.list_C, MTXControlData.DUPLICATED_ELEMENTS);
                  dt.btns_m[a].addActionListener(mbtn);
                  dt.btns_p[a].addActionListener(mbtn);

                  dt.btns_m[a].addActionListener(btnAC);
                  dt.btns_p[a].addActionListener(btnAC);
                  dt.combsTypes[a].addItemListener(cbListener1);
                  dt.btns_Dist[a].addActionListener(btnDis);
                  dt.btns_Tag[a].addActionListener(btnDis);
                  dt.btns_ImageC[a].addActionListener(btnDis);
                  dt.btns_Clock[a].addActionListener(btnDis);
                  dt.rbsPK[a].addActionListener(rbPKListener);

                  dt.rbsExtra[a].addActionListener(rbExtraListener);
                  dt.combsExtra[a].addItemListener(cbListener2);

                  dt.rbsDefaults[a].addActionListener(new rbDefault_AL(a));
                  MComp.setPlaceHolderText(dt.tfsDefaults[a], "NULL");
            }
      }

      private void extraPanels() {
            JComponent[] extraPanelFilter = new JComponent[4];

            for (int a = 0; a < DT.maxColumns; a++) {
                  int count = 0;
                  int countR = 0;
                  for (int b = 0; b < extraPanelFilter.length + 1; b++) {
                        //System.out.println("\t" + panelsExtra[a].getComponent(b).getClass().toString());
                        if (!dt.panelsExtra[a].getComponent(b).getClass().toString().contains("Filler")) {
                              if (dt.panelsExtra[a].getComponent(b).getClass().toString().contains("Radio")) {
                                    countR++;
                              }
                              if (countR <= 1) {
                                    extraPanelFilter[count++] = (JComponent) dt.panelsExtra[a].getComponent(b);
                                    //System.out.println("\t\tC" + count + ": " + extraPanelFilter[count++].getClass());

                              }
                        }
                  }

                  dt.rbsExtra[a] = (JRadioButton) extraPanelFilter[0];
                  dt.combsExtra[a] = (smallCOMBX) extraPanelFilter[1];
                  dt.tfsIDEN1[a] = (NumberOTF) extraPanelFilter[2];
                  dt.tfsIDEN2[a] = (NumberOTF) extraPanelFilter[3];
                  //++++++++++++++++++++++++++++++++++++++++++++++++
                  MComp.setOnlyNumbers(dt.tfsIDEN1[a]);
                  MComp.setOnlyNumbers(dt.tfsIDEN2[a]);
                  //++++++++++++++++++++++++++++++++++++++++++++++++
                  dt.combsExtra[a].setRenderer(new ComboBoxRenderer());
            }
      }

      private void defaultPanels() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  dt.rbsDefaults[a] = (JRadioButton) dt.panelsDefaults[a].getComponent(0);
                  dt.tfsDefaults[a] = (smallTF) dt.panelsDefaults[a].getComponent(1);

            }
      }

      //+++++++++++++++++++++++++++++++++++++++++++++
      private void JPUConfig() {
            dt.JF.add(dt.JPU, BorderLayout.NORTH);
            dt.JPU.setLayout(new BoxLayout(dt.JPU, BoxLayout.X_AXIS));
            dt.JPU.setBorder(new LineBorder(Color.WHITE, 1));
            dt.JPU.setBackground(Color.BLACK);
            dt.JPU.setPreferredSize(new Dimension(500, 46));
            dt.JPU.setMaximumSize(new Dimension(Short.MAX_VALUE, 46));

            dt.JPU.add(dt.lb_Title);
            dt.lb_Title.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 0));
            dt.lb_Title.setForeground(Color.WHITE);
            dt.lb_Title.setFont(new Font("Dialog", Font.BOLD, 18));
            dt.lb_Title.setPreferredSize(new Dimension(200, 27));
            dt.lb_Title.setMaximumSize(new Dimension(200, 27));

            dt.JPU.add(dt.tf_Title);
            dt.tf_Title.setPreferredSize(new Dimension(dt.tf_Title.getPreferredSize().width, 27));
            dt.tf_Title.setMaximumSize(new Dimension(Short.MAX_VALUE, 27));
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++

            MTF_Control3 mtf = new MTF_Control3(new Table_KControlException());
            mtf.addList(DTSQL.getBandWE_mysql(), MTF_Control3.EQUAL_MATCH);
            mtf.addList(DTSQL.getBandWC_mysql(), MTF_Control3.CONTAIN_MATCH);
            mtf.addList(TablesInfo.getTableList(), MTF_Control3.EQUAL_MATCH);

            dt.tf_Title.addKeyListener(mtf);

            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            dt.JPU.add(Box.createHorizontalStrut(10));
      }

      private void JPCConfig() {
            dt.JF.add(dt.sc_JPC, BorderLayout.CENTER);
            dt.JPC.setBackground(LK_C.BK_PANELC);
            dt.sc_JPC.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            dt.sc_JPC.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
            dt.sc_JPC.setBorder(new LineBorder(Color.WHITE, 1));

            beforeComponentsConfig();
            //+++++++++++++++++++++++++++++++++++++
            GroupLayout gl = new GroupLayout(dt.JPC);
            dt.JPC.setLayout(gl);
            /*
            "Cols Number", 
            "Field", "Sub", "Add", "Type", "Null", "Key", "Default", "Extra",
            "Dist1", "Dist2", "ImageC", "Tag", "Clock"
             */
            JComponent[] comps = new JComponent[]{
                  dt.lb, dt.tf, dt.btn_m, dt.btn_p, dt.combTypes, dt.checkbNulls, dt.rbPK, dt.panelDefault, dt.panelExtra,
                  dt.btn_Dist, dt.btn_Dist2, dt.btn_ImageC, dt.btn_Tag, dt.btn_Clock};
            MLayout.setSerializationExceptionAction(new SerializationExceptionAction() {
                  @Override
                  public JComponent getComponent(SerializationException se, JComponent jc) {
                        JComponent returnValue = null;
                        if (jc instanceof smallBTN_TG) {
                              Color[] c = ((smallBTN_TG) jc).C;
                              returnValue = new smallBTN_TG(c);

                        } else if (jc instanceof smallBTN_C) {
                              String text = ((smallBTN_C) jc).Title;
                              returnValue = new smallBTN_C(text);
                        }
                        return returnValue;
                  }

            });
            MLayout.setComponentsHeight(27);
            dt.compsD = MLayout.lineSequenceYClone(gl, dt.headers, comps, DT.maxColumns);
      }

      private void JPBConfig(String choice) {
            dt.JF.add(dt.JPB, BorderLayout.SOUTH);
            dt.JPB.setBackground(Color.BLACK);
            dt.JPB.setBorder(new LineBorder(Color.WHITE, 1));
            dt.JPB.setPreferredSize(new Dimension(500, 40));
            dt.JPB.setMaximumSize(new Dimension(Short.MAX_VALUE, 42));
            dt.JPB.setLayout(new BoxLayout(dt.JPB, BoxLayout.X_AXIS));

            dt.JPB.add(dt.lb_Status);
            Border bb = BorderFactory.createBevelBorder(BevelBorder.RAISED);
            Border be = BorderFactory.createEmptyBorder(1, 3, 1, 3);
            dt.lb_Status.setBorder(new CompoundBorder(bb, be));
            dt.lb_Status.setForeground(Color.WHITE);
            dt.lb_Status.setFont(new Font("Dialog", Font.BOLD, 16));
            dt.lb_Status.setMaximumSize(new Dimension(Short.MAX_VALUE, 28));

            dt.JPB.add(Box.createHorizontalStrut(6));
            dt.JPB.add(dt.btn_CU);
            dt.btn_CU.setText(choice);
            dt.btn_CU.setMinimumSize(new Dimension(60, 28));
            dt.btn_CU.addActionListener(new BTN_CU_AL(choice));
            dt.JPB.add(Box.createHorizontalStrut(10));
      }

      private void JPRConfig(String choice) {
            dt.JF.add(dt.JPR, BorderLayout.EAST);
            dt.JPR.setLayout(new BorderLayout());
            dt.JPR.add(dt.JPR_U, BorderLayout.CENTER);
            dt.JPR_U.setBackground(Color.BLACK);
            dt.JPR_U.setBorder(new LineBorder(Color.WHITE, 1));
            dt.JPR_U.setMinimumSize(new Dimension(200, 40));
            dt.JPR_U.setPreferredSize(new Dimension(200, 500));
            dt.JPR_U.setMaximumSize(new Dimension(200, Short.MAX_VALUE));
            dt.JPR_U.setLayout(new BoxLayout(dt.JPR_U, BoxLayout.Y_AXIS));

            //ADDING LB TO JPR_U AND TO TDISP+++++++++++++++++++++
            for (int a = 0; a < dt.lb_TDisp.length; a++) {
                  if (choice.equals("CREATE")) {
                        dt.lb_TDisp[a] = new smallLB(dt.lb_Disp_textC[a]);
                  }

                  dt.lb_TDisp[a].setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 0));
                  if (a % 2 == 0) {
                        dt.lb_TDisp[a].setFont(new Font("Dialog", Font.BOLD, 22));
                  }
                  dt.JPR_U.add(dt.lb_TDisp[a]);//HOLD ALL LBS AT THIS TIME
            }
            dt.JPR_U.add(dt.lb_ClockLocation);
            dt.lb_ClockLocation.setForeground(Color.YELLOW.darker());
            //lb_ClockLocation.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 0));

            dt.JPR.add(dt.boxImageC, BorderLayout.SOUTH);
            dt.boxImageC.setMinimumSize(new Dimension(100, 27));
            dt.boxImageC.setMaximumSize(new Dimension(Short.MAX_VALUE, 27));
            dt.boxImageC.setBackground(Color.BLACK);
            dt.boxImageC.setLayout(new BoxLayout(dt.boxImageC, BoxLayout.X_AXIS));
            dt.boxImageC.add(dt.tfClock);
            dt.tfClock.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            dt.tfClock.setMinimumSize(new Dimension(80, 27));
            dt.tfClock.setMaximumSize(new Dimension(Short.MAX_VALUE, 27));
            dt.boxImageC.add(dt.btn_ClockLocation);
            dt.btn_ClockLocation.setBorder(BorderFactory.createEmptyBorder());
            dt.btn_ClockLocation.setMinimumSize(new Dimension(20, 27));
            dt.btn_ClockLocation.setPreferredSize(new Dimension(20, 27));
            dt.btn_ClockLocation.setMaximumSize(new Dimension(20, 27));

            dt.lb_ClockLocation.setVisible(false);
            dt.boxImageC.setVisible(false);

            //ADDING LB TO ADISP
            ArrayList<JLabel> listLabelsA = new ArrayList<JLabel>();
            ArrayList<JLabel> listLabelsT = new ArrayList<JLabel>();
            for (int a = 0; a < dt.lb_TDisp.length; a++) {
                  if (a % 2 == 1) {
                        listLabelsA.add(dt.lb_TDisp[a]);
                  } else {
                        listLabelsT.add(dt.lb_TDisp[a]);
                  }
            }
            listToArray(listLabelsT, dt.lb_TDisp);
            listToArray(listLabelsA, dt.lb_ADisp);
            //DIST2 OFF
            dt.lb_TDisp[1].setForeground(Color.GRAY);
            dt.lb_ADisp[1].setForeground(Color.GRAY);
      }

      public void toolKitConfig() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  JComboBox cb = dt.combsExtra[a];
                  String selected = cb.getSelectedItem().toString();
                  if (!cb.isEnabled() && !dt.rbsPK[a].isSelected() && selected.equals("AUTO_INCREMENT")) {
                        cb.setToolTipText("Auto_increment column needs to be a Primary Key");
                  }else{
                        cb.setToolTipText("");
                  }
            }
      }

      public VC_R2(String choice) {
            dt.JF.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            dt.JF.setLayout(new BorderLayout());
            dt.JF.addWindowListener(new VCListener());

            JPUConfig();
            JPCConfig();//GroupLayout setUp

            //+++++++++++++++++++++++++++++++++++++
            if (choice.equals("CREATE")) {
                  startCreate();
            } else if (choice.equals("UPDATE")) {
                  //startUpdate();
            }
            //+++++++++++++++++++++++++++++++++++++

            JPBConfig(choice);
            JPRConfig(choice);
            toolKitConfig();

            updateSwing();
      }

      private void updateSwing() {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        dt.JF.setSize(1100, 500);
                        dt.JF.setAlwaysOnTop(true);
                        dt.JF.setVisible(true);
                  }

            });
      }
      /*
      public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        VC_R2 VC = new VC_R2("CREATE");
                        VC.JF.setSize(1100, 500);
                        VC.JF.setAlwaysOnTop(true);
                  }

            });
      }
       */
}
