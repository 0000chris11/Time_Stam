/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallComponenets;

import MC.DT;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/**
 *
 * @author C0FII
 */
public class NumberOTF extends JFormattedTextField {

      /*
      @Override
      public void paintComponent(Graphics g){
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
            super.paintComponent(g);
      }
      */
      
      public NumberOTF() {
            Font f = new Font("Dialog", Font.BOLD, 16);
            //setOpaque(false);
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