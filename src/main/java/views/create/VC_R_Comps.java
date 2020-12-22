/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create;

import MC.DT;
import MC.DTSQL;
import MC.LKCustom;
import MC.LK_C;
import MC.MainInstances;
import com.cofii2.methods.MComp;
import com.cofii2.myAClasses.LimitN;
import com.cofii2.stores.MArrays;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
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
import views.create.Actions.SingleSelectionButton;
import views.create.Actions.TFS_KControl;
import views.create.listeners.BTN_Dists;
import views.create.listeners.BTN_MP_AL;
import views.create.listeners.CBExtra_IL;
import views.create.listeners.CBType1_IL;
import views.create.listeners.rbDefault_AL;
import views.create.mTFControl.MBTN_Control;
import views.create.mTFControl.MTF_Control3;
import views.create.mTFControl.MTXControlData;
import views.create.renderers.ComboBoxRenderer;

/**
 *
 * @author C0FII
 */
public class VC_R_Comps {
   
      String[] headers_t = new String[]{
            "Cols Number", 
            "Field", "Sub", "Add", "Type", "Null", "PK", "FK","Default", "Extra",
            "Dist1", "Dist2", "ImageC", "Tag", "Clock"};
      JLabel[] headers = new JLabel[headers_t.length];
      JComponent[][] compsD;
      //+++++++++++++++++++++++++++++++++++++++++
      JLabel lb = new smallLB("Column 1");
      JTextField tf = new smallTF();
      JButton btn_p = new smallBTN_C("+");
      JButton btn_m = new smallBTN_C("-");
      
      JPanel panelTypes = new JPanel();
      JComboBox cbTypes = new smallCOMBX(DTSQL.mysqlTypes);
      JTextField tfType = new smallTF();
      
      JCheckBox ckNulls = new smallCHBX();
      JRadioButton rbPK = new JRadioButton();
      
      JPanel panelFK = new JPanel();
      JRadioButton rbFK = new JRadioButton();
      JTextField tfFK = new smallTF();
      
      JPanel panelDefault = new JPanel();
      JRadioButton rbDefault = new JRadioButton();
      JTextField tfDefault = new smallTF("NULL");
      
      JPanel panelExtra = new JPanel();
      JRadioButton rbExtra = new JRadioButton();//NO BUTTON GROUP
      private String[] cbExtraElements = new String[]{"AUTO INCREMENT", "IDENTITY"};
      JComboBox cbExtra = new smallCOMBX(cbExtraElements);
      JTextField tfIDEN1 = new NumberOTF();
      JTextField tfIDEN2 = new NumberOTF();
      
      JToggleButton btn_Dist = new smallBTN_TG(LKCustom.GP_CYAN_AND_WHITE);
      JToggleButton btn_Dist2 = new smallBTN_TG(null);
      JToggleButton btn_ImageC = new smallBTN_TG(LKCustom.GP_GREEN_AND_WHITE);
      JToggleButton btn_Tag = new smallBTN_TG(LKCustom.GP_CYAN_AND_WHITE);
      JToggleButton btn_Clock = new smallBTN_TG(LKCustom.GP_YELLOW_AND_WHITE);
      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      JLabel[] lbs = new JLabel[DT.maxColumns];
      JTextField[] tfs = new JTextField[DT.maxColumns];
      JButton[] btns_p = new smallBTN_C[DT.maxColumns];
      JButton[] btns_m = new smallBTN_C[DT.maxColumns];
      
      JPanel[] panelsTypes = new JPanel[DT.maxColumns];
      JComboBox[] cbsTypes = new smallCOMBX[DT.maxColumns];
      JTextField[] tfsTypes = new JTextField[DT.maxColumns];
      
      JCheckBox[] cksNulls = new smallCHBX[DT.maxColumns];
      
      JRadioButton[] rbsPK = new JRadioButton[DT.maxColumns];
      int rb_PKSelected = 0;
      
