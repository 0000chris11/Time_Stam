/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallComponenets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 *
 * @author C0FII
 */
public class smallTR_TF extends JTextField{
      
      @Override
      public void paintComponent(Graphics g){
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
            super.paintComponent(g);
      }
      
      public smallTR_TF(){
            //setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 0));
            setOpaque(false);
            setBackground(new Color(51, 51, 51, 40));
            Font f = new Font("Dialog", Font.BOLD, 16);
            setFont(f);
            setForeground(Color.WHITE);
      }
}
