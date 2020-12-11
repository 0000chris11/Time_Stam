/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create;

import MC.DT;
import MC.LK;
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

      JFrame JF = new JFrame("Create Table");

      JPanel JPU = new JPanel();
      //static JPanel JPC = new JPanelGradient(DT.GP_blackRed);
      static JPanel JPC = new JPanel();
      JScrollPane sc_JPC = new JScrollPane(JPC);
      static JPanel JPB = new JPanel();//STATUS
      //++++++++++++++++++++++++++++++++++++++
      static JPanel JPR = new JPanel();
      static JPanel JPR_U = new JPanelGradient(new Color[]{Color.BLACK, Color.BLUE});
      static JPanel JPR_B = new JPanel();
      static String[] lb_Disp_textC = new String[]{
            "Dist:", "NONE", "Dist2:", "NONE", "ImageC:", "NONE", "Tag:", "NONE", "Clock:", "NONE"};
      static JLabel[] lb_TDisp = new JLabel[10];
      static JLabel[] lb_ADisp = new JLabel[5];

      static JLabel lb_ClockLocation = new smallLB("Folder Location:");
      static Box bxClock = new Box(BoxLayout.LINE_AXIS);
      static JPanel boxImageC = new JPanel();
      JTextField tfClock = new smallTR_TF();
      JButton btn_ClockLocation = new JButton();
      //++++++++++++++++++++++++++++++++++++++

      static JLabel lb_Status = new JLabel("Waiting for action...");
      static JButton btn_CU = new JButton();
      //++++++++++++++++++++++++++++++++++++++++++++++
      static String[] headers_t = new String[]{
            "Cols Number", 
            "Field", "Sub", "Add", "Type", "Null", "Key", "Default", "Extra",
            "Dist1", "Dist2", "ImageC", "Tag", "Clock"};
      /*
      lb, tf, btn_m, btn_p, combTypes, checkbNulls, panelExtra, rbPK,
                  btn_Dist, btn_Dist2, btn_ImageC, btn_Tag, btn_Clock
      */
      static JLabel[] headers = new JLabel[headers_t.length];

      static JComponent[][] compsD;
      //++++++++++++++++++++++++++++++++++++++++++++++
      static JLabel lb_Title = new JLabel("Table Name");
      static JTextField tf_Title = new smallTF();

      static String lb_TitleOrigText = "Table Name";//MAY GETTER FROM CONSTRUCTOR
      static String[] lbOrigText = new String[DT.maxColumns];//MAY GETTER FROM CONSTRUCTOR
      //TO+COPY++++++++++++++++++++++++++++++++++++++
      static JLabel lb = new smallLB("Column 1");
      static JTextField tf = new smallTF();
      static JButton btn_p = new smallBTN_C("+");
      static JButton btn_m = new smallBTN_C("-");

      static String[] cb_options = new String[]{
            "INT", "FLOAT", "DOUBLE", "VARCHAR", "BOOLEAN/TINYINT(1)", "DATE"};
      static JComboBox combTypes = new smallCOMBX(cb_options);
      static JCheckBox checkbNulls = new smallCHBX();

      static JPanel panelDefault = new JPanel();
      static JRadioButton rbDefault = new JRadioButton();
      static JTextField tfDefault = new smallTF("NULL");
      
      static JPanel panelExtra = new JPanel();
      static JRadioButton rbExtra = new JRadioButton();//NO BUTTON GROUP
      static String[] cbExtra_options = new String[]{"AUTO INCREMENT", "IDENTITY"};
      static JComboBox combExtra = new smallCOMBX(cbExtra_options);
      static JTextField tfIDEN1 = new NumberOTF();
      static JTextField tfIDEN2 = new NumberOTF();
      static JRadioButton rbPK = new JRadioButton();
      
      static JToggleButton btn_Dist = new smallBTN_TG(LK.GP_CYAN_AND_WHITE);
      static JToggleButton btn_Dist2 = new smallBTN_TG(null);
      static JToggleButton btn_ImageC = new smallBTN_TG(LK.GP_GREEN_AND_WHITE);
      static JToggleButton btn_Tag = new smallBTN_TG(LK.GP_CYAN_AND_WHITE);
      static JToggleButton btn_Clock = new smallBTN_TG(LK.GP_YELLOW_AND_WHITE);
      //++++++++++++++++++++++++++++++++++++++++++++++
      static JLabel[] lbs = new JLabel[DT.maxColumns];
      static JTextField[] tfs = new JTextField[DT.maxColumns];
      static JButton[] btns_p = new smallBTN_C[DT.maxColumns];
      static JButton[] btns_m = new smallBTN_C[DT.maxColumns];
      static JComboBox[] combsTypes = new smallCOMBX[DT.maxColumns];
      static JCheckBox[] checkbsNull = new smallCHBX[DT.maxColumns];
      static JPanel[] panelsExtra = new JPanel[DT.maxColumns];
      
      static JRadioButton[] rbsExtra = new JRadioButton[DT.maxColumns];
      static int rb_ExtraSelected = 0;
      
      static JComboBox[] combsExtra = new smallCOMBX[DT.maxColumns];
      static JTextField[] tfsIDEN1 = new NumberOTF[DT.maxColumns];
      static JTextField[] tfsIDEN2 = new NumberOTF[DT.maxColumns];
      static JToggleButton[] btns_Dist = new smallBTN_TG[DT.maxColumns];
      static JToggleButton[] btns_Dist2 = new smallBTN_TG[DT.maxColumns];
      
      static JToggleButton[] btns_ImageC = new smallBTN_TG[DT.maxColumns];
      static int btn_ImageCSelected = 0;
      
      static ButtonGroup imageCGroup;
      static ButtonGroup clockGroup;
      static JToggleButton[] btns_Tag = new smallBTN_TG[DT.maxColumns];
      
      static JToggleButton[] btns_Clock = new smallBTN_TG[DT.maxColumns];
      static int btn_ClockSelected = 0;
      
      static JRadioButton[] rbsPK = new JRadioButton[DT.maxColumns];
      static int rb_PKSelected = 0;
      
      static JPanel[] panelsDefaults = new JPanel[DT.maxColumns];
      static JRadioButton[] rbDefaults = new JRadioButton[DT.maxColumns];
      static JTextField[] tfsDefaults = new JTextField[DT.maxColumns];
      /*
      static JPanel panelDefault = new JPanel();
      static JRadioButton rbDefault = new JRadioButton();
      static JTextField tfDefault = new smallTF("NULL");
      */
      //++++++++++++++++++++++++++++++++++++++++++
      static ArrayList<String> list_C = new ArrayList<String>();
      //++++++++++++++++++++++++++++++++++++++++++

      public static JPanel getPC() {
            return JPC;
      }
      
      public static JPanel getPR(){
            return JPR_U;
      }

      public static JComponent[][] getCompsD() {
            return compsD;
      }

      public static JLabel getLB_Title() {
            return lb_Title;
      }

      public static JTextField getTF_Title() {
            return tf_Title;
      }

      public static JLabel getLB_ClockLocation() {
            return lb_ClockLocation;
      }

      public static Box getBoxClock() {
            return bxClock;
      }
      
      public static JPanel getBoxImageC(){
            return boxImageC;
      }

      //++++++++++++++++++++++++++++++++++++++++++++
      public static String getLB_TitleOrigText() {
            return lb_TitleOrigText;
      }

      public static String[] getLBOrigTexts() {
            return lbOrigText;
      }

      //++++++++++++++++++++++++++++++++++++++++++++
      public static JLabel[] getHeaders(){
            return headers;
      }
      //++++++++++++++++++++++++++++++++++++++++++++
      public static JLabel[] getLBS() {
            return lbs;
      }

      public static JTextField[] getTFS() {
            return tfs;
      }

      public static JButton[] getBTNS_P() {
            return btns_p;
      }

      public static JButton[] getBTNS_M() {
            return btns_m;
      }

      public static JComboBox[] getCombTypes() {
            return combsTypes;
      }

      public static JCheckBox[] getCheckbNulls() {
            return checkbsNull;
      }

      public static JPanel[] getPanelTypes2() {
            return panelsExtra;
      }

      public static JRadioButton[] getRBTypes2() {
            return rbsExtra;
      }

      public static JComboBox[] getCombTypes2() {
            return combsExtra;
      }

      public static JTextField[] getTFSTypes1() {
            return tfsIDEN1;
      }

      public static JTextField[] getTFSTypes2() {
            return tfsIDEN2;
      }

      public static JToggleButton[] getBTNS_Dist() {
            return btns_Dist;
      }

      public static JToggleButton[] getBTNS_Dist2() {
            return btns_Dist2;
      }

      public static JToggleButton[] getBTNS_ImageC() {
            return btns_ImageC;
      }

      //++++++++++++++++++++++++++++++++++++++++++++++++++
      public static int getBTN_ImageCSelected() {
            return btn_ImageCSelected;
      }

      public static void setBTN_ImageCSelected(int v) {
            btn_ImageCSelected = v;
      }
      
      public static int getRB_ExtraSelected(){
            return rb_ExtraSelected;
      }
      
      public static void setRB_ExtraSelected(int v){
            rb_ExtraSelected = v;
      }
      
      public static int getRB_PKSelected(){
            return rb_PKSelected;
      }
      
      public static void setRB_PKSelected(int v){
            rb_PKSelected = v;
      }
      //+++++++++++++++++++++++++++++++++++++++++++++++++++
      public static JToggleButton[] getBTNS_Tag() {
            return btns_Tag;
      }

      public static JToggleButton[] getBTNS_Clock() {
            return btns_Clock;
      }

      public static ButtonGroup getClockGroup() {
            return clockGroup;
      }

      public static int getBTN_ClockSelected() {
            return btn_ClockSelected;
      }

      public static void setBTN_ClockSelected(int v) {
            btn_ClockSelected = v;
      }

      //++++++++++++++++++++++++++++++++++++++++++
      public static JLabel[] getLB_ADisp() {
            return lb_ADisp;
      }

      //++++++++++++++++++++++++++++++++++++++++++
      public static JLabel getLB_Status() {
            return lb_Status;
      }

      public static JButton getBTN_CU() {
            return btn_CU;
      }
      //+++++++++++++++++++++++++++++++++++++++++++
      public static ArrayList<String> getList_C(){
            return list_C;
      }
}
