/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Create;

import MC.DT;
import com.cofii.myClasses.MLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
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
            for (int a = 0; a < DT.maxColumns; a++) {
                  lbs[a] = new smallLB("Column " + (a + 1));
                  lbs[a].setForeground(Color.WHITE);
                  lbs[a].setSize(100, 27);
                  
                  tfs[a] = new smallTF();
                  tfs[a].setBackground(Color.DARK_GRAY);
                  tfs[a].setForeground(Color.WHITE);
                  tfs[a].setSize(200, 27);
                  
                  btns_m[a] = new smallBTN_C("-");
                  btns_m[a].setSize(22, 27);
                  btns_p[a] = new smallBTN_C("+");
                  btns_p[a].setSize(22, 27);
            }
      }
      
      private void jp1(JComponent jc, int limit) {
            GroupLayout layout = new GroupLayout(jc);
            layout.setAutoCreateContainerGaps(true);
            layout.setAutoCreateGaps(true);
            jc.setLayout(layout);
            
            ParallelGroup ph1 = layout.createParallelGroup(GroupLayout.Alignment.LEADING, true);
            ParallelGroup ph2 = layout.createParallelGroup(GroupLayout.Alignment.LEADING, true);
            ParallelGroup ph3 = layout.createParallelGroup(GroupLayout.Alignment.LEADING, true);
            ParallelGroup ph4 = layout.createParallelGroup(GroupLayout.Alignment.LEADING, true);
            
            SequentialGroup sv1 = layout.createSequentialGroup();
            
            for (int a = 0; a < limit; a++) {
                  ph1.addComponent(lbs[a]);
                  ph2.addComponent(tfs[a]);
                  ph3.addComponent(btns_m[a]);
                  ph4.addComponent(btns_p[a]);
                  
                  sv1.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                          .addComponent(lbs[a])
                          .addComponent(tfs[a])
                          .addComponent(btns_m[a], 27, 27, 27)
                          .addComponent(btns_p[a], 27, 27, 27));
            }
            
            layout.setHorizontalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGroup(ph1)
                                    .addGroup(ph2)
                                    .addGroup(ph3)
                                    .addGroup(ph4)));
            
            layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(sv1));
            
      }
      
      public VC_R2() {
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.setLayout(new BorderLayout());
            
            JF.add(JPU, BorderLayout.NORTH);
            JPU.setLayout(new BoxLayout(JPU, BoxLayout.X_AXIS));
            JPU.setBorder(new LineBorder(Color.WHITE, 2));
            JPU.setBackground(Color.BLACK);
            JPU.setPreferredSize(new Dimension(500, 60));
            JPU.setMaximumSize(new Dimension(Short.MAX_VALUE, 60));
            
            JPU.add(lb_Title);
            lb_Title.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 4));
            lb_Title.setForeground(Color.WHITE);
            lb_Title.setFont(new Font("Dialog", Font.BOLD, 18));
            lb_Title.setPreferredSize(new Dimension(200, 27));
            lb_Title.setMaximumSize(new Dimension(200, 27));
            
            JPU.add(tf_Title);
            tf_Title.setPreferredSize(new Dimension(tf_Title.getPreferredSize().width, 27));
            tf_Title.setMaximumSize(new Dimension(Short.MAX_VALUE, 27));
            
            JF.add(JPB, BorderLayout.CENTER);
            JPB.setBorder(new LineBorder(Color.WHITE, 2));
            JPB.setLayout(new GridLayout(1, 3, 0, 0));
            componentsConfig();
            //+++++++++++++++++++++++++++++++++++++
            JPB.add(JP1);
            jp1(JP1, DT.maxColumns);
            
            JPB.add(JP2);
            GroupLayout gl = new GroupLayout(JP2);
            JP2.setLayout(gl);
            MLayout ml = new MLayout(gl, 2);
            
            JComponent[] comps = new JComponent[]{comb, checkb};
            ml.lineSequence(comps);
            
            JPB.add(JP3);
            
            JF.setVisible(true);
      }
      
      public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        VC_R2 vc = new VC_R2();
                        vc.JF.setSize(800, 500);
                  }
                  
            });
      }
}
