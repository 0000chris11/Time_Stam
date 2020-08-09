/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Second;

import MC.DT;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import smallComponenets.PanelGradient;
import smallComponenets.smallLB;

/**
 *
 * @author Christopher
 */
public class VC_R_DataCom {
      
      JFrame JF = new JFrame("Create Table");
      
      JPanel JP = new PanelGradient();
      
      static JLabel[] lbs = new JLabel[DT.maxColumns];
      
      static JTextField[] tfs = new JTextField[DT.maxColumns];
      
      static JButton[] btns_p = new JButton[DT.maxColumns];
      static JButton[] btns_m = new JButton[DT.maxColumns];
      
      JSeparator SP_H1 = new JSeparator();
      JSeparator SP_V1 = new JSeparator();
      JSeparator[] SP_VS = new JSeparator[4];
      
      JLabel lb_Dist = new smallLB("Dist");
      JLabel lb_Dist2 = new smallLB("Dist2");
      JLabel lb_Tabl = new smallLB("Tabl");
      JLabel lb_Tag = new smallLB("Tag");
      JLabel lb_Clock = new smallLB("Clock");
      
      JToggleButton[] btns_Dist = new JToggleButton[DT.maxColumns - 1];
      JToggleButton[] btns_Dist2 = new JToggleButton[DT.maxColumns - 1];
      JToggleButton[] btns_Tabl = new JToggleButton[DT.maxColumns - 1];
      JToggleButton[] btns_Tag = new JToggleButton[DT.maxColumns - 1];
      JToggleButton[] btns_Clock = new JToggleButton[DT.maxColumns - 1];
      
      //++++++++++++++++++++++++++++++++++++++++++
      
      public static JLabel[] getJLBS(){
            return lbs;
      }
      
      public static JTextField[] getJTFS(){
            return tfs;
      }
      
      public static JButton[] getJBTNS_P(){
            return btns_p;
      }
      public static JButton[] getJBTNS_M(){
            return btns_m;
      }
      
}
