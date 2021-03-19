/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.createUpdate;

import MC.DT;
import MC.MainInstances;
import com.cofii2.components.swing.LabelCustom;
import com.cofii2.components.swing.PanelGradient;
import com.cofii2.components.swing.TextFieldCustom;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import views.loginMain.VL_Glass;

/**
 *
 * @author Christopher
 */
public class VC_R_DataCom {

      JFrame JF = new JFrame("Create Table");
      VL_Glass vlGlass = new VL_Glass();

      JPanel JPU = new JPanel();
      //JPanel JPC = new JPstaianelGradient(DT.GP_blackRed);

      JSplitPane JSP = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
      /**
       *Components Panel (LEFT SPLIT PANE)
       */
      JPanel JPC = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                  super.paintComponent(g);
                  /*
                  VC_R_Comps c = MainInstances.getVC_R_Comps();
                  if(c != null){
                        if(c.cbs_Customs[0].isDisplayable()){
                              JComboBox cb = c.cbs_Customs[0];
                              Graphics2D g2 = (Graphics2D) g;
                              
                              g2.setColor(Color.WHITE);
                              g2.drawLine(cb.getX() - 8, 10, cb.getX() - 8, this.getHeight() - 20);
                              
                        }
                  }
                   */
            }
      };
      /**
       * Components Panel's JScrollPane (LEFT SPLIT PANE)
       */
      JScrollPane sc_JPC = new JScrollPane(JPC);
      /**
       * Dist Main Panel (RIGHT SPLIT PANE)
       */
      JPanel JPCD = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                  super.paintComponent(g);
                  /*
                  VC_R_Comps c = MainInstances.getVC_R_Comps();
                  if (c != null) {
                        int y = c.getBTNS_Dist()[0].getY() + 13;
                        Graphics2D g2 = (Graphics2D) g;
                        g2.setColor(Color.WHITE);
                        g2.drawLine(8, y, getWidth() - 8, y);
                  }
                   */
            }
      };
      /**
       * Dist Main Panel's JScrollPane (RIGHT SPLIT PANE)
       */
      JScrollPane sc_JPCD = new JScrollPane(JPCD);
      /**
       * First Sub-panel of JPCD; parent of btns_dist
       */
      JPanel JPCD_U = new JPanel();
      /**
       * Second Sub-panel of JPCD; parent of btns_changeDist
       */
      JPanel JPCD_D = new JPanel();
      JPanel JPCD_UDist = new JPanel();
      JPanel JPCD_UDist2 = new JPanel();
      JPanel JPCD_UImageC = new JPanel();
      JPanel JPCD_UTag = new JPanel();
      JPanel JPCD_UClock = new JPanel();

      JPanel JPB = new JPanel();//STATUS
      //++++++++++++++++++++++++++++++++++++++
      JPanel JPR = new JPanel();
      JPanel JPR_U = new PanelGradient(new Color[]{Color.BLACK, Color.BLUE});
      JPanel JPR_B = new JPanel();

      JLabel lbTDist = new LabelCustom("Dist");
      JLabel lbTDist2 = new LabelCustom("Dist2");
      JLabel lbTImageC = new LabelCustom("ImageC");
      JLabel lbTTag = new LabelCustom("Tag");
      JLabel lbTClock = new LabelCustom("Clock");

      JLabel lbADist = new LabelCustom("NONE");
      JLabel lbADist2 = new LabelCustom("NONE");
      JLabel lbAImageC = new LabelCustom("NONE");
      JLabel lbATag = new LabelCustom("NONE");
      JLabel lbAClock = new LabelCustom("NONE");

      JLabel[] lbsCustoms = new JLabel[]{null, lbADist, lbADist2, lbAClock};

      JLabel lbImageC = new LabelCustom("Folder Location:");
      Box bxImageC = new Box(BoxLayout.LINE_AXIS);
      JPanel JPImageC = new JPanel();
      JTextField tfImageC = new TextFieldCustom();
      //Icon imageIcon = new ImageIcon("C:\\C0F\\Image\\Z Icons\\Not Mine\\folder-blue-512.png");
      JButton btn_ImageCLocation = new JButton();
      JFileChooser FC = new JFileChooser();
      //++++++++++++++++++++++++++++++++++++++

      JLabel lb_Status = new JLabel("Waiting for action...");
      JButton btn_CU = new JButton();
      //++++++++++++++++++++++++++++++++++++++++++++++
      JLabel lb_Title = new JLabel("Table Name", JLabel.CENTER);
      JTextField tf_Title = new TextFieldCustom();
      JButton btnChange_Table = new JButton("R");
      String update;

      String lb_TitleOrigText = "Table Name";//MAY GETTER FROM CONSTRUCTOR
      String[] lbOrigText = new String[DT.maxColumns];//MAY GETTER FROM CONSTRUCTOR

      //++++++++++++++++++++++++++++++++++++++++++
      ArrayList<String> list_C = new ArrayList<String>();
      //++++++++++++++++++++++++++++++++++++++++++

      public VL_Glass getGlass() {
            return vlGlass;
      }

      public JPanel getPU() {
            return JPU;
      }

      public JPanel getPC() {
            return JPC;
      }

      public JPanel getPR() {
            return JPR_U;
      }
      
      public JPanel getPCD_U(){
            return JPCD_U;
      }
      
      public void setPCDistHeigth(int rows){
            int height = 24 + 7 + (33 * rows) + 24;
             System.out.println("\tHEIGHT: " + height + " (rows: " + rows + ")");
            Dimension dimensionMainPanel = new Dimension(300, height + 51);
            Dimension dimensionPanel = new Dimension(300, height);
            Dimension dimension = new Dimension(60, height);
            
            JPCD.setMinimumSize(new Dimension(dimensionMainPanel));
            JPCD.setMaximumSize(new Dimension(dimensionMainPanel));
            JPCD.setPreferredSize(new Dimension(dimensionMainPanel));
            
            JPCD_U.setMinimumSize(dimensionPanel);
            JPCD_U.setMaximumSize(dimensionPanel);
            JPCD_U.setPreferredSize(dimensionPanel);
            
            JPCD_UDist.setMinimumSize(dimension);
            JPCD_UDist.setMaximumSize(dimension);
            JPCD_UDist.setPreferredSize(dimension);
            
            JPCD_UDist2.setMinimumSize(dimension);
            JPCD_UDist2.setMaximumSize(dimension);
            JPCD_UDist2.setPreferredSize(dimension);
            
            JPCD_UImageC.setMinimumSize(dimension);
            JPCD_UImageC.setMaximumSize(dimension);
            JPCD_UImageC.setPreferredSize(dimension);
            
            JPCD_UTag.setMinimumSize(dimension);
            JPCD_UTag.setMaximumSize(dimension);
            JPCD_UTag.setPreferredSize(dimension);
            
            JPCD_UClock.setMinimumSize(dimension);
            JPCD_UClock.setMaximumSize(dimension);
            JPCD_UClock.setPreferredSize(dimension);
      }

      public JScrollPane getsc_JPC() {
            return sc_JPC;
      }

      public JScrollPane getSC_JPCD() {
            return sc_JPCD;
      }

      public JPanel getPCD_UDist() {
            return JPCD_UDist;
      }

      public JPanel getPCD_UDist2() {
            return JPCD_UDist2;
      }

      public JPanel getPCD_UImageC() {
            return JPCD_UImageC;
      }
      
      public JPanel getPCD_UTag() {
            return JPCD_UTag;
      }
      
      public JPanel getPCD_UClock() {
            return JPCD_UClock;
      }

      public JLabel getLB_Title() {
            return lb_Title;
      }

      public JTextField getTF_Title() {
            return tf_Title;
      }
      
      public JButton getBTNChange_Table(){
            return btnChange_Table;
      }

      public JLabel getLBImageC() {
            return lbImageC;
      }

      public JTextField getTFImageC() {
            return tfImageC;
      }

      public JPanel getPImageC() {
            return JPImageC;
      }

      //++++++++++++++++++++++++++++++++++++++++++++
      public String getLB_TitleOrigText() {
            return lb_TitleOrigText;
      }

      public String[] getLBOrigTexts() {
            return lbOrigText;
      }

      //++++++++++++++++++++++++++++++++++++++++++
      public JLabel getLB_Status() {
            return lb_Status;
      }

      public JButton getBTN_CU() {
            return btn_CU;
      }

      //+++++++++++++++++++++++++++++++++++++++++++
      public JLabel getLBTDist() {
            return lbTDist;
      }

      public JLabel getLBADist() {
            return lbADist;
      }

      public JLabel getLBTDist2() {
            return lbTDist2;
      }

      public JLabel getLBADist2() {
            return lbADist2;
      }

      public JLabel getLBTImageC() {
            return lbTImageC;
      }

      public JLabel getLBAImageC() {
            return lbAImageC;
      }

      public JLabel getLBTTag() {
            return lbTTag;
      }

      public JLabel getLBATag() {
            return lbATag;
      }

      public JLabel getLBTClock() {
            return lbTClock;
      }

      public JLabel getLBAClock() {
            return lbAClock;
      }

      public JLabel[] getLBSCustoms() {
            return lbsCustoms;
      }

      //+++++++++++++++++++++++++++++++++++++++++++
      public ArrayList<String> getList_C() {
            return list_C;
      }
}
