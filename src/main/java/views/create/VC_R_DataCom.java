/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create;

import MC.DT;
import MC.LK_F;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import smallComponenets.JPanelGradient;
import smallComponenets.NumberOTF;
import smallComponenets.smallBTN_C;
import smallComponenets.smallBTN_TG;
import smallComponenets.smallCHBX;
import smallComponenets.smallCOMBX;
import smallComponenets.smallLB;
import smallComponenets.smallTF;
import smallComponenets.smallTR_JP;
import smallComponenets.smallTR_TF;

/**
 *
 * @author Christopher
 */
public class VC_R_DataCom {

      VC_R2 vc;
      JFrame JF = new JFrame("Create Table");

      JPanel JPU = new JPanel();
      //JPanel JPC = new JPstaianelGradient(DT.GP_blackRed);
      JPanel JPC = new JPanel();
      JScrollPane sc_JPC = new JScrollPane(JPC);
      JPanel JPB = new JPanel();//STATUS
      //++++++++++++++++++++++++++++++++++++++
      JPanel JPR = new JPanel();
      JPanel JPR_U = new JPanelGradient(new Color[]{Color.BLACK, Color.BLUE});
      JPanel JPR_B = new JPanel();
      String[] lb_Disp_textC = new String[]{
            "Dist:", "NONE", "Dist2:", "NONE", "ImageC:", "NONE", "Tag:", "NONE", "Clock:", "NONE"};
      JLabel[] lb_TDisp = new JLabel[10];
      JLabel[] lb_ADisp = new JLabel[5];

      JLabel lb_ClockLocation = new smallLB("Folder Location:");
      Box bxClock = new Box(BoxLayout.LINE_AXIS);
      JPanel boxImageC = new JPanel();
      JTextField tfClock = new smallTR_TF();
      JButton btn_ClockLocation = new JButton();
      //++++++++++++++++++++++++++++++++++++++

      JLabel lb_Status = new JLabel("Waiting for action...");
      JButton btn_CU = new JButton();
      //++++++++++++++++++++++++++++++++++++++++++++++
      String[] headers_t = new String[]{
            "Cols Number", 
            "Field", "Sub", "Add", "Type", "Null", "Key", "Default", "Extra",
            "Dist1", "Dist2", "ImageC", "Tag", "Clock"};
      /*
      lb, tf, btn_m, btn_p, combTypes, checkbNulls, panelExtra, rbPK,
                  btn_Dist, btn_Dist2, btn_ImageC, btn_Tag, btn_Clock
      */
      JLabel[] headers = new JLabel[headers_t.length];

      JComponent[][] compsD;
      //++++++++++++++++++++++++++++++++++++++++++++++
      JLabel lb_Title = new JLabel("Table Name");
      JTextField tf_Title = new smallTF();

      String lb_TitleOrigText = "Table Name";//MAY GETTER FROM CONSTRUCTOR
      String[] lbOrigText = new String[DT.maxColumns];//MAY GETTER FROM CONSTRUCTOR
      //TO+COPY++++++++++++++++++++++++++++++++++++++
      JLabel lb = new smallLB("Column 1");
      JTextField tf = new smallTF();
      JButton btn_p = new smallBTN_C("+");
      JButton btn_m = new smallBTN_C("-");

      String[] cb_options = new String[]{
            "INT", "FLOAT", "DOUBLE", "VARCHAR", "BOOLEAN/TINYINT(1)", "DATE"};
      JComboBox combTypes = new smallCOMBX(cb_options);
      JCheckBox checkbNulls = new smallCHBX();

      JPanel panelDefault = new JPanel();
      JRadioButton rbDefault = new JRadioButton();
      JTextField tfDefault = new smallTF("NULL");
      
      JPanel panelExtra = new JPanel();
      JRadioButton rbExtra = new JRadioButton();//NO BUTTON GROUP
      String[] cbExtra_options = new String[]{"AUTO INCREMENT", "IDENTITY"};
      JComboBox combExtra = new smallCOMBX(cbExtra_options);
      JTextField tfIDEN1 = new NumberOTF();
      JTextField tfIDEN2 = new NumberOTF();
      JRadioButton rbPK = new JRadioButton();
      
      JToggleButton btn_Dist = new smallBTN_TG(LK_F.GP_CYAN_AND_WHITE);
      JToggleButton btn_Dist2 = new smallBTN_TG(null);
      JToggleButton btn_ImageC = new smallBTN_TG(LK_F.GP_GREEN_AND_WHITE);
      JToggleButton btn_Tag = new smallBTN_TG(LK_F.GP_CYAN_AND_WHITE);
      JToggleButton btn_Clock = new smallBTN_TG(LK_F.GP_YELLOW_AND_WHITE);
      //++++++++++++++++++++++++++++++++++++++++++++++
      JLabel[] lbs = new JLabel[DT.maxColumns];
      JTextField[] tfs = new JTextField[DT.maxColumns];
      JButton[] btns_p = new smallBTN_C[DT.maxColumns];
      JButton[] btns_m = new smallBTN_C[DT.maxColumns];
      JComboBox[] combsTypes = new smallCOMBX[DT.maxColumns];
      JCheckBox[] checkbsNull = new smallCHBX[DT.maxColumns];
      JPanel[] panelsExtra = new JPanel[DT.maxColumns];
      
