/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Create;

import Create.Listeners.BTN_MP_AL;
import Create.Listeners.BTN_PM_VC;
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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
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
            for(int a = 0; a < btns.size(); a++){
                  if(btns.get(a).getText().equals("-")){
                        btns_m.add(btns.get(a));
                  }else if(btns.get(a).getText().equals("+")){
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
            
            for(JButton btn : btns_mo){
                  btn.addActionListener(btnAC);
            }
            for(JButton btn : btns_po){
                  btn.addActionListener(btnAC);
            }

      }

      private void startUpdate() {

      }

      public VC_R2(String choice) {
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.setLayout(new BorderLayout());

            JF.add(JPU, BorderLayout.NORTH);
            JPU.setLayout(new BoxLayout(JPU, BoxLayout.X_AXIS));
            JPU.setBorder(new LineBorder(Color.WHITE, 2));
            JPU.setBackground(Color.BLACK);
            JPU.setPreferredSize(new Dimension(500, 60));
            JPU.setMaximumSize(new Dimension(Short.MAX_VALUE, 60));

            JPU.add(lb_Title);
            lb_Title.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 0));
            lb_Title.setForeground(Color.WHITE);
            lb_Title.setFont(new Font("Dialog", Font.BOLD, 18));
            lb_Title.setPreferredSize(new Dimension(200, 27));
            lb_Title.setMaximumSize(new Dimension(200, 27));

            JPU.add(tf_Title);
            tf_Title.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 4));
            tf_Title.setPreferredSize(new Dimension(tf_Title.getPreferredSize().width, 27));
            tf_Title.setMaximumSize(new Dimension(Short.MAX_VALUE, 27));

            JF.add(JPB, BorderLayout.CENTER);
            JPB.setBorder(new LineBorder(Color.WHITE, 2));

            componentsConfig();
            //+++++++++++++++++++++++++++++++++++++
            GroupLayout gl = new GroupLayout(JPB);
            JPB.setLayout(gl);
            JComponent[] comps = new JComponent[]{
                  lb, tf, btn_m, btn_p, comb, checkb,
                  btn_Dist, btn_Dist2, btn_Tabl, btn_Tag, btn_Clock};
            compsD = MLayout.lineSequence(gl, headers, comps, DT.maxColumns, 27);
            //+++++++++++++++++++++++++++++++++++++
            if (choice.equals("CREATE")) {
                  startCreate();
            } else if (choice.equals("UPDATE")) {
                  startUpdate();
            }
            //+++++++++++++++++++++++++++++++++++++
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
