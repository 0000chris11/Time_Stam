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
import static views.create.VC_R_DataCom.lb_Status;
import MC.DT;
import MC.DTSQL;
import Others.LimitN;
import com.cofii.myClasses.MLayout;
import com.cofii.myInterfaces.SerializationExceptionAction;
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
import static views.create.VC_R_DataCom.rbsExtra;
import static views.create.VC_R_DataCom.combsExtra;
import views.create.Actions.PKAction;
import views.create.Actions.RBExtraAction;
import views.create.Actions.TFS_KControl;
import views.create.Actions.Table_KControlException;
import static views.create.VC_R_DataCom.headers;
import views.create.listeners.BTN_CU_AL;
import views.create.mTFControl.IKeyMatchActions3;
import views.create.mTFControl.MBTN_Control;
import views.create.mTFControl.MTF_Control3;
import views.create.mTFControl.MTXControlData;
import views.create.mTFControl.UpdateList;

/**
 *
 * @author C0FII
 */
public class VC_R2 extends VC_R_DataCom {

      //CHANGE THEM LATER++++++++++++++++++++++++++++++++++++++++++++
      BTN_MP_AL btnAC = new BTN_MP_AL();
      CBType1_IL cbListener1 = new CBType1_IL();
      BTN_Dists btnDis = new BTN_Dists();
      SingleSelectionButton rbPKListener = new SingleSelectionButton(rbsPK, new PKAction());

      private void beforeComponentsConfig() {
            for (int a = 0; a < headers.length; a++) {
                  headers[a] = new smallLB(headers_t[a]);
            }

            panelExtra.setLayout(new BoxLayout(panelExtra, BoxLayout.X_AXIS));

            panelExtra.add(rbExtra);
            panelExtra.add(combExtra);
            panelExtra.add(tfIDEN1);
            panelExtra.add(tfIDEN2);
            panelExtra.add(Box.createGlue());

            panelDefault.setLayout(new BoxLayout(panelDefault, BoxLayout.X_AXIS));
            panelDefault.add(rbDefault, 0);
            panelDefault.add(tfDefault, 1);
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
            for (int a = 0; a < compsD.length; a++) {
                  for (int b = 0; b < compsD[a].length; b++) {
                        if (a > 1) {
                              compsD[a][b].setVisible(false);
                        }
                  }
            }
            //++++++++++++++++++++++++++++++++++++

      }

