/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.createUpdate;

import MC.DT;
import MC.DTSQL;
import MC.LKCustom;
import MC.LK_C;
import SQLStores.TableKeysList;
import com.cofii2.components.swing.ButtonGradient;
import com.cofii2.components.swing.CheckBoxBasic;
import com.cofii2.components.swing.ComboBoxCustom;
import com.cofii2.components.swing.LabelCustom;
import com.cofii2.components.swing.TextFieldCustom;
import com.cofii2.components.swing.ToggleButtonGradient;
import com.cofii2.methods.MComp;
import com.cofii2.methods.MList;
import com.cofii2.myListeners.ComboBoxsSelectionComponent;
import com.cofii2.myListeners.ComboBoxsSelectionItem;
import com.cofii2.myListeners.ComboBoxsSelectionProperty;
import com.cofii2.myListeners.MultiSelectionAction;
import com.cofii2.myListeners.MultiSelectionComponent;
import com.cofii2.myListeners.MultiSelectionProperty;
import com.cofii2.myListeners.SingleSelectionAction;
import com.cofii2.myListeners.SingleSelectionComponent;
import com.cofii2.myListeners.SingleSelectionProperty;
import com.cofii2.stores.MArrays;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import views.create.Actions.BTNClockAction;
import views.create.Actions.BTNImageCAction;
import views.create.Actions.BTNTagAction;
import views.create.Actions.RBDefaultsModel;
import views.create.Actions.RBExtraAction;
import views.create.Actions.RBFKAction;
import views.create.Actions.RBFKComponent;
import views.create.Actions.RBPKAction;
import views.create.Actions.RBPKComponent;
import views.create.listeners.CBCustom_IL;
import MC.MainInstances;
import com.cofii2.textControl.TextButtonControl;
import java.beans.PropertyChangeSupport;
import views.create.Actions.BTNDist2Action;
import views.create.Actions.BTNDistAction;
import views.create.Actions.BTN_AControl;
import views.create.Actions.RBDefaultsAction;
import views.create.Actions.RBDefaultsComponent;
import views.create.Actions.TFS_KControl;
import views.create.listeners.BTN_M_AL;
import views.create.listeners.BTN_P_AL;
import views.create.listeners.CBSTypes_IL;
import views.create.listeners.rbDefault_AL;
import com.cofii2.textControl.TextControl;
import com.cofii2.textControl.TextControlData;
import views.create.listeners.BTNColumnDelete_AL;
import views.create.listeners.CKBNull_AL;
import views.create.listeners.TFDefault_KL;
import views.create.listeners.TFTypes_KL;
import views.first.VF_R;

/**
 *
 * @author C0FII
 */
public class VC_R_Comps {

      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      String[] headers_Create = {
            "Cols Number", "Field",
            "Type", "Null", "PK", "FK", "Default", "Extra"};
      String[] headers_Dists = {
            "Dist", "Dist2", "ImC", "Tag", "Clock"};

      JLabel[] headers = new JLabel[headers_Create.length];
      JLabel[] headersDists = new JLabel[5];
      JComponent[][] compsD;
      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      JLabel[] lbs = new JLabel[DT.maxColumns];

      JPanel[] panelsTFS = new JPanel[DT.maxColumns];
      JTextField[] tfs = new JTextField[DT.maxColumns];
      JButton[] btns_p = new JButton[DT.maxColumns];
      JButton[] btns_m = new JButton[DT.maxColumns];
      JButton[] btnsChange_Name = new JButton[DT.maxColumns];

      JPanel[] panelsTypes = new JPanel[DT.maxColumns];
      JComboBox[] cbsTypes = new JComboBox[DT.maxColumns];
      JTextField[] tfsTypes = new JTextField[DT.maxColumns];
      JButton[] btnsChange_Types = new JButton[DT.maxColumns];

      JPanel[] panelsNulls = new JPanel[DT.maxColumns];
      JCheckBox[] cksNulls = new JCheckBox[DT.maxColumns];
      JButton[] btnsChange_Nulls = new JButton[DT.maxColumns];

      JPanel[] panelsPK = new JPanel[DT.maxColumns];
      JRadioButton[] rbsPK = new JRadioButton[DT.maxColumns];
      JButton[] btnsChange_PK = new JButton[DT.maxColumns];

      JPanel[] panelsFK = new JPanel[DT.maxColumns];
      JRadioButton[] rbsFK = new JRadioButton[DT.maxColumns];
      JComboBox[] cbsFK = new JComboBox[DT.maxColumns];
      JButton[] btnsChange_FK = new JButton[DT.maxColumns];

      String[] primaryKeys;

      JPanel[] panelsDefaults = new JPanel[DT.maxColumns];
      JRadioButton[] rbsDefaults = new JRadioButton[DT.maxColumns];
      int rbDefaultsSelected = 0;
      JTextField[] tfsDefaults = new JTextField[DT.maxColumns];
      JButton[] btnsChange_Defaults = new JButton[DT.maxColumns];

      JPanel[] panelsExtra = new JPanel[DT.maxColumns];
      JRadioButton[] rbsExtra = new JRadioButton[DT.maxColumns];
      JButton[] btnsChange_Extra = new JButton[DT.maxColumns];
      int rb_ExtraSelected = 0;
      //String[] extraItems = new String[]{"AUTO_INCREMENT", "IDENTITY"};//MYSQL DOES NOT SUPPORT IDENTITY
      //JComboBox[] cbsExtra = new JComboBox[DT.maxColumns];
      //JTextField[] tfsIDEN1 = new JTextField[DT.maxColumns];
      //JTextField[] tfsIDEN2 = new JTextField[DT.maxColumns];

