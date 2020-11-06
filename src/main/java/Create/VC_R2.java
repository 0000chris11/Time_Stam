/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Create;

import Create.Listeners.BTN_MP_AL;
import Create.Listeners.BTN_PM_VC;
import Create.Listeners.TF_KL_Control;
import static Create.VC_R_DataCom.lb_Status;
import First.VF_R;
import MC.DT;
import com.cofii.myClasses.MLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.metal.MetalToggleButtonUI;
import org.apache.commons.lang3.SerializationUtils;
import smallComponenets.smallBTN_C;
import smallComponenets.smallLB;
import smallComponenets.smallTF;

/**
 *
 * @author C0FII
 */
public class VC_R2 extends VC_R_DataCom {

      private void componentsConfig() {
            for (int a = 0; a < headers.length; a++) {
                  headers[a] = new smallLB(headers_t[a]);
            }

            comb.setBackground(DT.TFColor[0]);
            comb.setForeground(Color.WHITE);
            comb.setFont(tf.getFont());
            checkb.setToolTipText("Allow null");
            
            //btn_Dist.setBackground(Color.WHITE);
      }
      
      private Object[] getColumn(Object[][] object, int col){
            Object[] returnObject = new Object[object.length];
            for(int a = 0; a < object.length; a++){
                  returnObject[a] = object[a][col];
            }
            return returnObject;
      }

      private void startCreate() {
            ArrayList<JButton> btns = new ArrayList<JButton>();
            for (int a = 0; a < compsD.length; a++) {
                  for (int b = 0; b < compsD[a].length; b++) {
                        if (a > 1) {
                              compsD[a][b].setVisible(false);
                        }

                        if (compsD[a][b] instanceof JButton) {
                              btns.add((JButton) compsD[a][b]);
                        }
                  }
            }

            ArrayList<JButton> btns_m = new ArrayList<JButton>();
            ArrayList<JButton> btns_p = new ArrayList<JButton>();
            for (int a = 0; a < btns.size(); a++) {
                  if (btns.get(a).getText().equals("-")) {
                        btns_m.add(btns.get(a));
                  } else if (btns.get(a).getText().equals("+")) {
                        btns_p.add(btns.get(a));
                  }
            }

            /*
            Integer[] arr = new Integer[al.size()]; 
            arr = al.toArray(arr); 
             */
            BTN_MP_AL btnAC = new BTN_MP_AL();
            btns_mo = new JButton[btns_m.size()];
            btns_mo = btns_m.toArray(btns_mo);
            btns_mo[0].setEnabled(false);

            btns_po = new JButton[btns_p.size()];
            btns_po = btns_p.toArray(btns_po);
            btns_po[DT.maxColumns - 1].setEnabled(false);

            for (JButton btn : btns_mo) {
                  btn.addActionListener(btnAC);
            }
            for (JButton btn : btns_po) {
                  btn.addActionListener(btnAC);
            }
            
            Object[] ob_tfs = getColumn(compsD, 1);
            Object[] ob_dis = getColumn(compsD, 6);
            Object[] ob_dis2 = getColumn(compsD, 7);
            Object[] ob_tab = getColumn(compsD, 8);
            Object[] ob_tag = getColumn(compsD, 9);
            Object[] ob_ck = getColumn(compsD, 10);
            
            TF_KL_Control tfkl = new TF_KL_Control();
            
            ButtonGroup bg = new ButtonGroup();
            ButtonGroup bg2 = new ButtonGroup();
            for(int a = 0; a < DT.maxColumns; a++){
                  tfsn[a] = (JTextField) ob_tfs[a + 1];
                  btns_Disto[a] = (JToggleButton) ob_dis[a + 1];
                  btns_Disto2[a] = (JToggleButton) ob_dis2[a + 1];
                  btns_Tablo[a] = (JToggleButton) ob_tab[a + 1];
                  btns_Tago[a] = (JToggleButton) ob_tag[a + 1];
                  btns_Clocko[a] = (JToggleButton) ob_ck[a + 1];
                  
                  tfsn[a].addKeyListener(tfkl);
                  
                  bg.add(btns_Tablo[a]);
                  bg2.add(btns_Clocko[a]);
                  
            }
      }

