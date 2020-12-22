/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create;

import MC.DT;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import smallComponenets.JPanelGradient;
import smallComponenets.smallLB;
import smallComponenets.smallTF;
import smallComponenets.smallTR_TF;

/**
 *
 * @author Christopher
 */
public class VC_R_DataCom {

      VC_R2 vc;
      JFrame JF = new JFrame("Create Table");

      JPanel JPU = new JPanel();
      //JPanel JPC = new JPstaianelGradient(DT.GP_blackRed);
      JPanel JPC = new JPanel();
      JScrollPane sc_JPC = new JScrollPane(JPC);
      JPanel JPB = new JPanel();//STATUS
      //++++++++++++++++++++++++++++++++++++++
      JPanel JPR = new JPanel();
      JPanel JPR_U = new JPanelGradient(new Color[]{Color.BLACK, Color.BLUE});
      JPanel JPR_B = new JPanel();
      String[] lb_Disp_textC = new String[]{
            "Dist:", "NONE", "Dist2:", "NONE", "ImageC:", "NONE", "Tag:", "NONE", "Clock:", "NONE"};
      JLabel[] lb_TDisp = new JLabel[10];
      JLabel[] lb_ADisp = new JLabel[5];

      JLabel lb_ClockLocation = new smallLB("Folder Location:");
      Box bxClock = new Box(BoxLayout.LINE_AXIS);
      JPanel boxImageC = new JPanel();
      JTextField tfClock = new smallTR_TF();
      JButton btn_ClockLocation = new JButton();
      //++++++++++++++++++++++++++++++++++++++

      JLabel lb_Status = new JLabel("Waiting for action...");
      JButton btn_CU = new JButton();
      //++++++++++++++++++++++++++++++++++++++++++++++
      JLabel lb_Title = new JLabel("Table Name");
      JTextField tf_Title = new smallTF();

      String lb_TitleOrigText = "Table Name";//MAY GETTER FROM CONSTRUCTOR
      String[] lbOrigText = new String[DT.maxColumns];//MAY GETTER FROM CONSTRUCTOR
      
      //++++++++++++++++++++++++++++++++++++++++++
      ArrayList<String> list_C = new ArrayList<String>();
      //++++++++++++++++++++++++++++++++++++++++++

      public JPanel getPC() {
            return JPC;
      }
      
      public JPanel getPR(){
            return JPR_U;
      }
      
      public JLabel getLB_Title() {
            return lb_Title;
      }

      public JTextField getTF_Title() {
            return tf_Title;
      }

      public JLabel getLB_ClockLocation() {
            return lb_ClockLocation;
      }

      public Box getBoxClock() {
            return bxClock;
      }
      
      public JPanel getBoxImageC(){
            return boxImageC;
      }

      //++++++++++++++++++++++++++++++++++++++++++++
      public String getLB_TitleOrigText() {
            return lb_TitleOrigText;
      }

      public String[] getLBOrigTexts() {
            return lbOrigText;
      }

      //++++++++++++++++++++++++++++++++++++++++++++
      

      //++++++++++++++++++++++++++++++++++++++++++
      public JLabel[] getLB_ADisp() {
            return lb_ADisp;
      }

      //++++++++++++++++++++++++++++++++++++++++++
      public JLabel getLB_Status() {
            return lb_Status;
      }

      public JButton getBTN_CU() {
            return btn_CU;
      }
      //+++++++++++++++++++++++++++++++++++++++++++
      public ArrayList<String> getList_C(){
            return list_C;
      }
}