      String[] customs = new String[]{"NONE", "Dist", "Dist2"};
      JTextField[] tfes_Customs = new JTextField[DT.maxColumns];
      JComboBox[] cbs_Customs = new JComboBox[DT.maxColumns];
      JToggleButton[] btns_Dist = new JToggleButton[DT.maxColumns];
      JToggleButton[] btns_Dist2 = new JToggleButton[DT.maxColumns - 1];
      JButton btnChange_DistDist2 = new ButtonGradient("C", Color.BLUE);
      JToggleButton[] btns_ImageC = new JToggleButton[DT.maxColumns];
      JButton btnChange_ImageC = new ButtonGradient("C", Color.BLUE);
      int btn_ImageCSelected = 0;
      JToggleButton[] btns_Tag = new JToggleButton[DT.maxColumns];
      JButton btnChange_Tag = new ButtonGradient("C", Color.BLUE);
      JToggleButton[] btns_Clock = new JToggleButton[DT.maxColumns];
      JButton btnChange_Clock = new ButtonGradient("C", Color.BLUE);
      int btn_ClockSelected = 0;
      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      private int columnDisplayed = 2;
      private BTNDistAction btnDistAction;
      private BTNDist2Action btnDist2Action;

      UpdateStore updateStore;

      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public VC_R_Comps() {
            start();
      }

      public VC_R_Comps(String update) {
            setUpdateStore(new UpdateStore());
            start();
      }

      private void start() {
            for (int a = 0; a < headers.length; a++) {
                  headers[a] = new LabelCustom(headers_Create[a]);
            }
            for (int a = 0; a < 5; a++) {
                  headersDists[a] = new LabelCustom(headers_Dists[a]);
            }
            //QUERY FOR CBS_FK +++++++++++++++++++++++++++++++++++++++++++++
            ArrayList<String> listPK = new ArrayList<>();
            for (int a = 0; a < TableKeysList.size(); a++) {
                  int pk = TableKeysList.getPKS().get(a).index;
                  String table = TableKeysList.getTables().get(a);
                  String pkColumn = TableKeysList.getPKS().get(a).string;
                  if (pk > 0) {
                        listPK.add(table + "." + pkColumn);
                  }
            }
            primaryKeys = MList.getListToArray(String.class, listPK);

            for (int a = 0; a < DT.maxColumns; a++) {
                  lbs[a] = new LabelCustom("Column " + (a + 1));

                  panelsTFS[a] = new JPanel();
                  tfs[a] = new TextFieldCustom();
                  if (updateStore == null) {
                        btns_m[a] = new ButtonGradient("-");
                        btns_p[a] = new ButtonGradient("+");
                  } else {
                        btnsChange_Name[a] = new ButtonGradient("C", Color.BLUE);
                        btns_m[a] = new ButtonGradient("x");
                        btns_p[a] = new ButtonGradient("+");
                  }

                  panelsTypes[a] = new JPanel();
                  cbsTypes[a] = new ComboBoxCustom(DTSQL.mysqlTypes);
                  tfsTypes[a] = new TextFieldCustom();
                  if (updateStore != null) {
                        btnsChange_Types[a] = new ButtonGradient("C", Color.BLUE);
                  }

                  panelsNulls[a] = new JPanel();
                  cksNulls[a] = new CheckBoxBasic();
                  if (updateStore != null) {
                        btnsChange_Nulls[a] = new ButtonGradient("C", Color.BLUE);
                  }

                  panelsPK[a] = new JPanel();
                  rbsPK[a] = new JRadioButton();
                  if (updateStore != null) {
                        btnsChange_PK[a] = new ButtonGradient("C", Color.BLUE);//ADD CONTROL FOR AUTO_INCREMENT
                  }

                  panelsFK[a] = new JPanel();
                  rbsFK[a] = new JRadioButton();
                  cbsFK[a] = new ComboBoxCustom(primaryKeys);
                  if (updateStore != null) {
                        btnsChange_FK[a] = new ButtonGradient("C", Color.BLUE);
                  }

                  panelsDefaults[a] = new JPanel();
                  rbsDefaults[a] = new JRadioButton();
                  tfsDefaults[a] = new TextFieldCustom();
                  if (updateStore != null) {
                        btnsChange_Defaults[a] = new ButtonGradient("C", Color.BLUE);
                  }

                  panelsExtra[a] = new JPanel();
                  rbsExtra[a] = new JRadioButton();
                  if (updateStore != null) {
                        btnsChange_Extra[a] = new ButtonGradient("C", Color.BLUE);
                  }

                  //cbs_Customs[a] = new ComboBoxE(customs);
                  //tfes_Customs[a] = (JTextField) cbs_Customs[a].getEditor().getEditorComponent();
                  btns_Dist[a] = new ToggleButtonGradient(LKCustom.GP_CYAN_AND_WHITE, Color.BLACK, Integer.toString(a + 1));
                  if (a != DT.maxColumns - 1) {
                        btns_Dist2[a] = new ToggleButtonGradient(new Color[]{Color.BLUE, Color.WHITE}, Color.BLACK, (a + 1) + "-" + (a + 2));
                  }
                  btns_ImageC[a] = new ToggleButtonGradient(LKCustom.GP_GREEN_AND_WHITE, Color.BLACK, Integer.toString(a + 1));
                  btns_Tag[a] = new ToggleButtonGradient(LKCustom.GP_CYAN_AND_WHITE, Color.BLACK, Integer.toString(a + 1));
                  btns_Clock[a] = new ToggleButtonGradient(LKCustom.GP_YELLOW_AND_WHITE, Color.BLACK, Integer.toString(a + 1));

            }

            panelTFS();
            panelTypes();
            panelNulls();
            panelPKS();
            panelFKS();
            panelDefaults();
            panelExtras();

            if (updateStore == null) {
                  btns_m[0].setEnabled(false);
                  btns_p[DT.maxColumns - 1].setEnabled(false);
            }

            setNames();
            setSizes();
            setColorAndOthers();
            setConfig();
            //enabledControl();
            //++++++++++++++++++++++++++++++++++++++++++
            MArrays ma = new MArrays();
            ma.addArray(lbs);
            ma.addArray(panelsTFS);
            ma.addArray(panelsTypes);
            ma.addArray(panelsNulls);
            ma.addArray(panelsPK);
            ma.addArray(panelsFK);
            ma.addArray(panelsDefaults);
            ma.addArray(panelsExtra);
            //ma.addArray(cbs_Customs);
            //ma.addArray(btns_Dist);
            //ma.addArray(btns_Dist2);
            //ma.addArray(btns_ImageC);
            //ma.addArray(btns_Tag);
            //ma.addArray(btns_Clock);
            compsD = ma.getDoubleArrayComponents(false);
      }
      //+++++++++++++++++++++++++++++++++++++++++++++++++

