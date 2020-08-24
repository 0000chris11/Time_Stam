/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Second;

import MC.MM;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author Christopher
 */
public class VO {
      
      private static JFrame JF = new JFrame("VO");
      public static JFrame getJF(){
            return JF;
      }
      
      JLabel lbq = new JLabel();
      JButton op1 = new JButton("No");
      JButton op2 = new JButton("Yes");
      
      public VO(String QT){
            //lbq.setText(QT);
            lbq.setText("Delete this table?");//EX
            //++++++++++++++++++++++++++++
            JF.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            JF.setLayout(null);
            JF.getContentPane().setBackground(Color.DARK_GRAY.darker());
            JF.setVisible(true);
            JF.setSize(284, 140);
            
            JF.add(lbq);
            Font f = new Font("Dialog", Font.PLAIN, 20);
            lbq.setForeground(Color.WHITE);
            lbq.setFont(f);
            lbq.setSize(lbq.getFontMetrics(f).stringWidth(lbq.getText()), 27);
            MM.setTextToXCenter(lbq, 18, JF);
            
            JF.add(op1);
            JF.add(op2);
            
            int by = 52;
            int bw = 100;
            int bh = 27;
            
            op1.setBounds(20, by, bw, bh);
            op2.setBounds(op1.getX() + op1.getWidth() + 20, by, bw, bh);
            
            int w = op1.getX() + op1.getWidth() + op2.getWidth() + 64;
            System.out.println("JF W: " + w);
      }
      
      public static void main(String[] args){
            new VO("");
      }
}