      JPanel[] panelsFK = new JPanel[DT.maxColumns];
      JRadioButton[] rbsFK = new JRadioButton[DT.maxColumns];
      int rb_FKSelected = 0;
      JTextField[] tfsFK = new smallTF[DT.maxColumns];
      
      JPanel[] panelsDefaults = new JPanel[DT.maxColumns];
      JRadioButton[] rbsDefaults = new JRadioButton[DT.maxColumns];
      JTextField[] tfsDefaults = new JTextField[DT.maxColumns];
      
      JPanel[] panelsExtra = new JPanel[DT.maxColumns];
      JRadioButton[] rbsExtra = new JRadioButton[DT.maxColumns];
      int rb_ExtraSelected = 0;
      JComboBox[] cbsExtra = new smallCOMBX[DT.maxColumns];
      JTextField[] tfsIDEN1 = new NumberOTF[DT.maxColumns];
      JTextField[] tfsIDEN2 = new NumberOTF[DT.maxColumns];
      
      JToggleButton[] btns_Dist = new smallBTN_TG[DT.maxColumns];
      JToggleButton[] btns_Dist2 = new smallBTN_TG[DT.maxColumns];
      JToggleButton[] btns_ImageC = new smallBTN_TG[DT.maxColumns];
      int btn_ImageCSelected = 0;
      JToggleButton[] btns_Tag = new smallBTN_TG[DT.maxColumns];
      JToggleButton[] btns_Clock = new smallBTN_TG[DT.maxColumns];
      int btn_ClockSelected = 0;
      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public VC_R_Comps() {
            for(int a = 0; a < DT.maxColumns; a++){
                  lbs[a] = new smallLB("Column " + (a + 1));
                  tfs[a] = new smallTF();
                  btns_m[a] = new smallBTN_C("-");
                  btns_p[a] = new smallBTN_C("+");
                  
                  panelsTypes[a] = new JPanel();
                  cbsTypes[a] = new smallCOMBX(DTSQL.mysqlTypes);
                  tfsTypes[a] = new smallTF();
                  
                  cksNulls[a] = new smallCHBX();
                  rbsPK[a] = new JRadioButton();
                  
                  panelsFK[a] = new JPanel();
                  rbsFK[a] = new JRadioButton();
                  tfsFK[a] = new smallTF();
                  
                  panelsDefaults[a] = new JPanel();
                  rbsDefaults[a] = new JRadioButton();
                  tfsDefaults[a] = new smallTF();
                  
                  panelsExtra[a] = new JPanel();
                  rbsExtra[a] = new JRadioButton();
                  cbsExtra[a] = new smallCOMBX();
                  tfsIDEN1[a] = new smallTF("1");
                  tfsIDEN2[a] = new smallTF("1");
                  
                  btns_Dist[a] = new smallBTN_TG(LKCustom.GP_CYAN_AND_WHITE);
                  btns_Dist2[a] = new smallBTN_TG(null);
                  btns_ImageC[a] = new smallBTN_TG(LKCustom.GP_GREEN_AND_WHITE);
                  btns_Tag[a] = new smallBTN_TG(LKCustom.GP_CYAN_AND_WHITE);
                  btns_Clock[a] = new smallBTN_TG(LKCustom.GP_YELLOW_AND_WHITE);
            }
 
            btns_m[0].setEnabled(false);
            btns_p[DT.maxColumns - 1].setEnabled(false);
            headers[10].setForeground(Color.GRAY);//DIST2
            //+++++++++++++++++++++++++++++++++++++++++
            extraPanels();
            defaultPanels();
            //+++++++++++++++++++++++++++++++++++++++++
            setNames();
            setSizes();
            setColorAndOthers();
            setListeners();
            //+++++++++++++++++++++++++++++++++
            MArrays ma = new MArrays();
            ma.addArray(lbs);
            ma.addArray(tfs);
            ma.addArray(btns_m);
            ma.addArray(btns_p);
            ma.addArray(panelsTypes);
            ma.addArray(cksNulls);
            ma.addArray(rbsPK);
            ma.addArray(panelsFK);
            ma.addArray(panelsDefaults);
            ma.addArray(panelsExtra);
            ma.addArray(btns_Dist);
            ma.addArray(btns_Dist2);
            ma.addArray(btns_ImageC);
            ma.addArray(btns_Tag);
            ma.addArray(btns_Clock);
            compsD = ma.getDoubleArrayComponents(false);
      }
      
