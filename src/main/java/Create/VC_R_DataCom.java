/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Create;

import MC.DT;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
      JPanel JPC = new JPanelGradient();
      JPanel JPB = new JPanel();
      JPanel JP1 = new JPanelGradient();
      JPanel JP2 = new JPanelGradient();
      JPanel JP3 = new JPanelGradient();

      static JLabel lb_Status = new JLabel("Waiting for action...");
      static JButton btn_CU = new JButton();
      //++++++++++++++++++++++++++++++++++++++++++++++
      String[] headers_t = new String[]{
            "Columns", "Name", "Sub", "Add", "Type", "Null",
            "Dist1", "Dist2", "Tabl", "Tag", "Clock"};
      JLabel[] headers = new JLabel[11];
      JLabel[] headers2 = new JLabel[2];
      JLabel[] headers3 = new JLabel[5];

      static JComponent[][] compsD;
      //++++++++++++++++++++++++++++++++++++++++++++++
      static JLabel lb_Title = new JLabel("Table Name");
      static JTextField tf_Title = new smallTF();

      static JLabel lb = new smallLB("Column 1");
      static JTextField tf = new smallTF();
      static JButton btn_p = new JButton("+");
      static JButton btn_m = new JButton("-");

      static JLabel[] lbs = new JLabel[DT.maxColumns];
      static JTextField[] tfs = new JTextField[DT.maxColumns];
      static JButton[] btns_p = new JButton[DT.maxColumns];
      static JButton[] btns_m = new JButton[DT.maxColumns];
      //++++++++++++++++++++++++++++++++++++++++++++++
      static String[] cb_options = new String[]{
            "INT", "FLOAT", "DOUBLE", "VARCHAR", "BOOLEAN/TINYINT(1)", "DATE"};
      static JComboBox comb = new JComboBox(cb_options);
      static JCheckBox checkb = new JCheckBox();

      //++++++++++++++++++++++++++++++++++++++++++++++
      private static class ColorB extends JToggleButton {

            Color C;
            
            public ColorB(Color c){
                  C = c;
            }
            
            @Override
            public void paintComponent(Graphics g) {
                  System.out.println("paintComponent");
                  if(isSelected()){
                        System.out.println("\tSELECTED");
                        setBackground(C);
                  }else{
                        System.out.println("\tUNSELECTED");
                        setBackground(Color.DARK_GRAY);
                  }
                  super.paintComponent(g);
            }
      }
      static JToggleButton btn_Dist = new ColorB(Color.WHITE);
      static JToggleButton btn_Dist2 = new ColorB(Color.WHITE);
      static JToggleButton btn_Tabl = new ColorB(Color.CYAN);
      static JToggleButton btn_Tag = new ColorB(Color.WHITE);
      static JToggleButton btn_Clock = new ColorB(Color.GREEN);
      //++++++++++++++++++++++++++++++++++++++++++++++
      static JTextField[] tfsn = new JTextField[DT.maxColumns];
      static JButton[] btns_po;
      static JButton[] btns_mo;
      static JToggleButton[] btns_Disto = new JToggleButton[DT.maxColumns];
      static JToggleButton[] btns_Disto2 = new JToggleButton[DT.maxColumns];
      static JToggleButton[] btns_Tablo = new JToggleButton[DT.maxColumns];
      static JToggleButton[] btns_Tago = new JToggleButton[DT.maxColumns];
      static JToggleButton[] btns_Clocko = new JToggleButton[DT.maxColumns];
      //++++++++++++++++++++++++++++++++++++++++++++++
      JSeparator SP_H1 = new JSeparator();
      JSeparator SP_V1 = new JSeparator();
      JSeparator[] SP_VS = new JSeparator[4];

      JLabel lb_Dist = new smallLB("Dist");
      JLabel lb_Dist2 = new smallLB("Dist2");
      JLabel lb_Tabl = new smallLB("Tabl");
      JLabel lb_Tag = new smallLB("Tag");
      JLabel lb_Clock = new smallLB("Clock");

      static JToggleButton[] btns_Dist = new JToggleButton[DT.maxColumns - 1];
      static JToggleButton[] btns_Dist2 = new JToggleButton[DT.maxColumns - 1];
      static JToggleButton[] btns_Tabl = new JToggleButton[DT.maxColumns - 1];
      static JToggleButton[] btns_Tag = new JToggleButton[DT.maxColumns - 1];
      static JToggleButton[] btns_Clock = new JToggleButton[DT.maxColumns - 1];
      //++++++++++++++++++++++++++++++++++++++++++
      static JComponent[][] row = new JComponent[DT.maxColumns - 1][9];
      //++++++++++++++++++++++++++++++++++++++++++

      public static JComponent[][] getCompsD() {
            return compsD;
      }
      
      public static JTextField[] getJTFSN(){
            return tfsn;
      }

      public static JLabel[] getJLBS() {
            return lbs;
      }

      public static JTextField[] getJTFS() {
            return tfs;
      }

      public static JButton[] getJBTNS_P() {
            return btns_p;
      }

      public static JButton[] getJBTNS_M() {
            return btns_m;
      }

      public static JButton[] getJBTNS_PO() {
            return btns_po;
      }

      public static JButton[] getJBTNS_MO() {
            return btns_mo;
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

      public static JToggleButton[] getBTNS_Tag() {
            return btns_Tag;
      }

      public static JToggleButton[] getBTNS_Clock() {
            return btns_Clock;
      }

      public static JComponent[][] getRow() {
            return row;
      }

      //++++++++++++++++++++++++++++++++++++++++++
      public static JLabel getLB_Status() {
            return lb_Status;
      }

      public static JButton getBTN_Create() {
            return btn_CU;
      }
}