      private void panelTFS() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  panelsTFS[a].setLayout(new BoxLayout(panelsTFS[a], BoxLayout.X_AXIS));
                  panelsTFS[a].add(tfs[a], 0);
                  panelsTFS[a].add(btns_m[a], 1);
                  panelsTFS[a].add(btns_p[a], 2);
                  if (updateStore != null) {
                        panelsTFS[a].add(btnsChange_Name[a], 3);
                  }
            }
      }

      private void panelTypes() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  panelsTypes[a].setLayout(new BoxLayout(panelsTypes[a], BoxLayout.X_AXIS));
                  panelsTypes[a].add(cbsTypes[a], 0);
                  panelsTypes[a].add(tfsTypes[a], 1);
                  if (updateStore != null) {
                        panelsTypes[a].add(btnsChange_Types[a], 2);
                        btnsChange_Types[a].setToolTipText("change type");
                  }
                  //MComp.setPlaceHolderText(tfsTypes[a], "1", Color.WHITE, Color.WHITE);

            }
      }

      private void addingDocumnetFilterToTFSTypes() {
            if (updateStore == null) {
                  for (int a = 0; a < DT.maxColumns; a++) {
                        if (a == 0) {
                              MComp.setOnlyNumbersAllowed(tfsTypes[a], DTSQL.INT_MIN_WIDTH, DTSQL.INT_MAX_WIDTH);
                              cbsTypes[a].setSelectedItem("INT");
                              tfsTypes[a].setToolTipText("Max " + DTSQL.INT_MAX_WIDTH);
                              tfsTypes[a].setText(Integer.toString(DTSQL.INT_DEFAULT_WIDTH));
                        } else {
                              MComp.setOnlyNumbersAllowed(tfsTypes[a], DTSQL.CHAR_MIN_WIDTH, DTSQL.CHAR_MAX_WIDTH);
                              cbsTypes[a].setSelectedItem("CHAR");
                              tfsTypes[a].setToolTipText("Max " + DTSQL.CHAR_MAX_WIDTH);
                              tfsTypes[a].setText(Integer.toString(DTSQL.CHAR_DEFAULT_WIDTH));
                              //System.out.println("CBS TEST PanelTypes: " + cbsTypes[1].getSelectedItem().toString());
                        }
                  }
            } else {
                  for (int a = 0; a < VF_R.getJT().getColumnCount(); a++) {
                        int index = cbsTypes[a].getSelectedIndex();
                        String selected = cbsTypes[a].getSelectedItem().toString();
                        if (MList.isOnThisArray(DTSQL.mysqlTypesFixedWidth, selected)) {

                              MComp.setOnlyNumbersAllowed(tfsTypes[a],
                                      DTSQL.mysql_TypesIntMinSize[index], DTSQL.mysql_TypesIntMaxSize[index]);
                              tfsTypes[a].setToolTipText("Max " + DTSQL.mysql_TypesIntMaxSize[index]);
                        }
                  }
            }
      }

      private void panelNulls() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  panelsNulls[a].setLayout(new BoxLayout(panelsNulls[a], BoxLayout.X_AXIS));
                  panelsNulls[a].add(cksNulls[a], 0);
                  if (updateStore != null) {
                        panelsNulls[a].add(btnsChange_Nulls[a], 1);
                  }
            }
      }

      private void panelPKS() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  panelsPK[a].setLayout(new BoxLayout(panelsPK[a], BoxLayout.X_AXIS));
                  panelsPK[a].add(rbsPK[a], 0);
                  if (updateStore != null) {
                        panelsPK[a].add(btnsChange_PK[a], 1);
                        btnsChange_PK[a].setToolTipText("update PK");
                  }
            }
      }

      private void panelFKS() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  panelsFK[a].setLayout(new BoxLayout(panelsFK[a], BoxLayout.X_AXIS));
                  panelsFK[a].add(rbsFK[a], 0);
                  panelsFK[a].add(cbsFK[a], 1);
                  if (updateStore != null) {
                        panelsFK[a].add(btnsChange_FK[a], 2);
                        btnsChange_FK[a].setToolTipText("update FK");
                  }

                  //rbsFK[a].setVisible(true);
                  cbsFK[a].setVisible(false);
            }
      }

      private void panelDefaults() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  panelsDefaults[a].setLayout(new BoxLayout(panelsDefaults[a], BoxLayout.X_AXIS));
                  panelsDefaults[a].add(rbsDefaults[a], 0);
                  panelsDefaults[a].add(tfsDefaults[a], 1);
                  if (updateStore != null) {
                        panelsDefaults[a].add(btnsChange_Defaults[a], 2);
                        btnsChange_Defaults[a].setToolTipText("remove Default value");
                  }
            }
      }

      private void panelExtras() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  panelsExtra[a].setLayout(new BoxLayout(panelsExtra[a], BoxLayout.X_AXIS));
                  panelsExtra[a].add(rbsExtra[a], 0);
                  if (updateStore != null) {
                        panelsExtra[a].add(btnsChange_Extra[a], 1);
                        btnsChange_Extra[a].setToolTipText("change Auto_increment value");
                  }
            }

      }

      //++++++++++++++++++++++++++++++++++++++++
      private void setNames() {
            boolean tab = false;
            if (updateStore != null) {
                  tab = true;
            }
            for (int a = 0; a < DT.maxColumns; a++) {
                  lbs[a].setName("LB_" + (a + 1));

                  panelsTFS[a].setName("PANEL_TFS_" + (a + 1));
                  tfs[a].setName("TF_" + (a + 1));
                  btns_m[a].setName("BTN_M_" + (a + 1));
                  btns_p[a].setName("BTN_P_" + (a + 1));
                  if (tab) {
                        btnsChange_Name[a].setName("BTN_CHANGE_NAME_" + (a + 1));
                  }

                  panelsTypes[a].setName("PANEL_TYPES_" + (a + 1));
                  cbsTypes[a].setName("COMBTYPE_" + (a + 1));
                  tfsTypes[a].setName("TF_TYPE_" + (a + 1));
                  if (tab) {
                        btnsChange_Types[a].setName("BTN_CHANGE_TYPE_" + (a + 1));
                  }

                  panelsNulls[a].setName("PANEL_NULLS_" + (a + 1));
                  cksNulls[a].setName("CHECKBNULL_" + (a + 1));
                  if (tab) {
                        btnsChange_Nulls[a].setName("BTN_CHANGE_NULL_" + (a + 1));
                  }

                  panelsPK[a].setName("PANEL_PK_" + (a + 1));
                  rbsPK[a].setName("RBPK_" + (a + 1));
                  if (tab) {
                        btnsChange_PK[a].setName("BTN_CHANGE_PK_" + (a + 1));
                  }

                  panelsFK[a].setName("PANEL_FK_" + (a + 1));
                  rbsFK[a].setName("RB_FK_" + (a + 1));
                  cbsFK[a].setName("CB_FK_" + (a + 1));
                  if (tab) {
                        btnsChange_FK[a].setName("BTN_CHANGE_FK_" + (a + 1));
                  }

                  panelsDefaults[a].setName("PANEL_D_" + (a + 1));
                  rbsDefaults[a].setName("RBD_" + (a + 1));
                  tfsDefaults[a].setName("TFD_" + (a + 1));
                  if (tab) {
                        btnsChange_Defaults[a].setName("BTN_REMOVE_DEFAULT_" + (a + 1));
                  }

                  panelsExtra[a].setName("PANEL_EXTRA_" + (a + 1));
                  rbsExtra[a].setName("RB_EX_" + (a + 1));
                  if (tab) {
                        btnsChange_Extra[a].setName("BTN_CHANGE_EXTRA_" + (a + 1));
                  }

                  //cbs_Customs[a].setName("CB_CUSTOM_" + (a + 1));
                  btns_Dist[a].setName("BTN_DIST_" + (a + 1));
                  if (a != DT.maxColumns - 1) {
                        btns_Dist2[a].setName("BTN_DIST2_" + (a + 1) + "-" + (a + 2));
                  }
                  btns_ImageC[a].setName("BTN_IMAGEC_ " + (a + 1));
                  btns_Tag[a].setName("BTN_TAG_" + (a + 1));
                  btns_Clock[a].setName("BTN_CLOCK_ " + (a + 1));

            }
      }

      private void setColorAndOthers() {
            Color color = LK_C.BK_PANELC;
            for (int a = 0; a < DT.maxColumns; a++) {

                  panelsTFS[a].setBackground(color);
                  panelsTypes[a].setBackground(color);
                  panelsNulls[a].setBackground(color);
                  panelsPK[a].setBackground(color);
                  panelsFK[a].setBackground(color);
                  panelsExtra[a].setBackground(color);
                  panelsDefaults[a].setBackground(color);

                  rbsPK[a].setBackground(color);
                  rbsFK[a].setBackground(color);
                  rbsExtra[a].setBackground(color);
                  rbsDefaults[a].setBackground(color);

                  panelsTFS[a].setOpaque(true);
                  panelsTypes[a].setOpaque(true);
                  panelsNulls[a].setOpaque(true);
                  panelsPK[a].setOpaque(true);
                  panelsFK[a].setOpaque(true);
                  panelsExtra[a].setOpaque(true);
                  panelsDefaults[a].setOpaque(true);

                  rbsPK[a].setOpaque(true);
                  rbsFK[a].setOpaque(true);
                  rbsExtra[a].setOpaque(true);
                  rbsDefaults[a].setOpaque(true);

                  //cbs_Customs[a].setBackground(null);
            }
      }

      private void setConfig() {
            for (int a = 0; a < DT.maxColumns; a++) {

                  cksNulls[a].setSelected(true);

                  if (a != 0) {
                        //ONLY THE FIRST ONE STARTS WITH INT
                        //cbsExtra[a].setEnabled(false);
                  }
                  //cbsExtra[a].setVisible(false);
                  //tfsIDEN1[a].setVisible(false);
                  //tfsIDEN2[a].setVisible(false);
                  tfsDefaults[a].setVisible(false);

                  //ComboBoxCellRenderer renderer = new ComboBoxCellRenderer(cbs_Customs[a]);
                  //renderer.set("Dist2", false);
                  //cbs_Customs[a].setRenderer(renderer);
            }
            //((ComboBoxCellRenderer) cbs_Customs[1].getRenderer()).setDisableItem("Dist2", false);
      }

      private void setSizes() {
            boolean tab = false;
            if (updateStore != null) {
                  tab = true;
            }
            for (int a = 0; a < DT.maxColumns; a++) {
                  if (tab) {
                        panelsTFS[a].setMinimumSize(new Dimension(290, 27));
                        panelsTFS[a].setPreferredSize(new Dimension(290, 27));
                        panelsTFS[a].setMaximumSize(new Dimension(290, 27));

                        btnsChange_Name[a].setMinimumSize(LK_C.DIMENS_BTNS_FIXED);
                        btnsChange_Name[a].setPreferredSize(LK_C.DIMENS_BTNS_FIXED);
                        btnsChange_Name[a].setMaximumSize(LK_C.DIMENS_BTNS_FIXED);
                  } else {
                        panelsTFS[a].setMinimumSize(new Dimension(260, 27));
                        panelsTFS[a].setPreferredSize(new Dimension(260, 27));
                        panelsTFS[a].setMaximumSize(new Dimension(260, 27));
                  }
                  tfs[a].setMinimumSize(LK_C.DIMENS_TFS_FIXED);
                  tfs[a].setPreferredSize(LK_C.DIMENS_TFS_FIXED);
                  tfs[a].setMaximumSize(LK_C.DIMENS_TFS_FIXED);//200
                  btns_m[a].setMinimumSize(LK_C.DIMENS_BTNS_FIXED);
                  btns_m[a].setPreferredSize(LK_C.DIMENS_BTNS_FIXED);
                  btns_m[a].setMaximumSize(LK_C.DIMENS_BTNS_FIXED);
                  btns_p[a].setMinimumSize(LK_C.DIMENS_BTNS_FIXED);
                  btns_p[a].setPreferredSize(LK_C.DIMENS_BTNS_FIXED);
                  btns_p[a].setMaximumSize(LK_C.DIMENS_BTNS_FIXED);

                  if (tab) {
                        panelsTypes[a].setMinimumSize(new Dimension(270, 27));
                        panelsTypes[a].setPreferredSize(new Dimension(270, 27));
                        panelsTypes[a].setMaximumSize(new Dimension(270, 27));
                        btnsChange_Types[a].setMinimumSize(new Dimension(30, 27));
                        btnsChange_Types[a].setPreferredSize(new Dimension(30, 27));
                        btnsChange_Types[a].setMaximumSize(new Dimension(30, 27));
                  } else {
                        panelsTypes[a].setMinimumSize(new Dimension(240, 27));
                        panelsTypes[a].setPreferredSize(new Dimension(240, 27));
                        panelsTypes[a].setMaximumSize(new Dimension(240, 27));
                  }
                  tfsTypes[a].setMinimumSize(new Dimension(40, 27));
                  tfsTypes[a].setPreferredSize(new Dimension(40, 27));
                  tfsTypes[a].setMaximumSize(new Dimension(40, 27));
                  cbsTypes[a].setMinimumSize(new Dimension(200, 27));
                  cbsTypes[a].setPreferredSize(new Dimension(200, 27));
                  cbsTypes[a].setMaximumSize(new Dimension(200, 27));

                  if (tab) {
                        panelsNulls[a].setMinimumSize(new Dimension(60, 27));
                        panelsNulls[a].setMaximumSize(new Dimension(60, 27));
                        panelsNulls[a].setPreferredSize(new Dimension(60, 27));

                        btnsChange_Nulls[a].setMinimumSize(new Dimension(30, 27));
                        btnsChange_Nulls[a].setMaximumSize(new Dimension(30, 27));
                        btnsChange_Nulls[a].setPreferredSize(new Dimension(30, 27));
                  } else {
                        panelsNulls[a].setMinimumSize(new Dimension(30, 27));
                        panelsNulls[a].setMaximumSize(new Dimension(30, 27));
                        panelsNulls[a].setPreferredSize(new Dimension(30, 27));
                  }
                  cksNulls[a].setMinimumSize(new Dimension(30, 27));
                  cksNulls[a].setMaximumSize(new Dimension(30, 27));
                  cksNulls[a].setPreferredSize(new Dimension(30, 27));

                  if (tab) {
                        panelsPK[a].setMinimumSize(new Dimension(60, 27));
                        panelsPK[a].setMinimumSize(new Dimension(60, 27));
                        panelsPK[a].setMinimumSize(new Dimension(60, 27));

                        btnsChange_PK[a].setMinimumSize(new Dimension(LK_C.DIMENS_BTNS_FIXED));
                        btnsChange_PK[a].setMaximumSize(new Dimension(LK_C.DIMENS_BTNS_FIXED));
                        btnsChange_PK[a].setPreferredSize(new Dimension(LK_C.DIMENS_BTNS_FIXED));
                  } else {
                        panelsPK[a].setMinimumSize(new Dimension(30, 27));
                        panelsPK[a].setMinimumSize(new Dimension(30, 27));
                        panelsPK[a].setMinimumSize(new Dimension(30, 27));
                  }
                  rbsPK[a].setMinimumSize(new Dimension(30, 27));
                  rbsPK[a].setMaximumSize(new Dimension(30, 27));
                  rbsPK[a].setPreferredSize(new Dimension(30, 27));

                  if (tab) {
                        panelsFK[a].setMinimumSize(new Dimension(60, 27));
                        panelsFK[a].setMaximumSize(new Dimension(60, 27));
                        panelsFK[a].setPreferredSize(new Dimension(60, 27));

                        btnsChange_FK[a].setMinimumSize(new Dimension(LK_C.DIMENS_BTNS_FIXED));
                        btnsChange_FK[a].setPreferredSize(new Dimension(LK_C.DIMENS_BTNS_FIXED));
                        btnsChange_FK[a].setMaximumSize(new Dimension(LK_C.DIMENS_BTNS_FIXED));
                  } else {
                        panelsFK[a].setMinimumSize(new Dimension(30, 27));
                        panelsFK[a].setMaximumSize(new Dimension(30, 27));
                        panelsFK[a].setPreferredSize(new Dimension(30, 27));
                  }
                  rbsFK[a].setMinimumSize(new Dimension(30, 27));
                  rbsFK[a].setMaximumSize(new Dimension(30, 27));
                  rbsFK[a].setPreferredSize(new Dimension(30, 27));//CHANGE FIXED DIMENSION WHEN RBS IS ACTIVATED
                  cbsFK[a].setMinimumSize(new Dimension(130, 27));
                  cbsFK[a].setMaximumSize(new Dimension(130, 27));
                  cbsFK[a].setPreferredSize(new Dimension(130, 27));

                  if (tab) {
                        panelsDefaults[a].setMinimumSize(new Dimension(60, 27));
                        panelsDefaults[a].setMaximumSize(new Dimension(60, 27));
                        panelsDefaults[a].setPreferredSize(new Dimension(60, 27));
                        btnsChange_Defaults[a].setMinimumSize(new Dimension(LK_C.DIMENS_BTNS_FIXED));
                        btnsChange_Defaults[a].setMaximumSize(new Dimension(LK_C.DIMENS_BTNS_FIXED));
                        btnsChange_Defaults[a].setPreferredSize(new Dimension(LK_C.DIMENS_BTNS_FIXED));
                  } else {
                        panelsDefaults[a].setMinimumSize(new Dimension(30, 27));
                        panelsDefaults[a].setMaximumSize(new Dimension(30, 27));
                        panelsDefaults[a].setPreferredSize(new Dimension(30, 27));
                  }
                  rbsDefaults[a].setMinimumSize(new Dimension(30, 27));
                  rbsDefaults[a].setMaximumSize(new Dimension(30, 27));
                  rbsDefaults[a].setPreferredSize(new Dimension(30, 27));
                  tfsDefaults[a].setMinimumSize(new Dimension(100, 27));
                  tfsDefaults[a].setMaximumSize(new Dimension(100, 27));
                  tfsDefaults[a].setPreferredSize(new Dimension(100, 27));

                  if (tab) {
                        panelsExtra[a].setMinimumSize(new Dimension(60, 27));
                        panelsExtra[a].setMaximumSize(new Dimension(60, 27));
                        panelsExtra[a].setPreferredSize(new Dimension(60, 27));
                        btnsChange_Extra[a].setMinimumSize(LK_C.DIMENS_BTNS_FIXED);
                        btnsChange_Extra[a].setMaximumSize(LK_C.DIMENS_BTNS_FIXED);
                        btnsChange_Extra[a].setPreferredSize(LK_C.DIMENS_BTNS_FIXED);
                  } else {
                        panelsExtra[a].setMinimumSize(new Dimension(30, 27));
                        panelsExtra[a].setMaximumSize(new Dimension(30, 27));
                        panelsExtra[a].setPreferredSize(new Dimension(30, 27));
                  }
                  rbsExtra[a].setMinimumSize(new Dimension(30, 27));
                  rbsExtra[a].setMaximumSize(new Dimension(30, 27));
                  rbsExtra[a].setPreferredSize(new Dimension(30, 27));

            }
      }

      public void setListeners() {
            addingDocumnetFilterToTFSTypes();
            //+++++++++++++++++++++++++++++++++++++++++++++
            ActionListener rbPK_AL = new RBPKAction();
            ComponentAdapter rbPK_CA = new RBPKComponent();

            ActionListener rbFK_AL = new RBFKAction();
            ComponentAdapter rbFK_CA = new RBFKComponent();

            ActionListener rbDefault_AL = new RBDefaultsAction();
            ComponentAdapter rbDefault_CA = new RBDefaultsComponent();

            //SingleSelectionAction rbDefault_AL = new SingleSelectionAction(rbsDefaults, new RBDefaultsModel(table));
            //SingleSelectionComponent rbDefault_CA = new SingleSelectionComponent(rbsDefaults, new RBDefaultsModel(table));
            SingleSelectionAction rbExtra_AL = new SingleSelectionAction(rbsExtra, new RBExtraAction());
            SingleSelectionComponent rbExtra_CA = new SingleSelectionComponent(rbsExtra, new RBExtraAction());
            //DISTS +++++++++++++++++++++++++++++++++++++++++++
            ComboBoxsSelectionItem cbsCustom_IL = new ComboBoxsSelectionItem(cbs_Customs, new CBCustom_IL());
            ComboBoxsSelectionComponent cbsCustom_CA = new ComboBoxsSelectionComponent(cbs_Customs, new CBCustom_IL());
            ComboBoxsSelectionProperty cbsCustom_PC = new ComboBoxsSelectionProperty(cbs_Customs, new CBCustom_IL());

            btnDistAction = new BTNDistAction();
            MultiSelectionAction btnDist_AL = new MultiSelectionAction(btns_Dist, btnDistAction);
            MultiSelectionComponent btnDist_CA = new MultiSelectionComponent(btns_Dist, btnDistAction);
            MultiSelectionProperty btnDist_PC = new MultiSelectionProperty(btns_Dist, btnDistAction);

            btnDist2Action = new BTNDist2Action();
            MultiSelectionAction btnDist2_AL = new MultiSelectionAction(btns_Dist2, btnDist2Action);
            MultiSelectionComponent btnDist2_CA = new MultiSelectionComponent(btns_Dist2, btnDist2Action);
            MultiSelectionProperty btnDist2_PC = new MultiSelectionProperty(btns_Dist2, btnDist2Action);

            SingleSelectionAction btnImageC_AL = new SingleSelectionAction(btns_ImageC, new BTNImageCAction());
            SingleSelectionComponent btnImageC_CA = new SingleSelectionComponent(btns_ImageC, new BTNImageCAction());
            SingleSelectionProperty btnImageC_PC = new SingleSelectionProperty(btns_ImageC, new BTNImageCAction());

            MultiSelectionAction btnTag_AL = new MultiSelectionAction(btns_Tag, new BTNTagAction());
            MultiSelectionComponent btnTag_CA = new MultiSelectionComponent(btns_Tag, new BTNTagAction());
            MultiSelectionProperty btnTag_PC = new MultiSelectionProperty(btns_Tag, new BTNTagAction());

            SingleSelectionAction btnClock_AL = new SingleSelectionAction(btns_Clock, new BTNClockAction());
            SingleSelectionComponent btnClock_CA = new SingleSelectionComponent(btns_Clock, new BTNClockAction());
            SingleSelectionProperty btnClock_PC = new SingleSelectionProperty(btns_Clock, new BTNClockAction());

            //SingleSelectionButton rbExtraListener = new SingleSelectionButton(rbsExtra, new RBExtraAction());
            //CBExtra_IL cbListener2 = new CBExtra_IL();
            VC_R_DataCom dt = MainInstances.getVC_R_DataCom();
            for (int a = 0; a < DT.maxColumns; a++) {
                  //TFS & BTNS WORDS CONTROL ++++++++++++++++++++++++++++++++++++++++++
                  TextControl mtf = new TextControl(new TFS_KControl(a), TextControl.KEY_RELEASED);
                  mtf.addList(DTSQL.getBandWE_mysql(), TextControl.EQUAL_MATCH);
                  mtf.addList(DTSQL.getBandWC_mysql(), TextControl.CONTAIN_MATCH);
                  mtf.addList(dt.list_C, TextControl.DUPLICATED_ELEMENTS);
                  mtf.setMinusIndex(2, a);
                  tfs[a].addKeyListener(mtf);
                  if (updateStore != null) {
                        btns_m[a].addActionListener(new BTNColumnDelete_AL(a));
                  } else {
                        TextButtonControl mbtn = new TextButtonControl(null, new BTN_AControl());
                        mbtn.addList(dt.list_C, TextControlData.DUPLICATED_ELEMENTS);
                        btns_m[a].addActionListener(mbtn);
                        btns_p[a].addActionListener(mbtn);

                        btns_m[a].addActionListener(new BTN_M_AL(a));
                        btns_p[a].addActionListener(new BTN_P_AL(a));
                  }

                  //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                  cbsTypes[a].addItemListener(new CBSTypes_IL(a));
                  tfsTypes[a].addKeyListener(new TFTypes_KL(a));

                  cksNulls[a].addActionListener(new CKBNull_AL(a));

                  tfsDefaults[a].addKeyListener(new TFDefault_KL());
                  //+++++++++++++++++++++++++++++++++++++++++++++++++++
                  btns_Dist[a].addActionListener(btnDist_AL);
                  btns_Dist[a].addComponentListener(btnDist_CA);
                  btns_Dist[a].addPropertyChangeListener("enabled", btnDist_PC);
                  if (a != DT.maxColumns - 1) {
                        btns_Dist2[a].addActionListener(btnDist2_AL);
                        btns_Dist2[a].addComponentListener(btnDist2_CA);
                        btns_Dist2[a].addPropertyChangeListener("enabled", btnDist2_PC);
                  }
                  btns_Tag[a].addActionListener(btnTag_AL);
                  btns_Tag[a].addComponentListener(btnTag_CA);
                  btns_Tag[a].addPropertyChangeListener("enabled", btnTag_PC);

                  btns_ImageC[a].addActionListener(btnImageC_AL);
                  btns_ImageC[a].addComponentListener(btnImageC_CA);
                  btns_ImageC[a].addPropertyChangeListener("enabled", btnImageC_PC);

                  btns_Clock[a].addActionListener(btnClock_AL);
                  btns_Clock[a].addComponentListener(btnClock_CA);
                  btns_Clock[a].addPropertyChangeListener("enabled", btnClock_PC);
                  //++++++++++++++++++++++++++++++++++++++++++++++++++++
                  rbsPK[a].addActionListener(rbPK_AL);
                  rbsPK[a].addComponentListener(rbPK_CA);

                  rbsFK[a].addActionListener(rbFK_AL);
                  rbsFK[a].addComponentListener(rbFK_CA);

                  rbsDefaults[a].addActionListener(rbDefault_AL);
                  rbsDefaults[a].addComponentListener(rbDefault_CA);

                  rbsExtra[a].addActionListener(rbExtra_AL);
                  rbsExtra[a].addComponentListener(rbExtra_CA);

                  //cbsExtra[a].addItemListener(cbListener2);
                  rbsDefaults[a].addActionListener(new rbDefault_AL(a));
                  //MComp.setPlaceHolderText(tfsDefaults[a], "NULL");
            }
            for (int a = 0; a < VF_R.getJT().getColumnCount(); a++) {
                  
            }
      }

      /**
       * Type Control depending of each custom situacion or errors that may
       * happen
       *
       */
      public void enabledControl() {
            for (int a = 0; a < DT.maxColumns; a++) {
                  //CREATE CONTROL FOR DISABLE RBSEXTRA IF THERE IS NO PRIMARY KEY SELECTED

                  boolean extra = MComp.areThisItemsMatchTheSelectedItem(DTSQL.extraTypes, cbsTypes[a]);
                  if (extra) {
                        rbsExtra[a].setEnabled(true);
                        rbsExtra[a].setBackground(Color.BLACK);
                        /*
                        cbsExtra[a].setEnabled(true);
                        tfsIDEN1[a].setEnabled(true);
                        tfsIDEN2[a].setEnabled(true);
                         */
                  } else {
                        rbsExtra[a].setEnabled(false);
                        rbsExtra[a].setBackground(new Color(255, 0, 0, 100));
                  }

                  boolean dist = MComp.areThisItemsMatchTheSelectedItem(DTSQL.distTypes, cbsTypes[a]);
                  if (dist) {
                        btns_Dist[a].setEnabled(true);
                  } else {
                        btns_Dist[a].setEnabled(false);
                  }

                  if (a != DT.maxColumns - 1) {
                        boolean dist2 = MComp.areThisItemsMatchTheSelectedItem(DTSQL.dist2Types, cbsTypes[a]);
                        int length = btns_Dist2[a].getName().length();
                        String text = btns_Dist2[a].getName();
                        int index1 = Character.getNumericValue(text.charAt(length - 3));
                        int index2 = Character.getNumericValue(text.charAt(length - 1));
                        if (dist2) {
                              if (a + 1 == index1 || a + 1 == index2) {
                                    btns_Dist2[a].setEnabled(true);
                                    if (a != DT.maxColumns - 2) {
                                          btns_Dist2[a + 1].setEnabled(true);
                                    }
                                    //btnDistAction.distdist2Control(true);
                              }
                        } else {
                              if (a + 1 == index1 || a + 1 == index2) {
                                    btns_Dist2[a].setEnabled(false);
                                    if (a != 0) {
                                          btns_Dist2[a - 1].setEnabled(false);
                                    }
                              }

                        }
                  }
                  boolean imageC = MComp.areThisItemsMatchTheSelectedItem(DTSQL.imageCTypes, cbsTypes[a]);
                  if (imageC) {
                        btns_ImageC[a].setEnabled(true);

                  } else {
                        btns_ImageC[a].setEnabled(false);
                  }
                  boolean tag = MComp.areThisItemsMatchTheSelectedItem(DTSQL.tagTypes, cbsTypes[a]);
                  if (tag) {
                        btns_Tag[a].setEnabled(true);
                  } else {
                        btns_Tag[a].setEnabled(false);
                  }
                  boolean clock = MComp.areThisItemsMatchTheSelectedItem(DTSQL.clockTypes, cbsTypes[a]);
                  if (clock) {
                        btns_Clock[a].setEnabled(true);
                  } else {
                        btns_Clock[a].setEnabled(false);
                  }
            }
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      public JComponent[][] getCompsD() {
            return compsD;
      }

      public JLabel[] getHeaders() {
            return headers;
      }

      //+++++++++++++++++++++++++++++++++++++
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

      public JButton[] getBTNSChange_TFS() {
            return btnsChange_Name;
      }

      public JPanel[] getPanelsTypes() {
            return panelsTypes;
      }

      public JComboBox[] getCBSTypes() {
            return cbsTypes;
      }

      public JTextField[] getTFSTypes() {
            return tfsTypes;
      }

      public JButton[] getBTNSChange_Types() {
            return btnsChange_Types;
      }

      public JCheckBox[] getCKSNulls() {
            return cksNulls;
      }

      public JButton[] getBTNSChange_Nulls() {
            return btnsChange_Nulls;
      }

      public JRadioButton[] getRBS_PK() {
            return rbsPK;
      }

      public JButton[] getBTNSChange_PK() {
            return btnsChange_PK;
      }

      public JPanel[] getPanelsFK() {
            return panelsFK;
      }

      public JRadioButton[] getRBS_FK() {
            return rbsFK;
      }

      public JComboBox[] getCBS_FK() {
            return cbsFK;
      }

      public JButton[] getBTNSChange_FK() {
            return btnsChange_FK;
      }

      public JPanel[] getPanelsDefaults() {
            return panelsDefaults;
      }

      public JRadioButton[] getRBSDefaults() {
            return rbsDefaults;
      }

      public int getRBDefaultsSelected() {
            return rbDefaultsSelected;
      }

      public void setRBDefaultsSelected(int index) {
            this.rbDefaultsSelected = index;
      }

      public JTextField[] getTFSDefaults() {
            return tfsDefaults;
      }

      public JButton[] getBTNSChange_Defaults() {
            return btnsChange_Defaults;
      }

      public JRadioButton[] getRBSExtra() {
            return rbsExtra;
      }

      public int getRB_ExtraSelected() {
            return rb_ExtraSelected;
      }

      public void setRB_ExtraSelected(int v) {
            rb_ExtraSelected = v;
      }

      public JButton[] getBTNSChange_Extra() {
            return btnsChange_Extra;
      }

      //++++++++++++++++++++++
      public JToggleButton[] getBTNS_Dist() {
            return btns_Dist;
      }

      public BTNDistAction getBTNDistAction() {
            return btnDistAction;
      }

      public JToggleButton[] getBTNS_Dist2() {
            return btns_Dist2;
      }

      public BTNDist2Action getBTN_Dist2Action() {
            return btnDist2Action;
      }

      public JButton getBTNChange_DistDist2() {
            return btnChange_DistDist2;
      }

      public JToggleButton[] getBTNS_ImageC() {
            return btns_ImageC;
      }

      public JButton getBTNChange_ImageC() {
            return btnChange_ImageC;
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

      public JButton getBTNChange_Tag() {
            return btnChange_Tag;
      }

      public JToggleButton[] getBTNS_Clock() {
            return btns_Clock;
      }

      public JButton getBTNChange_Clock() {
            return btnChange_Clock;
      }

      public int getBTN_ClockSelected() {
            return btn_ClockSelected;
      }

      public void setBTN_ClockSelected(int v) {
            btn_ClockSelected = v;
      }

      //+++++++++++++++++++++++++++++++++++++
      public JComboBox[] getCBS_Customs() {
            return cbs_Customs;
      }

      public JTextField[] getTFE_Customs() {
            return tfes_Customs;
      }

      public String[] getCustoms() {
            return customs;
      }

      //++++++++++++++++++++++++++++++++++++++
      public int getColumnDisplayed() {
            return columnDisplayed;
      }

      public void setColumnDisplayed(int columnDisplayed) {
            this.columnDisplayed = columnDisplayed;
      }

      public UpdateStore getUpdateStore() {
            return updateStore;
      }

      public void setUpdateStore(UpdateStore updateStore) {
            this.updateStore = updateStore;
      }
}
