/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Create;

import MC.DT;
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
import smallComponenets.JPanelGradient;
import smallComponenets.smallLB;
import smallComponenets.smallTF;

/**
 *
 * @author Christopher
 */
public class VC_R_DataCom {

      JFrame JF = new JFrame("Create Table");

      JPanel JPU = new JPanel();
      JPanel JPB = new JPanel();
      JPanel JP1 = new JPanelGradient();
      JPanel JP2 = new JPanelGradient();
      JPanel JP3 = new JPanelGradient();

      static JLabel lb_Status = new JLabel("Waiting for action...");
      static JButton btn_Create = new JButton("CREATE");
      //++++++++++++++++++++++++++++++++++++++++++++++
      static JLabel lb_Title = new JLabel("INSERT TITLE");
      static JLabel[] lbs = new JLabel[DT.maxColumns];
      static JTextField tf_Title = new smallTF();
      static JTextField[] tfs = new JTextField[DT.maxColumns];
      static JButton[] btns_p = new JButton[DT.maxColumns];
      static JButton[] btns_m = new JButton[DT.maxColumns];
      //++++++++++++++++++++++++++++++++++++++++++++++
      static String[] cb_options = new String[]{
            "INT", "FLOAT", "DOUBLE", "VARCHAR", "BOOLEAN/TINYINT(1)", "DATE"};
      static JComboBox comb = new JComboBox(cb_options);
      static JCheckBox checkb = new JCheckBox();

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
            return btn_Create;
      }
}
