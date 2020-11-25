/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.Login;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import smallComponenets.smallCHBX;
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

      static JComboBox cbUser = new MComboBoxE();
      static ArrayList<String> userData = new ArrayList<String>();
      static JPasswordField tfPass = new smallPassF();
      static JComboBox cbDB = new MComboBoxE();
      static ArrayList<String> dbData = new ArrayList<String>();

      static JList lstUser = new smallLST();
      static JList lstDB = new smallLST();

      static JScrollPane scUser = new JScrollPane(lstUser);
      static JScrollPane scDB = new JScrollPane(lstDB);

      static JButton btn_login = new JButton("Login");
      static JCheckBox ckb_Default = new smallCHBX("Set Default Login");

      //+++++++++++++++++++++++++++++++++++++++++++++
      public static JFrame getJF(){
            return JF;
      }
      
      public static JPanel getP() {
            return JPC;
      }
      
      public static JLabel getLBUser(){
            return lbUser;
      }

      public static JComboBox getCBUser() {
            return cbUser;
      }
      
      public static ArrayList<String> getUserData(){
            return userData;
      }
      
      public static JLabel getLBPass(){
            return lbPass;
      }

      public static JPasswordField getTFPass() {
            return tfPass;
      }
      
      public static JLabel getLBDB(){
            return lbDB;
      }

      public static JComboBox getCBDB() {
            return cbDB;
      }
      
      public static ArrayList<String> getDBData(){
            return dbData;
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
