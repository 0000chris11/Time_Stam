/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestWindow;

import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Christopher
 */
public class VT {
      
      private JFrame JF = new JFrame();
      private ArrayList<JButton> btns = new ArrayList<JButton>();
      
      public void add(JButton btn){
            JF.add(btn);
            btns.add(btn);
            
            int sum = 0;
            for(int a = 0; a < btns.size(); a++){
                  sum += btns.get(a).getWidth();
            }
            JF.setSize(sum + 20, 100);
            JF.pack();
      }
      public ArrayList<JButton> getBTNS(){
            return btns;
      }
      public void setVisible(boolean b){
            JF.setVisible(b);
      }
      
      public VT(){
            JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JF.setTitle("Test Window");
            JF.setLayout(new BoxLayout(JF.getContentPane(), BoxLayout.X_AXIS));
      }
}
