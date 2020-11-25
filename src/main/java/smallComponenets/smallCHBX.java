/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallComponenets;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JCheckBox;

/**
 *
 * @author C0FII
 */
public class smallCHBX extends JCheckBox {

      @Override
      public void paintComponent(Graphics g) {

            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
            super.paintComponent(g);
      }

      public smallCHBX() {
            setOpaque(false);
            setBackground(new Color(255, 0, 0, 20));
      }
      public smallCHBX(String text){
            setText(text);
            setOpaque(false);
            setBackground(new Color(255, 0, 0, 20));
      }
}
