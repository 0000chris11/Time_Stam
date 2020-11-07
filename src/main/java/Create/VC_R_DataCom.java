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
      JPanel JPC = new JPanelGradient();
      JScrollPane sc_JPC = new JScrollPane(JPC);
      JPanel JPB = new JPanel();
      //++++++++++++++++++++++++++++++++++++++
      JPanel JPR = new JPanel();
      String[] lb_Disp_textC = new String[]{
            "Dist:", "NONE", "Dist2:" ,"NONE", "Tabl:", "NONE", "Tag:", "NONE", "Clock:", "NONE"};
      JLabel[] lb_Disp = new JLabel[10];
      //++++++++++++++++++++++++++++++++++++++

      static JLabel lb_Status = new JLabel("Waiting for action...");
      static JButton btn_CU = new JButton();
      //++++++++++++++++++++++++++++++++++++++++++++++
      String[] headers_t = new String[]{
            "Columns", "Name", "Sub", "Add", "Type", "Null",
            "Dist1", "Dist2", "Tabl", "Tag", "Clock"};
      JLabel[]  headers = new JLabel[headers_t.length];

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
      static JLabel[] lbs = new JLabel[DT.maxColumns];
      static JTextField[] tfs = new JTextField[DT.maxColumns];
      static JButton[] btns_p = new JButton[DT.maxColumns];
      static JButton[] btns_m = new JButton[DT.maxColumns];
      static JToggleButton[] btns_Disto = new JToggleButton[DT.maxColumns];
      static JToggleButton[] btns_Disto2 = new JToggleButton[DT.maxColumns];
      static JToggleButton[] btns_Tablo = new JToggleButton[DT.maxColumns];
      static JToggleButton[] btns_Tago = new JToggleButton[DT.maxColumns];
      static JToggleButton[] btns_Clocko = new JToggleButton[DT.maxColumns];
      //++++++++++++++++++++++++++++++++++++++++++

      public static JComponent[][] getCompsD() {
            return compsD;
      }
      
      public static JTextField getTable_Name(){
            return tf_Title;
      }
      
      public static String[] getJLBOrigTexts(){
            return lbOrigText;
      }
      
      public static JLabel[] getJLBS(){
            return lbs;
      }
      
      public static JTextField[] getJTFS(){
            return tfs;
      }

      public static JButton[] getJBTNS_P() {
            return btns_p;
      }

      public static JButton[] getJBTNS_M() {
            return btns_m;
      }
      
      //++++++++++++++++++++++++++++++++++++++++++
      public static JLabel getLB_Status() {
            return lb_Status;
      }

      public static JButton getBTN_CU() {
            return btn_CU;
      }
}
