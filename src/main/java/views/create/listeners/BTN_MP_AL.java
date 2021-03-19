/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import MC.DT;
import MC.MainInstances;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import views.create.Actions.TFS_KControl;
import views.createUpdate.VC_R_Comps;

/**
 *
 * @author C0FII
 */
public class BTN_MP_AL implements ActionListener {
      
      private VC_R_Comps c = MainInstances.getVC_R_Comps();

      @Override
      public void actionPerformed(ActionEvent e) {
            for (int row = 0; row < DT.maxColumns - 1; row++) {
                  //SUB
                  if (e.getSource() == c.getBTNS_M()[row + 1]) {//FIRST ONE ALLWAYS DISABLED
                        for (int col = 0; col < c.getCompsD()[row].length; col++) {

                              JComponent JC = c.getCompsD()[row + 2][col];
                              JC.setVisible(false);
                              if (JC instanceof JTextField) {
                                    if (JC.getName().contains("TF_")) {
                                          ((JTextField) JC).setText("");
                                          JC.setForeground(Color.WHITE);
                                    }else{
                                          ((JTextField) JC).setText("NULL");
                                          JC.setForeground(Color.GRAY);
                                    }
                              } else if (JC instanceof JLabel) {
                                    ((JLabel) JC).setText("Column " + (row + 2));
                                    JC.setForeground(Color.WHITE);
                              }
                        }
                        c.getBTNS_M()[row].setVisible(true);
                        c.getBTNS_P()[row].setVisible(true);
                  }
                  //ADD
                  if (e.getSource() == c.getBTNS_P()[row]) {//LAST ONE ALLWAYS DISABLED
                        for (int col = 0; col < c.getCompsD()[row].length; col++) {
                              c.getCompsD()[row + 2][col].setVisible(true);
                        }
                        c.getBTNS_M()[row].setVisible(false);
                        c.getBTNS_P()[row].setVisible(false);

                  }
            }

            TFS_KControl.updateListC();
      }

}