      //+++++++++++++++++++++++++++++++++++++++++++++
      private void componentsConfig() {

            /*
            "Cols Number", 
            "Field", "Sub", "Add", "Type", "Null", "Key", "Default", "Extra",
            "Dist1", "Dist2", "ImageC", "Tag", "Clock"
             */
            for (int a = 0; a < DT.maxColumns; a++) {
                  lbs[a] = (smallLB) getColumn(JComponent.class, compsD, 0)[a + 1];//COLS NUMBER
                  tfs[a] = (smallTF) getColumn(JComponent.class, compsD, 1)[a + 1];//FIELD
                  btns_m[a] = (smallBTN_C) getColumn(JComponent.class, compsD, 2)[a + 1];//SUB
                  btns_p[a] = (smallBTN_C) getColumn(JComponent.class, compsD, 3)[a + 1];//ADD
                  combsTypes[a] = (smallCOMBX) getColumn(JComponent.class, compsD, 4)[a + 1];//TYPE
                  checkbsNull[a] = (smallCHBX) getColumn(JComponent.class, compsD, 5)[a + 1];//NULLS
                  rbsPK[a] = (JRadioButton) getColumn(JComponent.class, compsD, 6)[a + 1];//KEY
                  panelsDefaults[a] = (JPanel) getColumn(JComponent.class, compsD, 7)[a + 1];//DEFAULT
                  panelsExtra[a] = (JPanel) getColumn(JComponent.class, compsD, 8)[a + 1];//EXTRA
                  btns_Dist[a] = (smallBTN_TG) getColumn(JComponent.class, compsD, 9)[a + 1];//DIST1
                  btns_Dist2[a] = (smallBTN_TG) getColumn(JComponent.class, compsD, 10)[a + 1];//DIST2
                  btns_ImageC[a] = (smallBTN_TG) getColumn(JComponent.class, compsD, 11)[a + 1];//IMAGEC
                  btns_Tag[a] = (smallBTN_TG) getColumn(JComponent.class, compsD, 12)[a + 1];//TAG
                  btns_Clock[a] = (smallBTN_TG) getColumn(JComponent.class, compsD, 13)[a + 1];//CLOCK
                  //+++++++++++++++++++++++++++++++++++++++++++++++
                  setNames(a);
                  //+++++++++++++++++++++++++++++++++++++++++++++++
                  panelsExtra[a].setBackground(Color.BLACK);
                  panelsDefaults[a].setBackground(Color.BLACK);
                  rbsPK[a].setBackground(Color.BLACK);
                  tfsDefaults[a].setForeground(Color.GRAY);
                  //+++++++++++++++++++++++++++++++++++++++++++++++
                  setSizes(a);
                  //+++++++++++++++++++++++++++++++++++++++++++++++
                  setListeners(a);
                  //+++++++++++++++++++++++++++++++++++++++++++++++
                  panelsExtra[a].setOpaque(true);
                  //+++++++++++++++++++++++++++++++++++++++++++++++
                  btns_Dist2[a].setEnabled(false);
            }
            //=======================================================
            SingleSelectionButton rbExtraListener = new SingleSelectionButton(rbsExtra, new RBExtraAction());
            CBExtra_IL cbListener2 = new CBExtra_IL();
            //ButtonGroup bgRB = new ButtonGroup();

            JComponent[] extraPanelFilter = new JComponent[4];

            for (int a = 0; a < DT.maxColumns; a++) {
                  int count = 0;
                  int countR = 0;
                  for (int b = 0; b < extraPanelFilter.length + 1; b++) {
                        //System.out.println("\t" + panelsExtra[a].getComponent(b).getClass().toString());
                        if (!panelsExtra[a].getComponent(b).getClass().toString().contains("Filler")) {
                              if (panelsExtra[a].getComponent(b).getClass().toString().contains("Radio")) {
                                    countR++;
                              }
                              if (countR <= 1) {
                                    extraPanelFilter[count++] = (JComponent) panelsExtra[a].getComponent(b);
                                    //System.out.println("\t\tC" + count + ": " + extraPanelFilter[count++].getClass());

                              }
                        }
                  }

                  rbsExtra[a] = (JRadioButton) extraPanelFilter[0];
                  combsExtra[a] = (smallCOMBX) extraPanelFilter[1];
                  tfsIDEN1[a] = (NumberOTF) extraPanelFilter[2];
                  tfsIDEN2[a] = (NumberOTF) extraPanelFilter[3];
                  //++++++++++++++++++++++++++++++++++++++++++++++++
                  ((AbstractDocument) tfsIDEN1[a].getDocument()).setDocumentFilter(new LimitN());
                  ((AbstractDocument) tfsIDEN2[a].getDocument()).setDocumentFilter(new LimitN());
                  //++++++++++++++++++++++++++++++++++++++++++++++++
                  rbsExtra[a].setBackground(Color.BLACK);
                  combsExtra[a].setRenderer(new ComboBoxRenderer());
                  //++++++++++++++++++++++++++++++++++++++++++++++++
                  rbsExtra[a].addActionListener(rbExtraListener);
                  combsExtra[a].addItemListener(cbListener2);
                  //++++++++++++++++++++++++++++++++++++++++++++++++
                  combsExtra[a].setMinimumSize(new Dimension(100, 27));
                  combsExtra[a].setMaximumSize(new Dimension(210, 27));
                  tfsIDEN1[a].setMinimumSize(new Dimension(40, 27));
                  tfsIDEN1[a].setPreferredSize(new Dimension(40, 27));
                  tfsIDEN1[a].setMaximumSize(new Dimension(40, 27));
                  tfsIDEN2[a].setMinimumSize(new Dimension(50, 27));
                  tfsIDEN2[a].setPreferredSize(new Dimension(40, 27));
                  tfsIDEN2[a].setMaximumSize(new Dimension(50, 27));
                  //++++++++++++++++++++++++++++++++++++++++++++++++
                  rbsExtra[a].setOpaque(true);
                  combsExtra[a].setOpaque(true);
                  tfsIDEN1[a].setOpaque(true);
                  tfsIDEN2[a].setOpaque(true);
                  //++++++++++++++++++++++++++++++++++++++++++++++++
                  combsExtra[a].setVisible(false);
                  tfsIDEN1[a].setVisible(false);
                  tfsIDEN2[a].setVisible(false);

            }
            //========================================
            for (int a = 0; a < combsTypes.length; a++) {
                  //System.out.println((a + 1) + ": count: " + combsTypes[a].getItemCount());
                  if (a == 0) {
                        combsTypes[a].setSelectedIndex(0);
                  } else {
                        combsTypes[a].setSelectedIndex(1);
                  }
                  //combTypes2[a]
            }
            //========================================
            btns_m[0].setEnabled(false);
            btns_p[DT.maxColumns - 1].setEnabled(false);
            headers[10].setForeground(Color.GRAY);//DIST2
      }

