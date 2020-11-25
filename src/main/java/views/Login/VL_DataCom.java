/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.Login;

import java.awt.Color;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import smallComponenets.JPanelGradient;
import smallComponenets.MComboBoxE;
import smallComponenets.smallCOMBX;
import smallComponenets.smallLB;
import smallComponenets.smallLST;
import smallComponenets.smallPassF;
import smallComponenets.smallTF;

/**
 *
 * @author COFII
 */
public class VL_DataCom {

      VL_DataCom() {

      }

      static JFrame JF = new JFrame("Login");
      static JPanel JPC = new JPanelGradient(new Color[]{Color.BLACK, Color.BLUE});
      static JPanel JPS = new JPanel();

      static JLabel lbUser = new smallLB("User");
      static JLabel lbPass = new smallLB("Password");
      static JLabel lbDB = new smallLB("DataBase");

      static JComboBox cbUser = new MComboBoxE() /*{
            @Override
            public void setSelectedItem(Object item) {
                  super.setSelectedItem(item);
                  ComboBoxEditor editor = getEditor();
                  JTextField textField = (JTextField) editor.getEditorComponent();
                  textField.setCaretColor(Color.WHITE);
                  textField.setCaretPosition(0);
            }
      }*/;
      static JPasswordField tfPass = new smallPassF();
      static JComboBox cbDB = new MComboBoxE();

      static JList lstUser = new smallLST();
      static JList lstDB = new smallLST();

      static JScrollPane scUser = new JScrollPane(lstUser);
      static JScrollPane scDB = new JScrollPane(lstDB);

      static JButton btn_login = new JButton("Login");

      //+++++++++++++++++++++++++++++++++++++++++++++
      public static JPanel getP() {
            return JPC;
      }

      public static JComboBox getTFUser() {
            return cbUser;
      }

      public static JPasswordField getTFPass() {
            return tfPass;
      }

      public static JComboBox getTFDB() {
            return cbDB;
      }

      public static JScrollPane getSCUser() {
            return scUser;
      }

      public static JScrollPane getSCDB() {
            return scDB;
      }

      public static JList getLSTUser() {
            return lstUser;
      }

      public static JList getLSTDB() {
            return lstDB;
      }
}
