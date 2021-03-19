/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.first.listeners;

import MC.DT;
import MC.notMyMethods;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import views.first.VF_R;

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
            //System.out.println("CCCCmousePressed: " + evt.getComponent().getName());
            JComponent jcC = (JComponent) evt.getSource();
            Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();

            if (evt.getButton() == 1) {
                  //System.out.println(jcC.getName());
                  for (int a = 0; a < DT.maxColumns; a++) {
                        if (jcC.getName().equals("BTNC_" + (a + 1))) {
                              StringSelection ss = new StringSelection(getCorrectText(a));
                              cb.setContents(ss, ss);
                        }
                  }
            } else if (evt.getButton() == 3) {
                  for (int a = 0; a < DT.maxColumns; a++) {
                        if (jcC.getName().equals("BTNC_" + (a + 1))) {
                              deleteText(a);
                        }
                        if (jcC.getName().equals("TF_" + (a + 1))) {
                              n_mm.onPaste(VF_R.getJTFS()[a]);
                        }else if(jcC.getName().equals("TFE_" + (a + 1))){
                              n_mm.onPaste(VF_R.getJTFES()[a]);
                        }else if(jcC.getName().equals("TFC_" + (a + 1))){
                              n_mm.onPaste(VF_R.getJTF_CKS()[a]);
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
      
      //+++++++++++++++++++++++++++++++++++++++++++++++
      
      private String getCorrectText(int a){
            String returnValue = null;
            if(VF_R.tfPanelSelected[a].equalsIgnoreCase(VF_R.tfPanelTypes[0])){
                  returnValue = VF_R.getJTFS()[a].getText();
            }else if(VF_R.tfPanelSelected[a].equalsIgnoreCase(VF_R.tfPanelTypes[1])){
                  returnValue = VF_R.getJTFES()[a].getText();
            }else if(VF_R.tfPanelSelected[a].equalsIgnoreCase(VF_R.tfPanelTypes[2])){
                  returnValue = VF_R.getJTF_CKS()[a].getText();
            }
            
            return returnValue;
      }
      
      private void deleteText(int a){
            if(VF_R.tfPanelSelected[a].equalsIgnoreCase(VF_R.tfPanelTypes[0])){
                  VF_R.getJTFS()[a].setText("");
            }else if(VF_R.tfPanelSelected[a].equalsIgnoreCase(VF_R.tfPanelTypes[1])){
                  VF_R.getJTFES()[a].setText("");
            }else if(VF_R.tfPanelSelected[a].equalsIgnoreCase(VF_R.tfPanelTypes[2])){
                  VF_R.getJTF_CKS()[a].setText("");
            }

      }
}