      private void setNames() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  lbs[a].setName("LB_" + (a + 1));
                  tfs[a].setName("TF_" + (a + 1));
                  btns_m[a].setName("BTN_M_" + (a + 1));
                  btns_p[a].setName("BTN_P_" + (a + 1));
                  
                  panelsTypes[a].setName("PANEL_TYPES_" + (a + 1));
                  cbsTypes[a].setName("COMBTYPE_" + (a + 1));
                  tfsTypes[a].setName("TF_TYPE_" + (a + 1));
                  
                  cksNulls[a].setName("CHECKBNULL_" + (a + 1));
                  rbsPK[a].setName("RBPK_" + (a + 1));

                  panelsFK[a].setName("PANEL_FK_" + (a + 1));
                  rbsFK[a].setName("RB_FK_" + (a + 1));
                  tfsFK[a].setName("TF_FK_" + (a + 1));
                  
                  panelsDefaults[a].setName("PANEL_D_" + (a + 1));
                  rbsDefaults[a].setName("RBD_" + (a + 1));
                  tfsDefaults[a].setName("TFD_" + (a + 1));

                  panelsExtra[a].setName("PANEL_EX_" + (a + 1));
                  rbsExtra[a].setName("RB_EX_" + (a + 1));
                  cbsExtra[a].setName("CB_EX_" + (a + 1));
                  tfsIDEN1[a].setName("TFS_IDEN1_" + (a + 1));
                  tfsIDEN2[a].setName("TFS_IDEN2_" + (a + 1));

