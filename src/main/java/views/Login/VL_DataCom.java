/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.Login;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import smallComponenets.smallLST;

/**
 *
 * @author COFII
 */
public class VL_DataCom {
      
      VL_DataCom(){
            
      }
      
      static JFrame JF = new JFrame();
      static JPanel JP = new JPanel();
      
      static JLabel lbUser = new JLabel("User");
      static JLabel lbPass = new JLabel("Password");
      
      static JTextField tfUser = new JTextField();
      static JTextField tfPass = new JTextField();
      
      static JList lstUser = new smallLST();
      static JList lstPass = new smallLST();
      
      static JScrollPane scUser = new JScrollPane(lstUser);
      static JScrollPane scPass = new JScrollPane(lstPass);
}