      private void setNames(int a) {
            lbs[a].setName("LB_" + (a + 1));
            lbOrigText[a] = "Column " + (a + 1);
            tfs[a].setName("TF_" + (a + 1));
            btns_m[a].setName("BTN_M_" + (a + 1));
            btns_p[a].setName("BTN_P_" + (a + 1));
            combsTypes[a].setName("COMBTYPE_" + (a + 1));
            checkbsNull[a].setName("CHECKBNULL_" + (a + 1));
            rbsPK[a].setName("RBPK_" + (a + 1));
            panelsDefaults[a].setName("PANEL_D_" + (a + 1));
            tfsDefaults[a].setName("TFD_" + (a + 1));
            panelsExtra[a].setName("PANEL_EX_" + (a + 1));
            btns_Dist[a].setName("BTN_DIST_" + (a + 1));
            btns_Dist2[a].setName("BTN_DIST2_" + (a + 1));
            btns_ImageC[a].setName("BTN_IMAGEC_ " + (a + 1));
            btns_Tag[a].setName("BTN_TAG_" + (a + 1));
            btns_Clock[a].setName("BTN_CLOCK_ " + (a + 1));
      }

      private void setSizes(int a) {
            tfs[a].setMinimumSize(new Dimension(200, 27));
            panelsExtra[a].setMinimumSize(new Dimension(40, 27));
            //panelTypes2[a].setPreferredSize(new Dimension(40, 27));
            panelsExtra[a].setMaximumSize(new Dimension(320, 27));
            tfsDefaults[a].setMinimumSize(new Dimension(100, 27));
            tfsDefaults[a].setPreferredSize(new Dimension(100, 27));
      }

      private void setListeners(int a) {
            MTF_Control3 mtf = new MTF_Control3(new TFS_KControl());
            mtf.addList(DTSQL.getBandWE_mysql(), MTF_Control3.EQUAL_MATCH);
            mtf.addList(DTSQL.getBandWC_mysql(), MTF_Control3.CONTAIN_MATCH);
            mtf.addList(list_C, MTF_Control3.DUPLICATED_ELEMENTS);
            mtf.setMinusIndex(2, a);

            tfs[a].addKeyListener(mtf);
            MBTN_Control mbtn = new MBTN_Control(null, new IKeyMatchActions3() {

                  @Override
                  public UpdateList getUpdatedList(int listID, ArrayList<String> list) {
                        TFS_KControl.updateListC();
                        return new UpdateList(0, list_C);
                  }

                  @Override
                  public void listsAction(EventObject e, boolean[] matches) {
                        if (matches[0]) {
                              headers[1].setForeground(Color.RED);
                              headers[1].setText("Same Column Detected");
                        } else {
                              headers[1].setForeground(Color.WHITE);
                              headers[1].setText("Names");
                        }
                  }

            });
            mbtn.addList(list_C, MTXControlData.DUPLICATED_ELEMENTS);

            btns_m[a].addActionListener(mbtn);
            btns_m[a].addActionListener(btnAC);
            btns_p[a].addActionListener(mbtn);
            btns_p[a].addActionListener(btnAC);
            combsTypes[a].addItemListener(cbListener1);
            btns_Dist[a].addActionListener(btnDis);
            btns_Dist[a].setActionCommand("BTNS_DIST_" + (a + 1));
            btns_Dist2[a].setActionCommand("BTNS_DIST2_" + (a + 1));
            btns_Tag[a].addActionListener(btnDis);
            btns_ImageC[a].addActionListener(btnDis);
            btns_Clock[a].addActionListener(btnDis);
            rbsPK[a].addActionListener(rbPKListener);

      }

