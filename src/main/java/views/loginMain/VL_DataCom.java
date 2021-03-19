/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.loginMain;

import com.cofii2.components.swing.CheckBoxBasic;
import com.cofii2.components.swing.ComboBoxE;
import com.cofii2.components.swing.LabelCustom;
import com.cofii2.components.swing.ListCustom;
import com.cofii2.components.swing.PanelGradient;
import com.cofii2.components.swing.PasswordFieldCustom;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

/**
 *
 * @author COFII
 */
public class VL_DataCom {

      VL_DataCom() {

      }

      static JFrame JF = new JFrame("Login");
      static JPanel JPC = new PanelGradient(new Color[]{Color.BLACK, Color.BLUE});
      static JPanel JPS = new JPanel();

      static JLabel lbUser = new LabelCustom("User");
      static JLabel lbPass = new LabelCustom("Password");
      static JLabel lbDB = new LabelCustom("DataBase");

      static JComboBox cbUser = new ComboBoxE();
      static ArrayList<String> userData = new ArrayList<String>();
      static JPasswordField tfPass = new PasswordFieldCustom();
      static JComboBox cbDB = new ComboBoxE();
      static ArrayList<String> dbData = new ArrayList<String>();

      static JList lstUser = new ListCustom();
      static JList lstDB = new ListCustom();

      static JScrollPane scUser = new JScrollPane(lstUser);
      static JScrollPane scDB = new JScrollPane(lstDB);

      static JButton btn_login = new JButton("Login");
      static JCheckBox ckb_Default = new CheckBoxBasic("Set Default Login");
      //+++++++++++++++++++++++++++++++++++++++++++++
      private static boolean defaultUser;
      
      public static boolean getDefaultUser(){
            return defaultUser;
      }
      
      public static void setDefaultUser(boolean v){
            defaultUser = v;
      }
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
      
      public static JCheckBox getCKB_Default(){
            return ckb_Default;
      }
}
