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
import views.create.listeners.TF_KL_Control;
import views.create.renderers.ComboBoxRenderer;
import MC.DT;
import MC.DTSQL;
import MC.LK_C;
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

      private VC_R_DataCom vd = MITableOptions_AL.getVCreateData();
      
      //CHANGE THEM LATER++++++++++++++++++++++++++++++++++++++++++++
      private void beforeComponentsConfig() {
            for (int a = 0; a < vd.headers.length; a++) {
                  vd.headers[a] = new smallLB(vd.headers_t[a]);
            }

            vd.panelExtra.setLayout(new BoxLayout(vd.panelExtra, BoxLayout.X_AXIS));
            vd.panelExtra.add(vd.rbExtra, 0);
            vd.panelExtra.add(vd.combExtra, 1);
            vd.panelExtra.add(vd.tfIDEN1, 2);
            vd.panelExtra.add(vd.tfIDEN2, 3);
            vd.panelExtra.add(Box.createGlue());

            vd.panelDefault.setLayout(new BoxLayout(vd.panelDefault, BoxLayout.X_AXIS));
            vd.panelDefault.add(vd.rbDefault, 0);
            vd.panelDefault.add(vd.tfDefault, 1);
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
            for (int a = 0; a < vd.compsD.length; a++) {
                  for (int b = 0; b < vd.compsD[a].length; b++) {
                        if (a > 1) {
                              vd.compsD[a][b].setVisible(false);
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
                  vd.lbs[a] = (smallLB) getColumn(JComponent.class, vd.compsD, 0)[a + 1];//COLS NUMBER
                  vd.tfs[a] = (smallTF) getColumn(JComponent.class, vd.compsD, 1)[a + 1];//FIELD
                  vd.btns_m[a] = (smallBTN_C) getColumn(JComponent.class, vd.compsD, 2)[a + 1];//SUB
                  vd.btns_p[a] = (smallBTN_C) getColumn(JComponent.class, vd.compsD, 3)[a + 1];//ADD
                  vd.combsTypes[a] = (smallCOMBX) getColumn(JComponent.class, vd.compsD, 4)[a + 1];//TYPE
                  vd.checkbsNull[a] = (smallCHBX) getColumn(JComponent.class, vd.compsD, 5)[a + 1];//NULLS
                  vd.rbsPK[a] = (JRadioButton) getColumn(JComponent.class, vd.compsD, 6)[a + 1];//KEY
                  vd.panelsDefaults[a] = (JPanel) getColumn(JComponent.class, vd.compsD, 7)[a + 1];//DEFAULT
                  vd.panelsExtra[a] = (JPanel) getColumn(JComponent.class, vd.compsD, 8)[a + 1];//EXTRA
                  vd.btns_Dist[a] = (smallBTN_TG) getColumn(JComponent.class, vd.compsD, 9)[a + 1];//DIST1
                  vd.btns_Dist2[a] = (smallBTN_TG) getColumn(JComponent.class, vd.compsD, 10)[a + 1];//DIST2
                  vd.btns_ImageC[a] = (smallBTN_TG) getColumn(JComponent.class, vd.compsD, 11)[a + 1];//IMAGEC
                  vd.btns_Tag[a] = (smallBTN_TG) getColumn(JComponent.class, vd.compsD, 12)[a + 1];//TAG
                  vd.btns_Clock[a] = (smallBTN_TG) getColumn(JComponent.class, vd.compsD, 13)[a + 1];//CLOCK
                  //++++++++++++++++++++++++++++++++++++++++++++++               
            }
            //=======================================================
            vd.btns_m[0].setEnabled(false);
            vd.btns_p[DT.maxColumns - 1].setEnabled(false);
            vd.headers[10].setForeground(Color.GRAY);//DIST2
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
                  vd.lbs[a].setName("LB_" + (a + 1));
                  vd.lbOrigText[a] = "Column " + (a + 1);

                  vd.tfs[a].setName("TF_" + (a + 1));
                  vd.btns_m[a].setName("BTN_M_" + (a + 1));
                  vd.btns_p[a].setName("BTN_P_" + (a + 1));
                  vd.combsTypes[a].setName("COMBTYPE_" + (a + 1));
                  vd.checkbsNull[a].setName("CHECKBNULL_" + (a + 1));
                  vd.rbsPK[a].setName("RBPK_" + (a + 1));

                  vd.panelsDefaults[a].setName("PANEL_D_" + (a + 1));
                  vd.rbsDefaults[a].setName("RBD_" + (a + 1));
                  vd.tfsDefaults[a].setName("TFD_" + (a + 1));

                  vd.panelsExtra[a].setName("PANEL_EX_" + (a + 1));
                  vd.rbsExtra[a].setName("RB_EX_" + (a + 1));
                  vd.combsExtra[a].setName("CB_EX_" + (a + 1));
                  vd.tfsIDEN1[a].setName("TFS_IDEN1_" + (a + 1));
                  vd.tfsIDEN2[a].setName("TFS_IDEN2_" + (a + 1));

                  vd.btns_Dist[a].setName("BTN_DIST_" + (a + 1));
                  vd.btns_Dist2[a].setName("BTN_DIST2_" + (a + 1));
                  vd.btns_ImageC[a].setName("BTN_IMAGEC_ " + (a + 1));
                  vd.btns_Tag[a].setName("BTN_TAG_" + (a + 1));
                  vd.btns_Clock[a].setName("BTN_CLOCK_ " + (a + 1));
            }
      }

      private void setColorAndOthers() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  vd.panelsExtra[a].setBackground(LK_C.BK_PANELC);
                  vd.panelsDefaults[a].setBackground(LK_C.BK_PANELC);
                  vd.rbsPK[a].setBackground(LK_C.BK_PANELC);
                  vd.rbsExtra[a].setBackground(LK_C.BK_PANELC);
                  vd.rbsDefaults[a].setBackground(LK_C.BK_PANELC);
                  
                  vd.tfsDefaults[a].setForeground(Color.GRAY);

                  vd.panelsExtra[a].setOpaque(true);
                  vd.panelsDefaults[a].setOpaque(true);
                  vd.btns_Dist2[a].setEnabled(false);
                  vd.rbsExtra[a].setOpaque(true);
                  vd.combsExtra[a].setOpaque(true);
                  vd.tfsIDEN1[a].setOpaque(true);
                  vd.tfsIDEN2[a].setOpaque(true);
                  
                  vd.combsExtra[a].setVisible(false);
                  vd.tfsIDEN1[a].setVisible(false);
                  vd.tfsIDEN2[a].setVisible(false);
                  vd.tfsDefaults[a].setVisible(false);

                  if (a == 0) {
                        vd.combsTypes[a].setSelectedIndex(0);
                  } else {
                        vd.combsTypes[a].setSelectedIndex(1);
                  }
            }
      }

      private void setSizes() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  vd.tfs[a].setMinimumSize(LK_C.DIMENS_TFS_MIN);

                  vd.panelsExtra[a].setMinimumSize(LK_C.DIMENS_PEXTRA_MIN);
                  vd.panelsExtra[a].setMaximumSize(LK_C.DIMENS_PEXTRA_MAX);

                  vd.tfsDefaults[a].setMinimumSize(LK_C.DIMENS_TFSD_MIN);
                  vd.tfsDefaults[a].setPreferredSize(LK_C.DIMENS_TFSD_PREF);

                  vd.combsExtra[a].setMinimumSize(LK_C.DIMENS_COMBEX_MIN);
                  vd.combsExtra[a].setMaximumSize(LK_C.DIMENS_COMBEX_MAX);

                  vd.tfsIDEN1[a].setMinimumSize(LK_C.DIMENS_TFSIDEN_FIX);
                  vd.tfsIDEN1[a].setPreferredSize(LK_C.DIMENS_TFSIDEN_FIX);
                  vd.tfsIDEN1[a].setMaximumSize(LK_C.DIMENS_TFSIDEN_FIX);
                  vd.tfsIDEN2[a].setMinimumSize(LK_C.DIMENS_TFSIDEN_FIX);
                  vd.tfsIDEN2[a].setPreferredSize(LK_C.DIMENS_TFSIDEN_FIX);
                  vd.tfsIDEN2[a].setMaximumSize(LK_C.DIMENS_TFSIDEN_FIX);
            }
      }

      private void setListeners() {
            BTN_MP_AL btnAC = new BTN_MP_AL();
            CBType1_IL cbListener1 = new CBType1_IL();
            BTN_Dists btnDis = new BTN_Dists();
            SingleSelectionButton rbPKListener = new SingleSelectionButton(vd.rbsPK, new PKAction());

            SingleSelectionButton rbExtraListener = new SingleSelectionButton(vd.rbsExtra, new RBExtraAction());
            CBExtra_IL cbListener2 = new CBExtra_IL();

            for (int a = 0; a < DT.maxColumns; a++) {
                  MTF_Control3 mtf = new MTF_Control3(new TFS_KControl());
                  mtf.addList(DTSQL.getBandWE_mysql(), MTF_Control3.EQUAL_MATCH);
                  mtf.addList(DTSQL.getBandWC_mysql(), MTF_Control3.CONTAIN_MATCH);
                  mtf.addList(vd.list_C, MTF_Control3.DUPLICATED_ELEMENTS);
                  mtf.setMinusIndex(2, a);
                  vd.tfs[a].addKeyListener(mtf);

                  MBTN_Control mbtn = new MBTN_Control(null, new BTN_AControl());
                  mbtn.addList(vd.list_C, MTXControlData.DUPLICATED_ELEMENTS);
                  vd.btns_m[a].addActionListener(mbtn);
                  vd.btns_p[a].addActionListener(mbtn);

                  vd.btns_m[a].addActionListener(btnAC);
                  vd.btns_p[a].addActionListener(btnAC);
                  vd.combsTypes[a].addItemListener(cbListener1);
                  vd.btns_Dist[a].addActionListener(btnDis);
                  vd.btns_Tag[a].addActionListener(btnDis);
                  vd.btns_ImageC[a].addActionListener(btnDis);
                  vd.btns_Clock[a].addActionListener(btnDis);
                  vd.rbsPK[a].addActionListener(rbPKListener);

                  vd.rbsExtra[a].addActionListener(rbExtraListener);
                  vd.combsExtra[a].addItemListener(cbListener2);
                  
                  MComp.setPlaceHolderText(vd.tfsDefaults[a], "NULL");
            }
      }

      private void extraPanels() {
            JComponent[] extraPanelFilter = new JComponent[4];

            for (int a = 0; a < DT.maxColumns; a++) {
                  int count = 0;
                  int countR = 0;
                  for (int b = 0; b < extraPanelFilter.length + 1; b++) {
                        //System.out.println("\t" + panelsExtra[a].getComponent(b).getClass().toString());
                        if (!vd.panelsExtra[a].getComponent(b).getClass().toString().contains("Filler")) {
                              if (vd.panelsExtra[a].getComponent(b).getClass().toString().contains("Radio")) {
                                    countR++;
                              }
                              if (countR <= 1) {
                                    extraPanelFilter[count++] = (JComponent) vd.panelsExtra[a].getComponent(b);
                                    //System.out.println("\t\tC" + count + ": " + extraPanelFilter[count++].getClass());

                              }
                        }
                  }

                  vd.rbsExtra[a] = (JRadioButton) extraPanelFilter[0];
                  vd.combsExtra[a] = (smallCOMBX) extraPanelFilter[1];
                  vd.tfsIDEN1[a] = (NumberOTF) extraPanelFilter[2];
                  vd.tfsIDEN2[a] = (NumberOTF) extraPanelFilter[3];
                  //++++++++++++++++++++++++++++++++++++++++++++++++
                  MComp.setOnlyNumbers(vd.tfsIDEN1[a]);
                  MComp.setOnlyNumbers(vd.tfsIDEN2[a]);
                  //++++++++++++++++++++++++++++++++++++++++++++++++
                  vd.combsExtra[a].setRenderer(new ComboBoxRenderer());
            }
      }

      private void defaultPanels() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  vd.rbsDefaults[a] = (JRadioButton) vd.panelsDefaults[a].getComponent(0);
                  vd.tfsDefaults[a] = (smallTF) vd.panelsDefaults[a].getComponent(1);
                  
                  
            }
      }

      //+++++++++++++++++++++++++++++++++++++++++++++
      private void JPUConfig() {
            vd.JF.add(vd.JPU, BorderLayout.NORTH);
            vd.JPU.setLayout(new BoxLayout(vd.JPU, BoxLayout.X_AXIS));
            vd.JPU.setBorder(new LineBorder(Color.WHITE, 1));
            vd.JPU.setBackground(Color.BLACK);
            vd.JPU.setPreferredSize(new Dimension(500, 46));
            vd.JPU.setMaximumSize(new Dimension(Short.MAX_VALUE, 46));

            vd.JPU.add(vd.lb_Title);
            vd.lb_Title.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 0));
            vd.lb_Title.setForeground(Color.WHITE);
            vd.lb_Title.setFont(new Font("Dialog", Font.BOLD, 18));
            vd.lb_Title.setPreferredSize(new Dimension(200, 27));
            vd.lb_Title.setMaximumSize(new Dimension(200, 27));

            vd.JPU.add(vd.tf_Title);
            vd.tf_Title.setPreferredSize(new Dimension(vd.tf_Title.getPreferredSize().width, 27));
            vd.tf_Title.setMaximumSize(new Dimension(Short.MAX_VALUE, 27));
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++

            MTF_Control3 mtf = new MTF_Control3(new Table_KControlException());
            mtf.addList(DTSQL.getBandWE_mysql(), MTF_Control3.EQUAL_MATCH);
            mtf.addList(DTSQL.getBandWC_mysql(), MTF_Control3.CONTAIN_MATCH);
            mtf.addList(DT.getList_T(), MTF_Control3.EQUAL_MATCH);

            vd.tf_Title.addKeyListener(mtf);

            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            vd.JPU.add(Box.createHorizontalStrut(10));
      }

      private void JPCConfig() {
            vd.JF.add(vd.sc_JPC, BorderLayout.CENTER);
            vd.JPC.setBackground(LK_C.BK_PANELC);
            vd.sc_JPC.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            vd.sc_JPC.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
            vd.sc_JPC.setBorder(new LineBorder(Color.WHITE, 1));

            beforeComponentsConfig();
            //+++++++++++++++++++++++++++++++++++++
            GroupLayout gl = new GroupLayout(vd.JPC);
            vd.JPC.setLayout(gl);
            /*
            "Cols Number", 
            "Field", "Sub", "Add", "Type", "Null", "Key", "Default", "Extra",
            "Dist1", "Dist2", "ImageC", "Tag", "Clock"
             */
            JComponent[] comps = new JComponent[]{
                  vd.lb, vd.tf, vd.btn_m, vd.btn_p, vd.combTypes, vd.checkbNulls, vd.rbPK, vd.panelDefault, vd.panelExtra,
                  vd.btn_Dist, vd.btn_Dist2, vd.btn_ImageC, vd.btn_Tag, vd.btn_Clock};
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
            vd.compsD = MLayout.lineSequenceYClone(gl, vd.headers, comps, DT.maxColumns);
      }

      private void JPBConfig(String choice) {
            vd.JF.add(vd.JPB, BorderLayout.SOUTH);
            vd.JPB.setBackground(Color.BLACK);
            vd.JPB.setBorder(new LineBorder(Color.WHITE, 1));
            vd.JPB.setPreferredSize(new Dimension(500, 40));
            vd.JPB.setMaximumSize(new Dimension(Short.MAX_VALUE, 42));
            vd.JPB.setLayout(new BoxLayout(vd.JPB, BoxLayout.X_AXIS));

            vd.JPB.add(vd.lb_Status);
            Border bb = BorderFactory.createBevelBorder(BevelBorder.RAISED);
            Border be = BorderFactory.createEmptyBorder(1, 3, 1, 3);
            vd.lb_Status.setBorder(new CompoundBorder(bb, be));
            vd.lb_Status.setForeground(Color.WHITE);
            vd.lb_Status.setFont(new Font("Dialog", Font.BOLD, 16));
            vd.lb_Status.setMaximumSize(new Dimension(Short.MAX_VALUE, 28));

            vd.JPB.add(Box.createHorizontalStrut(6));
            vd.JPB.add(vd.btn_CU);
            vd.btn_CU.setText(choice);
            vd.btn_CU.setMinimumSize(new Dimension(60, 28));
            vd.btn_CU.addActionListener(new BTN_CU_AL(choice));
            vd.JPB.add(Box.createHorizontalStrut(10));
      }

      private void JPRConfig(String choice) {
            vd.JF.add(vd.JPR, BorderLayout.EAST);
            vd.JPR.setLayout(new BorderLayout());
            vd.JPR.add(vd.JPR_U, BorderLayout.CENTER);
            vd.JPR_U.setBackground(Color.BLACK);
            vd.JPR_U.setBorder(new LineBorder(Color.WHITE, 1));
            vd.JPR_U.setMinimumSize(new Dimension(200, 40));
            vd.JPR_U.setPreferredSize(new Dimension(200, 500));
            vd.JPR_U.setMaximumSize(new Dimension(200, Short.MAX_VALUE));
            vd.JPR_U.setLayout(new BoxLayout(vd.JPR_U, BoxLayout.Y_AXIS));

            //ADDING LB TO JPR_U AND TO TDISP+++++++++++++++++++++
            for (int a = 0; a < vd.lb_TDisp.length; a++) {
                  if (choice.equals("CREATE")) {
                        vd.lb_TDisp[a] = new smallLB(vd.lb_Disp_textC[a]);
                  }

                  vd.lb_TDisp[a].setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 0));
                  if (a % 2 == 0) {
                        vd.lb_TDisp[a].setFont(new Font("Dialog", Font.BOLD, 22));
                  }
                  vd.JPR_U.add(vd.lb_TDisp[a]);//HOLD ALL LBS AT THIS TIME
            }
            vd.JPR_U.add(vd.lb_ClockLocation);
            vd.lb_ClockLocation.setForeground(Color.YELLOW.darker());
            //lb_ClockLocation.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 0));

            vd.JPR.add(vd.boxImageC, BorderLayout.SOUTH);
            vd.boxImageC.setMinimumSize(new Dimension(100, 27));
            vd.boxImageC.setMaximumSize(new Dimension(Short.MAX_VALUE, 27));
            vd.boxImageC.setBackground(Color.BLACK);
            vd.boxImageC.setLayout(new BoxLayout(vd.boxImageC, BoxLayout.X_AXIS));
            vd.boxImageC.add(vd.tfClock);
            vd.tfClock.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            vd.tfClock.setMinimumSize(new Dimension(80, 27));
            vd.tfClock.setMaximumSize(new Dimension(Short.MAX_VALUE, 27));
            vd.boxImageC.add(vd.btn_ClockLocation);
            vd.btn_ClockLocation.setBorder(BorderFactory.createEmptyBorder());
            vd.btn_ClockLocation.setMinimumSize(new Dimension(20, 27));
            vd.btn_ClockLocation.setPreferredSize(new Dimension(20, 27));
            vd.btn_ClockLocation.setMaximumSize(new Dimension(20, 27));

            vd.lb_ClockLocation.setVisible(false);
            vd.boxImageC.setVisible(false);

            //ADDING LB TO ADISP
            ArrayList<JLabel> listLabelsA = new ArrayList<JLabel>();
            ArrayList<JLabel> listLabelsT = new ArrayList<JLabel>();
            for (int a = 0; a < vd.lb_TDisp.length; a++) {
                  if (a % 2 == 1) {
                        listLabelsA.add(vd.lb_TDisp[a]);
                  } else {
                        listLabelsT.add(vd.lb_TDisp[a]);
                  }
            }
            listToArray(listLabelsT, vd.lb_TDisp);
            listToArray(listLabelsA, vd.lb_ADisp);
            //DIST2 OFF
            vd.lb_TDisp[1].setForeground(Color.GRAY);
            vd.lb_ADisp[1].setForeground(Color.GRAY);
      }

      public VC_R2(String choice) {
            vd.JF.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            vd.JF.setLayout(new BorderLayout());
            vd.JF.addWindowListener(new VCListener());

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

            updateSwing();
      }

      private void updateSwing() {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        vd.JF.setSize(1100, 500);
                        vd.JF.setAlwaysOnTop(true);
                        vd.JF.setVisible(true);
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
