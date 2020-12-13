/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallComponenets;

import MC.DT;
import MC.LK_F;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;

/**
 *
 * @author C0FII
 */
public class MComboBoxE extends JComboBox{
      
      public MComboBoxE(){
            properties();
      }
      public MComboBoxE(String[] data){
            for(int a = 0; a < data.length; a++){
                  addItem(data[a]);
            }
            properties();
      }
      
      private void properties(){
            setEditable(true);
            setFont(LK_F.FONT_NORMAL);
            JTextField tfe = (JTextField) getEditor().getEditorComponent();
            CompoundBorder CB = new CompoundBorder(
                    tfe.getBorder(), BorderFactory.createEmptyBorder(2, 4, 1, 4));
            
            tfe.setBackground(LK_F.BK_NORMAL);
            tfe.setFont(getFont());
            tfe.setForeground(Color.WHITE);
            tfe.setCaretColor(Color.WHITE);
            tfe.setCaretPosition(0);
            tfe.setBorder(CB);
            //+++++++++++++++++++++++++++++++++
            //comboBox.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
            putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
      }
}