                  btns_Dist[a].setName("BTN_DIST_" + (a + 1));
                  btns_Dist2[a].setName("BTN_DIST2_" + (a + 1));
                  btns_ImageC[a].setName("BTN_IMAGEC_ " + (a + 1));
                  btns_Tag[a].setName("BTN_TAG_" + (a + 1));
                  btns_Clock[a].setName("BTN_CLOCK_ " + (a + 1));
            }
      }

      private void setColorAndOthers() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  panelsExtra[a].setBackground(LK_C.BK_PANELC);
                  panelsDefaults[a].setBackground(LK_C.BK_PANELC);
                  rbsPK[a].setBackground(LK_C.BK_PANELC);
                  rbsExtra[a].setBackground(LK_C.BK_PANELC);
                  rbsDefaults[a].setBackground(LK_C.BK_PANELC);

                  tfsDefaults[a].setForeground(Color.GRAY);

                  panelsExtra[a].setOpaque(true);
                  if (a != 0) {
                        //ONLY THE FIRST ONE STARTS WITH INT
                        cbsExtra[a].setEnabled(false);
                  }
                  panelsDefaults[a].setOpaque(true);
                  btns_Dist2[a].setEnabled(false);
                  rbsExtra[a].setOpaque(true);
                  cbsExtra[a].setOpaque(true);
                  tfsIDEN1[a].setOpaque(true);
                  tfsIDEN2[a].setOpaque(true);

                  cbsExtra[a].setVisible(false);
                  tfsIDEN1[a].setVisible(false);
                  tfsIDEN2[a].setVisible(false);
                  tfsDefaults[a].setVisible(false);

                  if (a == 0) {
                        cbsTypes[a].setSelectedIndex(0);
                  } else {
                        cbsTypes[a].setSelectedIndex(1);
                  }
            }
      }

      private void setSizes() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  tfs[a].setMinimumSize(LK_C.DIMENS_TFS_MIN);

                  panelsExtra[a].setMinimumSize(LK_C.DIMENS_PEXTRA_MIN);
                  panelsExtra[a].setMaximumSize(LK_C.DIMENS_PEXTRA_MAX);

                  tfsDefaults[a].setMinimumSize(LK_C.DIMENS_TFSD_MIN);
                  tfsDefaults[a].setPreferredSize(LK_C.DIMENS_TFSD_PREF);

                  cbsExtra[a].setMinimumSize(LK_C.DIMENS_COMBEX_MIN);
                  cbsExtra[a].setMaximumSize(LK_C.DIMENS_COMBEX_MAX);

                  tfsIDEN1[a].setMinimumSize(LK_C.DIMENS_TFSIDEN_FIX);
                  tfsIDEN1[a].setPreferredSize(LK_C.DIMENS_TFSIDEN_FIX);
                  tfsIDEN1[a].setMaximumSize(LK_C.DIMENS_TFSIDEN_FIX);
                  tfsIDEN2[a].setMinimumSize(LK_C.DIMENS_TFSIDEN_FIX);
                  tfsIDEN2[a].setPreferredSize(LK_C.DIMENS_TFSIDEN_FIX);
                  tfsIDEN2[a].setMaximumSize(LK_C.DIMENS_TFSIDEN_FIX);
            }
      }

      private void setListeners() {
            BTN_MP_AL btnAC = new BTN_MP_AL();
            CBType1_IL cbListener1 = new CBType1_IL();
            BTN_Dists btnDis = new BTN_Dists();
            SingleSelectionButton rbPKListener = new SingleSelectionButton(rbsPK, new PKAction());

            SingleSelectionButton rbExtraListener = new SingleSelectionButton(rbsExtra, new RBExtraAction());
            CBExtra_IL cbListener2 = new CBExtra_IL();

            VC_R_DataCom dt = MainInstances.getVC_R_DataCom();
            for (int a = 0; a < DT.maxColumns; a++) {
                  MTF_Control3 mtf = new MTF_Control3(new TFS_KControl());
                  mtf.addList(DTSQL.getBandWE_mysql(), MTF_Control3.EQUAL_MATCH);
                  mtf.addList(DTSQL.getBandWC_mysql(), MTF_Control3.CONTAIN_MATCH);
                  mtf.addList(dt.list_C, MTF_Control3.DUPLICATED_ELEMENTS);
                  mtf.setMinusIndex(2, a);
                  tfs[a].addKeyListener(mtf);

                  MBTN_Control mbtn = new MBTN_Control(null, new BTN_AControl());
                  mbtn.addList(dt.list_C, MTXControlData.DUPLICATED_ELEMENTS);
                  btns_m[a].addActionListener(mbtn);
                  btns_p[a].addActionListener(mbtn);

                  btns_m[a].addActionListener(btnAC);
                  btns_p[a].addActionListener(btnAC);
                  cbsTypes[a].addItemListener(cbListener1);
                  btns_Dist[a].addActionListener(btnDis);
                  btns_Tag[a].addActionListener(btnDis);
                  btns_ImageC[a].addActionListener(btnDis);
                  btns_Clock[a].addActionListener(btnDis);
                  rbsPK[a].addActionListener(rbPKListener);

                  rbsExtra[a].addActionListener(rbExtraListener);
                  cbsExtra[a].addItemListener(cbListener2);

                  rbsDefaults[a].addActionListener(new rbDefault_AL(a));
                  MComp.setPlaceHolderText(tfsDefaults[a], "NULL");
            }
      }

      private void extraPanels() {
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
                  cbsExtra[a] = (smallCOMBX) extraPanelFilter[1];
                  tfsIDEN1[a] = (NumberOTF) extraPanelFilter[2];
                  tfsIDEN2[a] = (NumberOTF) extraPanelFilter[3];
                  //++++++++++++++++++++++++++++++++++++++++++++++++
                  tfsIDEN1[a].setText("1");
                  tfsIDEN2[a].setText("1");
                  
                  MComp.setOnlyNumbersAllowed(tfsIDEN1[a], LimitN.ONE_TO_);
                  MComp.setOnlyNumbersAllowed(tfsIDEN2[a], LimitN.ONE_TO_);
                  //((AbstractDocument) tfsIDEN2[a].getDocument()).setDocumentFilter(new LimitN(LimitN.ONE_TO_));
                  //MComp.setOnlyNumbersAllowed(tfsIDEN1[a], LimitN.ONE_TO_);
                  //MComp.setOnlyNumbersAllowed(tfsIDEN2[a], LimitN.ONE_TO_);
                  //++++++++++++++++++++++++++++++++++++++++++++++++
                  cbsExtra[a].setRenderer(new ComboBoxRenderer());
            }
      }

      private void defaultPanels() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  rbsDefaults[a] = (JRadioButton) panelsDefaults[a].getComponent(0);
                  tfsDefaults[a] = (smallTF) panelsDefaults[a].getComponent(1);

            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public JComponent[][] getCompsD() {
            return compsD;
      }
      public JLabel[] getHeaders(){
            return headers;
      }
      
      public JLabel[] getLBS() {
            return lbs;
      }
      public JTextField[] getTFS() {
            return tfs;
      }
      public JButton[] getBTNS_P() {
            return btns_p;
      }
      public JButton[] getBTNS_M() {
            return btns_m;
      }

      public JComboBox[] getCBSTypes() {
            return cbsTypes;
      }
      public JCheckBox[] getCKSNulls() {
            return cksNulls;
      }

      public JPanel[] getPanelsDefaults(){
            return panelsDefaults;
      }
      public JRadioButton[] getRBSDefaults(){
            return rbsDefaults;
      }
      public JTextField[] getTFSDefaults(){
            return tfsDefaults;
      }
      
      public JPanel[] getPanelsExtra() {
            return panelsExtra;
      }
      public JRadioButton[] getRBSExtra() {
            return rbsExtra;
      }
      public int getRB_ExtraSelected(){
            return rb_ExtraSelected;
      } 
      public void setRB_ExtraSelected(int v){
            rb_ExtraSelected = v;
      }
      
      public JComboBox[] getCBSExtra() {
            return cbsExtra;
      }
      public JTextField[] getTFSIDEN1() {
            return tfsIDEN1;
      }
      public JTextField[] getTFSIDEN2() {
            return tfsIDEN2;
      }

      public JToggleButton[] getBTNS_Dist() {
            return btns_Dist;
      }
      public JToggleButton[] getBTNS_Dist2() {
            return btns_Dist2;
      }
      public JToggleButton[] getBTNS_ImageC() {
            return btns_ImageC;
      }
      public int getBTN_ImageCSelected() {
            return btn_ImageCSelected;
      }
      public void setBTN_ImageCSelected(int v) {
            btn_ImageCSelected = v;
      }
      
      public JToggleButton[] getBTNS_Tag() {
            return btns_Tag;
      }
      
      public JToggleButton[] getBTNS_Clock() {
            return btns_Clock;
      }
      public int getBTN_ClockSelected() {
            return btn_ClockSelected;
      }
      public void setBTN_ClockSelected(int v) {
            btn_ClockSelected = v;
      }
     
      public int getRB_PKSelected(){
            return rb_PKSelected;
      }
      public void setRB_PKSelected(int v){
            rb_PKSelected = v;
      }
      
      public int getRB_FKSelected(){
            return rb_FKSelected;
      }
      public void setRB_FKSelected(int v){
            rb_FKSelected = v;
      }
}
