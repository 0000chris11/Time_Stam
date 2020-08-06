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
import smallComponenets.PanelGradient;

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
      
      JSeparator SP1 = new JSeparator();
      
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
