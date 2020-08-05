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
      
      JLabel[] lbs = new JLabel[DT.maxColumns];
      
      JTextField[] tfs = new JTextField[DT.maxColumns];
      
      JButton[] btns_p = new JButton[DT.maxColumns];
      JButton[] btns_m = new JButton[DT.maxColumns];
      
      JSeparator SP1 = new JSeparator();
}
