/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestWindow;

import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Christopher
 */
public class VT extends JFrame{
      
      //private JFrame JF = new JFrame();
      private ArrayList<JButton> btns = new ArrayList<JButton>();
      private ArrayList<JComboBox> cboxs = new ArrayList<JComboBox>();
      
      public void addButton(JButton btn){
            add(btn);
            btns.add(btn);
            /*
            int sum = 0;
            for(int a = 0; a < btns.size(); a++){
                  sum += btns.get(a).getWidth();
            }
            JF.setSize(sum + 20, 100);
            */
            pack();
      }
      public void addComboBox(JComboBox cbox){
            add(cbox);
            cboxs.add(cbox);
            
            pack();
      }
      //+++++++++++++++++++++++++++++
      //private void 
      //+++++++++++++++++++++++++++++
      public ArrayList<JButton> getBTNS(){
            return btns;
      }
      public ArrayList<JComboBox> getCBOXS(){
            return cboxs;
      }
      
      public VT(){
            setDefaultCloseOperation(2);
            setTitle("Test Window");
            setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
            //++++++++++++++++++++++++++++++++++
      }
}
