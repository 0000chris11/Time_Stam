/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import views.create.VC_R2;
import MC.DT;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import views.create.Actions.TFS_KControl;
import views.create.VC_R_DataCom;
import views.first.listeners.MITableOptions_AL;

/**
 *
 * @author C0FII
 */
public class BTN_MP_AL implements ActionListener {
      
      private VC_R_DataCom dt = MITableOptions_AL.getVCreateData();

      @Override
      public void actionPerformed(ActionEvent e) {
            for (int row = 0; row < DT.maxColumns - 1; row++) {
                  //SUB
                  if (e.getSource() == dt.getBTNS_M()[row + 1]) {//FIRST ONE ALLWAYS DISABLED
                        for (int col = 0; col < dt.getCompsD()[row].length; col++) {

                              JComponent JC = dt.getCompsD()[row + 2][col];
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
                        dt.getBTNS_M()[row].setVisible(true);
                        dt.getBTNS_P()[row].setVisible(true);
                  }
                  //ADD
                  if (e.getSource() == dt.getBTNS_P()[row]) {//LAST ONE ALLWAYS DISABLED
                        for (int col = 0; col < dt.getCompsD()[row].length; col++) {
                              dt.getCompsD()[row + 2][col].setVisible(true);
                        }
                        dt.getBTNS_M()[row].setVisible(false);
                        dt.getBTNS_P()[row].setVisible(false);

                  }
            }

            TFS_KControl.updateListC();
      }

}
