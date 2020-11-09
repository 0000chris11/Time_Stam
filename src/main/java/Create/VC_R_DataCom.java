/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Create;

import MC.DT;
import java.awt.Color;
import java.awt.Graphics;
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
import smallComponenets.JPanelGradient;
import smallComponenets.smallBTN_C;
import smallComponenets.smallBTN_TG;
import smallComponenets.smallLB;
import smallComponenets.smallTF;

/**
 *
 * @author Christopher
 */
public class VC_R_DataCom {

      JFrame JF = new JFrame("Create Table");

      JPanel JPU = new JPanel();
      JPanel JPC = new JPanelGradient(DT.GP_blackRed);
      JScrollPane sc_JPC = new JScrollPane(JPC);
      JPanel JPB = new JPanel();
      //++++++++++++++++++++++++++++++++++++++
      JPanel JPR = new JPanelGradient(new Color[]{Color.BLACK, Color.BLUE});
      static String[] lb_Disp_textC = new String[]{
            "Dist:", "NONE", "Dist2:", "NONE", "Tabl:", "NONE", "Tag:", "NONE", "Clock:", "NONE"};
      static JLabel[] lb_TDisp = new JLabel[10];
      static JLabel[] lb_ADisp = new JLabel[5];
      //++++++++++++++++++++++++++++++++++++++

      static JLabel lb_Status = new JLabel("Waiting for action...");
      static JButton btn_CU = new JButton();
      //++++++++++++++++++++++++++++++++++++++++++++++
      String[] headers_t = new String[]{
            "Columns", "Name", "Sub", "Add", "Type", "Null",
            "Dist1", "Dist2", "Tabl", "Tag", "Clock"};
      JLabel[] headers = new JLabel[headers_t.length];

      static JComponent[][] compsD;
      //++++++++++++++++++++++++++++++++++++++++++++++
      static JLabel lb_Title = new JLabel("Table Name");
      static JTextField tf_Title = new smallTF();

      static String[] lbOrigText = new String[DT.maxColumns];
      static JLabel lb = new smallLB("Column 1");
      static JTextField tf = new smallTF();
      static JButton btn_p = new JButton("+");
      static JButton btn_m = new JButton("-");
      //++++++++++++++++++++++++++++++++++++++++++++++
      static String[] cb_options = new String[]{
            "INT", "FLOAT", "DOUBLE", "VARCHAR", "BOOLEAN/TINYINT(1)", "DATE"};
      static JComboBox comb = new JComboBox(cb_options);
      static JCheckBox checkb = new JCheckBox();

      //++++++++++++++++++++++++++++++++++++++++++++++
      public static class ColorB extends JToggleButton {

            Color C;

            public ColorB(Color c) {
                  C = c;
            }

            @Override
            public void paintComponent(Graphics g) {
                  super.paintComponent(g);
                  if (isEnabled()) {
                        if (isSelected()) {
                              setBackground(C);
                        } else {
                              setBackground(Color.DARK_GRAY);
                        }
                  }else{
                        setBackground(Color.BLACK);
                  }
                  
            }
      }
      static JToggleButton btn_Dist = new ColorB(Color.WHITE);
      static JToggleButton btn_Dist2 = new ColorB(Color.WHITE);
      static JToggleButton btn_Tabl = new ColorB(Color.CYAN);
      static JToggleButton btn_Tag = new ColorB(Color.WHITE);
      static JToggleButton btn_Clock = new ColorB(Color.GREEN);
      //++++++++++++++++++++++++++++++++++++++++++++++
      static JLabel[] lbs = new JLabel[DT.maxColumns];
      static JTextField[] tfs = new JTextField[DT.maxColumns];
      static JButton[] btns_p = new JButton[DT.maxColumns];
      static JButton[] btns_m = new JButton[DT.maxColumns];
      static JToggleButton[] btns_Dist = new JToggleButton[DT.maxColumns];
      static JToggleButton[] btns_Dist2 = new JToggleButton[DT.maxColumns];
      static JToggleButton[] btns_Tabl = new JToggleButton[DT.maxColumns];
      static int btn_TablSelected = -1;
      static int btn_ClockSelected = -1;
      static ButtonGroup tablGroup;
      static ButtonGroup clockGroup;
      static JToggleButton[] btns_Tag = new JToggleButton[DT.maxColumns];
      static JToggleButton[] btns_Clock = new JToggleButton[DT.maxColumns];
      //++++++++++++++++++++++++++++++++++++++++++

      public static JComponent[][] getCompsD() {
            return compsD;
      }

      public static JTextField getTable_Name() {
            return tf_Title;
      }

      public static String[] getLBOrigTexts() {
            return lbOrigText;
      }

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

      public static JToggleButton[] getBTNS_Dist() {
            return btns_Dist;
      }

      public static JToggleButton[] getBTNS_Dist2() {
            return btns_Dist2;
      }

      public static JToggleButton[] getBTNS_Tabl() {
            return btns_Tabl;
      }
      
      public static ButtonGroup getTablGroup(){
            return tablGroup;
      }
      
      public static int getBTN_TablSelected(){
            return btn_TablSelected;
      }
      
      public static void setBTN_TablSelected(int v){
            btn_TablSelected = v;
      }

      public static JToggleButton[] getBTNS_Tag() {
            return btns_Tag;
      }

      public static JToggleButton[] getBTNS_Clock() {
            return btns_Clock;
      }
      
      public static ButtonGroup getClockGroup(){
            return clockGroup;
      }
      
      public static int getBTN_ClockSelected(){
            return btn_ClockSelected;
      }
      
      public static void setBTN_ClockSelected(int v){
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
