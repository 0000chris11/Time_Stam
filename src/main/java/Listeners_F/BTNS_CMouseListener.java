/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners_F;

import First.VF_R;
import MC.DT;
import MC.notMyMethods;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *MouseListener for BTNS_C
 * @author Christopher
 */
public class BTNS_CMouseListener implements MouseListener {

      notMyMethods n_mm = new notMyMethods();

      @Override
      public void mouseClicked(MouseEvent evt) {
            //System.out.println("mouseClicked");
      }

      @Override
      public void mousePressed(MouseEvent evt) {
            //System.out.println("mousePressed");
            JComponent jcC = (JComponent) evt.getSource();
            Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();

            if (evt.getButton() == 1) {
                  for (int a = 0; a < DT.maxColumns; a++) {
                        if (jcC.getName().equals("BTNC_" + (a + 1))) {
                              StringSelection ss = new StringSelection(VF_R.getJTFS()[a].getText());
                              cb.setContents(ss, ss);
                        }
                  }
            } else if (evt.getButton() == 3) {
                  for (int a = 0; a < DT.maxColumns; a++) {
                        if (jcC.getName().equals("BTNC_" + (a + 1))) {
                              VF_R.getJTFS()[a].setText("");
                        }
                        if (jcC.getName().equals("TF_" + (a + 1))) {
                              n_mm.onPaste(VF_R.getJTFS()[a]);
                              //mm.tf_ConfigDists_M(lb_2, tf_2, lst_2, dt.getDm_2(), dt.getListD_2());
                        }
                  }
            }
      }

      @Override
      public void mouseReleased(MouseEvent arg0) {
            //System.out.println("mouserReleased");
      }     

      @Override
      public void mouseEntered(MouseEvent evt) {
            //System.out.println("mouseEntered");
            //JButton btnC = (JButton) evt.getSource();
            //JTextField tfC = (JTextField) evt.getSource();
            
      }

      @Override
      public void mouseExited(MouseEvent arg0) {
            //System.out.println("mouseExited");
      }
}