      JRadioButton[] rbsExtra = new JRadioButton[DT.maxColumns];
      int rb_ExtraSelected = 0;
      
      JComboBox[] combsExtra = new smallCOMBX[DT.maxColumns];
      JTextField[] tfsIDEN1 = new NumberOTF[DT.maxColumns];
      JTextField[] tfsIDEN2 = new NumberOTF[DT.maxColumns];
      JToggleButton[] btns_Dist = new smallBTN_TG[DT.maxColumns];
      JToggleButton[] btns_Dist2 = new smallBTN_TG[DT.maxColumns];
      
      JToggleButton[] btns_ImageC = new smallBTN_TG[DT.maxColumns];
      int btn_ImageCSelected = 0;
      
      ButtonGroup imageCGroup;
      ButtonGroup clockGroup;
      JToggleButton[] btns_Tag = new smallBTN_TG[DT.maxColumns];
      
      JToggleButton[] btns_Clock = new smallBTN_TG[DT.maxColumns];
      int btn_ClockSelected = 0;
      
      JRadioButton[] rbsPK = new JRadioButton[DT.maxColumns];
      int rb_PKSelected = 0;
      
      JPanel[] panelsDefaults = new JPanel[DT.maxColumns];
      JRadioButton[] rbsDefaults = new JRadioButton[DT.maxColumns];
      JTextField[] tfsDefaults = new JTextField[DT.maxColumns];
      /*
      JPanel panelDefault = new JPanel();
      JRadioButton rbDefault = new JRadioButton();
      JTextField tfDefault = new smallTF("NULL");
      */
      //++++++++++++++++++++++++++++++++++++++++++
      ArrayList<String> list_C = new ArrayList<String>();
      //++++++++++++++++++++++++++++++++++++++++++

      public JPanel getPC() {
            return JPC;
      }
      
      public JPanel getPR(){
            return JPR_U;
      }

      public JComponent[][] getCompsD() {
            return compsD;
      }

      public JLabel getLB_Title() {
            return lb_Title;
      }

      public JTextField getTF_Title() {
            return tf_Title;
      }

      public JLabel getLB_ClockLocation() {
            return lb_ClockLocation;
      }

      public Box getBoxClock() {
            return bxClock;
      }
      
      public JPanel getBoxImageC(){
            return boxImageC;
      }

      //++++++++++++++++++++++++++++++++++++++++++++
      public String getLB_TitleOrigText() {
            return lb_TitleOrigText;
      }

      public String[] getLBOrigTexts() {
            return lbOrigText;
      }

      //++++++++++++++++++++++++++++++++++++++++++++
      public JLabel[] getHeaders(){
            return headers;
      }
      //++++++++++++++++++++++++++++++++++++++++++++
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

      public JComboBox[] getCombTypes() {
            return combsTypes;
      }

      public JCheckBox[] getCheckbNulls() {
            return checkbsNull;
      }

      public JPanel[] getPanelTypes2() {
            return panelsExtra;
      }

      public JRadioButton[] getRBTypes2() {
            return rbsExtra;
      }

      public JComboBox[] getCombTypes2() {
            return combsExtra;
      }

      public JTextField[] getTFSTypes1() {
            return tfsIDEN1;
      }

      public JTextField[] getTFSTypes2() {
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

      //++++++++++++++++++++++++++++++++++++++++++++++++++
      public int getBTN_ImageCSelected() {
            return btn_ImageCSelected;
      }

      public void setBTN_ImageCSelected(int v) {
            btn_ImageCSelected = v;
      }
      
      public int getRB_ExtraSelected(){
            return rb_ExtraSelected;
      }
      
      public void setRB_ExtraSelected(int v){
            rb_ExtraSelected = v;
      }
      
      public int getRB_PKSelected(){
            return rb_PKSelected;
      }
      
      public void setRB_PKSelected(int v){
            rb_PKSelected = v;
      }
      //+++++++++++++++++++++++++++++++++++++++++++++++++++
      public JToggleButton[] getBTNS_Tag() {
            return btns_Tag;
      }

      public JToggleButton[] getBTNS_Clock() {
            return btns_Clock;
      }

      public ButtonGroup getClockGroup() {
            return clockGroup;
      }

      public int getBTN_ClockSelected() {
            return btn_ClockSelected;
      }

      public void setBTN_ClockSelected(int v) {
            btn_ClockSelected = v;
      }

      //++++++++++++++++++++++++++++++++++++++++++
      public JLabel[] getLB_ADisp() {
            return lb_ADisp;
      }

      //++++++++++++++++++++++++++++++++++++++++++
      public JLabel getLB_Status() {
            return lb_Status;
      }

      public JButton getBTN_CU() {
            return btn_CU;
      }
      //+++++++++++++++++++++++++++++++++++++++++++
      public ArrayList<String> getList_C(){
            return list_C;
      }
}