      private void startUpdate() {

      }

      //+++++++++++++++++++++++++++++++++++++++++++++
      public void JPUConfig() {
            JF.add(JPU, BorderLayout.NORTH);
            JPU.setLayout(new BoxLayout(JPU, BoxLayout.X_AXIS));
            JPU.setBorder(new LineBorder(Color.WHITE, 2));
            JPU.setBackground(Color.BLACK);
            JPU.setPreferredSize(new Dimension(500, 46));
            JPU.setMaximumSize(new Dimension(Short.MAX_VALUE, 46));

            JPU.add(lb_Title);
            lb_Title.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 0));
            lb_Title.setForeground(Color.WHITE);
            lb_Title.setFont(new Font("Dialog", Font.BOLD, 18));
            lb_Title.setPreferredSize(new Dimension(200, 27));
            lb_Title.setMaximumSize(new Dimension(200, 27));

            JPU.add(tf_Title);
            tf_Title.setPreferredSize(new Dimension(tf_Title.getPreferredSize().width, 27));
            tf_Title.setMaximumSize(new Dimension(Short.MAX_VALUE, 27));
            JPU.add(Box.createHorizontalStrut(10));
      }

      private void JPCConfig() {
            JF.add(JPC, BorderLayout.CENTER);
            JPC.setBorder(new LineBorder(Color.WHITE, 2));

            componentsConfig();
            //+++++++++++++++++++++++++++++++++++++
            GroupLayout gl = new GroupLayout(JPC);
            JPC.setLayout(gl);
            JComponent[] comps = new JComponent[]{
                  lb, tf, btn_m, btn_p, comb, checkb,
                  btn_Dist, btn_Dist2, btn_Tabl, btn_Tag, btn_Clock};
            compsD = MLayout.lineSequence(gl, headers, comps, DT.maxColumns, 27);
      }

      public void JPBConfig(String text) {
            JF.add(JPB, BorderLayout.SOUTH);
            JPB.setBackground(Color.BLACK);
            JPB.setPreferredSize(new Dimension(500, 40));
            JPB.setMaximumSize(new Dimension(Short.MAX_VALUE, 42));
            JPB.setLayout(new BoxLayout(JPB, BoxLayout.X_AXIS));

            JPB.add(lb_Status);
            Border bb = BorderFactory.createBevelBorder(BevelBorder.RAISED);
            Border be = BorderFactory.createEmptyBorder(1, 3, 1, 3);
            lb_Status.setBorder(new CompoundBorder(bb, be));
            lb_Status.setForeground(Color.WHITE);
            lb_Status.setFont(new Font("Dialog", Font.BOLD, 16));
            lb_Status.setMaximumSize(new Dimension(Short.MAX_VALUE, 28));

            JPB.add(Box.createHorizontalStrut(6));
            JPB.add(btn_CU);
            btn_CU.setText(text);
            btn_CU.setMinimumSize(new Dimension(60, 28));
            JPB.add(Box.createHorizontalStrut(10));
      }

      public VC_R2(String choice) {
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.setLayout(new BorderLayout());

            JPUConfig();
            JPCConfig();

            //+++++++++++++++++++++++++++++++++++++
            if (choice.equals("CREATE")) {
                  startCreate();
            } else if (choice.equals("UPDATE")) {
                  startUpdate();
            }
            //+++++++++++++++++++++++++++++++++++++

            JPBConfig(choice);

            JF.setVisible(true);
      }

      public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        VC_R2 vc = new VC_R2("CREATE");
                        vc.JF.setSize(800, 500);
                  }

            });
      }
}
