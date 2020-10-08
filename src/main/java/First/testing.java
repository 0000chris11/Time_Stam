/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package First;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.LayoutStyle;

/**
 *
 * @author Christopher
 */
public class testing {
      private JComponent[] C1;
      private JComponent[] C2;
      private JComponent[] C3;
      private JComponent[] C4;
      private JComponent[] C5;
      
      public testing(JComponent[] c1, JComponent[] c2, JComponent[] c3, 
              JComponent[] c4, JComponent[] c5){
            C1 = c1;
            C2 = c2;
            C3 = c3;
            C4 = c4;
            C5 = c5;
      }
      
      //TO COFII
      private void useFiveAndOneSequence(GroupLayout gl, int limit) {
            gl.setAutoCreateGaps(true);
            gl.setAutoCreateContainerGaps(true);

            GroupLayout.ParallelGroup pgh1 = gl.createParallelGroup(GroupLayout.Alignment.LEADING, true);
            GroupLayout.ParallelGroup pgh2 = gl.createParallelGroup(GroupLayout.Alignment.LEADING, true);
            GroupLayout.ParallelGroup pgh3 = gl.createParallelGroup(GroupLayout.Alignment.LEADING, true);

            GroupLayout.SequentialGroup sgv1 = gl.createSequentialGroup();
            //SequentialGroup sgh1 = layout.createSequentialGroup();
            int LST_PREF = 200;
            int TF_PREF = 150;
            int CON_PREF = 50;

            for (int a = 0; a < limit; a++) {
                  pgh1.addComponent(C1[a]);
                  pgh1.addGap(0);
                  //++++++++++++++++++++++++++
                  pgh2.addGroup(gl.createSequentialGroup()
                          .addComponent(C2[a], TF_PREF, TF_PREF, Short.MAX_VALUE)
                          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                          .addComponent(C3[a], CON_PREF, CON_PREF, CON_PREF));
                  pgh2.addComponent(C4[a], LST_PREF, LST_PREF, Short.MAX_VALUE);
                  //++++++++++++++++++++++++++
                  pgh3.addComponent(C5[a]);
                  pgh3.addGap(0);
                  //=========================================
                  sgv1.addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                          .addComponent(C1[a])
                          .addComponent(C2[a])
                          .addComponent(C3[a])
                          .addComponent(C5[a]));
                  sgv1.addComponent(C4[a]);
            }
            //++++++++++++++++++++++++++++++++
            //++++++++++++++++++++++++++++++++
            gl.setHorizontalGroup(
                    gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(gl.createSequentialGroup()
                                    .addGroup(pgh1)
                                    .addGroup(pgh2)
                                    .addGroup(pgh3)));

            gl.setVerticalGroup(
                    gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(sgv1));
      }
}
