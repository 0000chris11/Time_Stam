/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.create.listeners;

import com.cofii.myMethods.MComp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;

/**
 *
 * @author C0FII
 */
public class rbDefault_AL implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {
            JRadioButton rb = (JRadioButton) e.getSource();
            int index = MComp.getLastDigitCharsCountAtEnd(rb.getName()) - 1;
            if (rb.isSelected()) {
                  
            }
      }

}
