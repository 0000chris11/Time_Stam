/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallComponenets;

import MC.DT;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/**
 *
 * @author C0FII
 */
public class NumberOTF extends JFormattedTextField {

      public NumberOTF() {
            Font f = new Font("Dialog", Font.BOLD, 16);
            setBackground(DT.TFColor[0]);
            setForeground(Color.WHITE);
            
            setBorder(DT.compoundBorder_N);
            //+++++++++++++++++++++++++++++++++++++++
            setFont(f);
            setEnabled(true);
            setFocusable(true);
            setEditable(true);
            setCaretColor(Color.WHITE);
            //++++++++++++++++++++++++++++++++++++++
            //this.
      }
}
