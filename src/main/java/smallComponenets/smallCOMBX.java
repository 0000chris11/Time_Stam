/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallComponenets;

import MC.DT;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author C0FII
 */
public class smallCOMBX extends JComboBox {

      public smallCOMBX(String[] model) {
            for (int a = 0; a < model.length; a++) {
                  addItem(model[a]);
            }
            
            Font f = new Font("Dialog", Font.BOLD, 16);
            setBorder(new EmptyBorder(1, 3, 1, 3));
            setBackground(DT.TFColor[0]);
            setForeground(Color.WHITE);
            setFont(f);
      }
}