      private void defaultPanels() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  rbDefaults[a] = (JRadioButton) panelsDefaults[a].getComponent(0);
            }
      }

      //+++++++++++++++++++++++++++++++++++++++++++++
      private void JPUConfig() {
            JF.add(JPU, BorderLayout.NORTH);
            JPU.setLayout(new BoxLayout(JPU, BoxLayout.X_AXIS));
            JPU.setBorder(new LineBorder(Color.WHITE, 1));
            JPU.setBackground(Color.BLACK);
            JPU.setPreferredSize(new Dimension(500, 46));
            JPU.setMaximumSize(new Dimension(Short.MAX_VALUE, 46));

            JPU.add(lb_Title);
            lb_Title.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 0));
            lb_Title.setForeground(Color.WHITE);
            lb_Title.setFont(new Font("Dialog", Font.BOLD, 18));
            lb_Title.setPreferredSize(new Dimension(200, 27));
            lb_Title.setMaximumSize(new Dimension(200, 27));

            JPU.add(tf_Title);
            tf_Title.setPreferredSize(new Dimension(tf_Title.getPreferredSize().width, 27));
            tf_Title.setMaximumSize(new Dimension(Short.MAX_VALUE, 27));
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++

            MTF_Control3 mtf = new MTF_Control3(new Table_KControlException());
            mtf.addList(DTSQL.getBandWE_mysql(), MTF_Control3.EQUAL_MATCH);
            mtf.addList(DTSQL.getBandWC_mysql(), MTF_Control3.CONTAIN_MATCH);
            mtf.addList(DT.getList_T(), MTF_Control3.EQUAL_MATCH);

            tf_Title.addKeyListener(mtf);

            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            JPU.add(Box.createHorizontalStrut(10));
      }

      private void JPCConfig() {
            JF.add(sc_JPC, BorderLayout.CENTER);
            JPC.setBackground(Color.BLACK);
            sc_JPC.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            sc_JPC.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
            sc_JPC.setBorder(new LineBorder(Color.WHITE, 1));

            beforeComponentsConfig();
            //+++++++++++++++++++++++++++++++++++++
            GroupLayout gl = new GroupLayout(JPC);
            JPC.setLayout(gl);
            /*
            "Cols Number", 
            "Field", "Sub", "Add", "Type", "Null", "Key", "Default", "Extra",
            "Dist1", "Dist2", "ImageC", "Tag", "Clock"
             */
            JComponent[] comps = new JComponent[]{
                  lb, tf, btn_m, btn_p, combTypes, checkbNulls, rbPK, panelDefault, panelExtra,
                  btn_Dist, btn_Dist2, btn_ImageC, btn_Tag, btn_Clock};
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
            compsD = MLayout.lineSequenceYClone(gl, headers, comps, DT.maxColumns);
      }

      private void JPBConfig(String choice) {
            JF.add(JPB, BorderLayout.SOUTH);
            JPB.setBackground(Color.BLACK);
            JPB.setBorder(new LineBorder(Color.WHITE, 1));
            JPB.setPreferredSize(new Dimension(500, 40));
            JPB.setMaximumSize(new Dimension(Short.MAX_VALUE, 42));
            JPB.setLayout(new BoxLayout(JPB, BoxLayout.X_AXIS));

            JPB.add(lb_Status);
            Border bb = BorderFactory.createBevelBorder(BevelBorder.RAISED);
            Border be = BorderFactory.createEmptyBorder(1, 3, 1, 3);
            lb_Status.setBorder(new CompoundBorder(bb, be));
            lb_Status.setForeground(Color.WHITE);
            lb_Status.setFont(new Font("Dialog", Font.BOLD, 16));
            lb_Status.setMaximumSize(new Dimension(Short.MAX_VALUE, 28));

            JPB.add(Box.createHorizontalStrut(6));
            JPB.add(btn_CU);
            btn_CU.setText(choice);
            btn_CU.setMinimumSize(new Dimension(60, 28));
            btn_CU.addActionListener(new BTN_CU_AL(choice));
            JPB.add(Box.createHorizontalStrut(10));
      }

      private void JPRConfig(String choice) {
            JF.add(JPR, BorderLayout.EAST);
            JPR.setLayout(new BorderLayout());
            JPR.add(JPR_U, BorderLayout.CENTER);
            JPR_U.setBackground(Color.BLACK);
            JPR_U.setBorder(new LineBorder(Color.WHITE, 1));
            JPR_U.setMinimumSize(new Dimension(200, 40));
            JPR_U.setPreferredSize(new Dimension(200, 500));
            JPR_U.setMaximumSize(new Dimension(200, Short.MAX_VALUE));
            JPR_U.setLayout(new BoxLayout(JPR_U, BoxLayout.Y_AXIS));

            //ADDING LB TO JPR_U AND TO TDISP+++++++++++++++++++++
            for (int a = 0; a < lb_TDisp.length; a++) {
                  if (choice.equals("CREATE")) {
                        lb_TDisp[a] = new smallLB(lb_Disp_textC[a]);
                  }

                  lb_TDisp[a].setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 0));
                  if (a % 2 == 0) {
                        lb_TDisp[a].setFont(new Font("Dialog", Font.BOLD, 22));
                  }
                  JPR_U.add(lb_TDisp[a]);//HOLD ALL LBS AT THIS TIME
            }
            JPR_U.add(lb_ClockLocation);
            lb_ClockLocation.setForeground(Color.YELLOW.darker());
            //lb_ClockLocation.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 0));

            JPR.add(boxImageC, BorderLayout.SOUTH);
            boxImageC.setMinimumSize(new Dimension(100, 27));
            boxImageC.setMaximumSize(new Dimension(Short.MAX_VALUE, 27));
            boxImageC.setBackground(Color.BLACK);
            boxImageC.setLayout(new BoxLayout(boxImageC, BoxLayout.X_AXIS));
            boxImageC.add(tfClock);
            tfClock.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            tfClock.setMinimumSize(new Dimension(80, 27));
            tfClock.setMaximumSize(new Dimension(Short.MAX_VALUE, 27));
            boxImageC.add(btn_ClockLocation);
            btn_ClockLocation.setBorder(BorderFactory.createEmptyBorder());
            btn_ClockLocation.setMinimumSize(new Dimension(20, 27));
            btn_ClockLocation.setPreferredSize(new Dimension(20, 27));
            btn_ClockLocation.setMaximumSize(new Dimension(20, 27));

            lb_ClockLocation.setVisible(false);
            boxImageC.setVisible(false);

            //ADDING LB TO ADISP
            ArrayList<JLabel> listLabelsA = new ArrayList<JLabel>();
            ArrayList<JLabel> listLabelsT = new ArrayList<JLabel>();
            for (int a = 0; a < lb_TDisp.length; a++) {
                  if (a % 2 == 1) {
                        listLabelsA.add(lb_TDisp[a]);
                  } else {
                        listLabelsT.add(lb_TDisp[a]);
                  }
            }
            listToArray(listLabelsT, lb_TDisp);
            listToArray(listLabelsA, lb_ADisp);
            //DIST2 OFF
            lb_TDisp[1].setForeground(Color.GRAY);
            lb_ADisp[1].setForeground(Color.GRAY);
      }

      public VC_R2(String choice) {
            JF.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            JF.setLayout(new BorderLayout());

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
                        JF.setSize(1100, 500);
                        JF.setAlwaysOnTop(true);
                        JF.setVisible(true);
                  }

            });
      }
      /*
      public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        VC_R2 vc = new VC_R2("CREATE");
                        vc.JF.setSize(1100, 500);
                        vc.JF.setAlwaysOnTop(true);
                  }

            });
      }
       */
}
