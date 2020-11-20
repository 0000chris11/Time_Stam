/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Create;

import MC.DT;
import java.awt.Color;
import java.awt.Graphics;
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
      JPanel JPB = new JPanel();
      //++++++++++++++++++++++++++++++++++++++
      JPanel JPR = new JPanelGradient(new Color[]{Color.BLACK, Color.BLUE});
      static String[] lb_Disp_textC = new String[]{
            "Dist:", "NONE", "Dist2:", "NONE", "Tabl:", "NONE", "Tag:", "NONE", "Clock:", "NONE"};
      static JLabel[] lb_TDisp = new JLabel[10];
      static JLabel[] lb_ADisp = new JLabel[5];

      static JLabel lb_ClockLocation = new smallLB("Folder Location:");
      static Box bxClock = new Box(BoxLayout.LINE_AXIS);
      static JPanel bxClock2 = new JPanel();
      JTextField tfClock = new smallTR_TF();
      JButton btn_ClockLocation = new JButton();
      //++++++++++++++++++++++++++++++++++++++

      static JLabel lb_Status = new JLabel("Waiting for action...");
      static JButton btn_CU = new JButton();
      //++++++++++++++++++++++++++++++++++++++++++++++
      String[] headers_t = new String[]{
            "Columns", "Name", "Sub", "Add", "Type", "Null", "Type 2",
            "Dist1", "Dist2", "Tabl", "Tag", "Clock"};
      JLabel[] headers = new JLabel[headers_t.length];

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
      static JComboBox comb = new smallCOMBX(cb_options);
      static JCheckBox checkb = new smallCHBX();

      static JPanel panelType2 = new JPanel();
      static JRadioButton rbType2 = new JRadioButton();
      static String[] cbType_options = new String[]{"AUTO INCREMENT", "IDENTITY"};
      static JComboBox combType2 = new smallCOMBX(cbType_options);
      static JTextField tfType1 = new NumberOTF();
      static JTextField tfType2 = new NumberOTF();

      static JToggleButton btn_Dist = new smallBTN_TG(DT.GP_celesteWhite);
      static JToggleButton btn_Dist2 = new smallBTN_TG(null);
      static JToggleButton btn_Tabl = new smallBTN_TG(DT.GP_greenWhite);
      static JToggleButton btn_Tag = new smallBTN_TG(DT.GP_celesteWhite);
      static JToggleButton btn_Clock = new smallBTN_TG(DT.GP_yellowWhite);
      //++++++++++++++++++++++++++++++++++++++++++++++
      static JLabel[] lbs = new JLabel[DT.maxColumns];
      static JTextField[] tfs = new JTextField[DT.maxColumns];
      static JButton[] btns_p = new smallBTN_C[DT.maxColumns];
      static JButton[] btns_m = new smallBTN_C[DT.maxColumns];
      static JComboBox[] combTypes1 = new smallCOMBX[DT.maxColumns];
      static JCheckBox[] checkbs = new smallCHBX[DT.maxColumns];
      static JPanel[] panelTypes2 = new JPanel[DT.maxColumns];
      static JRadioButton[] rbTypes2 = new JRadioButton[DT.maxColumns];
      static int rb_Types2Selected = -1;
      static JComboBox[] combTypes2 = new smallCOMBX[DT.maxColumns];
      static JTextField[] tfsTypes1 = new NumberOTF[DT.maxColumns];
      static JTextField[] tfsTypes2 = new NumberOTF[DT.maxColumns];
      static JToggleButton[] btns_Dist = new smallBTN_TG[DT.maxColumns];
      static JToggleButton[] btns_Dist2 = new smallBTN_TG[DT.maxColumns];
      static JToggleButton[] btns_Tabl = new smallBTN_TG[DT.maxColumns];
      static int btn_TablSelected = -1;
      static int btn_ClockSelected = -1;
      static ButtonGroup tablGroup;
      static ButtonGroup clockGroup;
      static JToggleButton[] btns_Tag = new smallBTN_TG[DT.maxColumns];
      static JToggleButton[] btns_Clock = new smallBTN_TG[DT.maxColumns];
      //++++++++++++++++++++++++++++++++++++++++++

      public static JPanel getPC() {
            return JPC;
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

      //++++++++++++++++++++++++++++++++++++++++++++
      public static String getLB_TitleOrigText() {
            return lb_TitleOrigText;
      }

      public static String[] getLBOrigTexts() {
            return lbOrigText;
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

      public static JComboBox[] getCombTypes1() {
            return combTypes1;
      }

      public static JCheckBox[] getCheckbs() {
            return checkbs;
      }

      public static JPanel[] getPanelTypes2() {
            return panelTypes2;
      }

      public static JRadioButton[] getRBTypes2() {
            return rbTypes2;
      }

      public static JComboBox[] getCombTypes2() {
            return combTypes2;
      }

      public static JTextField[] getTFSTypes1() {
            return tfsTypes1;
      }

      public static JTextField[] getTFSTypes2() {
            return tfsTypes2;
      }

      public static JToggleButton[] getBTNS_Dist() {
            return btns_Dist;
      }

      public static JToggleButton[] getBTNS_Dist2() {
            return btns_Dist2;
      }

      public static JToggleButton[] getBTNS_Tabl() {
            return btns_Tabl;
      }

      public static ButtonGroup getTablGroup() {
            return tablGroup;
      }

      public static int getBTN_TablSelected() {
            return btn_TablSelected;
      }

      public static void setBTN_TablSelected(int v) {
            btn_TablSelected = v;
      }
      
      public static int getRB_Types2Selected(){
            return rb_Types2Selected;
      }
      
      public static void setRB_Types2Selected(int v){
            rb_Types2Selected = v;
      }

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
}
